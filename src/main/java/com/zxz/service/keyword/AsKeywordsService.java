package com.zxz.service.keyword;

import com.zxz.pojo.AsKeywords;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsKeywordsService
 */
public interface AsKeywordsService {

	Double addAsKeywords(AsKeywords keyword);
	
	boolean valikey(String keywords);
	
	boolean updateAsKeywords(AsKeywords keyword);
	
	AsKeywords findAsKeywords(Integer id);
	
	PageInfo<AsKeywords> findAsKeywordsList(AsKeywords keyword,Integer pageIndex,Integer pageSize);
}
