package com.zxz.dao.address;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.HatArea;
import com.zxz.pojo.HatCity;
import com.zxz.pojo.HatProvince;

/**
 * @author zhaoxuezhong
 *	AddressMapper
 */
public interface AddressMapper {
	
	List<HatProvince> findHatProvinceList(@Param("provinceId")Integer provinceId);
	
	List<HatCity> findHatCityList(@Param("father")Integer father);
	
	List<HatArea> findHatAreaList(@Param("father")Integer father);
}
