package com.dominhtuan.model.output;

public class BuildingOutput {
	private String name;
	private String street;
	private String ward;
	private String district;
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
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
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
		s =String.format("%-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s ", this.name,this.street
				,this.ward,this.district,this.numberOfBasement,this.floorArea,this.rentArea,this.rentPrice,this.rentType,this.staffName);
		return s;
	}	
}
