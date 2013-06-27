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
import com.ziksana.domain.course.ContentEnrichment;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentContentEnrichment;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDecoration;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.persistence.course.ContentEnrichmentMapper;
import com.ziksana.persistence.course.LearningComponentContentEnrichmentMapper;
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
	
	@Autowired
	LearningComponentContentEnrichmentMapper componentContentEnrichmentMapper;

	@Autowired
	ContentEnrichmentMapper contentEnrichmentMapper;
	
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

	public LearningComponentContent getLearningComponentContent(Integer learningComponentContentId){
		return learningComponentContentService.getLearningComponentContent(learningComponentContentId);
	}

	public LearningContent createLearningContent(LearningContent learningContent, List<ContentDecorationType> contentDecorationTypeList, MemberPersona creator, Integer learningComponentId,LearningContent previousLearningContent) {
		
		learningContent.setLinkedLearningContent(previousLearningContent);
		LearningContent savedLearningContent =  learningContentService.saveOrUpdateLearningContent(learningContent);
		
		for (ContentDecorationType contentDecorationType : contentDecorationTypeList) {
			learningContentDecorationService.saveLearningContentDecoration(
					getLearningContentDecoration(learningContent.getId(), contentDecorationType, creator));
		}
		
		associateContentService.updateAssociation(learningComponentId, previousLearningContent.getId(), savedLearningContent.getId());
		LOGGER.debug("EnrichContentServiceImpl.createLearningContent() content created successfully " + learningContent + " for decoration type " + contentDecorationTypeList);
		return savedLearningContent;
	}
	
	
	private LearningContentDecoration getLearningContentDecoration(Integer learningContentId, ContentDecorationType contentDecorationType, MemberPersona creator){
		LearningContentDecoration learningContentDecoration = new LearningContentDecoration();
		learningContentDecoration.setLearningContentId(learningContentId);
		learningContentDecoration.setContentDecorationType(contentDecorationType);
		learningContentDecoration.setContentDecorationTypeId(contentDecorationType.getId());
		learningContentDecoration.setActive(true);
		learningContentDecoration.setDelete(false);
		learningContentDecoration.setAuthoringMember(creator);
		learningContentDecoration.setAuthoringMemberRoleId(creator.getMemberRoleId());
		//learningContentDecoration.setCreatedBy(creator.getMember().getFirstName() + " " + creator.getMember().getFirstName());
		learningContentDecoration.setRightsOwningMember(creator);
		learningContentDecoration.setRightsOwningMemberRoleId(creator.getMemberRoleId());
		return learningContentDecoration;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.course.EnrichContentService#saveContentEnrichment(com.ziksana.domain.course.LearningComponentContent, com.ziksana.domain.course.ContentEnrichment)
	 */
	public ContentEnrichment saveContentEnrichment(
			Course course,
			LearningComponentContent learningComponentContent,
			ContentEnrichment contentEnrichment, MemberPersona creator) {
		contentEnrichmentMapper.saveContentEnrichment(contentEnrichment);
		componentContentEnrichmentMapper.saveLearningComponentContentEnrichment(
				getLearningComponentContentEnrichment(course, learningComponentContent, contentEnrichment, creator));
		return contentEnrichment;
	}
	
	private LearningComponentContentEnrichment getLearningComponentContentEnrichment(Course course,
			LearningComponentContent learningComponentContent,
			ContentEnrichment contentEnrichment, MemberPersona creator){
		LearningComponentContentEnrichment  componentContentEnrichment = new LearningComponentContentEnrichment();
		componentContentEnrichment.setActive(true);
		componentContentEnrichment.setContentEnrichment(contentEnrichment);
		componentContentEnrichment.setCourse(course);
		//componentContentEnrichment.setCurriculumCourse(curriculumCourse)
		componentContentEnrichment.setIsDelete(false);
		componentContentEnrichment.setLearningComponentContent(learningComponentContent);
		componentContentEnrichment.setCreatingMember(creator);
		return componentContentEnrichment;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.course.EnrichContentService#updateContentEnrichment(com.ziksana.domain.course.LearningComponentContent, com.ziksana.domain.course.ContentEnrichment)
	 */
	public ContentEnrichment updateContentEnrichment(
			LearningComponentContent learningComponentContent,
			ContentEnrichment contentEnrichment) {
		contentEnrichmentMapper.updateContentEnrichment(contentEnrichment);
		return contentEnrichment;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.course.EnrichContentService#deleteContentEnrichment(com.ziksana.domain.course.LearningComponentContent, java.lang.Integer)
	 */
	public void deleteContentEnrichment(
			LearningComponentContent learningComponentContent,
			Integer contentEnrichmentId) {
		contentEnrichmentMapper.deleteContentEnrichment(contentEnrichmentId);
		LOGGER.debug("The content enrichment deleted successfully for " + contentEnrichmentId);
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.course.EnrichContentService#getContentEnrichment(java.lang.Integer)
	 */
	public ContentEnrichment getContentEnrichment(Integer contentEnrichmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.course.EnrichContentService#getLearningComponentContentEnrichments(com.ziksana.domain.course.LearningComponentContent)
	 */
	public List<LearningComponentContentEnrichment> getLearningComponentContentEnrichments(
			LearningComponentContent learningComponentContent) {
		// TODO Auto-generated method stub
		return null;
	}

	public LearningComponentContent getLearningComponentContent(
			Integer learningComponentId, Integer learningContentId) {
		return learningComponentContentService.getLearningComponentContent(learningComponentId, learningContentId);
	}
	
	

}
