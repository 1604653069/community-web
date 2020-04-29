package com.community.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.community.domain.Test;
import com.community.service.TestService;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private File myFile;
	private String myFileContextType;
	private String myFileFileName;
	private TestService testService;
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	public void add() {
		System.out.println("添加数据成功");
		Test tes = new Test();
		testService.add(tes);
	}
	public void upload() {
		System.out.println("我被执行了");
		if(myFile!=null) {
			try {
				//文件上传总路径
				String path = ServletActionContext.getRequest().getRealPath("/upload");
				File dir = new File(path,"test");
				if(!dir.exists()) {
					dir.mkdirs();
				}
				//用户上传图片的路径
					File file = new File(dir,myFileFileName);
					FileUtils.copyFile(myFile, file);
					System.out.println("文件上传成功...");
				}catch (IOException e) {
					e.printStackTrace();
				}
		}
		else
			System.out.println("没有文件要上传");
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
