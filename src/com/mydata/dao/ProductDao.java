package com.mydata.dao;

import java.util.List;

import com.mydata.model.Product;

public interface ProductDao {

	public int saveProduct(Product p);

	String updateProduct(int i, float c);

	int deleteProduct(int i);

	List<Product> fetchAllProduct();

	Product fetchById(int i);

}
