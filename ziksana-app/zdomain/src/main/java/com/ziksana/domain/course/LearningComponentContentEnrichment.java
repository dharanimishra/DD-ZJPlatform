package com.ziksana.domain.course;

import java.util.Date;

public class LearningComponentContentEnrichment {

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.enrichmentId
	 */
	private Integer enrichmentId;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.StartTime
	 */
	private Date startTime;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.EndTime
	 */
	private Date endTime;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.LinkType
	 */
	private Integer linkType;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.LinkElement
	 */
	private String linkElement;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.InternalIndicator
	 */
	private Boolean internalIndicator;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.LinkDescription
	 */
	private String linkDescription;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.LinkItemAuthor
	 */
	private String linkItemAuthor;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.LinkItemCost
	 */
	private Integer linkItemCost;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.LinkSource
	 */
	private Integer linkSource;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.ZeniSuggestedIndicator
	 */
	private Boolean zeniSuggestedIndicator;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontentenrichment.learningComponentContentId
	 */
	private Integer learningComponentContentId;

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.enrichmentId
	 * @return the value of corlearningcomponentcontentenrichment.enrichmentId
	 */
	public Integer getEnrichmentId() {
		return enrichmentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.enrichmentId
	 * @param enrichmentId
	 *            the value for corlearningcomponentcontentenrichment.enrichmentId
	 */
	public void setEnrichmentId(Integer enrichmentId) {
		this.enrichmentId = enrichmentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.StartTime
	 * @return the value of corlearningcomponentcontentenrichment.StartTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.StartTime
	 * @param startTime
	 *            the value for corlearningcomponentcontentenrichment.StartTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.EndTime
	 * @return the value of corlearningcomponentcontentenrichment.EndTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.EndTime
	 * @param endTime
	 *            the value for corlearningcomponentcontentenrichment.EndTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.LinkType
	 * 
	 * @return the value of corlearningcomponentcontentenrichment.LinkType
	 */
	public Integer getLinkType() {
		return linkType;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.LinkType
	 * @param linkType
	 *            the value for corlearningcomponentcontentenrichment.LinkType
	 */
	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.LinkElement
	 * @return the value of corlearningcomponentcontentenrichment.LinkElement
	 */
	public String getLinkElement() {
		return linkElement;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.LinkElement
	 * @param linkElement
	 *            the value for corlearningcomponentcontentenrichment.LinkElement
	 */
	public void setLinkElement(String linkElement) {
		this.linkElement = linkElement == null ? null : linkElement.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.InternalIndicator
	 * @return the value of corlearningcomponentcontentenrichment.InternalIndicator
	 */
	public Boolean getInternalIndicator() {
		return internalIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.InternalIndicator
	 * @param internalIndicator
	 *            the value for corlearningcomponentcontentenrichment.InternalIndicator
	 */
	public void setInternalIndicator(Boolean internalIndicator) {
		this.internalIndicator = internalIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.LinkDescription
	 * @return the value of corlearningcomponentcontentenrichment.LinkDescription
	 */
	public String getLinkDescription() {
		return linkDescription;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.LinkDescription
	 * @param linkDescription
	 *            the value for corlearningcomponentcontentenrichment.LinkDescription
	 */
	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription == null ? null : linkDescription
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.LinkItemAuthor
	 * @return the value of corlearningcomponentcontentenrichment.LinkItemAuthor
	 */
	public String getLinkItemAuthor() {
		return linkItemAuthor;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.LinkItemAuthor
	 * @param linkItemAuthor
	 *            the value for corlearningcomponentcontentenrichment.LinkItemAuthor
	 */
	public void setLinkItemAuthor(String linkItemAuthor) {
		this.linkItemAuthor = linkItemAuthor == null ? null : linkItemAuthor
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.LinkItemCost
	 * @return the value of corlearningcomponentcontentenrichment.LinkItemCost
	 */
	public Integer getLinkItemCost() {
		return linkItemCost;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.LinkItemCost
	 * @param linkItemCost
	 *            the value for corlearningcomponentcontentenrichment.LinkItemCost
	 */
	public void setLinkItemCost(Integer linkItemCost) {
		this.linkItemCost = linkItemCost;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.LinkSource
	 * @return the value of corlearningcomponentcontentenrichment.LinkSource
	 */
	public Integer getLinkSource() {
		return linkSource;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.LinkSource
	 * @param linkSource
	 *            the value for corlearningcomponentcontentenrichment.LinkSource
	 */
	public void setLinkSource(Integer linkSource) {
		this.linkSource = linkSource;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.ZeniSuggestedIndicator
	 * @return the value of corlearningcomponentcontentenrichment.ZeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.ZeniSuggestedIndicator
	 * @param zeniSuggestedIndicator
	 *            the value for
	 *            corlearningcomponentcontentenrichment.ZeniSuggestedIndicator
	 */
	public void setZeniSuggestedIndicator(Boolean zeniSuggestedIndicator) {
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontentenrichment.Active
	 * @return the value of corlearningcomponentcontentenrichment.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontentenrichment.Active
	 * @param active
	 *            the value for corlearningcomponentcontentenrichment.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the learningComponentContentId
	 */
	public Integer getLearningComponentContentId() {
		return learningComponentContentId;
	}

	/**
	 * @param learningComponentContentId the learningComponentContentId to set
	 */
	public void setLearningComponentContentId(Integer learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}
}