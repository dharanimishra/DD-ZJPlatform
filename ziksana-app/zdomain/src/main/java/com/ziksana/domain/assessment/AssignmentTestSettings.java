package com.ziksana.domain.assessment;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

public class AssignmentTestSettings extends AuditHistory{
	

	public AssignmentTestSettings(Boolean active, SettingsProperty property,
			SettingsPropertyValueType propertyValueType, String propertyValue) {
		super();
		this.active = active;
		this.property = property;
		this.propertyValueType = propertyValueType;
		this.propertyValue = propertyValue;
	}
	

	private ZID 						testSettingsId;
	private Date 						creationDate 		= null;
	private Boolean 					active 				= null;
	private SettingsProperty 			property 			= null;
	private SettingsPropertyValueType 	propertyValueType 	= null;
	private String 						propertyValue 		= null;
	
	
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
	public SettingsProperty getProperty() {
		return property;
	}
	public void setProperty(SettingsProperty property) {
		this.property = property;
	}
	/**
	 * @return the propertyValueType
	 */
	public SettingsPropertyValueType getPropertyValueType() {
		return propertyValueType;
	}
	/**
	 * @param propertyValueType the propertyValueType to set
	 */
	public void setPropertyValueType(SettingsPropertyValueType propertyValueType) {
		this.propertyValueType = propertyValueType;
	}
	/**
	 * @return the propertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}
	/**
	 * @param propertyValue the propertyValue to set
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Override
	public String toString() {
		return "AssignmentTestSettings [active=" + active + ", propertyValue="
				+ propertyValue + "]";
	}

}
