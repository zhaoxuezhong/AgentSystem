package com.zxz.service.account;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.account.AsAccountMapper;
import com.zxz.dao.accountdetail.AsAccountdetailMapper;
import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
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
		return asAccountMapper.updateAsAccount(account)>0;
	}

	@Override
	public PageInfo<AsAccountdetail> findAsAccountdetailList(Integer userId,Integer pageIndex,Integer pageSize) {
		PageInfo<AsAccountdetail> pageInfo=new PageInfo<AsAccountdetail>();
		Integer totalCount=asAccountdetailMapper.getAsAccountdetailCount(userId);
		if(totalCount!=null&&totalCount!=0){
			pageInfo.setTotalCount(totalCount);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageIndex(pageIndex);
			pageInfo.setList(asAccountdetailMapper.findAsAccountdetailList(userId, 
					(pageInfo.getPageIndex()-1)*pageInfo.getPageSize(), pageInfo.getPageSize()));
		}
		return pageInfo;
	}

}
