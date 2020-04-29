package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.PhotoDao;
import com.community.domain.RepairPhoto;
import com.community.service.PhotoService;

@Transactional
public class PhotoServiceImpl implements PhotoService {
	private PhotoDao photoDao;
	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}
	public void savePhotos(RepairPhoto photos) {
		photoDao.savePho(photos);
	}

}
