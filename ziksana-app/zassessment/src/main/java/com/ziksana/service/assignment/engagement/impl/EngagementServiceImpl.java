package com.ziksana.service.assignment.engagement.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.assessment.engagement.Engagement;
import com.ziksana.domain.assessment.engagement.EngagementCriteria;
import com.ziksana.persistence.assessment.engagement.EngagementMapper;
import com.ziksana.service.assignment.engagement.EngagementService;

/**
 * @author ratneshkumar
 */
public class EngagementServiceImpl implements EngagementService {

	private static Logger LOGGER = LoggerFactory
			.getLogger(EngagementServiceImpl.class);

	@Autowired
	public EngagementMapper engagementMapper;

	public List<Engagement> getEngagementeRulesByCourseId(Integer courseId) {
		List<Engagement> engagementList = null;

		// Get Engagement Service
		engagementList = engagementMapper
				.getEngagementeRulesByCourseId(courseId);

		LOGGER.debug("Engagement Rules size : " + engagementList.size());

		return engagementList;
	}

	public void saveEngagement(Engagement engagement) {
		engagementMapper.saveEngagement(engagement);

	}

	public void saveCriteria(EngagementCriteria criteria) {
		// TODO Auto-generated method stub

	}

	public void updateCriteria(EngagementCriteria criteria) {
		engagementMapper.updateCriteria(criteria);

	}

	public void updateEngagement(Engagement engagement) {
		engagementMapper.updateEngagement(engagement);

	}

	public void deleteCriteria(Boolean isDelete, Integer engagementCriteriaId) {
		engagementMapper.deleteCriteria(isDelete, engagementCriteriaId);

	}

	public void deleteEngagement(Boolean isDelete, Integer engagementId) {
		engagementMapper.deleteEngagement(isDelete, engagementId);

	}

}
