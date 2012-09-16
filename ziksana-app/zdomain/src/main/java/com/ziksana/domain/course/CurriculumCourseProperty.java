package com.ziksana.domain.course;

import java.util.Date;

public class CurriculumCourseProperty {
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.currCoursePropertyId
	 */
	private Integer currCoursePropertyId;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.PropertyName
	 */
	private String propertyName;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.PropertyUsageType
	 */
	private Integer propertyUsageType;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.PropertyDataType
	 */
	private Integer propertyDataType;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.PropertyValue
	 */
	private String propertyValue;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.Sequence
	 */
	private Integer sequence;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourseproperty.CurriculumCourseId
	 */
	private Integer curriculumCourseId;

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.currCoursePropertyId
	 * 
	 * @return the value of corcurriculumcourseproperty.currCoursePropertyId
	 */
	public Integer getCurrCoursePropertyId() {
		return currCoursePropertyId;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.currCoursePropertyId
	 * 
	 * @param currCoursePropertyId
	 *            the value for corcurriculumcourseproperty.currCoursePropertyId
	 */
	public void setCurrCoursePropertyId(Integer currCoursePropertyId) {
		this.currCoursePropertyId = currCoursePropertyId;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.CreationDate
	 * 
	 * @return the value of corcurriculumcourseproperty.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corcurriculumcourseproperty.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.PropertyName
	 * 
	 * @return the value of corcurriculumcourseproperty.PropertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.PropertyName
	 * 
	 * @param propertyName
	 *            the value for corcurriculumcourseproperty.PropertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName == null ? null : propertyName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.PropertyUsageType
	 * 
	 * @return the value of corcurriculumcourseproperty.PropertyUsageType
	 */
	public Integer getPropertyUsageType() {
		return propertyUsageType;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.PropertyUsageType
	 * 
	 * @param propertyUsageType
	 *            the value for corcurriculumcourseproperty.PropertyUsageType
	 */
	public void setPropertyUsageType(Integer propertyUsageType) {
		this.propertyUsageType = propertyUsageType;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.PropertyDataType
	 * 
	 * @return the value of corcurriculumcourseproperty.PropertyDataType
	 */
	public Integer getPropertyDataType() {
		return propertyDataType;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.PropertyDataType
	 * 
	 * @param propertyDataType
	 *            the value for corcurriculumcourseproperty.PropertyDataType
	 */
	public void setPropertyDataType(Integer propertyDataType) {
		this.propertyDataType = propertyDataType;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.PropertyValue
	 * 
	 * @return the value of corcurriculumcourseproperty.PropertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.PropertyValue
	 * 
	 * @param propertyValue
	 *            the value for corcurriculumcourseproperty.PropertyValue
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue == null ? null : propertyValue
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.Sequence
	 * 
	 * @return the value of corcurriculumcourseproperty.Sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.Sequence
	 * 
	 * @param sequence
	 *            the value for corcurriculumcourseproperty.Sequence
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.Active
	 * 
	 * @return the value of corcurriculumcourseproperty.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.Active
	 * 
	 * @param active
	 *            the value for corcurriculumcourseproperty.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourseproperty.CurriculumCourseId
	 * 
	 * @return the value of corcurriculumcourseproperty.CurriculumCourseId
	 */
	public Integer getCurriculumCourseId() {
		return curriculumCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourseproperty.CurriculumCourseId
	 * 
	 * @param curriculumCourseId
	 *            the value for corcurriculumcourseproperty.CurriculumCourseId
	 */
	public void setCurriculumCourseId(Integer curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}
}