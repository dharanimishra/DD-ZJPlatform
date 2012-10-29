package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CoursePlaybook;
import com.ziksana.domain.course.CoursePlaybookView;

public interface CoursePlaybookMapper {

	@Insert({ "insert into corcourseplaybook (fromDate, ",
			"toDate, courseplaybookstatus, courseplaybooktype, courseid)",
			"values (#{fromDate,jdbcType=DATE}, ",
			"#{toDate,jdbcType=DATE}, #{coursePBStatus,jdbcType=INTEGER},",
			"#{playbookType,jdbcType=INTEGER}, #{course.courseId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "coursePlaybookId", before = true, resultType = Integer.class)
	@Results(value = {
			@Result(property = "coursePlaybookId", column = "courseplaybookid"),
			@Result(property = "fromDate", column = "validfrom"),
			@Result(property = "toDate", column = "validTo"),
			@Result(property = "coursePlaybookStatus", column = "courseplaybookStatus"),
			@Result(property = "coursePlaybookType", column = "courseplaybooktype"),
			@Result(property = "course.courseId", column = "courseId") })
	CoursePlaybook saveDefaultPlaybook(CoursePlaybook coursePlaybook);

	@Insert({
			"insert into corcoursepplaybookview ",
			"(creationdate, name, deliverytype, layoutPath, contentPath, playbookstatus, brochurePath, recipientstudentmodel, courseplaybookid) ",
			"values (sysdate(), #{name,jdbcType=VARCHAR}, #{deliverypeTy,jdbcType=INTEGER}, #{layoutPath,jdbcType=VARCHAR}, ",
			" #{contentPath,jdbcType=VARCHAR},#{playbookStatus,jdbcType=INTEGER},#{brochurePath,jdbcType=VARCHAR},#{recipientStudentModel,jdbcType=INTEGER},",
			" #{coursePlaybook.coursePlaybookId,jdbcType=INTEGER},)" })
	void savePlaybookView(CoursePlaybookView playbookView);

	@Select({
			"select courseplaybookid, fromDate, toDate, courseplaybookstatus, courseplaybooktype, courseid ",
			"   from corcourseplaybook where courseplaybookid = #{coursePlaybookId, jdbcType=INTEGER} and isDelete=#{isDelete,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "courseplaybookid", column = "courseplaybookid"),
			@Result(property = "fromDate", column = "fromdate"),
			@Result(property = "toDate", column = "todate"),
			@Result(property = "courseplaybookstatus", column = "courseplaybookstatus"),
			@Result(property = "courseplaybooktype", column = "courseplaybooktype"),
			@Result(property = "course.courseid", column = "courseid"),
			@Result(property = "playbookView", column = "courseplaybookId", javaType = CoursePlaybookView.class, one = @One(select = "getCoursePlaybookView")) })
	CoursePlaybook getDefaulPlaybookDetails(Boolean isDelete, Integer coursePlaybookId);
	

	@Select({
			"select courseplaybookviewid, name, deliverytype, layoutPath, contentPath, playbookstatus, brochurePath, recipientstudentmodel, courseplaybookid ",
			" from corcoursepplaybookview where courseplaybookid = #{coursePlaybookId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "coursePlaybookViewId", column = "courseplaybookviewid"),
			@Result(property = "name", column = "name"),
			@Result(property = "deliveryType", column = "deliverytype"),
			@Result(property = "layoutPath", column = "layoutpath"),
			@Result(property = "contentPath", column = "contentpath"),
			@Result(property = "playbookStatus", column = "playbookstatus"),
			@Result(property = "brochurePath", column = "brochurepath"),
			@Result(property = "recipientStudentModel", column = "recipientstudentmodel"),
			@Result(property = "coursePlaybook.coursePlaybookId", column = "courseplaybookid"), })
	CoursePlaybookView getCoursePlaybookView(Integer cooursePlaybookId);

	
	@Select({
			"select courseplaybookid, fromdate, todate, courseplaybookstatus, courseplaybooktype, courseid ",
			"   from corcourseplaybook where courseid = #{courseId, jdbcType=INTEGER} and isdelete=#{isDelete,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "courseplaybookid", column = "courseplaybookid"),
			@Result(property = "fromDate", column = "fromdate"),
			@Result(property = "toDate", column = "toDate"),
			@Result(property = "courseplaybookstatus", column = "courseplaybookstatus"),
			@Result(property = "courseplaybooktype", column = "courseplaybooktype"),
			@Result(property = "course.courseid", column = "courseid"),
			@Result(property = "playbookView", column = "courseplaybookId", javaType = CoursePlaybookView.class, one = @One(select = "getCoursePlaybookView")) })
	List<CoursePlaybook> getCoursePlaybookList(Boolean isDelete, Integer courseId);
	
	
	@Update({"update corcourseplaybook ",
		"isDelete= #{isDelete,jdbcType=BOOLEAN} where courseplaybookid = #{coursePBId,jdbcType=INTEGER}"})
	void deleteCoursePlaybook(Boolean isDelete, Integer coursePBId);

	
	@Update({"update corcourseplaybookview set set name=#{name,jdbcType=VARCHAR}, deliverytype=#{deliveryType,jdbcType=INTEGER}, ",
		" layoutpath=#{layoutPath,jdbcType=VARCHAR}, contentpath=#{contentPath,jdbcType=VARCHAR},",
		" playbookstatus=#{playbookStatus,jdbcType=INTEGER}, brochurepath=#{brochurePath,jdbcType=VARCHAR}, ",
		"recipientstudentmodel=#{recipientStudentModel,jdbcType=INTEGER} where courseplaybookviewid = #{coursePlaybookViewId, jdbcType=INTEGER}"})
	void updateCoursePlaybook(CoursePlaybookView coursePBView);

}