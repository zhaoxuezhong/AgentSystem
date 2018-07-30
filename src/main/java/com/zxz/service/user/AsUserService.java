package com.zxz.service.user;

import com.zxz.pojo.AsUser;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsUserService
 */
public interface AsUserService {

	AsUser login(AsUser user);

	boolean updateAsUser(AsUser user);
	
	PageInfo<AsUser> findAsUserList(AsUser user,Integer pageIndex,Integer pageSize);
	
}
