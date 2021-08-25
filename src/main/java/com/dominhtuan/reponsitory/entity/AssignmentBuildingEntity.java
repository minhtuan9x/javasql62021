package com.dominhtuan.reponsitory.entity;

public class AssignmentBuildingEntity {
	private int staffID;
	private int buildingID;
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	@Override
	public String toString() {
		return "AssignmentBuildingEntity [staffID=" + staffID + ", buildingID=" + buildingID + "]";
	}
	
}
