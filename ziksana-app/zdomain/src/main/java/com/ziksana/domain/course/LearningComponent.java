package com.ziksana.domain.course;

import java.util.Date;

public class LearningComponent {

	/**
	 * This field corresponds property ID
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds property validfrom {Start Date}
	 */
	private Date validFrom;

	/**
	 * This field corresponds property validTo{End Date}
	 */
	private Date validTo;

	/**
	 * This field corresponds property CourseStatus<br>
	 * ID for Course Status
	 */
	private Integer courseStatus;

	/**
	 * Description of the course status attribute<br>
	 * Description for Course Status{Id}
	 */
	private String courseStatusDesc;

	/**
	 * This field corresponds property Weightage
	 */
	private Integer weightage;

	/**
	 * This field corresponds property TotalCredits<br>
	 * Maximum Length:5
	 */
	private String totalCredits;

	/**
	 * This field corresponds property ExtraCreditsIndicator<br>
	 * Maximum Length:1
	 */
	private Boolean extraCreditsIndicator;
	
	/**
	 * This field corresponds to the attribute learningObjIndictor
	 */
	private Integer learningObjIndictor;

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
	 * This field corresponds to the attribute prescribedLODuration<br>
	 */
	private Boolean prescribedLODuration;
	

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
	 * This field corresponds property learningComponentTypeId
	 */
	private Integer learningComponentTypeId;

	/**
	 * This field corresponds property courseId
	 */
	private Integer courseId;

	/**
	 * This field corresponds property memberRoleId
	 */
	private Integer authorMemberPersonaId;

	/**
	 * This field corresponds property subjClassificationId
	 */
	private Integer subjClassificationId;

	/**
	 * This field corresponds property ExtraCredits<br>
	 * Maximum Length:5
	 */
	private String extraCredits;


	/**
	 * The Object contains the more information(associations, compositions) about LearningComponent
	 */
	private LearningComponentDetails learningComponentDetails;
	
	/**
	 * This method returns the value of the database column property
	 * learningComponentId
	 * 
	 * @return the value of property learningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column property
	 * learningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for property learningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column property validfrom
	 * 
	 * @return the value of property validfrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * This method sets the value of the database column property validfrom
	 * 
	 * @param validfrom
	 *            the value for property validfrom
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * This method returns the value of the database column property validTo
	 * 
	 * @return the value of property validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * This method sets the value of the database column property validTo
	 * 
	 * @param validTo
	 *            the value for property validTo
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * This method returns the value of the database column property
	 * CourseStatus
	 * 
	 * @return the value of property CourseStatus
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 * This method sets the value of the database column property CourseStatus
	 * 
	 * @param courseStatus
	 *            the value for property CourseStatus
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * This method returns the value of the database column property Weightage
	 * 
	 * @return the value of property Weightage
	 */
	public Integer getWeightage() {
		return weightage;
	}

	/**
	 * This method sets the value of the database column property Weightage
	 * 
	 * @param weightage
	 *            the value for property Weightage
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	/**
	 * This method returns the value of the database column property
	 * TotalCredits
	 * 
	 * @return the value of property TotalCredits
	 */
	public String getTotalCredits() {
		return totalCredits;
	}

	/**
	 * This method sets the value of the database column property TotalCredits
	 * 
	 * @param totalCredits
	 *            the value for property TotalCredits
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits == null ? null : totalCredits.trim();
	}

	/**
	 * This method returns the value of the database column property
	 * ExtraCreditsIndicator
	 * 
	 * @return the value of property ExtraCreditsIndicator
	 */
	public Boolean getExtraCreditsIndicator() {
		return extraCreditsIndicator;
	}

	/**
	 * This method sets the value of the database column property
	 * ExtraCreditsIndicator
	 * 
	 * @param extraCreditsIndicator
	 *            the value for property ExtraCreditsIndicator
	 */
	public void setExtraCreditsIndicator(Boolean extraCreditsIndicator) {
		this.extraCreditsIndicator = extraCreditsIndicator;
	}

	/**
	 * This method returns the value of the database column property
	 * ExtraCredits
	 * 
	 * @return the value of property ExtraCredits
	 */
	public String getExtraCredits() {
		return extraCredits;
	}

	/**
	 * This method sets the value of the database column property ExtraCredits
	 * 
	 * @param extraCredits
	 *            the value for property ExtraCredits
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
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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
	 * @return the learningComponentTypeId
	 */
	public Integer getLearningComponentTypeId() {
		return learningComponentTypeId;
	}

	/**
	 * @param learningComponentTypeId
	 *            the learningComponentTypeId to set
	 */
	public void setLearningComponentTypeId(Integer learningComponentTypeId) {
		this.learningComponentTypeId = learningComponentTypeId;
	}

	/**
	 * @return the courseStatusDesc
	 */
	public String getCourseStatusDesc() {
		return courseStatusDesc;
	}

	/**
	 * @param courseStatusDesc the courseStatusDesc to set
	 */
	public void setCourseStatusDesc(String courseStatusDesc) {
		this.courseStatusDesc = courseStatusDesc;
	}

	/**
	 * @return the authorMemberPersonaId
	 */
	public Integer getAuthorMemberPersona() {
		return authorMemberPersonaId;
	}

	/**
	 * @param authorMemberPersonaId the authorMemberPersonaId to set
	 */
	public void setAuthorMemberPersona(Integer authorMemberPersonaId) {
		this.authorMemberPersonaId = authorMemberPersonaId;
	}

	/**
	 * @return the learningComponentDetails
	 */
	public LearningComponentDetails getLearningComponentDetails() {
		return learningComponentDetails;
	}

	/**
	 * @param learningComponentDetails the learningComponentDetails to set
	 */
	public void setLearningComponentDetails(LearningComponentDetails learningComponentDetails) {
		this.learningComponentDetails = learningComponentDetails;
	}
	/**
	 * @return the learningObjIndictor
	 */
	public Integer getLearningObjIndictor() {
		return learningObjIndictor;
	}

	/**
	 * @param learningObjIndictor the learningObjIndictor to set
	 */
	public void setLearningObjIndictor(Integer learningObjIndictor) {
		this.learningObjIndictor = learningObjIndictor;
	}

	/**
	 * @return the thumbnailPicturePath
	 */
	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	/**
	 * @param thumbnailPicturePath the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	/**
	 * @return the templateIndicator
	 */
	public Boolean getTemplateIndicator() {
		return templateIndicator;
	}

	/**
	 * @param templateIndicator the templateIndicator to set
	 */
	public void setTemplateIndicator(Boolean templateIndicator) {
		this.templateIndicator = templateIndicator;
	}

	/**
	 * @return the prescribedLODuration
	 */
	public Boolean getPrescribedLODuration() {
		return prescribedLODuration;
	}

	/**
	 * @param prescribedLODuration the prescribedLODuration to set
	 */
	public void setPrescribedLODuration(Boolean prescribedLODuration) {
		this.prescribedLODuration = prescribedLODuration;
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