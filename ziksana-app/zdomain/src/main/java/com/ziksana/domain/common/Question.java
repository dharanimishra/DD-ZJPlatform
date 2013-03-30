/**
 * 
 */
package com.ziksana.domain.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ziksana.id.ZID;

/**
 * @author prabu
 * 
 */
public class Question {

	private ZID id;
	private Integer questionId;

	private String text;
	private String responseDate;

	private Set<Choice> choices;

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ZID id) {
		this.id = id;
	}

	/**
	 * @param choices
	 *            the choices to set
	 */
	public void setChoices(Set<Choice> choices) {
		this.choices = choices;
	}

	/**
	 * @return the responseDate
	 */
	public String getResponseDate() {
		return responseDate;
	}

	/**
	 * @param responseDate
	 *            the responseDate to set
	 */
	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

	public Question(Integer questionId, String text) {
		super();
		this.questionId = questionId;
		this.text = text;
		this.choices = new HashSet<Choice>();
	}

	public Question(Integer questionId, String text, String responseDate) {

		super();
		this.questionId = questionId;
		this.text = text;
		this.responseDate = responseDate;
		this.choices = new HashSet<Choice>();
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @param choices
	 *            the choices to set
	 */
	public void setChoices(List<Choice> choices) {
		this.choices.addAll(choices);
	}

	/**
	 * @return the id
	 */
	public ZID getId() {
		return id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the choices
	 */
	public Set<Choice> getChoices() {
		return choices;
	}

	/**
	 * @return the questionId
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId
	 *            the questionId to set
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

}
