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
	
	/**
	 * This is a convenience method , required by mybatis mapper. 
	 * @return
	 */
	public Integer getPollQuestionId()
	{
		if (pollQuestion == null)
			throw new NullPointerException(" Poll Question object is null");
		
		return pollQuestion.getID();
	}
	

}
