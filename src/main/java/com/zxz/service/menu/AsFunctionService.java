package com.zxz.service.menu;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoxuezhong
 *	AsFunctionService
 */
public interface AsFunctionService {

	List<Map<String, Object>> findMenu(Integer roleId);
}
