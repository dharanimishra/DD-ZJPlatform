package com.ziksana.domain.assessment;

import java.util.Date;

public class QuestionVisual {

	/**
	 * This field corresponds to the database column
	 * asmquestionvisual.QuestionVisualId
	 */
	private Integer questionVisualId;
	/**
	 * This field corresponds to the database column
	 * asmquestionvisual.CreationDate
	 */
	private Date creationDate;
	/**
	 * This field corresponds to the database column asmquestionvisual.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * asmquestionvisual.VisualType
	 */
	private Integer visualType;
	/**
	 * This field corresponds to the database column
	 * asmquestionvisual.VisualPath
	 */
	private String visualPath;
	/**
	 * This field corresponds to the database column
	 * asmquestionvisual.InternalIndicator
	 */
	private Boolean internalIndicator;
	/**
	 * This field corresponds to the database column
	 * asmquestionvisual.VisualSource
	 */
	private Integer visualSource;
	/**
	 * This field corresponds to the database column
	 * asmquestionvisual.QuestionBankId
	 */
	private Integer questionBankId;

	/**
	 * This method returns the value of the database column
	 * asmquestionvisual.QuestionVisualId
	 * 
	 * @return the value of asmquestionvisual.QuestionVisualId
	 */
	public Integer getQuestionVisualId() {
		return questionVisualId;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionvisual.QuestionVisualId
	 * 
	 * @param questionVisualId
	 *            the value for asmquestionvisual.QuestionVisualId
	 */
	public void setQuestionVisualId(Integer questionVisualId) {
		this.questionVisualId = questionVisualId;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionvisual.CreationDate
	 * 
	 * @return the value of asmquestionvisual.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionvisual.CreationDate
	 * 
	 * @param creationDate
	 *            the value for asmquestionvisual.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionvisual.Active
	 * 
	 * @return the value of asmquestionvisual.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionvisual.Active
	 * 
	 * @param active
	 *            the value for asmquestionvisual.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionvisual.VisualType
	 * 
	 * @return the value of asmquestionvisual.VisualType
	 */
	public Integer getVisualType() {
		return visualType;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionvisual.VisualType
	 * 
	 * @param visualType
	 *            the value for asmquestionvisual.VisualType
	 */
	public void setVisualType(Integer visualType) {
		this.visualType = visualType;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionvisual.VisualPath
	 * 
	 * @return the value of asmquestionvisual.VisualPath
	 */
	public String getVisualPath() {
		return visualPath;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionvisual.VisualPath
	 * 
	 * @param visualPath
	 *            the value for asmquestionvisual.VisualPath
	 */
	public void setVisualPath(String visualPath) {
		this.visualPath = visualPath == null ? null : visualPath.trim();
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionvisual.InternalIndicator
	 * 
	 * @return the value of asmquestionvisual.InternalIndicator
	 */
	public Boolean getInternalIndicator() {
		return internalIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionvisual.InternalIndicator
	 * 
	 * @param internalIndicator
	 *            the value for asmquestionvisual.InternalIndicator
	 */
	public void setInternalIndicator(Boolean internalIndicator) {
		this.internalIndicator = internalIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionvisual.VisualSource
	 * 
	 * @return the value of asmquestionvisual.VisualSource
	 */
	public Integer getVisualSource() {
		return visualSource;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionvisual.VisualSource
	 * 
	 * @param visualSource
	 *            the value for asmquestionvisual.VisualSource
	 */
	public void setVisualSource(Integer visualSource) {
		this.visualSource = visualSource;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionvisual.QuestionBankId
	 * 
	 * @return the value of asmquestionvisual.QuestionBankId
	 */
	public Integer getQuestionBankId() {
		return questionBankId;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionvisual.QuestionBankId
	 * 
	 * @param questionBankId
	 *            the value for asmquestionvisual.QuestionBankId
	 */
	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}
}