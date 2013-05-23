package com.ziksana.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.persistence.course.LearningComponentContentMapper;
import com.ziksana.service.course.LearningComponentContentService;

@Service
public class LearningComponentContentServiceImpl implements
		LearningComponentContentService {

	@Autowired
	LearningComponentContentMapper learningComponentContentMapper;
	
	public void saveLearningComponentContents(
			List<LearningComponentContent> learningComponentContents) {
		
		//TODO due to time constraints did this need to find a better solution
		for (LearningComponentContent learningComponentContent : learningComponentContents) {
			learningComponentContentMapper.saveLearningComponentContent(learningComponentContent);
		}
	}

	public void updateLearningComponentContent(
			LearningComponentContent learningComponentContent) {
		learningComponentContent.setDeleted(true);
		learningComponentContentMapper.updateLearningComponentContent(learningComponentContent);
	}

	public LearningComponentContent getLearningComponentContent(
			Integer learningComponentContentId) {
		// TODO Auto-generated method stub
		return learningComponentContentMapper.getLearningComponentContent(learningComponentContentId);
	}

	public LearningComponentContent getLearningComponentContent(
			Integer learningComponentId, Integer learningContentId) {
		// TODO Auto-generated method stub
		return learningComponentContentMapper.getLearningComponentContent(learningComponentId, learningContentId);
	}

}
