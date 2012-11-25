package com.ziksana.domain.assessment;

import java.util.List;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;


/**
 * @author bhashasp
  */
public class QuestionVisual extends AuditHistory{

	
	public QuestionVisual(VisualType visualType, String visualPath,
			VisualSource visualSource, QuestionBank questionBank) {
		super();
		this.visualType = visualType;
		this.visualPath = visualPath;
		this.visualSource = visualSource;
		this.questionBank = questionBank;
	}

	private ZID		 			questionVisualId;
	private Boolean 			active 				= null;
	private VisualType 			visualType 			= null;
	private Integer	 			visualTypeId		= null;
	private String 				visualPath 			= null;
	private Boolean 			internalIndicator 	= null;
	private VisualSource 		visualSource 		= null;
	private Integer	 			visualSourceId 		= null;
	private QuestionBank 		questionBank 		= null;
	private List<VisualSpot>	visualSpotList		= null;
	
	
	/**
	 * @return the questionVisualId
	 */
	public ZID getQuestionVisualId() {
		return questionVisualId;
	}
	/**
	 * @param questionVisualId the questionVisualId to set
	 */
	public void setQuestionVisualId(ZID questionVisualId) {
		this.questionVisualId = questionVisualId;
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
	 * @return the visualType
	 */
	public VisualType getVisualType() {
		return visualType;
	}
	/**
	 * @param visualType the visualType to set
	 */
	public void setVisualType(VisualType visualType) {
		this.visualType = visualType;
	}
	/**
	 * @return the visualPath
	 */
	public String getVisualPath() {
		return visualPath;
	}
	/**
	 * @param visualPath the visualPath to set
	 */
	public void setVisualPath(String visualPath) {
		this.visualPath = visualPath;
	}
	/**
	 * @return the internalIndicator
	 */
	public Boolean getInternalIndicator() {
		return internalIndicator;
	}
	/**
	 * @param internalIndicator the internalIndicator to set
	 */
	public void setInternalIndicator(Boolean internalIndicator) {
		this.internalIndicator = internalIndicator;
	}
	/**
	 * @return the questionBank
	 */
	public QuestionBank getQuestionBank() {
		return questionBank;
	}
	/**
	 * @param questionBank the questionBank to set
	 */
	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

	/**
	 * @return the visualSource
	 */
	public VisualSource getVisualSource() {
		return visualSource;
	}
	/**
	 * @param visualSource the visualSource to set
	 */
	public void setVisualSource(VisualSource visualSource) {
		this.visualSource = visualSource;
	}
	@Override
	public String toString() {
		return "QuestionVisual [active=" + active + ", visualType="
				+ visualType + ", visualPath=" + visualPath + ", visualSource="
				+ visualSource + "]";
	}
	/**
	 * @return the visualTypeId
	 */
	public Integer getVisualTypeId() {
		return visualTypeId;
	}
	/**
	 * @param visualTypeId the visualTypeId to set
	 */
	public void setVisualTypeId(Integer visualTypeId) {
		this.visualTypeId = visualTypeId;
	}
	/**
	 * @return the visualSourceId
	 */
	public Integer getVisualSourceId() {
		return visualSourceId;
	}
	/**
	 * @param visualSourceId the visualSourceId to set
	 */
	public void setVisualSourceId(Integer visualSourceId) {
		this.visualSourceId = visualSourceId;
	}
	/**
	 * @return the visualSpotList
	 */
	public List<VisualSpot> getVisualSpotList() {
		return visualSpotList;
	}
	/**
	 * @param visualSpotList the visualSpotList to set
	 */
	public void setVisualSpotList(List<VisualSpot> visualSpotList) {
		this.visualSpotList = visualSpotList;
	}

}