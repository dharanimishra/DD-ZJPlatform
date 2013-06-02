package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContent;

public interface AssociateContentService {
	
	
	public List<LearningContent> getLearningContents(Integer authMemberRoleId);

	public LearningContent getLearningContent(Integer learningContentId);

	public void associateContents(Integer authMemberRoleId, Integer courseId, Integer learningComponentId, String learningContentsToBeAssociated);
	
	public void unAssociateContent(Integer learningComponentId, Integer learningContentId);
	
	public Course getCourse(Integer courseId);
	
	public boolean isModuleExist(Integer courseId);
	
}
