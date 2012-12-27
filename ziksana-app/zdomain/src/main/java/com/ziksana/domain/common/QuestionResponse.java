package com.ziksana.domain.common;

public class QuestionResponse {
	
	private Question question;
	private Choice choice;
	
	

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}



	/**
	 * @param choice the choice to set
	 */
	public void setChoice(Choice choice) {
		this.choice = choice;
	}



	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}



	/**
	 * @return the choice
	 */
	public Choice getChoice() {
		return choice;
	}
	
	
	
	
	
	
	
	
	
	
	

}
