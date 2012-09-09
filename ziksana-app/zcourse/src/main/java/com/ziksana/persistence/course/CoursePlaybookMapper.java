package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CoursePlaybook;

public interface CoursePlaybookMapper {
	/**
	 * . This method corresponds to the database table corcourseplaybook
	 */
	@Delete({ "delete from corcourseplaybook",
			"where courseplaybookid = #{coursePlaybookId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer coursePlaybookId);

	/**
	 * . This method corresponds to the database table corcourseplaybook
	 */
	@Insert({
			"insert into corcourseplaybook (courseplaybookid, startdate, ",
			"enddate, courseplaybookstatus, courseplaybooktype, courseid)",
			"values (#{coursePlaybookId,jdbcType=INTEGER}, #{startDate,jdbcType=DATE}, ",
			"#{endDate,jdbcType=DATE}, #{coursePlaybookStatus,jdbcType=INTEGER},",
			"#{coursePlaybookType,jdbcType=INTEGER}, #{courseId,jdbcType=INTEGER})" })
	@SelectKey(statement = "select last_insert_id()", keyProperty = "coursePlaybookId", before = true, resultType = Integer.class)
	int insert(CoursePlaybook record);

	/**
	 * . This method corresponds to the database table corcourseplaybook
	 */
	int insertSelective(CoursePlaybook record);

	/**
	 * . This method corresponds to the database table corcourseplaybook
	 */
	@Select({ "select", "courseplaybookid, startdate, enddate, courseplaybookstatus, courseplaybooktype, courseid",
			"from corcourseplaybook where courseplaybookid = #{coursePlaybookId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CoursePlaybook selectByPrimaryKey(Integer coursePlaybookId);

	/**
	 * . This method corresponds to the database table corcourseplaybook
	 */
	int updateByPrimaryKeySelective(CoursePlaybook record);

	/**
	 * . This method corresponds to the database table corcourseplaybook
	 */
	@Update({ "update corcourseplaybook",
			"set startdate = #{startDate,jdbcType=DATE},",
			"enddate = #{endDate,jdbcType=DATE},",
			"courseplaybookstatus = #{coursePlaybookStatus,jdbcType=INTEGER},",
			"courseplaybooktype = #{coursePlaybookType,jdbcType=INTEGER},",
			"courseid = #{courseId,jdbcType=INTEGER}",
			"where courseplaybookid = #{coursePlaybookId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CoursePlaybook record);
}