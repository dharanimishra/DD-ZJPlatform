package com.ziksana.domain.institution;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.PropertyDataType;
import com.ziksana.domain.course.PropertyUsageType;
import com.ziksana.domain.course.Sequence;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CurriculumCourseProperty extends AuditHistory {
	
	public CurriculumCourseProperty(String name, PropertyUsageType usageType,
			PropertyDataType datatType, String propertyValue) {
		this.name = name;
		this.usageType = usageType;
		this.datatType = datatType;
		this.propertyValue = propertyValue;
	}

	private ZID 				propertyId;
	private String 				name			= null;
	private PropertyUsageType 	usageType 		= null;
	private PropertyDataType  	datatType 		= null;
	private String 				propertyValue 	= null;
	private Sequence 			sequence 		= null;
	private Boolean 			isActive 		= null;
	
	/**
	 * @return the propertyId
	 */
	public ZID getPropertyId() {
		return propertyId;
	}
	/**
	 * @param propertyId the propertyId to set
	 */
	public void setPropertyId(Integer propertyId) {
		this.propertyId = new IntegerZID(propertyId);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the usageType
	 */
	public PropertyUsageType getUsageType() {
		return usageType;
	}
	/**
	 * @param usageType the usageType to set
	 */
	public void setUsageType(PropertyUsageType usageType) {
		this.usageType = usageType;
	}
	/**
	 * @return the datatType
	 */
	public PropertyDataType getDatatType() {
		return datatType;
	}
	/**
	 * @param datatType the datatType to set
	 */
	public void setDatatType(PropertyDataType datatType) {
		this.datatType = datatType;
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
	/**
	 * @return the sequence
	 */
	public Sequence getSequence() {
		return sequence;
	}
	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}
	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "CurriculumCourseProperty [name=" + name + ", usageType="
				+ usageType + ", datatType=" + datatType + ", propertyValue="
				+ propertyValue + ", sequence=" + sequence + ", isActive="
				+ isActive + "]";
	}	

}
