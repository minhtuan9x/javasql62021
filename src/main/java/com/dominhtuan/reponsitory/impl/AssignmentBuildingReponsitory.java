package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.reponsitory.IAssignmentBuildingReponsitory;
import com.dominhtuan.reponsitory.entity.AssignmentBuildingEntity;

public class AssignmentBuildingReponsitory implements IAssignmentBuildingReponsitory {
	private ConnectDB connectDB = new ConnectDB();
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		// TODO Auto-generated method stub
		try {
			conn = connectDB.connectDB();
			conn.setAutoCommit(false);
			String sql = "insert into assignmentbuilding (staffid,buildingid)"
					+"\nvalues (?,?)";
			ps = conn.prepareStatement(sql);
			System.out.println(assignmentBuildingInput);
			int buildingID = assignmentBuildingInput.getIdBuilding();
			for (Integer item : assignmentBuildingInput.getIdStaff()) {
				ps.setInt(1, item);
				ps.setInt(2, buildingID);
				ps.execute();
			}
			conn.commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<AssignmentBuildingEntity> getAllAssignBuilding() {
		// TODO Auto-generated method stub
		List<AssignmentBuildingEntity> assignmentBuildingEntities = new ArrayList<AssignmentBuildingEntity>();
		try {
			conn = connectDB.connectDB();
			stmt = conn.createStatement();
			String sql = "select * from assignmentbuilding";
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
					assignmentBuildingEntity.setStaffID(rs.getInt("staffid"));
					assignmentBuildingEntity.setBuildingID(rs.getInt("buildingid"));
					assignmentBuildingEntities.add(assignmentBuildingEntity);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return assignmentBuildingEntities;
	}

}
