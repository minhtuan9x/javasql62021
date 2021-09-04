package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.reponsitory.IRentTypeReponsitory;
import com.dominhtuan.reponsitory.entity.RentTypeEntity;
import com.dominhtuan.util.ConnectDB;

public class RentTypeReponsitory implements IRentTypeReponsitory {
	ConnectDB connectDB = new ConnectDB();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public List<RentTypeEntity> getAllRentType() {
		// TODO Auto-generated method stub
		List<RentTypeEntity> rentTypeEntities = new ArrayList<RentTypeEntity>();
		try {
			conn = connectDB.connectDB();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM renttype";
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				RentTypeEntity rentTypeEntity;
				while (rs.next()) {
					rentTypeEntity = new RentTypeEntity();
					rentTypeEntity.setCode(rs.getString("code"));
					rentTypeEntity.setName(rs.getString("name"));
					rentTypeEntities.add(rentTypeEntity);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rentTypeEntities;
	}

	public String findRentTypeByBuildingID(int buildingID) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			conn = connectDB.connectDB();
			stmt = conn.createStatement();
			String sql = "select a.name from renttype as a " + "inner join buildingrenttype as b "
					+ "on a.id = b. renttypeid " + "where b.buildingid = " + buildingID;
		
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					result += rs.getString("name");
					if (!rs.isLast())
						result += ",";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
