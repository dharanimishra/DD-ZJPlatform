package com.ziksana.domain.utilz;

import java.io.Serializable;
import java.util.Date;

public class SubjectClassification implements Serializable{

	/**
	 */
	private static final long serialVersionUID = -6355785379087574399L;
	/**
	 * This field corresponds to the database column utlsubjectclassification.SubjClassificationId
	 */
	private Integer subjClassificationId;
	/**
	 * This field corresponds to the database column
	 * utlsubjectclassification.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * utlsubjectclassification.subjectCategory
	 */
	private String subjectCategory;

	/**
	 * This field corresponds to the database column
	 * utlsubjectclassification.SubjectArea
	 */
	private Integer subjectArea;
	/**
	 * This field corresponds to the database column
	 * utlsubjectclassification.SubjectTopic
	 */
	private Integer subjectTopic;
	/**
	 * This field corresponds to the database column utlsubjectclassification.Subject
	 */
	private Integer subject;
	/**
	 * This field corresponds to the database column utlsubjectclassification.Active
	 */
	private Boolean active;

	/**
	 * This method returns the value of the database column utlsubjectclassification.SubjClassificationId
	 * @return the value of utlsubjectclassification.SubjClassificationId
	 */
	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	/**
	 * This method sets the value of the database column utlsubjectclassification.SubjClassificationId
	 * @param SubjClassificationId
	 *            the value for utlsubjectclassification.SubjClassificationId
	 */
	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	/**
	 * This method returns the value of the database column
	 * utlsubjectclassification.CreationDate
	 * @return the value of utlsubjectclassification.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * utlsubjectclassification.CreationDate
	 * @param creationDate
	 *            the value for utlsubjectclassification.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * utlsubjectclassification.SubjectArea
	 * @return the value of utlsubjectclassification.SubjectArea
	 */
	public Integer getSubjectArea() {
		return subjectArea;
	}

	/**
	 * This method sets the value of the database column
	 * utlsubjectclassification.SubjectArea
	 * @param subjectArea
	 *            the value for utlsubjectclassification.SubjectArea
	 */
	public void setSubjectArea(Integer subjectArea) {
		this.subjectArea = subjectArea;
	}

	/**
	 * This method returns the value of the database column
	 * utlsubjectclassification.SubjectTopic
	 * @return the value of utlsubjectclassification.SubjectTopic
	 */
	public Integer getSubjectTopic() {
		return subjectTopic;
	}

	/**
	 * This method sets the value of the database column
	 * utlsubjectclassification.SubjectTopic
	 * @param subjectTopic
	 *            the value for utlsubjectclassification.SubjectTopic
	 */
	public void setSubjectTopic(Integer subjectTopic) {
		this.subjectTopic = subjectTopic;
	}

	/**
	 * This method returns the value of the database column
	 * utlsubjectclassification.Subject
	 * @return the value of utlsubjectclassification.Subject
	 */
	public Integer getSubject() {
		return subject;
	}

	/**
	 * This method sets the value of the database column
	 * utlsubjectclassification.Subject
	 * @param subject
	 *            the value for utlsubjectclassification.Subject
	 */
	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	/**
	 * This method returns the value of the database column
	 * utlsubjectclassification.Active
	 * @return the value of utlsubjectclassification.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * utlsubjectclassification.Active
	 * @param active
	 *            the value for utlsubjectclassification.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
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
}