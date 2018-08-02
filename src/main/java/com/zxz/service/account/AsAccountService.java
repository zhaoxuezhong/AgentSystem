package com.zxz.service.account;


import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
import com.zxz.pojo.condition.AccountCondition;
import com.zxz.utils.PageInfo;
/**
 * @author zhaoxuezhong
 *	AsAccountService
 */
public interface AsAccountService {
	
	AsAccount findAsAccountByUserId(Integer userId);
	
	PageInfo<AsAccountdetail> findAsAccountdetailList(AccountCondition accountCondition,Integer pageIndex,Integer pageSize);
	
	boolean updateAsAccount(AsAccount account);
	
	boolean addAsAccount(AsAccount account);
	
}
