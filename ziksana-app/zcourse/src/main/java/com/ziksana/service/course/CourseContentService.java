package com.ziksana.service.course;

import java.util.List;
import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.exception.course.CourseException;

public interface CourseContentService {

	/**
	 * Saves/Updates  the learningcomponentcontent
	 * @param course
	 * @param contentType
	 * @param compContent
	 * @throws CourseException
	 */
	public void saveOrUpdateContent(Course course,
			ContentType contentType, LearningComponentContent compContent)
			throws CourseException;
	
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

}
