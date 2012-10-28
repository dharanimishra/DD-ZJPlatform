package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CourseTagcloud;


public interface CourseTagcloudMapper {
	/**
	 * This saves the course tagcloud keys
	 */
	@Insert({
			"insert into corcoursetagcloud (CreationDate, ",
			"TagName, TagType, ",
			"CourseId, ",
			"MemberRoleId)",
			"values (#{creationDate,jdbcType=TIMESTAMP}, ",
			"#{tagName,jdbcType=VARCHAR}, #{tagType,jdbcType=INTEGER}, ",
			"#{courseId,jdbcType=INTEGER}, ",
			"#{memberRoleId,jdbcType=INTEGER})" })
	void save(CourseTagcloud tagCloud);
	
	
	@Select({"select coursetagcloudid,tagname, tagtype, courseId,memberroleId  from corcoursetagcloud where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value={
			@Result(property="courseTagcloudId", column="coursetagcloudid"),
			@Result(property="tagName", column="tagname"),
			@Result(property="tagType", column="tagtype"),
			@Result(property="course.courseId", column="courseId"),
			@Result(property="creatingMember.memberRoleId", column="memberroleId")
	})
	List<CourseTagcloud> getCourseTagClouds(Integer integer);

	
	@Update({"update corcoursetagcloud set tagname=#{tagName, jdbcType=VARCHAR}, tagtype=#{tagType, jdbcType=INTEGER} ",
		" where coursetagid = #{courseTagCloudId,jdbcType.INTEGER}"
	})
	void update(CourseTagcloud courseTagcloud);

}