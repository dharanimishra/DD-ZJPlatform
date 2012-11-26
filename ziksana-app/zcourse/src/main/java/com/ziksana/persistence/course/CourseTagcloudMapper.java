package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.CourseTagcloud;


public interface CourseTagcloudMapper {
	/**
	 * This saves the course tagcloud keys
	 */
	void save(CourseTagcloud tagCloud);
	
	
	/**
	 * @param integer
	 * @return
	 */
	@Select({"select coursetagcloudid,tagname, tagtype, courseId,memberroleId  from corcoursetagcloud where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value={
			@Result(property="courseTagcloudId", column="coursetagcloudid"),
			@Result(property="tagName", column="tagname"),
			@Result(property="tagType", column="tagtype"),
			@Result(property="course.courseId", column="courseId"),
			@Result(property="creatingMember.memberRoleId", column="memberroleId")
	})
	List<CourseTagcloud> getCourseTagClouds(Integer integer);

	
	/**
	 * This update / override the course tagcloud keys
	 * @param courseTagcloud
	 */
	void update(CourseTagcloud courseTagcloud);

}