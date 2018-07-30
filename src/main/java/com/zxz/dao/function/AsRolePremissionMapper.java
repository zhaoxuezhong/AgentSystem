package com.zxz.dao.function;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsFunction;

public interface AsRolePremissionMapper {

	List<AsFunction> findRoleFunctionList(@Param("parentId")Integer parentId,@Param("roleId")Integer roleId);
	
	
}
