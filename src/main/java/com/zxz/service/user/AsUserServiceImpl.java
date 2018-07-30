package com.zxz.service.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxz.dao.user.AsUserMapper;
import com.zxz.pojo.AsUser;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong
 *	AsUserServiceImpl
 */
@Service
@Scope("session")
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

	@Override
	public PageInfo<AsUser> findAsUserList(AsUser user, Integer pageIndex, Integer pageSize) {
		PageInfo<AsUser> pageInfo=new PageInfo<AsUser>();
		Integer totalCount= asUserMapper.getAsUserCount(user);
		if (totalCount!=null&&totalCount!=0) {
			pageInfo.setTotalCount(totalCount);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageIndex(pageIndex);
			pageInfo.setList(asUserMapper.findAsUserList(user, 
					(pageInfo.getPageIndex()-1)*pageInfo.getPageSize(), pageInfo.getPageSize()));
		}
		return pageInfo;
	}

	@Override
	public boolean addAsUser(AsUser user) {
		return asUserMapper.addAsUser(user)>0;
	}

	@Override
	public boolean deleteAsUser(Integer id) {
		return asUserMapper.deleteAsUser(id)>0;
	}

}
