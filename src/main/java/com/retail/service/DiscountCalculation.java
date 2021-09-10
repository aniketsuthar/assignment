package com.retail.service;

import com.retail.dto.User;

public interface DiscountCalculation {

	double findNetpayableAmount(User user);

}
