package com.dominhtuan.util;

import java.util.List;

import com.dominhtuan.controller.BuildingController;
import com.dominhtuan.model.output.BuildingOutput;

public class BuildingUtil {
	BuildingController buildingController = new BuildingController();
	
	public void td() {
		System.out
				.println(String.format("%-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s ", "Name", "Street",
						"Ward", "District", "NOB", "Floor area", "Rent Area", "Rent Price", "Rent Type", "Staff Name"));
	}

	public void showBuilding(List<BuildingOutput> buildingOutputs) {
		System.out.println("======================");
		if (buildingOutputs.size() <= 0) {
			System.out.println("Không tìm thấy!!!");
			return;
		}
		td();
		for (BuildingOutput item : buildingOutputs) {
			System.out.println(item);
		}
	}
}
