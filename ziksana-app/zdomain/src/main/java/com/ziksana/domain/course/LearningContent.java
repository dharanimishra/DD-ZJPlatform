package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class LearningContent implements Serializable {
	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 2095369225846100688L;

	/**
	 * This field corresponds to the database column corlearningcontent.learningContentId
	 */
	private Integer learningContentId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontent.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column corlearningcontent.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corlearningcontent.ContentType
	 */
	private Integer contentType;

	/**
	 * This field corresponds to the database column
	 * corlearningcontent.ContentPath
	 */
	private String contentPath;

	/**
	 * This field corresponds to the database column
	 * corlearningcontent.ContentFormat
	 */
	private Integer contentFormat;

	/**
	 * This field corresponds to the database column corlearningcontent.Status
	 */
	private Integer status;

	/**
	 * This field corresponds to the database column corlearningcontent.Version
	 */
	private Integer version;

	/**
	 * This field corresponds to the database column corlearningcontent.Version
	 */
	private String contentName;

	/**
	 * This field corresponds to the database column corlearningcontent.Version
	 */
	private String contentDescription;

	/**
	 * This field corresponds to the database column corlearningcontent.Version
	 */
	private String thumbnailPicturePath;

	/**
	 * This field corresponds to the database column corlearningcontent.Version
	 */
	private Integer rightsOwningMemberRoleId;

	/**
	 * This field corresponds to the database column corlearningcontent.Version
	 */
	private Integer authoringMemberRoleId;

	/**
	 * This field corresponds to the database column corlearningcontent.Version
	 */
	private Integer subjClassificationId;

	/**
	 * This field corresponds to the database column corlearningcontent.LinkedLearningContentId
	 */
	private Integer linkedLearningContentId;

	// private List<ContentParts> corlearningcontentParts;

	/**
	 * This method returns the value of the database column
	 * corlearningcontent.learningContentId
	 * 
	 * @return the value of corlearningcontent.learningContentId
	 */
	public Integer getLearningContentId() {
		return learningContentId;
	}

	/**
	 * This method sets the value of the database column corlearningcontent.learningContentId
	 * 
	 * @param learningContentId
	 *            the value for corlearningcontent.learningContentId
	 */
	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = learningContentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontent.CreationDate
	 * 
	 * @return the value of corlearningcontent.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontent.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corlearningcontent.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontent.Active
	 * 
	 * @return the value of corlearningcontent.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontent.Active
	 * 
	 * @param active
	 *            the value for corlearningcontent.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontent.ContentType
	 * 
	 * @return the value of corlearningcontent.ContentType
	 */
	public Integer getContentType() {
		return contentType;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontent.ContentType
	 * 
	 * @param contentType
	 *            the value for corlearningcontent.ContentType
	 */
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontent.ContentPath
	 * 
	 * @return the value of corlearningcontent.ContentPath
	 */
	public String getContentPath() {
		return contentPath;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontent.ContentPath
	 * 
	 * @param contentPath
	 *            the value for corlearningcontent.ContentPath
	 */
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath == null ? null : contentPath.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontent.ContentFormat
	 * 
	 * @return the value of corlearningcontent.ContentFormat
	 */
	public Integer getContentFormat() {
		return contentFormat;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontent.ContentFormat
	 * 
	 * @param contentFormat
	 *            the value for corlearningcontent.ContentFormat
	 */
	public void setContentFormat(Integer contentFormat) {
		this.contentFormat = contentFormat;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontent.Status
	 * 
	 * @return the value of corlearningcontent.Status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontent.Status
	 * 
	 * @param status
	 *            the value for corlearningcontent.Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontent.Version
	 * 
	 * @return the value of corlearningcontent.Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontent.Version
	 * 
	 * @param version
	 *            the value for corlearningcontent.Version
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
	 * @return the rightsOwningMemberRoleId
	 */
	public Integer getRightsOwningMemberRoleId() {
		return rightsOwningMemberRoleId;
	}

	/**
	 * @param rightsOwningMemberRoleId
	 *            the rightsOwningMemberRoleId to set
	 */
	public void setRightsOwningMemberRoleId(Integer rightsOwningMemberRoleId) {
		this.rightsOwningMemberRoleId = rightsOwningMemberRoleId;
	}

	/**
	 * @return the authoringMemberRoleId
	 */
	public Integer getAuthoringMemberRoleId() {
		return authoringMemberRoleId;
	}

	/**
	 * @param authoringMemberRoleId
	 *            the authoringMemberRoleId to set
	 */
	public void setAuthoringMemberRoleId(Integer authoringMemberRoleId) {
		this.authoringMemberRoleId = authoringMemberRoleId;
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
	 * @param linkedLearningContentId the linkedLearningContentId to set
	 */
	public void setLinkedLearningContentId(Integer linkedLearningContentId) {
		this.linkedLearningContentId = linkedLearningContentId;
	}
}