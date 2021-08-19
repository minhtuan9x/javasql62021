package com.dominhtuan.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.reponsitory.IBuildingReponsitory;
import com.dominhtuan.reponsitory.entity.BuildingEntity;
import com.dominhtuan.util.Checkinput;

public class BuildingReponsitory implements IBuildingReponsitory {
	private String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private String USER = "root";
	private String PASS = "admin";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public List<BuildingEntity> getAllBuilding(InputSearchBuilding inputSearchBuilding) {
		List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(Query(inputSearchBuilding));
				while (rs.next()) {
					BuildingEntity buildingEntity = new BuildingEntity();
					buildingEntity.setName(rs.getString("name"));
					buildingEntity.setStreet(rs.getString("street"));
					buildingEntity.setDistrict(rs.getString("district"));
					buildingEntity.setFloorArea(rs.getInt("floorarea"));
					buildingEntity.setWard(rs.getString("ward"));
					buildingEntity.setRentArea(rs.getInt("rentarea"));
					buildingEntity.setRentType(rs.getString("renttype"));
					buildingEntity.setNumberOfBasement(rs.getInt("numberofbasement"));
					buildingEntity.setStaffName(rs.getString("fullname"));
					buildingEntities.add(buildingEntity);
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
		return buildingEntities;
	}

	public String Query(InputSearchBuilding inputSearchBuilding) {
		Checkinput checkinput = new Checkinput();
//		select a.id, a.name, a.street, a.ward, a.floorarea,a.numberofbasement,b.name as district,c.value as rentarea,d1.name as renttype, f.fullname
//		from building as a join district as b
//		on a.districtid = b.id
//		left join rentarea as c
//		on a.id = c.buildingid
//		left join buildingrenttype as d
//		on a.id = d.buildingid
//		left join renttype as d1
//		on d1.id = d.renttypeid
//		left join assignmentbuilding as e
//		on a.id = e.buildingid
//		left join user as f
//		on f.id = e.staffid
//		where 1 = 1
		StringBuilder sql = new StringBuilder(
				"select a.id, a.name, a.street, a.ward, a.floorarea,a.numberofbasement,b.name as district,c.value as rentarea,d1.name as renttype, f.fullname\r\n"
						+ "from building as a join district as b\r\n" + "on a.districtid = b.id\r\n"
						+ "left join rentarea as c\r\n" + "on a.id = c.buildingid\r\n"
						+ "left join buildingrenttype as d\r\n" + "on a.id = d.buildingid\r\n"
						+ "left join renttype as d1\r\n" + "on d1.id = d.renttypeid\r\n"
						+ "left join assignmentbuilding as e\r\n" + "on a.id = e.buildingid\r\n"
						+ "left join user as f\r\n" + "on f.id = e.staffid\r\n" + "where 1 = 1");
		if (!checkinput.is0(inputSearchBuilding.getName())) {
			sql.append(" and a.name like '%" + inputSearchBuilding.getName() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getFloorArea())) {
			sql.append(" and a.floorarea = " + inputSearchBuilding.getFloorArea());
		}
		if (!checkinput.is0(inputSearchBuilding.getDistrictID())) {
			sql.append(" and b.code = '" + inputSearchBuilding.getDistrictID() + "'");
		}
		if (!checkinput.is0(inputSearchBuilding.getWard())) {
			sql.append(" and a.ward like '%" + inputSearchBuilding.getWard() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getStreet())) {
			sql.append(" and a.street like '%" + inputSearchBuilding.getStreet() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getNumberOfBasement())) {
			sql.append(" and a.numberofbasement = " + inputSearchBuilding.getNumberOfBasement());
		}
		if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				|| !checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom()))
				sql.append(" and c.value > " + inputSearchBuilding.getRentAreaFrom());
			else
				sql.append(" and c.value > " + inputSearchBuilding.getRentAreaTo());
		} else if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			sql.append(" and (c.value > " + inputSearchBuilding.getRentAreaFrom() + " and c.value < "
					+ inputSearchBuilding.getRentAreaTo() + ")");
		}
		if (!checkinput.is0(inputSearchBuilding.getRentPriceFrom())
				|| !checkinput.is0(inputSearchBuilding.getRentPriceTo())) {
			if (!checkinput.is0(inputSearchBuilding.getRentPriceFrom()))
				sql.append(" and a.rentprice > " + inputSearchBuilding.getRentPriceFrom());
			else
				sql.append(" and a.rentprice > " + inputSearchBuilding.getRentPriceTo());
		} else if (!checkinput.is0(inputSearchBuilding.getRentPriceFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentPriceTo()))
			sql.append(" and (a.rentprice > " + inputSearchBuilding.getRentPriceFrom() + " and a.rentprice < "
					+ inputSearchBuilding.getRentPriceTo() + ")");
		if (!checkinput.is0(inputSearchBuilding.getStaffID())) {
			sql.append(" and e.staffid = " + inputSearchBuilding.getStaffID());
		}
		return sql.toString();
	}

}
