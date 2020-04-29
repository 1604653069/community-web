package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Order;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {
	
	public List<Order> getUserOrderByUid(String uid) {
		return (List<Order>) this.getHibernateTemplate().find("from Order where uid=?", uid);
	}

	public void addOrder(Order order) {
			this.getHibernateTemplate().save(order);
	}

	public void removeOrder(Order order) {
			this.getHibernateTemplate().delete(order);
	}

	//获取所有的订单
	public List<Order> getAllOrder() {
		return (List<Order>) this.getHibernateTemplate().find("from Order");
	}

	public Order getOrderByOid(String oid) {
		List<Order> order = (List<Order>) this.getHibernateTemplate().find("from Order where oid=?", oid);
		if(order!=null&&order.size()>0) {
			return order.get(0);
		}
		return null;
	}

	public void updateOrder(Order order) {
		this.getHibernateTemplate().update(order);
	}

}
