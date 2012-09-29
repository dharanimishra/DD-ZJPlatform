package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class LearningComponentContentEnrichment extends AuditHistory {

	private Integer enrichmentId;
	private Date startTime;
	private Date endTime;
	private LinkType linkType;
	private String linkElement;
	private Boolean internalIndicator;
	private String linkDescription;
	private String linkItemAuthor;
	private Integer linkItemCost;
	private LinkSource linkSource;
	private Boolean zeniSuggestedIndicator;
	private Boolean active;
	private LearningComponentContent learningComponentContent;

	/**
	 * @return the enrichmentId
	 */
	public Integer getEnrichmentId() {
		return enrichmentId;
	}

	/**
	 * @param enrichmentId
	 *            the enrichmentId to set
	 */
	public void setEnrichmentId(Integer enrichmentId) {
		this.enrichmentId = enrichmentId;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the linkType
	 */
	public LinkType getLinkType() {
		return linkType;
	}

	/**
	 * @param linkType
	 *            the linkType to set
	 */
	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}

	/**
	 * @return the linkElement
	 */
	public String getLinkElement() {
		return linkElement;
	}

	/**
	 * @param linkElement
	 *            the linkElement to set
	 */
	public void setLinkElement(String linkElement) {
		this.linkElement = linkElement;
	}

	/**
	 * @return the internalIndicator
	 */
	public Boolean getInternalIndicator() {
		return internalIndicator;
	}

	/**
	 * @param internalIndicator
	 *            the internalIndicator to set
	 */
	public void setInternalIndicator(Boolean internalIndicator) {
		this.internalIndicator = internalIndicator;
	}

	/**
	 * @return the linkDescription
	 */
	public String getLinkDescription() {
		return linkDescription;
	}

	/**
	 * @param linkDescription
	 *            the linkDescription to set
	 */
	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}

	/**
	 * @return the linkItemAuthor
	 */
	public String getLinkItemAuthor() {
		return linkItemAuthor;
	}

	/**
	 * @param linkItemAuthor
	 *            the linkItemAuthor to set
	 */
	public void setLinkItemAuthor(String linkItemAuthor) {
		this.linkItemAuthor = linkItemAuthor;
	}

	/**
	 * @return the linkItemCost
	 */
	public Integer getLinkItemCost() {
		return linkItemCost;
	}

	/**
	 * @param linkItemCost
	 *            the linkItemCost to set
	 */
	public void setLinkItemCost(Integer linkItemCost) {
		this.linkItemCost = linkItemCost;
	}

	/**
	 * @return the linkSource
	 */
	public LinkSource getLinkSource() {
		return linkSource;
	}

	/**
	 * @param linkSource
	 *            the linkSource to set
	 */
	public void setLinkSource(LinkSource linkSource) {
		this.linkSource = linkSource;
	}

	/**
	 * @return the zeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}

	/**
	 * @param zeniSuggestedIndicator
	 *            the zeniSuggestedIndicator to set
	 */
	public void setZeniSuggestedIndicator(Boolean zeniSuggestedIndicator) {
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the learningComponentContent
	 */
	public LearningComponentContent getLearningComponentContent() {
		return learningComponentContent;
	}

	/**
	 * @param learningComponentContent
	 *            the learningComponentContent to set
	 */
	public void setLearningComponentContent(
			LearningComponentContent learningComponentContent) {
		this.learningComponentContent = learningComponentContent;
	}

}