package com.zxz.dao.keyword;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsKeywords;

/**
 * @author zhaoxuezhong
 *	AsKeywordsMapper
 */
public interface AsKeywordsMapper {

	int addAsKeywords(AsKeywords keyword);
	
	List<AsKeywords> findAsKeywordsList(@Param("keyword")AsKeywords keyword,
			@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
	int getAsKeywordsCount(AsKeywords keyword);
	
	int updateAsKeywords(AsKeywords keyword);
	
	AsKeywords findAsKeywords(@Param("id")Integer id);
	
}
