package com.community.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.CartDao;
import com.community.domain.Cart;
import com.community.domain.CartItem;
import com.community.service.CartService;
@Transactional
public class CartServiceImpl implements CartService {

	private CartDao cartDao;
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	public Cart getCartByUid(String uid) {
		return cartDao.getCartByUid(uid);
	}

	public void addCartItem(CartItem cartItem) {
		cartDao.addCartItem(cartItem);
	}

	public void addCart(Cart cart) {
		cartDao.addCart(cart);
	}

}
