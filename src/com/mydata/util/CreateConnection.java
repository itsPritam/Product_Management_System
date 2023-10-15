package com.mydata.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

	private static String dname = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/pritam";
	private static String username = "root";
	private static String password = "root";

	public static Connection initConnection() {
		
		Connection con = null;
		
		try {
			
			Class.forName(dname);
			con = DriverManager.getConnection(url,username,password);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}

}
