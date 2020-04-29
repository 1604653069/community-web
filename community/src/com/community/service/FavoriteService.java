package com.community.service;

import com.community.domain.Favorite;
import com.community.domain.FavoriteItem;
import com.community.domain.User;

public interface FavoriteService {
	
	public Favorite getFavoriteByUid(String uid);
	
	public void addFavoriteItem(FavoriteItem item);
	
	public void removeFavoriteItem(FavoriteItem item);
	//为用户添加一个收藏夹
	public void addFavorite(Favorite favorite);
	
	public FavoriteItem getFavoriteItemByPid(String pid);

	public FavoriteItem getFavoriteItemByHid(String hid);
}
