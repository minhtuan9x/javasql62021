package com.dominhtuan.service;

import java.util.List;

import com.dominhtuan.model.output.StaffAssignmentOutput;
import com.dominhtuan.model.output.StaffOutput;

public interface IStaffsservice {
	List<StaffOutput> getAllStaff();
	List<StaffAssignmentOutput> getAllStaffAssignment(int buildingID);
}
