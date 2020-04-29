package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Address;

public class AddressDaoIml extends HibernateDaoSupport implements AddressDao {

	public void addAddress(Address address) {
			this.getHibernateTemplate().save(address);
	}

	public void removeAddress(String aid) {
			this.getHibernateTemplate().delete(aid);
	}

	public void changeAddress(Address address) {
			this.getHibernateTemplate().update(address);
	}

	public List<Address> getAllAddress(String uid) {
		List<Address> address = (List<Address>) this.getHibernateTemplate().find("from Address where uid=?", uid);
		return address;
	}

}
