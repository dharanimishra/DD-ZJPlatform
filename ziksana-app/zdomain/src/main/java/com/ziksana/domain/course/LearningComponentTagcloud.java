package com.ziksana.domain.course;

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.TagCloud;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class LearningComponentTagcloud extends TagCloud {
	
	
	public LearningComponentTagcloud(String tagName, TagType tagType) {
		super(tagName, tagType);
	}
	
	private ZID 				componentTagCloudId;
	private LearningComponent 	learningComponent 		= null;
	
	/**
	 * @return the componentTagCloudId
	 */
	public ZID getComponentTagCloudId() {
		return componentTagCloudId;
	}
	/**
	 * @param componentTagCloudId the componentTagCloudId to set
	 */
	public void setComponentTagCloudId(ZID componentTagCloudId) {
		this.componentTagCloudId = componentTagCloudId;
	}
	/**
	 * @return the learningComponent
	 */
	public LearningComponent getLearningComponent() {
		return learningComponent;
	}
	/**
	 * @param learningComponent the learningComponent to set
	 */
	public void setLearningComponent(LearningComponent learningComponent) {
		this.learningComponent = learningComponent;
	}
	

}
