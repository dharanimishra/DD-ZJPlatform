package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.LearningComponentTagcloud;

public interface LearningComponentTagcloudMapper {
	/**
	 * This saves the course LearningComponentTagcloud keys
	 * 
	 * @return
	 */
	LearningComponentTagcloud save(
			LearningComponentTagcloud learningComponentTagcloud);

	/**
	 * @param integer
	 * @return
	 */
	@Select({ "select ID,tagname, tagtype, LearningComponentId  from corlearningcomponenttagcloud where LearningComponentId = #{learningComponentId,jdbcType=INTEGER}  order by ID desc limit 1" })
	@Results(value = {
			@Result(property = "tagCloudId", column = "ID"),
			@Result(property = "tagName", column = "tagname"),
			@Result(property = "tagType", column = "tagtype"),
			@Result(property = "learningComponentId", column = "LearningComponentId") })
	LearningComponentTagcloud getComponentTagClouds(Integer learningComponentId);

	/**
	 * This update / override the course tagcloud keys
	 * 
	 * @param LearningComponentTagcloud
	 */
	LearningComponentTagcloud update(
			LearningComponentTagcloud learningComponentTagcloud);

}