package com.ziksana.domain.course;

import java.util.Date;

public class ContentReviewWorkflow {
	/**
	 * This field corresponds to the database column
	 * corcontentreviewworkflow.reviewWorkflowId
	 */
	private Integer reviewWorkflowId;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewworkflow.CreatedDate
	 */
	private Date createdDate;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewworkflow.WorkflowType
	 */
	private Integer workflowType;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewworkflow.CompleteBy
	 */
	private Date completeBy;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewworkflow.Notes
	 */
	private String notes;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewworkflow.LearningContentReviewProgressId
	 */
	private Integer learningContentReviewProgressId;

	/**
	 * This method returns the value of the database column
	 * corcontentreviewworkflow.reviewWorkflowId
	 * 
	 * @return the value of corcontentreviewworkflow.reviewWorkflowId
	 */
	public Integer getReviewWorkflowId() {
		return reviewWorkflowId;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewworkflow.reviewWorkflowId
	 * 
	 * @param reviewWorkflowId
	 *            the value for corcontentreviewworkflow.reviewWorkflowId
	 */
	public void setReviewWorkflowId(Integer reviewWorkflowId) {
		this.reviewWorkflowId = reviewWorkflowId;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewworkflow.CreatedDate
	 * 
	 * @return the value of corcontentreviewworkflow.CreatedDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewworkflow.CreatedDate
	 * 
	 * @param createdDate
	 *            the value for corcontentreviewworkflow.CreatedDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewworkflow.WorkflowType
	 * 
	 * @return the value of corcontentreviewworkflow.WorkflowType
	 */
	public Integer getWorkflowType() {
		return workflowType;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewworkflow.WorkflowType
	 * 
	 * @param workflowType
	 *            the value for corcontentreviewworkflow.WorkflowType
	 */
	public void setWorkflowType(Integer workflowType) {
		this.workflowType = workflowType;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewworkflow.CompleteBy
	 * 
	 * @return the value of corcontentreviewworkflow.CompleteBy
	 */
	public Date getCompleteBy() {
		return completeBy;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewworkflow.CompleteBy
	 * 
	 * @param completeBy
	 *            the value for corcontentreviewworkflow.CompleteBy
	 */
	public void setCompleteBy(Date completeBy) {
		this.completeBy = completeBy;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewworkflow.Notes
	 * 
	 * @return the value of corcontentreviewworkflow.Notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewworkflow.Notes
	 * 
	 * @param notes
	 *            the value for corcontentreviewworkflow.Notes
	 */
	public void setNotes(String notes) {
		this.notes = notes == null ? null : notes.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewworkflow.LearningContentReviewProgressId
	 * 
	 * @return the value of
	 *         corcontentreviewworkflow.LearningContentReviewProgressId
	 */
	public Integer getLearningContentReviewProgressId() {
		return learningContentReviewProgressId;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewworkflow.LearningContentReviewProgressId
	 * 
	 * @param learningContentReviewProgressId
	 *            the value for
	 *            corcontentreviewworkflow.LearningContentReviewProgressId
	 */
	public void setLearningContentReviewProgressId(
			Integer learningContentReviewProgressId) {
		this.learningContentReviewProgressId = learningContentReviewProgressId;
	}
}