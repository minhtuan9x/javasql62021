package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.output.RentTypeOutput;
import com.dominhtuan.reponsitory.entity.RentTypeEntity;
import com.dominhtuan.reponsitory.impl.RentTypeReponsitory;
import com.dominhtuan.service.IRentTypeService;

public class RentTypeService implements IRentTypeService {

	@Override
	public List<RentTypeOutput> getAllRentType() {
		// TODO Auto-generated method stub
		List<RentTypeOutput> rentTypeOutputs = new ArrayList<RentTypeOutput>();
		RentTypeReponsitory rentTypeReponsitory = new RentTypeReponsitory();
		RentTypeOutput rentTypeOutput;
		for(RentTypeEntity item : rentTypeReponsitory.getAllRentType()) {
			rentTypeOutput = new RentTypeOutput();
			rentTypeOutput.setCode(item.getCode());
			rentTypeOutput.setName(item.getName());
			rentTypeOutputs.add(rentTypeOutput);
		}
		return rentTypeOutputs;
	}
}
