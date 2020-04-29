package com.community.dao;

import java.util.List;

import com.community.domain.RepairPhoto;

public interface PhotoDao {

	//保存用户上传的图片
	public void savePho(RepairPhoto photos);
}
