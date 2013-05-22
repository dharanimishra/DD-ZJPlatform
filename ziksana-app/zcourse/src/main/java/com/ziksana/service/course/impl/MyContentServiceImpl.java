/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.course.LearningContent;
import com.ziksana.service.course.LearningContentService;
import com.ziksana.service.course.MyContentService;

/**
 * @author Ratnesh Kumar
 * 
 */
public class MyContentServiceImpl implements MyContentService {

	@Autowired
	LearningContentService learningContentService;

	public List<LearningContent> getMyContents(Integer authMemberRoleId) {

		return learningContentService.getUserContent(authMemberRoleId);
	}

	public LearningContent getContent(Integer learningContentId) {

		return learningContentService.getLearningContent(learningContentId);
	}

	public void saveOrUpdate(LearningContent learningContent) {
		learningContentService.saveOrUpdateLearningContent(learningContent);

	}

	public void deleteContent(Integer learningContentId) {
		learningContentService.deleteLearningContent(learningContentId);
	}

}
