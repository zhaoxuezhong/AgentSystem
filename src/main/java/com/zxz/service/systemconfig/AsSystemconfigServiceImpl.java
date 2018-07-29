package com.zxz.service.systemconfig;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.systemconfig.AsSystemconfigMapper;
import com.zxz.pojo.AsSystemconfig;

/**
 * @author zhaoxuezhong
 *	AsSystemconfigServiceImpl
 */
@Service
public class AsSystemconfigServiceImpl implements AsSystemconfigService{
	@Resource
	private AsSystemconfigMapper asSystemconfigMapper;
	
	@Override
	public List<AsSystemconfig> findAsSystemconfigList(Integer configType,Integer isStart) {
		return asSystemconfigMapper.findAsSystemconfigList(configType,isStart);
	}

	@Override
	public String addAsSystemconfig(AsSystemconfig config) {
		if(asSystemconfigMapper.getConfigTypeNameExist(config.getConfigTypeName())>0){
			return "peat";
		}
		int configTypeValue=asSystemconfigMapper.getMaxConfigTypeValue(config.getConfigType());
		config.setConfigTypeValue(configTypeValue+1);
		return asSystemconfigMapper.addAsSystemconfig(config)>0?"success":"false";
	}

	@Override
	public String updateAsSystemconfig(AsSystemconfig config) {
		return asSystemconfigMapper.updateAsSystemconfig(config)>0?"success":"false";
	}

	@Override
	public boolean deleteAsSystemconfig(Integer id) {
		return asSystemconfigMapper.deleteAsSystemconfig(id)>0;
	}

}
