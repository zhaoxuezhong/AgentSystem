package com.zxz.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="accountdetail")
	public String accountdetail(Model model,
			@RequestParam(defaultValue="1")Integer pageIndex,@RequestParam(defaultValue="5")Integer pageSize){
		PageInfo<AsAccountdetail> accountDetailList=asAccountServiceImpl
				.findAsAccountdetailList(this.getCurrentUser().getId(),pageIndex,pageSize);
		model.addAttribute("accountDetailList", accountDetailList);
		return pages("accountdetail");
	}
}
