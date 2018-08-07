package com.zxz.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsAccount;

/**
 * @author zhaoxuezhong
 *	AsAccountMapper
 */
public interface AsAccountMapper {
	
	List<AsAccount> findAsAccountByUserId(@Param("userId")Integer userId);
	
	int updateAsAccount(AsAccount account);
	
	int addAsAccount(AsAccount account);
	
}