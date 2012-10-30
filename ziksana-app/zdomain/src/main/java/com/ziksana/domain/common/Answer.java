/**
 * 
 */
package com.ziksana.domain.common;

/**
 * @author prabu
 *
 */
public class Answer {


    private final Question question;
	private final Integer answerId;
	
	
	
	public Answer(Question question, Integer answerId) {
		super();
		this.question = question;
		this.answerId = answerId;
	}



    public Question getQuestion() {
        return question;
    }

    public Integer getAnswerId() {
        return answerId;
    }







}
