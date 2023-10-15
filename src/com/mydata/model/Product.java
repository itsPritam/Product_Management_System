package com.mydata.model;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int product_id;
	private String product_name;
	private float product_cost;
	private int product_quantity;
	
	public Product() {
		
	}

	public Product(int product_id, String product_name, float product_cost, int product_quantity) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_cost = product_cost;
		this.product_quantity = product_quantity;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getProduct_cost() {
		return product_cost;
	}

	public void setProduct_cost(float product_cose) {
		this.product_cost = product_cose;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	@Override
	public String toString() {

		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_cost=" + product_cost
				+ ", product_quantity=" + product_quantity + "]";
	}

}
