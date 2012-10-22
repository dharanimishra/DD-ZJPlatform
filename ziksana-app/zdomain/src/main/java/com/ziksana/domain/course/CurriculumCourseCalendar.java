/**
 * 
 */
package com.ziksana.domain.course;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CurriculumCourseCalendar extends AuditHistory {
	
	public CurriculumCourseCalendar(Date startDate, Date endDate,
			Timestamp startTime, Timestamp endTime, Duration duration,
			Boolean zeniSuggestedIndicator) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}

	private ZID 							curriculumCourseCalendarId;
	private Date 							startDate 					= null;
	private Date 							endDate 					= null;
	private Timestamp 						startTime 					= null;
	private Timestamp 						endTime 					= null;
	private Duration 						duration 					= null;
	private Boolean 						zeniSuggestedIndicator 		= null;
	
	private CurriculumCourse 				curriculumCourse 			= null;
	private List<Course> 					courseList 					= null;
	private List<CourseLearningComponent> 	courseLearningComponentList = null;
	private CurriculumDelivery 				curriculumDelivery 			= null;
	
	
	/**
	 * @return the curriculumCourseCalendarId
	 */
	public ZID getCurriculumCourseCalendarId() {
		return curriculumCourseCalendarId;
	}
	/**
	 * @param curriculumCourseCalendarId the curriculumCourseCalendarId to set
	 */
	public void setCurriculumCourseCalendarId(ZID curriculumCourseCalendarId) {
		this.curriculumCourseCalendarId = curriculumCourseCalendarId;
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
	 * @return the zeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}
	/**
	 * @param zeniSuggestedIndicator the zeniSuggestedIndicator to set
	 */
	public void setZeniSuggestedIndicator(Boolean zeniSuggestedIndicator) {
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}
	/**
	 * @return the curriculumCourse
	 */
	public CurriculumCourse getCurriculumCourse() {
		return curriculumCourse;
	}
	/**
	 * @param curriculumCourse the curriculumCourse to set
	 */
	public void setCurriculumCourse(CurriculumCourse curriculumCourse) {
		this.curriculumCourse = curriculumCourse;
	}
	/**
	 * @return the courseList
	 */
	public List<Course> getCourseList() {
		return courseList;
	}
	/**
	 * @param courseList the courseList to set
	 */
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	/**
	 * @return the courseLearningComponentList
	 */
	public List<CourseLearningComponent> getCourseLearningComponentList() {
		return courseLearningComponentList;
	}
	/**
	 * @param courseLearningComponentList the courseLearningComponentList to set
	 */
	public void setCourseLearningComponentList(
			List<CourseLearningComponent> courseLearningComponentList) {
		this.courseLearningComponentList = courseLearningComponentList;
	}
	/**
	 * @return the curriculumDelivery
	 */
	public CurriculumDelivery getCurriculumDelivery() {
		return curriculumDelivery;
	}
	/**
	 * @param curriculumDelivery the curriculumDelivery to set
	 */
	public void setCurriculumDelivery(CurriculumDelivery curriculumDelivery) {
		this.curriculumDelivery = curriculumDelivery;
	}
	
	@Override
	public String toString() {
		return "CurriculumCourseCalendar [startDate=" + startDate
				+ ", endDate=" + endDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", duration=" + duration
				+ ", zeniSuggestedIndicator=" + zeniSuggestedIndicator + "]";
	}
	

}
