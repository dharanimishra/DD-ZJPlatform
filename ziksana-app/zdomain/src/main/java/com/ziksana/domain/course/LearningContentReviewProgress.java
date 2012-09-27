package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;

public class LearningContentReviewProgress extends AuditHistory{

	private Integer reviewProgressId;
	private Date startDate;
	private Date endDate;
	private Integer totalDuration;
	private Integer degreeofCompletion;
	private CourseProgressStatus courseProgressStatus;
	private String description;
	private Rating averageRating;
	private Course course;
	private LearningComponent learningComponentId;
	private LearningComponentContent learningComponentContentId;
	private MemberPersona authorMemberPersona;
	
	
	/**
	 * @return the reviewProgressId
	 */
	public Integer getReviewProgressId() {
		return reviewProgressId;
	}
	/**
	 * @param reviewProgressId the reviewProgressId to set
	 */
	public void setReviewProgressId(Integer reviewProgressId) {
		this.reviewProgressId = reviewProgressId;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the totalDuration
	 */
	public Integer getTotalDuration() {
		return totalDuration;
	}
	/**
	 * @param totalDuration the totalDuration to set
	 */
	public void setTotalDuration(Integer totalDuration) {
		this.totalDuration = totalDuration;
	}
	/**
	 * @return the degreeofCompletion
	 */
	public Integer getDegreeofCompletion() {
		return degreeofCompletion;
	}
	/**
	 * @param degreeofCompletion the degreeofCompletion to set
	 */
	public void setDegreeofCompletion(Integer degreeofCompletion) {
		this.degreeofCompletion = degreeofCompletion;
	}
	/**
	 * @return the courseProgressStatus
	 */
	public CourseProgressStatus getCourseProgressStatus() {
		return courseProgressStatus;
	}
	/**
	 * @param courseProgressStatus the courseProgressStatus to set
	 */
	public void setCourseProgressStatus(CourseProgressStatus courseProgressStatus) {
		this.courseProgressStatus = courseProgressStatus;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the averageRating
	 */
	public Rating getAverageRating() {
		return averageRating;
	}
	/**
	 * @param averageRating the averageRating to set
	 */
	public void setAverageRating(Rating averageRating) {
		this.averageRating = averageRating;
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
	 * @return the learningComponentId
	 */
	public LearningComponent getLearningComponentId() {
		return learningComponentId;
	}
	/**
	 * @param learningComponentId the learningComponentId to set
	 */
	public void setLearningComponentId(LearningComponent learningComponentId) {
		this.learningComponentId = learningComponentId;
	}
	/**
	 * @return the learningComponentContentId
	 */
	public LearningComponentContent getLearningComponentContentId() {
		return learningComponentContentId;
	}
	/**
	 * @param learningComponentContentId the learningComponentContentId to set
	 */
	public void setLearningComponentContentId(
			LearningComponentContent learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}
	/**
	 * @return the authorMemberPersona
	 */
	public MemberPersona getAuthorMemberPersona() {
		return authorMemberPersona;
	}
	/**
	 * @param authorMemberPersona the authorMemberPersona to set
	 */
	public void setAuthorMemberPersona(MemberPersona authorMemberPersona) {
		this.authorMemberPersona = authorMemberPersona;
	}


}