package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.persistence.course.LearningContentMapper;
import com.ziksana.service.course.LearningContentService;

@Service
public class LearningContentServiceImpl implements LearningContentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(LearningContentServiceImpl.class);

	@Autowired
	LearningContentMapper learningContentMapper;

	public Content getContent(Integer contentId) {
		// TODO Auto-generated method stub
		return learningContentMapper.getContent(contentId);
	}

	public List<LearningContent> getUserContent(Integer memberId) {
		LOGGER.info("Entering Class :" + getClass()
				+ " Method Name :getUserContent(Integer memberId)");

		// List<LearningContent> list =
		// learningContentMapper.getListOfContentsByMemberRoleId(207);
		List<LearningContent> list = learningContentMapper
				.getUserContent(memberId);

		LOGGER.info("Exiting Class :" + getClass()
				+ " Method Name :getUserContent(Integer memberId)");

		return list;
	}

	public LearningContent getLearningContent(Integer learningContentId) {
		return learningContentMapper.getLearningContent(learningContentId);
	}

	@Transactional
	public LearningContent saveOrUpdateLearningContent(
			final LearningContent learningContent) {

		List<LearningContentParts> contentParts = null;

		try {
			// UPDATE OPERATION
			if (learningContent.getLearningContentId() != null) {

				LOGGER.debug("Before UPDATING the LearningContent ...");
				learningContentMapper.updateContent(learningContent);
				LOGGER.debug("After UPDATING the LearningContent ID...:"
						+ learningContent.getLearningContentId());

				contentParts = learningContent.getAllLearningContentParts();

				// Save Or Updates the LearningContentParts
				saveOrUpdateContentParts(learningContent, contentParts);

			} else { // SAVE OPERATION

				LOGGER.debug("Before saving the LearningContent ...");

				learningContentMapper.saveContent(learningContent);

				contentParts = learningContent.getAllLearningContentParts();

				// Save Or Updates the LearningContentParts
				saveOrUpdateContentParts(learningContent, contentParts);
			}
		} catch (Exception e) {
			LOGGER.error("Class :"
					+ getClass()
					+ " : Method :saveOrUpdateLearningContent(LearningContent learningContent)"
					+ e);
			// throw new ZiksanaException(ZiksanaConstants.COMMON_ERROR_MESSAGE,
			// e) {
			// };
		}
		return learningContent;
	}

	/**
	 * Saves/Updates the LearningContentParts.
	 * 
	 * @param baseLearningContent
	 * @param contentParts
	 */
	private void saveOrUpdateContentParts(
			final LearningContent baseLearningContent,
			final List<LearningContentParts> contentParts) {

		if (contentParts != null) {

			LOGGER.debug("Learning Content Parts list size ::"
					+ contentParts.size());

			for (LearningContentParts learningContentParts : contentParts) {

				learningContentParts.setLearningContent(baseLearningContent);

				if (learningContentParts.getLearningContent() != null) {
					learningContentMapper
							.updateContentParts(learningContentParts);
				} else {
					learningContentMapper
							.saveContentParts(learningContentParts);
				}
			}
		}

	}

	public void deleteLearningContent(Integer learningContentId) {
		// TODO Auto-generated method stub

	}

}
