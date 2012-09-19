package com.ziksana.domain.course;

import java.util.Date;

public class CourseTagcloud {
	/**
	 * This field corresponds to the database column
	 * corcoursetagcloud.courseTagCloudId
	 */
	private Integer courseTagCloudId;

	/**
	 * This field corresponds to the database column
	 * corcoursetagcloud.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column corcoursetagcloud.TagName
	 */
	private String tagName;

	/**
	 * This field corresponds to the database column corcoursetagcloud.TagType
	 */
	private Integer tagType;

	/**
	 * This field corresponds to the database column
	 * corcoursetagcloud.ZeniSuggestedIndicator
	 */
	private Boolean zeniSuggestedIndicator;

	/**
	 * This field corresponds to the database column corcoursetagcloud.CourseId
	 */
	private Integer courseId;

	/**
	 * This field corresponds to the database column
	 * corcoursetagcloud.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * corcoursetagcloud.courseTagCloudId
	 * 
	 * @return the value of corcoursetagcloud.courseTagCloudId
	 */
	public Integer getCourseTagCloudId() {
		return courseTagCloudId;
	}

	/**
	 * This method sets the value of the database column
	 * corcoursetagcloud.courseTagCloudId
	 * 
	 * @param courseTagCloudId
	 *            the value for corcoursetagcloud.courseTagCloudId
	 */
	public void setCourseTagCloudId(Integer courseTagCloudId) {
		this.courseTagCloudId = courseTagCloudId;
	}

	/**
	 * This method returns the value of the database column
	 * corcoursetagcloud.CreationDate
	 * 
	 * @return the value of corcoursetagcloud.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcoursetagcloud.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corcoursetagcloud.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcoursetagcloud.TagName
	 * 
	 * @return the value of corcoursetagcloud.TagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * This method sets the value of the database column
	 * corcoursetagcloud.TagName
	 * 
	 * @param tagName
	 *            the value for corcoursetagcloud.TagName
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName == null ? null : tagName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcoursetagcloud.TagType
	 * 
	 * @return the value of corcoursetagcloud.TagType
	 */
	public Integer getTagType() {
		return tagType;
	}

	/**
	 * This method sets the value of the database column
	 * corcoursetagcloud.TagType
	 * 
	 * @param tagType
	 *            the value for corcoursetagcloud.TagType
	 */
	public void setTagType(Integer tagType) {
		this.tagType = tagType;
	}

	/**
	 * This method returns the value of the database column
	 * corcoursetagcloud.ZeniSuggestedIndicator
	 * 
	 * @return the value of corcoursetagcloud.ZeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corcoursetagcloud.ZeniSuggestedIndicator
	 * 
	 * @param zeniSuggestedIndicator
	 *            the value for corcoursetagcloud.ZeniSuggestedIndicator
	 */
	public void setZeniSuggestedIndicator(Boolean zeniSuggestedIndicator) {
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corcoursetagcloud.CourseId
	 * 
	 * @return the value of corcoursetagcloud.CourseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the database column
	 * corcoursetagcloud.CourseId
	 * 
	 * @param courseId
	 *            the value for corcoursetagcloud.CourseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * This method returns the value of the database column
	 * corcoursetagcloud.MemberRoleId
	 * 
	 * @return the value of corcoursetagcloud.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corcoursetagcloud.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corcoursetagcloud.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}