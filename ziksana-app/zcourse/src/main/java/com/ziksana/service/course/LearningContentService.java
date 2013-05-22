/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.LearningContent;

/**
 * @author Ratnesh Kumar
 * 
 */
public interface LearningContentService {

	public Content getContent(Integer contentId);

	/**
	 * This method retrieves the list of learning contents for the
	 * AuthoringMemberRoleId i.e. author of content
	 * 
	 * @param memberId
	 * @return
	 */
	public List<LearningContent> getUserContent(Integer memberId);

	/**
	 * Returns the learningContent object for the specified id
	 * 
	 * @param learningContentId
	 * @return
	 */
	public LearningContent getLearningContent(Integer learningContentId);

	/**
	 * 
	 * @param learningContent
	 */
	public void saveOrUpdateLearningContent(LearningContent learningContent);

	/**
	 * Mark as deleted soft delete only
	 * 
	 * @param learningContentId
	 */
	public void deleteLearningContent(Integer learningContentId);

}
