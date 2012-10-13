package com.ziksana.domain.course;

import java.sql.Timestamp;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

public class ContentEnrichment extends AuditHistory {

	public ContentEnrichment(LinkType linkType,
			String linkElement, String linkItemAuthor, LinkSource linkSource,
			Boolean active) {
		this.linkType = linkType;
		this.linkElement = linkElement;
		this.linkItemAuthor = linkItemAuthor;
		this.linkSource = linkSource;
		this.active = active;
	}

	private ZID 						enrichmentId;
	private Timestamp 					startTime 					= null;
	private Timestamp					endTime 					= null;
	private LinkType 					linkType 					= null;
	private String 						linkElement 				= null;
	private Boolean 					internalIndicator 			= null;
	private String 						linkDescription 			= null;
	private String 						linkItemAuthor 				= null;
	private Integer 					linkItemCost 				= null;
	private LinkSource 					linkSource 					= null;
	private Boolean 					zeniSuggestedIndicator 		= null;
	private Boolean 					active 						= null;
	private ApplyEnrichment 			applyEnrichment 			= null;

	/**
	 * @return the enrichmentId
	 */
	public ZID getEnrichmentId() {
		return enrichmentId;
	}

	/**
	 * @param enrichmentId
	 *            the enrichmentId to set
	 */
	public void setEnrichmentId(ZID enrichmentId) {
		this.enrichmentId = enrichmentId;
	}

	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
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
	 * @return the applyEnrichment
	 */
	public ApplyEnrichment getApplyEnrichment() {
		return applyEnrichment;
	}

	/**
	 * @param applyEnrichment the applyEnrichment to set
	 */
	public void setApplyEnrichment(ApplyEnrichment applyEnrichment) {
		this.applyEnrichment = applyEnrichment;
	}


}