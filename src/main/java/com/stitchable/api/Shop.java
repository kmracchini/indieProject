package com.stitchable.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Gets API information from Etsy about a shop
 */
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

	/**
	 * Get pagination pagination.
	 *
	 * @return the pagination
	 */
	public Pagination getPagination(){
		return pagination;
	}

	/**
	 * Get count int.
	 *
	 * @return the int
	 */
	public int getCount(){
		return count;
	}

	/**
	 * Get params params.
	 *
	 * @return the params
	 */
	public Params getParams(){
		return params;
	}

	/**
	 * Get type string.
	 *
	 * @return the string
	 */
	public String getType(){
		return type;
	}

	/**
	 * Get results list.
	 *
	 * @return the list
	 */
	public List<com.stitchable.api.ResultsItem> getResults(){
		return results;
	}
}