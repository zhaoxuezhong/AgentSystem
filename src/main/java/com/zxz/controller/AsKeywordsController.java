package com.zxz.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zxz.pojo.AsKeywords;
import com.zxz.pojo.AsSystemconfig;
import com.zxz.pojo.AsUser;
import com.zxz.service.account.AsAccountService;
import com.zxz.service.keyword.AsKeywordsService;
import com.zxz.service.systemconfig.AsSystemconfigService;
import com.zxz.utils.Constants;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsKeywordsController
 */
@Controller
@RequestMapping(value="agent/keyword")
public class AsKeywordsController extends BaseController {
	@Resource
	private AsKeywordsService asKeywordsServiceImpl;
	@Resource
	private AsSystemconfigService asSystemconfigServiceImpl;
	@Resource
	private AsAccountService asAccountServiceImpl;
	
	@RequestMapping(value="")
	public String keyword(){
		return "redirect:keywordmanage";
	}
	
	@RequestMapping(value="keyword")
	public String addKeyword(Model model){
		List<AsSystemconfig> serviceTypeList=asSystemconfigServiceImpl.findAsSystemconfigList(Constants.SERVICE_TYPE, 1);
		model.addAttribute("serviceTypeList", serviceTypeList);
		List<AsSystemconfig> youhuiTypeList=asSystemconfigServiceImpl.findAsSystemconfigList(Constants.FAVOURABLE_TYPE, 1);
		model.addAttribute("youhuiTypeList", youhuiTypeList);
		Integer maxServiceYears=Integer.parseInt(asSystemconfigServiceImpl.findAsSystemconfigList(Constants.SERVICE_YEAR, 1).get(0).getConfigValue());
		model.addAttribute("maxServiceYears", maxServiceYears);
		return pages("keywords");
	}
	
	@RequestMapping(value="valikey")
	@ResponseBody
	public String valikey(String keywords){
		return asKeywordsServiceImpl.valikey(keywords)?"false":"success";
	}
	
	@RequestMapping(value="submitkeyword")
	@ResponseBody
	public String submitkeyword(String keywords,Integer data){
		try {
			AsKeywords keyword=JSONObject.parseObject(keywords,AsKeywords.class);
			AsUser loginUser =this.getCurrentUser();
			keyword.setAgentId(loginUser.getId());
			keyword.setAgentName(loginUser.getUserName());
			keyword.setPreRegFrozenMoney(keyword.getPrice());
			keyword.setPrice(keyword.getPrice()*keyword.getServiceYears());
			keyword.setServiceYears(keyword.getServiceYears()+data);
			keyword.setOpenApp(0);
			keyword.setPreRegDatetime(new Timestamp(System.currentTimeMillis()));
			keyword.setCheckStatus(0);
			keyword.setIsPass(0);
			keyword.setIsUse(1);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(keyword.getPreRegDatetime());
			calendar.add(Calendar.DAY_OF_YEAR,5);
			//5天后过期
	        keyword.setPreRegPassDatetime(new Timestamp(calendar.getTimeInMillis()));
			Double result=asKeywordsServiceImpl.addAsKeywords(keyword);
			return result==0?"exception":result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "exception";
		}
	}
	
	@RequestMapping(value="keywordmanage")
	public String keywordmanage(AsKeywords asKeywords,Model model,
			@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize){
		asKeywords.setAgentId(this.getCurrentUser().getRoleId()!=1?this.getCurrentUser().getId():null);
		PageInfo<AsKeywords> keywordsList=asKeywordsServiceImpl
				.findAsKeywordsList(asKeywords, pageIndex, pageSize);
		model.addAttribute("keywordsList", keywordsList);
		return pages("keywordmanage");
	}
	
	@RequestMapping(value="checkkeyword")
	public String checkkeyword(AsKeywords asKeywords,Model model,
			@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize){
		PageInfo<AsKeywords> keywordsList=asKeywordsServiceImpl
				.findAsKeywordsList(asKeywords, pageIndex, pageSize);
		model.addAttribute("keywordsList", keywordsList);
		return pages("checkkeyword");
	}
	
	
	@RequestMapping(value="updatekeywords")
	@ResponseBody
	public String updatekeywords(String keywords){
		AsKeywords keyword=JSONObject.parseObject(keywords, AsKeywords.class);
		if(keyword!=null&& keyword.getCheckStatus()!=null&& keyword.getCheckStatus()==2){
			keyword.setRegDatetime(new Timestamp(System.currentTimeMillis()));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(keyword.getRegDatetime());
			calendar.add(Calendar.YEAR,keyword.getServiceYears());
	        keyword.setRegPassDatetime(new Timestamp(calendar.getTimeInMillis()));
	        keyword.setIsPass(0);
		}
		if(keyword!=null&& keyword.getCheckStatus()!=null&& keyword.getCheckStatus()==3){
			keyword.setIsUse(0);
		}
		return asKeywordsServiceImpl.updateAsKeywords(keyword)?"success":"false";
	}
	
	@RequestMapping(value="openapp")
	public String openapp(Integer id,Model model){
		AsKeywords keywords=asKeywordsServiceImpl.findAsKeywords(id);
		model.addAttribute("keywords", keywords);
		return pages("openapp");
	}
	
	@RequestMapping(value="modifyapp")
	public String modifyapp(AsKeywords asKeywords,Model model){
		if(asKeywordsServiceImpl.updateAsKeywords(asKeywords)){
			return "redirect:keywordmanage";
		}
		AsKeywords keywords=asKeywordsServiceImpl.findAsKeywords(asKeywords.getId());
		keywords.setAppUserName(asKeywords.getAppUserName());
		keywords.setAppPassword(asKeywords.getAppPassword());
		model.addAttribute("keywords", keywords);
		return pages("openapp");
	}
	
}
