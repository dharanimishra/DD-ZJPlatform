package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Select;
import com.ziksana.domain.course.CourseLearningPlanner;

/**
 * @author bhashasp
 */
public interface PlannerMapper {
	
	

	/**
	 * Saves the course/CourseLearningComponent's Learning Planner
	 * @param courseLearningPlanner
	 */
	void saveCourseLearningPlanner(CourseLearningPlanner courseLearningPlanner);

	
	/**
	 * Checks Learning Planner for either Course or CourseLearningComponent 
	 * @param courseId
	 * @param courseLearningCompoentId
	 * @return
	 */
	@Select({"select count(*) from corcourselearningplanner where " +
			"courseid = #{courseId,jdbcType=INTEGER} or coursecomponentplannerid = #{courseLearningComponentId,jdbcType=INTEGER}"})
	int isPlannerExists(Integer courseId, Integer courseLearningComponentId);

}
