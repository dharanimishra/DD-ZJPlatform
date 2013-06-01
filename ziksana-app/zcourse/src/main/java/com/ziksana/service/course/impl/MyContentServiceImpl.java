/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.service.course.LearningContentService;
import com.ziksana.service.course.MyContentService;

/**
 * @author Ratnesh Kumar
 * 
 */
@Service
public class MyContentServiceImpl implements MyContentService {

	@Autowired
	LearningContentService learningContentService;

	public List<LearningContent> getMyContents(Integer authMemberRoleId) {

		return learningContentService.getUserContent(authMemberRoleId);
	}

	public LearningContent getContent(Integer learningContentId) {

		return learningContentService.getLearningContent(learningContentId);
	}

	public LearningContent saveOrUpdate(LearningContent learningContent) {
		return learningContentService
				.saveOrUpdateLearningContent(learningContent);

	}

	public void deleteContent(Integer learningContentId) {
		learningContentService.deleteLearningContent(learningContentId);
	}

	public boolean checkContentAssociation(Integer learningContentId) {
		LearningComponentContent learningComponentContent = learningContentService
				.checkContentAssociation(learningContentId);
		if (learningComponentContent.getId() > 0)
			return true;
		else
			return false;
	}
}
