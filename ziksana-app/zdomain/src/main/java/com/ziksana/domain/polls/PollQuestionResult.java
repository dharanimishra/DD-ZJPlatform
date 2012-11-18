package com.ziksana.domain.polls;



public class PollQuestionResult {

	private Integer      ID       = null;
    private PollQuestion question = null;
    
    
    public PollQuestionResult() {
    	
    }

    public PollQuestionResult(Integer id, PollQuestion qs) {
    	setID(id);
    	setQuestion(qs);
    }
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public PollQuestion getQuestion() {
    	return question;
    }
    
    public void setQuestion(PollQuestion question) {
    	this.question = question;
    }
    
    public boolean isValid() {
    	if (question != null) {
    		question.updateTotals();
    	} else {
    		throw new IllegalStateException("Question not set in the result");
    	}
    	
    	return false;
    }
    
    public Integer getOptionCount(int index) {
    	isValid();
        
    	//Need to revisit
    	return null;
    	//return question.getOption(index).getOptionTotal();
    }

    public void setOptionCount(int index, Integer count) {
        if (question == null) {
        	throw new IllegalStateException("Question not set in the result");
        }
        
        //question.getOption(index).setOptionTotal(count);
        isValid();
    }
    
    public Long getTotalRespondents() {
    	isValid();
        return question.getTotalRespondents();
    }
    
    
    public void setTotalRespondents(Integer totalRespondents) {
    	System.out.println(" Total respondents "+totalRespondents);
    	long temp = Long.parseLong(Integer.toString(totalRespondents.intValue()));
    	System.out.println(" TEMP value is "+temp);
    	if (question != null)
    	question.setTotalRespondents(totalRespondents.longValue());
    }
    
    
    
}