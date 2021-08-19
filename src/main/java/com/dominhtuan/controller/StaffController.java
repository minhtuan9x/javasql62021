package com.dominhtuan.controller;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.output.StaffOutput;
import com.dominhtuan.service.impl.StaffService;

public class StaffController {
	public List<StaffOutput> getAllStaff(){
		List<StaffOutput> staffOutputs = new ArrayList<StaffOutput>();
		StaffService staffService = new StaffService();
		staffOutputs = staffService.getAllStaff();
		return staffOutputs;
	}
}
