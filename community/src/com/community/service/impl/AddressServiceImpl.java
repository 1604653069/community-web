package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.AddressDao;
import com.community.domain.Address;
import com.community.service.AddressService;
@Transactional
public class AddressServiceImpl implements AddressService {
	private AddressDao addressDao;
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	public void addAddress(Address address) {
			addressDao.addAddress(address);
	}
	public void removeAddress(String aid) {
			addressDao.removeAddress(aid);
	}

	public void changeAddress(Address address) {
			addressDao.changeAddress(address);
	}

	public List<Address> getAllAddress(String uid) {
		return addressDao.getAllAddress(uid);
	}

}
