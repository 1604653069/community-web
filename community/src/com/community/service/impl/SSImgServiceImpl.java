package com.community.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.SSImgDao;
import com.community.domain.SSImg;
import com.community.service.SSImgService;

@Transactional
public class SSImgServiceImpl implements SSImgService {
	private SSImgDao ssImgDao;
	public void setSsImgDao(SSImgDao ssImgDao) {
		this.ssImgDao = ssImgDao;
	}
	public void uploadSSImg(SSImg ssImg) {
		ssImgDao.uploadImg(ssImg);
	}
}
