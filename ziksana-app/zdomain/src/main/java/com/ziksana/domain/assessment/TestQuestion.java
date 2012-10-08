package com.ziksana.domain.assessment;

import java.util.Date;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestQuestion extends AuditHistory{


	public TestQuestion(){
		
	}
	
	public TestQuestion(Integer pointsIfCorrect, Integer extraCreditPoints,
			Boolean penaltyIfIncorrectIndicator, PenaltyFactor penaltyFactor,
			Integer answerWithinTime, String questionContentMarkup,
			AssignmentTest assignmentTest, QuestionBank questionBank) {
		this.pointsIfCorrect = pointsIfCorrect;
		this.extraCreditPoints = extraCreditPoints;
		this.penaltyIfIncorrectIndicator = penaltyIfIncorrectIndicator;
		this.penaltyFactor = penaltyFactor;
		this.answerWithinTime = answerWithinTime;
		this.questionContentMarkup = questionContentMarkup;
		this.assignmentTest = assignmentTest;
		this.questionBank = questionBank;
	}
	
	
	private ZID 			testQuestionId;
	private Date 			creationDate 				= null;
	private Boolean 		active						= null;
	private Integer 		pointsIfCorrect				= null;
	private Integer 		extraCreditPoints			= null;
	private Boolean 		penaltyIfIncorrectIndicator	= null;
	private PenaltyFactor	penaltyFactor				= null;
	private Integer 		answerWithinTime			= null;
	private String 			questionContentMarkup		= null;
	private Boolean 		videoAnswerAllowedIndicator	= null;
	private Boolean 		audioAnwerAllowedIndicator	= null;
	private AssignmentTest 	assignmentTest				= null;
	private QuestionBank 	questionBank				= null;
	/**
	 * @return the testQuestionId
	 */
	public ZID getTestQuestionId() {
		return testQuestionId;
	}
	/**
	 * @param testQuestionId the testQuestionId to set
	 */
	public void setTestQuestionId(ZID testQuestionId) {
		this.testQuestionId = testQuestionId;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the pointsIfCorrect
	 */
	public Integer getPointsIfCorrect() {
		return pointsIfCorrect;
	}
	/**
	 * @param pointsIfCorrect the pointsIfCorrect to set
	 */
	public void setPointsIfCorrect(Integer pointsIfCorrect) {
		this.pointsIfCorrect = pointsIfCorrect;
	}
	/**
	 * @return the extraCreditPoints
	 */
	public Integer getExtraCreditPoints() {
		return extraCreditPoints;
	}
	/**
	 * @param extraCreditPoints the extraCreditPoints to set
	 */
	public void setExtraCreditPoints(Integer extraCreditPoints) {
		this.extraCreditPoints = extraCreditPoints;
	}
	/**
	 * @return the penaltyIfIncorrectIndicator
	 */
	public Boolean getPenaltyIfIncorrectIndicator() {
		return penaltyIfIncorrectIndicator;
	}
	/**
	 * @param penaltyIfIncorrectIndicator the penaltyIfIncorrectIndicator to set
	 */
	public void setPenaltyIfIncorrectIndicator(Boolean penaltyIfIncorrectIndicator) {
		this.penaltyIfIncorrectIndicator = penaltyIfIncorrectIndicator;
	}
	/**
	 * @return the penaltyFactor
	 */
	public PenaltyFactor getPenaltyFactor() {
		return penaltyFactor;
	}
	/**
	 * @param penaltyFactor the penaltyFactor to set
	 */
	public void setPenaltyFactor(PenaltyFactor penaltyFactor) {
		this.penaltyFactor = penaltyFactor;
	}
	/**
	 * @return the answerWithinTime
	 */
	public Integer getAnswerWithinTime() {
		return answerWithinTime;
	}
	/**
	 * @param answerWithinTime the answerWithinTime to set
	 */
	public void setAnswerWithinTime(Integer answerWithinTime) {
		this.answerWithinTime = answerWithinTime;
	}
	/**
	 * @return the questionContentMarkup
	 */
	public String getQuestionContentMarkup() {
		return questionContentMarkup;
	}
	/**
	 * @param questionContentMarkup the questionContentMarkup to set
	 */
	public void setQuestionContentMarkup(String questionContentMarkup) {
		this.questionContentMarkup = questionContentMarkup;
	}
	/**
	 * @return the videoAnswerAllowedIndicator
	 */
	public Boolean getVideoAnswerAllowedIndicator() {
		return videoAnswerAllowedIndicator;
	}
	/**
	 * @param videoAnswerAllowedIndicator the videoAnswerAllowedIndicator to set
	 */
	public void setVideoAnswerAllowedIndicator(Boolean videoAnswerAllowedIndicator) {
		this.videoAnswerAllowedIndicator = videoAnswerAllowedIndicator;
	}
	/**
	 * @return the audioAnwerAllowedIndicator
	 */
	public Boolean getAudioAnwerAllowedIndicator() {
		return audioAnwerAllowedIndicator;
	}
	/**
	 * @param audioAnwerAllowedIndicator the audioAnwerAllowedIndicator to set
	 */
	public void setAudioAnwerAllowedIndicator(Boolean audioAnwerAllowedIndicator) {
		this.audioAnwerAllowedIndicator = audioAnwerAllowedIndicator;
	}
	/**
	 * @return the assignmentTest
	 */
	public AssignmentTest getAssignmentTest() {
		return assignmentTest;
	}
	/**
	 * @param assignmentTest the assignmentTest to set
	 */
	public void setAssignmentTest(AssignmentTest assignmentTest) {
		this.assignmentTest = assignmentTest;
	}
	/**
	 * @return the questionBank
	 */
	public QuestionBank getQuestionBank() {
		return questionBank;
	}
	/**
	 * @param questionBank the questionBank to set
	 */
	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

	@Override
	public String toString() {
		return "TestQuestion [pointsIfCorrect=" + pointsIfCorrect
				+ ", extraCreditPoints=" + extraCreditPoints
				+ ", penaltyIfIncorrectIndicator="
				+ penaltyIfIncorrectIndicator + ", penaltyFactor="
				+ penaltyFactor + ", answerWithinTime=" + answerWithinTime
				+ ", questionContentMarkup=" + questionContentMarkup + "]";
	}
	
}