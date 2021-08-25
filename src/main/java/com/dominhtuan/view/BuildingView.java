package com.dominhtuan.view;

import java.util.Scanner;

import com.dominhtuan.controller.BuildingController;
import com.dominhtuan.util.AssignmentBuildingUtil;
import com.dominhtuan.util.BuildingUtil;

public class BuildingView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildingController buildingController = new BuildingController();
		BuildingUtil buildingUtil = new BuildingUtil();
		AssignmentBuildingUtil assignmentBuildingUtil = new AssignmentBuildingUtil();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("1. Tìm tòa nhà");
			System.out.println("2. Giao tòa nhà cho nhân viên quản lí");
			int chose = sc.nextInt();
			switch (chose) {
			case 1:
				buildingUtil.showBuilding(buildingController.getAllBuiding(buildingUtil.searchBuilding()));
				break;
			case 2:
				assignmentBuildingUtil.assignmentBuilding();
				break;

			default:
				break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
