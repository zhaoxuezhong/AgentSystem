package com.zxz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zxz.pojo.AsUser;
import com.zxz.service.user.AsUserService;
import com.zxz.utils.Constants;

/**
 * @author zhaoxuezhong
 *	LoginController
 */
@Controller
public class LoginController extends BaseController{
	@Resource
	private AsUserService asUserServiceImpl;
	
	@RequestMapping(value="doLogin",method=RequestMethod.POST)
	public String doLogin(AsUser user,HttpSession session){
		AsUser loginUser=asUserServiceImpl.login(user);
		if(loginUser!=null){
			session.setAttribute(Constants.SESSION_USER, loginUser);
			return MAIN;
		}
		return LOGIN;
	}
	
	@RequestMapping(value="toLogin")
	public String toLogin(){
		return LOGIN;
	}
	
	
	
}
