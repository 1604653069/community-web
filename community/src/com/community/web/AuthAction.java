package com.community.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Auth;
import com.community.service.AuthService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AuthAction extends ActionSupport implements ModelDriven<Auth> {
	private Auth auth = new Auth();
	private String uid;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	private AuthService authService;
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	public void getAllAuth() {
		Map<String,Object> maps = new HashMap<String,Object>();
		List<Auth> allAuth = authService.getAllAuth();
		if(allAuth!=null&&allAuth.size()>0) {
			maps.put("success",true);
			maps.put("auths",allAuth);
		}else {
			maps.put("success",false);
		}
		write(maps);
	}
	//客户端提交认证信息
	public void addAuth() {
		Map<String,Object> maps = new HashMap<String,Object>();
		Auth auth2 = getAuth();
		if(auth2!=null) {
			maps.put("success",true);
			maps.put("auth",auth2);
			System.out.println("添加认证信息成功");
		}else {
			maps.put("success",false);
			System.out.println("添加认证信息失败");
		}
		write(maps);
	}
	public Auth getAuth() {
		Auth authByUid = authService.getAuthByUid(auth.getUser().getUid());
		if(authByUid==null) {
			authService.addAuth(auth);
			authByUid = authService.getAuthByUid(auth.getUser().getUid());
		}
		return authByUid;
	}
	public void getMyAuth() {
		Map<String,Object> maps = new HashMap<String,Object>();
		Auth authByUid = getAuth();
		if(authByUid==null) {
			maps.put("success", false);
		}else {
			maps.put("success", true);
			maps.put("auth",authByUid);
		}
		write(maps);
	}
	public void update() {
		Map<String,Object> maps = new HashMap<String,Object>();
		Auth authByUid = authService.getAuthByUid(uid);
		if(authByUid!=null) {
			maps.put("success",true);
			authByUid.setState(authByUid.getState()+1);
			authService.updateAuth(authByUid);
		}else {
			maps.put("success",false);
		}
		write(maps);
	}
	public void update2() {
		Map<String,Object> maps = new HashMap<String,Object>();
		Auth authByUid = authService.getAuthByUid(uid);
		if(authByUid!=null) {
			maps.put("success",true);
			authByUid.setAddress(auth.getAddress());
			authByUid.setName(auth.getName());
			authByUid.setTel(auth.getTel());
			authByUid.setVillage(auth.getVillage());
			authByUid.setState(authByUid.getState()+1);
			authService.updateAuth(authByUid);
		}else {
			maps.put("success",false);
		}
		write(maps);
	}
	public void getUserAuth() {
		Map<String,Object> maps = new HashMap<String,Object>();
		Auth authByUid = authService.getAuthByUid(uid);
		if(authByUid!=null) {
			maps.put("success",true);
			maps.put("auth",authByUid);
		}else {
			maps.put("success",false);
		}
		write(maps);
	}
	public Auth getModel() {
		return auth;
	}
	public void write(Map<String,Object> maps) {
		String string = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
			System.out.println("认证信息为:"+string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
