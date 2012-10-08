package com.ziksana.domain.assessment;

import java.util.Date;

import com.ziksana.common.id.ZID;
import com.ziksana.domain.common.AuditHistory;

public class AssignmentTestSettings extends AuditHistory{
	
	public AssignmentTestSettings(Boolean active, Integer property,
			String propertyValueType, Integer propertyValue) {
		this.active = active;
		this.property = property;
		this.propertyValueType = propertyValueType;
		this.propertyValue = propertyValue;
	}

	private ZID 		testSettingsId;
	private Date 		creationDate 		= null;
	private Boolean 	active 				= null;
	private Integer 	property 			= null;
	private String 		propertyValueType 	= null;
	private Integer 	propertyValue 		= null;
	
	
	/**
	 * @return the testSettingsId
	 */
	public ZID getTestSettingsId() {
		return testSettingsId;
	}
	/**
	 * @param testSettingsId the testSettingsId to set
	 */
	public void setTestSettingsId(ZID testSettingsId) {
		this.testSettingsId = testSettingsId;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the property
	 */
	public Integer getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(Integer property) {
		this.property = property;
	}
	/**
	 * @return the propertyValueType
	 */
	public String getPropertyValueType() {
		return propertyValueType;
	}
	/**
	 * @param propertyValueType the propertyValueType to set
	 */
	public void setPropertyValueType(String propertyValueType) {
		this.propertyValueType = propertyValueType;
	}
	/**
	 * @return the propertyValue
	 */
	public Integer getPropertyValue() {
		return propertyValue;
	}
	/**
	 * @param propertyValue the propertyValue to set
	 */
	public void setPropertyValue(Integer propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Override
	public String toString() {
		return "AssignmentTestSettings [active=" + active + ", property="
				+ property + ", propertyValueType=" + propertyValueType
				+ ", propertyValue=" + propertyValue + "]";
	}

}
