package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * Domain object to map corlearningcontentdecoration
 * 
 * @author Arvind
 *
 */
public class LearningContentDecoration extends AuditHistory {

	private Integer id;
	private ZID learningContentDecorationtId;
	private Date creationDate;
	private Boolean active;
	private ContentDecorationType contentDecorationType;
	private Integer ContentDecorationTypeId;
	private Integer version;
	private String description;
	private String versionRemarks;
	private Integer authoringMemberRoleId;
	private Integer rightsOwningMemberRoleId;
	private boolean isDelete;
	private Integer subjClassificationId;
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
		setLearningContentDecorationtId(id);
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	 * @return the contentDecorationType
	 */
	public ContentDecorationType getContentDecorationType() {
		return contentDecorationType;
	}
	/**
	 * @param contentDecorationType the contentDecorationType to set
	 */
	public void setContentDecorationType(ContentDecorationType contentDecorationType) {
		this.contentDecorationType = contentDecorationType;
	}
	/**
	 * @return the contentDecorationTypeId
	 */
	public Integer getContentDecorationTypeId() {
		return ContentDecorationTypeId;
	}
	/**
	 * @param contentDecorationTypeId the contentDecorationTypeId to set
	 */
	public void setContentDecorationTypeId(Integer contentDecorationTypeId) {
		ContentDecorationTypeId = contentDecorationTypeId;
	}
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the versionRemarks
	 */
	public String getVersionRemarks() {
		return versionRemarks;
	}
	/**
	 * @param versionRemarks the versionRemarks to set
	 */
	public void setVersionRemarks(String versionRemarks) {
		this.versionRemarks = versionRemarks;
	}
	/**
	 * @return the authoringMemberRoleId
	 */
	public Integer getAuthoringMemberRoleId() {
		return authoringMemberRoleId;
	}
	/**
	 * @param authoringMemberRoleId the authoringMemberRoleId to set
	 */
	public void setAuthoringMemberRoleId(Integer authoringMemberRoleId) {
		this.authoringMemberRoleId = authoringMemberRoleId;
	}
	/**
	 * @return the rightsOwningMemberRoleId
	 */
	public Integer getRightsOwningMemberRoleId() {
		return rightsOwningMemberRoleId;
	}
	/**
	 * @param rightsOwningMemberRoleId the rightsOwningMemberRoleId to set
	 */
	public void setRightsOwningMemberRoleId(Integer rightsOwningMemberRoleId) {
		this.rightsOwningMemberRoleId = rightsOwningMemberRoleId;
	}
	/**
	 * @return the isDelete
	 */
	public boolean isDelete() {
		return isDelete;
	}
	/**
	 * @param isDelete the isDelete to set
	 */
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * @return the subjClassificationId
	 */
	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}
	/**
	 * @param subjClassificationId the subjClassificationId to set
	 */
	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	
	/**
	 * @return the learningContentDecorationtId
	 */
	public ZID getLearningContentDecorationtId() {
		return learningContentDecorationtId;
	}
	/**
	 * @param learningContentDecorationtId the learningContentDecorationtId to set
	 */
	private void setLearningContentDecorationtId(Integer learningContentDecorationtId) {
		this.learningContentDecorationtId = new IntegerZID(learningContentDecorationtId);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LearningContentDecoration [creationDate=");
		builder.append(creationDate);
		builder.append(", active=");
		builder.append(active);
		builder.append(", contentDecorationType=");
		builder.append(contentDecorationType);
		builder.append(", ContentDecorationTypeId=");
		builder.append(ContentDecorationTypeId);
		builder.append(", version=");
		builder.append(version);
		builder.append(", description=");
		builder.append(description);
		builder.append(", versionRemarks=");
		builder.append(versionRemarks);
		builder.append(", authoringMemberRoleId=");
		builder.append(authoringMemberRoleId);
		builder.append(", rightsOwningMemberRoleId=");
		builder.append(rightsOwningMemberRoleId);
		builder.append(", isDelete=");
		builder.append(isDelete);
		builder.append(", subjClassificationId=");
		builder.append(subjClassificationId);
		builder.append("]");
		return builder.toString();
	}
	

}