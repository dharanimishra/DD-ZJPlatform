package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CoursePlaybookView;

public interface CoursePlaybookViewMapper {

	/**
	 * This method corresponds to the database table corcourseplaybookview
	 */
	@Delete({ "delete from corcourseplaybookview",
			"where courseplaybookviewid = #{coursePlaybookViewId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer coursePlaybookViewId);

	/**
	 * This method corresponds to the database table corcourseplaybookview
	 */
	@Insert({
			"insert into corcourseplaybookview (courseplaybookviewid, playbookviewname, ",
			"deliverytype, layoutmarkuppath, ",
			"contentmarkuppath, creationdate, ",
			"courseplaybookstatus, brochurecontentpath, ",
			"recipientstudentmodel, courseplaybookid, ",
			"learningcomponentid)",
			"values (#{coursePlaybookViewId,jdbcType=INTEGER}, #{playbookViewName,jdbcType=VARCHAR}, ",
			"#{deliveryType,jdbcType=INTEGER}, #{layoutMarkupPath,jdbcType=VARCHAR}, ",
			"#{contentMarkupPath,jdbcType=VARCHAR}, #{creationDate,jdbcType=DATE}, ",
			"#{coursePlaybookStatus,jdbcType=INTEGER}, #{brochureContentPath,jdbcType=VARCHAR}, ",
			"#{recipientStudentModel,jdbcType=INTEGER}, #{CoursePlaybookId,jdbcType=INTEGER}, ",
			"#{LearningComponentId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "coursePlaybookViewId", before = true, resultType = Integer.class)
	int insert(CoursePlaybookView record);

	/**
	 * This method corresponds to the database table corcourseplaybookview
	 */
	int insertSelective(CoursePlaybookView record);

	/**
	 * This method corresponds to the database table corcourseplaybookview
	 */
	@Select({
			"select",
			"courseplaybookviewid, playbookviewname, deliverytype, layoutmarkuppath, contentmarkuppath, creationdate, ",
			"courseplaybookstatus, brochurecontentpath, recipientstudentmodel, courseplaybookid, ",
			"learningcomponentid", "from corcourseplaybookview",
			"where courseplaybookviewid = #{coursePlaybookViewId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CoursePlaybookView selectByPrimaryKey(Integer coursePlaybookViewId);

	/**
	 * This method corresponds to the database table corcourseplaybookview
	 */
	int updateByPrimaryKeySelective(CoursePlaybookView record);

	/**
	 * This method corresponds to the database table corcourseplaybookview
	 */
	@Update({
			"update corcourseplaybookview",
			"set playbookviewname = #{playbookViewName,jdbcType=VARCHAR},",
			"deliverytype = #{deliveryType,jdbcType=INTEGER},",
			"layoutmarkuppath = #{layoutMarkupPath,jdbcType=VARCHAR},",
			"contentmarkuppath = #{contentMarkupPath,jdbcType=VARCHAR},",
			"creationdate = #{creationDate,jdbcType=DATE},",
			"courseplaybookstatus = #{coursePlaybookStatus,jdbcType=INTEGER},",
			"brochurecontentpath = #{brochureContentPath,jdbcType=VARCHAR},",
			"recipientstudentmodel = #{recipientStudentModel,jdbcType=INTEGER},",
			"courseplaybookid = #{CoursePlaybookId,jdbcType=INTEGER},",
			"learningcomponentid = #{LearningComponentId,jdbcType=INTEGER}",
			"where courseplaybookviewid = #{coursePlaybookViewId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CoursePlaybookView record);
}