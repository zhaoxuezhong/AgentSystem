package com.zxz.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zxz.pojo.AsRole;
import com.zxz.pojo.AsUser;
import com.zxz.service.role.AsRoleService;
import com.zxz.service.user.AsUserService;
import com.zxz.utils.Constants;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsUserController
 */
@Controller
@Scope("session")
@RequestMapping(value="agent/user")
public class AsUserController extends BaseController{
	@Resource
	private AsUserService asUserServiceImpl;
	@Resource
	private AsRoleService asRoleServiceImpl;
	
	@ResponseBody
	@RequestMapping(value="modifypwd")
	public String modifypwd(String userName,String userPassword,HttpSession session){
		AsUser loginUser=this.getCurrentUser();
		if(loginUser!=null&&loginUser.getUserPassword().equals(userName)){
			AsUser user=new AsUser();
			user.setId(this.getCurrentUser().getId());
			user.setUserPassword(userPassword);
			if(asUserServiceImpl.updateAsUser(user)){
				loginUser.setUserPassword(userPassword);
				session.setAttribute(Constants.SESSION_USER, loginUser);
				return "success";
			}
		}
		return "false";
	}
	
	@RequestMapping(value="searchuser")
	public String searchUser(String userCode,Model model){
		PageInfo<AsUser> userList=asUserServiceImpl.findAsUserList(new AsUser(userCode), null, null);
		model.addAttribute("userList", userList==null||userList.getList()==null||userList.getList().size()<0?"null":userList);
		return "searchuser";
	}
	
	@RequestMapping(value="userList")
	public String userList(AsUser asUser,Model model,
			@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize){
		PageInfo<AsUser> userList=asUserServiceImpl.findAsUserList(asUser, pageIndex, pageSize);
		model.addAttribute("userList", userList);
		List<AsRole> roleList=asRoleServiceImpl.findAsRoleList(1);
		model.addAttribute("roleList", roleList);
		return pages("userlist");
	}
	
	@RequestMapping(value="edituser")
	@ResponseBody
	public String edituser(String flag,String user){
		AsUser asUser=JSONObject.parseObject(user, AsUser.class);
		boolean result=false;
		if("add".equals(flag)){
			asUser.setCreatedBy(this.getCurrentUser().getUserCode());
			asUser.setCreationTime(new Timestamp(System.currentTimeMillis()));
			result=asUserServiceImpl.addAsUser(asUser);
		}
		else if("modify".equals(flag)){
			asUser.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
			result=asUserServiceImpl.updateAsUser(asUser);
		}
		return result?"success":"false";
	}
	
	@RequestMapping(value="deluser")
	@ResponseBody
	public String deluser(Integer id){
		return asUserServiceImpl.deleteAsUser(id)?"success":"false";
	}
	
}
