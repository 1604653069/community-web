package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Auth;

public class AuthDaoImpl extends HibernateDaoSupport implements AuthDao {

	public List<Auth> getAllAuth() {
			List<Auth> auths = (List<Auth>) this.getHibernateTemplate().find("from Auth");
			if(auths.size()>0&&auths!=null)
				return auths;
			return null;
	}

	public Auth getAllAuthByAid(String aid) {
		List<Auth> auths = (List<Auth>) this.getHibernateTemplate().find("from Auth where aid=?", aid);
		if(auths.size()>0&&auths!=null)
			return auths.get(0);
		return null;
	}

	public void updateAuth(Auth auth) {
			this.getHibernateTemplate().update(auth);
	}

	public Auth getAuthByUid(String uid) {
		List<Auth> auths = (List<Auth>) this.getHibernateTemplate().find("from Auth where user.uid=?", uid);
		if(auths.size()>0&&auths!=null)
			return auths.get(0);
		return null;
	}

	public void addAuth(Auth auth) {
		 this.getHibernateTemplate().save(auth);
	}

}
