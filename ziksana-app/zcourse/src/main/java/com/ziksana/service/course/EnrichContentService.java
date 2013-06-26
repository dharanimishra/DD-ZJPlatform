/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.ContentDecorationType;
import com.ziksana.domain.course.ContentEnrichment;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentContentEnrichment;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.member.MemberPersona;

/**
 * @author Arvind
 * 
 */
public interface EnrichContentService {
	public List<LearningContent> getLearningContents(Integer authMemberRoleId);

	public LearningContent getLearningContent(Integer learningContentId);
	
	public LearningComponentContent getLearningComponentContent(Integer learningComponentContentId);
	
	public LearningComponentContent getLearningComponentContent(Integer learningComponentId, Integer learningContentId);

	public Course getCourse(Integer courseId);

	public boolean isModuleExist(Integer courseId);

	public LearningContent createLearningContent(
			LearningContent learningContent,
			List<ContentDecorationType> contentDecorationTypeList, MemberPersona creator,
			Integer learningComponentId, LearningContent previousLearningContent);
	
	public ContentEnrichment saveContentEnrichment(Course course, LearningComponentContent learningComponentContent, ContentEnrichment contentEnrichment, MemberPersona creator); 
	public ContentEnrichment updateContentEnrichment(LearningComponentContent learningComponentContent, ContentEnrichment contentEnrichment); 
	public void deleteContentEnrichment(LearningComponentContent learningComponentContent, Integer contentEnrichmentId); 
	public ContentEnrichment getContentEnrichment(Integer contentEnrichmentId); 
	public List<LearningComponentContentEnrichment> getLearningComponentContentEnrichments(LearningComponentContent learningComponentContent); 
}
