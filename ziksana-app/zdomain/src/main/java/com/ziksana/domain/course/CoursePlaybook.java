package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class CoursePlaybook implements Serializable{
	/**
	 */
	private static final long serialVersionUID = -2512406881043628210L;

	/**
	 * This field corresponds to the database column corcourseplaybook.coursePlaybookId
	 */
	private Integer coursePlaybookId;

	/**
	 * This field corresponds to the database column corcourseplaybook.StartDate
	 */
	private Date startDate;

	/**
	 * This field corresponds to the database column corcourseplaybook.EndDate
	 */
	private Date endDate;

	/**
	 * This field corresponds to the database column
	 * corcourseplaybook.CourseStatus
	 */
	private Integer courseStatus;
	
	/**
	 * This field corresponds to the database column
	 * corcourseplaybook.courseId
	 */
	private Integer courseId;
	
	/**
	 * This field corresponds to the database column
	 * corcourseplaybook.CoursePlaybookStatus
	 */
	private Integer  coursePlaybookStatus;
	
	/**
	 * This field corresponds to the database column
	 * corcourseplaybook.CoursePlaybookType
	 */
	private Integer coursePlaybookType;
	
	//private List<CorCourseComponent> corPlaybookComponents;

	/**
	 * . This method returns the value of the database column
	 * corcourseplaybook.coursePlaybookId
	 * 
	 * @return the value of corcourseplaybook.coursePlaybookId
	 * 
	 */
	public Integer getcoursePlaybookId() {
		return coursePlaybookId;
	}

	/**
	 * . This method sets the value of the database column corcourseplaybook.coursePlaybookId
	 * 
	 * @param coursePlaybookId
	 *            the value for corcourseplaybook.coursePlaybookId
	 * 
	 */
	public void setcoursePlaybookId(Integer coursePlaybookId) {
		this.coursePlaybookId = coursePlaybookId;
	}

	/**
	 * . This method returns the value of the database column
	 * corcourseplaybook.StartDate
	 * 
	 * @return the value of corcourseplaybook.StartDate
	 * 
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * . This method sets the value of the database column
	 * corcourseplaybook.StartDate
	 * 
	 * @param startDate
	 *            the value for corcourseplaybook.StartDate
	 * 
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * . This method returns the value of the database column
	 * corcourseplaybook.EndDate
	 * 
	 * @return the value of corcourseplaybook.EndDate
	 * 
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * . This method sets the value of the database column
	 * corcourseplaybook.EndDate
	 * 
	 * @param endDate
	 *            the value for corcourseplaybook.EndDate
	 * 
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * . This method returns the value of the database column
	 * corcourseplaybook.CourseStatus
	 * 
	 * @return the value of corcourseplaybook.CourseStatus
	 * 
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 * . This method sets the value of the database column
	 * corcourseplaybook.CourseStatus
	 * 
	 * @param courseStatus
	 *            the value for corcourseplaybook.CourseStatus
	 * 
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the coursePlaybookStatus
	 */
	public Integer getCoursePlaybookStatus() {
		return coursePlaybookStatus;
	}

	/**
	 * @param coursePlaybookStatus the coursePlaybookStatus to set
	 */
	public void setCoursePlaybookStatus(Integer coursePlaybookStatus) {
		this.coursePlaybookStatus = coursePlaybookStatus;
	}

	/**
	 * @return the coursePlaybookType
	 */
	public Integer getCoursePlaybookType() {
		return coursePlaybookType;
	}

	/**
	 * @param coursePlaybookType the coursePlaybookType to set
	 */
	public void setCoursePlaybookType(Integer coursePlaybookType) {
		this.coursePlaybookType = coursePlaybookType;
	}

/*	public List<CorCourseComponent> getCorPlaybookComponents() {
		return corPlaybookComponents;
	}

	public void setCorPlaybookComponents(List<CorCourseComponent> corPlaybookComponents) {
		this.corPlaybookComponents = corPlaybookComponents;
	}

*/
}