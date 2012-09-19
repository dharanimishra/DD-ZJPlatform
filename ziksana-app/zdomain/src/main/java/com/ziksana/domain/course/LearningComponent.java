package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class LearningComponent implements Serializable{
	/**
	 * serial versionId
	 */
	private static final long serialVersionUID = -5292172796555958154L;

	/**
	 * This field corresponds to the database column CorLearningComponent.ID
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.validfrom
	 */
	private Date validFrom;

	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.validTo
	 */
	private Date validTo;

	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.CourseStatus
	 */
	private Integer courseStatus;

	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.Weightage
	 */
	private Integer weightage;

	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.TotalCredits
	 */
	private String totalCredits;

	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.ExtraCreditsIndicator
	 */
	private Boolean extraCreditsIndicator;
	
	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.learningComponentTypeId
	 */
	private Integer learningComponentTypeId;

	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.courseId
	 */
	private Integer courseId;
	
	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.memberRoleId
	 */
	private Integer memberRoleId;
	
	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.subjClassificationId
	 */
	private Integer subjClassificationId;

/*	*//**
	 * This field corresponds to the database column
	 * CorLearningComponent.ExtraCreditsIndicator
	 *//*
	private CourseComponentContent componentContent;
*/	/**
	 * This field corresponds to the database column
	 * CorLearningComponent.ExtraCredits
	 */
	private String extraCredits;

	/**
	 * This method returns the value of the database column
	 * CorLearningComponent.learningComponentId
	 * @return the value of CorLearningComponent.learningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column CorLearningComponent.learningComponentId
	 * @param learningComponentId
	 *            the value for CorLearningComponent.learningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column
	 * CorLearningComponent.validfrom
	 * @return the value of CorLearningComponent.validfrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * This method sets the value of the database column
	 * CorLearningComponent.validfrom
	 * @param validfrom
	 *            the value for CorLearningComponent.validfrom
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * This method returns the value of the database column
	 * CorLearningComponent.validTo
	 * @return the value of CorLearningComponent.validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * This method sets the value of the database column
	 * CorLearningComponent.validTo
	 * @param validTo
	 *            the value for CorLearningComponent.validTo
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * This method returns the value of the database column
	 * CorLearningComponent.CourseStatus
	 * @return the value of CorLearningComponent.CourseStatus
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 * This method sets the value of the database column
	 * CorLearningComponent.CourseStatus
	 * @param courseStatus
	 *            the value for CorLearningComponent.CourseStatus
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * This method returns the value of the database column
	 * CorLearningComponent.Weightage
	 * @return the value of CorLearningComponent.Weightage
	 */
	public Integer getWeightage() {
		return weightage;
	}

	/**
	 * This method sets the value of the database column
	 * CorLearningComponent.Weightage
	 * @param weightage
	 *            the value for CorLearningComponent.Weightage
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	/**
	 * This method returns the value of the database column
	 * CorLearningComponent.TotalCredits
	 * @return the value of CorLearningComponent.TotalCredits
	 */
	public String getTotalCredits() {
		return totalCredits;
	}

	/**
	 * This method sets the value of the database column
	 * CorLearningComponent.TotalCredits
	 * @param totalCredits
	 *            the value for CorLearningComponent.TotalCredits
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits == null ? null : totalCredits.trim();
	}

	/**
	 * This method returns the value of the database column
	 * CorLearningComponent.ExtraCreditsIndicator
	 * @return the value of CorLearningComponent.ExtraCreditsIndicator
	 */
	public Boolean getExtraCreditsIndicator() {
		return extraCreditsIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * CorLearningComponent.ExtraCreditsIndicator
	 * @param extraCreditsIndicator
	 *            the value for CorLearningComponent.ExtraCreditsIndicator
	 */
	public void setExtraCreditsIndicator(Boolean extraCreditsIndicator) {
		this.extraCreditsIndicator = extraCreditsIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * CorLearningComponent.ExtraCredits
	 * @return the value of CorLearningComponent.ExtraCredits
	 */
	public String getExtraCredits() {
		return extraCredits;
	}

	/**
	 * This method sets the value of the database column
	 * CorLearningComponent.ExtraCredits
	 * @param extraCredits
	 *            the value for CorLearningComponent.ExtraCredits
	 */
	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits == null ? null : extraCredits.trim();
	}

	/**
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the memberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * @param memberRoleId the memberRoleId to set
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * @return the subjClassificationId
	 */
	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	/**
	 * @param subjClassificationId the subjClassificationId to set
	 */
	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	/**
	 * @return the learningComponentTypeId
	 */
	public Integer getLearningComponentTypeId() {
		return learningComponentTypeId;
	}

	/**
	 * @param learningComponentTypeId the learningComponentTypeId to set
	 */
	public void setLearningComponentTypeId(Integer learningComponentTypeId) {
		this.learningComponentTypeId = learningComponentTypeId;
	}

}