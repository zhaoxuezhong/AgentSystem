package com.zxz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxz.pojo.AsCustoms;
import com.zxz.pojo.AsSystemconfig;
import com.zxz.pojo.AsUser;
import com.zxz.pojo.HatArea;
import com.zxz.pojo.HatCity;
import com.zxz.pojo.HatProvince;
import com.zxz.service.address.AddressService;
import com.zxz.service.customs.AsCustomsService;
import com.zxz.service.systemconfig.AsSystemconfigService;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsCustomsController
 */
@Controller
@RequestMapping(value="agent/customs")
public class AsCustomsController extends BaseController{
	@Resource
	private AsCustomsService asCustomsServiceImpl;
	@Resource
	private AddressService addressServiceImpl;
	@Resource
	private AsSystemconfigService asSystemconfigServiceImpl;
	
	@RequestMapping(value="customlist")
	public String customlist(AsCustoms customs,Model model,
			@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="6")Integer pageSize){
		PageInfo<AsCustoms> customsList=asCustomsServiceImpl.findAsCustomsList(customs, pageIndex, pageSize);
		model.addAttribute("customsList", customsList);
		return pages("customlist");
	}
	
	@RequestMapping(value="addcustom")
	public String addcustom(Model model){
		List<HatProvince> provinceList=addressServiceImpl.findHatProvinceList(null);
		model.addAttribute("provinceList", provinceList);
		//企业类型
		List<AsSystemconfig> customTypeList=asSystemconfigServiceImpl.findAsSystemconfigList(5, 1);
		model.addAttribute("customTypeList", customTypeList);
		//证件类型
		List<AsSystemconfig> cardTypeList=asSystemconfigServiceImpl.findAsSystemconfigList(6, 1);
		model.addAttribute("cardTypeList", cardTypeList);
		return pages("addcustom");
	}
	
	@RequestMapping(value="loadcity")
	public String loadcity(Integer provinceId,Model model){
		List<HatCity> cityList=addressServiceImpl.findHatCityList(provinceId);
		model.addAttribute("cityList", cityList);
		return "";
	}
	
	@RequestMapping(value="loadarea")
	public String loadarea(Integer cityId,Model model){
		List<HatArea> areaList=addressServiceImpl.findHatAreaList(cityId);
		model.addAttribute("areaList", areaList);
		return "";
	}
	
	@RequestMapping(value="addsavecustom")
	public String addsavecustom(AsCustoms asCustoms){
		AsUser loginUser=this.getCurrentUser();
		asCustoms.setAgentId(loginUser.getId());
		asCustoms.setAgentCode(loginUser.getUserCode());
		asCustoms.setAgentName(loginUser.getUserName());
		if(asCustomsServiceImpl.addAsCustoms(asCustoms)){
			return "redirect:customlist";
		}
		return "redirect:addcustom";
	}
	
	@RequestMapping(value="isexitcustomname")
	@ResponseBody
	public String isexitcustomname(String customName){
		return asCustomsServiceImpl.isExitCustomName(customName)?"peat":"nopeat";
	}
	
}
