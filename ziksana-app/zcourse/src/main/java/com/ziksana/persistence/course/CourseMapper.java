package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseAdditionalProperty;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentType;

public interface CourseMapper {

	/**
	 * Retrieves the base course information by Member's (MemberPersona).
	 * 
	 * @param courseId
	 * @return
	 */
	@Select({ "select courseid, name, description, coursestatus ",
			" from corcourse where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "coursestatus", column = "coursestatus"),
			@Result(property = "accountableMember.memberroleid", column = "memberroleid") })
	Course getBaseCourseDetails(Integer courseId);

	/**
	 * Retrieves the list of base courses information
	 * 
	 * @param memberPersonaId
	 * @return
	 */
	@Select({ "select", "courseid, name, description, coursestatus",
			"from corcourse where memberpersonaid = #{memberPersonaId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "contentSecurityNeededIndicator", column = "securityindicator"),
			@Result(property = "duration.courseDuration", column = "courseduration") })
	List<Course> getListOfCourses(Integer memberPersonaId);

	/**
	 * This method will modifies the course information to database table
	 * corcourse
	 * 
	 * @param course
	 * @return
	 */
	@Update({
			"update corcourse",
			"set name = #{name,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR},",
			"coursestatus = #{courseStatus,jdbcType=INTEGER},",
			"contentsecurityneededindicator = #{securityIndicator,jdbcType=BOOLEAN},",
			"totalcredits = #{totalCredits,jdbcType=VARCHAR},",
			"extracredits = #{extraCredits,jdbcType=VARCHAR},",
			"additionalpropertyindicator = #{additionalInfoIndicator,jdbcType=BOOLEAN},",
			"courseduration=#{courseDuration,jdbcType=INTEGER},",
			"thumbnailpicturepath=#{thumbnailPicturePath,jdbcType=VARCHAR},",
			"version = #{version,jdbcType=INTEGER},",
			"subjclassificationid = #{subjClassification.subjClassificationId,jdbcType=INTEGER} ",
			"where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "contentSecurityNeededIndicator", column = "securityindicator"),
			@Result(property = "duration.courseDuration", column = "courseduration") })
	Course updateCourse(Course course);

	/**
	 * This method will modifies the indicators and assoication fields of course
	 * 
	 * @param course
	 * @return
	 */
	@Update({
			"update corcourse",
			"set contentsecurityneededindicator = #{securityIndicator,jdbcType=BOOLEAN},",
			"additionalpropertyindicator = #{additionalInfoIndicator,jdbcType=BOOLEAN},",
			"where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "contentSecurityNeededIndicator", column = "securityindicator"),
			@Result(property = "duration.courseDuration", column = "courseduration") })
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
			"#{securityIndicator,jdbcType=BOOLEAN}, ",
			"#{totalCredits,jdbcType=VARCHAR}, ",
			"#{extraCredits,jdbcType=VARCHAR}, ",
			"#{additionalInfoIndicator,jdbcType=BOOLEAN}, #{courseDuration,jdbcType=INTEGER},#{thumbnailPicturePath,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=INTEGER}, #{versionRemarks,jdbcType=VARCHAR}, #{accountableMember.memberRoleId,jdbcType=INTEGER},",
			"#{subjClassification.subjClassificationId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "courseid", before = true, resultType = Integer.class)
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "contentSecurityNeededIndicator", column = "securityindicator"),
			@Result(property = "duration.courseDuration", column = "courseduration") })
	Course saveCourse(Course course);

	/**
	 * This method will retrieves the course learning components and its
	 * contents from the database.
	 * 
	 * @param course
	 * @return
	 */
	@ResultMap("CourseTreeMap")
	Course getCourseComponents(Course course);

	
	
	@Insert({
			"insert into corcourseadditionalproperty (creationdate, usagetype, name, datatype, value, active, courseid, memberroleid ) ",
			"values (sysdate(), jdbcType.TIMESTAMP}, #{propertyUsageType, jdbcType.INTEGER}, #{propertyName, jdbcType.VARCHAR},",
			" #{propertyDataType, jdbcType.INTEGER}, #{propertyValue, jdbcType.VARCHAR}, ",
			" #{sequence , jdbcType.INTEGER}, #{active, jdbcType.BOOLEAN}, #{course.courseId, jdbcType.INTEGER},",
			" #{creatorMemberPersona.memberRoleId, jdbcType.INTEGER}  ) " })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "courseaddnlpropertyid", before = true, resultType = Integer.class)
	void saveAddnlInfo(CourseAdditionalProperty courseAdditionalProperty);

	
	
	/**
	 * Checks whetehr assignment is created at course creation.
	 * 
	 * @param learningComponentId
	 * @return
	 */
	@Select({ "select assignmentid from asmassignment where leraningcomponentid = #{learningComponentId, jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "assignmentId", column = "assignmentid") })
	Integer checkAssignment(Integer learningComponentId);

	
	
	@Select({
			"select learningcomponenttypeid, name, description  from corlearningcomponenttype where memberroleid = #{memberRoleId, jdbcType=INTEGER} ",
			" and isdefinequalifier = #{isDefineQualifier, jdbcType=BOOLEAN} and isdelete = false" })
	@Results(value = { 
			@Result(property = "learningcomponenttypeid", column = "learningcomponenttypeid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description")
	})
	List<LearningComponentType> getDefinieQualifiers(Integer memberRoleId,
			Boolean isDefineQualifier);


	
	@Select({ "select institutionid  from corinstitution where memberroleid = #{memberRoleId, jdbcType=INTEGER} " })
	@Results(value = { @Result(property = "institutionid", column = "institutionid") })
	Integer checkInstitution(Integer memberRoleId);

	
	
	@Update({
			"update corlearningcomponenttype set isdelete = #{isDelete, jdbcType=BOOLEAN} where ",
			" memberroleid=#{memberRoleId, jdbcType=INTEGER}, learningcomponenttypeid=#{learningComponentTypeId, jdbcType=INTEGER}" })
	void deleteQualifier(Boolean isDelete, Integer memberRoleId,
			Integer learningComponentTypeId);

	
	
	@Update({
			"update corlearningcomponenttype set name = #{name, jdbcType=VARCHAR}, description = #{description, jdbcType=VARCHAR} where ",
			" memberroleid=#{creatorMemberPersona.memberRoleId, jdbcType=INTEGER}, learningcomponenttypeid=#{learningComponentTypeId, jdbcType=INTEGER}" })
	void updateQualifier(LearningComponentType learningComponentType);

	
	
	@Select({
			"select learningcomponenttypeid, name, description  from corlearningcomponenttype where memberroleid = #{memberRoleId, jdbcType=INTEGER} ",
			" and isdefinequalifier = #{isDefineQualifier, jdbcType=BOOLEAN} and isdelete = false" })
	@Results(value = { 
			@Result(property = "learningcomponenttypeid", column = "learningcomponenttypeid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description")
	})
	LearningComponentType getQualifier(Boolean isDelete, Integer memberRoleId,
			Integer integer);

	
	List<LearningComponent> getLearningObjects(Boolean isLearningObject,
			Integer memberRoleId);

}