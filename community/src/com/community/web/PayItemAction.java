package com.community.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.PayItem;
import com.community.service.PayItemService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PayItemAction extends ActionSupport implements ModelDriven<PayItem>{
	private PayItem payItem = new PayItem();
	private PayItemService payItemService;
	public void setPayItemService(PayItemService payItemService) {
		this.payItemService = payItemService;
	}
	//获取用户缴费订单项
	public void getUserPayItem() {
		Map<String,Object> maps = new HashMap<String,Object>();
		PayItem payItem2 = getPayItem();
		maps.put("payItem",payItem2);
		write(maps);
	}
	//通过缴费订单和用户的uid进行查询，得出用户是否缴费
	public PayItem getPayItem() {
		System.out.println("pid:"+payItem.getPay().getPid());
		System.out.println("uid:"+payItem.getUser().getUid());
		PayItem payItemByPidAndUid = payItemService.getPayItemByPidAndUid(payItem);
		if(payItemByPidAndUid==null) {
			payItemService.addPayItem(payItem);
			payItemByPidAndUid = payItemService.getPayItemByPidAndUid(payItem);
			System.out.println("添加缴费订单项成功...");
		}
		return payItemByPidAndUid;
	}
	//修改订单项数据
	public void updatePayItem() {
			payItem.setDate(new Date());
			payItemService.updatePayItem(payItem);
			System.out.println("订单项数据修改成功...");
	}
	public void test() {
		System.out.println("我是测试数据..");
	}
	public PayItem getModel() {
		return payItem;
	}
	public void write(Map<String,Object> maps) {
		String string = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
			System.out.println("缴费订单项为:"+string);
			System.out.println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
