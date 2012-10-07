package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.common.id.ZID;
import com.ziksana.domain.common.AuditHistory;

public class LearningComponentContent extends AuditHistory{

	public LearningComponentContent(LearningComponent learningComponent,
			LearningContent baseLearningContent) {
		this.learningComponent = learningComponent;
		this.baseLearningContent = baseLearningContent;
	}

	public LearningComponentContent(CourseStatus courseStatus,
			ContentType contentType, LearningComponent learningComponent,
			LearningComponentContent synchronizeWithVideo,
			LearningContent baseLearningContent) {
		this.courseStatus = courseStatus;
		this.contentType = contentType;
		this.learningComponent = learningComponent;
		this.synchronizeWithVideo = synchronizeWithVideo;
		this.baseLearningContent = baseLearningContent;
	}

	private ZID		 						learningComponentContentId;
	private Date 							creationDate 						= null;
	private CourseStatus 					courseStatus 						= null;
	private ContentType 					contentType 						= null;
	private String 							contentDescription 					= null;
	private Boolean 						active 								= null;
	private Integer 						contentVersionUsed 					= null;
	private LearningComponent 				learningComponent 					= null;
	private LearningComponentContent 		synchronizeWithVideo 				= null;
	private LearningContent 				baseLearningContent 				= null;
	private LearningComponentContentDetails learningComponentContentDetails 	= null;

	/**
	 * @return the value of property learningComponentContentId
	 */
	public ZID getLearningComponentContentId() {
		return learningComponentContentId;
	}

	/**
	 * @param learningComponentContentId
	 *            the value for property learningComponentContentId
	 */
	public void setLearningComponentContentId(ZID learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}

	/**
	 * @return the value of property CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the value for property CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * @return the value of property ContentDescription
	 */
	public String getContentDescription() {
		return contentDescription;
	}

	/**
	 * @param contentDescription
	 *            the value for property ContentDescription
	 */
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription == null ? null
				: contentDescription.trim();
	}

	/**
	 * @return the value of property Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the value for property Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the value of property ContentVersionUsed
	 */
	public Integer getContentVersionUsed() {
		return contentVersionUsed;
	}

	/**
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
	 * @return the synchronizeWithVideo
	 */
	public LearningComponentContent getSynchronizeWithVideo() {
		return synchronizeWithVideo;
	}

	/**
	 * @param synchronizeWithVideo the synchronizeWithVideo to set
	 */
	public void setSynchronizeWithVideo(LearningComponentContent synchronizeWithVideo) {
		this.synchronizeWithVideo = synchronizeWithVideo;
	}

	/**
	 * @return the baseLearningContent
	 */
	public LearningContent getBaseLearningContent() {
		return baseLearningContent;
	}

	/**
	 * @param baseLearningContent the baseLearningContent to set
	 */
	public void setBaseLearningContent(LearningContent baseLearningContent) {
		this.baseLearningContent = baseLearningContent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LearningComponentContent [courseStatus=" + courseStatus
				+ ", contentType=" + contentType + ", learningComponent="
				+ learningComponent + ", baseLearningContent="
				+ baseLearningContent + "]";
	}

}