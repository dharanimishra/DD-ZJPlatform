/**
 * 
 */
package com.ziksana.domain.polls;

import java.util.List;

/**
 * @author prabu
 * 
 */
public class PollResponse {

	private PollQuestion pollQuestion;

	private List<Integer> answers;

	/**
	 * @param pollQuestion
	 * @param answers
	 */
	public PollResponse(PollQuestion pollQuestion, List<Integer> answers) {

		this.pollQuestion = pollQuestion;
		this.answers = answers;
	}

	/**
	 * @return the pollQuestion
	 */
	public PollQuestion getPollQuestion() {
		return pollQuestion;
	}

	/**
	 * @return the answers
	 */
	public List<Integer> getAnswers() {
		return answers;
	}

	public Integer getPollQuestionId() {
		return pollQuestion.getID();
	}

}
