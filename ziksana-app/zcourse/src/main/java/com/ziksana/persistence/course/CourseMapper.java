package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseAdditionalProperty;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.domain.institution.CurriculumCourse;

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
	@Select({ "select courseid, memberroleid, name, description, coursestatus, contentsecurityneededindicator, courseduration,",
			"coursedurationunit from corcourse where memberroleid = 100 " })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "status", column = "coursestatus"),
			@Result(property = "securityIndicator", column = "contentsecurityneededindicator"),
			@Result(property = "duration", column = "courseduration"),
			@Result(property = "durationUnits", column = "coursedurationunit") 
			})
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
			"extracredits, ",
			"additionalpropertyindicator, courseduration,thumbnailpicturepath, version, versionremarks, memberroleid, subjclassificationid)",
			"values (#{name,jdbcType=VARCHAR}, ",
			"#{description,jdbcType=VARCHAR}, ",
			" 1, ",
			"#{securityIndicator,jdbcType=BOOLEAN}, ",
			"#{extraCredits,jdbcType=VARCHAR}, ",
			"#{additionalInfoIndicator,jdbcType=BOOLEAN}, #{courseDuration.duration,jdbcType=INTEGER},#{thumbnailPicturePath,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=INTEGER}, #{versionRemarks,jdbcType=VARCHAR}, #{accountableMember.memberRoleId,jdbcType=INTEGER},",
			"#{subjClassification.subjClassificationId,jdbcType=INTEGER})" })
	@SelectKey(keyProperty = "courseid", before = true, resultType = int.class, statement = { "select last_insert_id as courseid" })
	int saveCourse(Course course);
	
	
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

	@Update({
		"update corcourse",
		"set coursestatus = #{courseStatus,jdbcType=INTEGER},",
		"where courseid = #{courseId,jdbcType=INTEGER}" })
	void saveReviewCourse(Course course);

	
	@Select({"select * from corcurriculumcourse where memberroleid = #{memberRoleId,jdbcType=INTEGER}"})
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
			@Result(property="course", column="courseid", javaType=Course.class,one=@One(select="getBaseCourseDetails"))
	})
	List<CurriculumCourse> getCurriculumCoursesByMember(Integer memberRoleId);


	@Select({"select * from corcourse where memberroleid = #{memberRoleId,jdbcType=INTEGER}"})
	@Results(value = { 
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "courseUseType", column = "courseusetype"),
			@Result(property = "courseversion", column = "courseversion"),
			@Result(property = "gradetype", column = "gradetype"),
			@Result(property = "validfrom", column = "validfrom"),
			@Result(property = "valido", column = "validto"),
			@Result(property = "duration", column = "duration"),
			@Result(property = "durationunit", column = "durationunit"),
	})
	List<Course> getPublishedCourses(Integer memberRoleId);
	
	
	
	//Course Tree structure related methods STARTS
	/**
	 * This method will retrieves the course learning components and its
	 * contents from the database.
	 * @param course
	 * @return
	 */
	@Select({"select courseid, name, description coursestatus, memberroleid from corcourse where courseid = #{courseId,jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "courseDetails.courseLearningComponentsList", column="courseid", javaType=List.class,many=@Many(select="getLearningComponents"))
			})
	Course getCourseComponents(Course course);
	
	
	@Select({
		"select courselearningcomponentid, courseid, learningcomponentid, learningcomponenttypeid ",
		" from corcourselearningcomponent where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
		@Result(property = "courseLearningComponentId", column = "courselearningcomponentid"),
		@Result(property = "duration.durationUnit", column = "durationunit"),
		@Result(property = "course.courseId", column = "courseid"),
		@Result(property = "learningComponent.learningComponentId", column = "learningcomponentid"),
		@Result(property = "learningcomponentType.learningcomponentTypeId", column = "learningcomponentTypeId"),
		@Result(property = "learningComponentType", column="learningcomponentTypeId", javaType=LearningComponentType.class,one=@One(select="getLearningComponentType")),
		@Result(property = "learningComponent", column="learningcomponentid", javaType=LearningComponent.class,one=@One(select="getLearningComponent"))
	})
	List<CourseLearningComponent> getLearningComponents(Integer courseId);
	
	
	@Select({
		"select learningcomponenttypeid from corlearningcomponenttype where learningcomponenttypeid = #{learningComponentTypeId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "learningComponentTypeId", column = "learningcomponenttypeid")
		})	
	LearningComponentType getLearningComponentType(Integer learningComponentTypeId);
		
	
	@Select({"select learningcomponentid, name, description, learningObjIndicator, learningcomponenttypeid, learningcomponentnestid " +
			"from corlearningcomponent where learningcomponentid = #{learningComponentId,jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property = "learningcomponentid", column = "learningcomponentid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "learningObjIndicator", column = "learningobjindicator"),
			@Result(property = "learningcomponentType.learningcomponentTypeId", column = "learningcomponentTypeId"),
			@Result(property = "learningComponentType", column="learningcomponentTypeId", javaType=LearningComponentType.class,one=@One(select="getLearningComponentType")),
			@Result(property = "learningcomponentnestid", column = "learningcomponentnestid"),
			@Result(property = "learningComponentDetails.learningComponentNest", column="learningcomponentnestid", javaType=LearningComponentType.class,one=@One(select="getLearningComponentNest")),
			@Result(property = "learningComponentDetails.learningCompContentList", column="learningcomponentid", javaType=List.class,many=@Many(select="getLearningComponentContents"))
		})
	LearningComponent getLearningComponent(Integer learningComponentId);
	
	
	@Select({
	"select learningcomponentnestid from corlearningcomponenttype where learningcomponentnestid = #{learningComponentNestId,jdbcType=INTEGER}" })
		@Results(value = {
				@Result(property = "learningComponentNestId", column = "learningcomponentnestid")
		})	
	LearningComponentNest getLearningComponentNest(Integer learningComponentNestId);
	
	
	@Select({"select learningcomponentcontentid, contentdescription, learningcontentid from corlearningcomponentcontent where isdelete = false" +
			" and learningcomponentid = #{learningComponentId,jdbcType.INTEGER}"})
	@Results(value = {
			@Result(property = "learningcomponentcontentid", column = "learningComponentContentId"),
			@Result(property = "contentdescription", column = "contentdescription"),
			@Result(property = "baseLearningContent.learningContentId", column = "learningcontentid"),
			@Result(property = "baseLearningContent", column="learningcontentid", javaType=LearningContent.class,one=@One(select="getLearningContent"))
			})
	List<LearningComponentContent> getLearningComponentContents(Integer learningComponentId);
	

	@Select({"select learningcontentid, contentpath, contentformat, contentname, contentdescription " +
			"from corlearningcontent where learningcontentid = #{learningContentId,jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property = "learningcontentid", column = "learningcontentid"),
			@Result(property = "contentdescription", column = "contentdescription"),
			@Result(property = "baseLearningContent.learningContentId", column = "learningcontentid"),
			@Result(property = "learningContentPartsList", column="learningcontentid", javaType=List.class,many=@Many(select="getLearningContentParts"))
			})
	LearningContent getLearningContent(Integer learningContentId);
	
	
	@Select({"select learningcontentpartsid, partpath, partsequence from corlearningcontentparts where learningcontentid = #{learningContentId,jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property = "learningContentPartsId", column = "learningcontentpartsid"),
			@Result(property = "partPath", column = "partpath"),
			@Result(property = "partSequence", column = "partsequence"),
		})
	List<LearningContentParts> getLearningContentParts(Integer learningContentId);
	
	//Course Tree structure related methods ENDS
	


}