package com.ziksana.persistence.course;

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
			"learningcomponentoveriddenindicator, durationunit, courseid, learningcomponentid, learningcomponenttypeid )",
			"values (sysdate(), ",
			"#{usageStartDate,jdbcType=TIMESTAMP}, ",
			"#{usageEndDate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, ",
			"#{weightage,jdbcType=INTEGER}, ",
			"#{totalCredits,jdbcType=INTEGER}, ",
			"#{extraCredits,jdbcType=INTEGER}, #{duration,jdbcType=INTEGER},#{isLearningComponentOveridden,jdbcType=BIT}, ",
			"#{durationUnit,jdbcType=INTEGER}, #{courseId,jdbcType=INTEGER}, #{learningComponentId,jdbcType=INTEGER}, #{learningComponentTypeId,jdbcType=INTEGER}, " })
	void save(CourseLearningComponent courseLComponent);

	@Select({
			"select courseLearningComponentId, duration, durationunit, courseid, learningcomponentid, learningcomponentTypeid ",
			" from corcourselearningcomponent where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseLearningComponentId", column = "courselearningcomponentid"),
			@Result(property = "duration.duration", column = "duration"),
			@Result(property = "duration.durationUnit", column = "durationunit"),
			@Result(property = "course.courseId", column = "courseid"),
			@Result(property = "learningComponent.learningComponentId", column = "learningcomponentid"),
			@Result(property = "learningcomponentType.learningcomponentTypeId", column = "learningcomponentTypeId") })
	CourseLearningComponent getComponentByCourse(Integer courseId);

}
