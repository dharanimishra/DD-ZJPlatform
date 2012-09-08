package com.springs.domain;

public class ComponentType {
	/**
	 * This field corresponds to the database column
	 * componenttype.componenttypeid
	 */
	private Integer componenttypeid;

	/**
	 * This field corresponds to the database column componenttype.name
	 */
	private String name;

	/**
	 * This field corresponds to the database column componenttype.description
	 */
	private String description;

	/**
	 * This method returns the value of the database column
	 * componenttype.componenttypeid
	 * 
	 * @return the value of componenttype.componenttypeid
	 */
	public Integer getComponenttypeid() {
		return componenttypeid;
	}

	/**
	 * This method sets the value of the database column
	 * componenttype.componenttypeid
	 * 
	 * @param componenttypeid
	 *            the value for componenttype.componenttypeid
	 */
	public void setComponenttypeid(Integer componenttypeid) {
		this.componenttypeid = componenttypeid;
	}

	/**
	 * This method returns the value of the database column componenttype.name
	 * 
	 * @return the value of componenttype.name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the value of the database column componenttype.name
	 * 
	 * @param name
	 *            the value for componenttype.name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method returns the value of the database column
	 * componenttype.description
	 * 
	 * @return the value of componenttype.description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column
	 * componenttype.description
	 * 
	 * @param description
	 *            the value for componenttype.description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}