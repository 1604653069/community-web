package com.community.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.community.domain.SSImg;

public class SSImgDaoImpl extends HibernateDaoSupport implements SSImgDao {
	public void uploadImg(SSImg ssImg) {
		this.getHibernateTemplate().save(ssImg);
	}
}
