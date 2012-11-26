package com.ziksana.domain.course;

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.TagCloud;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class LearningContentTagcloud extends TagCloud {

	public LearningContentTagcloud(String tagName, TagType tagType) {
		super(tagName, tagType);
	}
	
	private ZID 				contentTagCloudId;
	private LearningContent 	learningContent 		= null;
	/**
	 * @return the contentTagCloudId
	 */
	public ZID getContentTagCloudId() {
		return contentTagCloudId;
	}
	/**
	 * @param contentTagCloudId the contentTagCloudId to set
	 */
	public void setContentTagCloudId(Integer contentTagCloudId) {
		this.contentTagCloudId = new IntegerZID(contentTagCloudId);
	}
	/**
	 * @return the learningContent
	 */
	public LearningContent getLearningContent() {
		return learningContent;
	}
	/**
	 * @param learningContent the learningContent to set
	 */
	public void setLearningContent(LearningContent learningContent) {
		this.learningContent = learningContent;
	}
	
}
