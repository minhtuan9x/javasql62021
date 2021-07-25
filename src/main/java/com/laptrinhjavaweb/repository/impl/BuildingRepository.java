package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;

public class BuildingRepository implements IBuildingRepository {

	private String DB_URL = "jdbc:mysql://localhost:3306/batdongsan";
	private String USER = "root";
	private String PASS = "admin";
	private Connection conn = null;
	private Statement stmt = null;// cung cap phuong thuc de get dl
	static ResultSet rs = null;// de luu du lieu
//	static PreparedStatement ps = null;

	@Override
	public List<BuildingEntity> getBuildings(String name, String district) {
		List<BuildingEntity> result = new ArrayList<>();
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				System.out.println("Ket noi thanh cong");
				stmt = conn.createStatement();// khoi tao
				conn.setAutoCommit(false);// set bao toan du lieu, neu de true dung 2 cai thi cai nao dung luu sai ko
											// luu.

				StringBuilder query = new StringBuilder("select * from building where 1 = 1");
				if (name != null && name != "")
					query.append(" and name = '" + name + "'");
				if (district != null && district != "")
					query.append(" and district = '" + district + "'");
				rs = stmt.executeQuery(query.toString());
				
				while (rs.next()) {
					BuildingEntity item = new BuildingEntity();
					item.setId(rs.getInt("id"));
					item.setName(rs.getString("name"));
					item.setStreet(rs.getString("street"));
					item.setWard(rs.getString("ward"));
					item.setDistrict(rs.getString("district"));
					result.add(item);
				}
				conn.commit();/// kiem tra
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
			} /// de tro lai du lieu neu sai logic
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} /// de tro lai du lieu neu sai logic
		} finally {
			try {
				if (stmt != null)
					stmt.close();
//				if(ps!=null)
//					ps.close();
				if (rs != null)
					rs.close();
				if (conn != null) {
					conn.close();
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
