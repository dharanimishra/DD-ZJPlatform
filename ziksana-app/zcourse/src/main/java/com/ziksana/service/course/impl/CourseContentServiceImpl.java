package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDeleteType;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.persistence.course.LearningComponentContentMapper;
import com.ziksana.persistence.course.LearningContentMapper;
import com.ziksana.service.course.CourseContentService;

/**
 * @author ratneshkumar
 */
@Service
public class CourseContentServiceImpl implements CourseContentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseContentServiceImpl.class);

	@Autowired
	public LearningComponentContentMapper compContentMapper;
	@Autowired
	public LearningContentMapper contentMapper;

	@Transactional
	public void saveOrUpdateContent(
			final LearningComponentContent learningComponentContent)
			throws CourseException {

		List<LearningContentParts> contentParts = null;
		LearningContent learningContent = null;

		learningContent = learningComponentContent.getBaseLearningContent();

		// UPDATE OPERATION
		if (learningComponentContent.getLearningComponentContentId() != null) {

			LOGGER.debug("Before UPDATING the LearningComponentContent ...");
			compContentMapper
					.updateLearningComponentContent(learningComponentContent);
			LOGGER.debug("After UPDATING the LearningComponentContent ...: "
					+ learningComponentContent.toString());

			LOGGER.debug("Before UPDATING the LearningContent ...");
			contentMapper.updateContent(learningContent);
			LOGGER.debug("After UPDATING the LearningContent ID...:"
					+ learningContent.getLearningContentId());

			contentParts = learningContent.getAllLearningContentParts();

			// Save Or Updates the LearningContentParts
			saveOrUpdateContentParts(learningContent, contentParts);

		} else { // SAVE OPERATION

			LOGGER.debug("Before saving the LearningContent ...");

			contentMapper.saveContent(learningContent);

			LOGGER.debug("After saving the LearningContent ID...:"
					+ learningContent.getLearningContentId());

			learningComponentContent.setBaseLearningContent(learningContent);

			LOGGER.debug("Before saving the LearningComponentContent ...");
			compContentMapper
					.saveLearningComponentContent(learningComponentContent);
			LOGGER.debug("After saving the LearningComponentContent ...: "
					+ learningComponentContent.getLearningComponentContentId());

			contentParts = learningContent.getAllLearningContentParts();

			// Save Or Updates the LearningContentParts
			saveOrUpdateContentParts(learningContent, contentParts);
		}

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
					contentMapper.updateContentParts(learningContentParts);
				} else {
					contentMapper.saveContentParts(learningContentParts);
				}
			}
		}

	}

	public LearningComponentContent getLearningComponentContent(
			Integer learningComponentId) throws CourseException {

		LearningComponentContent lCompContent = null;
		Boolean isDelete = false;

		lCompContent = compContentMapper.getLearningComponentContentDetails(
				learningComponentId, isDelete);

		if (lCompContent != null) {

			LOGGER.debug("LearningComponentContent details : "
					+ lCompContent.toString());

			return lCompContent;

		}
		return null;
	}

	public List<LearningComponentContent> searchLearningComponentContent(
			String searchCriteria, LearningComponentContent compContent)
			throws CourseException {
		return null;
	}

	@Transactional
	public void enhaceContent(LearningComponentContent compContent)
			throws CourseException {

		LearningContent learningContent = null;
		List<LearningContentParts> contentPartsList = null;

		// Enhanced LearningContent
		learningContent = compContent.getBaseLearningContent();

		// associate parent content as a linked content
		learningContent.setLinkedLearningContent(learningContent);

		if (learningContent.getLearningContentId() != null) {
			LOGGER.debug("Before saving the LearningContent ");
			contentMapper.saveContent(learningContent);
			LOGGER.debug("After saving the LearningContent ID:"
					+ learningContent.getLearningContentId());
		} else {
			LOGGER.debug("Before UPDATING the LearningContent ");
			contentMapper.updateContent(learningContent);
		}

		contentPartsList = learningContent.getAllLearningContentParts();

		// SAVE OR UPDATES THE LEARNING CONTENT PARTS
		saveOrUpdateContentParts(learningContent, contentPartsList);

	}

	public List<LearningContent> getLearningContent(Integer memberRoleId)
			throws CourseException {

		List<LearningContent> contentList = null;

		contentList = new ArrayList<LearningContent>();

		LOGGER.debug("Member role ID : " + memberRoleId);

		contentList = contentMapper
				.getListOfContentsByMemberRoleId(memberRoleId);

		LOGGER.debug("Learning Content List : " + contentList.size());

		return contentList;
	}

	@Transactional
	public void deleteContent(LearningContentDeleteType deleteType,
			final Integer learningContentId) throws CourseException {

		final Boolean isDelete = true;
		List<Integer> learningContentIdList = null;

		LOGGER.debug("Learning Content Delete Params {:DeleteType :"
				+ deleteType + " , LearningContent ID : " + learningContentId);

		if (deleteType.getID() == 1) {

			contentMapper.deleteContent(isDelete, learningContentId);

		} else if (deleteType.getID() == 2) {

			learningContentIdList = contentMapper
					.getLearningContetPartsByContentId(learningContentId);

			for (Integer learningContentPartsId : learningContentIdList) {

				contentMapper.deleteContentParts(isDelete,
						learningContentPartsId);

			}

		} else if (deleteType.getID() == 3) {

			learningContentIdList = contentMapper
					.getLearningContetPartsByContentId(learningContentId);

			for (Integer learningContentPartsId : learningContentIdList) {

				contentMapper.deleteContentParts(isDelete,
						learningContentPartsId);

			}
			contentMapper.deleteContent(isDelete, learningContentId);
		}

	}

	@Transactional
	public void saveOrUpdateLearningContent(
			final LearningContent learningContent) throws CourseException {

		List<LearningContentParts> contentParts = null;

		try {
			// UPDATE OPERATION
			if (learningContent.getLearningContentId() != null) {

				LOGGER.debug("Before UPDATING the LearningContent ...");
				contentMapper.updateContent(learningContent);
				LOGGER.debug("After UPDATING the LearningContent ID...:"
						+ learningContent.getLearningContentId());

				contentParts = learningContent.getAllLearningContentParts();

				// Save Or Updates the LearningContentParts
				saveOrUpdateContentParts(learningContent, contentParts);

			} else { // SAVE OPERATION

				LOGGER.debug("Before saving the LearningContent ...");

				contentMapper.saveContent(learningContent);

				contentParts = learningContent.getAllLearningContentParts();

				// Save Or Updates the LearningContentParts
				saveOrUpdateContentParts(learningContent, contentParts);
			}
		} catch (Exception e) {
			LOGGER.error("Class :"
					+ getClass()
					+ " : Method :saveOrUpdateLearningContent(LearningContent learningContent)"
					+ e);
			//throw new ZiksanaException(ZiksanaConstants.COMMON_ERROR_MESSAGE, e) {
			//};
		}
	}
}
