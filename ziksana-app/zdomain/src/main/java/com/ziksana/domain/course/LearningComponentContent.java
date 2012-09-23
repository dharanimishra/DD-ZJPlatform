package com.ziksana.domain.course;

import java.util.Date;

public class LearningComponentContent {

	/**
	 * This field corresponds property learningComponentContentId
	 */
	private Integer learningComponentContentId;

	/**
	 * This field corresponds property CreationDate<br>
	 * LearningComponent Content creation date.
	 */
	private Date creationDate;

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
	 * This field corresponds property ContentType
	 */
	private Integer contentType;

	/**
	 * This attribute hold the description for attribute contentType<br>
	 * Description for contentType {Id}
	 */
	private String contentTypesDesc;

	/**
	 * This field corresponds property ContentDescription,br> Maximum Length:45
	 */
	private String contentDescription;

	/**
	 * This field corresponds property Active Maximum Length:1
	 */
	private Boolean active;

	/**
	 * This field corresponds property ContentVersionUsed
	 */
	private Integer contentVersion;

	/**
	 * This field corresponds to the property createdBy { User who creates }
	 */
	private String createdBy;

	/**
	 * This field corresponds to the property createdOn { Creation Date)
	 */
	private Date createdOn;

	/**
	 * This field corresponds to the property createdBy {User who modified }
	 */
	private String modifiedBy;

	/**
	 * This field corresponds to the property createdBy { modified date}
	 */
	private Date modifiedOn;

	/**
	 * Contains the information about associations/composition and more
	 * information
	 */
	private LearrningComponentContentDetails learrningComponentContentDetails;

	/**
	 * This method returns the value of the property learningComponentContentId
	 * 
	 * @return the value of property learningComponentContentId
	 */
	public Integer getLearningComponentContentId() {
		return learningComponentContentId;
	}

	/**
	 * This method sets the value of the property learningComponentContentId
	 * 
	 * @param learningComponentContentId
	 *            the value for property learningComponentContentId
	 */
	public void setLearningComponentContentId(Integer learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}

	/**
	 * This method returns the value of the property CreationDate
	 * 
	 * @return the value of property CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the property CreationDate
	 * 
	 * @param creationDate
	 *            the value for property CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the property CourseStatus
	 * 
	 * @return the value of property CourseStatus
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 * This method sets the value of the property CourseStatus
	 * 
	 * @param courseStatus
	 *            the value for property CourseStatus
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * This method returns the value of the property ContentType
	 * 
	 * @return the value of property ContentType
	 */
	public Integer getContentType() {
		return contentType;
	}

	/**
	 * This method sets the value of the property ContentType
	 * 
	 * @param contentType
	 *            the value for property ContentType
	 */
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	/**
	 * This method returns the value of the property ContentDescription
	 * 
	 * @return the value of property ContentDescription
	 */
	public String getContentDescription() {
		return contentDescription;
	}

	/**
	 * This method sets the value of the property ContentDescription
	 * 
	 * @param contentDescription
	 *            the value for property ContentDescription
	 */
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription == null ? null
				: contentDescription.trim();
	}

	/**
	 * This method returns the value of the property Active
	 * 
	 * @return the value of property Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the property Active
	 * 
	 * @param active
	 *            the value for property Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the property ContentVersionUsed
	 * 
	 * @return the value of property ContentVersionUsed
	 */
	public Integer getContentVersion() {
		return contentVersion;
	}

	/**
	 * This method sets the value of the property ContentVersionUsed
	 * 
	 * @param contentVersionUsed
	 *            the value for property ContentVersionUsed
	 */
	public void setContentVersion(Integer contentVersion) {
		this.contentVersion = contentVersion;
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

	/**
	 * @return the contentTypesDesc
	 */
	public String getContentTypesDesc() {
		return contentTypesDesc;
	}

	/**
	 * @param contentTypesDesc
	 *            the contentTypesDesc to set
	 */
	public void setContentTypesDesc(String contentTypesDesc) {
		this.contentTypesDesc = contentTypesDesc;
	}

	/**
	 * @return the learrningComponentContentDetails
	 */
	public LearrningComponentContentDetails getLearrningComponentContentDetails() {
		return learrningComponentContentDetails;
	}

	/**
	 * @param learrningComponentContentDetails
	 *            the learrningComponentContentDetails to set
	 */
	public void setLearrningComponentContentDetails(
			LearrningComponentContentDetails learrningComponentContentDetails) {
		this.learrningComponentContentDetails = learrningComponentContentDetails;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
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
	 * @param createdOn
	 *            the createdOn to set
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
	 * @param modifiedBy
	 *            the modifiedBy to set
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
	 * @param modifiedOn
	 *            the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}