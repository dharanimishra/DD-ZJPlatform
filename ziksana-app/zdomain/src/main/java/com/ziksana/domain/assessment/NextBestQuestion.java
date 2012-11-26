package com.ziksana.domain.assessment;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class NextBestQuestion extends AuditHistory {
	

	public NextBestQuestion(TestModel testModel, Boolean active) {
		this.testModel = testModel;
		this.active = active;
	}

	
	private ZID 			nextBestQuestionId;
	private TestModel 		testModel 					= null;
	private Boolean 		active 						= null;
	private QuestionBank	sourceQuestion				= null;
	private QuestionBank	nextQuestion				= null;
	
	public ZID getNextBestQuestionId() {
		return nextBestQuestionId;
	}
	public void setNextBestQuestionId(Integer nextBestQuestionId) {
		this.nextBestQuestionId = new IntegerZID(nextBestQuestionId);
	}
	public TestModel getTestModel() {
		return testModel;
	}
	public void setTestModel(TestModel testModel) {
		this.testModel = testModel;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	/**
	 * @return the sourceQuestion
	 */
	public QuestionBank getSourceQuestion() {
		return sourceQuestion;
	}
	/**
	 * @param sourceQuestion the sourceQuestion to set
	 */
	public void setSourceQuestion(QuestionBank sourceQuestion) {
		this.sourceQuestion = sourceQuestion;
	}
	/**
	 * @return the nextQuestion
	 */
	public QuestionBank getNextQuestion() {
		return nextQuestion;
	}
	/**
	 * @param nextQuestion the nextQuestion to set
	 */
	public void setNextQuestion(QuestionBank nextQuestion) {
		this.nextQuestion = nextQuestion;
	}
	@Override
	public String toString() {
		return "NextBestQuestion [testModel=" + testModel + ", active="
				+ active + "]";
	}


}
