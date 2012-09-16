package com.ziksana.domain.course;

import java.util.Date;

public class LearningContentReviewProgress {
	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.reviewProgressId
	 */
	private Integer reviewProgressId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.StartDate
	 */
	private Date startDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.EndDate
	 */
	private Date endDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.TotalDuration
	 */
	private Integer totalDuration;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.DegreeofCompletion
	 */
	private Integer degreeofCompletion;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.CourseProgressStatus
	 */
	private Integer courseProgressStatus;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.Description
	 */
	private String description;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.AverageRating
	 */
	private Integer averageRating;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.CourseId
	 */
	private Integer courseId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.LearningComponentId
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.LearningComponentContentId
	 */
	private Integer learningComponentContentId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentreviewprogress.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.reviewProgressId
	 * 
	 * @return the value of corlearningcontentreviewprogress.reviewProgressId
	 */
	public Integer getReviewProgressId() {
		return reviewProgressId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.reviewProgressId
	 * 
	 * @param reviewProgressId
	 *            the value for
	 *            corlearningcontentreviewprogress.reviewProgressId
	 */
	public void setReviewProgressId(Integer reviewProgressId) {
		this.reviewProgressId = reviewProgressId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.StartDate
	 * 
	 * @return the value of corlearningcontentreviewprogress.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.StartDate
	 * 
	 * @param startDate
	 *            the value for corlearningcontentreviewprogress.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.EndDate
	 * 
	 * @return the value of corlearningcontentreviewprogress.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.EndDate
	 * 
	 * @param endDate
	 *            the value for corlearningcontentreviewprogress.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.TotalDuration
	 * 
	 * @return the value of corlearningcontentreviewprogress.TotalDuration
	 */
	public Integer getTotalDuration() {
		return totalDuration;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.TotalDuration
	 * 
	 * @param totalDuration
	 *            the value for corlearningcontentreviewprogress.TotalDuration
	 */
	public void setTotalDuration(Integer totalDuration) {
		this.totalDuration = totalDuration;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.DegreeofCompletion
	 * 
	 * @return the value of corlearningcontentreviewprogress.DegreeofCompletion
	 */
	public Integer getDegreeofCompletion() {
		return degreeofCompletion;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.DegreeofCompletion
	 * 
	 * @param degreeofCompletion
	 *            the value for
	 *            corlearningcontentreviewprogress.DegreeofCompletion
	 */
	public void setDegreeofCompletion(Integer degreeofCompletion) {
		this.degreeofCompletion = degreeofCompletion;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.CourseProgressStatus
	 * 
	 * @return the value of
	 *         corlearningcontentreviewprogress.CourseProgressStatus
	 */
	public Integer getCourseProgressStatus() {
		return courseProgressStatus;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.CourseProgressStatus
	 * 
	 * @param courseProgressStatus
	 *            the value for
	 *            corlearningcontentreviewprogress.CourseProgressStatus
	 */
	public void setCourseProgressStatus(Integer courseProgressStatus) {
		this.courseProgressStatus = courseProgressStatus;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.Description
	 * 
	 * @return the value of corlearningcontentreviewprogress.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.Description
	 * 
	 * @param description
	 *            the value for corlearningcontentreviewprogress.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.AverageRating
	 * 
	 * @return the value of corlearningcontentreviewprogress.AverageRating
	 */
	public Integer getAverageRating() {
		return averageRating;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.AverageRating
	 * 
	 * @param averageRating
	 *            the value for corlearningcontentreviewprogress.AverageRating
	 */
	public void setAverageRating(Integer averageRating) {
		this.averageRating = averageRating;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.CourseId
	 * 
	 * @return the value of corlearningcontentreviewprogress.CourseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.CourseId
	 * 
	 * @param courseId
	 *            the value for corlearningcontentreviewprogress.CourseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.LearningComponentId
	 * 
	 * @return the value of corlearningcontentreviewprogress.LearningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.LearningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for
	 *            corlearningcontentreviewprogress.LearningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.LearningComponentContentId
	 * 
	 * @return the value of
	 *         corlearningcontentreviewprogress.LearningComponentContentId
	 */
	public Integer getLearningComponentContentId() {
		return learningComponentContentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.LearningComponentContentId
	 * 
	 * @param learningComponentContentId
	 *            the value for
	 *            corlearningcontentreviewprogress.LearningComponentContentId
	 */
	public void setLearningComponentContentId(Integer learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentreviewprogress.MemberRoleId
	 * 
	 * @return the value of corlearningcontentreviewprogress.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentreviewprogress.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corlearningcontentreviewprogress.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}