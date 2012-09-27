package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class CurriculumCourseCalendar extends AuditHistory{
	private Integer currCourseCalendarId;
	private Date creationDate;
	private Date startDate;
	private Date endDate;
	private Date startTime;
	private Date endTime;
	private Integer duration;
	private Boolean zeniSuggestedIndicator;
	private CurriculumCourse curriculumCourse;
	private Course course;
	private CourseLearningComponent courseLearningComponent;
	private CurriculumCourseCalendar curriculumCourseCalendar;
	private CurriculumDelivery curriculumDelivery;

	/**
	 * @return the value of corcurriculumcoursecalendar.currCourseCalendarId
	 */
	public Integer getCurrCourseCalendarId() {
		return currCourseCalendarId;
	}

	/**
	 * @param currCourseCalendarId
	 *            the value for corcurriculumcoursecalendar.currCourseCalendarId
	 */
	public void setCurrCourseCalendarId(Integer currCourseCalendarId) {
		this.currCourseCalendarId = currCourseCalendarId;
	}

	/**
	 * @return the value of corcurriculumcoursecalendar.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the value for corcurriculumcoursecalendar.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the value of corcurriculumcoursecalendar.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the value for corcurriculumcoursecalendar.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the value of corcurriculumcoursecalendar.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the value for corcurriculumcoursecalendar.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the value of corcurriculumcoursecalendar.StartTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the value for corcurriculumcoursecalendar.StartTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the value of corcurriculumcoursecalendar.EndTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the value for corcurriculumcoursecalendar.EndTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the value of corcurriculumcoursecalendar.Duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the value for corcurriculumcoursecalendar.Duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the value of corcurriculumcoursecalendar.ZeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}

	/**
	 * @param zeniSuggestedIndicator
	 *            the value for
	 *            corcurriculumcoursecalendar.ZeniSuggestedIndicator
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
	 * @return the curriculumCourseCalendar
	 */
	public CurriculumCourseCalendar getCurriculumCourseCalendar() {
		return curriculumCourseCalendar;
	}

	/**
	 * @param curriculumCourseCalendar the curriculumCourseCalendar to set
	 */
	public void setCurriculumCourseCalendar(CurriculumCourseCalendar curriculumCourseCalendar) {
		this.curriculumCourseCalendar = curriculumCourseCalendar;
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
}