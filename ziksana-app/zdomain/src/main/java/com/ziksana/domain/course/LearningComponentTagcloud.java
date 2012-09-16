package com.ziksana.domain.course;

import java.util.Date;

public class LearningComponentTagcloud {
	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttagcloud.componentTagCloudId
	 */
	private Integer componentTagCloudId;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttagcloud.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttagcloud.TagName
	 */
	private String tagName;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttagcloud.TagType
	 */
	private Integer tagType;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttagcloud.ZeniSuggestedIndicator
	 */
	private Boolean zeniSuggestedIndicator;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttagcloud.LearningComponentId
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttagcloud.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * corlearningcomponenttagcloud.componentTagCloudId
	 * 
	 * @return the value of corlearningcomponenttagcloud.componentTagCloudId
	 */
	public Integer getComponentTagCloudId() {
		return componentTagCloudId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponenttagcloud.componentTagCloudId
	 * 
	 * @param componentTagCloudId
	 *            the value for corlearningcomponenttagcloud.componentTagCloudId
	 */
	public void setComponentTagCloudId(Integer componentTagCloudId) {
		this.componentTagCloudId = componentTagCloudId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponenttagcloud.CreationDate
	 * 
	 * @return the value of corlearningcomponenttagcloud.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponenttagcloud.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corlearningcomponenttagcloud.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponenttagcloud.TagName
	 * 
	 * @return the value of corlearningcomponenttagcloud.TagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponenttagcloud.TagName
	 * 
	 * @param tagName
	 *            the value for corlearningcomponenttagcloud.TagName
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName == null ? null : tagName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponenttagcloud.TagType
	 * 
	 * @return the value of corlearningcomponenttagcloud.TagType
	 */
	public Integer getTagType() {
		return tagType;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponenttagcloud.TagType
	 * 
	 * @param tagType
	 *            the value for corlearningcomponenttagcloud.TagType
	 */
	public void setTagType(Integer tagType) {
		this.tagType = tagType;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponenttagcloud.ZeniSuggestedIndicator
	 * 
	 * @return the value of corlearningcomponenttagcloud.ZeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponenttagcloud.ZeniSuggestedIndicator
	 * 
	 * @param zeniSuggestedIndicator
	 *            the value for
	 *            corlearningcomponenttagcloud.ZeniSuggestedIndicator
	 */
	public void setZeniSuggestedIndicator(Boolean zeniSuggestedIndicator) {
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponenttagcloud.LearningComponentId
	 * 
	 * @return the value of corlearningcomponenttagcloud.LearningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponenttagcloud.LearningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for corlearningcomponenttagcloud.LearningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponenttagcloud.MemberRoleId
	 * 
	 * @return the value of corlearningcomponenttagcloud.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponenttagcloud.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corlearningcomponenttagcloud.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}