/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.EnrichContentService;
import com.ziksana.service.course.LearningComponentContentService;
import com.ziksana.service.course.LearningComponentService;
import com.ziksana.service.course.LearningContentService;

/**
 * @author Arvind
 *
 */
@Service
public class EnrichContentServiceImpl implements EnrichContentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(EnrichContentServiceImpl.class);

	@Autowired
	CourseService courseService;
	
	@Autowired
	LearningComponentContentService learningComponentContentService;
	
	@Autowired
	LearningContentService learningContentService;
	
	@Autowired
	LearningComponentService learningComponentService;
	

	
	public List<LearningContent> getLearningContents(Integer authMemberRoleId) {
		return learningContentService.getUserContent(authMemberRoleId);
	}

	public LearningContent getLearningContent(Integer learningContentId) {
		return learningContentService.getLearningContent(learningContentId);
	}

	public Course getCourse(Integer courseId) {
		LOGGER.debug("In EnrichContentServiceImpl.getCourse()");
		return courseService.getCourseByCourseId(courseId);
	}

	public boolean isModuleExist(Integer courseId) {
		Integer result = courseService.isModuleExists(courseId);
		Boolean exists = false;
		if(result > 0){
			exists = true;
		}
		else{
			exists = false;
		}
		return exists;
	}

}
