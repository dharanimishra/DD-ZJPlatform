package com.ziksana.domain.assessment;

import java.util.Date;

public class VisualSpot {

	/**
	 * This field corresponds to the database column asmvisualspot.VisualSpotId
	 */
	private Integer visualSpotId;
	/**
	 * This field corresponds to the database column asmvisualspot.CreationDate
	 */
	private Date creationDate;
	/**
	 * This field corresponds to the database column asmvisualspot.VisualSize
	 */
	private String visualSize;
	/**
	 * This field corresponds to the database column
	 * asmvisualspot.SpotRelativeCoordinate
	 */
	private String spotRelativeCoordinate;
	/**
	 * This field corresponds to the database column
	 * asmvisualspot.QuestionLabelText
	 */
	private String questionLabelText;
	/**
	 * This field corresponds to the database column asmvisualspot.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * asmvisualspot.QuestionVisualId
	 */
	private Integer questionVisualId;

	/**
	 * This method returns the value of the database column
	 * asmvisualspot.VisualSpotId
	 * 
	 * @return the value of asmvisualspot.VisualSpotId
	 */
	public Integer getVisualSpotId() {
		return visualSpotId;
	}

	/**
	 * This method sets the value of the database column
	 * asmvisualspot.VisualSpotId
	 * 
	 * @param visualSpotId
	 *            the value for asmvisualspot.VisualSpotId
	 */
	public void setVisualSpotId(Integer visualSpotId) {
		this.visualSpotId = visualSpotId;
	}

	/**
	 * This method returns the value of the database column
	 * asmvisualspot.CreationDate
	 * 
	 * @return the value of asmvisualspot.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * asmvisualspot.CreationDate
	 * 
	 * @param creationDate
	 *            the value for asmvisualspot.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * asmvisualspot.VisualSize
	 * 
	 * @return the value of asmvisualspot.VisualSize
	 */
	public String getVisualSize() {
		return visualSize;
	}

	/**
	 * This method sets the value of the database column
	 * asmvisualspot.VisualSize
	 * 
	 * @param visualSize
	 *            the value for asmvisualspot.VisualSize
	 */
	public void setVisualSize(String visualSize) {
		this.visualSize = visualSize == null ? null : visualSize.trim();
	}

	/**
	 * This method returns the value of the database column
	 * asmvisualspot.SpotRelativeCoordinate
	 * 
	 * @return the value of asmvisualspot.SpotRelativeCoordinate
	 */
	public String getSpotRelativeCoordinate() {
		return spotRelativeCoordinate;
	}

	/**
	 * This method sets the value of the database column
	 * asmvisualspot.SpotRelativeCoordinate
	 * 
	 * @param spotRelativeCoordinate
	 *            the value for asmvisualspot.SpotRelativeCoordinate
	 */
	public void setSpotRelativeCoordinate(String spotRelativeCoordinate) {
		this.spotRelativeCoordinate = spotRelativeCoordinate == null ? null
				: spotRelativeCoordinate.trim();
	}

	/**
	 * This method returns the value of the database column
	 * asmvisualspot.QuestionLabelText
	 * 
	 * @return the value of asmvisualspot.QuestionLabelText
	 */
	public String getQuestionLabelText() {
		return questionLabelText;
	}

	/**
	 * This method sets the value of the database column
	 * asmvisualspot.QuestionLabelText
	 * 
	 * @param questionLabelText
	 *            the value for asmvisualspot.QuestionLabelText
	 */
	public void setQuestionLabelText(String questionLabelText) {
		this.questionLabelText = questionLabelText == null ? null
				: questionLabelText.trim();
	}

	/**
	 * This method returns the value of the database column asmvisualspot.Active
	 * 
	 * @return the value of asmvisualspot.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column asmvisualspot.Active
	 * 
	 * @param active
	 *            the value for asmvisualspot.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * asmvisualspot.QuestionVisualId
	 * 
	 * @return the value of asmvisualspot.QuestionVisualId
	 */
	public Integer getQuestionVisualId() {
		return questionVisualId;
	}

	/**
	 * This method sets the value of the database column
	 * asmvisualspot.QuestionVisualId
	 * 
	 * @param questionVisualId
	 *            the value for asmvisualspot.QuestionVisualId
	 */
	public void setQuestionVisualId(Integer questionVisualId) {
		this.questionVisualId = questionVisualId;
	}
}