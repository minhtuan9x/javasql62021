package com.dominhtuan.view;

import com.dominhtuan.controller.BuildingController;
import com.dominhtuan.util.BuildingUtil;

public class BuildingView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildingController buildingController = new BuildingController();
		BuildingUtil buildingUtil = new BuildingUtil();
		try {
			buildingUtil.showBuilding(buildingController.getAllBuiding(buildingUtil.searchBuilding()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
