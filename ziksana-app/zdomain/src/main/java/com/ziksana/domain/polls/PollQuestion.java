package com.ziksana.domain.polls;

public class PollQuestion {
	
	  
	
	private Poll poll;
	  
	  
	  
    
    private Integer ID;

    
    private Boolean active;

    
    private String questionText;

    
    private String answer1;

    
    private String answer2;

    
    private String answer3;

    
    private String answer4;

    
    private String answer5;

    
    public Integer getID() {
        return ID;
    }

    
    public void setID(Integer ID) {
        this.ID = ID;
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

    
    public String getAnswer1() {
        return answer1;
    }

    
    public void setAnswer1(String answer1) {
        this.answer1 = answer1 == null ? null : answer1.trim();
    }

    
    public String getAnswer2() {
        return answer2;
    }

    
    public void setAnswer2(String answer2) {
        this.answer2 = answer2 == null ? null : answer2.trim();
    }

        public String getAnswer3() {
        return answer3;
    }

    
    public void setAnswer3(String answer3) {
        this.answer3 = answer3 == null ? null : answer3.trim();
    }

    
    public String getAnswer4() {
        return answer4;
    }

    
    public void setAnswer4(String answer4) {
        this.answer4 = answer4 == null ? null : answer4.trim();
    }

    
    public String getAnswer5() {
        return answer5;
    }

    
    public void setAnswer5(String answer5) {
        this.answer5 = answer5 == null ? null : answer5.trim();
    }
    
    
    
   	public Poll getPoll() {
   		return poll;
   	}

   	
   	public void setPoll(Poll poll) {
   		this.poll = poll;
   	}

    
    
    
    
    
}