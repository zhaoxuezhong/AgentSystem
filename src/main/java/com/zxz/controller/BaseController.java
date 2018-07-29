package com.zxz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zxz.pojo.AsUser;
import com.zxz.utils.Constants;


/**
 * BaseController
 * @author zhaoxuezhong
 */
public class BaseController {
	protected Logger logger = Logger.getLogger(BaseController.class);
	
	private AsUser currentUser;
	protected final String MAIN="WEB-INF/pages/main";
	protected final String LOGIN="WEB-INF/pages/login";


	public AsUser getCurrentUser() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(false);
		if(null != session){
			currentUser = (AsUser)session.getAttribute(Constants.SESSION_USER);
		}else {
			currentUser = null;
		}
		return currentUser;
	}

	public void setCurrentUser(AsUser currentUser) {
		this.currentUser = currentUser;
	}
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder){
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	protected String pages(String name){
		return "WEB-INF/pages/"+name;
	}
}
