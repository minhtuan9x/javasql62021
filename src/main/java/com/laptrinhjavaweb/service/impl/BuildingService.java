package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.model.input.BuildingSearchinput;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	
	private IBuildingRepository buildingRepository = new BuildingRepository();
	

	@Override
	public List<BuildingModel> getBuildings(BuildingSearchinput buildingSearchinput) {
		// TODO Auto-generated method stub
		List<BuildingEntity> result = buildingRepository.getBuildings(buildingSearchinput.getName(), buildingSearchinput.getDistrict());
		List<BuildingModel> buildingModels = new ArrayList<>(); 
		for(BuildingEntity item : result) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(item.getName());
			buildingModel.setAddress(item.getStreet()+" - "+item.getWard()+" - "+item.getDistrict());
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}	
}
