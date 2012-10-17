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
			"courseidentifier = #{courseIdentifier,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR},",
			"validfrom = #{ValidFrom,jdbcType=DATE},",
			"validto = #{ValidTo,jdbcType=DATE},",
			"coursestatus = #{courseStatus,jdbcType=INTEGER},",
			"rating = #{rating,jdbcType=INTEGER},",
			"contentsecurityneededindicator = #{contentSecurityNeededIndicator,jdbcType=BIT},",
			"courseweightage = #{courseWeightage,jdbcType=INTEGER},",
			"totalcredits = #{totalCredits,jdbcType=VARCHAR},",
			"extracreditsindicator = #{extraCreditsIndicator,jdbcType=BIT},",
			"extracredits = #{extraCredits,jdbcType=VARCHAR},",
			"additionalpropertyindicator = #{additionalPropertyIndicator,jdbcType=BIT},",
			"courseduration=#{courseDuration,jdbcType=INTEGER},",
			"thumbnailpicturepath=#{thumbnailPicturePath,jdbcType=VARCHAR},",
			"templateindicator=#{templateIndicator,jdbcType=TINYINT},",
			"version = #{version,jdbcType=INTEGER},",
			"memberroleid={memberRoleId,jdbcType=INTEGER},",
			"subjclassificationid = #{subjClassificationId,jdbcType=INTEGER} ",
			"where courseid = #{courseId,jdbcType=INTEGER}" })
	Course updateCourse(ZID courseId);

	
	/**
	 * This method saves the Course information to corcourse table
	 */
	@Insert({
			"insert into corcourse ( name, ",
			"courseidentifier, description, ",
			"validfrom, validto, coursestatus, ",
			"rating, contentsecurityneededindicator, ",
			"courseweightage, totalcredits, ",
			"extracreditsindicator, extracredits, ",
			"additionalpropertyindicator, courseduration,thumbnailpicturepath, templateindicator, version, memberroleid,subjclassificationid)",
			"values (#{name,jdbcType=VARCHAR}, ",
			"#{courseIdentifier,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
			"#{ValidFrom,jdbcType=DATE}, #{ValidTo,jdbcType=DATE}, #{courseStatus,jdbcType=INTEGER}, ",
			"#{rating,jdbcType=INTEGER}, #{contentSecurityNeededIndicator,jdbcType=BIT}, ",
			"#{courseWeightage,jdbcType=INTEGER}, #{totalCredits,jdbcType=VARCHAR}, ",
			"#{extraCreditsIndicator,jdbcType=BIT}, #{extraCredits,jdbcType=VARCHAR}, ",
			"#{additionalPropertyIndicator,jdbcType=BIT}, #{courseDuration,jdbcType=INTEGER},#{thumbnailPicturePath,jdbcType=VARCHAR}, ",
			"#{templateIndicator,jdbcType=TINYINT},  #{version,jdbcType=INTEGER}, #{memberRoleId,jdbcType=INTEGER},",
			"#{SubjClassificationId,jdbcType=INTEGER})" })
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