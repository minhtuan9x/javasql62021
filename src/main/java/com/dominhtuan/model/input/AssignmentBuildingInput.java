package com.dominhtuan.model.input;

import java.util.List;

public class AssignmentBuildingInput {
	private int idBuilding;
	private List<Integer> idStaff;
	public int getIdBuilding() {
		return idBuilding;
	}
	public void setIdBuilding(int idBuilding) {
		this.idBuilding = idBuilding;
	}
	public List<Integer> getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(List<Integer> idStaff) {
		this.idStaff = idStaff;
	}
	@Override
	public String toString() {
		return "AssignmentBuildingInput [idBuilding=" + idBuilding + ", idStaff=" + idStaff + "]";
	}
	
}
