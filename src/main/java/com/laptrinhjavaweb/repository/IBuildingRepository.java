package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.repository.entity.BuildingEntity;

public interface IBuildingRepository {
	List<BuildingEntity> getBuildings(String name,String district);
}
