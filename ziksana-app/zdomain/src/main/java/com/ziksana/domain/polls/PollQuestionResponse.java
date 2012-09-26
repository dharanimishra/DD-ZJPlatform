/**
 * 
 */
package com.ziksana.domain.polls;

import java.util.List;

/**
 * @author prabu
 *
 */
public class PollQuestionResponse {
	
	private PollQuestion pollQuestion;

	private List<Integer> answers;


	/**
	 * @return the pollQuestion
	 */
	public PollQuestion getPollQuestion() {
		return pollQuestion;
	}

	/**
	 * @param pollQuestion the pollQuestion to set
	 */
	public void setPollQuestion(PollQuestion pollQuestion) {
		this.pollQuestion = pollQuestion;
	}

	/**
	 * @return the answers
	 */
	public List<Integer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Integer> answers) {
		this.answers = answers;
	}
	
	public Integer getPollQuestionId()
	{
		return pollQuestion.getID();
	}
	

}
