package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.ContentEnrichment;
import com.ziksana.domain.course.Enrichment;
import com.ziksana.domain.course.EnrichmentType;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentContentHotspot;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LinkType;
import com.ziksana.domain.course.ReferenceSearchCriteria;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.EnrichmentMapper;
import com.ziksana.persistence.course.LearningComponentContentHotspotMapper;
import com.ziksana.service.course.CourseContentEnrichmentService;

public class CourseContentEnrichmentServiceImpl implements
		CourseContentEnrichmentService {

	private static Logger logger = Logger
			.getLogger(CourseContentEnrichmentServiceImpl.class);

	@Autowired
	public EnrichmentMapper 						enrichMapper;
	@Autowired
	public LearningComponentContentHotspotMapper 	hotspotMapper;
	
	
	@Transactional
	@Override
	public void saveOrUpdateEnrichContent(Enrichment enrich)
			throws CourseException {

	}

	@Transactional
	@Override
	public void saveReference(Enrichment enrichment, LinkType enrichLinkType) throws CourseException {

		saveReferenceOrTopicOrNotes(enrichment, LinkType.REFERENCE);
	}

	@Transactional
	@Override
	public void deleteReference(Enrichment enrichment) throws CourseException {
		deleteReferenceOrTopicOrNotes(enrichment);
	}

	@Transactional
	@Override
	public void saveNotes(Enrichment enrichment, LinkType enrichLinkType) throws CourseException {
		saveReferenceOrTopicOrNotes(enrichment,LinkType.ADDITIONAL_INFO);
	}

	@Transactional
	@Override
	public void deleteNotes(Enrichment enrichment) throws CourseException {

		deleteReferenceOrTopicOrNotes(enrichment);

	}

	@Transactional
	@Override
	public void updateNotes(Enrichment enrichment) throws CourseException {

		updateReferenceOrTopicOrNotes(enrichment);

	}

	@Transactional
	@Override
	public void saveTOC(Enrichment enrichment, LinkType enrichLinkType) throws CourseException {

		saveReferenceOrTopicOrNotes(enrichment, LinkType.TOC);

	}

	@Transactional
	@Override
	public void deleteTOC(Enrichment enrichment) throws CourseException {

		deleteReferenceOrTopicOrNotes(enrichment);

	}

	@Transactional
	@Override
	public void updateTOC(Enrichment enrichment) throws CourseException {

		updateReferenceOrTopicOrNotes(enrichment);

	}

	/**
	 * Saves Enrichment Reference/TOC(Topic)/Notes
	 * @param enrichment
	 * @throws CourseException
	 */
	private void saveReferenceOrTopicOrNotes(Enrichment enrichment, LinkType enrichLinkType)
			throws CourseException {
		ContentEnrichment 		contentEnrichment 	= null;

		if (enrichment == null) {
			throw new CourseException("Enrichment cannot be null");
		}

		if (enrichment.getLearningContent() == null) {
			throw new CourseException(
					"Learning Content cannot be null for Enrichment");
		}
		
		logger.debug("Before Saving the Enrichment ....");
		enrichMapper.saveReference(enrichment);
		logger.debug("After Saving the Enrichment .ID :"+enrichment.getEnrichmentId());
		
		if (enrichment.getEnrichmentId() != null) {

			logger.debug("After Saving the Enrichment learncontentid  :"+enrichment.getLearningContent().getLearningContentId());
			
			contentEnrichment = enrichment.getContentEnrich();

			contentEnrichment.setApplyEnrichment(enrichment);
			
			contentEnrichment.setLinkTypeId(enrichLinkType.getID());

			logger.debug("Before Saving the Enrichment Content ....:"
					+ contentEnrichment.getLinkTypeId());
			enrichMapper.saveRefenceContent(contentEnrichment);

		}
	}

	/**
	 * Deletes Enrichment delete indicator for Reference/TOC(Topic)/Notes
	 * entries
	 * @param enrichment
	 * @throws CourseException
	 */
	private void deleteReferenceOrTopicOrNotes(Enrichment enrichment)
			throws CourseException {

		ContentEnrichment contentEnrichment = null;

		if (enrichment == null) {
			throw new CourseException("Enrichment cannot be null");
		}

		if (enrichment.getLearningContent() == null) {
			throw new CourseException(
					"Learning Content cannot be null for Enrichment");
		}

		contentEnrichment = enrichment.getContentEnrich();

		if (contentEnrichment == null) {
			throw new CourseException("Content enrichment cannot be null");
		}

		logger.debug("Before Deleting the Enrichment Content ....:"
				+ contentEnrichment.getLinkType());
		// update delete indicator status to remove the association with
		// applyenrichment
		enrichMapper.delete(contentEnrichment);

		logger.debug("Before Deleting the Enrichment ....");
		// update delete indicator status to remove the association with content
		enrichMapper.delete(enrichment);

	}

	/**
	 * Updates Enrichment Reference/TOC(Topic)/Notes entries
	 * @param enrichment
	 * @throws CourseException
	 */
	private void updateReferenceOrTopicOrNotes(Enrichment enrichment)
			throws CourseException {

		ContentEnrichment contentEnrichment = null;

		if (enrichment == null) {
			throw new CourseException("Enrichment cannot be null");
		}

		if (enrichment.getLearningContent() == null) {
			throw new CourseException(
					"Learning Content cannot be null for Enrichment");
		}

		contentEnrichment = enrichment.getContentEnrich();

		if (contentEnrichment == null) {
			throw new CourseException("Content enrichment cannot be null");
		}

		// update delete indicator status to remove the association with
		// applyenrichment
		enrichMapper.updateContentEnrichment(contentEnrichment);
	}

	@Transactional
	@Override
	public Map<EnrichmentType, List<ContentEnrichment>> getAllEnrichmentContents(
			ZID memberPersonaId) throws CourseException {

		Map<EnrichmentType, List<ContentEnrichment>> 	enrichmentMap 			= null;
		List<Enrichment> 								enrichList 				= null;
		List<ContentEnrichment> 						refContentEnrichList 	= null;
		List<ContentEnrichment> 						topicContentEnrichList 	= null;
		List<ContentEnrichment> 						notesContentEnrichList 	= null;
		ContentEnrichment 								contentEnrichment 		= null;				
		enrichList 					= new ArrayList<Enrichment>();
		enrichmentMap 				= new HashMap<EnrichmentType, List<ContentEnrichment>>();
		refContentEnrichList 		= new ArrayList<ContentEnrichment>();
		topicContentEnrichList 		= new ArrayList<ContentEnrichment>();
		notesContentEnrichList 		= new ArrayList<ContentEnrichment>();
		
		if (memberPersonaId == null) {
			throw new CourseException("Member cannot be null");
		}

		enrichList = enrichMapper.getAllEnrichments(new Integer(memberPersonaId.getStorageID()));
		
		if(enrichList!=null && enrichList.size()>0){

			for (Enrichment enrichment : enrichList) {

				contentEnrichment = enrichment.getContentEnrich();

				if(contentEnrichment.getLinkType().equals(LinkType.TOC)){
						
					topicContentEnrichList.add(contentEnrichment);
						
				}else if(contentEnrichment.getLinkType().equals(LinkType.REFERENCE)){
						
					refContentEnrichList.add(contentEnrichment);
		
				}else if(contentEnrichment.getLinkType().equals(LinkType.ADDITIONAL_INFO)){
						
					notesContentEnrichList.add(contentEnrichment);
						
				}
			}

			enrichmentMap.put(EnrichmentType.TOPIC, topicContentEnrichList);
			enrichmentMap.put(EnrichmentType.REFERENCE, refContentEnrichList);
			enrichmentMap.put(EnrichmentType.NOTES, notesContentEnrichList);
			
		}

		return enrichmentMap;
	}
	
	@Override
	public List<LearningComponentContentHotspot> getCompContentHotspotList(LearningComponentContent compContent)throws CourseException {
		
		List<LearningComponentContentHotspot> hotspotList = null;
		
		if(compContent.getLearningComponentContentId()==null){
			throw new CourseException("Learning Component Content ID cannot be null");
		}
		
		hotspotList = new ArrayList<LearningComponentContentHotspot>();
		
		hotspotList = hotspotMapper.getHotspotList(compContent.getLearningComponentContentId());
		
		return hotspotList;
		
	}

	@Override
	public List<LearningContent> basicSearchReferences(ReferenceSearchCriteria searchCriteria) throws CourseException {
		
		List<LearningContent> contents  = null;

		if(searchCriteria == null){
			throw new CourseException("ReferenceSearchCriteria cannot be null");
		}
		
		contents  = enrichMapper.basicSearchReferenceMaterial(searchCriteria);
		
		logger.debug("Enrichments(Reference)  list size : "+contents.size());
		
		return contents;
	}

	
	@Override
	public List<LearningContent> advanceSearchReferences(ReferenceSearchCriteria searchCriteria) throws CourseException {
		
		List<LearningContent> contents  = null;

		if(searchCriteria == null){
			throw new CourseException("ReferenceSearchCriteria cannot be null");
		}
		
		contents  = enrichMapper.advanceSearchReferenceMaterial(searchCriteria);
		
		logger.debug("Enrichments(Reference)  list size : "+contents.size());
		
		return contents;
	}

	@Transactional
	@Override
	public void saveHotspot(LearningComponentContentHotspot hotspot) throws CourseException {

		LearningComponentContent compContent =  null;
		
		if(hotspot == null){
			throw new CourseException("LearningComponentContentHotspot cannot be  null");
		}
		
		compContent = hotspot.getLearningComponentContent();
		
		if(compContent.getLearningComponentContentId()!=null){
			
			logger.debug("Before Saving LearningComponentContentHotspot .. ");
			hotspotMapper.save(hotspot);
			
		}
	}

	@Override
	public void deleteHotspot(LearningComponentContentHotspot hotspot) throws CourseException {
		LearningComponentContent compContent =  null;
		
		if(hotspot == null){
			throw new CourseException("LearningComponentContentHotspot cannot be  null");
		}
		
		compContent = hotspot.getLearningComponentContent();
		
		if(compContent.getLearningComponentContentId()!=null){
			
			logger.debug("Before Saving LearningComponentContentHotspot .. ");
			
			Integer hotspotId = new Integer(hotspot.getComponentContentHotspotId().getStorageID());
			
			hotspotMapper.delete(hotspotId);
			
		}

	}

	@Override
	public void updateHotspot(LearningComponentContentHotspot hotspot) throws CourseException {
		
		LearningComponentContent compContent =  null;
		
		if(hotspot == null){
			throw new CourseException("LearningComponentContentHotspot cannot be  null");
		}
		
		compContent = hotspot.getLearningComponentContent();
		
		if(compContent.getLearningComponentContentId()!=null){
			
			logger.debug("Before Saving LearningComponentContentHotspot .. ");
			
			hotspotMapper.update(hotspot);
			
		}

	}

}
