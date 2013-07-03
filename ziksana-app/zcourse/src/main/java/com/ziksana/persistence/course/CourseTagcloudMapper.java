package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.CourseTagcloud;

public interface CourseTagcloudMapper {
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
	@Select({ "select ID as coursetagcloudid,tagname, tagtype, courseId  from corcoursetagcloud where courseid = #{courseId,jdbcType=INTEGER} limit 1" })
	@Results(value = {
			@Result(property = "tagCloudId", column = "coursetagcloudid"),
			@Result(property = "tagName", column = "tagname"),
			@Result(property = "tagType", column = "tagtype"),
			@Result(property = "courseId", column = "courseId") })
	CourseTagcloud getCourseTagClouds(Integer courseId);

	/**
	 * This update / override the course tagcloud keys
	 * 
	 * @param courseTagcloud
	 */
	CourseTagcloud update(CourseTagcloud courseTagcloud);

}