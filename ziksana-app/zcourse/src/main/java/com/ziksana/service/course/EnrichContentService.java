/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.ContentDecorationType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.member.MemberPersona;

/**
 * @author Arvind
 *
 */
public interface EnrichContentService {
	public List<LearningContent> getLearningContents(Integer authMemberRoleId);

	public LearningContent getLearningContent(Integer learningContentId);

	public Course getCourse(Integer courseId);
	
	public boolean isModuleExist(Integer courseId);
	
	public LearningContent createLearningContent(LearningContent learningContent, ContentDecorationType contentDecorationType, MemberPersona creator,Integer learningComponentId,Integer previousLearningContentId);
}
