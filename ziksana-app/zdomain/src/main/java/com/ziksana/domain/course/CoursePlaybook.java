package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class CoursePlaybook extends AuditHistory{

	private Integer coursePlaybookId;
	private Date startDate;
	private Date endDate;
	private CourseStatus courseStatus;
	private Course course;
	private PlaybookStatus  playbookStatus;
	private PlaybookType playbookType;
	
	/**
	 * @return the value of corcourseplaybook.coursePlaybookId
	 */
	public Integer getcoursePlaybookId() {
		return coursePlaybookId;
	}

	/**
	 * @param coursePlaybookId
	 *            the value for corcourseplaybook.coursePlaybookId
	 */
	public void setcoursePlaybookId(Integer coursePlaybookId) {
		this.coursePlaybookId = coursePlaybookId;
	}

	/**
	 * @return the value of corcourseplaybook.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the value for corcourseplaybook.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the value of corcourseplaybook.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the value for corcourseplaybook.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the courseStatus
	 */
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	/**
	 * @param courseStatus the courseStatus to set
	 */
	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
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
	 * @return the playbookStatus
	 */
	public PlaybookStatus getPlaybookStatus() {
		return playbookStatus;
	}

	/**
	 * @param playbookStatus the playbookStatus to set
	 */
	public void setPlaybookStatus(PlaybookStatus playbookStatus) {
		this.playbookStatus = playbookStatus;
	}

	/**
	 * @return the playbookType
	 */
	public PlaybookType getPlaybookType() {
		return playbookType;
	}

	/**
	 * @param playbookType the playbookType to set
	 */
	public void setPlaybookType(PlaybookType playbookType) {
		this.playbookType = playbookType;
	}

	/**
	 * @return the value of corcourseplaybook.CourseStatus
	 */
}