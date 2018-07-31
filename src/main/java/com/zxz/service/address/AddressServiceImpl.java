package com.zxz.service.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.address.AddressMapper;
import com.zxz.pojo.HatArea;
import com.zxz.pojo.HatCity;
import com.zxz.pojo.HatProvince;

/**
 * @author zhaoxuezhong
 *	AddressServiceImpl
 */
@Service
public class AddressServiceImpl implements AddressService {
	@Resource
	private AddressMapper addressMapper;
	
	@Override
	public List<HatProvince> findHatProvinceList(Integer provinceID) {
		return addressMapper.findHatProvinceList(provinceID);
	}

	@Override
	public List<HatCity> findHatCityList(Integer father) {
		return addressMapper.findHatCityList(father);
	}

	@Override
	public List<HatArea> findHatAreaList(Integer father) {
		return addressMapper.findHatAreaList(father);
	}

}
