package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CoursePlaybook;
import com.ziksana.domain.course.CoursePlaybookView;

public interface CoursePlaybookMapper {

	Integer saveDefaultPlaybook(CoursePlaybook coursePlaybook);

	@Insert({
			"insert into corcourseplaybookview ",
			"(creationdate, playbookviewname, deliverytype, layoutmarkupPath, contentmarkupPath, " +
			"courseplaybookstatus, brochurecontentPath, recipientstudentmodel, courseplaybookid) ",
			"values (sysdate(), #{name,jdbcType=VARCHAR}, #{deliveryTypeId,jdbcType=INTEGER}, #{layoutPath,jdbcType=VARCHAR}, ",
			" #{contentPath,jdbcType=VARCHAR},#{coursePlaybookStatusId,jdbcType=INTEGER},#{brochurePath,jdbcType=VARCHAR},#{recStudentModelId,jdbcType=INTEGER},",
			" #{coursePlaybook.coursePlaybookId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "courseplaybookviewid", before = true, resultType = Integer.class)
	void savePlaybookView(CoursePlaybookView playbookView);

	@Select({
			"select courseplaybookid, validfrom, validto, courseplaybookstatus, courseplaybooktype, courseid ",
			"   from corcourseplaybook where courseplaybookid = #{coursePlaybookId, jdbcType=INTEGER} and isdelete=#{isDelete,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "coursePlaybookId", column = "courseplaybookid"),
			@Result(property = "fromDate", column = "validfrom"),
			@Result(property = "toDate", column = "validto"),
			@Result(property = "coursePBStatusId", column = "courseplaybookstatus"),
			@Result(property = "playbookTypeId", column = "courseplaybooktype"),
			@Result(property = "course.courseId", column = "courseid"),
			@Result(property = "playbookView", column = "courseplaybookid", javaType = CoursePlaybookView.class, one = @One(select = "getCoursePlaybookView")) })
	CoursePlaybook getDefaulPlaybookDetails(@Param("isDelete") Boolean isDelete, @Param("coursePlaybookId") Integer coursePlaybookId);
	

	@Select({
			"select courseplaybookviewid, playbookviewname, deliverytype, layoutmarkuppath, contentmarkuppath, " +
			"courseplaybookstatus, brochurecontentpath, recipientstudentmodel, courseplaybookid ",
			" from corcourseplaybookview where courseplaybookid = #{coursePlaybookId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "coursePlaybookViewId", column = "courseplaybookviewid"),
			@Result(property = "name", column = "playbookviewname"),
			@Result(property = "deliveryTypeId", column = "deliverytype"),
			@Result(property = "layoutPath", column = "layoutmarkupPath"),
			@Result(property = "contentPath", column = "contentmarkuppath"),
			@Result(property = "coursePlaybookStatusId", column = "courseplaybookstatus"),
			@Result(property = "brochurePath", column = "brochurecontentpath"),
			@Result(property = "recStudentModelId", column = "recipientstudentmodel"),
			@Result(property = "coursePlaybook.coursePlaybookId", column = "courseplaybookid") })
	CoursePlaybookView getCoursePlaybookView(Integer cooursePlaybookId);

	
	@Select({
			"select courseplaybookid, validfrom, validto, courseplaybookstatus, courseplaybooktype, courseid ",
			"   from corcourseplaybook where courseid = #{courseId, jdbcType=INTEGER} and isdelete=#{isDelete,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "coursePlaybookId", column = "courseplaybookid"),
			@Result(property = "fromDate", column = "validfrom"),
			@Result(property = "toDate", column = "validto"),
			@Result(property = "coursePBStatusId", column = "courseplaybookstatus"),
			@Result(property = "playbookTypeId", column = "courseplaybooktype"),
			@Result(property = "course.courseId", column = "courseid"),
			@Result(property = "playbookView", column = "courseplaybookid", javaType = CoursePlaybookView.class, one = @One(select = "getCoursePlaybookView")) })
	List<CoursePlaybook> getCoursePlaybookList(@Param("isDelete") Boolean isDelete, @Param("courseId") Integer courseId);
	
	
	@Update({"update corcourseplaybook ",
		"set isdelete= #{isDelete,jdbcType=BOOLEAN} where courseplaybookid = #{coursePBId,jdbcType=INTEGER}"})
	void deleteCoursePlaybook(@Param("isDelete") Boolean isDelete, @Param("coursePBId") Integer coursePBId);

	
/*	@Update({"update corcourseplaybookview set playbookviewname=#{name,jdbcType=VARCHAR}, deliverytype=#{deliveryTypeId,jdbcType=INTEGER}, ",
		" layoutmarkuppath=#{layoutPath,jdbcType=VARCHAR}, contentmarkuppath=#{contentPath,jdbcType=VARCHAR},",
		" courseplaybookstatus=#{coursePlaybookStatusId,jdbcType=INTEGER}, brochurecontentpath=#{brochurePath,jdbcType=VARCHAR}, ",
		"recipientstudentmodel=#{recStudentModelId,jdbcType=INTEGER} where courseplaybookviewid = #{coursePlaybookViewId, jdbcType=INTEGER}"})
*/	void updateCoursePlaybook(CoursePlaybookView coursePBView);

	
	/**
	 * Checks whether CoursePlaybook exists
	 * @param courseId
	 * @return
	 */
	@Select({"select courseplaybookid  from corcourseplaybook where courseid = #{courseId, jdbcType=INTEGER}" })
	@Results(value = {
		@Result(property = "courseplaybookid", column = "courseplaybookid")
	})
	Integer isPlaybookExists(Integer courseId);

}