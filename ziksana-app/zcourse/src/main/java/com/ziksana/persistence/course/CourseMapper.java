package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.Course;
import com.ziksana.id.ZID;

public interface CourseMapper {

	/**
	 * Updates the Course's delete indicator to perform soft delete.
	 * @param CourseId
	 * @return
	 */
	@Delete({ "update from corcourse set isdelete=#{isDelete,jdbcType=BIT}",
			"where courseid = #{CourseId,jdbcType=INTEGER}" })
	int delete(ZID CourseId);

	/**
	 * Retrieves the base course information by Member's (MemberPersona).
	 * @param courseId
	 * @return
	 */
	@Select({
			"select",
			"courseid, name, courseidentifier, description, coursestatus ",
			" from corcourse where courseid = #{courseId,jdbcType=INTEGER}" })
	@ResultMap("BaseCourseMap")
	Course getBaseCourseDetails(ZID courseId);

	/**
	 * Retrieves the list of base courses information
	 * @param memberPersonaId
	 * @return
	 */
	@Select({
			"select",
			"courseid, name, courseidentifier, description, coursestatus",
			"from corcourse where memberpersonaid = #{memberPersonaId,jdbcType=INTEGER}" })
	@ResultMap("BaseCourseMap")
	List<Course> getListOfCourses(ZID memberPersonaId);


	/**
	 * This method will modifies the course information to database table
	 * corcourse
	 * @param course
	 * @return
	 */
	@Update({
			"update corcourse",
			"set name = #{name,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR},",
			"coursestatus = #{courseStatus,jdbcType=INTEGER},",
			"contentsecurityneededindicator = #{securityIndicator,jdbcType=BIT},",
			"totalcredits = #{totalCredits,jdbcType=VARCHAR},",
			"extracredits = #{extraCredits,jdbcType=VARCHAR},",
			"additionalpropertyindicator = #{additionalInfoIndicator,jdbcType=BIT},",
			"courseduration=#{courseDuration,jdbcType=INTEGER},",
			"thumbnailpicturepath=#{thumbnailPicturePath,jdbcType=VARCHAR},",
			"version = #{version,jdbcType=INTEGER},",
			"subjclassificationid = #{subjClassificationId,jdbcType=INTEGER} ",
			"where courseid = #{courseId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	Course updateCourse(Course course);

	/**
	 * This method will modifies the indicators and assoication fields of course
	 * @param course
	 * @return
	 */
	@Update({
			"update corcourse",
			"set contentsecurityneededindicator = #{securityIndicator,jdbcType=BIT},",
			"additionalpropertyindicator = #{additionalInfoIndicator,jdbcType=BIT},",
			"where courseid = #{courseId,jdbcType=INTEGER}" })
	Course updateCourseInfo(Course course);
	
	/**
	 * This method saves the Course information to corcourse table
	 */
	@Insert({
			"insert into corcourse ( name, ",
			"description, coursestatus, ",
			"contentsecurityneededindicator, ",
			"totalcredits, extracredits, ",
			"additionalpropertyindicator, courseduration,thumbnailpicturepath, version, versionremarks, memberroleid, subjclassificationid)",
			"values (#{name,jdbcType=VARCHAR}, ",
			"#{description,jdbcType=VARCHAR}, ",
			"#{courseStatus,jdbcType=INTEGER}, ",
			"#{securityIndicator,jdbcType=BIT}, ",
			"#{totalCredits,jdbcType=VARCHAR}, ",
			"#{extraCredits,jdbcType=VARCHAR}, ",
			"#{additionalInfoIndicator,jdbcType=BIT}, #{courseDuration,jdbcType=INTEGER},#{thumbnailPicturePath,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=INTEGER}, #{versionRemarks,jdbcType=VARCHAR}, #{memberRoleId,jdbcType=INTEGER},",
			"#{subjClassificationId,jdbcType=INTEGER})" })
	@ResultMap("BaseResultMap")
	Course saveCourse(Course course);


	/**
	 * This method will retrieves the course learning components and its
	 * contents from the database.
	 * @param course
	 * @return
	 */
	@ResultMap("CourseTreeMap")
	Course getCourseComponents(Course course);
	
}