/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.LearningContent;

/**
 * @author Ratnesh Kumar
 * 
 */
public interface MyContentService {

	public List<LearningContent> getMyContents(Integer authMemberRoleId);

	public LearningContent getContent(Integer learningContentId);

	public void saveOrUpdate(LearningContent learningContent);

	public void deleteContent(Integer learningContentId);
	
	
}
