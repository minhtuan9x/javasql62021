package com.dominhtuan.util;

import java.util.List;
import java.util.Scanner;

import com.dominhtuan.controller.BuildingController;
import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.model.output.BuildingOutput;

public class BuildingUtil {
	BuildingController buildingController = new BuildingController();
	CheckIntUtil checkIntUtil = new CheckIntUtil();

	public void td() {
		System.out.println(String.format("%-15s %-30s %-45s %-15s %-15s %-15s %-15s %-30s %-35s %-15s %-15s ","Created Date", "Name", "Address", "NOB",
				"Floor area", "Rent Area", "Rent Price", "Rent Type", "Staff Name","Manager Name","Manager Phone"));
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
	
	public InputSearchBuilding searchBuilding() {
		Scanner sc = new Scanner(System.in);
		InputSearchBuilding inputSearchBuilding = new InputSearchBuilding();
		StaffUtil staffUtil = new StaffUtil();
		RentTypeUtil rentTypeUtil = new RentTypeUtil();
		DistrictUtil districtUtil = new DistrictUtil();
		try {
			System.out.println("CHỨC NĂNG TÌM TÒA NHÀ");
			System.out.println("Bắt đầu nhập giá trị trường cần tìm!!!!");
			System.out.println("Nhập 0 để bỏ qua trường không tìm kiếm");
			System.out.println("Nhập tên tòa nhà: ");
			String name = sc.nextLine();
//			String name = "0";
			System.out.println("Nhập diện tích sàn: ");
			int floorArea = checkIntUtil.convertStringToInt();
//			int floorArea = 0;
			System.out.println("Danh sách quận: ");
			districtUtil.showDistrict();
			System.out.println("Nhập code quận: ");
			sc.nextLine();
			String districtID = sc.nextLine();
//			String districtID = "0";
			if (districtUtil.checkDistrictInput(districtID).equals("0")) {
				System.out.println("Không tìm thấy quận theo code!");
				districtID = "0";
			}
			System.out.println("Nhập phường: ");
			String ward = sc.nextLine();
//			String ward = "0";
			System.out.println("Nhập đường: ");
			String street = sc.nextLine();
//			String street = "0";
			System.out.println("Nhập tên quản lí: ");
			String managerName = sc.nextLine();
			System.out.println("Nhập số điện thoại quản lí: ");
			String managerPhone = sc.nextLine();
			System.out.println("Nhập số tầng hầm: ");
			int numberOfBasement = checkIntUtil.convertStringToInt();
//			int numberOfBasement = 0;
			System.out.println("Diện tích từ: ");
//			int rentAreaFrom = 0;
			int rentAreaFrom = checkIntUtil.convertStringToInt();
			System.out.println("Diện tích đến: ");
			int rentAreaTo = checkIntUtil.convertStringToInt();
//			int rentAreaTo = 0;
			System.out.println("Gía thuê từ: ");
			int rentPriceFrom = checkIntUtil.convertStringToInt();
//			int rentPriceFrom = 0;
			System.out.println("Gía thuê đến: ");
			int rentPriceTo = checkIntUtil.convertStringToInt();
//			int rentPriceTo = 0;
			System.out.println("Danh sách nhân viên phụ trách: ");
			staffUtil.showAllStaff();
			System.out.println("Nhập tên nhân viên phụ trách: ");
			sc.nextLine();
			String staffName = sc.nextLine();
			int staffID = staffUtil.checkStaffName(staffName);
			System.out.println("Danh sách loại tòa nhà: ");
			rentTypeUtil.showAllRentType();
			System.out.println("Nhập loại tòa nhà cách nhau bằng dấu , ");
			String num = sc.nextLine();
			List<String> rentType = rentTypeUtil.checkRentType(num);
			if (rentType.size() == 0) {
				System.out.println("Không tìm thấy loại tòa nhà!");
			}
			
			
			inputSearchBuilding.setDistrictID(districtID);
			inputSearchBuilding.setFloorArea(floorArea);
			inputSearchBuilding.setName(name);
			inputSearchBuilding.setNumberOfBasement(numberOfBasement);
			inputSearchBuilding.setRentAreaFrom(rentAreaFrom);
			inputSearchBuilding.setRentAreaTo(rentAreaTo);
			inputSearchBuilding.setStaffID(staffID);
			inputSearchBuilding.setStreet(street);
			inputSearchBuilding.setWard(ward);
			inputSearchBuilding.setRentPriceFrom(rentPriceFrom);
			inputSearchBuilding.setRentPriceTo(rentPriceTo);
			inputSearchBuilding.setValueRentType(rentType);
			inputSearchBuilding.setManagerName(managerName);
			inputSearchBuilding.setManagerPhone(managerPhone);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return inputSearchBuilding;
	}

}
