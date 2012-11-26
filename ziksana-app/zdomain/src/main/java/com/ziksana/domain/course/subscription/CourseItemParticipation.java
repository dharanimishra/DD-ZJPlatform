package com.ziksana.domain.course.subscription;

import java.sql.Timestamp;
import java.util.Date;

import com.ziksana.domain.course.Duration;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseItemParticipation {
	
	private ZID 							courseItemParticipationId;
	private Date 							usageDate 			= null;
	private Timestamp 						startTime 			= null;
	private Timestamp 						endTime 			= null;
	private Duration 						duration 			= null;
	private SubscriptionCourseItemCalendar  courseItemCalendar 	= null;
	
	/**
	 * @return the courseItemParticipationId
	 */
	public ZID getCourseItemParticipationId() {
		return courseItemParticipationId;
	}
	/**
	 * @param courseItemParticipationId the courseItemParticipationId to set
	 */
	public void setCourseItemParticipationId(Integer courseItemParticipationId) {
		this.courseItemParticipationId = new IntegerZID(courseItemParticipationId);
	}
	/**
	 * @return the usageDate
	 */
	public Date getUsageDate() {
		return usageDate;
	}
	/**
	 * @param usageDate the usageDate to set
	 */
	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
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
	 * @return the courseItemCalendar
	 */
	public SubscriptionCourseItemCalendar getCourseItemCalendar() {
		return courseItemCalendar;
	}
	/**
	 * @param courseItemCalendar the courseItemCalendar to set
	 */
	public void setCourseItemCalendar(
			SubscriptionCourseItemCalendar courseItemCalendar) {
		this.courseItemCalendar = courseItemCalendar;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseItemParticipation [usageDate=" + usageDate
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", duration=" + duration + "]";
	}
	


}
