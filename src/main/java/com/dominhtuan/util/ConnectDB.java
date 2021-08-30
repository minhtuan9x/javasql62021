package com.dominhtuan.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private String USER = "root";
	private String PASS = "admin";
	private Connection conn = null;
	
	public Connection connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return conn;
	}

}
