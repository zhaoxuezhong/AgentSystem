package com.zxz.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zxz.pojo.AsFunction;
import com.zxz.pojo.AsRole;
import com.zxz.service.menu.AsRolePremissioinService;
import com.zxz.service.role.AsRoleService;

@Controller
@RequestMapping(value="agent/role")
public class AsRoleController extends BaseController{
	@Resource
	private AsRoleService asRoleServiceImpl;
	@Resource
	private AsRolePremissioinService asRolePremissioinServiceImpl;
	
	@RequestMapping(value="rolelist")
	public String list(Model model){
		List<AsRole> roleList=asRoleServiceImpl.findAsRoleList(null);
		model.addAttribute("roleList", roleList);
		return pages("rolelist");
	}
	
	@RequestMapping(value="editrole")
	@ResponseBody
	public String editrole(String role,String flag){
		AsRole asRole=JSONObject.parseObject(role, AsRole.class);
		boolean result=false;
		if("add".equals(flag)){
			asRole.setCreatedBy(this.getCurrentUser().getUserCode());
			asRole.setCreationTime(new Timestamp(System.currentTimeMillis()));
			result=asRoleServiceImpl.addAsRole(asRole);
		}
		else if("modify".equals(flag)){
			asRole.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
			result=asRoleServiceImpl.updateAsRole(asRole);
		}
		return result?"success":"false";
	}
	
	@RequestMapping(value="deleterole/{id}")
	@ResponseBody
	public String deleterole(@PathVariable("id")Integer id){
		return asRoleServiceImpl.deleteAsRole(id)?"success":"false";
	}
	
	@RequestMapping(value="permission")
	public String premission(Model model){
		List<AsRole> roleList=asRoleServiceImpl.findAsRoleList(null);
		model.addAttribute("roleList", roleList);
		return pages("permission");
	}
	
	@RequestMapping(value="funclist")
	public String funclist(Integer roleId,Model model){
		List<AsFunction> funclist= asRolePremissioinServiceImpl.findAsFunctionList(roleId);
		model.addAttribute("funclist", funclist);
		return "funclist";
	}
	
}
