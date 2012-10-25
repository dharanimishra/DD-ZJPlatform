package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Insert;

import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public interface CourseLearningComponentMapper {
	

	@Insert({"insert into corcourselearningcomponent ( creationdate, usageStartDate, usageenddate, active, weightage, totalcredits, extracredits, duration, ",
	"learningcomponentoveriddenindicator, durationunit, courseid, learningcomponentid, learningcomponenttypeid )",
	"values (#{creationdate,jdbcType=TIMESTAMP}, ",
	"#{usageStartDate,jdbcType=TIMESTAMP}, ",
	"#{usageenddate,jdbcType=TIMESTAMP}, ",
	"#{active,jdbcType=BIT}, ",
	"#{weightage,jdbcType=INTEGER}, ",
	"#{totalcredits,jdbcType=INTEGER}, ",
	"#{extracredits,jdbcType=INTEGER}, #{duration,jdbcType=INTEGER},#{learningcomponentoveriddenindicator,jdbcType=BIT}, ",
	"#{durationunit,jdbcType=INTEGER}, #{courseid,jdbcType=INTEGER}, #{learningcomponentid,jdbcType=INTEGER}, #{learningcomponentTtypeid,jdbcType=INTEGER}, "})
	void save(CourseLearningComponent courseLComponent);

	CourseLearningComponent getComponentByCourse(ZID courseId);

	
}
