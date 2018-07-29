package com.zxz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxz.pojo.AsUser;
import com.zxz.service.user.AsUserService;
import com.zxz.utils.Constants;

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
	
	
	
}
