/**
 * 
 */
package com.ziksana.domain.common;

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.member.MemberPersona;

/**
 * @author bhashasp
 */
public class TagCloud extends AuditHistory{
	
	public TagCloud(String tagName, TagType tagType) {
		this.tagName = tagName;
		this.tagType = tagType;
	}
	
	public TagCloud() {
	}

	private String 				tagName 				= null;
	private TagType 			tagType 				= null;
	private Boolean 			zeniSuggestedIndicator 	= null;
	private MemberPersona 		creatingMember 			= null;
	
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

	@Override
	public String toString() {
		return "TagCloud [tagName=" + tagName + ", tagType=" + tagType
				+ ", zeniSuggestedIndicator=" + zeniSuggestedIndicator + "]";
	}
}
