package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dominhtuan.reponsitory.IRentAreaRepository;
import com.dominhtuan.util.ConnectDB;

public class RentAreaRepository implements IRentAreaRepository {
	
	private ConnectDB connectDB = new ConnectDB();
	private Connection conn =null;
	private Statement stmt = null;
	private ResultSet rs = null;
	

	@Override
	public String getAllRentAreaByBuildingID(int buildingId) {
		// TODO Auto-generated method stub
		String result="";
		try {
			conn = connectDB.connectDB();
			stmt = conn.createStatement();
			String sql = "select value from rentarea where buildingid = "+buildingId;
			rs = stmt.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					result+=rs.getInt("value");
					if(!rs.isLast())
						result+=",";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
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
