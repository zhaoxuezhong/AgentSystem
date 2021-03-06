package com.zxz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zxz.pojo.AsSystemconfig;
import com.zxz.service.systemconfig.AsSystemconfigService;
import com.zxz.utils.Constants;

/**
 * @author zhaoxuezhong
 *	AsSystemconfigController
 */
@Controller
@RequestMapping(value="agent/systemconfig")
public class AsSystemconfigController extends BaseController{
	@Resource
	private AsSystemconfigService asSystemconfigServiceImpl;
	
	@RequestMapping(value="")
	public String systemconfig(Model model){
		return systemConfigList(Constants.FINANCE_TYPE,model);
	}
	
	@RequestMapping(value="list/{configType}")
	public String systemConfigList(@PathVariable("configType")Integer configType,Model model){
		List<AsSystemconfig> systemConfigList= asSystemconfigServiceImpl.findAsSystemconfigList(configType,null);
		model.addAttribute("systemConfigList", systemConfigList);
		model.addAttribute("configType", configType);
		return pages("systemconfig");
	}
	
	@RequestMapping(value="addconfig")
	@ResponseBody
	public String addconfig(String systemConfig){
		AsSystemconfig config=JSONObject.parseObject(systemConfig,new TypeReference<AsSystemconfig>(){});
		String result=asSystemconfigServiceImpl.addAsSystemconfig(config);
		return result;
	}
	
	@RequestMapping(value="modifyconfig")
	@ResponseBody
	public String modifyconfig(String systemConfig){
		AsSystemconfig config=JSONObject.parseObject(systemConfig,new TypeReference<AsSystemconfig>(){});
		String result=asSystemconfigServiceImpl.updateAsSystemconfig(config);
		return result;
	}
	
	@RequestMapping(value="deleteconfig")
	@ResponseBody
	public String deleteconfig(Integer id){
		return asSystemconfigServiceImpl.deleteAsSystemconfig(id)?"success":"false";
	}
	
	@RequestMapping(value="caiwu")
	public String caiwu(Model model){
		List<AsSystemconfig> accountConfigList=asSystemconfigServiceImpl.findAsSystemconfigList(Constants.FINANCE_TYPE, 1);
		model.addAttribute("accountConfigList", accountConfigList);
		return pages("caiwu");
	}
	
}
