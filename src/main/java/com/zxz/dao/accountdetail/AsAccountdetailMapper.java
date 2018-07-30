package com.zxz.dao.accountdetail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsAccountdetail;

/**
 * @author zhaoxuezhong
 *	AsAccountdetailMapper
 */
public interface AsAccountdetailMapper {
	
	int getAsAccountdetailCount(Integer userId);
	
	List<AsAccountdetail> findAsAccountdetailList(@Param("userId")Integer userId,
			@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
	
	int addAsAccountdetail(AsAccountdetail accountDetail);
	
	int updateAsAccountdetail(AsAccountdetail accountDetail);
	
	int deleteAsAccountdetail(AsAccountdetail accountDetail);
	
}
