package com.zxz.service.account;


import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
import com.zxz.utils.PageInfo;
/**
 * @author zhaoxuezhong
 *	AsAccountService
 */
public interface AsAccountService {
	
	AsAccount findAsAccountByUserId(Integer userId);
	
	PageInfo<AsAccountdetail> findAsAccountdetailList(Integer userId,Integer pageIndex,Integer pageSize);
	
	boolean updateAsAccount(AsAccount account);
}
