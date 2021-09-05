package com.dominhtuan.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dominhtuan.controller.AssignmentBuildingController;
import com.dominhtuan.model.input.AssignmentBuildingInput;

public class AssignmentBuildingUtil {

    public AssignmentBuildingInput inputAssignmentBuilding() {
        Scanner sc = new Scanner(System.in);
        CheckIntUtil checkIntUtil = new CheckIntUtil();
        Checkinput checkinput = new Checkinput();
        StaffUtil staffUtil = new StaffUtil();
        AssignmentBuildingInput assignmentBuildingInput = new AssignmentBuildingInput();
        System.out.println("Nhập id tòa nhà cần giao cho nhân viên quản lí: ");
        int buildingID = checkIntUtil.convertStringToInt();
        if (checkinput.is0(buildingID))
            return null;
        System.out.println("Danh sách nhân viên: ");
        staffUtil.showAllStaffByBuildingID(buildingID);
        System.out.println("Nhập id các nhân viên cần giao cách nhau bằng dấu , (ex: 1,2,3,..) :");
        String stafflist = sc.nextLine();
        if (checkinput.is0(stafflist))
            return null;
        List<Integer> staffs = new ArrayList<Integer>();
        for (String item : stafflist.trim().split(",")) {
            staffs.add(Integer.valueOf(item));
        }
        assignmentBuildingInput.setBuildingID(buildingID);
        assignmentBuildingInput.setStaffID(staffs);

        return assignmentBuildingInput;
    }

    public void assignmentBuilding() {
        AssignmentBuildingController assignmentBuildingController = new AssignmentBuildingController();
        StaffUtil staffUtil = new StaffUtil();
        AssignmentBuildingInput assignmentBuildingInput = inputAssignmentBuilding();
        if (assignmentBuildingController.assignmentBuilding(assignmentBuildingInput)) {
            System.out.println("Giao tòa nhà cho nhân viên thành công!!!");
            staffUtil.showAllStaffByBuildingID(assignmentBuildingInput.getBuildingID());
        } else
            System.out.println("Giao tòa nhà cho nhân viên thất bại!!");
    }
}
