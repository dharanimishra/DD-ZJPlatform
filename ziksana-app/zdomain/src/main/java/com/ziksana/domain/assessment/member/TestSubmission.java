package com.ziksana.domain.assessment.member;

import java.util.Date;

import com.ziksana.domain.assessment.QuestionBankAnswer;
import com.ziksana.domain.assessment.TestQuestion;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestSubmission {
	
	public TestSubmission(){
		
	}
	public TestSubmission(String submittedResponse, Integer duration,
			Boolean isResponseType, Boolean isCorrectness, String feedback,
			Boolean isZeniCommented, Boolean isPeerEvaluated) {
		super();
		this.submittedResponse = submittedResponse;
		this.duration = duration;
		this.isResponseType = isResponseType;
		this.isCorrectness = isCorrectness;
		this.feedback = feedback;
		this.isZeniCommented = isZeniCommented;
		this.isPeerEvaluated = isPeerEvaluated;
	}
	private ZID 					submissionId;
	private String 					submittedResponse 		= null;
	private Date					submittedDate			= null;
	private Integer 				duration 				= null;
	private Boolean 				isResponseType 			= null;
	private String 					responseContentLink 	= null;
	private Boolean 				isCorrectness 			= null;
	private String 					feedback 				= null;
	private Boolean 				isZeniCommented 		= null;
	private Boolean 				isPeerEvaluated 		= null;
	private StudentTest 			test 					= null;
	private TestQuestion 			question 				= null;
	private QuestionBankAnswer 		answer 					= null;
	private MemberPersona			evaluatingMemberRole 	= null;
	
	
	/**
	 * @return the submissionId
	 */
	public ZID getSubmissionId() {
		return submissionId;
	}
	/**
	 * @param submissionId the submissionId to set
	 */
	public void setSubmissionId(Integer submissionId) {
		this.submissionId = new IntegerZID(submissionId);
	}
	/**
	 * @return the submittedResponse
	 */
	public String getSubmittedResponse() {
		return submittedResponse;
	}
	/**
	 * @param submittedResponse the submittedResponse to set
	 */
	public void setSubmittedResponse(String submittedResponse) {
		this.submittedResponse = submittedResponse;
	}
	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	/**
	 * @return the isResponseType
	 */
	public Boolean getIsResponseType() {
		return isResponseType;
	}
	/**
	 * @param isResponseType the isResponseType to set
	 */
	public void setIsResponseType(Boolean isResponseType) {
		this.isResponseType = isResponseType;
	}
	/**
	 * @return the responseContentLink
	 */
	public String getResponseContentLink() {
		return responseContentLink;
	}
	/**
	 * @param responseContentLink the responseContentLink to set
	 */
	public void setResponseContentLink(String responseContentLink) {
		this.responseContentLink = responseContentLink;
	}
	/**
	 * @return the isCorrectness
	 */
	public Boolean getIsCorrectness() {
		return isCorrectness;
	}
	/**
	 * @param isCorrectness the isCorrectness to set
	 */
	public void setIsCorrectness(Boolean isCorrectness) {
		this.isCorrectness = isCorrectness;
	}
	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	/**
	 * @return the isZeniCommented
	 */
	public Boolean getIsZeniCommented() {
		return isZeniCommented;
	}
	/**
	 * @param isZeniCommented the isZeniCommented to set
	 */
	public void setIsZeniCommented(Boolean isZeniCommented) {
		this.isZeniCommented = isZeniCommented;
	}
	/**
	 * @return the isPeerEvaluated
	 */
	public Boolean getIsPeerEvaluated() {
		return isPeerEvaluated;
	}
	/**
	 * @param isPeerEvaluated the isPeerEvaluated to set
	 */
	public void setIsPeerEvaluated(Boolean isPeerEvaluated) {
		this.isPeerEvaluated = isPeerEvaluated;
	}
	/**
	 * @return the test
	 */
	public StudentTest getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(StudentTest test) {
		this.test = test;
	}
	/**
	 * @return the question
	 */
	public TestQuestion getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(TestQuestion question) {
		this.question = question;
	}
	/**
	 * @return the answer
	 */
	public QuestionBankAnswer getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(QuestionBankAnswer answer) {
		this.answer = answer;
	}
	/**
	 * @return the evaluatingMemberRole
	 */
	public MemberPersona getEvaluatingMemberRole() {
		return evaluatingMemberRole;
	}
	/**
	 * @param evaluatingMemberRole the evaluatingMemberRole to set
	 */
	public void setEvaluatingMemberRole(MemberPersona evaluatingMemberRole) {
		this.evaluatingMemberRole = evaluatingMemberRole;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestSubmission [submittedResponse=" + submittedResponse
				+ ", duration=" + duration + ", isResponseType="
				+ isResponseType + ", responseContentLink="
				+ responseContentLink + ", isCorrectness=" + isCorrectness
				+ ", feedback=" + feedback + ", isZeniCommented="
				+ isZeniCommented + ", isPeerEvaluated=" + isPeerEvaluated
				+ "]";
	}
	/**
	 * @return the submittedDate
	 */
	public Date getSubmittedDate() {
		return submittedDate;
	}
	/**
	 * @param submittedDate the submittedDate to set
	 */
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

}
