package com.zxz.dao.function;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsFunction;
import com.zxz.pojo.AsRolePremission;

public interface AsRolePremissionMapper {

	List<AsFunction> findRoleFunctionList(@Param("parentId")Integer parentId,@Param("roleId")Integer roleId);

	List<AsFunction> findFunctionByRoleId(@Param("roleId")Integer roleId);
	
	int addRoleFunction(AsRolePremission arp);
	
	List<String> getRoleFunctionCount(@Param("roleId")Integer roleId);
	
	int deleteRoleFunction(@Param("roleId")Integer roleId,@Param("functionId")Integer functionId);
}
