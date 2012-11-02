package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.Rating;
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
	/**
	 * @return the reviewRatingId
	 */
	public ZID getReviewRatingId() {
		return reviewRatingId;
	}
	/**
	 * @param reviewRatingId the reviewRatingId to set
	 */
	public void setReviewRatingId(ZID reviewRatingId) {
		this.reviewRatingId = reviewRatingId;
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
	

}
