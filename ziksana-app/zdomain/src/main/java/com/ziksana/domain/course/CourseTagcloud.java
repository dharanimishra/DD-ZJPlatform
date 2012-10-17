package com.ziksana.domain.course;

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseTagcloud extends AuditHistory{

	private ZID 				courseTagCloudId;
	private String 				tagName					= null;
	private TagType 			tagType					= null;
	private Boolean 			zeniSuggestedIndicator	= null;
	private MemberPersona 		creatingMember 			= null;
	private Course				course					= null;
	
	/**
	 * @return the courseTagCloudId
	 */
	public ZID getCourseTagCloudId() {
		return courseTagCloudId;
	}
	/**
	 * @param courseTagCloudId the courseTagCloudId to set
	 */
	public void setCourseTagCloudId(ZID courseTagCloudId) {
		this.courseTagCloudId = courseTagCloudId;
	}
	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}
	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
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
	 * @return the zeniSuggestedIndicator
	 */
	public Boolean getZeniSuggestedIndicator() {
		return zeniSuggestedIndicator;
	}
	/**
	 * @param zeniSuggestedIndicator the zeniSuggestedIndicator to set
	 */
	public void setZeniSuggestedIndicator(Boolean zeniSuggestedIndicator) {
		this.zeniSuggestedIndicator = zeniSuggestedIndicator;
	}
	/**
	 * @return the creatingMember
	 */
	public MemberPersona getCreatingMember() {
		return creatingMember;
	}
	/**
	 * @param creatingMember the creatingMember to set
	 */
	public void setCreatingMember(MemberPersona creatingMember) {
		this.creatingMember = creatingMember;
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

	@Override
	public String toString() {
		return "CourseTagcloud [tagName=" + tagName + ", tagType=" + tagType
				+ "]";
	}



}
