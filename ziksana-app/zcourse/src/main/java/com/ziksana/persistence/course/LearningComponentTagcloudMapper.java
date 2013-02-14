package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.CourseTagcloud;

public interface LearningComponentTagcloudMapper {
	/**
	 * This saves the course tagcloud keys
	 * 
	 * @return
	 */
	CourseTagcloud save(CourseTagcloud tagCloud);

	/**
	 * @param integer
	 * @return
	 */
	@Select({ "select ID,tagname, tagtype, LearningComponentId,CourseId  from corlearningcomponenttagcloud where LearningComponentId = #{learningComponentId,jdbcType=INTEGER}  order by ID desc limit 1 " })
	@Results(value = {
			@Result(property = "tagCloudId", column = "ID"),
			@Result(property = "tagName", column = "tagname"),
			@Result(property = "tagType", column = "tagtype"),
			@Result(property = "learningComponentId", column = "LearningComponentId"),
			@Result(property = "courseId", column = "CourseId") })
	CourseTagcloud getComponentTagClouds(Integer learningComponentId,
			Integer courseId);

	/**
	 * This update / override the course tagcloud keys
	 * 
	 * @param courseTagcloud
	 */
	CourseTagcloud update(CourseTagcloud courseTagcloud);

}