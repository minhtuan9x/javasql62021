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
		List<BuildingEntity> result = buildingRepository.getBuildings(buildingSearchinput.getName(),
				buildingSearchinput.getDistrict());
		List<BuildingModel> buildingModels = new ArrayList<>();
		for (BuildingEntity item : result) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(item.getName());
			buildingModel.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict());
			buildingModel.setTypeUtf8(tachchuoi(item.getType()));
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}

	public static String tachchuoi(String t) {
		StringBuilder kieu = new StringBuilder();
		int dem = 1;
		String[] tach = t.trim().split(",");
		for (String item : tach) {
			switch (item) {
			case "tang_tret":
				kieu.append(dem + ". Tầng trệt \n");
				dem++;
				break;
			case "nguyen_can":
				kieu.append(dem + ". Nguyên căn \n");
				dem++;
				break;
			case "noi_that":
				kieu.append(dem + ". Nội thất \n");
				dem++;
				break;
			case "":
				kieu.append("Nhà Không có kiểu thuê nào hết!!");
				break;
			default:
				break;
			}
		}
		return kieu.toString();

	}
}
