package com.dominhtuan.util;

import java.util.HashMap;
import java.util.Map;

import com.dominhtuan.controller.DistrictController;
import com.dominhtuan.model.output.DistrictOutput;

public class DistrictUtil {
	DistrictController districtController = new DistrictController();

	public Map<String, String> getAllDistrict() {
		Map<String, String> result = new HashMap<String, String>();
		for (DistrictOutput item : districtController.getAllDistrict()) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

	public void showDistrict() {
		for (Map.Entry<String, String> item : getAllDistrict().entrySet()) {
			System.out.println("Code: " + item.getKey() + "   Name:" + item.getValue());
		}
	}

	public String checkDistrictInput(String districtCode) {
		String result = "";
		for (Map.Entry<String, String> item : getAllDistrict().entrySet()) {
			if (districtCode.equals(item.getKey())) {
				result = districtCode;
				return result;
			}
		}
		result = "0";
		return result;
	}
}
