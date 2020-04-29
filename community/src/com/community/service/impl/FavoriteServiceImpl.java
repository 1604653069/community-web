package com.community.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.FavoriteDao;
import com.community.domain.Favorite;
import com.community.domain.FavoriteItem;
import com.community.domain.User;
import com.community.service.FavoriteService;
@Transactional
public class FavoriteServiceImpl implements FavoriteService{
	private FavoriteDao favoriteDao;
	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}
	public Favorite getFavoriteByUid(String uid) {
		return favoriteDao.getFavoriteByUid(uid);
	}

	public void addFavoriteItem(FavoriteItem item) {
			favoriteDao.addFavoriteItem(item);
	}

	public void removeFavoriteItem(FavoriteItem item) {
			favoriteDao.removeFavoriteItem(item);
	}
	public void addFavorite(Favorite favorite) {
			favoriteDao.addFavorite(favorite);
	}
	public FavoriteItem getFavoriteItemByPid(String fiid) {
		return favoriteDao.getFavoriteItemByPid(fiid);
	}
	public FavoriteItem getFavoriteItemByHid(String hid) {
		return favoriteDao.getFavoriteItemByHid(hid);
	}

}
