package com.dominhtuan.controller;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.model.output.BuildingOutput;
import com.dominhtuan.service.impl.BuildingService;

public class BuildingController {
	public List<BuildingOutput> getAllBuiding(InputSearchBuilding inputSearchBuilding){
		List<BuildingOutput> buildingOutputs = new ArrayList<BuildingOutput>();
		BuildingService buildingService = new BuildingService();
		buildingOutputs = buildingService.getAllBuilding(inputSearchBuilding);
		return buildingOutputs;
	}
}