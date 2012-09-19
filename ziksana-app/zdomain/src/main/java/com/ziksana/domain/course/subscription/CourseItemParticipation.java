package com.ziksana.domain.course.subscription;

import java.util.Date;

public class CourseItemParticipation {
	/**
	 * This field corresponds to the database column
	 * sbncourseitemparticipation.courseItemParticipationId
	 */
	private Integer courseItemParticipationId;

	/**
	 * This field corresponds to the database column
	 * sbncourseitemparticipation.UsageDate
	 * 
	 */
	private Date usageDate;

	/**
	 * This field corresponds to the database column
	 * sbncourseitemparticipation.StartTime
	 * 
	 */
	private Date startTime;

	/**
	 * This field corresponds to the database column
	 * sbncourseitemparticipation.EndTime
	 * 
	 */
	private Date endTime;

	/**
	 * This field corresponds to the database column
	 * sbncourseitemparticipation.Duration
	 * 
	 */
	private Integer duration;

	/**
	 * This field corresponds to the database column
	 * sbncourseitemparticipation.subCourseItemCalendarId
	 * 
	 */
	private Integer subCourseItemCalendarId;

	/**
	 * This method returns the value of the database column
	 * sbncourseitemparticipation.courseItemParticipationId
	 * 
	 * @return the value of sbncourseitemparticipation.courseItemParticipationId
	 * 
	 */
	public Integer getCourseItemParticipationId() {
		return courseItemParticipationId;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseitemparticipation.courseItemParticipationId
	 * 
	 * @param courseItemParticipationId
	 *            the value for sbncourseitemparticipation.courseItemParticipationId
	 * 
	 */
	public void setCourseItemParticipationId(Integer courseItemParticipationId) {
		this.courseItemParticipationId = courseItemParticipationId;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseitemparticipation.UsageDate
	 * 
	 * @return the value of sbncourseitemparticipation.UsageDate
	 * 
	 */
	public Date getUsageDate() {
		return usageDate;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseitemparticipation.UsageDate
	 * 
	 * @param usageDate
	 *            the value for sbncourseitemparticipation.UsageDate
	 * 
	 */
	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseitemparticipation.StartTime
	 * 
	 * @return the value of sbncourseitemparticipation.StartTime
	 * 
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseitemparticipation.StartTime
	 * 
	 * @param startTime
	 *            the value for sbncourseitemparticipation.StartTime
	 * 
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseitemparticipation.EndTime
	 * 
	 * @return the value of sbncourseitemparticipation.EndTime
	 * 
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseitemparticipation.EndTime
	 * 
	 * @param endTime
	 *            the value for sbncourseitemparticipation.EndTime
	 * 
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseitemparticipation.Duration
	 * 
	 * @return the value of sbncourseitemparticipation.Duration
	 * 
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseitemparticipation.Duration
	 * 
	 * @param duration
	 *            the value for sbncourseitemparticipation.Duration
	 * 
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * This method returns the value of the database column
	 * sbncourseitemparticipation.subCourseItemCalendarId
	 * 
	 * @return the value of
	 *         sbncourseitemparticipation.subCourseItemCalendarId
	 * 
	 */
	public Integer getSubCourseItemCalendarId() {
		return subCourseItemCalendarId;
	}

	/**
	 * This method sets the value of the database column
	 * sbncourseitemparticipation.subCourseItemCalendarId
	 * 
	 * @param subCourseItemCalendarId
	 *            the value for sbncourseitemparticipation.subCourseItemCalendarId
	 * 
	 */
	public void setSubCourseItemCalendarId(
			Integer subCourseItemCalendarId) {
		this.subCourseItemCalendarId = subCourseItemCalendarId;
	}
}