package com.zxz.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
import com.zxz.service.account.AsAccountService;
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
				.findAsAccountdetailList(this.getCurrentUser().getId(),pageIndex,pageSize);
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
	
	
	
}
