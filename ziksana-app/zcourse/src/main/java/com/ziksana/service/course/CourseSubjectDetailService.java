/**
 * 
 */
package com.ziksana.service.course;

import java.util.Map;

/**
 * @author ratneshkumar Dec 15, 2012
 * 
 * 
 */
public interface CourseSubjectDetailService {

	Map<String, String> getSubjectCategory();

	Map<String, String> getSubjectArea(String subjectArea);

	Map<String, String> getSubjectTopic(String subjectTopic);

}
