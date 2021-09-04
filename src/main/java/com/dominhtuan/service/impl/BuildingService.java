package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.controller.BuildingController;
import com.dominhtuan.converter.BuildingConverver;
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
		BuildingConverver buildingConverver = new BuildingConverver();
		List<BuildingEntity> ds = buildingReponsitory.getAllBuilding(inputSearchBuilding);
		BuildingOutput buildingOutput;

		//
		String districtName=null;
		String rentArea = null;
		String rentType =null;
		String staffName = null;
		for (BuildingEntity item : ds) {
			buildingOutput = new BuildingOutput();
			districtName= districtReponsitory.findByDistrictID(item.getDistrictId());
			rentArea=rentAreaRepository.getAllRentAreaByBuildingID(item.getId());
			rentType=rentTypeReponsitory.findRentTypeByBuildingID(item.getId());
			staffName=staffRepository.findStaffbyBuildingID(item.getId());
			buildingOutput = buildingConverver.convertBuildingEntitytoOutput(item, districtName, rentType, rentArea,staffName);
			buildingOutputs.add(buildingOutput);
		}
		return buildingOutputs;
	}

}
