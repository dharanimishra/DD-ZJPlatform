package com.ziksana.domain.course;

import java.util.Date;

public class ContentReviewRating {
	/**
	 * This field corresponds to the database column
	 * corcontentreviewrating.reviewRatingId
	 */
	private Integer reviewRatingId;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewrating.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewrating.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewrating.RatingQuestion
	 */
	private Integer ratingQuestion;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewrating.ReviewerRating
	 */
	private Integer reviewerRating;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewrating.LearningContentReviewProgressId
	 */
	private Integer learningContentReviewProgressId;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewrating.WorkflowParticipantId
	 */
	private Integer workflowParticipantId;

	/**
	 * This field corresponds to the database column
	 * corcontentreviewrating.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * corcontentreviewrating.reviewRatingId
	 * 
	 * @return the value of corcontentreviewrating.reviewRatingId
	 */
	public Integer getReviewRatingId() {
		return reviewRatingId;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewrating.reviewRatingId
	 * 
	 * @param reviewRatingId
	 *            the value for corcontentreviewrating.reviewRatingId
	 */
	public void setReviewRatingId(Integer reviewRatingId) {
		this.reviewRatingId = reviewRatingId;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewrating.CreationDate
	 * 
	 * @return the value of corcontentreviewrating.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewrating.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corcontentreviewrating.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewrating.Active
	 * 
	 * @return the value of corcontentreviewrating.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewrating.Active
	 * 
	 * @param active
	 *            the value for corcontentreviewrating.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewrating.RatingQuestion
	 * 
	 * @return the value of corcontentreviewrating.RatingQuestion
	 */
	public Integer getRatingQuestion() {
		return ratingQuestion;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewrating.RatingQuestion
	 * 
	 * @param ratingQuestion
	 *            the value for corcontentreviewrating.RatingQuestion
	 */
	public void setRatingQuestion(Integer ratingQuestion) {
		this.ratingQuestion = ratingQuestion;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewrating.ReviewerRating
	 * 
	 * @return the value of corcontentreviewrating.ReviewerRating
	 */
	public Integer getReviewerRating() {
		return reviewerRating;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewrating.ReviewerRating
	 * 
	 * @param reviewerRating
	 *            the value for corcontentreviewrating.ReviewerRating
	 */
	public void setReviewerRating(Integer reviewerRating) {
		this.reviewerRating = reviewerRating;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewrating.LearningContentReviewProgressId
	 * 
	 * @return the value of
	 *         corcontentreviewrating.LearningContentReviewProgressId
	 */
	public Integer getLearningContentReviewProgressId() {
		return learningContentReviewProgressId;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewrating.LearningContentReviewProgressId
	 * 
	 * @param learningContentReviewProgressId
	 *            the value for
	 *            corcontentreviewrating.LearningContentReviewProgressId
	 */
	public void setLearningContentReviewProgressId(
			Integer learningContentReviewProgressId) {
		this.learningContentReviewProgressId = learningContentReviewProgressId;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewrating.WorkflowParticipantId
	 * 
	 * @return the value of corcontentreviewrating.WorkflowParticipantId
	 */
	public Integer getWorkflowParticipantId() {
		return workflowParticipantId;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewrating.WorkflowParticipantId
	 * 
	 * @param workflowParticipantId
	 *            the value for corcontentreviewrating.WorkflowParticipantId
	 */
	public void setWorkflowParticipantId(Integer workflowParticipantId) {
		this.workflowParticipantId = workflowParticipantId;
	}

	/**
	 * This method returns the value of the database column
	 * corcontentreviewrating.MemberRoleId
	 * 
	 * @return the value of corcontentreviewrating.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corcontentreviewrating.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corcontentreviewrating.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}