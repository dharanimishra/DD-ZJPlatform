package com.ziksana.domain.polls;



public class PollQuestionOption {

	private String optionText = null;
	
	public PollQuestionOption() {
		
	}
	
	public PollQuestionOption(String text) {
		optionText = text;
	}
	
	public String getText() {
		return optionText;
	}
	
	public String getHTML() {
		return optionText;
	}
	
	public void setText(String text) {
		this.optionText = text;
	}
	
	public String toString() {
		return "PollQuestionOption [" + getText() + "]";
	}
}
