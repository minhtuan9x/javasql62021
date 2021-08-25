package com.dominhtuan.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dominhtuan.controller.AssignmentBuildingController;
import com.dominhtuan.controller.BuildingController;
import com.dominhtuan.model.input.AssignmentBuildingInput;
import com.dominhtuan.model.output.AssignmentBuildingOutput;
import com.dominhtuan.model.output.BuildingIDandNameOutput;

public class AssignmentBuildingUtil {
	
	public void assignmentBuilding() {
		BuildingController buildingController = new BuildingController();
		AssignmentBuildingController assignmentBuildingController = new AssignmentBuildingController();
		Scanner sc = new Scanner(System.in);
		StaffUtil staffUtil = new StaffUtil();
		BuildingUtil buildingUtil = new BuildingUtil();
		System.out.println("Danh sách tòa nhà: ");
		for(BuildingIDandNameOutput item : buildingController.getBuildingNameandID()) {
			System.out.println("ID: "+item.getBuildingID()+"  Name: "+item.getBuildingName());
		}
		System.out.println("Nhập id nhà cần giao cho nhân viên quản lí: ");
		int id = sc.nextInt();
		if(findIDBuilding(id)!=null) {
			try {
				System.out.println("Danh sách nhân viên: ");
				staffUtil.showAllStaff();
				int idinput;
				List<Integer> idinputs = new ArrayList<Integer>();
				while(true) {
					System.out.println("Nhập id nhân viên cần giao, nhập 0 để ngừng nhập");
					idinput = sc.nextInt();
					if(idinput==0)
						break;
					idinputs.add(idinput);
				}
				AssignmentBuildingInput assignmentBuildingInput = new AssignmentBuildingInput();
				assignmentBuildingInput.setIdBuilding(id);
				assignmentBuildingInput.setIdStaff(idinputs);
				boolean result = assignmentBuildingController.assignmentBuilding(assignmentBuildingInput);
				if(result) {
					for(AssignmentBuildingOutput item : assignmentBuildingController.getAllAssignmentBuilding()) {
						System.out.println(String.format("Building: %-40s Staff: %-40s",buildingUtil.findBuildingNameByID(item.getBuildingID()),
								staffUtil.findStaffNameByID(item.getStaffID())));
					}
					System.out.println("Giao cho nhân viên thành công!!");
				}
				else
					System.out.println("Giao thất bại!!");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Không tìm thấy tòa nhà!!!");
		}
		
	}
	public String findIDBuilding(int id) {
		BuildingController buildingController = new BuildingController();
		String result;
		for(BuildingIDandNameOutput item : buildingController.getBuildingNameandID()) {
			if(item.getBuildingID()==id) {
				result="ID: "+item.getBuildingID()+"  Name: "+item.getBuildingName();
				return result;
			}
				
		}
		return null;
	}

}
