package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;

public class CourseTagcloud extends AuditHistory{

	private Integer courseTagCloudId;
	private Date creationDate;
	private String tagName;
	private TagType tagType;
	private Boolean zeniSuggestedIndicator;
	private Course course;
	private MemberPersona creatorMemberPersona;

	/**
	 * @return the value of corcoursetagcloud.courseTagCloudId
	 */
	public Integer getCourseTagCloudId() {
		return courseTagCloudId;
	}

	/**
	 * @param courseTagCloudId
	 *            the value for corcoursetagcloud.courseTagCloudId
	 */
	public void setCourseTagCloudId(Integer courseTagCloudId) {
		this.courseTagCloudId = courseTagCloudId;
	}

	/**
	 * @return the value of corcoursetagcloud.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the value for corcoursetagcloud.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the value of corcoursetagcloud.TagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName
	 *            the value for corcoursetagcloud.TagName
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName == null ? null : tagName.trim();
	}

	/**
	 * @return the value of corcoursetagcloud.ZeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}

	/**
	 * @param zeniSuggestedIndicator
	 *            the value for corcoursetagcloud.ZeniSuggestedIndicator
	 */
	public void setZeniSuggestedIndicator(Boolean zeniSuggestedIndicator) {
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}

	/**
	 * @return the tagType
	 */
	public TagType getTagType() {
		return tagType;
	}

	/**
	 * @param tagType the tagType to set
	 */
	public void setTagType(TagType tagType) {
		this.tagType = tagType;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the creatorMemberPersona
	 */
	public MemberPersona getCreatorMemberPersona() {
		return creatorMemberPersona;
	}

	/**
	 * @param creatorMemberPersona the creatorMemberPersona to set
	 */
	public void setCreatorMemberPersona(MemberPersona creatorMemberPersona) {
		this.creatorMemberPersona = creatorMemberPersona;
	}
}