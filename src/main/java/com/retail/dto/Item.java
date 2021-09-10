package com.retail.dto;

import com.retail.enums.ItemType;

public class Item {

	private ItemType type;
	private double value;

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
