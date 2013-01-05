package com.ziksana.domain.polls;

import java.util.Date;

public class PollResult {
	
	private Integer questionId;
	private String question;
	private Integer answer1;
	private Integer answer2;
	private Integer answer3;
	private Integer answer4;
	private Integer answer5;
	
	private Date pollQuestionDate;
	
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Integer getAnswer1() {
		return answer1;
	}
	public void setAnswer1(Integer answer1) {
		this.answer1 = answer1;
	}
	public Integer getAnswer2() {
		return answer2;
	}
	public void setAnswer2(Integer answer2) {
		this.answer2 = answer2;
	}
	public Integer getAnswer3() {
		return answer3;
	}
	public void setAnswer3(Integer answer3) {
		this.answer3 = answer3;
	}
	public Integer getAnswer4() {
		return answer4;
	}
	public void setAnswer4(Integer answer4) {
		this.answer4 = answer4;
	}
	public Integer getAnswer5() {
		return answer5;
	}
	public void setAnswer5(Integer answer5) {
		this.answer5 = answer5;
	}
	/**
	 * @return the pollQuestionDate
	 */
	public Date getPollQuestionDate() {
		return pollQuestionDate;
	}
	/**
	 * @param pollQuestionDate the pollQuestionDate to set
	 */
	public void setPollQuestionDate(Date pollQuestionDate) {
		this.pollQuestionDate = pollQuestionDate;
	}
	
	
	

}
