package com.zxz.service.user;

import com.zxz.pojo.AsUser;

/**
 * @author zhaoxuezhong
 *	AsUserService
 */
public interface AsUserService {

	AsUser login(AsUser user);

	boolean updateAsUser(AsUser user);
	
}
