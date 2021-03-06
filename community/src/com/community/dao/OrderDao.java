package com.community.dao;

import java.util.List;

import com.community.domain.Order;

public interface OrderDao {

	public List<Order> getUserOrderByUid(String uid);
	
	public void addOrder(Order order);
	
	public void removeOrder(Order order);
	
	public List<Order> getAllOrder();
	
	public Order getOrderByOid(String oid);
	
	public void updateOrder(Order order);
}
