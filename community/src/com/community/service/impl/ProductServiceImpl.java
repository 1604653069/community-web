package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.ProductDao;
import com.community.domain.Product;
import com.community.service.ProductService;

@Transactional
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public List<Product> findAllProduct() {
		return productDao.findAllProduct();
	}

	public List<Product> findAllHotProduct() {
		return productDao.findAllHotProduct();
	}
	
	public List<Product> findProductBySort(int type) {
		return productDao.findProductBySort(type);
	}
	public Product findProductByPid(String pid) {
		return productDao.findProductByPid(pid);
	}
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	public void removeProduct(Product findProductByPid) {
		productDao.removeProduct(findProductByPid);
	}
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

}
