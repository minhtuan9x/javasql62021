package com.dominhtuan.model.output;

public class StaffAssignmentOutput {
	private int staffID;
	private String staffName;
	private String checked;
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	@Override
	public String toString() {
		return String.format("%-5s %-20s %-10s", this.staffID, this.staffName,this.checked);
	}

	
}
