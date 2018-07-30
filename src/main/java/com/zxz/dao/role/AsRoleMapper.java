package com.zxz.dao.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsRole;

/**
 * @author zhaoxuezhong
 *	AsRoleMapper
 */
public interface AsRoleMapper {
	
	List<AsRole> findAsRoleList(@Param("isStart")Integer isStart);

	int addAsRole(AsRole role);
	
	int updateAsRole(AsRole role);
	
	int deleteAsRole(Integer id);
	
}
