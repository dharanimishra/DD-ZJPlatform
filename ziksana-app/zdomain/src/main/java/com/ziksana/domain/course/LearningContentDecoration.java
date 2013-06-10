package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * Domain object to map corlearningcontentdecoration
 * 
 * @author Arvind
 *
 */
public class LearningContentDecoration extends AuditHistory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer learningContentId;
	private ZID learningContentDecorationtId;
	private Boolean active;
	private ContentDecorationType contentDecorationType;
	private Integer ContentDecorationTypeId;
	private Integer version;
	private String description;
	private String versionRemarks;
	private Integer authoringMemberRoleId;
	private Integer rightsOwningMemberRoleId;
	private MemberPersona rightsOwningMember = null;
	private MemberPersona authoringMember = null;
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
	
	
	/**
	 * @param learningContentDecorationtId the learningContentDecorationtId to set
	 */
	public void setLearningContentDecorationtId(ZID learningContentDecorationtId) {
		this.learningContentDecorationtId = learningContentDecorationtId;
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
	 * @return the learningContentId
	 */
	public Integer getLearningContentId() {
		return learningContentId;
	}
	/**
	 * @param learningContentId the learningContentId to set
	 */
	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = learningContentId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LearningContentDecoration [active=");
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