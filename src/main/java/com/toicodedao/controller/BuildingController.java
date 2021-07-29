package com.toicodedao.controller;

import java.util.List;

import com.toicodedao.model.BuildingModel;
import com.toicodedao.model.input.BuildingInput;
import com.toicodedao.server.impl.BuildingServer;

public class BuildingController {
	BuildingServer buildingServer;

	public List<BuildingModel> getBuildingSearch(BuildingInput buildingInput) {
		buildingServer = new BuildingServer();
		return buildingServer.getBuildingSearch(buildingInput);
	}

	public boolean setBuilding(BuildingModel buildingModel) throws Exception {
		buildingServer = new BuildingServer();
		if (buildingServer.setBuilding(buildingModel))
			return true;
		return false;
	}
	public boolean deleteBuilding(BuildingInput buildingInput) {
		buildingServer = new BuildingServer();
		if(buildingServer.deleteBuilding(buildingInput))
			return true;
		return false;
	}
	public List<BuildingModel> getAllBuilding(){
		buildingServer = new BuildingServer();
		return buildingServer.getALLBuilding();
		
	}
}
