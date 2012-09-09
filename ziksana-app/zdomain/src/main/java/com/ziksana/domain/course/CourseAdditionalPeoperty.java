package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class CourseAdditionalPeoperty implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 6810726986036389416L;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.CourseAddnlPropertyId
	 */
	private Integer courseAddnlPropertyId;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.CreationDate
	 */
	private Date creationDate;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.PropertyUsageType
	 */
	private Integer propertyUsageType;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.PropertyName
	 */
	private String propertyName;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.PropertyDataType
	 */
	private Integer propertyDataType;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.PropertyValue
	 */
	private String propertyValue;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.Sequence
	 */
	private Integer sequence;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.CourseId
	 */
	private Integer courseId;
	/**
	 * This field corresponds to the database column
	 * corcourseadditionalproperty.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.CourseAddnlPropertyId
	 * 
	 * @return the value of corcourseadditionalproperty.CourseAddnlPropertyId
	 */
	public Integer getCourseAddnlPropertyId() {
		return courseAddnlPropertyId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.CourseAddnlPropertyId
	 * 
	 * @param CourseAddnlPropertyId
	 *            the value for corcourseadditionalproperty.CourseAddnlPropertyId
	 */
	public void setCourseAddnlPropertyId(Integer courseAddnlPropertyId) {
		this.courseAddnlPropertyId = courseAddnlPropertyId;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.CreationDate
	 * 
	 * @return the value of corcourseadditionalproperty.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corcourseadditionalproperty.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.PropertyUsageType
	 * 
	 * @return the value of corcourseadditionalproperty.PropertyUsageType
	 */
	public Integer getPropertyUsageType() {
		return propertyUsageType;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.PropertyUsageType
	 * 
	 * @param propertyUsageType
	 *            the value for corcourseadditionalproperty.PropertyUsageType
	 */
	public void setPropertyUsageType(Integer propertyUsageType) {
		this.propertyUsageType = propertyUsageType;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.PropertyName
	 * 
	 * @return the value of corcourseadditionalproperty.PropertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.PropertyName
	 * 
	 * @param propertyName
	 *            the value for corcourseadditionalproperty.PropertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName == null ? null : propertyName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.PropertyDataType
	 * 
	 * @return the value of corcourseadditionalproperty.PropertyDataType
	 */
	public Integer getPropertyDataType() {
		return propertyDataType;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.PropertyDataType
	 * 
	 * @param propertyDataType
	 *            the value for corcourseadditionalproperty.PropertyDataType
	 */
	public void setPropertyDataType(Integer propertyDataType) {
		this.propertyDataType = propertyDataType;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.PropertyValue
	 * 
	 * @return the value of corcourseadditionalproperty.PropertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.PropertyValue
	 * 
	 * @param propertyValue
	 *            the value for corcourseadditionalproperty.PropertyValue
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue == null ? null : propertyValue
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.Sequence
	 * 
	 * @return the value of corcourseadditionalproperty.Sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.Sequence
	 * 
	 * @param sequence
	 *            the value for corcourseadditionalproperty.Sequence
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.Active
	 * 
	 * @return the value of corcourseadditionalproperty.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.Active
	 * 
	 * @param active
	 *            the value for corcourseadditionalproperty.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.CourseId
	 * 
	 * @return the value of corcourseadditionalproperty.CourseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.CourseId
	 * 
	 * @param courseId
	 *            the value for corcourseadditionalproperty.CourseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseadditionalproperty.MemberRoleId
	 * 
	 * @return the value of corcourseadditionalproperty.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseadditionalproperty.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corcourseadditionalproperty.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}