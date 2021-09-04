package com.dominhtuan.controller;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.output.DistrictOutput;
import com.dominhtuan.service.impl.DistrictService;

public class DistrictController {
	public List<DistrictOutput> getAllDistrict(){
		List<DistrictOutput> districtOutputs = new ArrayList<DistrictOutput>();
		DistrictService districtService = new DistrictService();
		districtOutputs = districtService.getAllDistrict();
		return districtOutputs;
	}
}
