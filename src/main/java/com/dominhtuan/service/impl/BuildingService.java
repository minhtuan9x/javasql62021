package com.dominhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.model.output.BuildingOutput;
import com.dominhtuan.reponsitory.entity.BuildingEntity;
import com.dominhtuan.reponsitory.impl.BuildingReponsitory;
import com.dominhtuan.service.IBuildingService;

public class BuildingService implements IBuildingService {

	public List<BuildingOutput> getAllBuilding(InputSearchBuilding inputSearchBuilding) {
		// TODO Auto-generated method stub
		List<BuildingOutput> buildingOutputs = new ArrayList<BuildingOutput>();
		BuildingReponsitory buildingReponsitory = new BuildingReponsitory();
		List<BuildingEntity> ds = buildingReponsitory.getAllBuilding(inputSearchBuilding);
		BuildingOutput buildingOutput;
		List<String> names = removeDuplicateName(ds);
		String rentType = "";
		String rentArea = "";
		//
		for (BuildingEntity item : ds) {
			for (String item2 : names) {
				if (item2.equals(item.getName())) {
					for (BuildingEntity item3 : ds) {
						if (item2.equals(item3.getName())) {
							if (item3.getRentArea() != 0)
								rentArea += item3.getRentArea() + ",";
							if (item3.getRentType() != null)
								rentType += item3.getRentType() + ",";
						}

					}
				}
			}
			rentArea = removeDuplicate(rentArea);
			rentType = removeDuplicate(rentType);
			rentArea = removeComma(rentArea);
			rentType = removeComma(rentType);
			buildingOutput = new BuildingOutput();
			buildingOutput.setName(item.getName());
			buildingOutput.setAddresss(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrictName());
			buildingOutput.setFloorArea(item.getFloorArea());
			buildingOutput.setNumberOfBasement(item.getNumberOfBasement());
			buildingOutput.setRentArea(rentArea);
			buildingOutput.setRentType(rentType);
			buildingOutput.setRentPrice(item.getRentPrice());
			buildingOutput.setStaffName(item.getStaffName());
			buildingOutputs.add(buildingOutput);
			rentType = "";
			rentArea = "";
		}
		buildingOutputs = removeDuplicateList(buildingOutputs);
		return buildingOutputs;
	}

	public String removeDuplicate(String a) {
		String result = "";
		List<String> ds = new ArrayList<>();
		List<String> ds2 = new ArrayList<>();
		for (String item : a.split(",")) {
			ds.add(item);
		}

		for (String item2 : ds) {
			if (!ds2.contains(item2)) {
				ds2.add(item2);
			}
		}
		for (String item2 : ds2)
			result += item2 + ",";
		return result;
	}
	public List<BuildingOutput> removeDuplicateList(List<BuildingOutput> buildingOutputs){
		List<BuildingOutput> results = new ArrayList<>();
		for (BuildingOutput item : buildingOutputs) {
			if (!results.contains(item)) {
				results.add(item);
			}
		}
		return results;
	}
	public List<String> removeDuplicateName(List<BuildingEntity> buildingEntities){
		List<String> names = new ArrayList<>();
		for (BuildingEntity item : buildingEntities) {
			if (!names.contains(item.getName())) {
				names.add(item.getName());
			}
		}
		return names;
	}
	public String removeComma(String input) {
		String result= "";
		for(int i = 0;i<input.length()-1;i++) {
			result+=input.charAt(i);
		}
		return result;
	}
}
