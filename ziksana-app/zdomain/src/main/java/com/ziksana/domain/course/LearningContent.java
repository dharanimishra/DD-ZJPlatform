package com.ziksana.domain.course;

import java.util.Date;
import java.util.List;

public class LearningContent {

	/**
	 * This field corresponds to the property learningContentId
	 */
	private Integer learningContentId;

	/**
	 * This field corresponds to the property CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the property Active<br>
	 * Maximum Length:1
	 */
	private Boolean activeFlag;

	/**
	 * This field corresponds to the property ContentType
	 */
	private Integer contentTypeId;

	/**
	 * This attribute hold the description for attribute contentType
	 */
	private String contentTypesDesc;

	/**
	 * This field corresponds to the property ContentPath<br>
	 * Maximum Length:45
	 */
	private String contentPath;

	/**
	 * This field corresponds to the property ContentFormat
	 */
	private Integer contentFormat;

	/**
	 * This field corresponds to the property Status
	 */
	private Integer statusId;
	
	/**
	 * This field corresponds to the property Status
	 */
	private String statusDesc;

	/**
	 * This field corresponds to the property Version
	 */
	private Integer version;

	/**
	 * This field corresponds to the property contentName<br>
	 * Maximum Length:45
	 */
	private String contentName;

	/**
	 * This field corresponds to the property contentDescription<br>
	 * Maximum Length:4800
	 */
	private String contentDescription;

	/**
	 * This field corresponds to the property thumbnailPicturePath<br>
	 * Maximum Length:72
	 */
	private String thumbnailPicturePath;


	/**This field corresponds to the property createdBy { User who creates }
	 */
	private String createdBy;
	
	/**This field corresponds to the property createdOn { Creation Date)
	 */
	private Date createdOn;
	
	/**This field corresponds to the property createdBy {User who modified  }
	 */
	private String modifiedBy;
	
	/**This field corresponds to the property createdBy { modified date}
	 */
	private Date modifiedOn;
	
		/**
	 * This field corresponds to the property Version
	 */
	private Integer rightsOwningMemberPersonaId;

	/**
	 * This field corresponds to the property Version
	 */
	private Integer authoringMemberPersonaId;

	/**
	 * This field corresponds to the property Version
	 */
	private Integer subjClassificationId;

	/**
	 * This field corresponds to the property LinkedLearningContentId
	 */
	private Integer linkedLearningContentId;

	
	private List<LearningContentParts> learningContentParts;
	
	private LearningComponentContent baseComponentContent;

	/**
	 * This method returns the value of the property learningContentId
	 * 
	 * @return the value of learningContentId
	 */
	public Integer getLearningContentId() {
		return learningContentId;
	}

	/**
	 * This method sets the value of the property learningContentId
	 * 
	 * @param learningContentId
	 *            the value for learningContentId
	 */
	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = learningContentId;
	}

	/**
	 * This method returns the value of the property CreationDate
	 * 
	 * @return the value of CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the property CreationDate
	 * 
	 * @param creationDate
	 *            the value for CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the property Active
	 * 
	 * @return the value of Active
	 */
	public Boolean getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method sets the value of the property Active
	 * 
	 * @param active
	 *            the value for Active
	 */
	public void setActive(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method returns the value of the property ContentType
	 * 
	 * @return the value of ContentType
	 */
	public Integer getContentTypeId() {
		return contentTypeId;
	}

	/**
	 * This method sets the value of the property ContentType
	 * 
	 * @param contentType
	 *            the value for ContentType
	 */
	public void setContentType(Integer contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	/**
	 * This method returns the value of the property ContentPath
	 * 
	 * @return the value of ContentPath
	 */
	public String getContentPath() {
		return contentPath;
	}

	/**
	 * This method sets the value of the property ContentPath
	 * 
	 * @param contentPath
	 *            the value for ContentPath
	 */
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath == null ? null : contentPath.trim();
	}

	/**
	 * This method returns the value of the property ContentFormat
	 * 
	 * @return the value of ContentFormat
	 */
	public Integer getContentFormat() {
		return contentFormat;
	}

	/**
	 * This method sets the value of the property ContentFormat
	 * 
	 * @param contentFormat
	 *            the value for ContentFormat
	 */
	public void setContentFormat(Integer contentFormat) {
		this.contentFormat = contentFormat;
	}

	/**
	 * This method returns the value of the property Version
	 * 
	 * @return the value of Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the property Version
	 * 
	 * @param version
	 *            the value for Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/*	*//**
	 * @return the corlearningcontentParts
	 */
	/*
	 * public List<ContentParts> getcorlearningcontentParts() { return
	 * corlearningcontentParts; }
	 *//**
	 * @param corlearningcontentParts
	 *            the corlearningcontentParts to set
	 */
	/*
	 * public void setcorlearningcontentParts(List<ContentParts>
	 * corlearningcontentParts) { this.corlearningcontentParts =
	 * corlearningcontentParts; }
	 */
	/**
	 * @return the contentName
	 */
	public String getContentName() {
		return contentName;
	}

	/**
	 * @param contentName
	 *            the contentName to set
	 */
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	/**
	 * @return the contentDescription
	 */
	public String getContentDescription() {
		return contentDescription;
	}

	/**
	 * @param contentDescription
	 *            the contentDescription to set
	 */
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	/**
	 * @return the thumbnailPicturePath
	 */
	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	/**
	 * @param thumbnailPicturePath
	 *            the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}


	/**
	 * @return the subjClassificationId
	 */
	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	/**
	 * @param subjClassificationId
	 *            the subjClassificationId to set
	 */
	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	/**
	 * @return the linkedLearningContentId
	 */
	public Integer getLinkedLearningContentId() {
		return linkedLearningContentId;
	}

	/**
	 * @param linkedLearningContentId
	 *            the linkedLearningContentId to set
	 */
	public void setLinkedLearningContentId(Integer linkedLearningContentId) {
		this.linkedLearningContentId = linkedLearningContentId;
	}

	/**
	 * @return the learningContentParts
	 */
	public List<LearningContentParts> getLearningContentParts() {
		return learningContentParts;
	}

	/**
	 * @param learningContentParts
	 *            the learningContentParts to set
	 */
	public void setLearningContentParts(
			List<LearningContentParts> learningContentParts) {
		this.learningContentParts = learningContentParts;
	}

	/**
	 * @return the contentTypesDesc
	 */
	public String getContentTypesDesc() {
		return contentTypesDesc;
	}

	/**
	 * @param contentTypesDesc
	 *            the contentTypesDesc to set
	 */
	public void setContentTypesDesc(String contentTypesDesc) {
		this.contentTypesDesc = contentTypesDesc;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the rightsOwningMemberPersonaId
	 */
	public Integer getRightsOwningMemberPersona() {
		return rightsOwningMemberPersonaId;
	}

	/**
	 * @param rightsOwningMemberPersonaId the rightsOwningMemberPersonaId to set
	 */
	public void setRightsOwningMemberPersona(Integer rightsOwningMemberPersonaId) {
		this.rightsOwningMemberPersonaId = rightsOwningMemberPersonaId;
	}

	/**
	 * @return the authoringMemberPersonaId
	 */
	public Integer getAuthoringMemberPersona() {
		return authoringMemberPersonaId;
	}

	/**
	 * @param authoringMemberPersonaId the authoringMemberPersonaId to set
	 */
	public void setAuthoringMemberPersona(Integer authoringMemberPersonaId) {
		this.authoringMemberPersonaId = authoringMemberPersonaId;
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * @return the baseComponentContent
	 */
	public LearningComponentContent getBaseComponentContent() {
		return baseComponentContent;
	}

	/**
	 * @param baseComponentContent the baseComponentContent to set
	 */
	public void setBaseComponentContent(LearningComponentContent baseComponentContent) {
		this.baseComponentContent = baseComponentContent;
	}
}