package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class LearningComponentContent implements Serializable{
	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 2706548075228037128L;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontent.learningComponentContentId
	 */
	private Integer learningComponentContentId;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontent.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontent.CourseStatus
	 */
	private Integer courseStatus;
	
	/**
	 * This attribute hold the description for attribute courseStatus
	 */
	private String courseStatusDesc;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontent.ContentType
	 */
	private Integer contentType;
	
	/**
	 * This attribute hold the description for attribute contentType
	 */
	private String contentTypesDesc;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontent.ContentDescription
	 */
	private String contentDescription;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontent.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontent.ContentVersionUsed
	 */
	private Integer contentVersionUsed;

	
	/**
	 * Contains the information about associations/composition and more information
	 */
	private LearrningComponentContentDetails  learrningComponentContentDetails;
	
	
	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontent.learningComponentContentId
	 * @return the value of corlearningcomponentcontent.learningComponentContentId
	 */
	public Integer getLearningComponentContentId() {
		return learningComponentContentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontent.learningComponentContentId
	 * @param learningComponentContentId
	 *            the value for corlearningcomponentcontent.learningComponentContentId
	 */
	public void setLearningComponentContentId(Integer learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontent.CreationDate
	 * @return the value of corlearningcomponentcontent.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontent.CreationDate
	 * @param creationDate
	 *            the value for corlearningcomponentcontent.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontent.CourseStatus
	 * @return the value of corlearningcomponentcontent.CourseStatus
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontent.CourseStatus
	 * @param courseStatus
	 *            the value for corlearningcomponentcontent.CourseStatus
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontent.ContentType
	 * @return the value of corlearningcomponentcontent.ContentType
	 */
	public Integer getContentType() {
		return contentType;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontent.ContentType
	 * @param contentType
	 *            the value for corlearningcomponentcontent.ContentType
	 */
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontent.ContentDescription
	 * @return the value of corlearningcomponentcontent.ContentDescription
	 */
	public String getContentDescription() {
		return contentDescription;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontent.ContentDescription
	 * @param contentDescription
	 *            the value for corlearningcomponentcontent.ContentDescription
	 */
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription == null ? null
				: contentDescription.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontent.Active
	 * @return the value of corlearningcomponentcontent.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontent.Active
	 * @param active
	 *            the value for corlearningcomponentcontent.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontent.ContentVersionUsed
	 * @return the value of corlearningcomponentcontent.ContentVersionUsed
	 */
	public Integer getContentVersionUsed() {
		return contentVersionUsed;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontent.ContentVersionUsed
	 * @param contentVersionUsed
	 *            the value for corlearningcomponentcontent.ContentVersionUsed
	 */
	public void setContentVersionUsed(Integer contentVersionUsed) {
		this.contentVersionUsed = contentVersionUsed;
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
	 * @return the contentTypesDesc
	 */
	public String getContentTypesDesc() {
		return contentTypesDesc;
	}

	/**
	 * @param contentTypesDesc the contentTypesDesc to set
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
	 * @param learrningComponentContentDetails the learrningComponentContentDetails to set
	 */
	public void setLearrningComponentContentDetails(
			LearrningComponentContentDetails learrningComponentContentDetails) {
		this.learrningComponentContentDetails = learrningComponentContentDetails;
	}

}