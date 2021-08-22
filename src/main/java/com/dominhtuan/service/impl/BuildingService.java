package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.model.output.BuildingOutput;
import com.dominhtuan.reponsitory.entity.BuildingEntity;
import com.dominhtuan.reponsitory.impl.BuildingReponsitory;
import com.dominhtuan.service.IBuildingService;

public class BuildingService implements IBuildingService {

	public List<BuildingOutput> getAllBuilding(InputSearchBuilding inputSearchBuilding) {
		// TODO Auto-generated method stub
		List<BuildingOutput> buildingOutputs = new ArrayList<BuildingOutput>();
		BuildingReponsitory buildingReponsitory = new BuildingReponsitory();
		BuildingOutput buildingOutput = new BuildingOutput();
		for (BuildingEntity item : buildingReponsitory.getAllBuilding(inputSearchBuilding)) {
			buildingOutput = new BuildingOutput();
			buildingOutput.setName(item.getName());
			buildingOutput.setAddresss(item.getStreet()+" - "+item.getWard()+" - "+item.getDistrictName());
			buildingOutput.setFloorArea(item.getFloorArea());
			buildingOutput.setNumberOfBasement(item.getNumberOfBasement());
			buildingOutput.setRentArea(item.getRentArea());
			buildingOutput.setRentPrice(item.getRentPrice());
			buildingOutput.setRentType(item.getRentType());
			buildingOutput.setStaffName(item.getStaffName());
			buildingOutputs.add(buildingOutput);
		}
		return buildingOutputs;
	}
}
