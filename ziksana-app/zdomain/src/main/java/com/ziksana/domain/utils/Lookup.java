package com.ziksana.domain.utils;

import java.util.Date;

public class Lookup {
	/**
	 * This field corresponds to the database column utllookup.LookupId
	 */
	private Integer lookupId;

	/**
	 * This field corresponds to the database column utllookup.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column utllookup.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column utllookup.CategoryName
	 */
	private String categoryName;

	/**
	 * This field corresponds to the database column
	 * utllookup.CategoryDescription
	 */
	private String categoryDescription;

	/**
	 * This field corresponds to the database column utllookup.ParentLookupId
	 */
	private Integer parentLookupId;

	/**
	 * This method returns the value of the database column utllookup.LookupId
	 * 
	 * @return the value of utllookup.LookupId
	 */
	public Integer getLookupId() {
		return lookupId;
	}

	/**
	 * This method sets the value of the database column utllookup.LookupId
	 * 
	 * @param lookupId
	 *            the value for utllookup.LookupId
	 */
	public void setLookupId(Integer lookupId) {
		this.lookupId = lookupId;
	}

	/**
	 * This method returns the value of the database column
	 * utllookup.CreationDate
	 * 
	 * @return the value of utllookup.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column utllookup.CreationDate
	 * 
	 * @param creationDate
	 *            the value for utllookup.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column utllookup.Active
	 * 
	 * @return the value of utllookup.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column utllookup.Active
	 * 
	 * @param active
	 *            the value for utllookup.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * utllookup.CategoryName
	 * 
	 * @return the value of utllookup.CategoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * This method sets the value of the database column utllookup.CategoryName
	 * 
	 * @param categoryName
	 *            the value for utllookup.CategoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * utllookup.CategoryDescription
	 * 
	 * @return the value of utllookup.CategoryDescription
	 */
	public String getCategoryDescription() {
		return categoryDescription;
	}

	/**
	 * This method sets the value of the database column
	 * utllookup.CategoryDescription
	 * 
	 * @param categoryDescription
	 *            the value for utllookup.CategoryDescription
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription == null ? null
				: categoryDescription.trim();
	}

	/**
	 * This method returns the value of the database column
	 * utllookup.ParentLookupId
	 * 
	 * @return the value of utllookup.ParentLookupId
	 */
	public Integer getParentLookupId() {
		return parentLookupId;
	}

	/**
	 * This method sets the value of the database column
	 * utllookup.ParentLookupId
	 * 
	 * @param parentLookupId
	 *            the value for utllookup.ParentLookupId
	 */
	public void setParentLookupId(Integer parentLookupId) {
		this.parentLookupId = parentLookupId;
	}
}