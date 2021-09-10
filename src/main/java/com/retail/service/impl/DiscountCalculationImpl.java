package com.retail.service.impl;

import org.springframework.stereotype.Service;

import com.retail.dto.User;
import com.retail.enums.ItemType;
import com.retail.service.DiscountCalculation;

@Service
public class DiscountCalculationImpl implements DiscountCalculation {

	public double findNetpayableAmount(User user) {
		double netAmount = 0;
		double billAmount = user.getTotalBill().getItems().stream().filter(e -> e.getType() == ItemType.NOT_GROCERRY)
				.mapToDouble(e -> e.getValue()).sum();

		if (billAmount >= 100.0 && billAmount / 100 > 0) {
			billAmount = billAmount - ((int) (billAmount / 100) * 5);
		}
		switch (user.getUserType()) {

		case EMPLOYEE:
			return netAmount = billAmount - ((30 * billAmount) / 100);

		case AFFILIATE:
			return netAmount = billAmount - ((10 * billAmount) / 100);

		case CUSTOMER:
			if (user.getYearsSinceCustomer() > 2) {
				return netAmount = billAmount - ((5 * billAmount) / 100);
			} else {
				return billAmount;
			}
		}
		return netAmount;
	}

}
