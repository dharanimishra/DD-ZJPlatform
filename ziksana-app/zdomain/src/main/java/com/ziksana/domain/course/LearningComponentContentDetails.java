/**
 * 
 */
package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.List;


/**
 * @author bhashasp
 */
public class LearningComponentContentDetails{

	
	public LearningComponentContentDetails(
			LearningComponent learningComponent,
			LearningContent baseLearningContent) {
			}

	public LearningComponentContentDetails() {
		
	}

	private List<ContentEnrichment> 	enrichmentList						= null;
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
	public void addLearningContent(LearningContent learningContent) throws Exception{
		if(learningContent == null){
			throw new IllegalArgumentException("Cannot set Learning Content as null in Component Content");
		}
		this.learningContent = learningContent;
	}

	/**
	 * @return the enrichmentList
	 */
	public List<ContentEnrichment> getEnrichmentList() {
		return enrichmentList;
	}

	/**
	 * @param enrhmichmentList the enrichmentList to set
	 */
	public void setEnrichments(List<ContentEnrichment> enrichist)  throws Exception{
		
		if(enrichist == null){
			throw new IllegalArgumentException("Cannot set enrichments as null in Component Content ID");
		}
		
		this.enrichmentList = enrichist;
		
	}

	
	
	/**add enrichment to list 
	 * @param enrichment
	 */
	public void addEnrichment(ContentEnrichment enrichment){
		
		if(enrichmentList == null){
			enrichmentList = new ArrayList<ContentEnrichment>();
		}
		
		enrichmentList.add(enrichment);
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
	@Override
	public String toString() {
		return "LearningComponentContentDetails [learningContent="
				+ learningContent + "]";
	}


}
