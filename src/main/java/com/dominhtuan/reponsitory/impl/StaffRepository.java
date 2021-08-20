package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.reponsitory.IStaffRepository;
import com.dominhtuan.reponsitory.entity.StaffEntity;

public class StaffRepository implements IStaffRepository {
	private Connection conn = null;
	private ConnectDB connectDB = new ConnectDB();
	private Statement stmt = null;
	private ResultSet rs = null;
	public List<StaffEntity> getAllStaff() {
		List<StaffEntity> staffEntities = new ArrayList<StaffEntity>();
		// TODO Auto-generated method stub
		try {
			conn = connectDB.connectDB();
			if(conn != null) {
				stmt = conn.createStatement();
//				select user.fullname, user.id, user_role.roleid
//				from user
//				inner join user_role
//				on user.id = user_role.userid
//				where user_role.roleid = 2
				String sql = "select user.fullname, user.id, user_role.roleid\r\n" + 
						"from user\r\n" + 
						"inner join user_role\r\n" + 
						"on user.id = user_role.userid\r\n" + 
						"where user_role.roleid = 2";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					StaffEntity staffEntity = new StaffEntity();
					staffEntity.setStaffID(rs.getInt("id"));
					staffEntity.setStaffName(rs.getString("fullname"));
					staffEntities.add(staffEntity);
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
		
		return staffEntities;
	}

}
