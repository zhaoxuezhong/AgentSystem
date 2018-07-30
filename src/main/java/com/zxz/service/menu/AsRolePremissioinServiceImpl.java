package com.zxz.service.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.function.AsRolePremissionMapper;
import com.zxz.pojo.AsFunction;

/**
 * @author zhaoxuezhong
 *	AsFunctionServiceImpl
 */
@Service
public class AsRolePremissioinServiceImpl implements AsRolePremissioinService {
	@Resource
	private AsRolePremissionMapper asRolePremissionMapper;

	@Override
	public List<Map<String, Object>> findMenu(Integer roleId) {
		List<Map<String, Object>> menuList=new ArrayList<Map<String,Object>>();
		List<AsFunction> mainFunction=asRolePremissionMapper.findRoleFunctionList(0,null);
		for (AsFunction asFunction : mainFunction) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<AsFunction> smenuFunction=asRolePremissionMapper.findRoleFunctionList(asFunction.getId(),roleId);
			if(smenuFunction!=null&&smenuFunction.size()>0){
				map.put("asFunction", asFunction);
				map.put("smenuFunction", smenuFunction);
				menuList.add(map);
			}
		}
		return menuList;
	}

	@Override
	public List<AsFunction> findAsFunctionList(Integer roleId) {
		return asRolePremissionMapper.findRoleFunctionList(null, roleId);
	}

}
