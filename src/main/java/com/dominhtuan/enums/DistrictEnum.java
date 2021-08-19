package com.dominhtuan.enums;

public enum DistrictEnum {
	Q1 ("Quận 1"),
	Q2 ("Quận 2"),
	Q3 ("Quận 3"),
	Q4 ("Quận 4"),
	Q5 ("Quận 5"),
	Q6 ("Quận 6"),
	Q7 ("Quận 7"),
	Q8 ("Quận 8"),
	Q9 ("Quận 9"),
	Q10 ("Quận 10");
	

	private String value;
	
	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	private DistrictEnum(String value) {
		this.value = value;
	}

	
}
