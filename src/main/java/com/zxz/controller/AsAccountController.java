package com.zxz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
import com.zxz.pojo.AsSystemconfig;
import com.zxz.pojo.condition.AccountCondition;
import com.zxz.service.account.AsAccountService;
import com.zxz.service.systemconfig.AsSystemconfigService;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsAccountController
 */
@Controller
@RequestMapping(value="agent/account")
public class AsAccountController extends BaseController{
	@Resource
	private AsAccountService asAccountServiceImpl;
	@Resource
	private AsSystemconfigService asSystemconfigServiceImpl;
	
	@RequestMapping(value="")
	public String account(Model model){
		return accountdetail( model, 1, 6);
	}
	
	/**
	 * 查看账户明细
	 * @param model
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="accountdetail")
	public String accountdetail(Model model,
			@RequestParam(defaultValue="1")Integer pageIndex,@RequestParam(defaultValue="5")Integer pageSize){
		PageInfo<AsAccountdetail> accountDetailList=asAccountServiceImpl
				.findAsAccountdetailList(new AccountCondition(this.getCurrentUser().getId()),pageIndex,pageSize);
		model.addAttribute("accountDetailList", accountDetailList);
		return pages("accountdetail");
	}
	
	/**
	 * 操作账户
	 * @return
	 */
	@RequestMapping(value="opeaccount")
	@ResponseBody
	public String opeaccount(String account){
		AsAccount asAccount=JSONObject.parseObject(account, AsAccount.class);
		boolean result=asAccountServiceImpl.updateAsAccount(asAccount);
		return result?"success":"false";
	}
	
	@RequestMapping(value="yfklist",method=RequestMethod.GET)
	public String yfklist(Integer id,String userCode,
			Model model,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize){
		return yfklist(new AccountCondition(id,userCode),model,pageIndex,pageSize);
	}
	
	@RequestMapping(value="yfklist",method=RequestMethod.POST)
	public String yfklist(AccountCondition accountCondition,
			Model model,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize){
		PageInfo<AsAccountdetail> accountdetailList=asAccountServiceImpl
				.findAsAccountdetailList(accountCondition, pageIndex, pageSize);
		model.addAttribute("accountCondition", accountCondition);
		model.addAttribute("accountdetailList", accountdetailList);
		List<AsSystemconfig> accountConfigList= asSystemconfigServiceImpl.findAsSystemconfigList(1, 1);
		model.addAttribute("accountConfigList", accountConfigList);
		return pages("yfklist");
	}
	
	@RequestMapping(value="yfk")
	public String yfk(AccountCondition accountCondition,
			Model model,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize){
		accountCondition.setId(this.getCurrentUser().getRoleId()!=1?this.getCurrentUser().getId():null);
		yfklist(accountCondition, model, pageIndex, pageSize);
		return pages("yfk");
	}
	
	
}
