package com.dominhtuan.util;

import java.util.HashMap;
import java.util.Map;

import com.dominhtuan.controller.StaffController;
import com.dominhtuan.model.output.StaffOutput;

public class StaffUtil {
	public Map<Integer, String> getAllStaff() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		StaffController staffController = new StaffController();
		for (StaffOutput item : staffController.getAllStaff()) {
			result.put(item.getStaffID(), item.getStaffName());
		}
		return result;
	}

	public void showAllStaff() {
		for (Map.Entry<Integer, String> item : getAllStaff().entrySet()) {
			System.out.println("ID: " + item.getKey() + " Name: " + item.getValue());
		}

	}

	public int checkStaffName(String staffName) {
		int result = 0;
		Map<Integer, String> staffs = getAllStaff();
		if (staffs.containsValue(staffName)) {
			for (Map.Entry<Integer, String> item : staffs.entrySet()) {
				if (item.getValue().equals(staffName)) {
					System.out.println("ID: " + item.getKey());
					result = item.getKey();
				}
			}
		}
		if (result == 0) {
			System.out.println("Không tìm thấy nhân viên!");
			return 0;
		}
		return result;
	}
}
