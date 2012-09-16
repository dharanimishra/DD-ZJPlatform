package com.ziksana.domain.course;

import java.util.Date;

public class LearningContentTagcloud {
	/**
	 * This field corresponds to the database column
	 * corlearningcontenttagcloud.contentTagCloudId
	 */
	private Integer contentTagCloudId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttagcloud.CreatedDate
	 */
	private Date createdDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttagcloud.TagName
	 */
	private String tagName;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttagcloud.TagType
	 */
	private Integer tagType;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttagcloud.ZeniSuggestedIndicator
	 */
	private Boolean zeniSuggestedIndicator;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttagcloud.LearningContentId
	 */
	private Integer learningContentId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttagcloud.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttagcloud.contentTagCloudId
	 * 
	 * @return the value of corlearningcontenttagcloud.contentTagCloudId
	 */
	public Integer getContentTagCloudId() {
		return contentTagCloudId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttagcloud.contentTagCloudId
	 * 
	 * @param contentTagCloudId
	 *            the value for corlearningcontenttagcloud.contentTagCloudId
	 */
	public void setContentTagCloudId(Integer contentTagCloudId) {
		this.contentTagCloudId = contentTagCloudId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttagcloud.CreatedDate
	 * 
	 * @return the value of corlearningcontenttagcloud.CreatedDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttagcloud.CreatedDate
	 * 
	 * @param createdDate
	 *            the value for corlearningcontenttagcloud.CreatedDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttagcloud.TagName
	 * 
	 * @return the value of corlearningcontenttagcloud.TagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttagcloud.TagName
	 * 
	 * @param tagName
	 *            the value for corlearningcontenttagcloud.TagName
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName == null ? null : tagName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttagcloud.TagType
	 * 
	 * @return the value of corlearningcontenttagcloud.TagType
	 */
	public Integer getTagType() {
		return tagType;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttagcloud.TagType
	 * 
	 * @param tagType
	 *            the value for corlearningcontenttagcloud.TagType
	 */
	public void setTagType(Integer tagType) {
		this.tagType = tagType;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttagcloud.ZeniSuggestedIndicator
	 * 
	 * @return the value of corlearningcontenttagcloud.ZeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttagcloud.ZeniSuggestedIndicator
	 * 
	 * @param zeniSuggestedIndicator
	 *            the value for
	 *            corlearningcontenttagcloud.ZeniSuggestedIndicator
	 */
	public void setZeniSuggestedIndicator(Boolean zeniSuggestedIndicator) {
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttagcloud.LearningContentId
	 * 
	 * @return the value of corlearningcontenttagcloud.LearningContentId
	 */
	public Integer getLearningContentId() {
		return learningContentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttagcloud.LearningContentId
	 * 
	 * @param learningContentId
	 *            the value for corlearningcontenttagcloud.LearningContentId
	 */
	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = learningContentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttagcloud.MemberRoleId
	 * 
	 * @return the value of corlearningcontenttagcloud.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttagcloud.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corlearningcontenttagcloud.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}