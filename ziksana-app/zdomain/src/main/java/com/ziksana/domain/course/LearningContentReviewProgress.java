package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.Duration;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.Rating;
import com.ziksana.id.ZID;

 /**
 * @author bhashasp
 */
public class LearningContentReviewProgress extends AuditHistory {

	public LearningContentReviewProgress(Date startDate, Date endDate,
			Duration totalDuration, String description) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalDuration = totalDuration;
		this.description = description;
	}

	private ZID 				reviewProgressId;
	private Date 				startDate				= null;
	private Date 				endDate					= null;
	private Duration			totalDuration			= null;
	private Integer 			degreeOfCompletion		= null;
	private String 				description 			= null;
	private Rating 				averageRating 			= null;
	private Course				course					= null;
	private LearningComponent	learningComponent 		= null;
	
	/**
	 * @return the reviewProgressId
	 */
	public ZID getReviewProgressId() {
		return reviewProgressId;
	}
	/**
	 * @param reviewProgressId the reviewProgressId to set
	 */
	public void setReviewProgressId(ZID reviewProgressId) {
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
	public Duration getTotalDuration() {
		return totalDuration;
	}
	/**
	 * @param totalDuration the totalDuration to set
	 */
	public void setTotalDuration(Duration totalDuration) {
		this.totalDuration = totalDuration;
	}
	/**
	 * @return the degreeOfCompletion
	 */
	public Integer getDegreeOfCompletion() {
		return degreeOfCompletion;
	}
	/**
	 * @param degreeOfCompletion the degreeOfCompletion to set
	 */
	public void setDegreeOfCompletion(Integer degreeOfCompletion) {
		this.degreeOfCompletion = degreeOfCompletion;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LearningContentReviewProgress [startDate=" + startDate
				+ ", endDate=" + endDate + ", totalDuration=" + totalDuration
				+ ", degreeOfCompletion=" + degreeOfCompletion
				+ ", description=" + description + "]";
	}
	
}
