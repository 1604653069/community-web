package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.OrderDao;
import com.community.domain.Order;
import com.community.service.OrderService;

@Transactional
public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public List<Order> getUserOrderByUid(String uid) {
		return orderDao.getUserOrderByUid(uid);
	}

	public void addOrder(Order order) {
		orderDao.addOrder(order);
	}

	public void removeOrder(Order order) {
		orderDao.removeOrder(order);
	}

	public List<Order> getAllOrder() {
		return orderDao.getAllOrder();
	}

	public Order getOrderByOid(String oid) {
		return orderDao.getOrderByOid(oid);
	}

	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}

}
