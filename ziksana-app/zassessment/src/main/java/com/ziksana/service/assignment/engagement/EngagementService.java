package com.ziksana.service.assignment.engagement;

import java.util.List;

import com.ziksana.domain.assessment.engagement.Engagement;
import com.ziksana.domain.assessment.engagement.EngagementCriteria;

/**
 * @author ratneshkumar
 */
public interface EngagementService {

	List<Engagement> getEngagementeRulesByCourseId(Integer courseId);

	void saveEngagement(Engagement engagement);

	void saveCriteria(EngagementCriteria criteria);

	void updateCriteria(EngagementCriteria criteria);

	void updateEngagement(Engagement engagement);

	void deleteCriteria(Boolean isDelete, Integer engagementCriteriaId);

	void deleteEngagement(Boolean isDelete, Integer engagementId);

}
