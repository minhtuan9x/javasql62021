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
					buildingEntity.setId(rs.getInt("id"));
					buildingEntity.setName(rs.getString("name"));
					buildingEntity.setStreet(rs.getString("street"));
					buildingEntity.setDistrictId(rs.getInt("districtid"));
					buildingEntity.setFloorArea(rs.getInt("floorarea"));
					buildingEntity.setWard(rs.getString("ward"));
					buildingEntity.setRentPrice(rs.getInt("rentprice"));
					buildingEntity.setRentArea(rs.getInt("rentarea"));
					buildingEntity.setNumberOfBasement(rs.getInt("numberofbasement"));
					for (String item : checkrs) {
						switch (item) {
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
		StringBuilder select = new StringBuilder(
				"select a.id, a.name, a.street, a.ward, a.floorarea,a.numberofbasement,a.rentprice,a.districtid,"
						+ "c.value as rentarea");

		StringBuilder sql = new StringBuilder("\nfrom building as a\nleft join rentarea as c" + "\non a.id = c.buildingid");
		if (inputSearchBuilding.getValueRentType().size() > 0) {
			select.append(",d1.name as renttype");
			rsset("renttype");
			sql.append("\nleft join buildingrenttype as d\r\n" + "on a.id = d.buildingid\r\n"
					+ "left join renttype as d1\r\n" + "on d1.id = d.renttypeid\n");
		}
		if (!checkinput.is0(inputSearchBuilding.getStaffID())) {
			select.append(", f.fullname");
			rsset("fullname");
			sql.append("\nleft join assignmentbuilding as e\non a.id = e.buildingid\n" + "left join user as f\r\n"
					+ "on f.id = e.staffid\n");
		}
		
		sql.append("\nwhere 1 = 1");

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
				&& checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			sql.append(" and c.value > " + inputSearchBuilding.getRentAreaFrom());

		} else if (checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			sql.append(" and c.value < " + inputSearchBuilding.getRentAreaTo());
		} else if (!checkinput.is0(inputSearchBuilding.getRentAreaFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentAreaTo())) {
			sql.append(" and (c.value > " + inputSearchBuilding.getRentAreaFrom() + " and c.value < "
					+ inputSearchBuilding.getRentAreaTo() + ")");
		}
		if (!checkinput.is0(inputSearchBuilding.getRentPriceFrom())
				&& checkinput.is0(inputSearchBuilding.getRentPriceTo())) {
			sql.append(" and a.rentprice > " + inputSearchBuilding.getRentPriceFrom());

		} else if (checkinput.is0(inputSearchBuilding.getRentPriceFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentPriceTo())) {
			sql.append(" and a.rentprice < " + inputSearchBuilding.getRentPriceTo());
		} else if (!checkinput.is0(inputSearchBuilding.getRentPriceFrom())
				&& !checkinput.is0(inputSearchBuilding.getRentPriceTo()))
			sql.append(" and (a.rentprice > " + inputSearchBuilding.getRentPriceFrom() + " and a.rentprice < "
					+ inputSearchBuilding.getRentPriceTo() + ")");
		if (!checkinput.is0(inputSearchBuilding.getStaffID())) {
			sql.append(" and e.staffid = " + inputSearchBuilding.getStaffID());
		}
		if (inputSearchBuilding.getValueRentType().size() > 0) {
			if (inputSearchBuilding.getValueRentType().size() == 1) {
				sql.append(" and ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' )");
			}
			if (inputSearchBuilding.getValueRentType().size() == 2) {
				sql.append(" and ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' or d1.code = '"
						+ inputSearchBuilding.getValueRentType().get(1) + "' )");
			}
			if (inputSearchBuilding.getValueRentType().size() == 3) {
				sql.append(" and ( d1.code = '" + inputSearchBuilding.getValueRentType().get(0) + "' or d1.code = '"
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
