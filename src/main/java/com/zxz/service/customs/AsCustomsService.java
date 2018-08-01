package com.zxz.service.customs;

import com.zxz.pojo.AsCustoms;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsCustomsService
 */
public interface AsCustomsService {

	PageInfo<AsCustoms> findAsCustomsList(AsCustoms customs,Integer pageIndex,Integer pageSize);
	
	boolean addAsCustoms(AsCustoms customs);
	
	boolean updateAsCustoms(AsCustoms customs);
	
	AsCustoms findAsCustoms(Integer id);
	
	boolean isExitCustomName(String customName);
}
