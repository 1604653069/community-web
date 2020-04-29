package com.community.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Test;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {
	public void add(Test test) {
		this.getHibernateTemplate().save(test);
	}

}
