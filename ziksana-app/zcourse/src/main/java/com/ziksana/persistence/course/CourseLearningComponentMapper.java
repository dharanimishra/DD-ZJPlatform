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
			"select ID, duration, courseid, learningcomponentid, learningcomponenttypeid ",
			" from corcourselearningcomponent where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseLearningComponentId", column = "courselearningcomponentid"),
			@Result(property = "duration.duration", column = "duration"),
			@Result(property = "course.courseId.storageID", column = "courseid"),
			@Result(property = "learningComponent.learningComponentId.storageID", column = "learningcomponentid"),
			@Result(property = "learningComponentType.learningComponentTypeId.storageID", column = "learningcomponenttypeid") })
	List<CourseLearningComponent> getCourseLearningComponentByCourse(Integer courseId);

	/**
	 * @param courseId
	 * @return
	 */
	@Select({
			"select ID, duration,  courseid, learningcomponentid, learningcomponenttypeid ",
			" from corcourselearningcomponent where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseLearningComponentId", column = "courselearningcomponentid"),
			@Result(property = "learningComponent.learningComponentId", column = "learningcomponentid")
			 })
	List<CourseLearningComponent> getBaseCourseLearningComponentsByCourse(Integer courseId);

}
