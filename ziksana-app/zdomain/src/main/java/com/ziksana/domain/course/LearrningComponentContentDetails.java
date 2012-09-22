/**
 * 
 */
package com.ziksana.domain.course;

/**
 * @author bhashasp
 */
public class LearrningComponentContentDetails {
	
	private Integer learningComponentId;
	
	private Integer SynchronizeWithVideoId;
	
	private Integer baseLearningContentId;
	
	private LearningContent learningContent;

	/**
	 * @return the learningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * @param learningComponentId the learningComponentId to set
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * @return the synchronizeWithVideoId
	 */
	public Integer getSynchronizeWithVideoId() {
		return SynchronizeWithVideoId;
	}

	/**
	 * @param synchronizeWithVideoId the synchronizeWithVideoId to set
	 */
	public void setSynchronizeWithVideoId(Integer synchronizeWithVideoId) {
		SynchronizeWithVideoId = synchronizeWithVideoId;
	}

	/**
	 * @return the baseLearningContentId
	 */
	public Integer getBaseLearningContentId() {
		return baseLearningContentId;
	}

	/**
	 * @param baseLearningContentId the baseLearningContentId to set
	 */
	public void setBaseLearningContentId(Integer baseLearningContentId) {
		this.baseLearningContentId = baseLearningContentId;
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
