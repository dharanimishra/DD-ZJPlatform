/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.ContentDecorationType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDecoration;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.service.course.AssociateContentService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.EnrichContentService;
import com.ziksana.service.course.LearningComponentContentService;
import com.ziksana.service.course.LearningComponentService;
import com.ziksana.service.course.LearningContentDecorationService;
import com.ziksana.service.course.LearningContentService;

/**
 * @author Arvind
 *
 */
@Service
public class EnrichContentServiceImpl implements EnrichContentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(EnrichContentServiceImpl.class);

	@Autowired
	CourseService courseService;
	
	@Autowired
	LearningComponentContentService learningComponentContentService;
	
	@Autowired
	LearningContentService learningContentService;
	
	@Autowired
	LearningComponentService learningComponentService;
	
	@Autowired
	LearningContentDecorationService learningContentDecorationService;
	
	@Autowired
	AssociateContentService associateContentService;

	
	public List<LearningContent> getLearningContents(Integer authMemberRoleId) {
		return learningContentService.getUserContent(authMemberRoleId);
	}

	public LearningContent getLearningContent(Integer learningContentId) {
		return learningContentService.getLearningContent(learningContentId);
	}

	public Course getCourse(Integer courseId) {
		LOGGER.debug("In EnrichContentServiceImpl.getCourse()");
		return courseService.getCourseByCourseId(courseId);
	}

	public boolean isModuleExist(Integer courseId) {
		Integer result = courseService.isModuleExists(courseId);
		Boolean exists = false;
		if(result > 0){
			exists = true;
		}
		else{
			exists = false;
		}
		return exists;
	}

	public LearningContent createLearningContent(LearningContent learningContent, ContentDecorationType contentDecorationType, MemberPersona creator, Integer learningComponentId,Integer previousLearningContentId) {
		
		LearningContent previousLearningContent = learningContentService.getLearningContent(previousLearningContentId);
		learningContent.setLinkedLearningContent(previousLearningContent);
		LearningContent savedLearningContent =  learningContentService.saveOrUpdateLearningContent(learningContent);
		
		learningContentDecorationService.saveLearningContentDecoration(
				getLearningContentDecoration(learningContent.getId(), contentDecorationType, creator));
		associateContentService.updateAssociation(learningComponentId, previousLearningContentId, savedLearningContent.getId());
		LOGGER.debug("EnrichContentServiceImpl.createLearningContent() content created successfully " + learningContent + " for decoration type " + contentDecorationType);
		return savedLearningContent;
	}
	
	private LearningContentDecoration getLearningContentDecoration(Integer learningContentId, ContentDecorationType contentDecorationType, MemberPersona creator){
		LearningContentDecoration learningContentDecoration = new LearningContentDecoration();
		learningContentDecoration.setLearningContentId(learningContentId);
		learningContentDecoration.setContentDecorationType(contentDecorationType);
		learningContentDecoration.setActive(true);
		learningContentDecoration.setDelete(false);
		learningContentDecoration.setContentDecorationTypeId(contentDecorationType.getId());
		learningContentDecoration.setAuthoringMember(creator);
		learningContentDecoration.setAuthoringMemberRoleId(creator.getMemberRoleId());
		learningContentDecoration.setCreatedBy(creator.getMember().getFirstName() + " " + creator.getMember().getFirstName());
		learningContentDecoration.setRightsOwningMember(creator);
		learningContentDecoration.setRightsOwningMemberRoleId(creator.getMemberRoleId());
		return learningContentDecoration;
	}

}
