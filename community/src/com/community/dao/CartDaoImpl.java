package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Cart;
import com.community.domain.CartItem;

public class CartDaoImpl extends HibernateDaoSupport implements CartDao {

	//通过uid来获取购物车
	public Cart getCartByUid(String uid) {
		List<Cart> carts = (List<Cart>) this.getHibernateTemplate().find("from Cart where uid=?", uid);
		if(carts.size()>0) {
			return carts.get(0);
		}
		return null;
	}
	//添加购物条目
	public void addCartItem(CartItem cartItem) {
		this.getHibernateTemplate().save(cartItem);
	}
	//添加购物车
	public void addCart(Cart cart) {
		 this.getHibernateTemplate().save(cart);
	}

}
