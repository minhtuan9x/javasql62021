package com.dominhtuan.util;

import java.util.Scanner;

public class CheckIntUtil {
	public int convertStringToInt() {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if(str.length()>0) {
			result = Integer.parseInt(str);
			return result;
		}
		return 0;
		
	}
}
