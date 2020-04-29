package com.community.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Cart;
import com.community.domain.CartItem;
import com.community.domain.Product;
import com.community.domain.User;
import com.community.service.CartService;
import com.community.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CartAction extends ActionSupport implements ModelDriven<CartItem> {
	/* 购物车清单 */
	private CartItem cartItem = new CartItem();
	/* 购物车服务类 */
	private CartService cartService;
	private ProductService productService;
	/* 加购的用户 */
	private User user;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	/* 添加购物车清单 */
	public void addCartItem() {
		/* 添加之前要先获取或者创建购物车 */
		/* 如果没有购物车则创建 */
		Cart cart2 = getCartByUid();
		if(cart2==null) {
			System.out.println("用户没有购物车，需要创建购物车");
			createCart();
		}
		//获取加购的商品
		Product product = productService.findProductByPid(cartItem.getProduct().getPid());
		cartItem.setProduct(product);
		Cart cart = getCartByUid();
		cartItem.setCart(cart);
		System.out.println(cartItem);
		cartService.addCartItem(cartItem);
		System.out.println("成功添加购物车");
	}

	/* 获取购物车中的信息 */
	public void getCartInfo() {
		System.out.println(user.toString());
		Cart cart = getCartByUid();
		//如果用户没有购物车，则创建一个购物车
		if(cart==null) {
			createCart();
			cart = getCartByUid();
		}
		String cartStr = JSON.toJSONString(cart);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(cartStr);
      		System.out.println("获取购物车信息成功:"+cartStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* 创建购物车 */
	public void createCart() {
		Cart cart = new Cart();
		cart.setUser(user);
		cartService.addCart(cart);
		System.out.println("用户添加购物车成功");
	}
	/* 用户用户的购物车 */
	public Cart getCartByUid() {
		return cartService.getCartByUid(user.getUid());
	}
	/* 创建购物车 */
	public CartItem getModel() {
		return cartItem;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void test() {
		System.out.println("我是测试数据");
	}
}

