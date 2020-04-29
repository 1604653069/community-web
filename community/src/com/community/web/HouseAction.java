package com.community.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.House;
import com.community.domain.HouseImg;
import com.community.service.HouseImgService;
import com.community.service.HouseService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HouseAction extends ActionSupport implements ModelDriven<House>{
	private House house = new House();	
	private File myFile;
	private String myFileContextType;
	private String myFileFileName;
	private HouseImgService houseImgService;
	private HouseService houseService;
	private int price;
	private Integer type2;
	private Set<HouseImg> houseImgs =new HashSet<HouseImg>();
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	public void setHouseImgService(HouseImgService houseImgService) {
		this.houseImgService = houseImgService;
	}

	public void getAllHouseInfo() throws IOException {
		List<House> allHouseInfo = houseService.getAllHouseInfo();
		String houseInfo = JSON.toJSONString(allHouseInfo);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(houseInfo);
			System.out.println("获取购物车信息成功:"+houseInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加房屋消息
	public void addHouse() {
		System.out.println(house.toString());
		house.setDate(new Date());
		houseService.addHouse(house);
		System.out.println("房屋信息添加成功");
		if(myFile!=null) {
			System.out.println("上传的商品有图片信息");
			try {
				String dirStr="";
				//文件上传总路径
				String path = ServletActionContext.getRequest().getRealPath("/house");
				File dir = new File(path,dirStr);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				//用户上传图片的路径
					File file = new File(dir,myFileFileName);
					FileUtils.copyFile(myFile, file);
					System.out.println("文件上传成功...");
					HouseImg houseImage = new HouseImg();
					houseImage.setHouse(house);
					houseImage.setPath("http://192.168.1.106:8080/community/house/"+myFileFileName);
					houseImgService.addHouseImg(houseImage);
					System.out.println("上传图片保存成功");
			}catch (IOException e) {
					e.printStackTrace();
					System.out.println("房屋信息添加失败");
				}
		}
	}
	public void getAllHouseInfo2() throws IOException {
		Map<String,Object> maps = new HashMap<String,Object>();
		List<House> allHouseInfo = houseService.getAllHouseInfo();
		if(allHouseInfo.size()>0&&allHouseInfo!=null) {
			maps.put("success",true);
			maps.put("houses",allHouseInfo);
		}else {
			maps.put("success",false);
		}
		String houseInfo = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(houseInfo);
			System.out.println("获取房屋信息成功:"+houseInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获取当个房屋信息
	public void getHouse() {
		Map<String,Object> maps=  new HashMap<String,Object>();
		House houseByHid = houseService.getHouseByHid(house.getHid());
		if(houseByHid!=null) {
			maps.put("success",true);
			maps.put("house",houseByHid);
		}else {
			maps.put("success",false);
		}
		String houseInfo = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(houseInfo);
			System.out.println("获取房屋信息成功:"+houseInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//修改房屋消息
	public void updateHouse() {
		Map<String,Object> maps = new HashMap<String,Object>();
		try {
			System.out.println("要修改的房屋信息为："+house.toString());
			House houseByHid = houseService.getHouseByHid(house.getHid());
			houseByHid.setAddress(house.getAddress());
			houseByHid.setArea(house.getArea());
			houseByHid.setDate(house.getDate());
			houseByHid.setDetailed(house.getDetailed());
			houseByHid.setRent(house.getRent());
			houseByHid.setTitle(house.getTitle());
			houseByHid.setType(house.getType());
			houseService.updateHouse(houseByHid);
			maps.put("success",true);
			System.out.println("房屋信息修改成功");
		} catch (Exception e) {
			System.out.println("房屋信息修改失败");
			maps.put("success",false);
			System.out.println(e.toString());
		}
		String houseInfo = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(houseInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void getHouseBySort() {
		System.out.println("type:"+type2);
		Map<String,Object> maps = new HashMap<String,Object>();
		String hql="from House ";
		if(price!=0&&type2==null) {
			hql+="where rent<="+price;
		}else if(price==0&&type2!=null) {
			hql+="where type="+type2;
		}else if(price!=0&&type2!=null) {
			hql+="where rent<="+price+" and type="+type2;
		}
		System.out.println(hql);
		List<House> houseBySort = houseService.getHouseBySort(hql);
		if(houseBySort!=null) {
			maps.put("success",true);
			maps.put("houses",houseBySort);
		}else {
			maps.put("success",false);
		}
		String houseInfo = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(houseInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//删除房屋消息
	public void removeHouse() {
	}
	
	public House getModel() {
		return house;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContextType() {
		return myFileContextType;
	}
	public void setMyFileContextType(String myFileContextType) {
		this.myFileContextType = myFileContextType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Integer getType2() {
		return type2;
	}
	public void setType2(Integer type2) {
		this.type2 = type2;
	}
}
