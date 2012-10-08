package com.ziksana.domain.assessment;

import java.util.Date;
import com.ziksana.common.id.ZID;
import com.ziksana.domain.common.AuditHistory;

/**
 * @author bhashasp
 */
public class QuestionBankAnswer extends AuditHistory {
	
	
	public QuestionBankAnswer(Boolean active, String answerContent,
			Boolean correctIndicator, AnswerSequence answerSequence,
			Status status, QuestionBank questionBank,
			QuestionBankAnswer matchingQtnBankAnswer) {
		this.active = active;
		this.answerContent = answerContent;
		this.correctIndicator = correctIndicator;
		this.answerSequence = answerSequence;
		this.status = status;
		this.questionBank = questionBank;
		this.matchingQtnBankAnswer = matchingQtnBankAnswer;
	}

	private ZID 				questionBankAnswerId;
	private Date 				creationDate			= null;
	private String 				answerContent			= null;
	private Boolean 			correctIndicator		= null;
	private AnswerSequence 		answerSequence			= null;
	private String 				answerReflectionComment	= null;
	private Integer 			answerKeywordWeight		= null;
	private Status	status					= null;
	private QuestionBank 		questionBank			= null;
	private QuestionBankAnswer 	matchingQtnBankAnswer	= null;
	private VisualSpot 			visualSpotLabel			= null;
	private Boolean 			active					= null;
	
	/**
	 * @return the questionBankAnswerId
	 */
	public ZID getQuestionBankAnswerId() {
		return questionBankAnswerId;
	}
	/**
	 * @param questionBankAnswerId the questionBankAnswerId to set
	 */
	public void setQuestionBankAnswerId(ZID questionBankAnswerId) {
		this.questionBankAnswerId = questionBankAnswerId;
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
	 * @return the answerContent
	 */
	public String getAnswerContent() {
		return answerContent;
	}
	/**
	 * @param answerContent the answerContent to set
	 */
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	/**
	 * @return the correctIndicator
	 */
	public Boolean getCorrectIndicator() {
		return correctIndicator;
	}
	/**
	 * @param correctIndicator the correctIndicator to set
	 */
	public void setCorrectIndicator(Boolean correctIndicator) {
		this.correctIndicator = correctIndicator;
	}
	/**
	 * @return the answerSequence
	 */
	public AnswerSequence getAnswerSequence() {
		return answerSequence;
	}
	/**
	 * @param answerSequence the answerSequence to set
	 */
	public void setAnswerSequence(AnswerSequence answerSequence) {
		this.answerSequence = answerSequence;
	}
	/**
	 * @return the answerReflectionComment
	 */
	public String getAnswerReflectionComment() {
		return answerReflectionComment;
	}
	/**
	 * @param answerReflectionComment the answerReflectionComment to set
	 */
	public void setAnswerReflectionComment(String answerReflectionComment) {
		this.answerReflectionComment = answerReflectionComment;
	}
	/**
	 * @return the answerKeywordWeight
	 */
	public Integer getAnswerKeywordWeight() {
		return answerKeywordWeight;
	}
	/**
	 * @param answerKeywordWeight the answerKeywordWeight to set
	 */
	public void setAnswerKeywordWeight(Integer answerKeywordWeight) {
		this.answerKeywordWeight = answerKeywordWeight;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
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
	/**
	 * @return the matchingQtnBankAnswer
	 */
	public QuestionBankAnswer getMatchingQtnBankAnswer() {
		return matchingQtnBankAnswer;
	}
	/**
	 * @param matchingQtnBankAnswer the matchingQtnBankAnswer to set
	 */
	public void setMatchingQtnBankAnswer(QuestionBankAnswer matchingQtnBankAnswer) {
		this.matchingQtnBankAnswer = matchingQtnBankAnswer;
	}
	/**
	 * @return the visualSpotLabel
	 */
	public VisualSpot getVisualSpotLabel() {
		return visualSpotLabel;
	}
	/**
	 * @param visualSpotLabel the visualSpotLabel to set
	 */
	public void setVisualSpotLabel(VisualSpot visualSpotLabel) {
		this.visualSpotLabel = visualSpotLabel;
	}

	@Override
	public String toString() {
		return "QuestionBankAnswer [answerContent=" + answerContent
				+ ", correctIndicator=" + correctIndicator
				+ ", answerSequence=" + answerSequence + ", status=" + status
				+ ", questionBank=" + questionBank + "]";
	}

}