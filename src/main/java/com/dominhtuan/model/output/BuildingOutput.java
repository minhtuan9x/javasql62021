package com.dominhtuan.model.output;

public class BuildingOutput {
	private String name;
	private String addresss;
	private int numberOfBasement;
	private int floorArea;
	private String rentArea;
	private String rentPrice;
	private String rentType;
	private String staffName;
	private String managerName;
	private String managerPhone;

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



	public String getRentArea() {
		return rentArea;
	}

	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}

	public String getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(String rentPrice) {
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
	
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuildingOutput other = (BuildingOutput) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s;
		s = String.format("%-30s %-45s %-15s %-15s %-15s %-15s %-30s %-15s %-15s %-15s ", this.name, this.addresss,
				this.numberOfBasement, this.floorArea, this.rentArea, this.rentPrice, this.rentType, this.staffName,this.managerName,this.managerPhone);
		return s;
	}
}
