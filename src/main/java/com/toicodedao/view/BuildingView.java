package com.toicodedao.view;

import java.util.List;
import java.util.Scanner;

import com.toicodedao.controller.BuildingController;
import com.toicodedao.model.BuildingModel;
import com.toicodedao.model.input.BuildingInput;

public class BuildingView {
	static Scanner sc = new Scanner(System.in);
	static Scanner scint = new Scanner(System.in);
	static BuildingController buildingController = new BuildingController();
	static BuildingModel buildingModel;

	public static void main(String[] args) {
		menu();

	}

	static void xuatds(List<BuildingModel> buildingModels) {
		for (BuildingModel item : buildingModels) {
			System.out.println("id: "+item.getId());
			System.out.println("Name: "+item.getName());
			System.out.println("Address: "+item.getAddress());
			System.out.println("Type: ");
			System.out.println(item.getType());
		}
	}

	static void menu() {
		while (true) {
			menutieude();
			System.out.println("Moi ban chon");
			int chon = scint.nextInt();
			try {
				switch (chon) {
				case 1:
					System.out.println("Moi nhap ten toa nha can tim");
					String name = sc.nextLine();
					BuildingInput buildingInput = new BuildingInput();
					buildingInput.setName(name);
					xuatds(buildingController.getBuildingSearch(buildingInput));
					break;
				case 2:
					if (buildingController.setBuilding(them()))
						System.out.println("Them Thanh Cong");
					else
						System.out.println("Them that bai");
					break;
				case 3:
					System.out.println("Nhap ten toa nha muon xoa: ");
					String tenxoa = sc.nextLine();
					buildingInput = new BuildingInput();
					buildingInput.setName(tenxoa);
					if (buildingController.deleteBuilding(buildingInput))
						System.out.println("Xoa thanh cong");
					else
						System.out.println("Xoa that bai");
					break;
				case 4:
					xuatds(buildingController.getAllBuilding());
					break;
				case 0:
					return;
				default:
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	static void menutieude() {
		System.out.println("1. Tim kiem theo ten");
		System.out.println("2. Them toa nha");
		System.out.println("3. Xoa toa nha");
		System.out.println("4. Xuat toan bo toa nha");
		System.out.println("0. Thoat");
	}

	static BuildingModel them() {
		buildingModel = new BuildingModel();
		System.out.println("Nhap id: ");
		int id = scint.nextInt();
		System.out.println("Nhap name: ");
		String ten = sc.nextLine();
		System.out.println("Nhap duong: ");
		String duong = sc.nextLine();
		System.out.println("Nhap phuong: ");
		String phuong = sc.nextLine();
		System.out.println("Nhap quan: ");
		String quan = sc.nextLine();
		String diachi = duong + " - " + phuong + " - " + quan;
		System.out.println("Nhap kieu thue: ");
		String kieu = sc.nextLine();
		buildingModel.setId(id);
		buildingModel.setName(ten);
		buildingModel.setAddress(diachi);
		buildingModel.setType(kieu);
		return buildingModel;
	}
}
