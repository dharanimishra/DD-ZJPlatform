package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.Rating;
import com.ziksana.id.ZID;

/**
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
	private LearningContentReviewProgress 	learningContentReviewProgress 	= null;
	private WorkflowParticipant 			participant 					= null;
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
	 * @return the learningContentReviewProgress
	 */
	public LearningContentReviewProgress getLearningContentReviewProgress() {
		return learningContentReviewProgress;
	}
	/**
	 * @param learningContentReviewProgress the learningContentReviewProgress to set
	 */
	public void setLearningContentReviewProgress(
			LearningContentReviewProgress learningContentReviewProgress) {
		this.learningContentReviewProgress = learningContentReviewProgress;
	}
	/**
	 * @return the participant
	 */
	public WorkflowParticipant getParticipant() {
		return participant;
	}
	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(WorkflowParticipant participant) {
		this.participant = participant;
	}

	@Override
	public String toString() {
		return "ContentReviewRating [questionRating=" + questionRating
				+ ", reviewerRating=" + reviewerRating + "]";
	}
	

}
