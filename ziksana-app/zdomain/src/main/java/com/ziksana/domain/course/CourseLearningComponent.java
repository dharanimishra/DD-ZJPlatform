package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class CourseLearningComponent extends AuditHistory{
	
	private Integer courseLearningComponentId;
	private Date creationDate;
	private Integer learningComponentVersionUsed;
	private Boolean active;
	private Integer weightage;
	private String totalCredits;
	private String extraCredits;
	private Integer duration;
	private Boolean learningComponentOveriddenIndicator;
	private Course course;
	private LearningComponent learningComponent;
	private LearningComponentType learningComponentType;
	

	/**
	 * @return the value of property courseLearningComponentId
	 */
	public Integer getCourseLearningComponentId() {
		return courseLearningComponentId;
	}

	/**
	 * @param courseLearningComponentId
	 *            the value for property courseLearningComponentId
	 */
	public void setCourseLearningComponentId(Integer courseLearningComponentId) {
		this.courseLearningComponentId = courseLearningComponentId;
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
	 * @return the value of property LearningComponentVersionUsed
	 */
	public Integer getLearningComponentVersionUsed() {
		return learningComponentVersionUsed;
	}

	/**
	 * @param learningComponentVersionUsed
	 *            the value for property LearningComponentVersionUsed
	 */
	public void setLearningComponentVersionUsed(
			Integer learningComponentVersionUsed) {
		this.learningComponentVersionUsed = learningComponentVersionUsed;
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
	 * This method returns the value of the property Weightage
	 * 
	 * @return the value of property Weightage
	 */
	public Integer getWeightage() {
		return weightage;
	}

	/**
	 * @param weightage
	 *            the value for property Weightage
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	/**
	 * @return the value of property TotalCredits
	 */
	public String getTotalCredits() {
		return totalCredits;
	}

	/**
	 * @param totalCredits
	 *            the value for property TotalCredits
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits == null ? null : totalCredits.trim();
	}

	/**
	 * @return the value of property ExtraCredits
	 */
	public String getExtraCredits() {
		return extraCredits;
	}

	/**
	 * @param extraCredits
	 *            the value for property ExtraCredits
	 */
	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits == null ? null : extraCredits.trim();
	}

	/**
	 * @return the value of property duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the value for property duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the value of property LearningComponentOveriddenIndicator
	 */
	public Boolean getLearningComponentOveriddenIndicator() {
		return learningComponentOveriddenIndicator;
	}

	/**
	 * @param learningComponentOveriddenIndicator
	 *            the value for property LearningComponentOveriddenIndicator
	 */
	public void setLearningComponentOveriddenIndicator(
			Boolean learningComponentOveriddenIndicator) {
		this.learningComponentOveriddenIndicator = learningComponentOveriddenIndicator;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
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
	 * @return the learningComponentType
	 */
	public LearningComponentType getLearningComponentType() {
		return learningComponentType;
	}

	/**
	 * @param learningComponentType the learningComponentType to set
	 */
	public void setLearningComponentType(LearningComponentType learningComponentType) {
		this.learningComponentType = learningComponentType;
	}

}