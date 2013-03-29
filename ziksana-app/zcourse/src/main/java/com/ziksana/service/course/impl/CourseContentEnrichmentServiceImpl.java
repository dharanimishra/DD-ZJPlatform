package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author ratneshkumar
 */
public class CourseContentEnrichmentServiceImpl implements
		CourseContentEnrichmentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseContentEnrichmentServiceImpl.class);

	@Autowired
	public EnrichmentMapper enrichMapper;
	@Autowired
	public LearningComponentContentHotspotMapper hotspotMapper;

	@Transactional
	@Override
	public void saveOrUpdateEnrichContent(Enrichment enrich)
			throws CourseException {

	}

	@Transactional
	@Override
	public void saveReference(Enrichment enrichment, LinkType enrichLinkType)
			throws CourseException {

		saveReferenceOrTopicOrNotes(enrichment, LinkType.REFERENCE);
	}

	@Transactional
	@Override
	public void deleteReference(Enrichment enrichment) throws CourseException {
		deleteReferenceOrTopicOrNotes(enrichment);
	}

	@Transactional
	@Override
	public void saveNotes(Enrichment enrichment, LinkType enrichLinkType)
			throws CourseException {
		saveReferenceOrTopicOrNotes(enrichment, LinkType.ADDITIONAL_INFO);
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
	public void saveTOC(Enrichment enrichment, LinkType enrichLinkType)
			throws CourseException {

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
	 * 
	 * @param enrichment
	 * @throws CourseException
	 */
	private void saveReferenceOrTopicOrNotes(Enrichment enrichment,
			LinkType enrichLinkType) throws CourseException {
		ContentEnrichment contentEnrichment = null;

		LOGGER.debug("Before Saving the Enrichment ....");
		enrichMapper.saveReference(enrichment);
		LOGGER.debug("After Saving the Enrichment .ID :"
				+ enrichment.getEnrichmentId());

		if (enrichment.getEnrichmentId() != null) {

			LOGGER.debug("After Saving the Enrichment learncontentid  :"
					+ enrichment.getLearningContent().getLearningContentId());

			contentEnrichment = enrichment.getContentEnrich();

			contentEnrichment.setApplyEnrichment(enrichment);

			contentEnrichment.setLinkTypeId(enrichLinkType.getID());

			LOGGER.debug("Before Saving the Enrichment Content ....:"
					+ contentEnrichment.getLinkTypeId());
			enrichMapper.saveRefenceContent(contentEnrichment);

		}
	}

	/**
	 * Deletes Enrichment delete indicator for Reference/TOC(Topic)/Notes
	 * entries
	 * 
	 * @param enrichment
	 * @throws CourseException
	 */
	private void deleteReferenceOrTopicOrNotes(Enrichment enrichment)
			throws CourseException {

		ContentEnrichment contentEnrichment = null;
		contentEnrichment = enrichment.getContentEnrich();


		LOGGER.debug("Before Deleting the Enrichment Content ....:"
				+ contentEnrichment.getLinkType());
		// update delete indicator status to remove the association with
		// applyenrichment
		enrichMapper.deleteContentEnrichment(contentEnrichment);

		LOGGER.debug("Before Deleting the Enrichment ....");
		// update delete indicator status to remove the association with content
		enrichMapper.deleteEnrichment(enrichment);

	}

	/**
	 * Updates Enrichment Reference/TOC(Topic)/Notes entries
	 * 
	 * @param enrichment
	 * @throws CourseException
	 */
	private void updateReferenceOrTopicOrNotes(Enrichment enrichment)
			throws CourseException {

		ContentEnrichment contentEnrichment = null;


		contentEnrichment = enrichment.getContentEnrich();


		// update delete indicator status to remove the association with
		// applyenrichment
		enrichMapper.updateContentEnrichment(contentEnrichment);
	}

	@Transactional
	@Override
	public Map<EnrichmentType, List<ContentEnrichment>> getAllEnrichmentContents(
			ZID memberPersonaId) throws CourseException {

		Map<EnrichmentType, List<ContentEnrichment>> enrichmentMap = null;
		List<Enrichment> enrichList = null;
		List<ContentEnrichment> refContentEnrichList = null;
		List<ContentEnrichment> topicContentEnrichList = null;
		List<ContentEnrichment> notesContentEnrichList = null;
		ContentEnrichment contentEnrichment = null;
		enrichList = new ArrayList<Enrichment>();
		enrichmentMap = new HashMap<EnrichmentType, List<ContentEnrichment>>();
		refContentEnrichList = new ArrayList<ContentEnrichment>();
		topicContentEnrichList = new ArrayList<ContentEnrichment>();
		notesContentEnrichList = new ArrayList<ContentEnrichment>();


		enrichList = enrichMapper.getAllEnrichments(new Integer(memberPersonaId
				.getStorageID()));

		if (enrichList != null && enrichList.size() > 0) {

			for (Enrichment enrichment : enrichList) {

				contentEnrichment = enrichment.getContentEnrich();

				if (contentEnrichment.getLinkType().equals(LinkType.TOC)) {

					topicContentEnrichList.add(contentEnrichment);

				} else if (contentEnrichment.getLinkType().equals(
						LinkType.REFERENCE)) {

					refContentEnrichList.add(contentEnrichment);

				} else if (contentEnrichment.getLinkType().equals(
						LinkType.ADDITIONAL_INFO)) {

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
	public List<LearningComponentContentHotspot> getCompContentHotspotList(
			LearningComponentContent compContent) throws CourseException {

		List<LearningComponentContentHotspot> hotspotList = null;


		hotspotList = new ArrayList<LearningComponentContentHotspot>();

		hotspotList = hotspotMapper.getHotspotList(Integer.valueOf(compContent
				.getLearningComponentContentId().getStorageID()));

		return hotspotList;

	}

	@Override
	public List<LearningContent> basicSearchReferences(
			ReferenceSearchCriteria searchCriteria) throws CourseException {

		List<LearningContent> contents = null;


		contents = enrichMapper.basicSearchReferenceMaterial(searchCriteria);

		LOGGER.debug("Enrichments(Reference)  list size : " + contents.size());

		return contents;
	}

	@Override
	public List<LearningContent> advanceSearchReferences(
			ReferenceSearchCriteria searchCriteria) throws CourseException {

		List<LearningContent> contents = null;


		contents = enrichMapper.advanceSearchReferenceMaterial(searchCriteria);

		LOGGER.debug("Enrichments(Reference)  list size : " + contents.size());

		return contents;
	}

	@Transactional
	@Override
	public void saveHotspot(LearningComponentContentHotspot hotspot)
			throws CourseException {

		LearningComponentContent compContent = null;


		compContent = hotspot.getLearningComponentContent();

		if (compContent.getLearningComponentContentId() != null) {

			LOGGER.debug("Before Saving LearningComponentContentHotspot .. ");
			hotspotMapper.save(hotspot);

		}
	}

	@Override
	public void deleteHotspot(LearningComponentContentHotspot hotspot)
			throws CourseException {
		LearningComponentContent compContent = null;


		compContent = hotspot.getLearningComponentContent();

		if (compContent.getLearningComponentContentId() != null) {

			LOGGER.debug("Before Saving LearningComponentContentHotspot .. ");

			Integer hotspotId = new Integer(hotspot
					.getComponentContentHotspotId().getStorageID());

			hotspotMapper.delete(hotspotId);

		}

	}

	@Override
	public void updateHotspot(LearningComponentContentHotspot hotspot)
			throws CourseException {

		LearningComponentContent compContent = null;


		compContent = hotspot.getLearningComponentContent();

		if (compContent.getLearningComponentContentId() != null) {

			LOGGER.debug("Before Saving LearningComponentContentHotspot .. ");

			hotspotMapper.update(hotspot);

		}

	}

}
