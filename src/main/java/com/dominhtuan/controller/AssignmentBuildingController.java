package com.dominhtuan.controller;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.model.output.AssignmentBuildingOutput;
import com.dominhtuan.service.impl.AssignmentBuildingService;

public class AssignmentBuildingController {
	public boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		AssignmentBuildingService assignmentBuildingService = new AssignmentBuildingService();
		boolean result = assignmentBuildingService.assignmentBuilding(assignmentBuildingInput);
		if (result)
			return true;
		return false;
	}
	public List<AssignmentBuildingOutput> getAllAssignmentBuilding() {
		List<AssignmentBuildingOutput>assignmentBuildingOutputs = new ArrayList<AssignmentBuildingOutput>();
		AssignmentBuildingService assignmentBuildingService = new AssignmentBuildingService();
		assignmentBuildingOutputs = assignmentBuildingService.getAllAssignmentBuilding();
		return assignmentBuildingOutputs;
		
	}
}
