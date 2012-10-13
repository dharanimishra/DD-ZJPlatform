/**
 * 
 */
package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CoursePlaybook extends AuditHistory {
	
	public CoursePlaybook(CourseStatus courseStatus, PlaybookType playbookType) {
		this.courseStatus = courseStatus;
		this.playbookType = playbookType;
	}

	private ZID coursePlaybookId;
	private Date fromDate  	= null;
	private Date toDate		= null;
	private CourseStatus courseStatus = null;
	private PlaybookType	playbookType = null;
	
	
	/**
	 * @return the coursePlaybookId
	 */
	public ZID getCoursePlaybookId() {
		return coursePlaybookId;
	}
	/**
	 * @param coursePlaybookId the coursePlaybookId to set
	 */
	public void setCoursePlaybookId(ZID coursePlaybookId) {
		this.coursePlaybookId = coursePlaybookId;
	}
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

	@Override
	public String toString() {
		return "CoursePlaybook [courseStatus=" + courseStatus
				+ ", playbookType=" + playbookType + "]";
	}

}
