package com.dominhtuan.controller;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.output.RentTypeOutput;
import com.dominhtuan.service.impl.RentTypeService;

public class RentTypeController {
	public List<RentTypeOutput> getAllRentType(){
		List<RentTypeOutput> rentTypeOutputs = new ArrayList<RentTypeOutput>();
		RentTypeService rentTypeService = new RentTypeService();
		rentTypeOutputs = rentTypeService.getAllRentType();
		return rentTypeOutputs;
	}
}
