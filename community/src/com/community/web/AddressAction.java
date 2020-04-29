package com.community.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Address;
import com.community.service.AddressService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddressAction extends ActionSupport implements ModelDriven<Address>{

	private AddressService addressService;
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	private Address address = new Address();
	public void addAddress() {
		System.out.println("有人添加了地址，添加的地址为:"+address.toString());
		addressService.addAddress(address);
	}
	public void removeAddress() {
		addressService.removeAddress(address.getAid());
	}
	public void changeAddress() {
		System.out.println("有人想要修改地址诶~"+address.toString());
		addressService.changeAddress(address);
	}
	public void getAddress() {
		List<Address> allAddress = addressService.getAllAddress(address.getUser().getUid());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String address = JSON.toJSONString(allAddress);
		try {
			System.out.println("收货人的地址为:s"+address);
			response.getWriter().println(address);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void test() {
		System.out.println("我被执行了...");
	}
	@Override
	public Address getModel() {
		return address;
	}
}
