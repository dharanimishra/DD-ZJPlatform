package com.springs.domain;

public class ComponentNest {
	/**
	 * This field corresponds to the database column componentnest.nestid
	 */
	private Integer nestid;

	/**
	 * This field corresponds to the database column componentnest.description
	 */
	private String description;

	/**
	 * This method returns the value of the database column componentnest.nestid
	 * 
	 * @return the value of componentnest.nestid
	 */
	public Integer getNestid() {
		return nestid;
	}

	/**
	 * This method sets the value of the database column componentnest.nestid
	 * 
	 * @param nestid
	 *            the value for componentnest.nestid
	 */
	public void setNestid(Integer nestid) {
		this.nestid = nestid;
	}

	/**
	 * This method returns the value of the database column
	 * componentnest.description
	 * 
	 * @return the value of componentnest.description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column
	 * componentnest.description
	 * 
	 * @param description
	 *            the value for componentnest.description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}