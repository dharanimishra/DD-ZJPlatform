package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.CourseLearningComponent;

/**
 * @author bhashasp
 */
public interface CourseLearningComponentMapper {

	@Insert({
			"insert into corcourselearningcomponent ( creationdate, usageStartDate, usageenddate, active, weightage, totalcredits, extracredits, duration, ",
			"learningcomponentoveriddenindicator, durationunit, courseid, learningcomponentid, learningcomponenttypeid ) ",
			"values (sysdate(), ",
			"#{usageStartDate,jdbcType=TIMESTAMP}, ",
			"#{usageEndDate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, ",
			"#{weightage,jdbcType=INTEGER}, ",
			"#{totalCredits,jdbcType=INTEGER}, ",
			"#{extraCredits,jdbcType=INTEGER}, #{duration.duration,jdbcType=INTEGER},#{isLearningComponentOveridden,jdbcType=BIT}, ",
			"#{duration.durationUnits,jdbcType=INTEGER}, #{course.courseId,jdbcType=INTEGER}, #{learningComponent.learningComponentId,jdbcType=INTEGER}," +
			" #{learningComponentType.learningComponentTypeId,jdbcType=INTEGER} )" })
	void save(CourseLearningComponent courseLComponent);

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
	List<CourseLearningComponent> getComponentByCourse(Integer courseId);

}
