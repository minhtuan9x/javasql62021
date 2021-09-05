package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.dominhtuan.model.input.AssignmentBuildingAdvanceInput;
import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.model.output.StaffAssignmentOutput;
import com.dominhtuan.reponsitory.entity.StaffAssignmentEntity;
import com.dominhtuan.reponsitory.impl.AssignmentBuildingRepository;
import com.dominhtuan.reponsitory.impl.StaffRepository;
import com.dominhtuan.service.IAssignmentBuildingService;

public class AssignmentBuildingService implements IAssignmentBuildingService {

    public boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
        // TODO Auto-generated method stub
        if (assignmentBuildingInput == null)
            return false;
        AssignmentBuildingAdvanceInput result = checkAssignment(assignmentBuildingInput);
        AssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepository();
        if (assignmentBuildingRepository.AssignmentBuilding(result))
            return true;
        return false;
    }
    public boolean assignmentBuilding2(AssignmentBuildingInput assignmentBuildingInput){
        if (assignmentBuildingInput == null)
            return false;
        AssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepository();
        AssignmentBuildingAdvanceInput assignmentBuildingAdvanceInput = new AssignmentBuildingAdvanceInput();
        List<Integer> staffAdds = new ArrayList<Integer>();
        List<Integer> staffRemove = new ArrayList<Integer>();
        StaffRepository staffRepository = new StaffRepository();
        List<Integer>  news = assignmentBuildingInput.getStaffID();
        List<Integer> olds = new ArrayList<Integer>();
        for(StaffAssignmentEntity item : staffRepository.findAllStaffbyBuildingID(assignmentBuildingInput.getBuildingID())){
            olds.add(item.getStaffID());
        }
        for(Integer item : olds){
            if(!news.contains(item))
                staffRemove.add(item);
        }
        for(Integer item : news){
            if(!olds.contains(item)){
                staffAdds.add(item);
            }
        }
        assignmentBuildingAdvanceInput.setBuildingID(assignmentBuildingInput.getBuildingID());
        assignmentBuildingAdvanceInput.setStaffIDAdds(staffAdds);
        assignmentBuildingAdvanceInput.setStaffIDRemoves(staffRemove);
        if (assignmentBuildingRepository.AssignmentBuilding(assignmentBuildingAdvanceInput))
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
