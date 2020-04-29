package com.community.dao;

import com.community.domain.Cart;
import com.community.domain.CartItem;

public interface CartDao {
	
	//通过用户的id来获取购物车
	public Cart getCartByUid(String uid);
	//添加购物车条目
	public void addCartItem(CartItem cartItem);
	//添加购物车
	public void addCart(Cart cart);
	
}
