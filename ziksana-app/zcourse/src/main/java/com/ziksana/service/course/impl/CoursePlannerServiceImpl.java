package com.ziksana.service.course.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningPlanner;
import com.ziksana.exception.course.CourseException;
import com.ziksana.persistence.course.PlannerMapper;
import com.ziksana.service.course.CoursePlannerService;

/**
 * @author bhashasp
 */
public class CoursePlannerServiceImpl implements CoursePlannerService {

	private final static Logger LOGGER = Logger
			.getLogger(CoursePlannerServiceImpl.class);

	@Autowired
	public PlannerMapper plannerMapper;

	@Override
	public void saveCoursePlanner(Course course) throws CourseException {

		List<CourseLearningPlanner> plannerList = null;

		plannerList = course.getCourseLearningPlannerList();

		if (plannerList != null) {

			for (CourseLearningPlanner courseLearningPlanner : plannerList) {

				LOGGER.debug("Before Course Learning Planner save ...");
				plannerMapper.saveCourseLearningPlanner(courseLearningPlanner);

			}
		}

	}

}
