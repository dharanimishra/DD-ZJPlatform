package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.CourseLearningComponent;

/**
 * @author bhashasp
 */
public interface CourseLearningComponentMapper {

	/**
	 * Saves the Course LearningComponent details
	 * @param courseLComponent
	 * @return
	 */
	Integer saveCourseLearningComponent(CourseLearningComponent courseLComponent);
	
	/**
	 * Updates the Course LearningComponent details
	 * @param courseLComponent
	 * @return
	 */
	Integer updateCourseLearningComponent(CourseLearningComponent courseLComponent);

	/**
	 * @param courseId
	 * @return
	 */
	@Select({
			"select courselearningcomponentid, duration, durationunit, courseid, learningcomponentid, learningcomponenttypeid ",
			" from corcourselearningcomponent where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseLearningComponentId", column = "courselearningcomponentid"),
			@Result(property = "duration.duration", column = "duration"),
			@Result(property = "duration.durationUnit", column = "durationunit"),
			@Result(property = "course.courseId", column = "courseid"),
			@Result(property = "learningComponent.learningComponentId", column = "learningcomponentid"),
			@Result(property = "learningcomponentType.learningcomponentTypeId", column = "learningcomponentTypeId") })
	List<CourseLearningComponent> getCourseLearningComponentByCourse(Integer courseId);

}
