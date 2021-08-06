package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.model.input.BuildingSearchinput;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.util.BuildingTypeUtil;

public class BuildingService implements IBuildingService {

	private IBuildingRepository buildingRepository = new BuildingRepository();

	@Override
	public List<BuildingModel> getBuildings(BuildingSearchinput buildingSearchinput) {
		// TODO Auto-generated method stub
		List<BuildingEntity> result = buildingRepository.getBuildings(buildingSearchinput.getName(),
				buildingSearchinput.getDistrict());
		List<BuildingModel> buildingModels = new ArrayList<>();
		for (BuildingEntity item : result) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(item.getName());
			buildingModel.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict());
			buildingModel.setTypeUtf8(getAllType(item.getType()));
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}

	public static String getAllType(String str) {
		StringBuilder type = new StringBuilder("");
		int count = 1;
		String[] split = str.trim().split(",");
		Map<String, String> buildingType = BuildingTypeUtil.getAll();
		for (String item : split) {
				if (buildingType.containsKey(item)) {
					type.append(count+". "+buildingType.get(item)+"\n");
					count++;
				}	
			if(type.toString().equals("")||type.toString().equals(null)) {
				type.append("Nhà Không có kiểu thuê nào hết!!");
			}
		}
		return type.toString();
	}
}
