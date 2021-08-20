package com.dominhtuan.model.input;

import java.util.List;

public class InputSearchBuilding {
	private String name;
	private int floorArea;
	private String districtID;
	private String ward;
	private String street;
	private int numberOfBasement;
	private int rentAreaFrom;
	private int rentAreaTo;
	private int rentPriceFrom;
	private int rentPriceTo;
	private int staffID;
	private List<String> valueRentType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}

	public String getDistrictID() {
		return districtID;
	}
	public void setDistrictID(String districtID) {
		this.districtID = districtID;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(int numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public int getRentAreaFrom() {
		return rentAreaFrom;
	}
	public void setRentAreaFrom(int rentAreaFrom) {
		this.rentAreaFrom = rentAreaFrom;
	}
	public int getRentAreaTo() {
		return rentAreaTo;
	}
	public void setRentAreaTo(int rentAreaTo) {
		this.rentAreaTo = rentAreaTo;
	}
	public int getRentPriceFrom() {
		return rentPriceFrom;
	}
	public void setRentPriceFrom(int rentPriceFrom) {
		this.rentPriceFrom = rentPriceFrom;
	}
	public int getRentPriceTo() {
		return rentPriceTo;
	}
	public void setRentPriceTo(int rentPriceTo) {
		this.rentPriceTo = rentPriceTo;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public List<String> getValueRentType() {
		return valueRentType;
	}
	public void setValueRentType(List<String> valueRentType) {
		this.valueRentType = valueRentType;
	}
	@Override
	public String toString() {
		return "InputSearchBuilding [name=" + name + ", floorArea=" + floorArea + ", districtID=" + districtID
				+ ", ward=" + ward + ", street=" + street + ", numberOfBasement=" + numberOfBasement + ", rentAreaFrom="
				+ rentAreaFrom + ", rentAreaTo=" + rentAreaTo + ", rentPriceFrom=" + rentPriceFrom + ", rentPriceTo="
				+ rentPriceTo + ", staffID=" + staffID + "]";
	}
	
	
}
