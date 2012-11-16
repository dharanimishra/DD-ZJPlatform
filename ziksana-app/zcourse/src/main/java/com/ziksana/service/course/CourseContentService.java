package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDeleteType;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public interface CourseContentService {

	/**
	 * Saves/Updates  the learningcomponentcontent
	 * @param course
	 * @param contentType
	 * @param compContent
	 * @throws CourseException
	 */
	public void saveOrUpdateContent(Course course)	throws CourseException;
	
	/**
	 * Retrieves the LearningComponentContent details
	 * @param course
	 * @return
	 * @throws CourseException
	 */
	public LearningComponentContent getLearningComponentContent(Course course) throws CourseException;
	
	/**
	 * Searches the component contents by search criteria.
	 * @param searchCriteria
	 * @param compContent
	 * @return
	 * @throws CourseException
	 */
	public List<LearningComponentContent> searchLearningComponentContent(String searchCriteria, LearningComponentContent compContent) throws CourseException;

	/**
	 * Saves/Updates  the enhnced learningcomponentcontent. and links with the parent content
	 * @param course
	 * @param contentType
	 * @param compContent
	 * @throws CourseException
	 */
	public void enhaceContent(LearningComponentContent compContent)
			throws CourseException;
	
	/**
	 * Retrieve the list content based on MemberRoleId
	 * @param memberRoleId
	 * @return
	 * @throws CourseException
	 */
	public List<LearningContent> getLearningContent(Integer memberRoleId) throws CourseException;

	
	/**
	 * @param deleteType
	 * @param learningContentId
	 * @throws CourseException
	 */
	public void deleteContent(LearningContentDeleteType deleteType, ZID learningContentId) throws CourseException;
}
