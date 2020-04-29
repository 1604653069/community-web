package com.community.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Favorite;
import com.community.domain.FavoriteItem;
import com.community.domain.House;
import com.community.domain.Product;
import com.community.domain.User;
import com.community.service.FavoriteService;
import com.community.service.HouseService;
import com.community.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FavoriteAction extends ActionSupport implements ModelDriven<FavoriteItem>{
	private FavoriteItem favoriteItem = new FavoriteItem();
	private ProductService productService;
	private HouseService houseService;
	private FavoriteService favoriteService;
	private User user;
	public void setUser(User user) {
		this.user = user;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	public void setFavoriteService(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	public void addFavoriteItem() {
		Favorite favorite = getFavorite();
		if(favorite==null) {
			//如果用户还没有收藏夹，则创建一个收藏夹
			createFavorite();
			//重新获取一次收藏夹
			favorite = getFavorite();
		}
		if(favoriteItem.getType()==0) {
			//如果收藏的是商品
			Product product = productService.findProductByPid(favoriteItem.getProduct().getPid());
			System.out.println("收藏的商品为:"+product.toString());
			favoriteItem.setProduct(product);
		}else if(favoriteItem.getType()==1) {
			//如果收藏的是房屋
			House house = houseService.getHouseByHid(favoriteItem.getHouse().getHid());
			favoriteItem.setHouse(house);
		}
		favoriteItem.setFavorite(favorite);
		favoriteService.addFavoriteItem(favoriteItem);
		System.out.println("上传的type值为:"+favoriteItem.getType());
		System.out.println("收藏成功...");
	}
	public void removeFavoriteItem() {
		FavoriteItem favoriteItem = null;
		if(this.favoriteItem.getType()==0) {
			 favoriteItem = favoriteService.getFavoriteItemByPid(this.favoriteItem.getProduct().getPid());
		}else if(this.favoriteItem.getType()==1) {
			favoriteItem = favoriteService.getFavoriteItemByHid(this.favoriteItem.getHouse().getHid());
		}
		favoriteService.removeFavoriteItem(favoriteItem);
		System.out.println("删除已收藏的信息");
	}
	//获取收藏夹信息
	public void getFavoriteInfo() {
		Favorite favorite = getFavorite();
		if(favorite==null) {
			createFavorite();
			//重新获取一次收藏夹
			favorite = getFavorite();
		}
		String favoriteStr = JSON.toJSONString(favorite);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(favoriteStr);
      		System.out.println("获取收藏信息成功:"+favoriteStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//创建一个收藏夹
	public void createFavorite() {
			Favorite favorite = new Favorite();
			favorite.setUser(user);
			favoriteService.addFavorite(favorite);
			System.out.println("创建收藏建成功");
	}
	
	public Favorite getFavorite() {
		return favoriteService.getFavoriteByUid(user.getUid());
	}
	public FavoriteItem getModel() {
		return favoriteItem;
	}
}
