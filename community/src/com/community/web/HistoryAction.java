package com.community.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.History;
import com.community.service.HistoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HistoryAction extends ActionSupport implements ModelDriven<History>{
	private History history = new History();
	private HistoryService historyService;
	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	public void getAllUserHistory() {
		//获取该用户的所有充值记录
		List<History> allHistoryByUid = historyService.getAllHistoryByUid(history.getUser().getUid());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String historyStr = JSON.toJSONString(allHistoryByUid);
		try {
			System.out.println("用户的充值记录为:"+historyStr);
			response.getWriter().println(historyStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public History getModel() {
		return history;
	}

}
