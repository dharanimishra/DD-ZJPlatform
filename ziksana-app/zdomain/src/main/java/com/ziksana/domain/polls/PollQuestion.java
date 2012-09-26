package com.ziksana.domain.polls;

import java.util.ArrayList;
import java.util.List;

import com.ziksana.common.exception.PollException;
import com.ziksana.domain.member.MemberPersona;




public class PollQuestion {
	
	  
	
	private Integer                  ID            = null;
    private Poll                     parent        = null;
    private MemberPersona            creatorMember = null;
    private Boolean                  active        = null;
    private String                   questionText  = null;
    private List<PollQuestionOption> options       = null;

    public PollQuestion() {
    	
    }
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Poll getPoll() {
    	return parent;
    }
    
    public void setPoll(Poll parent) {
    	this.parent = parent;
    }
    
    public MemberPersona getCreatorMember() {
    	return creatorMember;
    }
    
    public void setCreatorMember(MemberPersona creator) {
    	this.creatorMember = creator;
    }
    
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText == null ? null : questionText.trim();
    }

    public List<PollQuestionOption> getAllOptions() {
    	return options;
    }
    
    public PollQuestionOption getOption(int index) {
        return options.get(index);
    }

    public void addOption(String option) 
    throws PollException {
    	if (option == null) {
    		throw new PollException("Null option cannot be added to a PollQuestion");
    	}
    	
    	if (options == null) {
    		options = new ArrayList<PollQuestionOption>();
    	}
    	
    	options.add(new PollQuestionOption(option.trim()));
    }
    
    public void addOption(PollQuestionOption option) 
    		throws PollException {
    	if (option == null) {
    		throw new PollException("Null option cannot be added to a PollQuestion");
    	}

    	if (options == null) {
    		options = new ArrayList<PollQuestionOption>();
    	}

    	options.add(option);
    }
    
    public void setOptions(List<PollQuestionOption> options) {
    	this.options = options;
    }
    
    public String toString() {
    	// TODO: create a string and return
    	return String.format("Question text is %s ", questionText);
    }   
    
    
}