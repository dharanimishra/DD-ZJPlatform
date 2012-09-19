package com.ziksana.domain.assessment.member;

public class TestSubmission {
	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.TestSubmissionId
	 */
	private Integer testSubmissionId;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.SubmittedResponse
	 */
	private String submittedResponse;

	/**
	 * This field corresponds to the database column msmtestsubmission.Duration
	 */
	private Integer duration;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.ZeniEvaluatedIndicator
	 */
	private Boolean zeniEvaluatedIndicator;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.ResponseTypeIndicator
	 */
	private Boolean responseTypeIndicator;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.ResponseContentLink
	 */
	private String responseContentLink;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.CorrectnessIndicator
	 */
	private Boolean correctnessIndicator;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.FeedbackComment
	 */
	private String feedbackComment;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.ZeniCommentedIndicator
	 */
	private Boolean zeniCommentedIndicator;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.PeerEvaluatedIndicator
	 */
	private Boolean peerEvaluatedIndicator;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.AssignmentTestId
	 */
	private Integer assignmentTestId;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.TestQuestionId
	 */
	private Integer testQuestionId;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.QuestionBankAnswerId
	 */
	private Integer questionBankAnswerId;

	/**
	 * This field corresponds to the database column
	 * msmtestsubmission.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.TestSubmissionId
	 * 
	 * @return the value of msmtestsubmission.TestSubmissionId
	 */
	public Integer getTestSubmissionId() {
		return testSubmissionId;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.TestSubmissionId
	 * 
	 * @param testSubmissionId
	 *            the value for msmtestsubmission.TestSubmissionId
	 */
	public void setTestSubmissionId(Integer testSubmissionId) {
		this.testSubmissionId = testSubmissionId;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.SubmittedResponse
	 * 
	 * @return the value of msmtestsubmission.SubmittedResponse
	 */
	public String getSubmittedResponse() {
		return submittedResponse;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.SubmittedResponse
	 * 
	 * @param submittedResponse
	 *            the value for msmtestsubmission.SubmittedResponse
	 */
	public void setSubmittedResponse(String submittedResponse) {
		this.submittedResponse = submittedResponse == null ? null
				: submittedResponse.trim();
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.Duration
	 * 
	 * @return the value of msmtestsubmission.Duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.Duration
	 * 
	 * @param duration
	 *            the value for msmtestsubmission.Duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.ZeniEvaluatedIndicator
	 * 
	 * @return the value of msmtestsubmission.ZeniEvaluatedIndicator
	 */
	public Boolean getZeniEvaluatedIndicator() {
		return zeniEvaluatedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.ZeniEvaluatedIndicator
	 * 
	 * @param zeniEvaluatedIndicator
	 *            the value for msmtestsubmission.ZeniEvaluatedIndicator
	 */
	public void setZeniEvaluatedIndicator(Boolean zeniEvaluatedIndicator) {
		this.zeniEvaluatedIndicator = zeniEvaluatedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.ResponseTypeIndicator
	 * 
	 * @return the value of msmtestsubmission.ResponseTypeIndicator
	 */
	public Boolean getResponseTypeIndicator() {
		return responseTypeIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.ResponseTypeIndicator
	 * 
	 * @param responseTypeIndicator
	 *            the value for msmtestsubmission.ResponseTypeIndicator
	 */
	public void setResponseTypeIndicator(Boolean responseTypeIndicator) {
		this.responseTypeIndicator = responseTypeIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.ResponseContentLink
	 * 
	 * @return the value of msmtestsubmission.ResponseContentLink
	 */
	public String getResponseContentLink() {
		return responseContentLink;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.ResponseContentLink
	 * 
	 * @param responseContentLink
	 *            the value for msmtestsubmission.ResponseContentLink
	 */
	public void setResponseContentLink(String responseContentLink) {
		this.responseContentLink = responseContentLink == null ? null
				: responseContentLink.trim();
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.CorrectnessIndicator
	 * 
	 * @return the value of msmtestsubmission.CorrectnessIndicator
	 */
	public Boolean getCorrectnessIndicator() {
		return correctnessIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.CorrectnessIndicator
	 * 
	 * @param correctnessIndicator
	 *            the value for msmtestsubmission.CorrectnessIndicator
	 */
	public void setCorrectnessIndicator(Boolean correctnessIndicator) {
		this.correctnessIndicator = correctnessIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.FeedbackComment
	 * 
	 * @return the value of msmtestsubmission.FeedbackComment
	 */
	public String getFeedbackComment() {
		return feedbackComment;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.FeedbackComment
	 * 
	 * @param feedbackComment
	 *            the value for msmtestsubmission.FeedbackComment
	 */
	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment == null ? null : feedbackComment
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.ZeniCommentedIndicator
	 * 
	 * @return the value of msmtestsubmission.ZeniCommentedIndicator
	 */
	public Boolean getZeniCommentedIndicator() {
		return zeniCommentedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.ZeniCommentedIndicator
	 * 
	 * @param zeniCommentedIndicator
	 *            the value for msmtestsubmission.ZeniCommentedIndicator
	 */
	public void setZeniCommentedIndicator(Boolean zeniCommentedIndicator) {
		this.zeniCommentedIndicator = zeniCommentedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.PeerEvaluatedIndicator
	 * 
	 * @return the value of msmtestsubmission.PeerEvaluatedIndicator
	 */
	public Boolean getPeerEvaluatedIndicator() {
		return peerEvaluatedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.PeerEvaluatedIndicator
	 * 
	 * @param peerEvaluatedIndicator
	 *            the value for msmtestsubmission.PeerEvaluatedIndicator
	 */
	public void setPeerEvaluatedIndicator(Boolean peerEvaluatedIndicator) {
		this.peerEvaluatedIndicator = peerEvaluatedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.AssignmentTestId
	 * 
	 * @return the value of msmtestsubmission.AssignmentTestId
	 */
	public Integer getAssignmentTestId() {
		return assignmentTestId;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.AssignmentTestId
	 * 
	 * @param assignmentTestId
	 *            the value for msmtestsubmission.AssignmentTestId
	 */
	public void setAssignmentTestId(Integer assignmentTestId) {
		this.assignmentTestId = assignmentTestId;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.TestQuestionId
	 * 
	 * @return the value of msmtestsubmission.TestQuestionId
	 */
	public Integer getTestQuestionId() {
		return testQuestionId;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.TestQuestionId
	 * 
	 * @param testQuestionId
	 *            the value for msmtestsubmission.TestQuestionId
	 */
	public void setTestQuestionId(Integer testQuestionId) {
		this.testQuestionId = testQuestionId;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.QuestionBankAnswerId
	 * 
	 * @return the value of msmtestsubmission.QuestionBankAnswerId
	 */
	public Integer getQuestionBankAnswerId() {
		return questionBankAnswerId;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.QuestionBankAnswerId
	 * 
	 * @param questionBankAnswerId
	 *            the value for msmtestsubmission.QuestionBankAnswerId
	 */
	public void setQuestionBankAnswerId(Integer questionBankAnswerId) {
		this.questionBankAnswerId = questionBankAnswerId;
	}

	/**
	 * This method returns the value of the database column
	 * msmtestsubmission.MemberRoleId
	 * 
	 * @return the value of msmtestsubmission.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * msmtestsubmission.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for msmtestsubmission.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}