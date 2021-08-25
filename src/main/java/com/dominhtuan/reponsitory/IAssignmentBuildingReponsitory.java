package com.dominhtuan.reponsitory;

import java.util.List;

import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.reponsitory.entity.AssignmentBuildingEntity;

public interface IAssignmentBuildingReponsitory {
	boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput);
	List<AssignmentBuildingEntity> getAllAssignBuilding();
}
