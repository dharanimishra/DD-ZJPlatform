package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
	@Select({"select learningplannerid from corcourselearrningplanner where " +
			"courseid = #{courseId,jdbcType=INTEGER} or courselearningcompoentid = #{courseLearningCompoentId,jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property = "learningPlannerId", column = "learningplannerid"),
	})
	Integer isPlannerExists(Integer courseId, Integer courseLearningCompoentId);

}
