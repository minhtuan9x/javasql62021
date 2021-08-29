package com.dominhtuan.util;

public class Checkinput {
	public boolean is0(String str) {
		if (str.equals("0") || str.equals("") || str.equals(null)) {
			return true;
		}
		return false;
	}

	public boolean is0(int number) {
		if (number == 0)
			return true;
		return false;
	}
}
