package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.output.StaffAssignmentOutput;
import com.dominhtuan.model.output.StaffOutput;
import com.dominhtuan.reponsitory.entity.StaffAssignmentEntity;
import com.dominhtuan.reponsitory.entity.StaffEntity;
import com.dominhtuan.reponsitory.impl.StaffRepository;
import com.dominhtuan.service.IStaffsservice;

public class StaffService implements IStaffsservice {
	
	private StaffRepository staffRepository = new StaffRepository();
	
	public List<StaffOutput> getAllStaff() {
		List<StaffOutput> staffOutputs = new ArrayList<StaffOutput>();
		for(StaffEntity item : staffRepository.getAllStaff()) {
			StaffOutput staffOutput = new StaffOutput();
			staffOutput.setStaffID(item.getStaffID());
			staffOutput.setStaffName(item.getStaffName());
			staffOutputs.add(staffOutput);
		}
		return staffOutputs;
	}
	
	public List<StaffAssignmentOutput> getAllStaffAssignment(int buildingID) {
		// TODO Auto-generated method stub
		List<StaffAssignmentOutput> staffAssignmentOutputs = new ArrayList<StaffAssignmentOutput>();
		for(StaffOutput item : getAllStaff()) {
			StaffAssignmentOutput staffAssignmentOutput = new StaffAssignmentOutput();
			staffAssignmentOutput.setStaffID(item.getStaffID());
			staffAssignmentOutput.setStaffName(item.getStaffName());
			int flag = 0;
			for(StaffAssignmentEntity item2 : staffRepository.findAllStaffbyBuildingID(buildingID)) {
				if(item.getStaffID()==item2.getStaffID()) {
					flag++;
				}
			}
			if(flag>0) {
				staffAssignmentOutput.setChecked("checked");
			}else {
				staffAssignmentOutput.setChecked("");
			}
			staffAssignmentOutputs.add(staffAssignmentOutput);
		}
		return staffAssignmentOutputs;
	}

}
