package com.community.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.community.domain.Product;
import com.community.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private Product product = new Product();
	/* 商品上传的图片 */
	private File myFile;
	private String myFileContextType;
	private String myFileFileName;
	
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	/* 获取所有的商品信息 */
	public void getAllProduct() {
		List<Product> allProduct = productService.findAllProduct();
		String string = JSON.toJSONString(allProduct);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
			System.out.println("获取所有的商品信息成功:"+string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* 获取所有的热销信息 */
	public void getAllHotProduct() {
		List<Product> allProduct = productService.findAllHotProduct();
		String string = JSON.toJSONString(allProduct);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
			System.out.println("获取所有的热卖商品信息成功:"+string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* 获取启动界面的商品信息 */
	public void getStartUpShops() {
		Map<String,List<Product>> shops = new HashMap<String,List<Product>>();
		List<Product> hotShops = productService.findAllHotProduct();
		/*随机推荐商品*/
		int type =new Random().nextInt(3 - 1+ 1) + 1;
		List<Product> commandShops = productService.findProductBySort(type);
		shops.put("hot", hotShops);
		shops.put("command", commandShops);
		String shopsStr = JSON.toJSONString(shops);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(shopsStr);
			System.out.println("初始化界面的商品信息:"+shopsStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加商品
	public String addProduct() {
		Map<String,Object> maps = new HashMap<String,Object>();
		if(myFile!=null) {
			System.out.println("上传的商品有图片信息");
			System.out.println("上传的商品为:"+product.toString());
			try {
				String dirStr="";
				//文件上传总路径
				String path = ServletActionContext.getRequest().getRealPath("/product");
				if(product.getType()==0) {
					dirStr="baobao";
				}else if(product.getType()==1) {
					dirStr="Bottling";
				}else if(product.getType()==2) {
					dirStr="clothes";
				}else if(product.getType()==3) {
					dirStr="skirt";
				}else if(product.getType()==4) {
					dirStr="toys";
				}else if(product.getType()==5) {
					dirStr="specialty";
				}
				File dir = new File(path,dirStr);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				//用户上传图片的路径
					File file = new File(dir,myFileFileName);
					FileUtils.copyFile(myFile, file);
					System.out.println("文件上传成功...");
					product.setpImage("http://192.168.1.106:808/community/"+dirStr+"/"+myFileFileName);
				}catch (IOException e) {
					e.printStackTrace();
				}
		}
		product.setPdate(new Date());
		productService.addProduct(product);
		System.out.println("添加商品成功...");
		return SUCCESS;
	}
	//商品下架
	public void removeProduct() {
		Map<String,Object> maps = new HashMap<String,Object>();
		try {
			Product findProductByPid = productService.findProductByPid(product.getPid());
			productService.removeProduct(findProductByPid);
			maps.put("success",true);
			String jsonString = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(jsonString);
			System.out.println("商品下架成功...");
		}catch (Exception e) {
			maps.put("success",false);
			String jsonString = JSON.toJSONString(maps);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().println(jsonString);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("商品下失败...");
		}
	}
	
	public void getAllProduct2() {
		Map<String,Object> maps = new HashMap<String,Object>();
		List<Product> allProduct = productService.findAllProduct();
		if(allProduct!=null&&allProduct.size()>0) {
			maps.put("success",true);
			maps.put("products",allProduct);
		}else {
			maps.put("success",false);
		}
		String string = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
			System.out.println("获取所有的商品信息成功:"+string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getProductByPid() {
		Map<String,Object> maps = new HashMap<String,Object>();
		Product findProductByPid = productService.findProductByPid(product.getPid());
		if(findProductByPid!=null) {
			maps.put("success",true);
			maps.put("product",findProductByPid);
		}else {
			maps.put("success",false);
		}
		String string = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(string);
			System.out.println("获取品信息成功:"+string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String updateProduct() throws IOException {
		System.out.println("上传商品信息的pid为:"+product.getPid());
		String productImgPath="";
		Map<String,Object> maps = new HashMap<String,Object>();
		Product findProductByPid = productService.findProductByPid(product.getPid());
		try {
			if(myFile!=null) {
				System.out.println("上传的商品有图片信息");
				System.out.println("上传的商品为:"+product.toString());
					String dirStr="";
					//文件上传总路径
					String path = ServletActionContext.getRequest().getRealPath("/product");
					if(product.getType()==0) {
						dirStr="baobao";
					}else if(product.getType()==1) {
						dirStr="Bottling";
					}else if(product.getType()==2) {
						dirStr="clothes";
					}else if(product.getType()==3) {
						dirStr="skirt";
					}else if(product.getType()==4) {
						dirStr="toys";
					}else if(product.getType()==5) {
						dirStr="specialty";
					}
					File dir = new File(path,dirStr);
					if(!dir.exists()) {
						dir.mkdirs();
					}
					//用户上传图片的路径
						File file = new File(dir,myFileFileName);
						FileUtils.copyFile(myFile, file);
						System.out.println("文件上传成功...");
						productImgPath="http://192.168.1.106:808/community/"+dirStr+"/"+myFileFileName;
						product.setpImage(productImgPath);
			}else {
				String getpImage = findProductByPid.getpImage();
				product.setpImage(getpImage);
			}
			findProductByPid.setPname(product.getPname());
			findProductByPid.setType(product.getType());
			findProductByPid.setShopPrice(product.getShopPrice());
			findProductByPid.setPdesc(product.getPdesc());
			findProductByPid.setIsHot(product.getIsHot());
			productService.updateProduct(findProductByPid);
			System.out.println("商品修改成功");
			maps.put("success",true);
		} catch (Exception e) {
			maps.put("success",false);
			System.out.println(e.toString());
			System.out.println("商品修改失败");
		}
		String string = JSON.toJSONString(maps);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(string);
		return SUCCESS;
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
	public Product getModel() {
		return product;
	}
}
