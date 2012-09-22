package com.ziksana.domain.course;

import java.util.Date;

public class Course {

	/**
	 * This field corresponds to the property courseId
	 */
	private Integer courseId;

	/**
	 * This field corresponds to the property Name
	 */
	private String name;

	/**
	 * This field corresponds to the property CourseIdentifier
	 */
	private String courseIdentifier;

	/**
	 * This field corresponds to the property Description
	 */
	private String description;

	/**
	 * This field corresponds to the property ValidFrom
	 */
	private Date validFrom;

	/**
	 * This field corresponds to the property ValidTo
	 */
	private Date validTo;

	/**
	 * This field corresponds to the property CourseStatus
	 */
	private Integer courseStatus;

	/**
	 * Description of the course status attribute
	 */
	private String courseStatusDesc;

	/**
	 * This field corresponds to the property Rating
	 */
	private Integer rating;

	/**
	 * This field corresponds to the attribute ContentSecurityNeededIndicator
	 */
	private Boolean contentSecurityNeededIndicator;

	/**
	 * This field corresponds to the property CourseWeightage
	 */
	private Integer courseWeightage;

	/**
	 * This field corresponds to the property TotalCredits
	 */
	private String totalCredits;

	/**
	 * This field corresponds to the attribute ExtraCreditsIndicator
	 */
	private Boolean extraCreditsIndicator;

	/**
	 * This field corresponds to the property ExtraCredits
	 */
	private String extraCredits;

	/**
	 * This field corresponds to the attribute AdditionalPropertyIndicator
	 */
	private Boolean additionalPropertyIndicator;

	/**
	 * This field corresponds to the attribute courseDuration
	 */
	private Integer courseDuration;

	/**
	 * This field corresponds to the attribute thumbnailPicturePath
	 */
	private String thumbnailPicturePath;

	/**
	 * This field corresponds to the attribute templateIndicator
	 */
	private Boolean templateIndicator;

	/**
	 * This field corresponds to the property subjClassificationId
	 */
	private Integer subjClassificationId;

	/**
	 * This field corresponds to the property memberRoleId
	 */
	private Integer accountableMemberPersonaId;

	/**
	 * This object corresponds to the details about the Course components
	 */
	private CourseDetails courseDetails;

	/**
	 * This field corresponds to the property Version
	 */
	private Integer version;

	/**
	 * This method returns the value of the property Name
	 * 
	 * @return the value of attribute Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the value of the property Name
	 * 
	 * @param name
	 *            the value for attribute Name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method returns the value of the attribute CourseIdentifier
	 * 
	 * @return the value of attribute CourseIdentifier
	 */
	public String getCourseIdentifier() {
		return courseIdentifier;
	}

	/**
	 * This method sets the value of the attribute CourseIdentifier
	 * 
	 * @param courseIdentifier
	 *            the value for attribute CourseIdentifier
	 */
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier == null ? null
				: courseIdentifier.trim();
	}

	/**
	 * This method returns the value of the attribute Description
	 * 
	 * @return the value of attribute Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the property Description
	 * 
	 * @param description
	 *            the value for attribute Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the property Version
	 * 
	 * @return the value of attribute Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the property Version
	 * 
	 * @param version
	 *            the value for attribute Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the subjClassificationId
	 */
	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	/**
	 * @param subjClassificationId
	 *            the subjClassificationId to set
	 */
	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	/**
	 * This method returns the value of the property courseId
	 * 
	 * @return the value of attribute courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the property courseId
	 * 
	 * @param courseId
	 *            the value for attribute courseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseDetails
	 */
	public CourseDetails getCourseDetails() {
		return courseDetails;
	}

	/**
	 * @param courseDetails
	 *            the courseDetails to set
	 */
	public void setCourseDetails(CourseDetails courseDetails) {
		this.courseDetails = courseDetails;
	}

	/**
	 * @return the accountableMemberPersonaId
	 */
	public Integer getAccountableMemberPersona() {
		return accountableMemberPersonaId;
	}

	/**
	 * @param accountableMemberPersonaId
	 *            the accountableMemberPersonaId to set
	 */
	public void setAccountableMemberPersona(Integer accountableMemberPersonaId) {
		this.accountableMemberPersonaId = accountableMemberPersonaId;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 * @return the courseStatusDesc
	 */
	public String getCourseStatusDesc() {
		return courseStatusDesc;
	}

	/**
	 * @param courseStatusDesc
	 *            the courseStatusDesc to set
	 */
	public void setCourseStatusDesc(String courseStatusDesc) {
		this.courseStatusDesc = courseStatusDesc;
	}

	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Boolean getContentSecurityNeededIndicator() {
		return contentSecurityNeededIndicator;
	}

	public void setContentSecurityNeededIndicator(
			Boolean contentSecurityNeededIndicator) {
		this.contentSecurityNeededIndicator = contentSecurityNeededIndicator;
	}

	public Integer getCourseWeightage() {
		return courseWeightage;
	}

	public void setCourseWeightage(Integer courseWeightage) {
		this.courseWeightage = courseWeightage;
	}

	public String getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Boolean getExtraCreditsIndicator() {
		return extraCreditsIndicator;
	}

	public void setExtraCreditsIndicator(Boolean extraCreditsIndicator) {
		this.extraCreditsIndicator = extraCreditsIndicator;
	}

	public String getExtraCredits() {
		return extraCredits;
	}

	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits;
	}

	public Boolean getAdditionalPropertyIndicator() {
		return additionalPropertyIndicator;
	}

	public void setAdditionalPropertyIndicator(
			Boolean additionalPropertyIndicator) {
		this.additionalPropertyIndicator = additionalPropertyIndicator;
	}

	public Integer getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	public Boolean getTemplateIndicator() {
		return templateIndicator;
	}

	public void setTemplateIndicator(Boolean templateIndicator) {
		this.templateIndicator = templateIndicator;
	}

}