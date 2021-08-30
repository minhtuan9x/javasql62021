package com.dominhtuan.reponsitory;

import java.util.List;

import com.dominhtuan.reponsitory.entity.DistrictEntity;

public interface IDistrictReponsitory {
	List<DistrictEntity> getAllDistrict();
	String findByDistrictID(int districtId);
}
