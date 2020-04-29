package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.community.domain.UserHeadImg;

@Transactional
public class UserHeadImgDaoImpl extends HibernateDaoSupport implements UserHeadImgDao {
	
	public void addHeadImg(UserHeadImg img) {
		this.getHibernateTemplate().save(img);
	}

	public void updateUserImg(UserHeadImg img) {
		this.getHibernateTemplate().update(img);
	}

	public UserHeadImg getUserHeadImgByUid(String uid) {
		List<UserHeadImg> userHeadImgs = (List<UserHeadImg>) this.getHibernateTemplate().find("from UserHeadImg where uid=?", uid);
		if(userHeadImgs!=null&&userHeadImgs.size()>0) {
			return userHeadImgs.get(0);
		}
		return null;
	}

}
