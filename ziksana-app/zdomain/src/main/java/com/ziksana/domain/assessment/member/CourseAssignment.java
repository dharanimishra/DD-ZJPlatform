package com.ziksana.domain.assessment.member;

import java.util.Date;

public class CourseAssignment {
	/**
	 * This field corresponds to the database column
	 * msmcourseassignment.CourseAssignmentId
	 */
	private Integer courseAssignmentId;

	/**
	 * This field corresponds to the database column
	 * msmcourseassignment.AssignmentName
	 */
	private String assignmentName;

	/**
	 * This field corresponds to the database column
	 * msmcourseassignment.StartDate
	 */
	private Date startDate;

	/**
	 * This field corresponds to the database column msmcourseassignment.EndDate
	 */
	private Date endDate;

	/**
	 * This field corresponds to the database column
	 * msmcourseassignment.Duration
	 */
	private Integer duration;

	/**
	 * This field corresponds to the database column msmcourseassignment.Effort
	 */
	private Integer effort;

	/**
	 * This field corresponds to the database column msmcourseassignment.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * msmcourseassignment.Progress
	 */
	private Integer progress;

	/**
	 * This field corresponds to the database column
	 * msmcourseassignment.SubscriptionCourseId
	 */
	private Integer subscriptionCourseId;

	/**
	 * This field corresponds to the database column
	 * msmcourseassignment.LearningComponentId
	 */
	private Integer learningComponentId;

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.CourseAssignmentId
	 * 
	 * @return the value of msmcourseassignment.CourseAssignmentId
	 */
	public Integer getCourseAssignmentId() {
		return courseAssignmentId;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.CourseAssignmentId
	 * 
	 * @param courseAssignmentId
	 *            the value for msmcourseassignment.CourseAssignmentId
	 */
	public void setCourseAssignmentId(Integer courseAssignmentId) {
		this.courseAssignmentId = courseAssignmentId;
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.AssignmentName
	 * 
	 * @return the value of msmcourseassignment.AssignmentName
	 */
	public String getAssignmentName() {
		return assignmentName;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.AssignmentName
	 * 
	 * @param assignmentName
	 *            the value for msmcourseassignment.AssignmentName
	 */
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName == null ? null : assignmentName
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.StartDate
	 * 
	 * @return the value of msmcourseassignment.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.StartDate
	 * 
	 * @param startDate
	 *            the value for msmcourseassignment.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.EndDate
	 * 
	 * @return the value of msmcourseassignment.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.EndDate
	 * 
	 * @param endDate
	 *            the value for msmcourseassignment.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.Duration
	 * 
	 * @return the value of msmcourseassignment.Duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.Duration
	 * 
	 * @param duration
	 *            the value for msmcourseassignment.Duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.Effort
	 * 
	 * @return the value of msmcourseassignment.Effort
	 */
	public Integer getEffort() {
		return effort;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.Effort
	 * 
	 * @param effort
	 *            the value for msmcourseassignment.Effort
	 */
	public void setEffort(Integer effort) {
		this.effort = effort;
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.Active
	 * 
	 * @return the value of msmcourseassignment.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.Active
	 * 
	 * @param active
	 *            the value for msmcourseassignment.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.Progress
	 * 
	 * @return the value of msmcourseassignment.Progress
	 */
	public Integer getProgress() {
		return progress;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.Progress
	 * 
	 * @param progress
	 *            the value for msmcourseassignment.Progress
	 */
	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.SubscriptionCourseId
	 * 
	 * @return the value of msmcourseassignment.SubscriptionCourseId
	 */
	public Integer getSubscriptionCourseId() {
		return subscriptionCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.SubscriptionCourseId
	 * 
	 * @param subscriptionCourseId
	 *            the value for msmcourseassignment.SubscriptionCourseId
	 */
	public void setSubscriptionCourseId(Integer subscriptionCourseId) {
		this.subscriptionCourseId = subscriptionCourseId;
	}

	/**
	 * This method returns the value of the database column
	 * msmcourseassignment.LearningComponentId
	 * 
	 * @return the value of msmcourseassignment.LearningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * msmcourseassignment.LearningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for msmcourseassignment.LearningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}
}