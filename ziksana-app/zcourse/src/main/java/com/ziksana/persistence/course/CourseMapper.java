package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseAdditionalProperty;
import com.ziksana.domain.course.CourseEditResponse;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.domain.course.ModuleEditResponse;
import com.ziksana.domain.institution.CurriculumCourse;

public interface CourseMapper {

	/**
	 * Retrieves the base course information by Member's (MemberPersona).
	 * 
	 * @param courseId
	 * @return
	 */
	@Select({ "select id, name, description, coursestatus ",
			" from corcourse where id = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "coursestatus", column = "coursestatus"),
			@Result(property = "accountableMember.memberroleid", column = "memberroleid") })
	Course getBaseCourseDetails(Integer courseId);

	@Select({ "select course.id as courseid, course.name, course.description, course.TotalCredits,course.ExtraCredits,course.CourseDuration,course.CourseDurationUnit,course.ThumbnailPicturePath,subjectclassification.SubjectArea,subjectclassification.SubjectCategory,subjectclassification.SubjectTopic from corcourse course,utlsubjectclassification subjectclassification where course.ID=#{courseId,jdbcType=INTEGER} and course.SubjClassificationId=subjectclassification.ID" })
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "coursename", column = "name"),
			@Result(property = "coursedesc", column = "description"),
			@Result(property = "credits", column = "TotalCredits"),
			@Result(property = "extracredits", column = "ExtraCredits"),
			@Result(property = "duration", column = "CourseDuration"),
			@Result(property = "durationtype", column = "CourseDurationUnit"),
			@Result(property = "subjectarea", column = "SubjectArea"),
			@Result(property = "subject", column = "SubjectCategory"),
			@Result(property = "topic", column = "SubjectTopic"),
			@Result(property = "imageupload", column = "ThumbnailPicturePath") })
	CourseEditResponse getCourseDetails(Integer courseId);

	@Select({ "select cclc.ID as courseLearningComponentId, clc.id as learningComponentId, clc.name, clc.description,clc.LearningObjectIndicator,clc.PrescribedLCDuration,clc.PrescribedLCDurationUnit,subjectclassification.SubjectArea,subjectclassification.SubjectCategory,subjectclassification.SubjectTopic,clc.ThumbnailPicturePath from corcourselearningcomponent cclc, corlearningcomponent clc,utlsubjectclassification subjectclassification where cclc.LearningComponentId=clc.ID and  clc.id = #{learningComponentId,jdbcType=INTEGER} and clc.SubjClassificationId=subjectclassification.ID " })
	@Results(value = {
			@Result(property = "courseLearningComponentId", column = "courseLearningComponentId"),
			@Result(property = "learningComponentId", column = "learningComponentId"),
			@Result(property = "modulename", column = "name"),
			@Result(property = "moduledesc", column = "description"),
			@Result(property = "learningObjectIndicator", column = "LearningObjectIndicator"),
			@Result(property = "prescribedLCDuration", column = "PrescribedLCDuration"),
			@Result(property = "prescribedLCDurationUnit", column = "PrescribedLCDurationUnit"),
			@Result(property = "subjectarea", column = "SubjectArea"),
			@Result(property = "subject", column = "SubjectCategory"),
			@Result(property = "topic", column = "SubjectTopic"),
			@Result(property = "imageupload", column = "ThumbnailPicturePath") })
	ModuleEditResponse getModuleDetails(Integer learningComponentId);

	/**
	 * Retrieves the list of base courses information
	 * 
	 * @param memberPersonaId
	 * @return
	 */
	@Select({
			"select id, memberroleid, name, description, coursestatus, contentsecurityneededindicator, courseduration, ThumbnailPicturePath",
			" from corcourse where memberroleid = #{memberPersonaId,jdbcType=INTEGER} and isdelete = false" })
	@Results(value = {
			@Result(property = "courseId", column = "id"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatusId", column = "coursestatus"),
			@Result(property = "securityIndicator", column = "contentsecurityneededindicator"),
			@Result(property = "duration", column = "courseduration"),
			@Result(property = "thumbnailPicturePath", column = "ThumbnailPicturePath") })
	List<Course> getListOfCourses(Integer memberPersonaId);

	/**
	 * This method will modifies the course information to database table
	 * corcourse
	 * 
	 * @param course
	 * @return
	 */
	Integer updateCourse(Course course);

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
			@Result(property = "courseId", column = "id"),
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
	Integer saveCourse(Course course);

	/**
	 * @param courseAdditionalProperty
	 */
	@Insert({
			"insert into corcourseadditionalproperty (creationdate, usagetype, name, datatype, value, active, courseid, memberroleid ) ",
			"values (sysdate(), jdbcType.TIMESTAMP}, #{propertyUsageType, jdbcType.INTEGER}, #{propertyName, jdbcType.VARCHAR},",
			" #{propertyDataType, jdbcType.INTEGER}, #{propertyValue, jdbcType.VARCHAR}, ",
			" #{sequence , jdbcType.INTEGER}, #{active, jdbcType.BOOLEAN}, #{course.courseId, jdbcType.INTEGER},",
			" #{creatorMemberPersona.memberRoleId, jdbcType.INTEGER}  ) " })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "courseaddnlpropertyid", before = true, resultType = Integer.class)
	Integer saveAddnlInfo(CourseAdditionalProperty courseAdditionalProperty);

	/**
	 * Checks whetehr assignment is created at course creation.
	 * 
	 * @param learningComponentId
	 * @return
	 */
	@Select({ "select count(*) from asmassignment where ID = #{learningComponentId, jdbcType=INTEGER}" })
	int checkAssignment(Integer learningComponentId);

	/**
	 * @param memberRoleId
	 * @param isDefineQualifier
	 * @return
	 */
	@Select({
			"select learningcomponenttypeid, name, description  from corlearningcomponenttype where memberroleid = #{memberRoleId, jdbcType=INTEGER} ",
			" and isdefinequalifier = #{isDefineQualifier, jdbcType=BOOLEAN} and isdelete = false" })
	@Results(value = {
			@Result(property = "learningcomponenttypeid", column = "learningcomponenttypeid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description") })
	List<LearningComponentType> getDefinieQualifiers(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("isDefineQualifier") Boolean isDefineQualifier);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select institutionid  from corinstitution where memberroleid = #{memberRoleId, jdbcType=INTEGER} " })
	@Results(value = { @Result(property = "institutionid", column = "institutionid") })
	Integer checkInstitution(Integer memberRoleId);

	/**
	 * @param isDelete
	 * @param memberRoleId
	 * @param learningComponentTypeId
	 */
	@Update({
			"update corlearningcomponenttype set isdelete = #{isDelete, jdbcType=BOOLEAN} where ",
			" memberroleid=#{memberRoleId, jdbcType=INTEGER}, learningcomponenttypeid=#{learningComponentTypeId, jdbcType=INTEGER}" })
	void deleteQualifier(@Param("isDelete") Boolean isDelete,
			@Param("memberRoleId") Integer memberRoleId,
			Integer learningComponentTypeId);

	/**
	 * @param learningComponentType
	 */
	@Update({
			"update corlearningcomponenttype set name = #{name, jdbcType=VARCHAR}, description = #{description, jdbcType=VARCHAR} where ",
			" memberroleid=#{creatorMemberPersona.memberRoleId, jdbcType=INTEGER}, learningcomponenttypeid=#{learningComponentTypeId, jdbcType=INTEGER}" })
	void updateQualifier(LearningComponentType learningComponentType);

	/**
	 * @param isDelete
	 * @param memberRoleId
	 * @param integer
	 * @return
	 */
	@Select({
			"select learningcomponenttypeid, name, description  from corlearningcomponenttype where memberroleid = #{memberRoleId, jdbcType=INTEGER} ",
			" and isdefinequalifier = #{isDefineQualifier, jdbcType=BOOLEAN} and isdelete = false" })
	@Results(value = {
			@Result(property = "learningcomponenttypeid", column = "learningcomponenttypeid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description") })
	LearningComponentType getQualifier(@Param("isDelete") Boolean isDelete,
			@Param("memberRoleId") Integer memberRoleId,
			@Param("isDefineQualifier") Integer isDefineQualifier);

	/**
	 * @param isLearningObject
	 * @param memberRoleId
	 * @return
	 */
	List<LearningComponent> getLearningObjects(
			@Param("isLearningObject") Boolean isLearningObject,
			@Param("memberRoleId") Integer memberRoleId);

	/**
	 * @param course
	 */
	@Update({ "update corcourse",
			"set coursestatus = #{courseStatus,jdbcType=INTEGER},",
			"where courseid = #{courseId,jdbcType=INTEGER}" })
	void saveReviewCourse(Course course);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select curriculumcourseid,courseid,courseusetype,courseversion,gradetype,validfrom,validto,"
			+ "duration,durationunit  from corcurriculumcourse where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "curriculumCourseId", column = "curriculumcourseid"),
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "courseUseType", column = "courseusetype"),
			@Result(property = "courseversion", column = "courseversion"),
			@Result(property = "gradetype", column = "gradetype"),
			@Result(property = "validfrom", column = "validfrom"),
			@Result(property = "valido", column = "validto"),
			@Result(property = "duration", column = "duration"),
			@Result(property = "durationunit", column = "durationunit"),
			@Result(property = "course", column = "courseid", javaType = Course.class, one = @One(select = "getBaseCourseDetails")) })
	List<CurriculumCourse> getCurriculumCoursesByMember(Integer memberRoleId);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select * from corcourse where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "courseId", column = "id"),
			@Result(property = "courseUseType", column = "courseusetype"),
			@Result(property = "courseversion", column = "courseversion"),
			@Result(property = "gradetype", column = "gradetype"),
			@Result(property = "validfrom", column = "validfrom"),
			@Result(property = "valido", column = "validto"),
			@Result(property = "duration", column = "duration"),
			@Result(property = "durationunit", column = "durationunit"), })
	List<Course> getPublishedCourses(Integer memberRoleId);

	// Course Tree structure related methods STARTS
	/**
	 * This method will retrieves the course learning components and its
	 * contents from the database.
	 * 
	 * @param course
	 * @return
	 */
	@Select({ "select id, name, description coursestatus, memberroleid from corcourse where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "id"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "courseDetails.courseLearningComponentsList", column = "courseid", javaType = List.class, many = @Many(select = "getLearningComponents")) })
	Course getCourseComponents(Integer courseId);

	/**
	 * @param courseId
	 * @return
	 */
	@Select({
			"select courselearningcomponentid, courseid, learningcomponentid, learningcomponenttypeid ",
			" from corcourselearningcomponent where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseLearningComponentId", column = "courselearningcomponentid"),
			@Result(property = "duration.durationUnit", column = "durationunit"),
			@Result(property = "course.courseId", column = "courseid"),
			@Result(property = "learningComponent.learningComponentId", column = "learningcomponentid"),
			@Result(property = "learningcomponentType.learningcomponentTypeId", column = "learningcomponentTypeId"),
			@Result(property = "learningComponentType", column = "learningcomponentTypeId", javaType = LearningComponentType.class, one = @One(select = "getLearningComponentType")),
			@Result(property = "learningComponent", column = "learningcomponentid", javaType = LearningComponent.class, one = @One(select = "getLearningComponent")) })
	List<CourseLearningComponent> getLearningComponents(Integer courseId);

	/**
	 * @param learningComponentTypeId
	 * @return
	 */
	@Select({ "select learningcomponenttypeid from corlearningcomponenttype where learningcomponenttypeid = #{learningComponentTypeId,jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "learningComponentTypeId", column = "learningcomponenttypeid") })
	LearningComponentType getLearningComponentType(
			Integer learningComponentTypeId);

	/**
	 * @param learningComponentId
	 * @return
	 */
	@Select({ "select learningcomponentid, name, description, learningObjIndicator, learningcomponenttypeid, learningcomponentnestid "
			+ "from corlearningcomponent where learningcomponentid = #{learningComponentId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "learningcomponentid", column = "learningcomponentid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "learningObjIndicator", column = "learningobjindicator"),
			@Result(property = "learningcomponentType.learningcomponentTypeId", column = "learningcomponentTypeId"),
			@Result(property = "learningComponentType", column = "learningcomponentTypeId", javaType = LearningComponentType.class, one = @One(select = "getLearningComponentType")),
			@Result(property = "learningcomponentnestid", column = "learningcomponentnestid"),
			@Result(property = "learningComponentDetails.learningComponentNest", column = "learningcomponentnestid", javaType = LearningComponentType.class, one = @One(select = "getLearningComponentNest")),
			@Result(property = "learningComponentDetails.learningCompContentList", column = "learningcomponentid", javaType = List.class, many = @Many(select = "getLearningComponentContents")) })
	LearningComponent getLearningComponent(Integer learningComponentId);

	/**
	 * @param learningComponentNestId
	 * @return
	 */
	@Select({ "select learningcomponentnestid from corlearningcomponenttype where learningcomponentnestid = #{learningComponentNestId,jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "learningComponentNestId", column = "learningcomponentnestid") })
	LearningComponentNest getLearningComponentNest(
			Integer learningComponentNestId);

	/**
	 * @param learningComponentId
	 * @return
	 */
	@Select({ "select learningcomponentcontentid, contentdescription, learningcontentid from corlearningcomponentcontent where isdelete = false"
			+ " and learningcomponentid = #{learningComponentId,jdbcType.INTEGER}" })
	@Results(value = {
			@Result(property = "learningcomponentcontentid", column = "learningComponentContentId"),
			@Result(property = "contentdescription", column = "contentdescription"),
			@Result(property = "baseLearningContent.learningContentId", column = "learningcontentid"),
			@Result(property = "baseLearningContent", column = "learningcontentid", javaType = LearningContent.class, one = @One(select = "getLearningContent")) })
	List<LearningComponentContent> getLearningComponentContents(
			Integer learningComponentId);

	/**
	 * @param learningContentId
	 * @return
	 */
	@Select({ "select learningcontentid, contentpath, contentformat, contentname, contentdescription "
			+ "from corlearningcontent where learningcontentid = #{learningContentId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "learningcontentid", column = "learningcontentid"),
			@Result(property = "contentdescription", column = "contentdescription"),
			@Result(property = "baseLearningContent.learningContentId", column = "learningcontentid"),
			@Result(property = "learningContentPartsList", column = "learningcontentid", javaType = List.class, many = @Many(select = "getLearningContentParts")) })
	LearningContent getLearningContent(Integer learningContentId);

	/**
	 * @param learningContentId
	 * @return
	 */
	@Select({ "select learningcontentpartsid, partpath, partsequence from corlearningcontentparts where learningcontentid = #{learningContentId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "learningContentPartsId", column = "learningcontentpartsid"),
			@Result(property = "partPath", column = "partpath"),
			@Result(property = "partSequence", column = "partsequence"), })
	List<LearningContentParts> getLearningContentParts(Integer learningContentId);

	// Course Tree structure related methods ENDS

	@Update({ "update corcourse set isDelete = true where ID =  #{courseId,jdbcType=INTEGER}" })
	void deleteCourse(Integer courseId);

	@Update({ "update corlearningcomponent set isdelete = #{isdelete, jdbcType=BOOLEAN} where ID =  #{learningComponentId,jdbcType=INTEGER}" })
	void removeCourseComponents(@Param("isDelete") Boolean isDelete,
			@Param("learningComponentId") Integer learningComponentId);

	List<Course> getCourses(@Param("statusId") Integer statusId,
			@Param("memberPersonaId") Integer memberPersonaId);

	List<Course> getAllCourses(@Param("statusId") Integer statusId,
			@Param("memberPersonaId") Integer memberPersonaId);

	Integer totalNumberOfCourses(@Param("statusId") Integer statusId,
			@Param("memberPersonaId") Integer memberPersonaId);

	public Course getCourseByCourseId(Integer courseId);

	public Integer saveCurriculamCourse(@Param("courseId") Integer courseId,
			@Param("memberRoleId") Integer memberRoleId);

	public void saveAndEnableCourse(int coursesId);

	public int isCourseNameExists(@Param("statusId") Integer statusId,
			@Param("memberPersonaId") Integer memberPersonaId,
			@Param("courseName") String courseName);

	public int getCoursesByCoursename(@Param("statusId") Integer statusId,
			@Param("memberPersonaId") Integer memberPersonaId,
			@Param("courseName") String courseName,
			@Param("courseId") int courseId);

	public int isModuleExists(Integer courseId);

	public int isContentExists(Integer courseId);

}
