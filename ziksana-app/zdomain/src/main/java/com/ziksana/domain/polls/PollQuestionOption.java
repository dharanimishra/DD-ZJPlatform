package com.ziksana.domain.polls;



public class PollQuestionOption {

	private Integer index        = -1;     // Index within the list of options
	private String  optionText   = null;
	private boolean optionSet    = false;  // captures the user's response
	private Integer optionTotal  = -1;     // captures the totals / result
	
	public PollQuestionOption() {
	
	}
	
	public PollQuestionOption(int idx) {
		index = idx;
	}

	public PollQuestionOption(String text) {
		optionText = text;
	}

	public PollQuestionOption(int idx, String text) {
		index      = idx;
		optionText = text;
	}

	public int getIndex() {
		if (index < 0) {
			throw new IllegalStateException("Index not set.");
		}
		
		return index;
	}
	
	public void setIndex(int idx) {
		index = idx;
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
	
	public boolean isSet() {
		return optionSet;
	}
	
	public void setOption() {
		optionSet = true;
	}
	
	public void unsetOption() {
		optionSet = false;
	}
	

	public Integer getOptionTotal() {
		
		
		return optionTotal;
	}
	
	public void setOptionTotal(Integer value) {
		optionTotal = value;
	}
	
	public String toString() {
		return "PollQuestionOption [" + getText() + "]";
	}
}
