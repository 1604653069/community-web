package com.community.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Score;
import com.community.service.ScoreService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScoreAction extends ActionSupport implements ModelDriven<Score> {
	private Score score = new Score();
	private ScoreService  scoreService;	
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	//如果是新用户，则添加新的积分到数据库中
	public void addScore() {
		scoreService.addScore(score);
		System.out.println("添加积分成功");
	}
	//更新用户积分
	public void updateScore() {
		Score myScore = getScore();
		if(myScore==null) {
			addScore();
			myScore = getScore();
		}
		myScore.setScore(myScore.getScore()+(score.getScore()));
		System.out.println("该用户的积分为:"+score.toString());
		scoreService.updateScore(myScore);
		System.out.println("更新积分成功");
	}
	public void getUserScore() {
		Score scoreByUid = getScore();
		//如果是新的用户，则添加新的积分到数据库中
		if(scoreByUid==null) {
			addScore();
			scoreByUid = getScore();
		}
		try {
			String jsonString = JSON.toJSONString(scoreByUid);
			System.out.println("转换后的json数据为:"+jsonString);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
		} catch (Exception e) {
			
		}
		
	}
	public Score getScore() {
		return scoreService.getUserScoreByUid(score.getUser().getUid());
	}
	public Score getModel() {
		return score;
	}

}
