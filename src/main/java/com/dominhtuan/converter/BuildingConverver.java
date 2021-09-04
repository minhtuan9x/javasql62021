package com.dominhtuan.converter;

import com.dominhtuan.model.output.BuildingOutput;
import com.dominhtuan.reponsitory.entity.BuildingEntity;

public class BuildingConverver {

	public BuildingOutput convertBuildingEntitytoOutput(BuildingEntity buildingEntity,String districtName,String rentType,String rentArea,String staffName) {
		BuildingOutput buildingOutput = new BuildingOutput();
		buildingOutput.setCreateDate(buildingEntity.getCreatedBy());
		buildingOutput.setName(buildingEntity.getName());
		buildingOutput.setFloorArea(buildingEntity.getFloorArea());
		buildingOutput.setNumberOfBasement(buildingEntity.getNumberOfBasement());
		buildingOutput.setRentPrice(buildingEntity.getRentPriceDescription());
		buildingOutput.setManagerName(buildingEntity.getManagerName());
		buildingOutput.setManagerPhone(buildingEntity.getManagerPhone());
		buildingOutput.setAddresss(buildingEntity.getStreet() + " - " + buildingEntity.getWard() + " - "
				+ districtName);
		buildingOutput.setRentArea(rentArea);
		buildingOutput.setRentType(rentType);
		buildingOutput.setStaffName(staffName);
		return buildingOutput;
	}
}
