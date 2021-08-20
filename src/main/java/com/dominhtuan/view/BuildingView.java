package com.dominhtuan.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dominhtuan.controller.BuildingController;
import com.dominhtuan.enums.DistrictEnum;
import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.model.output.BuildingOutput;
import com.dominhtuan.util.RentTypeUtil;
import com.dominhtuan.util.StaffUtil;

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
		StaffUtil staffUtil = new StaffUtil();
		RentTypeUtil rentTypeUtil = new RentTypeUtil();
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
			showAllStaff();
			System.out.println("Nhập tên nhân viên phụ trách: ");
			sc.nextLine();
			String staffName = sc.nextLine();
			int staffID = staffUtil.checkStaffName(staffName);
			System.out.println("Danh sách loại tòa nhà: ");
			rentTypeUtil.showAllRentType();
			System.out.println("Nhập loại tòa nhà cách nhau bằng dấu , ");
			String num = sc.nextLine();
			List<String> rentType = rentTypeUtil.checkRentType(num);
			if(rentType.size()==0) {
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

	public static void showAllStaff() {
		StaffUtil staffUtil = new StaffUtil();
		for(Map.Entry<Integer, String> item : staffUtil.getAllStaff().entrySet()) {
			System.out.println("ID: "+item.getKey()+" Name: "+item.getValue());
		}

	}

	public static void td() {
		System.out
				.println(String.format("%-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s ", "Name", "Street",
						"Ward", "District", "NOB", "Floor area", "Rent Area", "Rent Price", "Rent Type", "Staff Name"));
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
