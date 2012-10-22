package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.id.ZID;


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
	
	
	@Select({"select * from corcoursetagcloud where courseid = #{courseId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	List<CourseTagcloud> getCourseTagClouds(ZID courseId);

	
	@Update({"update corcoursetagcloud set  where coursetagid = #{courseTagCloudId,jdbcType.INTEGER}"
	})
	void update(CourseTagcloud courseTagcloud);

}