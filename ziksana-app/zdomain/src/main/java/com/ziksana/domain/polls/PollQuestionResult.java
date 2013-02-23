package com.ziksana.domain.polls;



public class PollQuestionResult {

	private Integer      ID       = null;
    private PollQuestion question = null;
    
    Integer answer1Count;
    Integer answer2Count;
    Integer answer3Count;
    Integer answer4Count;
    Integer answer5Count;
    
    private String percentage1;
    
    private String percentage2;
    
    private String percentage3;
    
    private String percentage4;
    
    private String percentage5;
    
   
	
    
    
    
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

	public String getPercentage1() {
		return percentage1;
	}

	public void setPercentage1(String percentage1) {
		this.percentage1 = percentage1;
	}

	public String getPercentage2() {
		return percentage2;
	}

	public void setPercentage2(String percentage2) {
		this.percentage2 = percentage2;
	}

	public String getPercentage3() {
		return percentage3;
	}

	public void setPercentage3(String percentage3) {
		this.percentage3 = percentage3;
	}

	public String getPercentage4() {
		return percentage4;
	}

	public void setPercentage4(String percentage4) {
		this.percentage4 = percentage4;
	}

	public String getPercentage5() {
		return percentage5;
	}

	public void setPercentage5(String percentage5) {
		this.percentage5 = percentage5;
	}

	
    
}