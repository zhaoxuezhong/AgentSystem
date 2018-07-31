package com.zxz.service.address;

import java.util.List;

import com.zxz.pojo.HatArea;
import com.zxz.pojo.HatCity;
import com.zxz.pojo.HatProvince;

/**
 * @author zhaoxuezhong
 *	AddressService
 */
public interface AddressService {

	List<HatProvince> findHatProvinceList(Integer provinceID);
	
	List<HatCity> findHatCityList(Integer father);
	
	List<HatArea> findHatAreaList(Integer father);
}
