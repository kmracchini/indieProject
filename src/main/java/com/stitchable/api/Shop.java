package com.stitchable.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Shop {

	@JsonProperty("pagination")
	private Pagination pagination;

	@JsonProperty("count")
	private int count;

	@JsonProperty("params")
	private Params params;

	@JsonProperty("type")
	private String type;

	@JsonProperty("results")
	private List<com.stitchable.api.ResultsItem> results;

	public Pagination getPagination(){
		return pagination;
	}

	public int getCount(){
		return count;
	}

	public Params getParams(){
		return params;
	}

	public String getType(){
		return type;
	}

	public List<com.stitchable.api.ResultsItem> getResults(){
		return results;
	}
}