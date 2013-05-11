package com.ziksana.domain.course;

import java.sql.Timestamp;
import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseLearningPlanner extends AuditHistory {
	
	
	public CourseLearningPlanner(){
		
	}
	
	private ZID  					coursePlannerId;
	private Date 					startPeriod 			= null;
	private Date 					endPeriod 				= null;
	private Timestamp				startTime				= null;
	private Timestamp				endTime					= null;
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
	public void setCoursePlannerId(Integer coursePlannerId) {
		this.coursePlannerId = new IntegerZID(coursePlannerId);
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
	/**
	 * @return the startPeriod
	 */
	public Date getStartPeriod() {
		return startPeriod;
	}
	/**
	 * @param startPeriod the startPeriod to set
	 */
	public void setStartPeriod(Date startPeriod) {
		this.startPeriod = startPeriod;
	}
	/**
	 * @return the endPeriod
	 */
	public Date getEndPeriod() {
		return endPeriod;
	}
	/**
	 * @param endPeriod the endPeriod to set
	 */
	public void setEndPeriod(Date endPeriod) {
		this.endPeriod = endPeriod;
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
	
}
