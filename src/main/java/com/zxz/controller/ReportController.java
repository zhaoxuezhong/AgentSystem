package com.zxz.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zxz.enu.FinanceType;
import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
import com.zxz.pojo.AsKeywords;
import com.zxz.pojo.condition.AccountCondition;
import com.zxz.service.account.AsAccountService;
import com.zxz.service.keyword.AsKeywordsService;
import com.zxz.utils.ExportData;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong ReportController
 */
@Controller
@RequestMapping(value = "agent/report")
public class ReportController extends BaseController {
	@Resource
	private AsAccountService asAccountServiceImpl;
	@Resource
	private AsKeywordsService asKeywordsServiceImpl;
	@Resource
	private ExportData exportData;

	@RequestMapping(value = "")
	public String report() {
		return "redirect:report";
	}

	@RequestMapping(value = "report")
	public String search(@RequestParam(defaultValue = "1") Integer reportType,
			AccountCondition accountCondition,Model model) {
		model.addAttribute("reportType", reportType);
		switch (reportType) {
		case 1:
			List<AsAccount> accountList = asAccountServiceImpl.findAllAsAccount();
			model.addAttribute("accountList", accountList);
			break;
		case 2:
			accountCondition.setDetailType(FinanceType.冻结.ordinal()+1);
			PageInfo<AsAccountdetail> accountDetailList=asAccountServiceImpl.findAsAccountdetailList(accountCondition, null, null);
			model.addAttribute("accountDetailList", accountDetailList.getList());
			break;
		case 3:
			PageInfo<AsAccountdetail> accountDetailList1=asAccountServiceImpl.findAsAccountdetailList(accountCondition, null, null);
			model.addAttribute("accountDetailList", accountDetailList1.getList());
			break;
		case 4:
			
			PageInfo<AsKeywords> productList= asKeywordsServiceImpl.findAsKeywordsList(
					new AsKeywords(accountCondition.getStartTime(),accountCondition.getEndTime()), null, null);
			model.addAttribute("reportproductList", productList.getList());
			break;
		}
		
		return pages("report");
	}

	@RequestMapping(value="reportaccounte")
	public String reportaccounte(HttpServletRequest request){
		List<String> heads = Arrays.asList("序号","代理商名称","账户余额");

		List<AsAccount> accountList = asAccountServiceImpl.findAllAsAccount();
		List<List<Object>> list=new ArrayList<List<Object>>();
		for (int i=0;i<accountList.size();i++) {
			List<Object> item=new ArrayList<Object>();
			item.add(i+1);
			item.add(accountList.get(i).getUserName());
			item.add(accountList.get(i).getMoney());
			list.add(item);
		}		
		String excelName="代理商余额报表-"+System.currentTimeMillis();
		try {
			String path=request.getServletContext().getRealPath("report");
			exportData.outFile(exportData.expExcel(heads,list,excelName),
					path+File.separator+excelName+".xls");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:report";
	}
	
	@RequestMapping("reportaccount")
	public String reportaccount(String startTime,String endTime,HttpServletRequest request){
		String path=request.getServletContext().getRealPath("report")+File.separator+"代理商余额报表-"+System.currentTimeMillis()+".pdf";
		List<String> heads = Arrays.asList("序号","代理商名称","账户余额");

		List<AsAccount> accountList = asAccountServiceImpl.findAllAsAccount();
		List<List<Object>> list=new ArrayList<List<Object>>();
		for (int i=0;i<accountList.size();i++) {
			List<Object> item=new ArrayList<Object>();
			item.add(i+1);
			item.add(accountList.get(i).getUserName());
			item.add(accountList.get(i).getMoney());
			list.add(item);
		}
		exportData.exportPDF(3,"代理商余额报表",path, heads, list);;
		return "redirect:report";
	}
	
}
