package com.retail.dto;

import com.retail.enums.UserType;

public class User {

	private UserType userType;
	private int yearsSinceCustomer;
	private Bill totalBill;

	public Bill getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Bill totalBill) {
		this.totalBill = totalBill;
	}

	public int getYearsSinceCustomer() {
		return yearsSinceCustomer;
	}

	public void setYearsSinceCustomer(int yearsSinceCustomer) {
		this.yearsSinceCustomer = yearsSinceCustomer;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
