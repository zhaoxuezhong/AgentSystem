package com.zxz.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsUser;
import com.zxz.service.account.AsAccountService;
import com.zxz.service.function.AsRolePremissioinService;
import com.zxz.service.user.AsUserService;
import com.zxz.utils.Constants;
import com.zxz.utils.RedisAPI;

/**
 * @author zhaoxuezhong LoginController
 */
@Controller
@Scope("session")
public class LoginController extends BaseController {
	@Resource
	private AsUserService asUserServiceImpl;
	@Resource
	private AsRolePremissioinService asRolePremissioinServiceImpl;
	@Resource
	private AsAccountService asAccountServiceImpl;
	@Resource
	private RedisAPI redisAPI;

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin(AsUser user, HttpSession session) {
		AsUser loginUser = asUserServiceImpl.login(user);
		if (loginUser != null) {
			session.setAttribute(Constants.SESSION_USER, loginUser);
			return "redirect:agent/main";
		}
		return LOGIN;
	}

	@RequestMapping(value = "logOut")
	public String logOut(HttpSession session) {
		if (this.getCurrentUser() != null) {
			AsUser user = new AsUser(this.getCurrentUser().getId(), new Timestamp(System.currentTimeMillis()));
			asUserServiceImpl.updateAsUser(user);
			session.removeAttribute(Constants.SESSION_USER);
		}
		return LOGIN;
	}

	@RequestMapping(value = "toLogin")
	public String toLogin() {
		return LOGIN;
	}
	
	@RequestMapping(value="agent")
	public String agent(Model model,HttpSession session){
		return main(model, session);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "agent/main")
	public String main(Model model,HttpSession session) {
		String key="role"+this.getCurrentUser().getRoleId();
		if(!redisAPI.exist(key)){
			List<Map<String, Object>> menuList=asRolePremissioinServiceImpl.findMenu(this.getCurrentUser().getRoleId());
			if(null != menuList){
				session.setAttribute("menuList", menuList);
				redisAPI.set(key, JSONArray.toJSONString(menuList));
			}
		}
		else{
			List<Map> menuList=(List<Map>) JSONArray.parseArray(redisAPI.get(key),Map.class);
			session.setAttribute("menuList", menuList);
		}
		
		AsAccount account=asAccountServiceImpl.findAsAccountByUserId(this.getCurrentUser().getId());
		session.setAttribute("account", account);
		return MAIN;
	}

}
