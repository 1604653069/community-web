package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.community.domain.Favorite;
import com.community.domain.FavoriteItem;
import com.community.domain.User;

@Transactional
public class FavoriteDaoImpl extends HibernateDaoSupport implements FavoriteDao {

	public Favorite getFavoriteByUid(String uid) {
		 List<Favorite> result = (List<Favorite>) this.getHibernateTemplate().find("from Favorite where uid=?", uid);
		 if(result==null||result.size()==0) {
			 return null;
		 }else {
			 return result.get(0);
		 }
	}
	public void addFavoriteItem(FavoriteItem item) {
			this.getHibernateTemplate().saveOrUpdate(item);
	}
	public void removeFavoriteItem(FavoriteItem item) {
			this.getHibernateTemplate().delete(item);
	}
	public void addFavorite(Favorite favorite) {
			this.getHibernateTemplate().save(favorite);
	}
	public FavoriteItem getFavoriteItemByPid(String pid) {
		return (FavoriteItem) this.getHibernateTemplate().find("from FavoriteItem where pid=?", pid).get(0);
	}
	public FavoriteItem getFavoriteItemByHid(String hid) {
		return (FavoriteItem) this.getHibernateTemplate().find("from FavoriteItem where hid=?", hid).get(0);
	}
}
