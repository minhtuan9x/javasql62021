package com.dominhtuan.model.input;

import java.util.List;

public class AssignmentBuildingAdvanceInput {
	private int buildingID;
	private List<Integer> staffIDRemoves;
	private List<Integer> staffIDAdds;
	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	public List<Integer> getStaffIDRemoves() {
		return staffIDRemoves;
	}
	public void setStaffIDRemoves(List<Integer> staffIDRemoves) {
		this.staffIDRemoves = staffIDRemoves;
	}
	public List<Integer> getStaffIDAdds() {
		return staffIDAdds;
	}
	public void setStaffIDAdds(List<Integer> staffIDAdds) {
		this.staffIDAdds = staffIDAdds;
	}
	@Override
	public String toString() {
		return "AssignmentBuildingAdvanceInput [buildingID=" + buildingID + ", staffIDRemoves=" + staffIDRemoves
				+ ", staffIDAdds=" + staffIDAdds + "]";
	}
	

}
