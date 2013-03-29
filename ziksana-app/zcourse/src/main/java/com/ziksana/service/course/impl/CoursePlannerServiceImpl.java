package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final static Logger LOGGER = LoggerFactory
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
		} else {
			// TODO what to do? Ideally we should not reach this method if we do
			// not have any course learning planner to save
		}

	}

}
