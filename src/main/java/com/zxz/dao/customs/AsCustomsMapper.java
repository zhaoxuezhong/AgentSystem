package com.zxz.dao.customs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsCustoms;

public interface AsCustomsMapper {

	List<AsCustoms> findAsCustomsList(@Param("customs")AsCustoms customs,@Param("pageIndex") Integer pageIndex,
			@Param("pageSize") Integer pageSize);
	
	int getAsCustomsCount(AsCustoms customs);
	
	int addAsCustoms(AsCustoms customs);
}
