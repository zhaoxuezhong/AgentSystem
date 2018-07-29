package com.zxz.service.systemconfig;

import java.util.List;

import com.zxz.pojo.AsSystemconfig;

public interface AsSystemconfigService {

	List<AsSystemconfig> findAsSystemconfigList(Integer configType,Integer isStart);
	
	String addAsSystemconfig(AsSystemconfig config);
	
	String updateAsSystemconfig(AsSystemconfig config);
	
	boolean deleteAsSystemconfig(Integer id);
}
