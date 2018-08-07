package com.zxz.service.function;

import java.util.List;
import java.util.Map;

import com.zxz.pojo.AsFunction;

/**
 * @author zhaoxuezhong
 *	AsFunctionService
 */
public interface AsRolePremissioinService {

	List<Map<String, Object>> findMenu(Integer roleId);
	
	List<AsFunction> findAsFunctionList(Integer roleId);
	
	List<AsFunction> findFunctionByRoleId(Integer roleId);
	
	boolean updateRoleFunction(List<String> functionIdList,Integer roleId) throws Exception;
}
