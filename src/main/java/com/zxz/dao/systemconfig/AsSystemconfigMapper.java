package com.zxz.dao.systemconfig;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsSystemconfig;

/**
 * @author zhaoxuezhong
 *	AsSystemconfigMapper
 */
public interface AsSystemconfigMapper {
	
	List<AsSystemconfig> findAsSystemconfigList(@Param("configType")Integer configType,@Param("isStart")Integer isStart);
	
	int getConfigTypeNameExist(String configTypeName);
	
	int getMaxConfigTypeValue(Integer configType);
	
	int addAsSystemconfig(AsSystemconfig config);
	
	int updateAsSystemconfig(AsSystemconfig config);
	
	int deleteAsSystemconfig(Integer id);
}
