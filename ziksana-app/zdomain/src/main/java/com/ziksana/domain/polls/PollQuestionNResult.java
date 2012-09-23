/**
 * 
 */
package com.ziksana.domain.polls;

/**
 * @author prabu
 *
 */
public class PollQuestionNResult {
	    
	    private PollQuestion pollQuestion;
	    private PollResult pollResult;
	    
		
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
		 * @return the pollResult
		 */
		public PollResult getPollResult() {
			return pollResult;
		}
		
		/**
		 * @param pollResult the pollResult to set
		 */
		public void setPollResult(PollResult pollResult) {
			this.pollResult = pollResult;
		}
		
		/**
		 * This is a convenience method to determine the object is question or result. 
		 * @return true if this object is pollquestion. It returns false 
		 * if the object is pollresult.
		 */
		public boolean isThisQuestion()
		{
			if (null != pollQuestion)
			{
				return true;
			}
			else if (null != pollResult)
			{
				return false;
			}
			else
			{
				return false;
			}
			
			
		}
		
		
	
}
