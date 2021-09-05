package com.dominhtuan.controller;

import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.service.impl.AssignmentBuildingService;

public class AssignmentBuildingController {
	private AssignmentBuildingService assignmentBuildingService = new AssignmentBuildingService();
	public boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
//		if(assignmentBuildingService.assignmentBuilding(assignmentBuildingInput))
		if(assignmentBuildingService.assignmentBuilding2(assignmentBuildingInput))
			return true;
		return false;	
	}
}
