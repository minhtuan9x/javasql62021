package com.dominhtuan.reponsitory;

import java.util.List;

import com.dominhtuan.reponsitory.entity.StaffEntity;

public interface IStaffRepository {
	List<StaffEntity> getAllStaff();
	String findStaffbyBuildingID(int buildingID);
}
