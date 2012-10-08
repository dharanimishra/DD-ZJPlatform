package com.ziksana.domain.assessment;

import com.ziksana.common.id.ZID;
import com.ziksana.domain.common.AuditHistory;

/**
 * @author bhashasp
 */
public class VisualSpot extends AuditHistory{


	public VisualSpot(String size, String coordinates,
			String questionLabelText, QuestionVisual questionVisual) {
		this.size = size;
		this.coordinates = coordinates;
		this.questionLabelText = questionLabelText;
		this.questionVisual = questionVisual;
	}


	private ZID 			visualSpotId;
	private String 			size 				= null;
	private String 			coordinates	= null;
	private String 			questionLabelText 	= null;
	private Boolean 		active 				= null;
	private QuestionVisual 	questionVisual 		= null;
	
	
	/**
	 * @return the visualSpotId
	 */
	public ZID getVisualSpotId() {
		return visualSpotId;
	}
	/**
	 * @param visualSpotId the visualSpotId to set
	 */
	public void setVisualSpotId(ZID visualSpotId) {
		this.visualSpotId = visualSpotId;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the coordinates
	 */
	public String getCoordinates() {
		return coordinates;
	}
	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	/**
	 * @return the questionLabelText
	 */
	public String getQuestionLabelText() {
		return questionLabelText;
	}
	/**
	 * @param questionLabelText the questionLabelText to set
	 */
	public void setQuestionLabelText(String questionLabelText) {
		this.questionLabelText = questionLabelText;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the questionVisual
	 */
	public QuestionVisual getQuestionVisual() {
		return questionVisual;
	}
	/**
	 * @param questionVisual the questionVisual to set
	 */
	public void setQuestionVisual(QuestionVisual questionVisual) {
		this.questionVisual = questionVisual;
	}

	@Override
	public String toString() {
		return "VisualSpot [size=" + size + ", coordinates="
				+ coordinates + ", questionLabelText="
				+ questionLabelText + "]";
	}

}