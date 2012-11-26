package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * Domain holds the review rating
 * @author bhashasp
 */
public class ContentReviewRating extends AuditHistory {
	
	public ContentReviewRating(Integer questionRating, Rating reviewerRating) {
		this.questionRating = questionRating;
		this.reviewerRating = reviewerRating;
	}
	private ZID 							reviewRatingId;
	private Integer 						questionRating 					= null;
	private Rating 							reviewerRating 					= null;
	private LearningContentReviewProgress 	courseReviewProgress 			= null;
	private WorkflowParticipant 			workflowParticipant 			= null;
	private Integer							averageAuthorRating				= null;
	private Integer							averageContentRating			= null;
	/**
	 * @return the reviewRatingId
	 */
	public ZID getReviewRatingId() {
		return reviewRatingId;
	}
	/**
	 * @param reviewRatingId the reviewRatingId to set
	 */
	public void setReviewRatingId(Integer reviewRatingId) {
		this.reviewRatingId = new IntegerZID(reviewRatingId);
	}
	/**
	 * @return the questionRating
	 */
	public Integer getQuestionRating() {
		return questionRating;
	}
	/**
	 * @param questionRating the questionRating to set
	 */
	public void setQuestionRating(Integer questionRating) {
		this.questionRating = questionRating;
	}
	/**
	 * @return the reviewerRating
	 */
	public Rating getReviewerRating() {
		return reviewerRating;
	}
	/**
	 * @param reviewerRating the reviewerRating to set
	 */
	public void setReviewerRating(Rating reviewerRating) {
		this.reviewerRating = reviewerRating;
	}

	/**
	 * @return the courseReviewProgress
	 */
	public LearningContentReviewProgress getCourseReviewProgress() {
		return courseReviewProgress;
	}
	/**
	 * @param courseReviewProgress the courseReviewProgress to set
	 */
	public void setCourseReviewProgress(LearningContentReviewProgress courseReviewProgress) {
		this.courseReviewProgress = courseReviewProgress;
	}
	/**
	 * @return the workflowParticipant
	 */
	public WorkflowParticipant getWorkflowParticipant() {
		return workflowParticipant;
	}
	/**
	 * @param workflowParticipant the workflowParticipant to set
	 */
	public void setWorkflowParticipant(WorkflowParticipant workflowParticipant) {
		this.workflowParticipant = workflowParticipant;
	}
	@Override
	public String toString() {
		return "ContentReviewRating [questionRating=" + questionRating
				+ ", reviewerRating=" + reviewerRating + "]";
	}
	/**
	 * @return the averageAuthorRating
	 */
	public Integer getAverageAuthorRating() {
		return averageAuthorRating;
	}
	/**
	 * @param averageAuthorRating the averageAuthorRating to set
	 */
	public void setAverageAuthorRating(Integer averageAuthorRating) {
		this.averageAuthorRating = averageAuthorRating;
	}
	/**
	 * @return the averageContentRating
	 */
	public Integer getAverageContentRating() {
		return averageContentRating;
	}
	/**
	 * @param averageContentRating the averageContentRating to set
	 */
	public void setAverageContentRating(Integer averageContentRating) {
		this.averageContentRating = averageContentRating;
	}
	

}
