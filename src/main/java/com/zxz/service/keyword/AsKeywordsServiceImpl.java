package com.zxz.service.keyword;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.account.AsAccountMapper;
import com.zxz.dao.accountdetail.AsAccountdetailMapper;
import com.zxz.dao.keyword.AsKeywordsMapper;
import com.zxz.enu.FinanceType;
import com.zxz.pojo.AsAccount;
import com.zxz.pojo.AsAccountdetail;
import com.zxz.pojo.AsKeywords;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong AsKeywordsServiceImpl
 */
@Service
public class AsKeywordsServiceImpl implements AsKeywordsService {
	@Resource
	private AsKeywordsMapper asKeywordsMapper;
	@Resource
	private AsAccountMapper asAccountMapper;
	@Resource
	private AsAccountdetailMapper asAccountdetailMapper;

	@Override
	public Double addAsKeywords(AsKeywords keyword) {
		List<AsAccount> list = asAccountMapper.findAsAccountByUserId(keyword.getAgentId());
		if (list == null || list.size() < 1) {
			return 0D;
		}
		AsAccount account = list.get(0);
		account.setMoney(account.getMoney() - keyword.getPreRegFrozenMoney());

		AsAccountdetail accountDetail = new AsAccountdetail();
		accountDetail.setUserId(account.getUserId());
		accountDetail.setAccountMoney(account.getMoney());
		accountDetail.setDetailDateTime(new Timestamp(System.currentTimeMillis()));
		accountDetail.setMoney(-keyword.getPreRegFrozenMoney());
		accountDetail.setDetailType(FinanceType.冻结.ordinal() + 1);
		accountDetail.setDetailTypeName(FinanceType.冻结.toString());
		accountDetail.setMemo("申请关键词【 " + keyword.getKeywords() + " 】成功,冻结一年服务金额");
		if (asAccountdetailMapper.addAsAccountdetail(accountDetail) > 0
				&& asAccountMapper.updateAsAccount(account) > 0) {
			return asKeywordsMapper.addAsKeywords(keyword) > 0 ? account.getMoney() : 0D;
		}
		return 0D;
	}

	@Override
	public boolean valikey(String keywords) {
		return asKeywordsMapper.getAsKeywordsCount(new AsKeywords(keywords, 1)) > 0;
	}

	@Override
	public PageInfo<AsKeywords> findAsKeywordsList(AsKeywords keyword, Integer pageIndex, Integer pageSize) {
		PageInfo<AsKeywords> pageInfo = new PageInfo<AsKeywords>();
		Integer totalCount = asKeywordsMapper.getAsKeywordsCount(keyword);
		if (totalCount != null && totalCount != 0) {
			pageInfo.setTotalCount(totalCount);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageIndex(pageIndex);
			pageInfo.setList(asKeywordsMapper.findAsKeywordsList(keyword,
					(pageInfo.getPageIndex() - 1) * pageInfo.getPageSize(), pageInfo.getPageSize()));
		}
		return pageInfo;
	}

	@Override
	public boolean updateAsKeywords(AsKeywords keyword) {
		if (asKeywordsMapper.updateAsKeywords(keyword) < 1)
			return false;
		if (keyword != null && keyword.getCheckStatus() != null && keyword.getCheckStatus() == 2) {
			keyword = findAsKeywords(keyword.getId());
			List<AsAccount> list = asAccountMapper.findAsAccountByUserId(keyword.getAgentId());
			if (list == null || list.size() < 1)
				return false;
			AsAccount account = list.get(0);
			account.setMoneyBak(account.getMoneyBak() - keyword.getPrice());
			account.setMoney(account.getMoneyBak());

			AsAccountdetail accountDetail = new AsAccountdetail();
			accountDetail.setUserId(account.getUserId());
			accountDetail.setAccountMoney(account.getMoney());
			accountDetail.setDetailDateTime(new Timestamp(System.currentTimeMillis()));
			accountDetail.setMoney(-keyword.getPrice());
			accountDetail.setDetailType(FinanceType.代理款.ordinal() + 1);
			accountDetail.setDetailTypeName(FinanceType.代理款.toString());
			accountDetail.setMemo("关键词【 " + keyword.getKeywords() + " 】审核通过,扣除代理款￥" + keyword.getPrice() + "元");
			if (asAccountdetailMapper.addAsAccountdetail(accountDetail) < 1
					|| asAccountMapper.updateAsAccount(account) < 1) {
				return false;
			}
		}
		if (keyword != null && keyword.getCheckStatus() != null && keyword.getCheckStatus() == 3) {
			keyword = findAsKeywords(keyword.getId());
			List<AsAccount> list = asAccountMapper.findAsAccountByUserId(keyword.getAgentId());
			if (list == null || list.size() < 1)
				return false;
			AsAccount account = list.get(0);
			account.setMoney(account.getMoney() + keyword.getPreRegFrozenMoney());

			AsAccountdetail accountDetail = new AsAccountdetail();
			accountDetail.setUserId(account.getUserId());
			accountDetail.setAccountMoney(account.getMoney());
			accountDetail.setDetailDateTime(new Timestamp(System.currentTimeMillis()));
			accountDetail.setMoney(keyword.getPreRegFrozenMoney());
			accountDetail.setDetailType(FinanceType.退费.ordinal() + 1);
			accountDetail.setDetailTypeName(FinanceType.退费.toString());
			accountDetail
					.setMemo("关键词【 " + keyword.getKeywords() + " 】审核不通过,退回冻结款￥" + keyword.getPreRegFrozenMoney() + "元");
			if (asAccountdetailMapper.addAsAccountdetail(accountDetail) < 1
					|| asAccountMapper.updateAsAccount(account) < 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public AsKeywords findAsKeywords(Integer id) {
		return asKeywordsMapper.findAsKeywords(id);
	}

	@Override
	public boolean updateXufeiAsKeywords(AsKeywords keyword) {
		AsKeywords reKeywords = findAsKeywords(keyword.getId());
		Calendar calendar = Calendar.getInstance();
		Integer year=keyword.getServiceYears();
		Double price=keyword.getPrice();
		Double money=year*price;
		// 没有过期
		if (reKeywords.getIsPass() == 0) {
			calendar.setTime(reKeywords.getRegPassDatetime());
			keyword.setPrice(reKeywords.getPrice() +money);
			keyword.setServiceYears(reKeywords.getServiceYears() + year);
		}
		// 已过期
		else {
			calendar.setTime(new Timestamp(System.currentTimeMillis()));
			// 改为没有过期
			keyword.setIsPass(0);
			keyword.setPrice(money);
		}
		calendar.add(Calendar.YEAR, year);
		keyword.setRegPassDatetime(new Timestamp(calendar.getTimeInMillis()));

		if (asKeywordsMapper.updateAsKeywords(keyword) < 1)
			return false;

		List<AsAccount> list = asAccountMapper.findAsAccountByUserId(reKeywords.getAgentId());
		if (list == null || list.size() < 1)
			return false;
		AsAccount account = list.get(0);
		account.setMoneyBak(account.getMoneyBak() - money);
		account.setMoney(account.getMoneyBak());

		AsAccountdetail accountDetail = new AsAccountdetail();
		accountDetail.setUserId(account.getUserId());
		accountDetail.setAccountMoney(account.getMoney());
		accountDetail.setDetailDateTime(new Timestamp(System.currentTimeMillis()));
		accountDetail.setMoney(-money);
		accountDetail.setDetailType(FinanceType.代理款.ordinal() + 1);
		accountDetail.setDetailTypeName(FinanceType.代理款.toString());
		accountDetail.setMemo("关键词【 " + keyword.getKeywords() + " 】续费" + year + "年，扣除代理款￥"
				+ money + "元");
		if (asAccountdetailMapper.addAsAccountdetail(accountDetail) < 1
				|| asAccountMapper.updateAsAccount(account) < 1) {
			return false;
		}
		return true;
	}

}
