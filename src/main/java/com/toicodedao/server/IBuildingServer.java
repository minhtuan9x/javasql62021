package com.toicodedao.server;

import java.util.List;

import com.toicodedao.model.BuildingModel;
import com.toicodedao.model.input.BuildingInput;

public interface IBuildingServer {
	List<BuildingModel> getBuildingSearch(BuildingInput buildingInput);
	boolean setBuilding(BuildingModel buildingModel) throws Exception;
	boolean deleteBuilding(BuildingInput buildingInput);
	List<BuildingModel> getALLBuilding();

}
