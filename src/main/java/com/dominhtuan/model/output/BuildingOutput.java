package com.dominhtuan.model.output;

public class BuildingOutput {
	private String name;
	private String addresss;
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

	public String getAddresss() {
		return addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
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
		String s;
		s = String.format("%-30s %-45s %-15s %-15s %-15s %-15s %-15s %-15s ", this.name, this.addresss,
				this.numberOfBasement, this.floorArea, this.rentArea, this.rentPrice, this.rentType, this.staffName);
		return s;
	}
}
