package com.ziksana.domain.polls;

public class PollQuestionResult {

    

	private Integer ID;
    
	
	private Integer pollQuestionId;
	
    private Integer answer1Count;

    private Integer answer2Count;

    private Integer answer3Count;

    private Integer answer4Count;

    private Integer answer5Count;

    private Integer totalRespondents;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAnswer1Count() {
        return answer1Count;
    }

    public void setAnswer1Count(Integer answer1Count) {
        this.answer1Count = answer1Count;
    }

    public Integer getAnswer2Count() {
        return answer2Count;
    }

    public void setAnswer2Count(Integer answer2Count) {
        this.answer2Count = answer2Count;
    }

    public Integer getAnswer3Count() {
        return answer3Count;
    }

    public void setAnswer3Count(Integer answer3Count) {
        this.answer3Count = answer3Count;
    }

    public Integer getAnswer4Count() {
        return answer4Count;
    }

    public void setAnswer4Count(Integer answer4Count) {
        this.answer4Count = answer4Count;
    }

    public Integer getAnswer5Count() {
        return answer5Count;
    }

    public void setAnswer5Count(Integer answer5Count) {
        this.answer5Count = answer5Count;
    }

    public Integer getTotalRespondents() {
        return totalRespondents;
    }

    public void setTotalRespondents(Integer totalRespondents) {
        this.totalRespondents = totalRespondents;
    }
    
   

	/**
	 * @return the pollQuestionId
	 */
	public Integer getPollQuestionId() {
		return pollQuestionId;
	}

	/**
	 * @param pollQuestionId the pollQuestionId to set
	 */
	public void setPollQuestionId(Integer pollQuestionId) {
		this.pollQuestionId = pollQuestionId;
	}
	
	
	 
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PollQuestionResult [questiontext=" + pollQuestionId + ", answer1Count="
				+ answer1Count + ", answer2Count=" + answer2Count
				+ ", answer3Count=" + answer3Count + ", answer4Count="
				+ answer4Count + ", answer5Count=" + answer5Count
				+ ", totalRespondents=" + totalRespondents + "]";
	}
    
    
}