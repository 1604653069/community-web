package com.community.domain;

import com.alibaba.fastjson.annotation.JSONField;

/*购物车条目类*/
public class CartItem {
	//购物车条目
	private String iid;
	//购物车中物品的数量
	private int quantity;
	//单个购物条目的金额
	private double total;
	//购物条目中的物品
	private Product product;
	//附属于那个的购物车
	@JSONField(serialize=false)
	private Cart cart;
	
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		if(product!=null)
		total = product.getShopPrice()*quantity;
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
