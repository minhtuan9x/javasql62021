package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.model.input.BuildingSearchinput;

public interface IBuildingService {
	List<BuildingModel> getBuildings(BuildingSearchinput buildingSearchinput);
}
