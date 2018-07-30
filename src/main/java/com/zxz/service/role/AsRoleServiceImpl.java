package com.zxz.service.role;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.role.AsRoleMapper;
import com.zxz.pojo.AsRole;

/**
 * @author zhaoxuezhong
 *	AsRoleServiceImpl
 */
@Service
public class AsRoleServiceImpl implements AsRoleService {
	@Resource
	private AsRoleMapper asRoleMapper;
	
	@Override
	public List<AsRole> findAsRoleList(Integer isStart) {
		return asRoleMapper.findAsRoleList(isStart);
	}

	@Override
	public boolean addAsRole(AsRole role) {
		return asRoleMapper.addAsRole(role)>0;
	}

	@Override
	public boolean updateAsRole(AsRole role) {
		return asRoleMapper.updateAsRole(role)>0;
	}

	@Override
	public boolean deleteAsRole(Integer id) {
		return asRoleMapper.deleteAsRole(id)>0;
	}

}
