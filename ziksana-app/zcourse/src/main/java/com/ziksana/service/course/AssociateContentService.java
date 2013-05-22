package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;

public interface AssociateContentService {
	
	
	public List<LearningContent> getLearningContents(Integer authMemberRoleId);

	public void associateContentToComponent(List<LearningComponentContent> learningComponentContents);

	public List<LearningContent> unAssociateContentFromComponent(LearningComponentContent learningComponentContent);

}
