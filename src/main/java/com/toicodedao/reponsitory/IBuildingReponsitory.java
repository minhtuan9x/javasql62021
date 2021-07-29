package com.toicodedao.reponsitory;

import java.util.List;

import com.toicodedao.model.input.BuildingInput;
import com.toicodedao.reponsitory.entity.BuildingEntity;

public interface IBuildingReponsitory {
	List<BuildingEntity> getBuildingSearch(BuildingInput buildingInput);
	boolean setBuilding(BuildingEntity buildingEntity);
	boolean deleteBuilding(BuildingInput buildingInput);
	List<BuildingEntity> getALLBuilding();
}
