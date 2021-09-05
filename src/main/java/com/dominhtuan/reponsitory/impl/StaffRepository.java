package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.reponsitory.IStaffRepository;
import com.dominhtuan.reponsitory.entity.StaffAssignmentEntity;
import com.dominhtuan.reponsitory.entity.StaffEntity;
import com.dominhtuan.util.ConnectDB;

public class StaffRepository implements IStaffRepository {
    private ConnectDB connectDB = new ConnectDB();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public List<StaffEntity> getAllStaff() {
        List<StaffEntity> staffEntities = new ArrayList<StaffEntity>();
        // TODO Auto-generated method stub
        try {
            conn = connectDB.connectDB();
            if (conn != null) {
                stmt = conn.createStatement();
                String sql = "select user.fullname, user.id,user.status, user_role.roleid\r\n" + "from user\r\n"
                        + "inner join user_role\r\n" + "on user.id = user_role.userid\r\n"
                        + "where user_role.roleid = 2 and user.status = 1";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    StaffEntity staffEntity = new StaffEntity();
                    staffEntity.setStaffID(rs.getInt("id"));
                    staffEntity.setStaffName(rs.getString("fullname"));
                    staffEntities.add(staffEntity);
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

        return staffEntities;
    }

    public String findStaffbyBuildingID(int buildingID) {
        // TODO Auto-generated method stub
        String result = "";
        try {
            conn = connectDB.connectDB();
            stmt = conn.createStatement();
            String sql = "select a.fullname from user as a\n"
                    + "inner join assignmentbuilding as b\n"
                    + "on a.id = b.staffid \n" +
                    "inner join user_role as c\n" +
                    "on a.id = c.userid\n"
                    + "where c.roleid = 2 and b.buildingid =" + buildingID;
            rs = stmt.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    result += rs.getString("fullname");
                    if (!rs.isLast()) {
                        result += ",";
                    }
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
        return result;
    }

    public List<StaffAssignmentEntity> findAllStaffbyBuildingID(int buildingID) {
        // TODO Auto-generated method stub
        List<StaffAssignmentEntity> staffAssignmentEntities = new ArrayList<StaffAssignmentEntity>();
        try {
            conn = connectDB.connectDB();
            stmt = conn.createStatement();
            String sql = "select a.id, a.fullname from user as a\n"
                    + "inner join assignmentbuilding as b\n"
                    + "on a.id = b.staffid \n" +
                    "inner join user_role as c\n" +
                    "on a.id = c.userid\n"
                    + "where c.roleid = 2 and b.buildingid =" + buildingID;
            rs = stmt.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    StaffAssignmentEntity staffAssignmentEntity = new StaffAssignmentEntity();
                    staffAssignmentEntity.setStaffID(rs.getInt("id"));
                    staffAssignmentEntity.setStaffName(rs.getString("fullname"));
                    staffAssignmentEntities.add(staffAssignmentEntity);
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
        return staffAssignmentEntities;
    }

}
