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
					buildingEntity.setName(rs.getString("name"));
					buildingEntity.setStreet(rs.getString("street"));
					buildingEntity.setDistrictId(rs.getInt("districtid"));
					buildingEntity.setFloorArea(rs.getInt("floorarea"));
					buildingEntity.setWard(rs.getString("ward"));
					buildingEntity.setRentPrice(rs.getInt("rentprice"));
					buildingEntity.setNumberOfBasement(rs.getInt("numberofbasement"));
					for (String item : checkrs) {
						switch (item) {
						case "district":
							buildingEntity.setDistrictName(rs.getString("district"));
							break;
						case "rentarea":
							buildingEntity.setRentArea(rs.getInt("rentarea"));
							break;
						case "fullname":
							buildingEntity.setStaffName(rs.getString("fullname"));
							break;
						case "renttype":
							buildingEntity.setRentType(rs.getString("renttype"));
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
//		left join district as b
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
		StringBuilder sql = new StringBuilder();
		StringBuilder select = new StringBuilder(
				"select a.id, a.name, a.street, a.ward, a.floorarea,a.numberofbasement,a.rentprice,a.districtid");
		StringBuilder from = new StringBuilder("\nfrom building as a\n");
		StringBuilder join = new StringBuilder();
		StringBuilder query = new StringBuilder("where 1 = 1 \n");
		select.append(",b.name as district");
		rsset("district");
		join.append("left join district as b\non a.districtid = b.id\n");
		if (!checkinput.is0(inputSearchBuilding.getName())) {
			query.append(" and a.name like '%" + inputSearchBuilding.getName() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getFloorArea())) {
			query.append(" and a.floorarea = " + inputSearchBuilding.getFloorArea());
		}
		if (!checkinput.is0(inputSearchBuilding.getDistrictID())) {

			query.append(" and b.code = '" + inputSearchBuilding.getDistrictID() + "'");
		}
		if (!checkinput.is0(inputSearchBuilding.getWard())) {
			query.append(" and a.ward like '%" + inputSearchBuilding.getWard() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getStreet())) {
			query.append(" and a.street like '%" + inputSearchBuilding.getStreet() + "%'");
		}
		if (!checkinput.is0(inputSearchBuilding.getNumberOfBasement())) {
			query.append(" and a.numberofbasement = " + inputSearchBuilding.getNumberOfBasement());
		}
		if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				|| !checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			select.append(",c.value as rentarea");
			rsset("rentarea");
			join.append("left join rentarea as c\non a.id = c.buildingid\n");
		}
		if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				&& checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			query.append(" and c.value > " + inputSearchBuilding.getRentAreaFrom());

		} else if (checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			query.append(" and c.value < " + inputSearchBuilding.getRentAreaTo());
		} else if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			query.append(" and (c.value > " + inputSearchBuilding.getRentAreaFrom() + " and c.value < "
					+ inputSearchBuilding.getRentAreaTo() + ")");
		}
		if (!checkinput.is0(inputSearchBuilding.getRentPriceFrom())
				&& checkinput.is0(inputSearchBuilding.getRentPriceTo())) {
			query.append(" and a.rentprice > " + inputSearchBuilding.getRentPriceFrom());

		} else if (checkinput.is0(inputSearchBuilding.getRentPriceFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentPriceTo())) {
			query.append(" and a.rentprice < " + inputSearchBuilding.getRentPriceTo());
		} else if (!checkinput.is0(inputSearchBuilding.getRentPriceFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentPriceTo()))
			query.append(" and (a.rentprice > " + inputSearchBuilding.getRentPriceFrom() + " and a.rentprice < "
					+ inputSearchBuilding.getRentPriceTo() + ")");
		if (!checkinput.is0(inputSearchBuilding.getStaffID())) {
			select.append(", f.fullname");
			rsset("fullname");
			join.append("left join assignmentbuilding as e\non a.id = e.buildingid\n" + "left join user as f\r\n"
					+ "on f.id = e.staffid\n");
			query.append(" and e.staffid = " + inputSearchBuilding.getStaffID());
		}
		if (inputSearchBuilding.getValueRentType().size() > 0) {
			select.append(",d1.name as renttype");
			rsset("renttype");
			join.append("left join buildingrenttype as d\r\n" + "on a.id = d.buildingid\r\n"
					+ "left join renttype as d1\r\n" + "on d1.id = d.renttypeid\n");
			if (inputSearchBuilding.getValueRentType().size() == 1) {
				query.append(" and ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' )");
			}
			if (inputSearchBuilding.getValueRentType().size() == 2) {
				query.append(" and ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' or d1.code = '"
						+ inputSearchBuilding.getValueRentType().get(1) + "' )");
			}
			if (inputSearchBuilding.getValueRentType().size() == 3) {
				query.append(" and ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' or d1.code = '"
						+ inputSearchBuilding.getValueRentType().get(1) + "'  or d1.code = '"
						+ inputSearchBuilding.getValueRentType().get(2) + "' )");
			}
		}
		sql.append(select.toString() + from.toString() + join.toString() + query.toString());
		System.out.println("=====");
		System.out.println(sql);
		return sql.toString();
	}

	List<String> checkrs = new ArrayList<>();

	public boolean rsset(String input) {
		checkrs.add(input);
		return true;
	}

}
