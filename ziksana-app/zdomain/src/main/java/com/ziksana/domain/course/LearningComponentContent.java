package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class LearningComponentContent extends AuditHistory{

	public LearningComponentContent(LearningComponent learningComponent,
			LearningContent baseLearningContentId) {
		this.learningComponent = learningComponent;
		this.baseLearningContentId = baseLearningContentId;
	}

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
	private CourseStatus courseStatus;

	/**
	 * This field corresponds property ContentType
	 */
	private ContentType contentType;

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
	private Integer contentVersionUsed;

	private LearningComponent learningComponent;

	private LearningComponentContent SynchronizeWithVideoId;

	private LearningContent baseLearningContentId;

	/**
	 * Contains the information about associations/composition and more
	 * information
	 */
	private LearningComponentContentDetails learningComponentContentDetails;

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
	public Integer getContentVersionUsed() {
		return contentVersionUsed;
	}

	/**
	 * This method sets the value of the property ContentVersionUsed
	 * 
	 * @param contentVersionUsed
	 *            the value for property ContentVersionUsed
	 */
	public void setContentVersionUsed(Integer contentVersionUsed) {
		this.contentVersionUsed = contentVersionUsed;
	}
	/**
	 * @return the learrningComponentContentDetails
	 */
	public LearningComponentContentDetails getLearrningComponentContentDetails() {
		return learningComponentContentDetails;
	}

	/**
	 * @param learningComponentContentDetails
	 *            the learrningComponentContentDetails to set
	 */
	public void setLearrningComponentContentDetails(
			LearningComponentContentDetails learningComponentContentDetails) {
		this.learningComponentContentDetails = learningComponentContentDetails;
	}

	/**
	 * @return the courseStatus
	 */
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	/**
	 * @param courseStatus the courseStatus to set
	 */
	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * @return the contentType
	 */
	public ContentType getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the learningComponent
	 */
	public LearningComponent getLearningComponent() {
		return learningComponent;
	}

	/**
	 * @param learningComponent the learningComponent to set
	 */
	public void setLearningComponent(LearningComponent learningComponent) {
		this.learningComponent = learningComponent;
	}

	/**
	 * @return the synchronizeWithVideoId
	 */
	public LearningComponentContent getSynchronizeWithVideoId() {
		return SynchronizeWithVideoId;
	}

	/**
	 * @param synchronizeWithVideoId the synchronizeWithVideoId to set
	 */
	public void setSynchronizeWithVideoId(LearningComponentContent synchronizeWithVideoId) {
		SynchronizeWithVideoId = synchronizeWithVideoId;
	}

	/**
	 * @return the baseLearningContentId
	 */
	public LearningContent getBaseLearningContentId() {
		return baseLearningContentId;
	}

	/**
	 * @param baseLearningContentId the baseLearningContentId to set
	 */
	public void setBaseLearningContentId(LearningContent baseLearningContentId) {
		this.baseLearningContentId = baseLearningContentId;
	}

}