/**
 * 
 */
package com.ziksana.domain.course;

import java.util.List;


/**
 * @author bhashasp
 */
public class LearningComponentContentDetails extends LearningComponentContent{

	
	public LearningComponentContentDetails(
			LearningComponent learningComponent,
			LearningContent baseLearningContent) {
		super( learningComponent, baseLearningContent);
		}

	private List<LearningComponentContentEnrichment> 	enrichmentList						= null;
	//private List<LearningComponentContentBookmark> 		bookmarkList						= null;
	//private List<LearningContentReviewProgress> 		learningContentReviewProgressList	= null;
	//private List<LearningComponentContentEmbed>		learningCompContentEmbedList		= null;
	//private List<LearningComponentContentFootstep>    learningCompContentFootstepList		= null; 
	//private List<SubscriberNotes>						subscriberNotesList					= null;
	private List<LearningComponentContentHotspot>    	learningCompContentHotspotList		= null; 
	
	private LearningContent 							learningContent						= null;
	
	/**
	 * @return the learningContent
	 */
	public LearningContent getLearningContent() {
		return learningContent;
	}

	/**
	 * @param learningContent the learningContent to set
	 */
	public void addLearningContent(LearningContent learningContent) {
		
		this.learningContent = learningContent;
	}

	/**
	 * @return the enrichmentList
	 */
	public List<LearningComponentContentEnrichment> getEnrichmentList() {
		return enrichmentList;
	}

	/**
	 * @param enrichmentList the enrichmentList to set
	 */
	public void setEnrichmentList(List<LearningComponentContentEnrichment> enrichmentList) {
		this.enrichmentList = enrichmentList;
	}

	/**
	 * @return the learningCompContentHotspotList
	 */
	public List<LearningComponentContentHotspot> getLearningCompContentHotspotList() {
		return learningCompContentHotspotList;
	}

	/**
	 * @param learningCompContentHotspotList the learningCompContentHotspotList to set
	 */
	public void setLearningCompContentHotspotList(
			List<LearningComponentContentHotspot> learningCompContentHotspotList) {
		this.learningCompContentHotspotList = learningCompContentHotspotList;
	}

/*	*//**
	 * @return the enrichmentList
	 *//*
	public List<LearningComponentContentEnrichment> getEnrichmentList() {
		return enrichmentList;
	}

	*//**
	 * @param enrichmentList
	 *            the enrichmentList to set
	 *//*
	public void setEnrichmentList(
			List<LearningComponentContentEnrichment> enrichmentList) {
		this.enrichmentList = enrichmentList;
	}

*//*	*//**
	 * @return the bookmarkList
	 *//*
	public List<LearningComponentContentBookmark> getBookmarkList() {
		return bookmarkList;
	}

	*//**
	 * @param bookmarkList
	 *            the bookmarkList to set
	 *//*
	public void setBookmarkList(
			List<LearningComponentContentBookmark> bookmarkList) {
		this.bookmarkList = bookmarkList;
	}

	*//**
	 * @return the learningContentReviewProgressList
	 *//*
	public List<LearningContentReviewProgress> getLearningContentReviewProgressList() {
		return learningContentReviewProgressList;
	}

	*//**
	 * @param learningContentReviewProgressList the learningContentReviewProgressList to set
	 *//*
	public void setLearningContentReviewProgressList(
			List<LearningContentReviewProgress> learningContentReviewProgressList) {
		this.learningContentReviewProgressList = learningContentReviewProgressList;
	}

	*//**
	 * @return the subscriberNotesList
	 *//*
	public List<SubscriberNotes> getSubscriberNotesList() {
		return subscriberNotesList;
	}

	*//**
	 * @param subscriberNotesList the subscriberNotesList to set
	 *//*
	public void setSubscriberNotesList(List<SubscriberNotes> subscriberNotesList) {
		this.subscriberNotesList = subscriberNotesList;
	}
*/
}
