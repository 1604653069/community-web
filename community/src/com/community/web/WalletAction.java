package com.community.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.History;
import com.community.domain.Wallet;
import com.community.service.HistoryService;
import com.community.service.WalletService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WalletAction extends ActionSupport implements ModelDriven<Wallet>{
	private Wallet wallet = new Wallet();
	private WalletService walletService;
	private History history = new History();
	private HistoryService historyService;
	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	public void setWalletService(WalletService walletService) {
		this.walletService = walletService;
	}
	//用户充值接口
	public void chongzhi() {
		System.out.println("要充值用户的为:"+wallet.getUser().getUid());
		Wallet userWallet = walletService.getUserWalletByUid(wallet.getUser().getUid());
		if(userWallet==null) {
			createWallet();
			userWallet = walletService.getUserWalletByUid(wallet.getUser().getUid());
		}else {
			userWallet.setMoney(userWallet.getMoney()+wallet.getMoney());
			walletService.updateUserWallet(userWallet);
			history.setUser(wallet.getUser());
			history.setMoney(userWallet.getMoney());
			history.setTime(new Date());
			history.setBalance(wallet.getMoney());
			historyService.addHistory(history);
			System.out.println("用户充值成功");
		}
	}
	//获取用户余额
	public void getUserWallet() {
		System.out.println("用户的uid为："+wallet.getUser().getUid());
		Wallet userWallet = walletService.getUserWalletByUid(wallet.getUser().getUid());
		if(userWallet==null) {
			//如果是新的用户，没有使用钱包,则创建一个钱包
			createWallet();
			//重新获取用户的钱包
			userWallet = walletService.getUserWalletByUid(wallet.getUser().getUid());
		}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			String walletStr = JSON.toJSONString(userWallet);
			try {
				System.out.println("用户的余额为:"+walletStr);
				response.getWriter().println(walletStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("用户成功使用钱包功能");
	}
	private void createWallet() {
		Wallet wallet = new Wallet();
		wallet.setUser(this.wallet.getUser());
		walletService.createWallet(wallet);
		System.out.println("用户创建钱包成功");
	}
	public Wallet getModel() {
		return wallet;
	}
}
