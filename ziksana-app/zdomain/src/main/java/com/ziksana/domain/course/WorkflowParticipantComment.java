package com.ziksana.domain.course;

import java.util.Date;

public class WorkflowParticipantComment {
	/**
	 * This field corresponds to the database column
	 * corworkflowparticipantcomment.workflowParticipantCommentId
	 */
	private Integer workflowParticipantCommentId;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipantcomment.CommentDate
	 */
	private Date commentDate;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipantcomment.Comment
	 */
	private String comment;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipantcomment.Criticality
	 */
	private Integer criticality;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipantcomment.IgnoredIndicator
	 */
	private Boolean ignoredIndicator;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipantcomment.ClosingRemarks
	 */
	private String closingRemarks;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipantcomment.Status
	 */
	private Integer status;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipantcomment.WorkflowParticipantId
	 */
	private Integer workflowParticipantId;

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipantcomment.workflowParticipantCommentId
	 * 
	 * @return the value of
	 *         corworkflowparticipantcomment.workflowParticipantCommentId
	 */
	public Integer getWorkflowParticipantCommentId() {
		return workflowParticipantCommentId;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipantcomment.workflowParticipantCommentId
	 * 
	 * @param workflowParticipantCommentId
	 *            the value for
	 *            corworkflowparticipantcomment.workflowParticipantCommentId
	 */
	public void setWorkflowParticipantCommentId(
			Integer workflowParticipantCommentId) {
		this.workflowParticipantCommentId = workflowParticipantCommentId;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipantcomment.CommentDate
	 * 
	 * @return the value of corworkflowparticipantcomment.CommentDate
	 */
	public Date getCommentDate() {
		return commentDate;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipantcomment.CommentDate
	 * 
	 * @param commentDate
	 *            the value for corworkflowparticipantcomment.CommentDate
	 */
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipantcomment.Comment
	 * 
	 * @return the value of corworkflowparticipantcomment.Comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipantcomment.Comment
	 * 
	 * @param comment
	 *            the value for corworkflowparticipantcomment.Comment
	 */
	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipantcomment.Criticality
	 * 
	 * @return the value of corworkflowparticipantcomment.Criticality
	 */
	public Integer getCriticality() {
		return criticality;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipantcomment.Criticality
	 * 
	 * @param criticality
	 *            the value for corworkflowparticipantcomment.Criticality
	 */
	public void setCriticality(Integer criticality) {
		this.criticality = criticality;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipantcomment.IgnoredIndicator
	 * 
	 * @return the value of corworkflowparticipantcomment.IgnoredIndicator
	 */
	public Boolean getIgnoredIndicator() {
		return ignoredIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipantcomment.IgnoredIndicator
	 * 
	 * @param ignoredIndicator
	 *            the value for corworkflowparticipantcomment.IgnoredIndicator
	 */
	public void setIgnoredIndicator(Boolean ignoredIndicator) {
		this.ignoredIndicator = ignoredIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipantcomment.ClosingRemarks
	 * 
	 * @return the value of corworkflowparticipantcomment.ClosingRemarks
	 */
	public String getClosingRemarks() {
		return closingRemarks;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipantcomment.ClosingRemarks
	 * 
	 * @param closingRemarks
	 *            the value for corworkflowparticipantcomment.ClosingRemarks
	 */
	public void setClosingRemarks(String closingRemarks) {
		this.closingRemarks = closingRemarks == null ? null : closingRemarks
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipantcomment.Status
	 * 
	 * @return the value of corworkflowparticipantcomment.Status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipantcomment.Status
	 * 
	 * @param status
	 *            the value for corworkflowparticipantcomment.Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipantcomment.WorkflowParticipantId
	 * 
	 * @return the value of corworkflowparticipantcomment.WorkflowParticipantId
	 */
	public Integer getWorkflowParticipantId() {
		return workflowParticipantId;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipantcomment.WorkflowParticipantId
	 * 
	 * @param workflowParticipantId
	 *            the value for
	 *            corworkflowparticipantcomment.WorkflowParticipantId
	 */
	public void setWorkflowParticipantId(Integer workflowParticipantId) {
		this.workflowParticipantId = workflowParticipantId;
	}
}