package com.community.dao;

import java.util.List;

import com.community.domain.Address;

public interface AddressDao {

	//添加收货地址
	public void addAddress(Address address);
	//删除收货地址
	public void removeAddress(String aid);
	//修改收货地址
	public void changeAddress(Address address);
	//获取所有的收货地址
	public List<Address> getAllAddress(String uid);
}
