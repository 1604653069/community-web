package com.community.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.community.domain.RepairPhoto;
import com.community.service.PhotoService;
import com.opensymphony.xwork2.ActionSupport;

public class FileUpload  extends ActionSupport{
	private PhotoService photoService;
	private RepairPhoto repairPhoto;
	private String uid;
	private List<File> myFile;
	private List<String> myFileContextType;
	private List<String> myFileFileName;
	public void upload() { 
		System.out.println("有文件上传的请求..."+"上传的用户为："+uid);
		try {
		//文件上传总路径
		String path = ServletActionContext.getRequest().getRealPath("/upload");
		File dir = new File(path,uid);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		//用户上传图片的路径
		if(myFile!=null) {
			for(int i=0;i<myFile.size();i++) {
				File file = new File(dir,myFileFileName.get(i));
				FileUtils.copyFile(myFile.get(i), file);
			}
			System.out.println("文件上传成功...");
		}else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("文件上传失败");
			System.out.println("文件上传失败");
		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
}
