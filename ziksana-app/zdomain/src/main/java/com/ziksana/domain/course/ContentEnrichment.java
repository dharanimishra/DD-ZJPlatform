package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class ContentEnrichment extends AuditHistory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @return the contentEnrichmentId
	 */
	public ZID getContentEnrichmentId() {
		return contentEnrichmentId;
	}

	/**
	 * @param contentEnrichmentId the contentEnrichmentId to set
	 */
	public void setContentEnrichmentId(Integer contentEnrichmentId) {
		this.contentEnrichmentId = new IntegerZID(contentEnrichmentId);
	}


	public ContentEnrichment() {
		
	}

	private ZID 						contentEnrichmentId;
	private Integer 					id;
	private Double 					startTime 					= null;
	private Double					endTime 					= null;
	private LinkType 					linkType 					= null;
	private EnrichmentType 				enrichmentType 				= null;
	private String 						linkElement 				= null;
	private Boolean 					internalIndicator 			= null;
	private String 						linkName 					= null;
	private String 						linkDescription 			= null;
	private String 						linkItemAuthor 				= null;
	private Double	 					linkItemCost 				= null;
	private LinkSource 					linkSource 					= null;
	private Double 					duration	 				= null;
	private Boolean 					zeniSuggestedIndicator 		= null;
	private Boolean 					active 						= null;
	private Boolean						isDelete					= null;
	private String 						coordinates					= null;					
	private LearningContent parentContent;

	/**
	* @return the startTime
	*/
	public Double getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Double startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Double getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Double endTime) {
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
	public Double getLinkItemCost() {
		return linkItemCost;
	}

	/**
	 * @param linkItemCost
	 *            the linkItemCost to set
	 */
	public void setLinkItemCost(Double linkItemCost) {
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
	 * @param linkTypeId the linkType to set
	 */
	public void setLinkType(Integer linkTypeId) {
		linkType = LinkType.getLinkType(linkTypeId);
	}


	/**
	 * @param linkSourceId the linkSource to set
	 */
	public void setLinkSource(Integer linkSourceId) {
		linkSource = LinkSource.getLinkSource(linkSourceId);
	}

	/**
	 * @return the isDelete
	 */
	public Boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * @return the enrichmentType
	 */
	public EnrichmentType getEnrichmentType() {
		return enrichmentType;
	}

	/**
	 * @param enrichmentType the enrichmentType to set
	 */
	public void setEnrichmentType(EnrichmentType enrichmentType) {
		this.enrichmentType = enrichmentType;
	}

	/**
	 * @return the linkName
	 */
	public String getLinkName() {
		return linkName;
	}

	/**
	 * @param linkName the linkName to set
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
		setContentEnrichmentId(new IntegerZID(id));
	}

	/**
	 * @param contentEnrichmentId the contentEnrichmentId to set
	 */
	private void setContentEnrichmentId(ZID contentEnrichmentId) {
		this.contentEnrichmentId = contentEnrichmentId;
	}

	/**
	 * @return the duration
	 */
	public Double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Double duration) {
		this.duration = duration;
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
	 * @return the parentContent
	 */
	public LearningContent getParentContent() {
		return parentContent;
	}

	/**
	 * @param parentContent the parentContent to set
	 */
	public void setParentContent(LearningContent parentContent) {
		this.parentContent = parentContent;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @param enrichmentTypeId the enrichmentType to set
	 */
	public void setEnrichmentType(Integer enrichmentTypeId) {
		enrichmentType = EnrichmentType.getEnrichmentType(enrichmentTypeId);
	}

}