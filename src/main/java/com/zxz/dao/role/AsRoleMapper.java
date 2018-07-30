package com.zxz.dao.role;

import java.util.List;

import com.zxz.pojo.AsRole;

/**
 * @author zhaoxuezhong
 *	AsRoleMapper
 */
public interface AsRoleMapper {
	
	List<AsRole> findAsRoleList(Integer isStart);

	int addAsRole(AsRole role);
	
	int updateAsRole(AsRole role);
	
	int deleteAsRole(Integer id);
	
}
