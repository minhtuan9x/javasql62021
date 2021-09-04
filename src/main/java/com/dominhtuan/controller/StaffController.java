package com.dominhtuan.controller;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.output.StaffAssignmentOutput;
import com.dominhtuan.model.output.StaffOutput;
import com.dominhtuan.service.impl.StaffService;

public class StaffController {
	private StaffService staffService = new StaffService();
	
	public List<StaffOutput> getAllStaff(){
		List<StaffOutput> staffOutputs = new ArrayList<StaffOutput>();
		
		staffOutputs = staffService.getAllStaff();
		return staffOutputs;
	}
	public List<StaffAssignmentOutput> getAllStaffByBuildingID(int buildingID){
		List<StaffAssignmentOutput> staffAssignmentOutputs = new ArrayList<StaffAssignmentOutput>();
		staffAssignmentOutputs = staffService.getAllStaffAssignment(buildingID);
		return staffAssignmentOutputs;
		
	}
}
