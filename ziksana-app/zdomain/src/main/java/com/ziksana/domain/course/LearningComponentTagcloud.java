package com.ziksana.domain.course;

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.TagCloud;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author Ratnesh Kumar
 */
public class LearningComponentTagcloud extends TagCloud {

	private static final long serialVersionUID = 8705387066802080147L;

	public LearningComponentTagcloud() {

	}

	public LearningComponentTagcloud(String tagName, TagType tagType) {
		super(tagName, tagType);
	}

	private ZID componentTagCloudId;

	private Integer tagCloudId = null;

	private LearningComponent learningComponent = null;

	private Integer learningComponentId;

	public Integer getTagCloudId() {
		return tagCloudId;
	}

	public void setTagCloudId(Integer tagCloudId) {
		this.tagCloudId = tagCloudId;
	}

	public void setComponentTagCloudId(ZID componentTagCloudId) {
		this.componentTagCloudId = componentTagCloudId;
	}

	/**
	 * @return the componentTagCloudId
	 */

	public ZID getComponentTagCloudId() {
		return componentTagCloudId;
	}

	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * @param componentTagCloudId
	 *            the componentTagCloudId to set
	 */
	public void setComponentTagCloudId(Integer componentTagCloudId) {
		this.componentTagCloudId = new IntegerZID(componentTagCloudId);
	}

	/**
	 * @return the learningComponent
	 */
	public LearningComponent getLearningComponent() {
		return learningComponent;
	}

	/**
	 * @param learningComponent
	 *            the learningComponent to set
	 */
	public void setLearningComponent(LearningComponent learningComponent) {
		this.learningComponent = learningComponent;
	}

	@Override
	public String toString() {
		return "LearningComponentTagcloud [componentTagCloudId="
				+ componentTagCloudId + ", tagCloudId=" + tagCloudId
				+ ", learningComponent=" + learningComponent
				+ ", learningComponentId=" + learningComponentId
				+ ", getTagName()=" + getTagName() + ", getTagType()="
				+ getTagType() + ", getZeniSuggestedIndicator()="
				+ getZeniSuggestedIndicator() + ", getCreatingMember()="
				+ getCreatingMember() + ", toString()=" + super.toString()
				+ ", getTagTypeId()=" + getTagTypeId() + ", getCreatedBy()="
				+ getCreatedBy() + ", getCreatedOn()=" + getCreatedOn()
				+ ", getModifiedBy()=" + getModifiedBy() + ", getModifiedOn()="
				+ getModifiedOn() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
