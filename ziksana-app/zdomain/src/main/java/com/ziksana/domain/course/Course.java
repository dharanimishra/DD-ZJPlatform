package com.ziksana.domain.course;

import java.util.Date;

public class Course {

	/**
	 * This field corresponds to the property courseId<br>
	 * {Generated ID}
	 */
	private Integer courseId;

	/**
	 * This field corresponds to the property Name<br>
	 * Name of the Course Maximum Length:45
	 */
	private String name;

	/**
	 * This field corresponds to the property CourseIdentifier<br>
	 * Identifier for the Course Maximum Length:45
	 */
	private String courseIdentifier;

	/**
	 * This field corresponds to the property Description<br>
	 * Maximum Length:240
	 */
	private String description;

	/**
	 * This field corresponds to the property ValidFrom<br>
	 * Course Start Date is for When Course is associate to curriculumm
	 */
	private Date validFrom;

	/**
	 * This field corresponds to the property ValidTo<br>
	 * Course End Date is for When Course is associate to curriculumm
	 */
	private Date validTo;

	/**
	 * This field corresponds to the property CourseStatus<br>
	 * ID for Course Status
	 */
	private Integer courseStatus;

	/**
	 * Description of the course status attribute<br>
	 * Description for Course Status Id
	 */
	private String courseStatusDesc;

	/**
	 * This field corresponds to the property Rating
	 */
	private Integer rating;

	/**
	 * This field corresponds to the attribute ContentSecurityNeededIndicator<br>
	 * Maximum Length:1
	 */
	private Boolean securityNeededIndicator;

	/**
	 * This field corresponds to the property TotalCredits<br>
	 * Maximum Length:5
	 */
	private String totalCredits;

	/**
	 * This field corresponds to the attribute ExtraCreditsIndicator<br>
	 * Maximum Length:1
	 */
	private Boolean extraCreditsIndicator;

	/**
	 * This field corresponds to the property ExtraCredits Maximum Length:5
	 */
	private String extraCredits;

	/**
	 * This field corresponds to the attribute AdditionalPropertyIndicator<br>
	 * Maximum Length:1
	 */
	private Boolean additionalPropertyIndicator;

	/**
	 * This field corresponds to the attribute courseDuration in weeks
	 */
	private Integer courseDuration;

	/**
	 * This field corresponds to the attribute thumbnailPicturePath<br>
	 * Maximum Length:72
	 */
	private String thumbnailPicturePath;

	/**
	 * This field corresponds to the attribute templateIndicator<br>
	 * Maximum Length:1
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
	
	/**This field corresponds to the property createdBy { User who creates }
	 */
	private String createdBy;
	
	/**This field corresponds to the property createdOn { Creation Date)
	 */
	private Date createdOn;
	
	/**This field corresponds to the property createdBy {User who modified  }
	 */
	private String modifiedBy;
	
	/**This field corresponds to the property createdBy { modified date}
	 */
	private Date modifiedOn;
	

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

	public Boolean getSecurityNeededIndicator() {
		return securityNeededIndicator;
	}

	public void setSecurityNeededIndicator(Boolean securityNeededIndicator) {
		this.securityNeededIndicator = securityNeededIndicator;
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

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}