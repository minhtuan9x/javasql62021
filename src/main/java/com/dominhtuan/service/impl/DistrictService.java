package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.output.DistrictOutput;
import com.dominhtuan.reponsitory.entity.DistrictEntity;
import com.dominhtuan.reponsitory.impl.DistrictReponsitory;
import com.dominhtuan.service.IDistrictService;

public class DistrictService implements IDistrictService {
	
	@Override
	public List<DistrictOutput> getAllDistrict() {
		// TODO Auto-generated method stub
		List<DistrictOutput> districtOutputs = new ArrayList<DistrictOutput>();
		DistrictReponsitory districtReponsitory = new DistrictReponsitory();
		DistrictOutput districtOutput;
		for(DistrictEntity item : districtReponsitory.getAllDistrict()) {
			districtOutput = new DistrictOutput();
			districtOutput.setCode(item.getCode());
			districtOutput.setName(item.getName());
			districtOutputs.add(districtOutput);
		}
		return districtOutputs;
	}

}
