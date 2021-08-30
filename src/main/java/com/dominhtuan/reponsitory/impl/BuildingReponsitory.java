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
import com.dominhtuan.util.ConnectDB;

public class BuildingReponsitory implements IBuildingReponsitory {
	private ConnectDB connectDB = new ConnectDB();
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public List<BuildingEntity> getAllBuilding(InputSearchBuilding inputSearchBuilding) {
		List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();

		try {
			conn = connectDB.connectDB();
			if (conn != null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(Query(inputSearchBuilding));
				while (rs.next()) {
					BuildingEntity buildingEntity = new BuildingEntity();
					buildingEntity.setId(rs.getInt("id"));
					buildingEntity.setName(rs.getString("name"));
					buildingEntity.setStreet(rs.getString("street"));
					buildingEntity.setFloorArea(rs.getInt("floorarea"));
					buildingEntity.setWard(rs.getString("ward"));
					buildingEntity.setRentPrice(rs.getInt("rentprice"));
					buildingEntity.setRentPriceDescription(rs.getString("rentpricedescription"));
					buildingEntity.setNumberOfBasement(rs.getInt("numberofbasement"));
					buildingEntity.setManagerName(rs.getString("managername"));
					buildingEntity.setManagerPhone(rs.getString("managerphone"));
					for (String item : checkrs) {
						switch (item) {
						case "fullname":
							buildingEntity.setStaffName(rs.getString("fullname"));
							break;
						case "renttype":
							buildingEntity.setRentType(rs.getString("renttype"));
							break;
						case "rentarea":
							buildingEntity.setRentArea(rs.getInt("rentarea"));
							break;
						case "district":
							buildingEntity.setDistrictId(rs.getInt("districtid"));
							break;

						default:
							break;
						}
					}
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
//		select a.id, a.name, a.street, a.ward, a.floorarea,a.numberofbasement,a.rentprice,a.districtid,b.name as district,c.value as rentarea,d1.name as renttype, f.fullname
//		from building as a 
//		inner join district as b
//		on a.districtid = b.id
//		inner join rentarea as c
//		on a.id = c.buildingid
//		inner join buildingrenttype as d
//		on a.id = d.buildingid
//		inner join renttype as d1
//		on d1.id = d.renttypeid
//		inner join assignmentbuilding as e
//		on a.id = e.buildingid
//		inner join user as f
//		on f.id = e.staffid
//		where 1 = 1
//		System.out.println(inputSearchBuilding);
		StringBuilder select = new StringBuilder(
				"select a.id, a.name, a.street, a.ward, a.floorarea,a.numberofbasement,a.rentprice,a.districtid,a.rentpricedescription,"
				+ "a.managername,a.managerphone");

		StringBuilder sql = new StringBuilder("\nfrom building as a");
		if (!checkinput.is0(inputSearchBuilding.getDistrictID())) {
			select.append(",b.name");
			rsset("district");
			sql.append("\ninner join district as b" + "\non a.districtid = b.id");
		}
		if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				|| !checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			select.append(",c.value as rentarea");
			rsset("rentarea");
			sql.append("\ninner join rentarea as c" + "\non a.id = c.buildingid");
		}
		if (inputSearchBuilding.getValueRentType().size() > 0) {
			select.append(",d1.name as renttype");
			rsset("renttype");
			sql.append("\ninner join buildingrenttype as d\r\n" + "on a.id = d.buildingid\r\n"
					+ "inner join renttype as d1\r\n" + "on d1.id = d.renttypeid\n");
		}
		if (!checkinput.is0(inputSearchBuilding.getStaffID())) {
			select.append(", f.fullname");
			rsset("fullname");
			sql.append("\ninner join assignmentbuilding as e\non a.id = e.buildingid\n" + "inner join user as f\r\n"
					+ "on f.id = e.staffid\n");
		}

		sql.append("\nwhere 1 = 1");

		if (!checkinput.is0(inputSearchBuilding.getName())) {
			sql.append(" \nand a.name like '%" + inputSearchBuilding.getName() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getFloorArea())) {
			sql.append(" \nand a.floorarea = " + inputSearchBuilding.getFloorArea());
		}
		if (!checkinput.is0(inputSearchBuilding.getDistrictID())) {

			sql.append(" \nand b.code = '" + inputSearchBuilding.getDistrictID() + "'");
		}
		if (!checkinput.is0(inputSearchBuilding.getWard())) {
			sql.append(" \nand a.ward like '%" + inputSearchBuilding.getWard() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getStreet())) {
			sql.append(" \nand a.street like '%" + inputSearchBuilding.getStreet() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getNumberOfBasement())) {
			sql.append(" \nand a.numberofbasement = " + inputSearchBuilding.getNumberOfBasement());
		}
		//
		if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom())) {
			sql.append(" \nand c.value >= " + inputSearchBuilding.getRentAreaFrom());

		}
		if (!checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			sql.append(" and c.value <= " + inputSearchBuilding.getRentAreaTo());
		}
		//
		if (!checkinput.is0(inputSearchBuilding.getRentPriceFrom())) {
			sql.append(" \nand a.rentprice >= " + inputSearchBuilding.getRentPriceFrom());

		}
		if (!checkinput.is0(inputSearchBuilding.getRentPriceTo())) {
			sql.append(" and a.rentprice <= " + inputSearchBuilding.getRentPriceTo());
		}

		if (!checkinput.is0(inputSearchBuilding.getStaffID())) {
			sql.append(" \nand e.staffid = " + inputSearchBuilding.getStaffID());
		}
		if(!checkinput.is0(inputSearchBuilding.getManagerName())) {
			sql.append("\nand a.managername like '%"+inputSearchBuilding.getManagerName()+"%'");
		}
		if(!checkinput.is0(inputSearchBuilding.getManagerPhone())) {
			sql.append("\nand a.managerphone like '%"+inputSearchBuilding.getManagerPhone()+"%'");
		}
		if (inputSearchBuilding.getValueRentType() != null && inputSearchBuilding.getValueRentType().size() > 0) {
			if (inputSearchBuilding.getValueRentType().size() == 1) {
				sql.append(" \nand ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' )");
			}
			if (inputSearchBuilding.getValueRentType().size() == 2) {
				sql.append(" \nand ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' or d1.code = '"
						+ inputSearchBuilding.getValueRentType().get(1) + "' )");
			}
			if (inputSearchBuilding.getValueRentType().size() == 3) {
				sql.append(" \nand ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' or d1.code = '"
						+ inputSearchBuilding.getValueRentType().get(1) + "'  or d1.code = '"
						+ inputSearchBuilding.getValueRentType().get(2) + "' )");
			}
		}
		System.out.println(select.toString() + sql.toString());
		return select.toString() + sql.toString();
	}

	List<String> checkrs = new ArrayList<>();

	public boolean rsset(String input) {
		checkrs.add(input);
		return true;
	}

}
