package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.output.StaffOutput;
import com.dominhtuan.reponsitory.entity.StaffEntity;
import com.dominhtuan.reponsitory.impl.StaffRepository;
import com.dominhtuan.service.IStaffsservice;

public class StaffService implements IStaffsservice {

	public List<StaffOutput> getAllStaff() {
		List<StaffOutput> staffOutputs = new ArrayList<StaffOutput>();
		StaffRepository repository = new StaffRepository();
		for(StaffEntity item : repository.getAllStaff()) {
			StaffOutput staffOutput = new StaffOutput();
			staffOutput.setStaffID(item.getStaffID());
			staffOutput.setStaffName(item.getStaffName());
			staffOutputs.add(staffOutput);
		}
		return staffOutputs;
	}

}
