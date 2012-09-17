package com.ziksana.domain.course.subscription;

import java.util.Date;

public class SubscriptionCourseItemCalendar {
	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.subCourseItemCalendarId
	 */
	private Integer subCourseItemCalendarId;

	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.CreatedDate
	 */
	private Date createdDate;

	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.StartDate
	 */
	private Date startDate;

	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.EndDate
	 */
	private Date endDate;

	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.Status
	 */
	private Integer status;

	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.CalendarItemDescription
	 */
	private String calendarItemDescription;

	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.ZeniRecommendedIndicator
	 */
	private Boolean zeniRecommendedIndicator;

	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.SubscriptionCourseId
	 */
	private Integer subscriptionCourseId;

	/**
	 * This field corresponds to the database column
	 * sbnsubscriptioncourseitemcalendar.LearningComponentId
	 */
	private Integer learningComponentId;

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.subCourseItemCalendarId
	 * 
	 * @return the value of sbnsubscriptioncourseitemcalendar.subCourseItemCalendarId
	 */
	public Integer getSubCourseItemCalendarId() {
		return subCourseItemCalendarId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.subCourseItemCalendarId
	 * 
	 * @param subCourseItemCalendarId
	 *            the value for sbnsubscriptioncourseitemcalendar.subCourseItemCalendarId
	 */
	public void setSubCourseItemCalendarId(Integer subCourseItemCalendarId) {
		this.subCourseItemCalendarId = subCourseItemCalendarId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.CreatedDate
	 * 
	 * @return the value of sbnsubscriptioncourseitemcalendar.CreatedDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.CreatedDate
	 * 
	 * @param createdDate
	 *            the value for sbnsubscriptioncourseitemcalendar.CreatedDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.StartDate
	 * 
	 * @return the value of sbnsubscriptioncourseitemcalendar.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.StartDate
	 * 
	 * @param startDate
	 *            the value for sbnsubscriptioncourseitemcalendar.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.EndDate
	 * 
	 * @return the value of sbnsubscriptioncourseitemcalendar.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.EndDate
	 * 
	 * @param endDate
	 *            the value for sbnsubscriptioncourseitemcalendar.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.Status
	 * 
	 * @return the value of sbnsubscriptioncourseitemcalendar.Status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.Status
	 * 
	 * @param status
	 *            the value for sbnsubscriptioncourseitemcalendar.Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.CalendarItemDescription
	 * 
	 * @return the value of
	 *         sbnsubscriptioncourseitemcalendar.CalendarItemDescription
	 */
	public String getCalendarItemDescription() {
		return calendarItemDescription;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.CalendarItemDescription
	 * 
	 * @param calendarItemDescription
	 *            the value for
	 *            sbnsubscriptioncourseitemcalendar.CalendarItemDescription
	 */
	public void setCalendarItemDescription(String calendarItemDescription) {
		this.calendarItemDescription = calendarItemDescription == null ? null
				: calendarItemDescription.trim();
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.ZeniRecommendedIndicator
	 * 
	 * @return the value of
	 *         sbnsubscriptioncourseitemcalendar.ZeniRecommendedIndicator
	 */
	public Boolean getZeniRecommendedIndicator() {
		return zeniRecommendedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.ZeniRecommendedIndicator
	 * 
	 * @param zeniRecommendedIndicator
	 *            the value for
	 *            sbnsubscriptioncourseitemcalendar.ZeniRecommendedIndicator
	 */
	public void setZeniRecommendedIndicator(Boolean zeniRecommendedIndicator) {
		this.zeniRecommendedIndicator = zeniRecommendedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.SubscriptionCourseId
	 * 
	 * @return the value of
	 *         sbnsubscriptioncourseitemcalendar.SubscriptionCourseId
	 */
	public Integer getSubscriptionCourseId() {
		return subscriptionCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.SubscriptionCourseId
	 * 
	 * @param subscriptionCourseId
	 *            the value for
	 *            sbnsubscriptioncourseitemcalendar.SubscriptionCourseId
	 */
	public void setSubscriptionCourseId(Integer subscriptionCourseId) {
		this.subscriptionCourseId = subscriptionCourseId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscriptioncourseitemcalendar.LearningComponentId
	 * 
	 * @return the value of
	 *         sbnsubscriptioncourseitemcalendar.LearningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscriptioncourseitemcalendar.LearningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for
	 *            sbnsubscriptioncourseitemcalendar.LearningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}
}