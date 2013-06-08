/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContent;

/**
 * @author Arvind
 *
 */
public interface EnrichContentService {
	public List<LearningContent> getLearningContents(Integer authMemberRoleId);

	public LearningContent getLearningContent(Integer learningContentId);

	public Course getCourse(Integer courseId);
	
	public boolean isModuleExist(Integer courseId);
	

}
