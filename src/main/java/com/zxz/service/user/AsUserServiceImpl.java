package com.zxz.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.user.AsUserMapper;
import com.zxz.pojo.AsUser;

/**
 * @author zhaoxuezhong
 *	AsUserServiceImpl
 */
@Service
public class AsUserServiceImpl implements AsUserService {
	@Resource
	private AsUserMapper asUserMapper;
	
	@Override
	public AsUser login(AsUser user) {
		return asUserMapper.findAsUser(user);
	}

	@Override
	public boolean updateAsUser(AsUser user) {
		return asUserMapper.updateAsUser(user)>0;
	}

}
