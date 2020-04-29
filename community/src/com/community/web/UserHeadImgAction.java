package com.community.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.UserHeadImg;
import com.community.service.UserHeadImgService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserHeadImgAction extends ActionSupport implements ModelDriven<UserHeadImg>{
	private File myFile;
	private String myFileContextType;
	private String myFileFileName;
	private UserHeadImg userHeadImg = new UserHeadImg();
	private UserHeadImgService userHeadImgService;
	public void setUserHeadImgService(UserHeadImgService userHeadImgService) {
		this.userHeadImgService = userHeadImgService;
	}
	//获取用户的头像
	public void getUserHeadImg() {
		UserHeadImg userHeadImgByUid = getImg();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String headImgStr = JSON.toJSONString(userHeadImgByUid);
		try {
			System.out.println("用户头像"+headImgStr);
			response.getWriter().println(headImgStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//用户上传头像
	public void addUserHeadImg() {
		/* 先获取用户的头像 */
		UserHeadImg headImg = getImg();
		if(headImg==null) {
			//如果用户使用的是默认的头像，第一次修改头像时
			userHeadImgService.addHeadImg(userHeadImg);
		}
		try {
			//用户上传图片的路径
		if(myFile!=null) {
			//文件上传总路径
			String path = ServletActionContext.getRequest().getRealPath("/upload");
			File dir = new File(path,userHeadImg.getUser().getUid()+"/headImg");
			if(!dir.exists()) {
				dir.mkdirs();
			}
				File file = new File(dir,myFileFileName);
				//将上传的头像写入到磁盘中
				FileUtils.copyFile(myFile, file);
				//重新获取用户的头像
				headImg = getImg();
				/* 保修图片上传的路径 */
				headImg.setPath("http://39.105.68.228:8080/community/upload"+"/"+userHeadImg.getUser().getUid()+"/headImg"+"/"+myFileFileName);
				headImg.setUser(userHeadImg.getUser());
				userHeadImgService.updateUserImg(headImg);
				System.out.println("头像上传成功...");
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
	private UserHeadImg getImg() {
		return userHeadImgService.getUserHeadImgByUid(userHeadImg.getUser().getUid());
	}
	public UserHeadImg getModel() {
		return userHeadImg;
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
}
