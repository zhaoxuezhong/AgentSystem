package com.zxz.service.function;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.function.AsRolePremissionMapper;
import com.zxz.pojo.AsFunction;
import com.zxz.pojo.AsRolePremission;

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

	@Override
	public List<AsFunction> findFunctionByRoleId(Integer roleId) {
		return asRolePremissionMapper.findFunctionByRoleId(roleId);
	}

	@Override
	public boolean updateRoleFunction(List<String> functionIdList, Integer roleId) throws Exception {
		boolean flag = true;
		List<String> oldFunctionId=asRolePremissionMapper.getRoleFunctionCount(roleId);
		for (String newStr: functionIdList) {
			//相等则原来有，跳过
			if(oldFunctionId.contains(newStr)){
				oldFunctionId.remove(newStr);
				continue;
			}
			//不相等说明原来并没有，则新增
			AsRolePremission arp=new AsRolePremission();
			arp.setCreationTime(new Timestamp(System.currentTimeMillis()));
			arp.setFunctionId(Integer.parseInt(newStr));
			arp.setIsStart(1);
			arp.setRoleId(roleId);
			arp.setCreatedBy("admin");
			if(asRolePremissionMapper.addRoleFunction(arp)<1){
				flag=false;
				throw new Exception("角色权限新增异常");
			}
		}
		//在functionIdList中不存在的，则删除
		for (String str : oldFunctionId) {
			if(asRolePremissionMapper.deleteRoleFunction(roleId, Integer.parseInt(str))<1){
				flag=false;
				throw new Exception("角色权限删除异常");
			}
		}
		return flag;
	}
	
	

}
