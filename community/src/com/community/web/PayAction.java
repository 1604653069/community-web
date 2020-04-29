package com.community.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Pay;
import com.community.service.PayService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PayAction extends ActionSupport implements ModelDriven<Pay>{

	private Pay pay = new Pay();
	private PayService payService;
	public void setPayService(PayService payService) {
		this.payService = payService;
	}
	public void addPay() {
		Map<String,Object> maps = new HashMap<String,Object>();
		try {
			pay.setCommitDate(new Date());
			payService.addPay(pay);
			maps.put("success",true);
		} catch (Exception e) {
			maps.put("success",false);
		}
		write(maps);
	}
	public void getAllPays() {
		Map<String,Object> maps = new HashMap<String,Object>();
		List<Pay> allPays = payService.getAllPays();
		if(allPays!=null&&allPays.size()>0) {
			maps.put("success",true);
			maps.put("pays",allPays);
			System.out.println("获取所有的缴费订单成功");
		}else {
			maps.put("success",false);
		}
		write(maps);
	}
	public void remove() {
		Map<String,Object> maps = new HashMap<String,Object>();
		if(pay.getPid()!=null&&pay.getPid().length()>0) {
			Pay payByPid = payService.getPayByPid(pay.getPid());
			if(payByPid!=null) {
				payService.remove(payByPid);
				maps.put("success",true);
			}
		}else
			maps.put("success",false);
		write(maps);
	}
	public void getPayByPid() {
		Map<String,Object> maps = new HashMap<String,Object>();
		if(pay.getPid()!=null&&pay.getPid().length()>0) {
			Pay payByPid = payService.getPayByPid(pay.getPid());
			if(payByPid!=null) {
				maps.put("success",true);
				maps.put("pay",payByPid);
			}
		}else
			maps.put("success",false);
		write(maps);
	}
	public void updatePay() {
		Map<String,Object> maps = new HashMap<String,Object>();
		if(pay.getPid()!=null&&pay.getPid().length()>0) {
			try {
				payService.update(pay);
				maps.put("success",true);
			} catch (Exception e) {
				maps.put("success",false);
			}
		}else
			maps.put("success",false);
		write(maps);
	}
	public Pay getModel() {
		return pay;
	}
	public void write(Map<String,Object> maps) {
		String string = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
			System.out.println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
