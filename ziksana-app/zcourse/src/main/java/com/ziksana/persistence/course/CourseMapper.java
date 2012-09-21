package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.Course;

public interface CourseMapper {

	/**
	 * This method corresponds to the database table corcourse
	 */
	@Delete({ "delete from corcourse",
			"where CourseId = #{CourseId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer CourseId);

	/**
	 * This method corresponds to the database table corcourse
	 */
	int insertSelective(Course record);

	/**
	 * This method corresponds to the database table corcourse
	 */
	@Select({
			"select",
			"CourseId, Name, CourseIdentifier, Description, ValidFrom, ValidTo, CourseStatus, Rating, ",
			"ContentSecurityNeededIndicator, CourseWeightage, TotalCredits, ExtraCreditsIndicator, ",
			"ExtraCredits, AdditionalPropertyIndicator, CourseDuration, ",
			"ThumbnailPicturePath, TemplateIndicator, Version, MemberRoleId, SubjClassificationId ",
			" from corcourse", "where CourseId = #{courseId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	Course selectByPrimaryKey(Integer CourseId);

	/**
	 * This method corresponds to the database table corcourse
	 */
	int updateByPrimaryKeySelective(Course record);

	@Select({
			"select",
			"courseid, name, courseidentifier, description, ValidFrom, ValidTo, coursestatus, rating, ",
			"contentsecurityneededindicator, courseweightage, totalcredits, extracreditsindicator, ",
			"extracredits, additionalpropertyindicator, courseduration, ",
			"thumbnailpicturepath, templateindicator, version, memberroleid, ",
			"subjclassificationid ",
			"from corcourse where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	List<Course> getListOfCourses(Integer memberRoleId);

	Course getCourseCatalog(Integer courseId);

	/**
	 * This method will modifies the course information to database table
	 * corcourse
	 */
	@Update({
			"update corcourse",
			"set Name = #{name,jdbcType=VARCHAR},",
			"CourseIdentifier = #{courseIdentifier,jdbcType=VARCHAR},",
			"Description = #{description,jdbcType=VARCHAR},",
			"ValidFrom = #{ValidFrom,jdbcType=DATE},",
			"ValidTo = #{ValidTo,jdbcType=DATE},",
			"CourseStatus = #{courseStatus,jdbcType=INTEGER},",
			"Rating = #{rating,jdbcType=INTEGER},",
			"ContentSecurityNeededIndicator = #{contentSecurityNeededIndicator,jdbcType=BIT},",
			"CourseWeightage = #{courseWeightage,jdbcType=INTEGER},",
			"TotalCredits = #{totalCredits,jdbcType=VARCHAR},",
			"ExtraCreditsIndicator = #{extraCreditsIndicator,jdbcType=BIT},",
			"ExtraCredits = #{extraCredits,jdbcType=VARCHAR},",
			"AdditionalPropertyIndicator = #{additionalPropertyIndicator,jdbcType=BIT},",
			"CourseDuration=#{courseDuration,jdbcType=INTEGER},",
			"ThumbnailPicturePath=#{thumbnailPicturePath,jdbcType=VARCHAR},",
			"TemplateIndicator=#{templateIndicator,jdbcType=TINYINT},",
			"Version = #{version,jdbcType=INTEGER},",
			"MemberRoleId={memberRoleId,jdbcType=INTEGER},",
			"SubjClassificationId = #{subjClassificationId,jdbcType=INTEGER} ",
			"where CourseId = #{courseId,jdbcType=INTEGER}" })
	Course updateCourse(Course course);

	
	/**
	 * This method saves the course information to corcourse table
	 */
	@Insert({
			"insert into corcourse ( Name, ",
			"CourseIdentifier, Description, ",
			"ValidFrom, ValidTo, CourseStatus, ",
			"Rating, ContentSecurityNeededIndicator, ",
			"CourseWeightage, TotalCredits, ",
			"ExtraCreditsIndicator, ExtraCredits, ",
			"AdditionalPropertyIndicator, CourseDuration,ThumbnailPicturePath, TemplateIndicator, Version, MemberRoleId,SubjClassificationId)",
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
	
	
	/**
	 * This method will retrieves the list of courses by Member's(memberroleid).
	 * @param course
	 * @return
	 */
	@Select({
		"select",
		"courseid, name, courseidentifier, description, validfrom, validto, coursestatus, rating, ",
		"contentsecurityneededindicator, courseweightage, totalcredits, extracreditsindicator, ",
		"extracredits, additionalpropertyindicator, courseduration, ",
		"thumbnailpicturepath, templateindicator, version, memberroleid, subjclassificationid ",
		" from corcourse where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	Course getCoursesByMemberRole(Integer memberRoleId);

}