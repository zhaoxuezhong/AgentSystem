package com.zxz.dao.accountdetail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AsAccountdetail;
import com.zxz.pojo.condition.AccountCondition;

/**
 * @author zhaoxuezhong
 *	AsAccountdetailMapper
 */
public interface AsAccountdetailMapper {
	
	int getAsAccountdetailCount(AccountCondition accountCondition);
	
	List<AsAccountdetail> findAsAccountdetailList(@Param("accountCondition")AccountCondition accountCondition,
			@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
	
	int addAsAccountdetail(AsAccountdetail accountDetail);
	
	int updateAsAccountdetail(AsAccountdetail accountDetail);
	
	int deleteAsAccountdetail(AsAccountdetail accountDetail);
	
}
