package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.model.output.BuildingOutput;
import com.dominhtuan.reponsitory.entity.BuildingEntity;
import com.dominhtuan.reponsitory.impl.BuildingReponsitory;
import com.dominhtuan.reponsitory.impl.DistrictReponsitory;
import com.dominhtuan.reponsitory.impl.RentAreaRepository;
import com.dominhtuan.reponsitory.impl.RentTypeReponsitory;
import com.dominhtuan.reponsitory.impl.StaffRepository;
import com.dominhtuan.service.IBuildingService;

public class BuildingService implements IBuildingService {

	public List<BuildingOutput> getAllBuilding(InputSearchBuilding inputSearchBuilding) {
		// TODO Auto-generated method stub
		List<BuildingOutput> buildingOutputs = new ArrayList<BuildingOutput>();
		BuildingReponsitory buildingReponsitory = new BuildingReponsitory();
		DistrictReponsitory districtReponsitory = new DistrictReponsitory();
		RentTypeReponsitory rentTypeReponsitory = new RentTypeReponsitory();
		RentAreaRepository rentAreaRepository = new RentAreaRepository();
		StaffRepository staffRepository = new StaffRepository();
		List<BuildingEntity> ds = buildingReponsitory.getAllBuilding(inputSearchBuilding);
		BuildingOutput buildingOutput;

		//
		for (BuildingEntity item : ds) {
			buildingOutput = new BuildingOutput();
			buildingOutput.setName(item.getName());
			buildingOutput.setAddresss(item.getStreet() + " - " + item.getWard() + " - "
					+ districtReponsitory.findByDistrictID(item.getDistrictId()));
			buildingOutput.setFloorArea(item.getFloorArea());
			buildingOutput.setNumberOfBasement(item.getNumberOfBasement());
			buildingOutput.setRentArea(rentAreaRepository.getAllRentAreaByBuildingID(item.getId()));
			buildingOutput.setRentType(rentTypeReponsitory.findRentTypeByBuildingID(item.getId()));
			buildingOutput.setRentPrice(item.getRentPriceDescription());
			buildingOutput.setStaffName(staffRepository.findStaffbyBuildingID(item.getId()));
			buildingOutput.setManagerName(item.getManagerName());
			buildingOutput.setManagerPhone(item.getManagerPhone());
			buildingOutputs.add(buildingOutput);
		}
		return buildingOutputs;
	}

}
