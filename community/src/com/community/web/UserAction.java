package com.community.web;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Auth;
import com.community.domain.User;
import com.community.service.AuthService;
import com.community.service.UserService;
import com.community.test.Utils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private AuthService authService;
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login() throws IOException {
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("登陆的用户:"+user.toString());
		User loginUser = userService.login(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if(loginUser!=null) {
			map.put("user", loginUser);
			map.put("success",true);
			System.out.println("登陆成功");
			String string = JSON.toJSONString(loginUser);
			System.out.println("转化成json数据的格式:"+string);
			response.getWriter().println(string);
		}else {
			map.put("success",false);
			String string = JSON.toJSONString(map);
			response.getWriter().println(string);
			System.out.println("登陆失败 ");
		}
		return NONE;
	}
	
	public String login2() throws IOException {
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("登陆的用户:"+user.toString());
		User loginUser = userService.login(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if(loginUser!=null) {
			map.put("user", loginUser);
			map.put("success",true);
			System.out.println("登陆成功");
			String string = JSON.toJSONString(map);
			System.out.println("转化成json数据的格式:"+string);
			response.getWriter().println(string);
		}else {
			map.put("success",false);
			String string = JSON.toJSONString(map);
			response.getWriter().println(string);
			System.out.println("登陆失败 ");
		}
		return NONE;
	}
	
	public User getModel() {
		return user;
	}
	public void regist(){
		Map<String,Object> map = new HashMap<String,Object>();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		User findUserByUserName = userService.findUserByUserName(user.getUsername());
		User findUserByTel = userService.findUserByTel(user.getTel());
		if(findUserByUserName!=null)
		{
			map.put("success",false);
			map.put("message","用户名已存在");
		}else if(findUserByTel!=null) {
			map.put("success",false);
			map.put("message","手机号码已被绑定");
		}
		else {
				if(user.getName()==null) {
					user.setName(Utils.randomName(true, 4));
				}
				userService.addUser(user);
				Auth auth = new Auth();
				auth.setVillage("武夷小区");
				auth.setTel(user.getTel());
				auth.setUser(user);
				authService.addAuth(auth);
				map.put("success", true);
		}
		try {
			String string = JSON.toJSONString(map);
			response.getWriter().print(string);
			System.out.println("用户添加成功");
		} catch (Exception e) {
			map.put("success", false);
			map.put("message","服务器繁忙,请稍后再试");
			String string = JSON.toJSONString(map);
			try {
				response.getWriter().print(string);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("用户添加失败");
		}
	}
	public void getAllUsers() {
		Map<String,Object> map = new HashMap<String,Object>();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			List<User> allUsers = userService.getAllUsers();
			map.put("success", true);
			map.put("users",allUsers);
			String string = JSON.toJSONString(map);
			response.getWriter().print(string);
			System.out.println("获取所有用户成功");
		}catch (Exception e) {
			map.put("success", false);
			String string = JSON.toJSONString(map);
			try {
				response.getWriter().print(string);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("获取所有用户失败");
		}
	}
	//删除用户信息
	public void remove() {
		Map<String,Object> map = new HashMap<String,Object>();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			User findUserByUid = userService.findUserByUid(user.getUid());
			findUserByUid.setState("-1");
			userService.logOffUser(findUserByUid);
			map.put("success", true);
			String string = JSON.toJSONString(map);
			response.getWriter().print(string);
			System.out.println("删除用户成功");
		}catch (Exception e) {
			map.put("success", false);
			String string = JSON.toJSONString(map);
			try {
				response.getWriter().print(string);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("删除用户失败");
			System.out.println(e.toString());
		}
		
	}
	public void update() {
		Map<String,Object> map = new HashMap<String,Object>();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			User findUserByUid = userService.findUserByUid(user.getUid());
			findUserByUid.setUsername(user.getUsername());
			findUserByUid.setPassword(user.getPassword());
			findUserByUid.setSex(user.getSex());
			findUserByUid.setName(user.getName());
			findUserByUid.setTel(user.getTel());
			findUserByUid.setAddress(user.getAddress());
			findUserByUid.setType(user.getType());
			findUserByUid.setState(user.getState());
			userService.updateUser(findUserByUid);
			map.put("success", true);
			map.put("user",findUserByUid);
			String string = JSON.toJSONString(map);
			response.getWriter().print(string);
			System.out.println("更新用户成功");
		}catch (Exception e) {
			map.put("success", false);
			String string = JSON.toJSONString(map);
			try {
				response.getWriter().print(string);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("更新用户失败");
			System.out.println(e.toString());
		}
	}
	
	public void getUserByUid() {
		System.out.println(user.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			User findUserByUid = userService.findUserByUid(user.getUid());
			System.out.println(findUserByUid.toString());
			map.put("success", true);
			map.put("user",findUserByUid);
			String string = JSON.toJSONString(map);
			response.getWriter().print(string);
			System.out.println("获取用户成功");
		}catch (Exception e) {
			map.put("success", false);
			String string = JSON.toJSONString(map);
			try {
				response.getWriter().print(string);
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println(e1.toString());
			}
			System.out.println("获取用户失败");
			System.out.println(e.toString());
		}
	}
	public void forget() {
		Map<String,Object> map = new HashMap<String,Object>();
		User findUserByUid = userService.findUserByTel(user.getTel());
		if(findUserByUid==null) {
			map.put("success",false);
			map.put("message","该号码并未绑定");
		}else {
			findUserByUid.setPassword(user.getPassword());
			userService.updateUser(findUserByUid);
			map.put("success",true);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String string = JSON.toJSONString(map);
		try {
			response.getWriter().print(string);
		} catch (IOException e) {
			map.put("success",false);
			map.put("message","服务器繁忙,请稍后再试");
			e.printStackTrace();
			try {
				response.getWriter().print(string);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void getUserByTel() {
		Map<String,Object> map = new HashMap<String,Object>();
		User findUserByUid = userService.findUserByTel(user.getTel());
		if(findUserByUid==null) {
			map.put("success",false);
			map.put("message","该手机尚未注册与绑定");
		}else {
			map.put("success",true);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String string = JSON.toJSONString(map);
		try {
			response.getWriter().print(string);
		} catch (IOException e) {
			map.put("success",false);
			map.put("message","服务器繁忙,请稍后再试");
			e.printStackTrace();
			try {
				response.getWriter().print(string);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
