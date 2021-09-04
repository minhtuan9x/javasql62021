package com.dominhtuan.service;

import com.dominhtuan.model.input.AssignmentBuildingAdvanceInput;
import com.dominhtuan.model.input.AssignmentBuildingInput;

public interface IAssignmentBuildingService {
	boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput);
	AssignmentBuildingAdvanceInput checkAssignment(AssignmentBuildingInput assignmentBuildingInput);
}
