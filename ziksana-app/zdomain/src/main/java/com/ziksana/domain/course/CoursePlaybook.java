package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

/**
 * @author bhashasp
 */
public class CoursePlaybook extends AuditHistory {
	
	
	//Default playbook
	public CoursePlaybook(){
		this.playbookType = PlaybookType.PREVIEW;
	}
	
	//when create a new playbook
	public CoursePlaybook(CoursePlaybookStatus coursePBStatus, PlaybookType playbookType) {
		this.coursePBStatus = coursePBStatus;
		this.playbookType = PlaybookType.REGULAR;
	}

	private Integer 				coursePlaybookId;
	private Date 					fromDate  		= null;
	private Date 					toDate			= null;
	private CoursePlaybookStatus 	coursePBStatus 	= null;
	private Integer				 	coursePBStatusId= null;
	private PlaybookType			playbookType 	= null;
	private Integer					playbookTypeId 	= null;
	private Course					course			= null;
	private CoursePlaybookView		playbookView	= null;
	
	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the courseStatus
	 */
	public CoursePlaybookStatus getCoursePBStatus() {
		return coursePBStatus;
	}
	/**
	 * @param courseStatus the courseStatus to set
	 */
	public void setCoursePBStatus(CoursePlaybookStatus coursePBStatus) {
		this.coursePBStatus = coursePBStatus;
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
	 * @return the playbookView
	 */
	public CoursePlaybookView getPlaybookView() {
		return playbookView;
	}

	/**
	 * @param playbookView the playbookView to set
	 */
	public void setPlaybookView(CoursePlaybookView playbookView) {
		this.playbookView = playbookView;
	}

	@Override
	public String toString() {
		return "CoursePlaybook [coursePBStatus=" + coursePBStatus
				+ ", playbookType=" + playbookType + "]";
	}

	/**
	 * @return the coursePBStatusId
	 */
	public Integer getCoursePBStatusId() {
		return coursePBStatusId;
	}

	/**
	 * @param coursePBStatusId the coursePBStatusId to set
	 */
	public void setCoursePBStatusId(Integer coursePBStatusId) {
		this.coursePBStatusId = coursePBStatusId;
	}

	/**
	 * @return the playbookTypeId
	 */
	public Integer getPlaybookTypeId() {
		return playbookTypeId;
	}

	/**
	 * @param playbookTypeId the playbookTypeId to set
	 */
	public void setPlaybookTypeId(Integer playbookTypeId) {
		this.playbookTypeId = playbookTypeId;
	}

	/**
	 * @return the coursePlaybookId
	 */
	public Integer getCoursePlaybookId() {
		return coursePlaybookId;
	}

	/**
	 * @param coursePlaybookId the coursePlaybookId to set
	 */
	public void setCoursePlaybookId(Integer coursePlaybookId) {
		this.coursePlaybookId = coursePlaybookId;
	}

}
