package com.zxz.service.keyword;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.account.AsAccountMapper;
import com.zxz.dao.accountdetail.AsAccountdetailMapper;
import com.zxz.dao.keyword.AsKeywordsMapper;
import com.zxz.enu.FinanceType;
import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
import com.zxz.pojo.AsKeywords;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsKeywordsServiceImpl
 */
@Service
public class AsKeywordsServiceImpl implements AsKeywordsService {
	@Resource
	private AsKeywordsMapper asKeywordsMapper;
	@Resource
	private AsAccountMapper asAccountMapper;
	@Resource
	private AsAccountdetailMapper asAccountdetailMapper;
	
	@Override
	public Double addAsKeywords(AsKeywords keyword) {
		AsAccount account=asAccountMapper.findAsAccountByUserId(keyword.getAgentId());
		account.setMoney(account.getMoney()-keyword.getPreRegFrozenMoney());
		
		AsAccountdetail accountDetail=new AsAccountdetail();
		accountDetail.setUserId(account.getUserId());
		accountDetail.setAccountMoney(account.getMoney());
		accountDetail.setDetailDateTime(new Timestamp(System.currentTimeMillis()));
		accountDetail.setMoney(-keyword.getPreRegFrozenMoney());
		accountDetail.setDetailType(FinanceType.冻结.ordinal()+1);
		accountDetail.setDetailTypeName(FinanceType.冻结.toString());
		accountDetail.setMemo("申请的关键词【 "+keyword.getKeywords()+" 】");
		if(asAccountdetailMapper.addAsAccountdetail(accountDetail)>0
		&&asAccountMapper.updateAsAccount(account)>0){
			return asKeywordsMapper.addAsKeywords(keyword)>0?account.getMoney():0D;
		}
		return 0D;
	}

	@Override
	public boolean valikey(String keywords) {
		return asKeywordsMapper.getAsKeywordsCount(new AsKeywords(keywords))>0;
	}

	@Override
	public PageInfo<AsKeywords> findAsKeywordsList(AsKeywords keyword, Integer pageIndex, Integer pageSize) {
		PageInfo<AsKeywords> pageInfo=new PageInfo<AsKeywords>();
		Integer totalCount= asKeywordsMapper.getAsKeywordsCount(keyword);
		if (totalCount!=null&&totalCount!=0) {
			pageInfo.setTotalCount(totalCount);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageIndex(pageIndex);
			pageInfo.setList(asKeywordsMapper.findAsKeywordsList(keyword, 
					(pageInfo.getPageIndex()-1)*pageInfo.getPageSize(), pageInfo.getPageSize()));
		}
		return pageInfo;
	}

	@Override
	public boolean updateAsKeywords(AsKeywords keyword) {
		return asKeywordsMapper.updateAsKeywords(keyword)>0;
	}

	@Override
	public AsKeywords findAsKeywords(Integer id) {
		return asKeywordsMapper.findAsKeywords(id);
	}

}
