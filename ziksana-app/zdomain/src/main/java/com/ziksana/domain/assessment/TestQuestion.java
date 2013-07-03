package com.ziksana.domain.assessment;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestQuestion extends AuditHistory{


	public TestQuestion(){
		
	}
	
	public TestQuestion(Integer pointsIfCorrect, Integer extraCreditPoints,
			Boolean isPenaltyIfIncorrect, Integer penaltyMarks,
			Integer answerWithinTime, String questionContentMarkup,
			 QuestionBank questionBank) {
		this.pointsIfCorrect = pointsIfCorrect;
		this.extraCreditPoints = extraCreditPoints;
		this.isPenaltyIfIncorrect = isPenaltyIfIncorrect;
		this.setPenaltyMarks(penaltyMarks);
		this.answerWithinTime = answerWithinTime;
		this.questionContentMarkup = questionContentMarkup;
		//this.assignment = assignment;
		this.questionBank = questionBank;
	}
	
	
	private ZID 			testQuestionId;
	private Date 			creationDate 				= null;
	private Boolean 		active						= null;
	private Integer 		pointsIfCorrect				= null;
	private Integer			marks						= null;
	private Integer 		extraCreditPoints			= null;
	private Boolean 		isPenaltyIfIncorrect		= null;
	private Integer 		penaltyMarks				= null;//percentage ranging from 0 to 500
	private Integer 		answerWithinTime			= null;//time
	private String 			questionContentMarkup		= null;
	private Boolean 		isVideoAnswerAllowed		= null;
	private Boolean 		isAudioAnwerAllowed			= null;
	private Test 			test						= null;
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
	public void setTestQuestionId(Integer testQuestionId) {
		this.testQuestionId = new IntegerZID(testQuestionId);
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
	 * @return the marks
	 */
	public Integer getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(Integer marks) {
		this.marks = marks;
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
	 * @return the penaltyMarks
	 */
	public Integer getPenaltyMarks() {
		return penaltyMarks;
	}

	/**
	 * @param penaltyMarks the penaltyMarks to set
	 */
	public void setPenaltyMarks(Integer penaltyMarks) {
		this.penaltyMarks = penaltyMarks;
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
	 * @return the isVideoAnswerAllowed
	 */
	public Boolean getIsVideoAnswerAllowed() {
		return isVideoAnswerAllowed;
	}

	/**
	 * @param isVideoAnswerAllowed the isVideoAnswerAllowed to set
	 */
	public void setIsVideoAnswerAllowed(Boolean isVideoAnswerAllowed) {
		this.isVideoAnswerAllowed = isVideoAnswerAllowed;
	}

		/**
	 * @return the isAudioAnwerAllowed
	 */
	public Boolean getIsAudioAnwerAllowed() {
		return isAudioAnwerAllowed;
	}

	/**
	 * @param isAudioAnwerAllowed the isAudioAnwerAllowed to set
	 */
	public void setIsAudioAnwerAllowed(Boolean isAudioAnwerAllowed) {
		this.isAudioAnwerAllowed = isAudioAnwerAllowed;
	}

/*		*//**
	 * @return the assignmentTest
	 *//*
	public Assignment getAssignment() {
		return assignment;
	}
	*//**
	 * @param assignment the assignmentTest to set
	 *//*
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
*/	/**
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
				+ ", isPenaltyIfIncorrect="
				+ isPenaltyIfIncorrect + ", penaltyMarks="
				+ penaltyMarks + ", answerWithinTime=" + answerWithinTime
				+ ", questionContentMarkup=" + questionContentMarkup + "]";
	}

	/**
	 * @return the isPenaltyIfIncorrect
	 */
	public Boolean getIsPenaltyIfIncorrect() {
		return isPenaltyIfIncorrect;
	}

	/**
	 * @param isPenaltyIfIncorrect the isPenaltyIfIncorrect to set
	 */
	public void setIsPenaltyIfIncorrect(Boolean isPenaltyIfIncorrect) {
		this.isPenaltyIfIncorrect = isPenaltyIfIncorrect;
	}

	/**
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}
	
}