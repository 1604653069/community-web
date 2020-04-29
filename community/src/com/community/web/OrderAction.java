package com.community.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.community.domain.Order;
import com.community.domain.OrderItem;
import com.community.domain.Product;
import com.community.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	private Order order = new Order();
	private OrderService orderService;
	private List<Product> products;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void getUserOrder() {
		List<Order> orders = orderService.getUserOrderByUid(order.getUser().getUid());
		String jsonStr = JSON.toJSONString(orders);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
      		System.out.println("获取订单信息成功:"+jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addOrder() {
//		orderService.addOrder(order);
		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		for(Product product:products) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setProduct(product);
			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		orderService.addOrder(order);
		System.out.println("订单添加成功...");
	}
	public void getAllOrder() {
		Map<String,Object> maps = new HashMap<String,Object>();
		List<Order> allOrder = orderService.getAllOrder();
		if(allOrder!=null&&allOrder.size()>0) {
			maps.put("success",true);
			maps.put("orders",allOrder);
		}else {
			maps.put("success", false);
		}
		String jsonStr = JSON.toJSONString(maps,SerializerFeature.DisableCircularReferenceDetect);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
      		System.out.println("获取所有订单信息成功:"+jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("订单获取失败");
		}
	}
	public void getUserOrder2() {
		Map<String,Object>maps = new HashMap<String,Object>();
		Order myOrder= orderService.getOrderByOid(order.getOid());
		if(myOrder!=null) {
			maps.put("success",true);
			maps.put("orders",myOrder);
		}else {
			maps.put("success",false);
			System.out.println("订单信息获取失败");
		}
		String jsonStr = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
      		System.out.println("获取订单信息成功:"+jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
	public void updateOrder() {
		Map<String,Object> maps = new HashMap<String,Object>();
		try {
			Order orderByOid = orderService.getOrderByOid(order.getOid());
			orderByOid.setState(orderByOid.getState()+1);
			orderService.updateOrder(orderByOid);
			maps.put("success",true);
		} catch (Exception e) {
			maps.put("success",false);
			System.out.println(e.toString());
		}
		String jsonStr = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(jsonStr);
      		System.out.println("修改订单信息成功:"+jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Order getModel() {
		return order;
	}
}
