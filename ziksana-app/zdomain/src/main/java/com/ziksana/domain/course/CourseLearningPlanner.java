package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseLearningPlanner extends AuditHistory {
	
	public CourseLearningPlanner(Date startDate, Date endDate, Duration duration) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
	}
	
	private ZID  					coursePlannerId;
	private Date 					startDate 				= null;
	private Date 					endDate 				= null;
	private Duration 				duration 				= null;
	private CourseLearningComponent courseLearningComponent = null;
	private Course 					course 					= null;
	private CourseLearningPlanner 	courseComponentCalendar = null;
	
	/**
	 * @return the coursePlannerId
	 */
	public ZID getCoursePlannerId() {
		return coursePlannerId;
	}
	/**
	 * @param coursePlannerId the coursePlannerId to set
	 */
	public void setCoursePlannerId(ZID coursePlannerId) {
		this.coursePlannerId = coursePlannerId;
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
/*	*//**
	 * @return the courseLearningComponent
	 *//*
	public CourseLearningComponent getCourseLearningComponent() {
		return courseLearningComponent;
	}
	*//**
	 * @param courseLearningComponent the courseLearningComponent to set
	 *//*
	public void setCourseLearningComponent(
			CourseLearningComponent courseLearningComponent) {
		this.courseLearningComponent = courseLearningComponent;
	}
	*//**
	 * @return the course
	 *//*
	public Course getCourse() {
		return course;
	}
	*//**
	 * @param course the course to set
	 *//*
	public void setCourse(Course course) {
		this.course = course;
	}
*/	/**
	 * @return the courseComponentCalendar
	 */
	public CourseLearningPlanner getCourseComponentCalendar() {
		return courseComponentCalendar;
	}
	/**
	 * @param courseComponentCalendar the courseComponentCalendar to set
	 */
	public void setCourseComponentCalendar(
			CourseLearningPlanner courseComponentCalendar) {
		this.courseComponentCalendar = courseComponentCalendar;
	}

	@Override
	public String toString() {
		return "CourseLearningPlanner [startDate=" + startDate + ", endDate="
				+ endDate + ", duration=" + duration + "]";
	}
	/**
	 * @return the courseLearningComponent
	 */
	public CourseLearningComponent getCourseLearningComponent() {
		return courseLearningComponent;
	}
	/**
	 * @param courseLearningComponent the courseLearningComponent to set
	 */
	public void setCourseLearningComponent(CourseLearningComponent courseLearningComponent) {
		this.courseLearningComponent = courseLearningComponent;
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
	
}
