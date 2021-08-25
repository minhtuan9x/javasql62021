package com.dominhtuan.service;

import java.util.List;

import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.model.output.AssignmentBuildingOutput;

public interface IAssignmentBuildingService {
	boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput);
	List<AssignmentBuildingOutput> getAllAssignmentBuilding();
	List<Integer> checkStaffID(AssignmentBuildingInput assignmentBuildingInput);
}
