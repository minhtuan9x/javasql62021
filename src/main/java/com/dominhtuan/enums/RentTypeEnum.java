package com.dominhtuan.enums;

public enum RentTypeEnum {
	tang_tret("Tầng trệt"),
	nguyen_can("Nguyên Căn"),
	noi_that("Nội Thất");
	

	private String value;
	
	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	private RentTypeEnum(String value) {
		this.value = value;
	}



	
}
