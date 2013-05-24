package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.ComponentContentType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.service.course.AssociateContentService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.LearningComponentContentService;
import com.ziksana.service.course.LearningContentService;


@Service
public class AssociateContentServiceImpl implements AssociateContentService {

	
	@Autowired
	CourseService courseService;
	
	@Autowired
	LearningComponentContentService learningComponentContentService;
	
	@Autowired
	LearningContentService learningContentService;
	
	
	
	public List<LearningContent> getLearningContents(Integer authMemberRoleId) {
		return learningContentService.getUserContent(authMemberRoleId);
	}

	public LearningContent getLearningContent(Integer learningContentId) {
		return learningContentService.getLearningContent(learningContentId);
	}


	public void associateContents(Integer authMemberRoleId, Integer courseId, Integer learningComponentId, String learningContentsToBeAssociated) {
		List<LearningComponentContent> learningComponentContents = getLearningComponentContents(authMemberRoleId, courseId, learningComponentId, learningContentsToBeAssociated);
		learningComponentContentService.saveLearningComponentContents(learningComponentContents);
		
	}

	public Course getCourse(Integer courseId) {
		return courseService.getCourseByCourseId(courseId);
	}
	/**
	 * A helper method to get learning component content objects
	 * @param courseId
	 * @param learningComponentId
	 * @param learningContentsToBeAssociated
	 * @return
	 */
	private List<LearningComponentContent> getLearningComponentContents(Integer authMemberRoleId, Integer courseId, Integer learningComponentId, String learningContentsToBeAssociated){
		
		String[] contentIdArray = learningContentsToBeAssociated.split(",");
		
		List<LearningComponentContent> learningComponentContentList = new ArrayList<LearningComponentContent>();
		
		Course course = getCourse(courseId);
		LearningComponent learningComponent = null;//learningComponentService.getLearningComponent(learningComponentId);
		
		for (String stringContentId : contentIdArray) {
			
			LearningContent learningContent = getLearningContent(Integer.parseInt(stringContentId));
			LearningComponentContent learningComponentContent = new LearningComponentContent();
			learningComponentContent.setActive(true);
			learningComponentContent.setCompContentType(ComponentContentType.PREVIEW_CONTENT);
			learningComponentContent.setCompContentTypeId(ComponentContentType.PREVIEW_CONTENT.getID());
			learningComponentContent.setContentDescription(learningContent.getContentDescription());
			learningComponentContent.setCourseStatus(course.getCourseStatus());
			learningComponentContent.setCourseStatusId(course.getCourseStatus().getID());
			
			//componentContent.setCreatedBy(memberId);
			learningComponentContent.setCreatedOn(new Date());
			learningComponentContent.setCreationDate(new Date());
			learningComponentContent.setLearningComponent(learningComponent);
			learningComponentContent.setBaseLearningContent(learningContent);
			//set learning component content details
			//componentContent.setModifiedBy(modifiedBy);
			learningComponentContent.setModifiedOn(new Date());
			//componentContent.setSynchronizeWithVideo(synchronizeWithVideo);
			learningComponentContentList.add(learningComponentContent);
		}
		
		
		
		return learningComponentContentList;
	}

	public void unAssociateContent(Integer learningComponentId, Integer learningContentId) {
		LearningComponentContent learningComponentContent = learningComponentContentService.getLearningComponentContent(learningComponentId, learningContentId);
		learningComponentContent.setDeleted(true);
		learningComponentContentService.deleteLearningComponentContent(learningComponentContent);
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

}
