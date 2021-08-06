package com.laptrinhjavaweb.util;

import java.util.HashMap;
import java.util.Map;

import com.laptrinhjavaweb.contants.BuildingContants;

public class BuildingTypeUtil {
	public static Map<String, String> getAll(){
		Map<String, String> result = new HashMap<>();
		result.put(BuildingContants.TANG_TRET, BuildingContants.VALUE_TANG_TRET);
		result.put(BuildingContants.NOI_THAT, BuildingContants.VALUE_NOI_THAT);
		result.put(BuildingContants.NGUYEN_CAN, BuildingContants.VALUE_NGUYEN_CAN);
		return result;
	}
}
