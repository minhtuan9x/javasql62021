package com.laptrinhjavaweb.view;

import java.util.List;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.model.input.BuildingSearchinput;

public class BuildingView {

	private static BuildingController buildingController = new BuildingController();

	public static void main(String[] args) {
//		String name = null;
//		String district = null;

		String name = "building 1";
		String district = "go vap";
		BuildingSearchinput buildingSearchinput = initBuildingSearchinput(name, district);

		List<BuildingModel> buildings = buildingController.getBuildings(buildingSearchinput);// tao danh sach list co
																								// nhieu model

		showbuilding(buildings);

	}

	private static void showbuilding(List<BuildingModel> buildings) {
		// TODO Auto-generated method stub
		for (BuildingModel item : buildings) {
			System.out.println("Ten toa nha: " + item.getName());
			System.out.println("Dia chi: " + item.getAddress());
		}
	}

	private static BuildingSearchinput initBuildingSearchinput(String name, String district) {
		// TODO Auto-generated method stub
		BuildingSearchinput buildingSearchinput = new BuildingSearchinput();// nhap doi tuong can tim kiem
		buildingSearchinput.setName(name);
		buildingSearchinput.setDistrict(district);
		return buildingSearchinput;
	}
}
