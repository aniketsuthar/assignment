package com.retail.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.dto.User;
import com.retail.service.DiscountCalculation;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("discount")
public class DiscountCalculationController {

	@Autowired
	DiscountCalculation discService;

	@PostMapping("getnetAmount")
	@ApiOperation(value = "Populates net payable amount given the bill.", response = Double.class)
	public double getNetAmount(@RequestBody User user) {
		return discService.findNetpayableAmount(user);
	}

}
