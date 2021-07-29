package com.toicodedao.server.impl;

import java.util.ArrayList;
import java.util.List;

import com.toicodedao.controller.BuildingController;
import com.toicodedao.model.BuildingModel;
import com.toicodedao.model.input.BuildingInput;
import com.toicodedao.reponsitory.entity.BuildingEntity;
import com.toicodedao.reponsitory.impl.BuildingReponsitory;
import com.toicodedao.server.IBuildingServer;

public class BuildingServer implements IBuildingServer {
	BuildingReponsitory buildingReponsitory;
	BuildingModel buildingModel;
	BuildingEntity buildingEntity;
	BuildingController buildingController;

	public List<BuildingModel> getBuildingSearch(BuildingInput buildingInput) {
		// TODO Auto-generated method stub
		List<BuildingModel> buildingModels = new ArrayList<BuildingModel>();
		buildingReponsitory = new BuildingReponsitory();
		for (BuildingEntity item : buildingReponsitory.getBuildingSearch(buildingInput)) {
			buildingModel = new BuildingModel();
			buildingModel.setId(item.getId());
			buildingModel.setName(item.getName());
			buildingModel.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict());
			buildingModel.setType(tachchuoi(item.getType()));
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}

	public String tachchuoi(String t) {
		StringBuilder kieu = new StringBuilder();
		String[] tach = t.trim().split(",");
		int dem = 1;
		for (String item : tach) {
			switch (item) {
			case "tang_tret":
				kieu.append(dem+". Tầng trệt\n");
				dem++;
				break;
			case "nguyen_can":
				kieu.append(dem+". Nguyên căn\n");
				dem++;
				break;
			case "noi_that":
				kieu.append(dem+". Nội thất\n");
				dem++;
				break;

			default:
				kieu.append("Không có kiểu thuê nào!!");
				break;
			}
		}
		return kieu.toString();

	}

	public boolean setBuilding(BuildingModel buildingModel) throws Exception {
		buildingEntity = new BuildingEntity();
		buildingReponsitory = new BuildingReponsitory();
		// TODO Auto-generated method stub
		buildingController = new BuildingController();
		BuildingInput buildingInput = new BuildingInput();
		buildingInput.setName("");
		for (BuildingModel item : buildingController.getBuildingSearch(buildingInput)) {
			if (item.getId() == buildingModel.getId()) {
				throw new Exception("Trung ma");
			}
		}
		buildingEntity.setId(buildingModel.getId());
		buildingEntity.setName(buildingModel.getName());
		String tach[] = diachi(buildingModel.getAddress());
		buildingEntity.setStreet(tach[0]);
		buildingEntity.setWard(tach[1]);
		buildingEntity.setDistrict(tach[2]);
		buildingEntity.setType(buildingModel.getType());
		if (buildingReponsitory.setBuilding(buildingEntity))
			return true;
		return false;
	}

	public String[] diachi(String t) {
		String[] tach = t.trim().split(" - ");
		return tach;
	}

	public boolean deleteBuilding(BuildingInput buildingInput) {
		// TODO Auto-generated method stub
		buildingReponsitory = new BuildingReponsitory();
		if (buildingReponsitory.deleteBuilding(buildingInput))
			return true;
		return false;
	}

	public List<BuildingModel> getALLBuilding() {
		// TODO Auto-generated method stub
		List<BuildingModel> buildingModels = new ArrayList<BuildingModel>();
		buildingReponsitory = new BuildingReponsitory();
		for (BuildingEntity item : buildingReponsitory.getALLBuilding()) {
			buildingModel = new BuildingModel();
			buildingModel.setId(item.getId());
			buildingModel.setName(item.getName());
			buildingModel.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict());
			buildingModel.setType(tachchuoi(item.getType()));
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}

}
