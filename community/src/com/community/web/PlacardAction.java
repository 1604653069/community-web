package com.community.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Placard;
import com.community.service.PlacardService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PlacardAction extends ActionSupport implements ModelDriven<Placard>{
	private Placard placard = new Placard();
	private PlacardService placardService;
	public void setPlacardService(PlacardService placardService) {
		this.placardService = placardService;
	}
	public void getList() throws IOException {
		List<Placard> datas = placardService.getList();
		String jsonString = JSON.toJSONString(datas);
		System.out.println("转换后的json数据为:"+jsonString);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(jsonString);
	}
	
	public void getAllNotices() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Placard> datas = placardService.getList();
		try {
			map.put("notices", datas);
			map.put("success", true);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
			System.out.println("获取所有的公告成功");
		}catch(Exception e){
			map.put("success", false);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			System.out.println("获取公告失败");
			try {
				response.getWriter().write(jsonString);
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println(e1.toString());
			}
			System.out.println(e.toString());
		}
		
	}
	public void addNotice() {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			placard.setDate(new Date());
			placard.setStitle(placard.getTitle());
			placardService.addPlacard(placard);
			map.put("success", true);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
			System.out.println("添加成功");
		}catch(Exception e) {
			map.put("success",false);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write(jsonString);
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println(e1.toString());
			}
			System.out.println("添加失败"+e.toString());
		}
			
	}
	public void remove() {
		System.out.println("要删除的pid为:"+placard.getPid());
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map.put("success", true);
			placardService.removePlacard(placard);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
			System.out.println("删除成功");
		} catch (Exception e) {
			map.put("success", false);
			placardService.removePlacard(placard);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write(jsonString);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("删除失败");
		}
	
	}
	
	public void update() {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Placard myPlacard = placardService.getPlacardByPid(placard.getPid());
			myPlacard.setContent(placard.getContent());
			myPlacard.setTitle(placard.getTitle());
			myPlacard.setType(placard.getType());
			myPlacard.setDate(placard.getDate());
			placardService.updatePlacard(myPlacard);
			map.put("success",true);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
			System.out.println("更新成功");
		}catch (Exception e) {
			map.put("success",false);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write(jsonString);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("更新失败");
		}
	}
	
	public void getNotice() {
		System.out.println("上传的数据为:"+placard.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Placard placardByPid = placardService.getPlacardByPid(placard.getPid());
			System.out.println("数据库中的数据为:"+placardByPid.toString());
			map.put("success",true);
			map.put("notice",placardByPid);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
			System.out.println("更新成功");
		}catch (Exception e) {
			map.put("success",false);
			String jsonString = JSON.toJSONString(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write(jsonString);
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println(e1.toString());
			}
			System.out.println(e.toString());
		}
		 
	}
	public Placard getModel() {
		return placard;
	}
	
}
