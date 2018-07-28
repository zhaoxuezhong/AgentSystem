package com.zxz.dao.user;

import com.zxz.pojo.AsUser;

/**
 * @author zhaoxuezhong
 *	AsUserMapper
 */
public interface AsUserMapper {
	
	AsUser findAsUser(AsUser user);

	int updateAsUser(AsUser user);
	
}
