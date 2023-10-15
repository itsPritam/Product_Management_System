package com.mydata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mydata.model.Product;
import com.mydata.util.CreateConnection;

public class ProductDaoImpl implements ProductDao {

	Connection con = CreateConnection.initConnection();

	public int saveProduct(Product p) {

		int x = 0;
		try {

			PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?, ?)");

			ps.setInt(1, p.getProduct_id());
			ps.setString(2, p.getProduct_name());
			ps.setFloat(3, p.getProduct_cost());
			ps.setInt(4, p.getProduct_quantity());
			
			x = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	public String updateProduct(int i, float c) {

		String res = null;

		try {
			PreparedStatement ps = con.prepareStatement("update product set cost = ? where pid = ?");

			ps.setFloat(1, c);
			ps.setInt(2, i);

			int x = ps.executeUpdate();

			if (x > 0)
				res = "success";
			else
				res = "failure";

		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}

	@Override
	public int deleteProduct(int i) {
		int x = 0;
		try {

			PreparedStatement ps = con.prepareStatement("delete from product where pid = ?");

			ps.setInt(1, i);
			x = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return x;
	}

	@Override
	public List<Product> fetchAllProduct() {

		List<Product> callProduct = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select *from product");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt("pid"), rs.getString("pname"), rs.getFloat("cost"),
						rs.getInt("quantity"));
				callProduct.add(p);

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return callProduct;
	}

	@Override
	public Product fetchById(int i) {
		
		Product p = new Product();
		
		try {
			PreparedStatement ps = con.prepareStatement("select *from product where pid =?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("pid");
				p.setProduct_id(id);
				p.setProduct_name(rs.getString("pname"));
				p.setProduct_cost(rs.getFloat("cost"));
				p.setProduct_quantity(rs.getInt("quantity"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return p;
	}

}
