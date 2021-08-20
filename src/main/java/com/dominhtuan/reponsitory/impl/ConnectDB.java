package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import com.dominhtuan.reponsitory.IConnectDB;

public class ConnectDB implements IConnectDB {
	private String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private String USER = "root";
	private String PASS = "admin";
	private Connection conn = null;
	@Override
	public Connection connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connect success!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
}
