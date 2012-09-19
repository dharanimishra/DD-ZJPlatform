package com.ziksana.domain.course.subscription;

import java.util.Date;

public class MemberSubscriptionCourseCriteria {
	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscriptioncoursecriteria.ID
	 * 
	 */
	private Integer ID;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscriptioncoursecriteria.CreationDate
	 * 
	 */
	private Date creationDate;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscriptioncoursecriteria.CriteriaName
	 * 
	 */
	private Integer criteriaName;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscriptioncoursecriteria.CriteriaValue
	 * 
	 */
	private String criteriaValue;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscriptioncoursecriteria.CourseStatus
	 * 
	 */
	private Integer courseStatus;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscriptioncoursecriteria.SubscriptionCourseId
	 * 
	 */
	private Integer subscriptionCourseId;

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscriptioncoursecriteria.ID
	 * 
	 * @return the value of sbnmembersubscriptioncoursecriteria.ID
	 * 
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscriptioncoursecriteria.ID
	 * 
	 * @param ID
	 *            the value for sbnmembersubscriptioncoursecriteria.ID
	 * 
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscriptioncoursecriteria.CreationDate
	 * 
	 * @return the value of sbnmembersubscriptioncoursecriteria.CreationDate
	 * 
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscriptioncoursecriteria.CreationDate
	 * 
	 * @param creationDate
	 *            the value for sbnmembersubscriptioncoursecriteria.CreationDate
	 * 
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscriptioncoursecriteria.CriteriaName
	 * 
	 * @return the value of sbnmembersubscriptioncoursecriteria.CriteriaName
	 * 
	 */
	public Integer getCriteriaName() {
		return criteriaName;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscriptioncoursecriteria.CriteriaName
	 * 
	 * @param criteriaName
	 *            the value for sbnmembersubscriptioncoursecriteria.CriteriaName
	 * 
	 */
	public void setCriteriaName(Integer criteriaName) {
		this.criteriaName = criteriaName;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscriptioncoursecriteria.CriteriaValue
	 * 
	 * @return the value of sbnmembersubscriptioncoursecriteria.CriteriaValue
	 * 
	 */
	public String getCriteriaValue() {
		return criteriaValue;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscriptioncoursecriteria.CriteriaValue
	 * 
	 * @param criteriaValue
	 *            the value for
	 *            sbnmembersubscriptioncoursecriteria.CriteriaValue
	 * 
	 */
	public void setCriteriaValue(String criteriaValue) {
		this.criteriaValue = criteriaValue == null ? null : criteriaValue
				.trim();
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscriptioncoursecriteria.CourseStatus
	 * 
	 * @return the value of sbnmembersubscriptioncoursecriteria.CourseStatus
	 * 
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscriptioncoursecriteria.CourseStatus
	 * 
	 * @param courseStatus
	 *            the value for sbnmembersubscriptioncoursecriteria.CourseStatus
	 * 
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscriptioncoursecriteria.SubscriptionCourseId
	 * 
	 * @return the value of
	 *         sbnmembersubscriptioncoursecriteria.SubscriptionCourseId
	 * 
	 */
	public Integer getSubscriptionCourseId() {
		return subscriptionCourseId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscriptioncoursecriteria.SubscriptionCourseId
	 * 
	 * @param subscriptionCourseId
	 *            the value for
	 *            sbnmembersubscriptioncoursecriteria.SubscriptionCourseId
	 * 
	 */
	public void setSubscriptionCourseId(Integer subscriptionCourseId) {
		this.subscriptionCourseId = subscriptionCourseId;
	}
}