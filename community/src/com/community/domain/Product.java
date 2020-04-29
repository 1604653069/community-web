package com.community.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/*商品实体类*/
public class Product {
	/* 商品id */
	private String pid;
	/* 商品名称 */
	private String pname;
	/* 市场价格 */
	private double marketPrice;
	/* 商城价格 */
	private double shopPrice;
	/* 图片地址 */
	private String pImage;
	/* 商品日期 */
	@JSONField(format = "yyyy-MM-dd")
	private Date pdate;
	/* 是否是热销产品 */
	private int isHot;
	/* 商品的详细信息 */
	private String pdesc;
	/* 商品是否下架 */
	private int pflag;
	/* 商品的类型 */
	private int type;
//	/* 一对一 */
//	@JSONField(serialize=false)
//	private CartItem cartItem;
	public Product() {
		super();
	}
	public Product(String pid, String pname, double marketPrice, double shopPrice, String pImage, Date pdate, int isHot,
			String pdesc, int pflag,int type) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.marketPrice = marketPrice;
		this.shopPrice = shopPrice;
		this.pImage = pImage;
		this.pdate = pdate;
		this.isHot = isHot;
		this.pdesc = pdesc;
		this.pflag = pflag;
		this.type = type;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public double getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getIsHot() {
		return isHot;
	}
	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
//	public CartItem getCartItem() {
//		return cartItem;
//	}
//	public void setCartItem(CartItem cartItem) {
//		this.cartItem = cartItem;
//	}
//	@Override
//	public String toString() {
//		return "Product [pid=" + pid + ", pname=" + pname + ", marketPrice=" + marketPrice + ", shopPrice=" + shopPrice
//				+ ", pImage=" + pImage + ", pdate=" + pdate + ", isHot=" + isHot + ", pdesc=" + pdesc + ", pflag="
//				+ pflag + ", type=" + type + ", cartItem=" + cartItem + "]";
//	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", marketPrice=" + marketPrice + ", shopPrice=" + shopPrice
				+ ", pImage=" + pImage + ", pdate=" + pdate + ", isHot=" + isHot + ", pdesc=" + pdesc + ", pflag="
				+ pflag + ", type=" + type + "]";
	}
}
