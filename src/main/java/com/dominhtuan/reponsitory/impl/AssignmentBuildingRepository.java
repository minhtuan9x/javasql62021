package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dominhtuan.model.input.AssignmentBuildingAdvanceInput;
import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.reponsitory.IAssignmentBuildingRepository;
import com.dominhtuan.util.ConnectDB;

public class AssignmentBuildingRepository implements IAssignmentBuildingRepository {
	ConnectDB connectDB = new ConnectDB();
	Connection conn = null;
	PreparedStatement psadd = null;
	PreparedStatement psremove = null;
	

	public boolean AssignmentBuilding(AssignmentBuildingAdvanceInput assignmentBuildingAdvanceInput) {
		// TODO Auto-generated method stub
		try {
			conn = connectDB.connectDB();
			conn.setAutoCommit(false);
			String sqladd = "insert into assignmentbuilding(staffid,buildingid)"
					+ "\nvalues(?,?)";
			String sqlremove = "delete from assignmentbuilding"
					+ "\nwhere staffid = ? and buildingid = ?";
			System.out.println(assignmentBuildingAdvanceInput);
			psadd = conn.prepareStatement(sqladd);
			psremove = conn.prepareStatement(sqlremove);
			int buildingID = assignmentBuildingAdvanceInput.getBuildingID();
			if(assignmentBuildingAdvanceInput.getStaffIDAdds().size()>0) {
				for(Integer staffID : assignmentBuildingAdvanceInput.getStaffIDAdds()) {
					psadd.setInt(1, staffID);
					psadd.setInt(2, buildingID);
					psadd.executeUpdate();
				}
			}
			if(assignmentBuildingAdvanceInput.getStaffIDRemoves().size()>0) {
				for(Integer staffID : assignmentBuildingAdvanceInput.getStaffIDRemoves()) {
					psremove.setInt(1, staffID);
					psremove.setInt(2, buildingID);
					psremove.executeUpdate();
				}
			}
			
			conn.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi repo giao toa nha:\n"+e.getMessage());
		}finally {
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
