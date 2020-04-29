package com.community.service;

import java.util.List;

import com.community.domain.Product;

public interface ProductService {

	/* 获取所有的商品信息 */
	public List<Product> findAllProduct();

	/* 获取所有热卖商品 */
	public List<Product> findAllHotProduct();
	
	/* 分类搜索 */
	public List<Product> findProductBySort(int type);
	
	public Product findProductByPid(String pid);
	
	public void addProduct(Product product);

	public void removeProduct(Product findProductByPid);
	
	public void updateProduct(Product product);
}
