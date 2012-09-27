package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ziksana.common.exception.CourseException;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utilz.SubjectClassification;

public class LearningContent extends AuditHistory{

	public LearningContent() {
	}
	
	public LearningContent(ContentType contentType) {
		this.contentType = contentType;
	}

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
	private ContentType contentType;

	/**
	 * This field corresponds to the property ContentPath<br>
	 * Maximum Length:45
	 */
	private String contentPath;

	/**
	 * This field corresponds to the property ContentFormat

	 */
	private ContentFormat contentFormat;

	/**
	 * This field corresponds to the property Status
	 */
	private ContentStatus status;
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

	/**
	 * This field corresponds to the property Version
	 */
	private MemberPersona rightsOwningMember;

	/**
	 * This field corresponds to the property Version
	 */
	private MemberPersona authoringMember;

	/**
	 * This field corresponds to the property Version
	 */
	private SubjectClassification subjClassification;

	/**
	 * This field corresponds to the property LinkedLearningContentId
	 */
	private LearningContent 			linkedLearningContent 	= null;

	private List<LearningContentParts> 	learningContentParts 	= null;
	
	private LearningComponentContent 	baseComponentContent 	= null;

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
	 * @return the status
	 */
	public ContentStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ContentStatus status) {
		this.status = status;
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
	 * @return the learningContentParts
	 */
	public List<LearningContentParts> getLearningContentParts() {
		return learningContentParts;
	}

	/**
	 * @param learningContentParts
	 *            the learningContentParts to set
	 */
	public void addLearningContentParts(
			List<LearningContentParts> learningContentParts) throws CourseException {
		
		learningContentParts = new ArrayList<LearningContentParts>();
		
		this.learningContentParts = learningContentParts;
	}

	/**
	 * @return the baseComponentContent
	 */
	public LearningComponentContent getBaseComponentContent() {
		return baseComponentContent;
	}

	/**
	 * @param baseComponentContent
	 *            the baseComponentContent to set
	 */
	public void setBaseComponentContent(
			LearningComponentContent baseComponentContent) {
		this.baseComponentContent = baseComponentContent;
	}

	/**
	 * @return the contentType
	 */
	public ContentType getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the rightsOwningMember
	 */
	public MemberPersona getRightsOwningMember() {
		return rightsOwningMember;
	}

	/**
	 * @param rightsOwningMember the rightsOwningMember to set
	 */
	public void setRightsOwningMember(MemberPersona rightsOwningMember) {
		this.rightsOwningMember = rightsOwningMember;
	}

	/**
	 * @return the authoringMember
	 */
	public MemberPersona getAuthoringMember() {
		return authoringMember;
	}

	/**
	 * @param authoringMember the authoringMember to set
	 */
	public void setAuthoringMember(MemberPersona authoringMember) {
		this.authoringMember = authoringMember;
	}

	/**
	 * @return the subjClassification
	 */
	public SubjectClassification getSubjClassification() {
		return subjClassification;
	}

	/**
	 * @param subjClassification the subjClassification to set
	 */
	public void setSubjClassification(SubjectClassification subjClassification) {
		this.subjClassification = subjClassification;
	}

	/**
	 * @return the linkedLearningContent
	 */
	public LearningContent getLinkedLearningContent() {
		return linkedLearningContent;
	}

	/**
	 * @param linkedLearningContent the linkedLearningContent to set
	 */
	public void setLinkedLearningContent(LearningContent linkedLearningContent) {
		this.linkedLearningContent = linkedLearningContent;
	}

	@Override
	public String toString() {
		return "LearningContent [contentType=" + contentType
				+ ", contentFormat=" + contentFormat + "]";
	}
}