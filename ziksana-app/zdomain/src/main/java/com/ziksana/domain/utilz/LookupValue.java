package com.ziksana.domain.utilz;

import java.util.Date;

public class LookupValue {
	/**
	 * This field corresponds to the database column
	 * utllookupvalue.LookupValueId
	 */
	private Integer lookupValueId;

	/**
	 * This field corresponds to the database column utllookupvalue.LookupValue
	 */
	private String lookupValue;

	/**
	 * This field corresponds to the database column utllookupvalue.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column utllookupvalue.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * utllookupvalue.ValueDescription
	 */
	private String valueDescription;

	/**
	 * This field corresponds to the database column utllookupvalue.LookupId
	 */
	private Integer lookupId;

	/**
	 * This method returns the value of the database column
	 * utllookupvalue.LookupValueId
	 * 
	 * @return the value of utllookupvalue.LookupValueId
	 */
	public Integer getLookupValueId() {
		return lookupValueId;
	}

	/**
	 * This method sets the value of the database column
	 * utllookupvalue.LookupValueId
	 * 
	 * @param lookupValueId
	 *            the value for utllookupvalue.LookupValueId
	 */
	public void setLookupValueId(Integer lookupValueId) {
		this.lookupValueId = lookupValueId;
	}

	/**
	 * This method returns the value of the database column
	 * utllookupvalue.LookupValue
	 * 
	 * @return the value of utllookupvalue.LookupValue
	 */
	public String getLookupValue() {
		return lookupValue;
	}

	/**
	 * This method sets the value of the database column
	 * utllookupvalue.LookupValue
	 * 
	 * @param lookupValue
	 *            the value for utllookupvalue.LookupValue
	 */
	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue == null ? null : lookupValue.trim();
	}

	/**
	 * This method returns the value of the database column
	 * utllookupvalue.Active
	 * 
	 * @return the value of utllookupvalue.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column utllookupvalue.Active
	 * 
	 * @param active
	 *            the value for utllookupvalue.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * utllookupvalue.CreationDate
	 * 
	 * @return the value of utllookupvalue.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * utllookupvalue.CreationDate
	 * 
	 * @param creationDate
	 *            the value for utllookupvalue.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * utllookupvalue.ValueDescription
	 * 
	 * @return the value of utllookupvalue.ValueDescription
	 */
	public String getValueDescription() {
		return valueDescription;
	}

	/**
	 * This method sets the value of the database column
	 * utllookupvalue.ValueDescription
	 * 
	 * @param valueDescription
	 *            the value for utllookupvalue.ValueDescription
	 */
	public void setValueDescription(String valueDescription) {
		this.valueDescription = valueDescription == null ? null
				: valueDescription.trim();
	}

	/**
	 * This method returns the value of the database column
	 * utllookupvalue.LookupId
	 * 
	 * @return the value of utllookupvalue.LookupId
	 */
	public Integer getLookupId() {
		return lookupId;
	}

	/**
	 * This method sets the value of the database column utllookupvalue.LookupId
	 * 
	 * @param lookupId
	 *            the value for utllookupvalue.LookupId
	 */
	public void setLookupId(Integer lookupId) {
		this.lookupId = lookupId;
	}
}