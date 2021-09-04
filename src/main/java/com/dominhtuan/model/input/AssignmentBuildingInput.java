package com.dominhtuan.model.input;

import java.util.List;

public class AssignmentBuildingInput {
	private int  buildingID;
	private List<Integer> staffID;

	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	public List<Integer> getStaffID() {
		return staffID;
	}
	public void setStaffID(List<Integer> staffID) {
		this.staffID = staffID;
	}
	@Override
	public String toString() {
		return "AssignmentBuildingInput [buildingID=" + buildingID + ", staffID=" + staffID + "]";
	}

}
