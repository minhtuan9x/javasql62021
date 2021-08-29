package com.dominhtuan.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dominhtuan.controller.RentTypeController;
import com.dominhtuan.model.output.RentTypeOutput;

public class RentTypeUtil {
	RentTypeController rentTypeController = new RentTypeController();

	public Map<String, String> getAllRentType() {
		Map<String, String> results = new HashMap<String, String>();
		for (RentTypeOutput item : rentTypeController.getAllRentType()) {
			results.put(item.getCode(), item.getName());
		}
		return results;
	}
	public void showAllRentType() {
		int count = 1;
		for (Map.Entry<String, String> item : getAllRentType().entrySet()) {
			System.out.println(count + ": " + item.getValue());
			count++;
		}
	}
	public Map<String, String> getKeyRentType() {
		Map<String, String> results = new HashMap<String, String>();
		int count = 1;
		for (Map.Entry<String, String> item : getAllRentType().entrySet()) {
			results.put(String.valueOf(count), item.getKey());
			count++;
		}
		return results;
	}
	public List<String> checkRentType(String num) {
		List<String> results = new ArrayList<String>();
		for(Map.Entry<String, String> item : getKeyRentType().entrySet()) {
			for(String item2 : num.split(",")) {
//				if(item.getKey().contains(item2)) {
//					results.add(item.getValue());
//				}
				if(item.getKey() == item2) {
					results.add(item.getValue());
				}
			}
		}
		return results;
	}
}
