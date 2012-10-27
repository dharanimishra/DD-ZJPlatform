package com.ziksana.service.course;

import java.util.List;
import java.util.Map;

import com.ziksana.domain.course.ContentEnrichment;
import com.ziksana.domain.course.Enrichment;
import com.ziksana.domain.course.EnrichmentType;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentContentHotspot;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.ReferenceSearchCriteria;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;


/**
 * @author bhashasp
 */
public interface CourseContentEnrichmentService {
	
	/** 
	 * Saves the updated enrichments.
	 * @param enrich
	 * @throws CourseException
	 */
	public void saveOrUpdateEnrichContent(Enrichment enrich) throws CourseException;
	/**
	 * Save Reference material information to video content.<br>
	 * LinkType : REFERENCE
	 * @param enrich
	 * @throws CourseException
	 */
	public void saveReference(Enrichment enrich) throws CourseException;
	
	/**
	 * Deletes the association of reference  to video content.
	 * @param enrich
	 * @throws CourseException
	 */
	public void deleteReference(Enrichment enrich) throws CourseException;
	
	/**
	 * Saves the Notes  to video content.<br>
	 * "LinkType : ADDITIONAL_INFO"
	 * @param enrich
	 * @throws CourseException
	 */
	public void saveNotes(Enrichment enrich) throws CourseException;
	
	/**
	 * Deletes the Notes association to video content.
	 * @param enrich
	 * @throws CourseException
	 */
	public void deleteNotes(Enrichment enrich) throws CourseException;
	
	/**
	 * Updates the Notes for video content.
	 * @param enrich
	 * @throws CourseException
	 */
	public void updateNotes(Enrichment enrich) throws CourseException;

	/**
	 * Saves the Topic for video content<br>
	 * LinkType : TOC, Title: Topic Item, Details as “Dependeny:  Parent TOC Title”
	 * @param enrich
	 * @throws CourseException
	 */
	public void saveTOC(Enrichment enrich) throws CourseException;
	
	/**
	 * Removes the Topiic association to video content. 
	 * @param enrich
	 * @throws CourseException
	 */
	public void deleteTOC(Enrichment enrich) throws CourseException;
	
	/**
	 * Modifies the Topic for video
	 * @param enrich
	 * @throws CourseException
	 */
	public void updateTOC(Enrichment enrich) throws CourseException;
	
	/**
	 * Retrieve all enrichment contents (Topic, Hotspot, Reference, Notes)
	 * @param memberPersonaId
	 * @return
	 * @throws CourseException
	 */
	public Map<EnrichmentType, List<ContentEnrichment>> getAllEnrichmentContents(ZID memberPersonaId) throws CourseException;
	
	/**
	 * Basic Searches the Reference Material based on the provided search criteria.
	 * @param enrich
	 * @return
	 * @throws CourseException
	 */
	public List<LearningContent> basicSearchReferences(ReferenceSearchCriteria searchCriteria) throws CourseException;
	
	/**
	 * Advance Searches the Reference Material based on the provided search criteria.
	 * @param enrich
	 * @return
	 * @throws CourseException
	 */
	public List<LearningContent> advanceSearchReferences(ReferenceSearchCriteria searchCriteria) throws CourseException;

	
	
	/**
	 * Retrieves the list of Hotspots by componentcontent.
	 * @param compContent
	 * @return
	 * @throws CourseException
	 */
	public List<LearningComponentContentHotspot> getCompContentHotspotList(LearningComponentContent compContent)throws CourseException;

	/**
	 * Saves the Topic for video content
	 * @param LearningComponentContentHotspot
	 * @throws CourseException
	 */
	public void saveHotspot(LearningComponentContentHotspot hotspot) throws CourseException;
	
	/**
	 * Removes the Topiic association to video content. 
	 * @param LearningComponentContentHotspot
	 * @throws CourseException
	 */
	public void deleteHotspot(LearningComponentContentHotspot hotspot) throws CourseException;
	
	/**
	 * Modifies the Topic for video
	 * @param LearningComponentContentHotspot
	 * @throws CourseException
	 */
	public void updateHotspot(LearningComponentContentHotspot hotspot) throws CourseException;
	
	
}
