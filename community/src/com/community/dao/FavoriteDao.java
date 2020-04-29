package com.community.dao;

import com.community.domain.Favorite;
import com.community.domain.FavoriteItem;
import com.community.domain.User;

public interface FavoriteDao {

	public Favorite getFavoriteByUid(String uid);
	
	public void addFavoriteItem(FavoriteItem item);
	
	public void removeFavoriteItem(FavoriteItem item);
	
	public void addFavorite(Favorite favorite);
	
	public FavoriteItem getFavoriteItemByPid(String pid);
	
	public FavoriteItem getFavoriteItemByHid(String hid);
}
