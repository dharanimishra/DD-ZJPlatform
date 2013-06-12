/**
 * 
 */
package com.ziksana.domain.common;

import java.io.Serializable;

/**
 * @author prabu
 *
 */
public class Answer implements Serializable {


    private static final long serialVersionUID = 1902353241839580008L;
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
