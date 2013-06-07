/**
 * 
 */
package com.ziksana.service.course.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.LearningContentDecoration;
import com.ziksana.persistence.course.LearningContentDecorationMapper;
import com.ziksana.service.course.LearningContentDecorationService;

/**
 * @author Arvind
 *
 */
@Service
public class LearningContentDecorationServiceImpl implements
		LearningContentDecorationService {
	
	private final static Logger LOGGER = LoggerFactory
			.getLogger(LearningContentServiceImpl.class);

	@Autowired
	private LearningContentDecorationMapper learningContentDecorationMapper;


	
	/* (non-Javadoc)
	 * @see com.ziksana.service.course.LearningContentDecorationService#saveLearningContentDecoration(com.ziksana.domain.course.LearningContentDecoration)
	 */
	public LearningContentDecoration saveLearningContentDecoration(
			LearningContentDecoration learningContentDecoration) {
		LearningContentDecoration learningContentDecorationSaved = learningContentDecorationMapper.saveContentDecoration(learningContentDecoration);
		LOGGER.debug("LearningContentDecorationServiceImpl.saveLearningContentDecoration() saved the learning content decoration " + learningContentDecorationSaved);
		return learningContentDecorationSaved;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.course.LearningContentDecorationService#updateLearningContentDecoration(com.ziksana.domain.course.LearningContentDecoration)
	 */
	public LearningContentDecoration updateLearningContentDecoration(
			LearningContentDecoration learningContentDecoration) {
		LearningContentDecoration learningContentDecorationUpdated = learningContentDecorationMapper.updateContentDecoration(learningContentDecoration);
		LOGGER.debug("LearningContentDecorationServiceImpl.updateContentDecoration() update the learningContentDecoration = " + learningContentDecoration);
		return learningContentDecorationUpdated;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.course.LearningContentDecorationService#getLearningContentDecoration(java.lang.Integer)
	 */
	public LearningContentDecoration getLearningContentDecoration(
			Integer learningContentDecorationId) {
		LearningContentDecoration learningContentDecoration = learningContentDecorationMapper.getLearningContentDecoration(learningContentDecorationId);  
		LOGGER.debug("LearningContentDecorationServiceImpl.getLearningContentDecoration() got the learningContentDecoration = " + learningContentDecoration);
		return learningContentDecoration;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.course.LearningContentDecorationService#markLearningContentDecorationAsDeleted(com.ziksana.domain.course.LearningContentDecoration)
	 */
	public LearningContentDecoration markLearningContentDecorationAsDeleted(
			LearningContentDecoration learningContentDecoration) {
		learningContentDecoration.setDelete(true);
		LearningContentDecoration learningContentDecorationDeleted = updateLearningContentDecoration(learningContentDecoration);
		LOGGER.debug("LearningContentDecorationServiceImpl.markLearningContentDecorationAsDeleted() marked the learningContentDecoration as deleted = " + learningContentDecoration);
		return learningContentDecorationDeleted;
	}

	
	
}
