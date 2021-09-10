package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.retail.dto.Bill;
import com.retail.dto.Item;
import com.retail.dto.User;
import com.retail.enums.ItemType;
import com.retail.enums.UserType;

class RetailStoreApplicationTests extends AbstractTest {
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testForEmployee() throws Exception {
		String uri = "/discount/getnetAmount";
		User user = new User();
		user.setUserType(UserType.EMPLOYEE);

		Bill bill = new Bill();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setType(ItemType.NOT_GROCERRY);
		item.setValue(80.0);

		Item item2 = new Item();
		item2.setType(ItemType.NOT_GROCERRY);
		item2.setValue(80.0);

		items.add(item2);
		items.add(item);
		bill.setItems(items);
		user.setTotalBill(bill);

		String inputJson = super.mapToJson(user);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Double netAmount = Double.valueOf(mvcResult.getResponse().getContentAsString());
		assertEquals(netAmount, 108.5, 0.0);
	}

	@Test
	public void testForEmployeeWithGrocerry() throws Exception {
		String uri = "/discount/getnetAmount";
		User user = new User();
		user.setUserType(UserType.EMPLOYEE);

		Bill bill = new Bill();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setType(ItemType.GROCERRY);
		item.setValue(80.0);

		Item item2 = new Item();
		item2.setType(ItemType.NOT_GROCERRY);
		item2.setValue(80.0);

		items.add(item2);
		items.add(item);
		bill.setItems(items);
		user.setTotalBill(bill);

		String inputJson = super.mapToJson(user);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Double netAmount = Double.valueOf(mvcResult.getResponse().getContentAsString());
		assertEquals(netAmount, 56.0, 0.0);
	}

	@Test
	public void testForAffiliateWithGrocerry() throws Exception {
		String uri = "/discount/getnetAmount";
		User user = new User();
		user.setUserType(UserType.AFFILIATE);

		Bill bill = new Bill();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setType(ItemType.GROCERRY);
		item.setValue(80.0);

		Item item2 = new Item();
		item2.setType(ItemType.NOT_GROCERRY);
		item2.setValue(80.0);

		items.add(item2);
		items.add(item);
		bill.setItems(items);
		user.setTotalBill(bill);

		String inputJson = super.mapToJson(user);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Double netAmount = Double.valueOf(mvcResult.getResponse().getContentAsString());
		assertEquals(netAmount, 72.0, 0.0);
	}

	@Test
	public void testForAffiliate() throws Exception {
		String uri = "/discount/getnetAmount";
		User user = new User();
		user.setUserType(UserType.AFFILIATE);

		Bill bill = new Bill();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setType(ItemType.NOT_GROCERRY);
		item.setValue(80.0);

		Item item2 = new Item();
		item2.setType(ItemType.NOT_GROCERRY);
		item2.setValue(80.0);

		items.add(item2);
		items.add(item);
		bill.setItems(items);
		user.setTotalBill(bill);

		String inputJson = super.mapToJson(user);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Double netAmount = Double.valueOf(mvcResult.getResponse().getContentAsString());
		assertEquals(netAmount, 139.5, 0.0);
	}

	@Test
	public void testForCustomerWithGrocerryLessThan2years() throws Exception {
		String uri = "/discount/getnetAmount";
		User user = new User();
		user.setUserType(UserType.CUSTOMER);
		user.setYearsSinceCustomer(1);
		Bill bill = new Bill();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setType(ItemType.GROCERRY);
		item.setValue(80.0);

		Item item2 = new Item();
		item2.setType(ItemType.NOT_GROCERRY);
		item2.setValue(80.0);

		items.add(item2);
		items.add(item);
		bill.setItems(items);
		user.setTotalBill(bill);

		String inputJson = super.mapToJson(user);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Double netAmount = Double.valueOf(mvcResult.getResponse().getContentAsString());
		assertEquals(netAmount, 80.0, 0.0);
	}

	@Test
	public void testForCustomerLessThan2Years()  throws Exception {
		String uri = "/discount/getnetAmount";
		User user = new User();
		user.setUserType(UserType.CUSTOMER);
		user.setYearsSinceCustomer(1);

		Bill bill = new Bill();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setType(ItemType.NOT_GROCERRY);
		item.setValue(80.0);

		Item item2 = new Item();
		item2.setType(ItemType.NOT_GROCERRY);
		item2.setValue(80.0);

		items.add(item2);
		items.add(item);
		bill.setItems(items);
		user.setTotalBill(bill);

		String inputJson = super.mapToJson(user);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Double netAmount = Double.valueOf(mvcResult.getResponse().getContentAsString());
		assertEquals(netAmount, 155.0, 0.0);
	}
	@Test
	public void testForCustomerWithGrocerryGreaterThan2years() throws Exception {
		String uri = "/discount/getnetAmount";
		User user = new User();
		user.setUserType(UserType.CUSTOMER);
		user.setYearsSinceCustomer(5);
		Bill bill = new Bill();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setType(ItemType.GROCERRY);
		item.setValue(80.0);

		Item item2 = new Item();
		item2.setType(ItemType.NOT_GROCERRY);
		item2.setValue(80.0);

		items.add(item2);
		items.add(item);
		bill.setItems(items);
		user.setTotalBill(bill);

		String inputJson = super.mapToJson(user);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Double netAmount = Double.valueOf(mvcResult.getResponse().getContentAsString());
		assertEquals(netAmount, 76.0, 0.0);
	}

	@Test
	public void testForCustomerGreaterThan2Years()  throws Exception {
		String uri = "/discount/getnetAmount";
		User user = new User();
		user.setUserType(UserType.CUSTOMER);
		user.setYearsSinceCustomer(4);

		Bill bill = new Bill();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setType(ItemType.NOT_GROCERRY);
		item.setValue(80.0);

		Item item2 = new Item();
		item2.setType(ItemType.NOT_GROCERRY);
		item2.setValue(80.0);

		items.add(item2);
		items.add(item);
		bill.setItems(items);
		user.setTotalBill(bill);

		String inputJson = super.mapToJson(user);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Double netAmount = Double.valueOf(mvcResult.getResponse().getContentAsString());
		assertEquals(netAmount, 147.25, 0.0);
	}
}
