/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.LearningContent;

/**
 * @author prabu
 *
 */
public interface ContentService {
	
	public Content getContent(Integer contentId);
	
	/**
	 * This method retrieves the list of learning contents for the AuthoringMemberRoleId 
	 * i.e. author of content
	 * @param memberId
	 * @return
	 */
	public List<LearningContent> getUserContent(Integer memberId);

	/**
	 * Returns the learningcontent object for the specified id
	 * @param learningContentId
	 * @return
	 */
	public LearningContent getLearningContent(Integer learningContentId);

}
