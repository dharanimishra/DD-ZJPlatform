package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.ziksana.domain.course.CourseLearningPlanner;

/**
 * @author bhashasp
 */
public interface PlannerMapper {
	
	

	/**
	 * Saves the course/CourseLearningComponent's Learning Planner
	 * @param courseLearningPlanner
	 */
	@Insert({"insert into corcourselearningplanner (startperiod, endperiod, starttime,endtime, duration, courseid)" +
			" values (#{startPeriod, jdbcType=DATE}, #{endPeriod, jdbcType=DATE}, " +
			"#{startTime, jdbcType=TIMESTAMP}, #{endTime, jdbcType=TIMESTAMP}, " +
			"#{duration.duration, jdbcType=INTEGER}, #{course.courseId, jdbcType=INTEGER}) "})
	@SelectKey(keyProperty = "courselearningplannerid", before = true, resultType = int.class, statement = { "select last_insert_id" })
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
