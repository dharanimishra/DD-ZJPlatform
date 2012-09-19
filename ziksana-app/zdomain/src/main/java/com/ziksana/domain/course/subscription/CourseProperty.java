package com.ziksana.domain.course.subscription;

import java.util.Date;

public class CourseProperty {
	/**
	 * This field corresponds to the database column sbncourseproperty.coursePropertyId
	 */
	private Integer coursePropertyId;

	/**
	 * This field corresponds to the database column
	 * sbncourseproperty.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * sbncourseproperty.PropertyName
	 */
	private Integer propertyName;

	/**
	 * This field corresponds to the database column
	 * sbncourseproperty.PropertyValue
	 */
	private String propertyValue;

	/**
	 * This field corresponds to the database column sbncourseproperty.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * sbncourseproperty.SubscriptionCourseId
	 */
	private Integer subscriptionCourseId;

	/**
	 * This field corresponds to the database column
	 * sbncourseproperty.CurrCoursePropertyId
	 */
	private Integer currCoursePropertyId;

	/**
	 * This method returns the value of the database column sbncourseproperty.coursePropertyId
	 * 
	 * @return the value of sbncourseproperty.coursePropertyId
	 */
	public Integer getCoursePropertyId() {
		return coursePropertyId;
	}

	/**
	 * This method sets the value of the database column sbncourseproperty.coursePropertyId
	 * 
	 * @param coursePropertyId
	 *            the value for sbncourseproperty.coursePropertyId
	 */
	public void setCoursePropertyId(Integer coursePropertyId) {
		this.coursePropertyId = coursePropertyId;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseproperty.CreationDate
	 * 
	 * @return the value of sbncourseproperty.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseproperty.CreationDate
	 * 
	 * @param creationDate
	 *            the value for sbncourseproperty.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseproperty.PropertyName
	 * 
	 * @return the value of sbncourseproperty.PropertyName
	 */
	public Integer getPropertyName() {
		return propertyName;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseproperty.PropertyName
	 * 
	 * @param propertyName
	 *            the value for sbncourseproperty.PropertyName
	 */
	public void setPropertyName(Integer propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseproperty.PropertyValue
	 * 
	 * @return the value of sbncourseproperty.PropertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseproperty.PropertyValue
	 * 
	 * @param propertyValue
	 *            the value for sbncourseproperty.PropertyValue
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue == null ? null : propertyValue
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseproperty.Active
	 * 
	 * @return the value of sbncourseproperty.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseproperty.Active
	 * 
	 * @param active
	 *            the value for sbncourseproperty.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseproperty.SubscriptionCourseId
	 * 
	 * @return the value of sbncourseproperty.SubscriptionCourseId
	 */
	public Integer getSubscriptionCourseId() {
		return subscriptionCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseproperty.SubscriptionCourseId
	 * 
	 * @param subscriptionCourseId
	 *            the value for sbncourseproperty.SubscriptionCourseId
	 */
	public void setSubscriptionCourseId(Integer subscriptionCourseId) {
		this.subscriptionCourseId = subscriptionCourseId;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseproperty.CurrCoursePropertyId
	 * 
	 * @return the value of sbncourseproperty.CurrCoursePropertyId
	 */
	public Integer getCurrCoursePropertyId() {
		return currCoursePropertyId;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseproperty.CurrCoursePropertyId
	 * 
	 * @param currCoursePropertyId
	 *            the value for sbncourseproperty.CurrCoursePropertyId
	 */
	public void setCurrCoursePropertyId(Integer currCoursePropertyId) {
		this.currCoursePropertyId = currCoursePropertyId;
	}
}