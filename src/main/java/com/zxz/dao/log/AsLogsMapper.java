package com.zxz.dao.log;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsLogs;

public interface AsLogsMapper {
	
	int getAsLogsCount(AsLogs asLogs);

	List<AsLogs> findAsLogsList(@Param("asLogs")AsLogs asLogs,
			@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
}
