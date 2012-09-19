package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class CoursePlaybookView implements Serializable{

	/**
	 * serial versionId
	 */
	private static final long serialVersionUID = 5606145887094339160L;
	/**
	 * This field corresponds to the database column corcourseplaybookview.coursePlaybookViewId
	 */
	private Integer coursePlaybookViewId;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.PlaybookViewName
	 */
	private String playbookViewName;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.DeliveryType
	 */
	private Integer deliveryType;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.LayoutMarkupPath
	 */
	private String layoutMarkupPath;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.ContentMarkupPath
	 */
	private String contentMarkupPath;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.CreationDate
	 */
	private Date creationDate;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.CoursePlaybookStatus
	 */
	private Integer coursePlaybookStatus;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.BrochureContentPath
	 */
	private String brochureContentPath;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.RecipientStudentModel
	 */
	private Integer recipientStudentModel;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.PlaybookId
	 */
	private Integer coursePlaybookId;
	/**
	 * This field corresponds to the database column
	 * corcourseplaybookview.CourseComponentId
	 */
	private Integer learningComponentId;

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.coursePlaybookViewId
	 * 
	 * @return the value of corcourseplaybookview.coursePlaybookViewId
	 */
	public Integer getCoursePlaybookViewId() {
		return coursePlaybookViewId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.coursePlaybookViewId
	 * 
	 * @param coursePlaybookViewId
	 *            the value for corcourseplaybookview.coursePlaybookViewId
	 */
	public void setCoursePlaybookViewId(Integer coursePlaybookViewId) {
		this.coursePlaybookViewId = coursePlaybookViewId;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.PlaybookViewName
	 * 
	 * @return the value of corcourseplaybookview.PlaybookViewName
	 */
	public String getPlaybookViewName() {
		return playbookViewName;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.PlaybookViewName
	 * 
	 * @param playbookViewName
	 *            the value for corcourseplaybookview.PlaybookViewName
	 */
	public void setPlaybookViewName(String playbookViewName) {
		this.playbookViewName = playbookViewName == null ? null
				: playbookViewName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.DeliveryType
	 * 
	 * @return the value of corcourseplaybookview.DeliveryType
	 */
	public Integer getDeliveryType() {
		return deliveryType;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.DeliveryType
	 * 
	 * @param deliveryType
	 *            the value for corcourseplaybookview.DeliveryType
	 */
	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.LayoutMarkupPath
	 * 
	 * @return the value of corcourseplaybookview.LayoutMarkupPath
	 */
	public String getLayoutMarkupPath() {
		return layoutMarkupPath;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.LayoutMarkupPath
	 * 
	 * @param layoutMarkupPath
	 *            the value for corcourseplaybookview.LayoutMarkupPath
	 */
	public void setLayoutMarkupPath(String layoutMarkupPath) {
		this.layoutMarkupPath = layoutMarkupPath == null ? null
				: layoutMarkupPath.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.ContentMarkupPath
	 * 
	 * @return the value of corcourseplaybookview.ContentMarkupPath
	 */
	public String getContentMarkupPath() {
		return contentMarkupPath;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.ContentMarkupPath
	 * 
	 * @param contentMarkupPath
	 *            the value for corcourseplaybookview.ContentMarkupPath
	 */
	public void setContentMarkupPath(String contentMarkupPath) {
		this.contentMarkupPath = contentMarkupPath == null ? null
				: contentMarkupPath.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.CreationDate
	 * 
	 * @return the value of corcourseplaybookview.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corcourseplaybookview.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.CoursePlaybookStatus
	 * 
	 * @return the value of corcourseplaybookview.CoursePlaybookStatus
	 */
	public Integer getCoursePlaybookStatus() {
		return coursePlaybookStatus;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.CoursePlaybookStatus
	 * 
	 * @param coursePlaybookStatus
	 *            the value for corcourseplaybookview.CoursePlaybookStatus
	 */
	public void setCoursePlaybookStatus(Integer coursePlaybookStatus) {
		this.coursePlaybookStatus = coursePlaybookStatus;
	}

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.BrochureContentPath
	 * 
	 * @return the value of corcourseplaybookview.BrochureContentPath
	 */
	public String getBrochureContentPath() {
		return brochureContentPath;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.BrochureContentPath
	 * 
	 * @param brochureContentPath
	 *            the value for corcourseplaybookview.BrochureContentPath
	 */
	public void setBrochureContentPath(String brochureContentPath) {
		this.brochureContentPath = brochureContentPath == null ? null
				: brochureContentPath.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourseplaybookview.RecipientStudentModel
	 * 
	 * @return the value of corcourseplaybookview.RecipientStudentModel
	 */
	public Integer getRecipientStudentModel() {
		return recipientStudentModel;
	}

	/**
	 * This method sets the value of the database column
	 * corcourseplaybookview.RecipientStudentModel
	 * 
	 * @param recipientStudentModel
	 *            the value for corcourseplaybookview.RecipientStudentModel
	 */
	public void setRecipientStudentModel(Integer recipientStudentModel) {
		this.recipientStudentModel = recipientStudentModel;
	}

	/**
	 * @return the coursePlaybookId
	 */
	public Integer getCoursePlaybookId() {
		return coursePlaybookId;
	}

	/**
	 * @param coursePlaybookId
	 *            the coursePlaybookId to set
	 */
	public void setCoursePlaybookId(Integer coursePlaybookId) {
		this.coursePlaybookId = coursePlaybookId;
	}

	/**
	 * @return the learningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * @param learningComponentId
	 *            the learningComponentId to set
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}
}