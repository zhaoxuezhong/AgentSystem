package com.zxz.service.menu;

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
}
