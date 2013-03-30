package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface CoursePlaybookMapper {

	/**
	 * @param coursePlaybook
	 * @return
	 */
	//Integer saveDefaultPlaybook(CoursePlaybook coursePlaybook);

	/**
	 * @param playbookView
	 */
	//void savePlaybookView(CoursePlaybookView playbookView);

	/**
	 * @param isDelete
	 * @param coursePlaybookId
	 * @return
	 */
//	@Select({
//			"select courseplaybookid, validfrom, validto, courseplaybookstatus, courseplaybooktype, courseid ",
//			"   from corcourseplaybook where courseplaybookid = #{coursePlaybookId, jdbcType=INTEGER} and isdelete=#{isDelete,jdbcType=BOOLEAN}" })
//	@Results(value = {
//			@Result(property = "coursePlaybookId", column = "courseplaybookid"),
//			@Result(property = "fromDate", column = "validfrom"),
//			@Result(property = "toDate", column = "validto"),
//			@Result(property = "coursePBStatusId", column = "courseplaybookstatus"),
//			@Result(property = "playbookTypeId", column = "courseplaybooktype"),
//			@Result(property = "course.courseId", column = "courseid"),
//			@Result(property = "playbookView", column = "courseplaybookid", javaType = CoursePlaybookView.class, one = @One(select = "getCoursePlaybookView")) })
//	CoursePlaybook getDefaulPlaybookDetails(@Param("isDelete") Boolean isDelete, @Param("coursePlaybookId") Integer coursePlaybookId);
//	
//
//	/**
//	 * @param cooursePlaybookId
//	 * @return
//	 */
//	@Select({
//			"select courseplaybookviewid, playbookviewname, deliverytype, layoutmarkuppath, contentmarkuppath, " +
//			"courseplaybookstatus, brochurecontentpath, recipientstudentmodel, courseplaybookid ",
//			" from corcourseplaybookview where courseplaybookid = #{coursePlaybookId,jdbcType=INTEGER}" })
//	@Results(value = {
//			@Result(property = "coursePlaybookViewId", column = "courseplaybookviewid"),
//			@Result(property = "name", column = "playbookviewname"),
//			@Result(property = "deliveryTypeId", column = "deliverytype"),
//			@Result(property = "layoutPath", column = "layoutmarkupPath"),
//			@Result(property = "contentPath", column = "contentmarkuppath"),
//			@Result(property = "coursePlaybookStatusId", column = "courseplaybookstatus"),
//			@Result(property = "brochurePath", column = "brochurecontentpath"),
//			@Result(property = "recStudentModelId", column = "recipientstudentmodel"),
//			@Result(property = "coursePlaybook.coursePlaybookId", column = "courseplaybookid") })
//	CoursePlaybookView getCoursePlaybookView(Integer cooursePlaybookId);
//
//	
//	/**
//	 * @param isDelete
//	 * @param courseId
//	 * @return
//	 */
//	@Select({
//			"select courseplaybookid, validfrom, validto, courseplaybookstatus, courseplaybooktype, courseid ",
//			"   from corcourseplaybook where courseid = #{courseId, jdbcType=INTEGER} and isdelete=#{isDelete,jdbcType=BOOLEAN}" })
//	@Results(value = {
//			@Result(property = "coursePlaybookId", column = "courseplaybookid"),
//			@Result(property = "fromDate", column = "validfrom"),
//			@Result(property = "toDate", column = "validto"),
//			@Result(property = "coursePBStatusId", column = "courseplaybookstatus"),
//			@Result(property = "playbookTypeId", column = "courseplaybooktype"),
//			@Result(property = "course.courseId", column = "courseid"),
//			@Result(property = "playbookView", column = "courseplaybookid", javaType = CoursePlaybookView.class, one = @One(select = "getCoursePlaybookView")) })
//	List<CoursePlaybook> getCoursePlaybookList(@Param("isDelete") Boolean isDelete, @Param("courseId") Integer courseId);
//	
//	
//	/**
//	 * @param isDelete
//	 * @param coursePBId
//	 */
//	@Update({"update corcourseplaybook ",
//		"set isdelete= #{isDelete,jdbcType=BOOLEAN} where courseplaybookid = #{coursePBId,jdbcType=INTEGER}"})
//	void deleteCoursePlaybook(@Param("isDelete") Boolean isDelete, @Param("coursePBId") Integer coursePBId);
//
//	
//	/**
//	 * @param coursePBView
//	 */
//	void updateCoursePlaybook(CoursePlaybookView coursePBView);

	
	/**
	 * Checks whether CoursePlaybook exists
	 * @param courseId
	 * @return
	 */
	@Select({"select count(*)  from corcourseplaybook where courseid = #{courseId, jdbcType=INTEGER}" })
	int isPlaybookExists(Integer courseId);

}