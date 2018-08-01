package com.zxz.service.customs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.contacts.ContactsMapper;
import com.zxz.dao.customs.AsCustomsMapper;
import com.zxz.pojo.AsContacts;
import com.zxz.pojo.AsCustoms;
import com.zxz.utils.PageInfo;

/**
 * @author zhaoxuezhong AsCustomsServiceImpl
 */
@Service
public class AsCustomsServiceImpl implements AsCustomsService {
	@Resource
	private AsCustomsMapper asCustomsMapper;
	@Resource
	private ContactsMapper contactsMapper;

	@Override
	public PageInfo<AsCustoms> findAsCustomsList(AsCustoms customs, Integer pageIndex, Integer pageSize) {
		PageInfo<AsCustoms> pageInfo = new PageInfo<AsCustoms>();
		Integer totalCount = asCustomsMapper.getAsCustomsCount(customs);
		if (totalCount != null && totalCount != 0) {
			pageInfo.setTotalCount(totalCount);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageIndex(pageIndex);
			pageInfo.setList(asCustomsMapper.findAsCustomsList(customs,
					(pageInfo.getPageIndex() - 1) * pageInfo.getPageSize(), pageInfo.getPageSize()));
		}
		return pageInfo;
	}

	@Override
	public boolean addAsCustoms(AsCustoms customs) {
		int customId = asCustomsMapper.addAsCustoms(customs);
		boolean result;
		if (result = customId > 0) {
			List<AsContacts> contacts = customs.getContactList();
			if (contacts != null && contacts.size() > 0) {
				for (AsContacts asContacts : contacts) {
					asContacts.setCustomId(customId);
					if (contactsMapper.addAsContacts(asContacts) < 0) {
						result = false;
					}
				}
			}
		}
		return result;
	}

	@Override
	public boolean isExitCustomName(String customName) {
		return asCustomsMapper.getAsCustomsCount(new AsCustoms(customName)) > 0;
	}

	@Override
	public boolean updateAsCustoms(AsCustoms customs) {
		boolean result = asCustomsMapper.updateAsCustoms(customs) > 0;
		if (result) {
			List<AsContacts> contactsList = customs.getContactList();
			if (contactsList != null && contactsList.size() > 0) {
				for (AsContacts asContacts : contactsList) {
					contactsMapper.updateAsContacts(asContacts);
					if (contactsMapper.updateAsContacts(asContacts) < 0) {
						result = false;
					}
				}
			} 
		}
		return result;
	}

	@Override
	public AsCustoms findAsCustoms(Integer id) {
		return asCustomsMapper.findAsCustoms(id);
	}

}
