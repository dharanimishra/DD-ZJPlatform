package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utils.SubjectClassification;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author Ratnesh Kumar
 */

public class LearningContent extends AuditHistory {

	public LearningContent() {
	}

	public LearningContent(ContentType contentType) {
		this.contentType = contentType;
	}

	public LearningContent(Integer contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	private ZID learningContentId;
	private Date creationDate = null;
	private Boolean activeFlag = null;
	private Boolean active = null;
	private ContentType contentType = null;
	/**
	 * Maximum Length:45
	 */
	private String contentPath = null;
	private ContentFormat contentFormat = null;
	private Integer contentFormatId = null;
	private ContentStatus status = null;
	private Integer statusId = null;
	private Integer version = null;

	private Integer numberOfThumbnails = null;

	public Integer getNumberOfThumbnails() {
		return numberOfThumbnails;
	}

	public void setNumberOfThumbnails(Integer numberOfThumbnails) {
		this.numberOfThumbnails = numberOfThumbnails;
	}

	/**
	 * Maximum Length:45
	 */
	private String contentName = null;

	public Boolean getActive() {
		return active;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * Maximum Length:4800
	 */
	private String contentDescription = null;

	/**
	 * Maximum Length:72
	 */
	private String thumbnailPicturePath = null;
	private String screenshotPath = null;

	public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {
		this.screenshotPath = screenshotPath;
	}

	private MemberPersona rightsOwningMember = null;
	private MemberPersona authoringMember = null;
	private SubjectClassification subjClassification = null;
	private LearningContent linkedLearningContent = null;
	private List<LearningContentParts> learningContentPartsList = null;
	private LearningComponentContent baseComponentContent = null;
	private Integer contentTypeId = null;
	private Boolean isDelete = null;

	/**
	 * @return the value of learningContentId
	 */
	public ZID getLearningContentId() {
		return learningContentId;
	}

	/**
	 * @param learningContentId
	 *            the value for learningContentId
	 */
	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = new IntegerZID(learningContentId);
	}

	/**
	 * @return the value of CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the value for CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the value of Active
	 */
	public Boolean getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param active
	 *            the value for Active
	 */
	public void setActive(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * @return the value of ContentPath
	 */
	public String getContentPath() {
		return contentPath;
	}

	/**
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
	 * @param status
	 *            the status to set
	 */
	public void setStatus(ContentStatus status) {
		this.status = status;
	}

	/**
	 * @return the value of Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
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
	public List<LearningContentParts> getAllLearningContentParts() {
		return learningContentPartsList;
	}

	public void addLearningContentParts(LearningContentParts parts) {

		if (learningContentPartsList == null) {
			learningContentPartsList = new ArrayList<LearningContentParts>();
		}

		parts.setLearningContent(this);
		learningContentPartsList.add(parts);

	}

	/**
	 * @param learningComponent
	 */
	public LearningContentParts getLearningContentParts(int index)
			throws Exception {

		if (learningContentPartsList == null) {
			throw new IllegalArgumentException(
					"learningContentParts is not set in the learning content ID ["
							+ learningContentId + "]");
		}
		try {
			return learningContentPartsList.get(index);
		} catch (Exception e) {
			throw new NoSuchMethodException("learning Content Parts at index ["
					+ index + "] at not found");
		}
	}

	public void setLearningContentParts(List<LearningContentParts> partsList)
			throws Exception {

		if (partsList == null) {
			throw new IllegalArgumentException(
					"Cannot set learningContentParts as null in  learning content ID ["
							+ learningContentId + "]");
		}

		learningContentPartsList = partsList;

		for (LearningContentParts learningContentParts : partsList) {
			learningContentParts.setLearningContent(this);
		}

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
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(ContentType contentType) {
		if (contentTypeId != null) {
			contentType = ContentType.getContentType(contentTypeId);
		}
		this.contentType = contentType;
	}

	/**
	 * @return the rightsOwningMember
	 */
	public MemberPersona getRightsOwningMember() {
		return rightsOwningMember;
	}

	/**
	 * @param rightsOwningMember
	 *            the rightsOwningMember to set
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
	 * @param authoringMember
	 *            the authoringMember to set
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
	 * @param subjClassification
	 *            the subjClassification to set
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
	 * @param linkedLearningContent
	 *            the linkedLearningContent to set
	 */
	public void setLinkedLearningContent(LearningContent linkedLearningContent) {
		this.linkedLearningContent = linkedLearningContent;
	}

	@Override
	public String toString() {
		return "LearningContent [activeFlag=" + activeFlag + ", contentPath="
				+ contentPath + ", contentFormat=" + contentFormat
				+ ", status=" + status + ", contentName=" + contentName
				+ ", contentDescription=" + contentDescription
				+ ", thumbnailPicturePath=" + thumbnailPicturePath
				+ ", subjClassification=" + subjClassification
				+ ", learningContentPartsList=" + learningContentPartsList
				+ ", baseComponentContent=" + baseComponentContent + "]";
	}

	/**
	 * @return the contentTypeId
	 */
	public Integer getContentTypeId() {
		return contentTypeId;
	}

	/**
	 * @param contentTypeId
	 *            the contentTypeId to set
	 */
	public void setContentTypeId(Integer contentTypeId) {
		this.contentTypeId = contentTypeId;
		setContentType(ContentType.getContentType(contentTypeId));
	}

	/**
	 * @return the contentFormatId
	 */
	public Integer getContentFormatId() {
		return contentFormatId;
	}

	/**
	 * @param contentFormatId
	 *            the contentFormatId to set
	 */
	public void setContentFormatId(Integer contentFormatId) {
		this.contentFormatId = contentFormatId;
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId
	 *            the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the contentFormat
	 */
	public ContentFormat getContentFormat() {
		return contentFormat;
	}

	/**
	 * @param contentFormat
	 *            the contentFormat to set
	 */
	public void setContentFormat(ContentFormat contentFormat) {
		this.contentFormat = contentFormat;
	}

	/**
	 * @return the learningContentPartsList
	 */
	public List<LearningContentParts> getLearningContentPartsList() {
		return learningContentPartsList;
	}

	/**
	 * @param learningContentPartsList
	 *            the learningContentPartsList to set
	 */
	public void setLearningContentPartsList(
			List<LearningContentParts> learningContentPartsList) {
		this.learningContentPartsList = learningContentPartsList;
	}

	/**
	 * @return the isDelete
	 */
	public Boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete
	 *            the isDelete to set
	 */
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	private Integer contentPartid;
	private String contentUrl;
	public Integer getContentPartid() {
		return contentPartid;
	}

	public void setContentPartid(Integer contentPartid) {
		this.contentPartid = contentPartid;
	}

	public void setLearningContentId(ZID learningContentId) {
		this.learningContentId = learningContentId;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	
	
}