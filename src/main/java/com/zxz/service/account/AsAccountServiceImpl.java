package com.zxz.service.account;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.account.AsAccountMapper;
import com.zxz.dao.accountdetail.AsAccountdetailMapper;
import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
import com.zxz.pojo.condition.AccountCondition;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsAccountServiceImpl
 */
@Service
public class AsAccountServiceImpl implements AsAccountService {
	@Resource
	private AsAccountMapper asAccountMapper;
	@Resource
	private AsAccountdetailMapper asAccountdetailMapper;
	
	@Override
	public AsAccount findAsAccountByUserId(Integer userId) {
		return asAccountMapper.findAsAccountByUserId(userId);
	}

	@Override
	public boolean updateAsAccount(AsAccount account) {
		AsAccountdetail accountDetail=account.getAccountDetail();
		accountDetail.setDetailDateTime(new Timestamp(System.currentTimeMillis()));
		accountDetail.setUserId(account.getUserId());
		accountDetail.setMoney(account.getMoney());
		AsAccount reAccount=asAccountMapper.findAsAccountByUserId(account.getUserId());
		//余额
		Double money=reAccount.getMoney()+account.getMoney();
		accountDetail.setAccountMoney(money);
		account.setMoney(money);
		account.setId(reAccount.getId());
		return asAccountdetailMapper.addAsAccountdetail(accountDetail)>0
				&&asAccountMapper.updateAsAccount(account)>0;
	}

	@Override
	public PageInfo<AsAccountdetail> findAsAccountdetailList(AccountCondition accountCondition,Integer pageIndex,Integer pageSize) {
		PageInfo<AsAccountdetail> pageInfo=new PageInfo<AsAccountdetail>();
		Integer totalCount=asAccountdetailMapper.getAsAccountdetailCount(accountCondition);
		if(totalCount!=null&&totalCount!=0){
			pageInfo.setTotalCount(totalCount);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageIndex(pageIndex);
			pageInfo.setList(asAccountdetailMapper.findAsAccountdetailList(accountCondition, 
					(pageInfo.getPageIndex()-1)*pageInfo.getPageSize(), pageInfo.getPageSize()));
		}
		return pageInfo;
	}

	@Override
	public boolean addAsAccount(AsAccount account) {
		return asAccountMapper.addAsAccount(account)>0;
	}

}
