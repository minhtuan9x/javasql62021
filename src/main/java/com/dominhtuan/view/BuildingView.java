package com.dominhtuan.view;

import java.util.List;
import java.util.Scanner;

import com.dominhtuan.controller.BuildingController;
import com.dominhtuan.controller.StaffController;
import com.dominhtuan.enums.DistrictEnum;
import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.model.output.BuildingOutput;
import com.dominhtuan.model.output.StaffOutput;

public class BuildingView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildingController buildingController = new BuildingController();
		try {
			showBuilding(buildingController.getAllBuiding(searchBuilding()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static InputSearchBuilding searchBuilding() {
		Scanner sc = new Scanner(System.in);
		InputSearchBuilding inputSearchBuilding = new InputSearchBuilding();
		try {
			System.out.println("CHỨC NĂNG TÌM TÒA NHÀ");
			System.out.println("Bắt đầu nhập giá trị trường cần tìm!!!!");
			System.out.println("Nhập 0 để bỏ qua trường không tìm kiếm");
			System.out.println("Nhập tên tòa nhà: ");
			String name = sc.nextLine();
			System.out.println("Nhập diện tích sàn: ");
			int floorArea = sc.nextInt();
			System.out.println("Danh sách quận: ");
			getDistrict();
			System.out.println("Nhập code quận: ");
			sc.nextLine();
			String districtID = sc.nextLine();
			System.out.println("Nhập phường: ");
			String ward = sc.nextLine();
			System.out.println("Nhập đường: ");
			String street = sc.nextLine();
			System.out.println("Nhập số tầng hầm: ");
			int numberOfBasement = sc.nextInt();
			System.out.println("Diện tích từ: ");
			int rentAreaFrom = sc.nextInt();
			System.out.println("Diện tích đến: ");
			int rentAreaTo = sc.nextInt();
			System.out.println("Gía thuê từ: ");
			int rentPriceFrom = sc.nextInt();
			System.out.println("Gía thuê đến: ");
			int rentPriceTo = sc.nextInt();
			System.out.println("Danh sách nhân viên phụ trách: ");
			getAllStaff();
			System.out.println("Nhập id nhân viên phụ trách: ");
			int staffID = sc.nextInt();

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
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return inputSearchBuilding;
	}

	public static void getDistrict() {
		for (DistrictEnum item : DistrictEnum.values()) {
			System.out.println(item + ": " + item.getValue());
		}
	}

	public static void getAllStaff() {
		StaffController staffController = new StaffController();
		for (StaffOutput item : staffController.getAllStaff()) {
			System.out.println("ID: " + item.getStaffID() + "  Name: " + item.getStaffName());
		}
	}

	public static void td() {
		System.out.println(String.format("%-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s ", "Name", "Street",
				"Ward", "District", "NOB", "Floor area", "Rent Area", "Rent Type", "Staff Name"));
	}

	public static void showBuilding(List<BuildingOutput> buildingOutputs) {
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
