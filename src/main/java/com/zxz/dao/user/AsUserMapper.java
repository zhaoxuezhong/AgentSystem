package com.zxz.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsUser;

/**
 * @author zhaoxuezhong
 *	AsUserMapper
 */
public interface AsUserMapper {
	
	AsUser findAsUser(AsUser user);

	int updateAsUser(AsUser user);
	
	int getAsUserCount(AsUser user);
	
	int addAsUser(AsUser user);
	
	int deleteAsUser(Integer id);
	
	List<AsUser> findAsUserList(@Param("user")AsUser user,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
}
