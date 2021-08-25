package com.dominhtuan.service;

import java.util.List;

import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.model.output.BuildingIDandNameOutput;
import com.dominhtuan.model.output.BuildingOutput;

public interface IBuildingService {
	List<BuildingOutput> getAllBuilding(InputSearchBuilding inputSearchBuilding);
	List<BuildingIDandNameOutput> getIDandNameBuilding();
}