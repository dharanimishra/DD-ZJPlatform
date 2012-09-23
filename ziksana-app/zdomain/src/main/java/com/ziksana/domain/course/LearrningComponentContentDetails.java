/**
 * 
 */
package com.ziksana.domain.course;

import java.util.List;

/**
 * @author bhashasp
 */
public class LearrningComponentContentDetails {

	private Integer learningComponentId;

	private Integer SynchronizeWithVideoId;

	private Integer baseLearningContentId;

	private LearningContent learningContent;

	private List<LearningComponentContentEnrichment> enrichmentList;

	private List<LearningComponentContentBookmark> bookmarkList;

	/**
	 * @return the learningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * @param learningComponentId
	 *            the learningComponentId to set
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
	 * @param synchronizeWithVideoId
	 *            the synchronizeWithVideoId to set
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
	 * @param baseLearningContentId
	 *            the baseLearningContentId to set
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
	 * @param learningContent
	 *            the learningContent to set
	 */
	public void setLearningContent(LearningContent learningContent) {
		this.learningContent = learningContent;
	}

	/**
	 * @return the enrichmentList
	 */
	public List<LearningComponentContentEnrichment> getEnrichmentList() {
		return enrichmentList;
	}

	/**
	 * @param enrichmentList
	 *            the enrichmentList to set
	 */
	public void setEnrichmentList(
			List<LearningComponentContentEnrichment> enrichmentList) {
		this.enrichmentList = enrichmentList;
	}

	/**
	 * @return the bookmarkList
	 */
	public List<LearningComponentContentBookmark> getBookmarkList() {
		return bookmarkList;
	}

	/**
	 * @param bookmarkList
	 *            the bookmarkList to set
	 */
	public void setBookmarkList(
			List<LearningComponentContentBookmark> bookmarkList) {
		this.bookmarkList = bookmarkList;
	}

}
