package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.model.output.AssignmentBuildingOutput;
import com.dominhtuan.reponsitory.entity.AssignmentBuildingEntity;
import com.dominhtuan.reponsitory.impl.AssignmentBuildingReponsitory;
import com.dominhtuan.service.IAssignmentBuildingService;
import com.dominhtuan.util.StaffUtil;

public class AssignmentBuildingService implements IAssignmentBuildingService {

	@Override
	public boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		// TODO Auto-generated method stub
		StaffUtil staffUtil = new StaffUtil();
		AssignmentBuildingReponsitory assignmentBuildingReponsitory = new AssignmentBuildingReponsitory();
		if (checkStaffID(assignmentBuildingInput).size() > 0) {
			try {
				String exception = "Nhân viên ";
				for (Integer item : checkStaffID(assignmentBuildingInput)) {
					exception += staffUtil.findStaffNameByID(item) + ",";
				}
				exception += "đã được giao cho tòa nhà này rồi!!";
				throw new Exception(exception);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		} else {
			boolean result = assignmentBuildingReponsitory.assignmentBuilding(assignmentBuildingInput);
			if (result)
				return true;
		}
		return false;
	}

	@Override
	public List<AssignmentBuildingOutput> getAllAssignmentBuilding() {
		// TODO Auto-generated method stub
		List<AssignmentBuildingOutput> assignmentBuildingOutputs = new ArrayList<AssignmentBuildingOutput>();
		AssignmentBuildingReponsitory assignmentBuildingReponsitory = new AssignmentBuildingReponsitory();
		for (AssignmentBuildingEntity item : assignmentBuildingReponsitory.getAllAssignBuilding()) {
			AssignmentBuildingOutput assignmentBuildingOutput = new AssignmentBuildingOutput();
			assignmentBuildingOutput.setBuildingID(item.getBuildingID());
			assignmentBuildingOutput.setStaffID(item.getStaffID());
			assignmentBuildingOutputs.add(assignmentBuildingOutput);
		}
		return assignmentBuildingOutputs;
	}

	@Override
	public List<Integer> checkStaffID(AssignmentBuildingInput assignmentBuildingInput) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<>();
		for (AssignmentBuildingOutput item : getAllAssignmentBuilding()) {
			for (Integer item2 : assignmentBuildingInput.getIdStaff()) {
				if (item.getBuildingID() == assignmentBuildingInput.getIdBuilding() && item.getStaffID() == item2)
					result.add(item2);
			}
		}
		return result;
	}

}
