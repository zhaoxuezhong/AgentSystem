package com.zxz.dao.account;

import com.zxz.pojo.AsAccount;

/**
 * @author zhaoxuezhong
 *	AsAccountMapper
 */
public interface AsAccountMapper {
	
	AsAccount findAsAccountByUserId(Integer userId);
	
	int updateAsAccount(AsAccount account);
	
	int addAsAccount(AsAccount account);
}
