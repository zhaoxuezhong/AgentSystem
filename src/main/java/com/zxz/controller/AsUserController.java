package com.zxz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zxz.pojo.AsUser;
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
	public String searchUser(String user,Model model,
			@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="5")Integer pageSize){
		AsUser asUser=JSONObject.parseObject(user, AsUser.class);
		PageInfo<AsUser> userList=asUserServiceImpl.findAsUserList(asUser, pageIndex, pageSize);
		model.addAttribute("userList", userList==null||userList.getList()==null||userList.getList().size()<0?"null":userList);
		return "searchuser";
	}
	
}
