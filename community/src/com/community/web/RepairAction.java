package com.community.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.community.domain.Auth;
import com.community.domain.Repair;
import com.community.domain.RepairPhoto;
import com.community.service.AuthService;
import com.community.service.PhotoService;
import com.community.service.RepairService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/** 报事提交接口
 * @author Hong
 *
 */
public class RepairAction extends ActionSupport implements ModelDriven<Repair>{
	private List<File> myFile;
	private List<String> myFileContextType;
	private List<String> myFileFileName;
	private RepairService repairService;
	private PhotoService photoService;
	private AuthService authService;
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	public void setRepairService(RepairService repairService) {
		this.repairService = repairService;
	} 
	private Repair repair = new Repair();
	//提交修理报事接口	
	public void commitRepair() {
		System.out.println("客户端上传的数据为:"+repair.toString());
		//保存报修订单
		repairService.commitRepair(repair);
		//保存图片
		try {
			//用户上传图片的路径
		if(myFile!=null) {
			System.out.println("有文件上传的请求..."+"上传的用户为："+repair.getUser().getUid());
			//文件上传总路径
			String path = ServletActionContext.getRequest().getRealPath("/upload");
			File dir = new File(path,repair.getUser().getUid()+"/repair");
			if(!dir.exists()) {
				dir.mkdirs();
			}
			for(int i=0;i<myFile.size();i++) {
				File file = new File(dir,myFileFileName.get(i));
				FileUtils.copyFile(myFile.get(i), file);
				//将上传的图片的路径保存到数据库中
				RepairPhoto photo = new RepairPhoto();
				/* 保修图片上传的路径 */
				photo.setPath("http://39.105.68.228:8080/community/upload"+"/"+repair.getUser().getUid()+"/repair"+"/"+myFileFileName.get(i));
				photo.setRepair(repair);
				photoService.savePhotos(photo);
			}
			System.out.println("文件上传成功...");
		}else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("文件上传失败");
			System.out.println("没有文件上传，或者文件上传失败");
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获取所有的报事维修订单
	public void getAllRepairs() {
			Map<String,Object> maps = new HashMap<String,Object>();
			List<Repair> allRepair = repairService.getAllRepair();
			if(allRepair!=null) {
				maps.put("success", true);
				maps.put("repairs",allRepair);
			}else {
				maps.put("success",false);
			}
			String jsonString = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write(jsonString);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(jsonString);
			System.out.println("获取报事订单成功!");
	}
	
	public void getRepairByRid() {
		Map<String,Object> maps = new HashMap<String,Object>();
		 Repair repairByRid = repairService.getRepairByRid(repair.getRid());
		if(repairByRid!=null) {
			maps.put("success", true);
			maps.put("repair",repairByRid);
		}else {
			maps.put("success",false);
		}
		String jsonString = JSON.toJSONString(maps,SerializerFeature.DisableCircularReferenceDetect);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(jsonString);
		System.out.println("获取单个报事订单成功!");
	}
	public void update() {
		Map<String,Object> maps = new HashMap<String,Object>();
		try {
			Repair repairByRid = repairService.getRepairByRid(repair.getRid());
			repairByRid.setState(1);
			repairService.updateRepair(repairByRid);
			maps.put("success", true);
			String jsonString = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
		} catch (Exception e) {
			maps.put("success", false);
			String jsonString = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write(jsonString);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("更新失败");
		}
		System.out.println("更新成功...");
		
	}
	public void update2() {
		Map<String,Object> maps = new HashMap<String,Object>();
		try {
			Repair repairByRid = repairService.getRepairByRid(repair.getRid());
			repairByRid.setState(2);
			repairService.updateRepair(repairByRid);
			maps.put("success", true);
			String jsonString = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
		} catch (Exception e) {
			maps.put("success", false);
			String jsonString = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write(jsonString);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("更新失败");
		}
		System.out.println("更新成功...");
		
	}
	//获取用户所有的保修订单
	public void getUserAllRepair() {
		Map<String,Object> maps = new HashMap<String,Object>();
		List<Repair> userAllRepairByUid = repairService.getUserAllRepairByUid(repair.getUser().getUid());
		if(userAllRepairByUid!=null) {
			maps.put("success",true);
			maps.put("repairs",userAllRepairByUid);
		}else {
			maps.put("success",false);
		}
		String jsonString = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Repair getModel() {
		return repair;
	}
	public List<File> getMyFile() {
		return myFile;
	}
	public void setMyFile(List<File> myFile) {
		this.myFile = myFile;
	}
	public List<String> getMyFileContextType() {
		return myFileContextType;
	}
	public void setMyFileContextType(List<String> myFileContextType) {
		this.myFileContextType = myFileContextType;
	}
	public List<String> getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(List<String> myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
}
