package com.ziksana.domain.course.subscription;

import java.util.Date;

import com.ziksana.domain.assessment.Status;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseItemProgress {
	
	public CourseItemProgress(Date creationDate, Date startDate, Date endDate,
			Integer degreeOfCompletion, Status status, Integer totalTimeSpent) {
		super();
		this.creationDate = creationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.degreeOfCompletion = degreeOfCompletion;
		this.status = status;
		this.totalTimeSpent = totalTimeSpent;
	}
	
	private ZID 				courseItemProgressId;
	private Date 				creationDate 		= null;
	private Date 				startDate 			= null;
	private Date 				endDate 			= null;
	private Integer 			degreeOfCompletion 	= null;
	private Status				status 				= null;
	private Integer 			totalTimeSpent 		= null;
	private SubscriptionCourse	subscriptionCourse 	= null;
	private LearningComponent	courseComponent 	= null;
	
	
	/**
	 * @return the courseItemProgressId
	 */
	public ZID getCourseItemProgressId() {
		return courseItemProgressId;
	}
	/**
	 * @param courseItemProgressId the courseItemProgressId to set
	 */
	public void setCourseItemProgressId(Integer courseItemProgressId) {
		this.courseItemProgressId = new IntegerZID(courseItemProgressId);
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the totalTimeSpent
	 */
	public Integer getTotalTimeSpent() {
		return totalTimeSpent;
	}
	/**
	 * @param totalTimeSpent the totalTimeSpent to set
	 */
	public void setTotalTimeSpent(Integer totalTimeSpent) {
		this.totalTimeSpent = totalTimeSpent;
	}
	/**
	 * @return the subscriptionCourse
	 */
	public SubscriptionCourse getSubscriptionCourse() {
		return subscriptionCourse;
	}
	/**
	 * @param subscriptionCourse the subscriptionCourse to set
	 */
	public void setSubscriptionCourse(SubscriptionCourse subscriptionCourse) {
		this.subscriptionCourse = subscriptionCourse;
	}
	/**
	 * @return the courseComponent
	 */
	public LearningComponent getCourseComponent() {
		return courseComponent;
	}
	/**
	 * @param courseComponent the courseComponent to set
	 */
	public void setCourseComponent(LearningComponent courseComponent) {
		this.courseComponent = courseComponent;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseItemProgress [creationDate=" + creationDate
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", degreeOfCompletion=" + degreeOfCompletion + ", status="
				+ status + ", totalTimeSpent=" + totalTimeSpent + "]";
	}
}
