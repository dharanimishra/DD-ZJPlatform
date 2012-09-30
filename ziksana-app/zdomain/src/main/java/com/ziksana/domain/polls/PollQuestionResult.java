package com.ziksana.domain.polls;

import com.ziksana.common.exception.PollException;

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
    
    public boolean isValid() 
    throws PollException {
    	if (question != null) {
    		question.updateTotals();
    	} else {
    		throw new PollException("Question not set in the result");
    	}
    	
    	return false;
    }
    
    public Integer getOptionCount(int index) 
    throws PollException {
    	isValid();
        return question.getOption(index).getOptionTotal();
    }

    public void setOptionCount(int index, Integer count) 
    throws PollException {
        if (question == null) {
        	throw new PollException("Question not set in the result");
        }
        
        question.getOption(index).setOptionTotal(count);
        isValid();
    }
    
    public Long getTotalRespondents() 
    throws PollException {
    	isValid();
        return question.getTotalRespondents();
    }
}