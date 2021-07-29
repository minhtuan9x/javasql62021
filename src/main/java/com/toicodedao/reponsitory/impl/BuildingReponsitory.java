package com.toicodedao.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.toicodedao.model.input.BuildingInput;
import com.toicodedao.reponsitory.IBuildingReponsitory;
import com.toicodedao.reponsitory.entity.BuildingEntity;

public class BuildingReponsitory implements IBuildingReponsitory {
	private String url = "jdbc:mysql://localhost:3306/batdongsan";
	private String user = "root";
	private String pass = "admin";
	Connection conn;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	BuildingEntity buildingEntity;

	public List<BuildingEntity> getBuildingSearch(BuildingInput buildingInput) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			rs = stmt.executeQuery(query(buildingInput));
			int check = 0;
			while (rs.next()) {
				buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getInt("id"));
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setDistrict(rs.getString("district"));
				buildingEntity.setType(rs.getString("type"));
				buildingEntities.add(buildingEntity);
				check = 1;
			}
			if (check == 0)
				throw new Exception("Khong tim thay!!");
			conn.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());;
			}
		}finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buildingEntities;
	}

	public String query(BuildingInput buildingInput) {
		StringBuilder query = new StringBuilder("select * from building where 1=1");
		if (!buildingInput.getName().equals("") && !buildingInput.getName().equals(null)) {
			query.append(" and name = '" + buildingInput.getName() + "'");
		}
		return query.toString();

	}

	public boolean setBuilding(BuildingEntity buildingEntity) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			String sql = "insert into building (id,name,street,ward,district,type) values (?,?,?,?,?,?)";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, buildingEntity.getId());
			ps.setString(2, buildingEntity.getName());
			ps.setString(3, buildingEntity.getStreet());
			ps.setString(4, buildingEntity.getWard());
			ps.setString(5, buildingEntity.getDistrict());
			ps.setString(6, buildingEntity.getType());
			int t = ps.executeUpdate();
			if(t>0) {
				conn.commit();
				return true;
			}
				
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteBuilding(BuildingInput buildingInput) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			String sql = "delete from building where name = ?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, buildingInput.getName());
			int t = ps.executeUpdate();
			if(t>0) {
				conn.commit();
				return true;
			}
				
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<BuildingEntity> getALLBuilding() {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			rs = stmt.executeQuery("select * from building");
			while (rs.next()) {
				buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getInt("id"));
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setDistrict(rs.getString("district"));
				buildingEntity.setType(rs.getString("type"));
				buildingEntities.add(buildingEntity);
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());;
			}
		}finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buildingEntities;
	}

}
