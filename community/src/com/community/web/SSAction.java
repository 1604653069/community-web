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
import com.community.domain.SS;
import com.community.domain.SSImg;
import com.community.service.SSImgService;
import com.community.service.SSService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SSAction extends ActionSupport implements ModelDriven<SS> {
	/* 发表说说的实体 */
	private SS ss = new SS();
	/* 说说的业务层 */
	private SSService ssService;
	private SSImgService ssImgService;
	public void setSsImgService(SSImgService ssImgService) {
		this.ssImgService = ssImgService;
	}
	/* 说说上传的图片 */
	private List<File> myFile;
	private List<String> myFileContextType;
	private List<String> myFileFileName;

	public void setSsService(SSService ssService) {
		this.ssService = ssService;
	}

	/* 获取所有说说 */
	public void findAllSS() {
		List<SS> mySSs = ssService.findAllSS();
		String string = JSON.toJSONString(mySSs);
		System.out.println("所有的说说:" + string);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("获取所有的说说成功");
	}
	
	public void findAllTalks() {
		Map<String,Object> maps = new HashMap<String,Object>();
		List<SS> mySSs = ssService.findAllSS();
		if(mySSs!=null&mySSs.size()>0) {
			maps.put("success", true);
			maps.put("ss", mySSs);
			String string = JSON.toJSONString(maps);
			System.out.println("所有的说说:" + string);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().println(string);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("获取所有的说说成功");
		}else {
			maps.put("success", false);
			String string = JSON.toJSONString(maps);
			System.out.println("所有的说说:" + string);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().println(string);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("获取说说失败");
		}
		
	}
	
	/* 发表说说 */
	public void addSS() {
		/* 保存说说 */
		System.out.println("有人发表说说了耶~");
		ssService.addSS(ss);
		System.out.println("说说发表成功!");
		/* 如果说说中有上传图片 */
		try {
			if (myFile != null) {
				// 文件上传总路径
				String path = ServletActionContext.getRequest().getRealPath("/upload");
				System.out.println("说说发表的人为:" + ss.getUser().getUid());
				File dir = new File(path, ss.getUser().getUid() + "/ss/"+ss.getSid());
				if (!dir.exists()) {
					dir.mkdirs();
				}
				for (int i = 0; i < myFile.size(); i++) {
					File file = new File(dir, myFileFileName.get(i));
					FileUtils.copyFile(myFile.get(i), file);
					// 将上传的图片的路径保存到数据库中
					SSImg ssImg = new SSImg();
					ssImg.setPath("http://39.105.68.228:8080/community/upload"+"/"+ss.getUser().getUid()+"/ss"+"/"+ss.getSid()+"/"+myFileFileName.get(i));
					ssImg.setSs(ss); 
					/* 将上传图片的路径保存在数据库中 */
					ssImgService.uploadSSImg(ssImg);
				}
				System.out.println("图片上传成功...");
			}
		} catch (Exception e) {
			System.out.println("图片上传失败...");
		}
	}
	/* 删除说说 */
	public void removeSS() {
		Map<String,Object> maps = new HashMap<String,Object>();
		try {
			SS ssBySid = ssService.getSSBySid(ss.getSid());
			ssService.removeSS(ssBySid);
			maps.put("success", true);
			String string = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(string);
			System.out.println("删除说说成功");
		}catch (Exception e) {
			maps.put("success", false);
			String string = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().println(string);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("说说删除失败");
		}
		
	}

	public void getSSByUid(){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<SS> userSSByUid = ssService.getUserSSByUid(ss.getUser().getUid());
		if(userSSByUid!=null) {
			maps.put("success",true);
			maps.put("ss",userSSByUid);
		}else {
			maps.put("success",false);
		}
		String string = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
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
	@Override
	public SS getModel() {
		return ss;
	}

}
