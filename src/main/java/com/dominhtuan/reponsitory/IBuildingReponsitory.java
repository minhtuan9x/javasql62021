package com.dominhtuan.reponsitory;

import java.util.List;

import com.dominhtuan.model.input.InputSearchBuilding;
import com.dominhtuan.reponsitory.entity.BuildingEntity;

public interface IBuildingReponsitory {
	List<BuildingEntity> getAllBuilding(InputSearchBuilding inputSearchBuilding);
}
