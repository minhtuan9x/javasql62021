package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.AssignmentBuildingAdvanceInput;
import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.model.output.StaffAssignmentOutput;
import com.dominhtuan.reponsitory.impl.AssignmentBuildingRepository;
import com.dominhtuan.service.IAssignmentBuildingService;

public class AssignmentBuildingService implements IAssignmentBuildingService {

	public boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		// TODO Auto-generated method stub
		if(assignmentBuildingInput==null)
			return false;
		AssignmentBuildingAdvanceInput result = checkAssignment(assignmentBuildingInput);
		AssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepository();
		if (assignmentBuildingRepository.AssignmentBuilding(result))
			return true;
		return false;
	}

	public AssignmentBuildingAdvanceInput checkAssignment(AssignmentBuildingInput assignmentBuildingInput) {
		// TODO Auto-generated method stub
		AssignmentBuildingAdvanceInput assignmentBuildingAdvanceInput = new AssignmentBuildingAdvanceInput();
		List<Integer> staffIDAdds = new ArrayList<Integer>();
		List<Integer> staffIDRemoves = new ArrayList<Integer>();
		StaffService staffService = new StaffService();
		
		for (StaffAssignmentOutput item : staffService.getAllStaffAssignment(assignmentBuildingInput.getBuildingID())) {
			int flag = 0;
			for (Integer item2 : assignmentBuildingInput.getStaffID()) {
				if (item.getStaffID() == item2) {
					flag++;
					if (!item.getChecked().equals("checked"))
						staffIDAdds.add(item.getStaffID());
				}
			}
			if (flag == 0) {
				if (item.getChecked().equals("checked"))
					staffIDRemoves.add(item.getStaffID());

			}
		}
		assignmentBuildingAdvanceInput.setBuildingID(assignmentBuildingInput.getBuildingID());
		assignmentBuildingAdvanceInput.setStaffIDAdds(staffIDAdds);
		assignmentBuildingAdvanceInput.setStaffIDRemoves(staffIDRemoves);

		return assignmentBuildingAdvanceInput;
	}

}
