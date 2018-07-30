package com.zxz.service.role;

import java.util.List;

import com.zxz.pojo.AsRole;

/**
 * @author zhaoxuezhong
 *	AsRoleService
 */
public interface AsRoleService {

	List<AsRole> findAsRoleList(Integer isStart);

	boolean addAsRole(AsRole role);
	
	boolean updateAsRole(AsRole role);
	
	boolean deleteAsRole(Integer id);
}
