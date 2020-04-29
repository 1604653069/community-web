package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	/* 获取所有的商品信息 */
	public List<Product> findAllProduct() {
		return (List<Product>) this.getHibernateTemplate().find("from Product");
	}

	/* 获取热卖商品信息 */
	public List<Product> findAllHotProduct() {
		return (List<Product>) this.getHibernateTemplate().find("from Product where isHot = ?",1);
	}

	/* 分类搜索 */
	public List<Product> findProductBySort(int type) {
		return (List<Product>) this.getHibernateTemplate().find("from Product where type=?", type);
	}

	public Product findProductByPid(String pid) {
		List<Product> products = (List<Product>) this.getHibernateTemplate().find("from Product where pid=?", pid);
		if(products!=null&&products.size()>0)
			return products.get(0);
		return null;
	}

	public void addProduct(Product product) {
		this.getHibernateTemplate().save(product);
	}
	public void removeProduct(Product findProductByPid) {
		this.getHibernateTemplate().delete(findProductByPid);
	}

	public void updateProduct(Product product) {
		this.getHibernateTemplate().update(product);
	}

}
