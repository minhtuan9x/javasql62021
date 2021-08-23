package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.reponsitory.IDistrictReponsitory;
import com.dominhtuan.reponsitory.entity.DistrictEntity;

public class DistrictReponsitory implements IDistrictReponsitory {

	private ConnectDB connectDB = new  ConnectDB();
	private Connection conn =null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	@Override
	public List<DistrictEntity> getAllDistrict() {
		// TODO Auto-generated method stub
		List<DistrictEntity> districtEntities = new ArrayList<DistrictEntity>();
		try {
			conn = connectDB.connectDB();
			stmt = conn.createStatement();
			String sql ="SELECT * FROM district";
			rs = stmt.executeQuery(sql);
			if(rs!=null) {
				DistrictEntity districtEntity;
				while(rs.next()) {
					districtEntity = new DistrictEntity();
					districtEntity.setCode(rs.getString("code"));
					districtEntity.setName(rs.getString("name"));
					districtEntities.add(districtEntity);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return districtEntities;
	}

	@Override
	public String findByBuildingId(int buildingId) {
		// TODO Auto-generated method stub
		String districtName = null;
		try {
			conn = connectDB.connectDB();
			stmt = conn.createStatement();
			String sql = "select a.id, b.name"
					+ "\nfrom building as a "
					+ "\nleft join district as b"
					+ "\non a.districtid = b.id"
					+ "\nwhere a.id = "+buildingId;
			rs = stmt.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
					return rs.getString("name");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return districtName;
	}

}
