package com.dominhtuan.reponsitory.entity;

public class BuildingEntity {
	private String name;
	private String street;
	private String ward;
	private int districtId;
	private String districtName;
	private int numberOfBasement;
	private int floorArea;
	private int rentArea;
	private int rentPrice;
	private String rentType;
	private String staffName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(int numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public int getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}

	public int getRentArea() {
		return rentArea;
	}

	public void setRentArea(int rentArea) {
		this.rentArea = rentArea;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "BuildingEntity [name=" + name + ", street=" + street + ", ward=" + ward + ", districtId=" + districtId
				+ ", districtName=" + districtName + ", numberOfBasement=" + numberOfBasement + ", floorArea="
				+ floorArea + ", rentArea=" + rentArea + ", rentPrice=" + rentPrice + ", rentType=" + rentType
				+ ", staffName=" + staffName + "]";
	}
	

}
