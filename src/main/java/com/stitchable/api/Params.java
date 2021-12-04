package com.stitchable.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Params{

	@JsonProperty("shop_id")
	private String shopId;

	public String getShopId(){
		return shopId;
	}
}