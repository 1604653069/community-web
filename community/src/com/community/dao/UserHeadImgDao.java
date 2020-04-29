package com.community.dao;

import com.community.domain.UserHeadImg;

public interface UserHeadImgDao {
	//添加用户头像
	public void addHeadImg(UserHeadImg img);
	//修改用户头像
	public void updateUserImg(UserHeadImg img);
	//获取用户头像
	public UserHeadImg getUserHeadImgByUid(String uid);
}
