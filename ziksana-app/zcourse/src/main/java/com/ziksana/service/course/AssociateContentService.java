package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;

public interface AssociateContentService {
	
	
	public List<LearningContent> getLearningContents(Integer authMemberRoleId);

	public LearningContent getLearningContent(Integer learningContentId);

	public void associateContents(Integer authMemberRoleId, Integer courseId, Integer learningComponentId, String learningContentsToBeAssociated);
	
	/**
	 * This method un-associates the component to content association by marking as deleted.
	 * @param learningComponentId
	 * @param learningContentId
	 */
	public void unAssociateContent(Integer learningComponentId, Integer learningContentId);
	
	public Course getCourse(Integer courseId);
	
	public boolean isModuleExist(Integer courseId);
	
	/**
	 * This method 
	 * 1. finds the old association and then marks it as deleted.
	 * 2. Makes a deep copy of old {@link LearningComponentContent} and then updates the copied object with
	 * new content id. it also makes the id as null so as to create a new {@link LearningComponentContent}
	 * 
	 * @param learningComponentId
	 * @param previousLearningContentId
	 * @param newLearningContentId
	 */
	public void updateAssociation(Integer learningComponentId, Integer previousLearningContentId, Integer newLearningContentId);
}
