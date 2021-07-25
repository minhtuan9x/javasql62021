package com.laptrinhjavaweb.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample {
	static final String DB_URL = "jdbc:mysql://localhost:3306/batdongsan";
	static final String USER = "root";
	static final String PASS = "admin";
	static Connection conn = null;
	//static Statement stmt = null;// cung cap phuong thuc de get dl
	static ResultSet rs = null;// de luu du lieu
	static PreparedStatement ps = null;

	public static void main(String[] args) {
		System.out.println("Connecting to a selected database...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				System.out.println("Ket noi thanh cong");
				//stmt = conn.createStatement();//khoi tao
				conn.setAutoCommit(false);//set bao toan du lieu, neu de true dung 2 cai thi cai nao dung luu sai ko luu.
				Scanner sc = new Scanner(System.in);
				int chon = sc.nextInt();
				switch (chon) {
				case 1:
					String sql = "select * from building ";
					//rs = stmt.executeQuery(sql);// lay tat ca du lieu tu sql ve rs
					while (rs.next()) {
						System.out.println("id: " + rs.getInt("id"));
						System.out.println("name: " + rs.getString("name"));
					}

					break;
				case 2:
					String sql2 = "insert into building(names) values ('building 7')";
					//stmt.executeUpdate(sql2);
					String sql21 = "insert into building(name) values ('building 5')";
					//stmt.executeUpdate(sql21);
					break;
				case 3:
					String sql3 = "update building set name= ? where id = ?  ";
					//stmt.executeUpdate(sql3);
					ps = conn.prepareStatement(sql3);
					ps.setString(1, "cc");
					ps.setInt(2, 1);
					ps.executeUpdate();
					break;
				case 4:
					String sql4 = "delete from building where id = 3";
					//stmt.executeUpdate(sql4);
				default:
					break;
				}
				
				conn.commit();///kiem tra
			} else {
				System.out.println("Ket noi that bai");
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}///de tro lai du lieu neu sai logic
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}///de tro lai du lieu neu sai logic
		} finally {
			try {
//				if (stmt != null)
//					stmt.close();
				if(ps!=null)
					ps.close();
				if (rs != null)
					rs.close();
				if (conn != null) {
					conn.close();
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
