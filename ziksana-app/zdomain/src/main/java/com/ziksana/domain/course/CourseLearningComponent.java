package com.ziksana.domain.course;

import java.util.Date;

public class CourseLearningComponent {
	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.courseLearningComponentId
	 * 
	 */
	private Integer courseLearningComponentId;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.CreationDate
	 * 
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.LearningComponentVersionUsed
	 * 
	 */
	private Integer learningComponentVersionUsed;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.Active
	 * 
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.Weightage
	 * 
	 */
	private Integer weightage;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.TotalCredits
	 * 
	 */
	private String totalCredits;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.ExtraCredits
	 * 
	 */
	private String extraCredits;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.duration
	 * 
	 */
	private Integer duration;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.LearningComponentOveriddenIndicator
	 * 
	 */
	private Boolean learningComponentOveriddenIndicator;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.CourseId
	 * 
	 */
	private Integer courseId;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.LearningComponentId
	 * 
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds to the database column
	 * corcourselearningcomponent.LearningComponentTypeId
	 * 
	 */
	private Integer learningComponentTypeId;

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.courseLearningComponentId
	 * 
	 * @return the value of corcourselearningcomponent.courseLearningComponentId
	 * 
	 */
	public Integer getCourseLearningComponentId() {
		return courseLearningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.courseLearningComponentId
	 * 
	 * @param courseLearningComponentId
	 *            the value for corcourselearningcomponent.courseLearningComponentId
	 * 
	 */
	public void setCourseLearningComponentId(Integer courseLearningComponentId) {
		this.courseLearningComponentId = courseLearningComponentId;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.CreationDate
	 * 
	 * @return the value of corcourselearningcomponent.CreationDate
	 * 
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corcourselearningcomponent.CreationDate
	 * 
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.LearningComponentVersionUsed
	 * 
	 * @return the value of
	 *         corcourselearningcomponent.LearningComponentVersionUsed
	 * 
	 */
	public Integer getLearningComponentVersionUsed() {
		return learningComponentVersionUsed;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.LearningComponentVersionUsed
	 * 
	 * @param learningComponentVersionUsed
	 *            the value for
	 *            corcourselearningcomponent.LearningComponentVersionUsed
	 * 
	 */
	public void setLearningComponentVersionUsed(
			Integer learningComponentVersionUsed) {
		this.learningComponentVersionUsed = learningComponentVersionUsed;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.Active
	 * 
	 * @return the value of corcourselearningcomponent.Active
	 * 
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.Active
	 * 
	 * @param active
	 *            the value for corcourselearningcomponent.Active
	 * 
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.Weightage
	 * 
	 * @return the value of corcourselearningcomponent.Weightage
	 * 
	 */
	public Integer getWeightage() {
		return weightage;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.Weightage
	 * 
	 * @param weightage
	 *            the value for corcourselearningcomponent.Weightage
	 * 
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.TotalCredits
	 * 
	 * @return the value of corcourselearningcomponent.TotalCredits
	 * 
	 */
	public String getTotalCredits() {
		return totalCredits;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.TotalCredits
	 * 
	 * @param totalCredits
	 *            the value for corcourselearningcomponent.TotalCredits
	 * 
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits == null ? null : totalCredits.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.ExtraCredits
	 * 
	 * @return the value of corcourselearningcomponent.ExtraCredits
	 * 
	 */
	public String getExtraCredits() {
		return extraCredits;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.ExtraCredits
	 * 
	 * @param extraCredits
	 *            the value for corcourselearningcomponent.ExtraCredits
	 * 
	 */
	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits == null ? null : extraCredits.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.duration
	 * @return the value of corcourselearningcomponent.duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.ExtraCredits
	 * 
	 * @param duration
	 *            the value for corcourselearningcomponent.duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.LearningComponentOveriddenIndicator
	 * 
	 * @return the value of
	 *         corcourselearningcomponent.LearningComponentOveriddenIndicator
	 * 
	 */
	public Boolean getLearningComponentOveriddenIndicator() {
		return learningComponentOveriddenIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.LearningComponentOveriddenIndicator
	 * 
	 * @param learningComponentOveriddenIndicator
	 *            the value for corcourselearningcomponent.
	 *            LearningComponentOveriddenIndicator
	 * 
	 */
	public void setLearningComponentOveriddenIndicator(
			Boolean learningComponentOveriddenIndicator) {
		this.learningComponentOveriddenIndicator = learningComponentOveriddenIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.CourseId
	 * 
	 * @return the value of corcourselearningcomponent.CourseId
	 * 
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.CourseId
	 * 
	 * @param courseId
	 *            the value for corcourselearningcomponent.CourseId
	 * 
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.LearningComponentId
	 * 
	 * @return the value of corcourselearningcomponent.LearningComponentId
	 * 
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.LearningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for corcourselearningcomponent.LearningComponentId
	 * 
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningcomponent.LearningComponentTypeId
	 * 
	 * @return the value of corcourselearningcomponent.LearningComponentTypeId
	 * 
	 */
	public Integer getLearningComponentTypeId() {
		return learningComponentTypeId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningcomponent.LearningComponentTypeId
	 * 
	 * @param learningComponentTypeId
	 *            the value for corcourselearningcomponent.LearningComponentTypeId
	 * 
	 */
	public void setLearningComponentTypeId(Integer learningComponentTypeId) {
		this.learningComponentTypeId = learningComponentTypeId;
	}
}