package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.persistence.course.ContentMapper;
import com.ziksana.persistence.course.LearningContentMapper;
import com.ziksana.service.course.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(ContentServiceImpl.class);

	@Autowired
	ContentMapper contentMapper;

	@Autowired
	LearningContentMapper learningContentMapper;

	public Content getContent(Integer contentId) {
		// TODO Auto-generated method stub
		return contentMapper.getContent(contentId);
	}

	public List<LearningContent> getUserContent(Integer memberId) {
		LOGGER.info("Entering Class :" + getClass()
				+ " Method Name :getUserContent(Integer memberId)");

		// List<LearningContent> list =
		// learningContentMapper.getListOfContentsByMemberRoleId(207);
		List<LearningContent> list = contentMapper.getUserContent(memberId);

		LOGGER.info("Exiting Class :" + getClass()
				+ " Method Name :getUserContent(Integer memberId)");

		return list;
	}

	public LearningContent getLearningContent(Integer learningContentId) {
		return contentMapper.getLearningContent(learningContentId);
	}

}
