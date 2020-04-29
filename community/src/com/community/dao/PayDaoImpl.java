package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Pay;

public class PayDaoImpl extends HibernateDaoSupport implements PayDao {

	public List<Pay> getAllPays() {
		return (List<Pay>) this.getHibernateTemplate().find("from Pay");
	}

	public Pay getPayByPid(String pid) {
		List<Pay> Pays = (List<Pay>) this.getHibernateTemplate().find("from Pay where pid=?",pid);
		if(Pays!=null&& Pays.size()>0) {
			return Pays.get(0);
		}
		return null;
	}

	public void addPay(Pay pay) {
			this.getHibernateTemplate().save(pay);
	}

	public void update(Pay pay) {
			this.getHibernateTemplate().update(pay);
	}

	public void remove(Pay pay) {
			this.getHibernateTemplate().delete(pay);
	}

}
