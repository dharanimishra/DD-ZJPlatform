package com.ziksana.domain.course.subscription;

import java.sql.Timestamp;
import java.util.Date;
import com.ziksana.domain.course.Duration;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseParticipation {
	
	private ZID 				courseParticipationId;
	private Date 				creationDate 		= null;
	private Timestamp 			startTime 			= null;
	private Timestamp 			endTime 			= null;
	private Duration			duration 			= null;
	private SubscriptionCourse 	subscriptionCourse 	= null;
	
	/**
	 * @return the courseParticipationId
	 */
	public ZID getCourseParticipationId() {
		return courseParticipationId;
	}
	/**
	 * @param courseParticipationId the courseParticipationId to set
	 */
	public void setCourseParticipationId(Integer courseParticipationId) {
		this.courseParticipationId = new IntegerZID(courseParticipationId);
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
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the duration
	 */
	public Duration getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Duration duration) {
		this.duration = duration;
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
	
	
}
