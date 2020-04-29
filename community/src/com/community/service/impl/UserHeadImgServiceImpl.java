package com.community.service.impl;

import com.community.dao.UserHeadImgDao;
import com.community.domain.UserHeadImg;
import com.community.service.UserHeadImgService;

public class UserHeadImgServiceImpl implements UserHeadImgService {
	private UserHeadImgDao userHeadImgDao;
	public void setUserHeadImgDao(UserHeadImgDao userHeadImgDao) {
		this.userHeadImgDao = userHeadImgDao;
	}
	public void addHeadImg(UserHeadImg img) {
			this.userHeadImgDao.addHeadImg(img);
	}
	public void updateUserImg(UserHeadImg img) {
			this.userHeadImgDao.updateUserImg(img);
	}
	public UserHeadImg getUserHeadImgByUid(String uid) {
		return this.userHeadImgDao.getUserHeadImgByUid(uid);
	}
}
