package com.zxz.service.log;


import com.zxz.pojo.AsLogs;
import com.zxz.utils.PageInfo;
/**
 * @author zhaoxuezhong
 *	AsLogsService
 */
public interface AsLogsService {

	PageInfo<AsLogs> findAsLogsList(AsLogs asLogs,Integer pageIndex,Integer pageSize);
}
