package com.ziksana.domain.polls;

import com.ziksana.common.exception.PollException;

/**
 * 
 * @author 
 * 
 * Class contains either a PollQuestion or a PollQuestionResult.
 * Should never contain both at the same time.
 *
 */
public class PollResultNQuestion {
	
	private PollQuestion       question = null;
	private PollQuestionResult result   = null;

	public PollResultNQuestion() {
		
	}

	public PollResultNQuestion(PollQuestion question) {
		this.question = question;
	}
	
	public PollResultNQuestion(PollQuestionResult result) {
		this.result = result;
	}

	public PollQuestionResult getPollResult() {
		return result;
	}
	
	public PollQuestion getPollQuestion() {

		return question;
	}

	public void setPollResult(PollQuestionResult pollResult) 
	throws PollException {
		if (this.question != null) {
			throw new PollException("Cannot set PollResult as PollQuestion already set.");
		}
		
		this.result = pollResult;
	}
	
	public void setPollQuestion(PollQuestion pollQuestion) 
	throws PollException {
		if (this.result != null) {
			throw new PollException("Cannot set PollQuestion as PollResult already set.");
		}
		
		this.question = pollQuestion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PollResultNQuestion [question=" + question + ", result="
				+ result + "]";
	}

}
