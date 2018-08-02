package com.zxz.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zxz.pojo.AsLogs;
import com.zxz.service.log.AsLogsService;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsLogsController
 */
@Controller
@RequestMapping(value="agent/log")
public class AsLogsController extends BaseController{
	@Resource
	private AsLogsService asLogsServiceImpl;
	
	@RequestMapping(value="loglist",method=RequestMethod.GET)
	public String loglist(Integer id,String userName,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize,Model model){
		return loglist(new AsLogs(id,userName), pageIndex, pageSize, model);
	}
	
	@RequestMapping(value="loglist",method=RequestMethod.POST)
	public String loglist(AsLogs asLogs,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize,Model model){
		PageInfo<AsLogs> logsList=asLogsServiceImpl.findAsLogsList(asLogs, pageIndex, pageSize);
		model.addAttribute("logsList", logsList);
		model.addAttribute("asLogs", asLogs);
		return pages("loglist");
	}
	
	@RequestMapping(value="mylogs")
	public String mylogs(AsLogs asLogs,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize,Model model){
		asLogs.setUserId(this.getCurrentUser().getRoleId()!=1?this.getCurrentUser().getId():null);
		loglist(asLogs, pageIndex, pageSize, model);
		return pages("logs");
	}
	
}
