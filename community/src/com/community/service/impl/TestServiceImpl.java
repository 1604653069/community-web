package com.community.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.TestDao;
import com.community.domain.Test;

@Transactional
public class TestServiceImpl implements com.community.service.TestService {
	private TestDao testDao;
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	@Override
	public void add(Test test) {
		testDao.add(test);
	}

}
