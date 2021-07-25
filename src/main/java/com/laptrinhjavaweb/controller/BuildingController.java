package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.model.input.BuildingSearchinput;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {
	

	
	private IBuildingService buildingService = new BuildingService();
	
	public List<BuildingModel> getBuildings(BuildingSearchinput buildingSearchinput){//lay du lieu
		List<BuildingModel> buildingModels = new ArrayList<>(); 
		String name = buildingSearchinput.getName();
		String district = buildingSearchinput.getDistrict();
		
		return buildingService.getBuildings(buildingSearchinput);
	}
}
