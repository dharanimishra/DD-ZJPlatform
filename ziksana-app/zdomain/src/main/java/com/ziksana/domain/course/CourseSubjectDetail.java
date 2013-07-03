/**
 * 
 */
package com.ziksana.domain.course;

import java.util.Date;

/**
 * @author ratneshkumar Dec 15, 2012
 * 
 * 
 */
public class CourseSubjectDetail {

	private Integer subjectClassificationId;

	private Date creationDate;

	private String subjectCategory;

	private String subjectArea;

	private String subjectTopic;

	private Integer active;

	/**
	 * 
	 */
	public CourseSubjectDetail() {
		super();
	}

	/**
	 * @param subjectClassificationId
	 * @param creationDate
	 * @param subjectCategory
	 * @param subjectArea
	 * @param subjectTopic
	 * @param active
	 */
	public CourseSubjectDetail(Integer subjectClassificationId,
			Date creationDate, String subjectCategory, String subjectArea,
			String subjectTopic, Integer active) {
		super();
		this.subjectClassificationId = subjectClassificationId;
		this.creationDate = creationDate;
		this.subjectCategory = subjectCategory;
		this.subjectArea = subjectArea;
		this.subjectTopic = subjectTopic;
		this.active = active;
	}

	/**
	 * @return the subjectClassificationId
	 */
	public Integer getSubjectClassificationId() {
		return subjectClassificationId;
	}

	/**
	 * @param subjectClassificationId
	 *            the subjectClassificationId to set
	 */
	public void setSubjectClassificationId(Integer subjectClassificationId) {
		this.subjectClassificationId = subjectClassificationId;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the subjectCategory
	 */
	public String getSubjectCategory() {
		return subjectCategory;
	}

	/**
	 * @param subjectCategory
	 *            the subjectCategory to set
	 */
	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	/**
	 * @return the subjectArea
	 */
	public String getSubjectArea() {
		return subjectArea;
	}

	/**
	 * @param subjectArea
	 *            the subjectArea to set
	 */
	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}

	/**
	 * @return the subjectTopic
	 */
	public String getSubjectTopic() {
		return subjectTopic;
	}

	/**
	 * @param subjectTopic
	 *            the subjectTopic to set
	 */
	public void setSubjectTopic(String subjectTopic) {
		this.subjectTopic = subjectTopic;
	}

	/**
	 * @return the active
	 */
	public Integer getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Integer active) {
		this.active = active;
	}

}
