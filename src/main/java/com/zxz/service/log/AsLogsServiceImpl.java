package com.zxz.service.log;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.log.AsLogsMapper;
import com.zxz.pojo.AsLogs;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsLogsServiceImpl
 */
@Service
public class AsLogsServiceImpl implements AsLogsService {
	@Resource
	private AsLogsMapper asLogsMapper;
	@Override
	public PageInfo<AsLogs> findAsLogsList(AsLogs asLogs, Integer pageIndex, Integer pageSize) {
		PageInfo<AsLogs> pageInfo=new PageInfo<AsLogs>();
		Integer totalCount= asLogsMapper.getAsLogsCount(asLogs);
		if (totalCount!=null&&totalCount!=0) {
			pageInfo.setTotalCount(totalCount);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageIndex(pageIndex);
			pageInfo.setList(asLogsMapper.findAsLogsList(asLogs, 
					(pageInfo.getPageIndex()-1)*pageInfo.getPageSize(), pageInfo.getPageSize()));
		}
		return pageInfo;
	}

}
