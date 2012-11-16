package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponent;

public interface LearningComponentMapper {
	/**
	 * This method saves the Learning component
	 * 
	 * @param component
	 * @return
	 */
	@Insert({
			"insert into corlearningcomponent (validfrom, ",
			"validto, name, description, coursestatus, weightage, totalcredits, ",
			"extracreditsindicator, extracredits, prescribedlcduration, prescribedlcdurationunit, learningobjectindicator, memberroleid, learningcomponenttypeid, subjclassificationid)",
			"values (#{validFrom,jdbcType=DATE}, ",
			"#{validTo,jdbcType=DATE}, #{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, #{prescribedLCDuration,jdbcType=INTEGER}, ",
			"#{weightage,jdbcType=INTEGER}, #{totalCredits,jdbcType=VARCHAR}, ",
			"#{extraCreditsIndicator,jdbcType=BIT}, #{extraCredits,jdbcType=VARCHAR}, #{extraCredits,jdbcType=VARCHAR}, #{prescribedlcduration,jdbcType=INTEGER},",
			"#{prescribedlcdurationunit,jdbcType=INTEGER}, #{learningobjectindicator,jdbcType=INTEGER}, #{authoredMember.memberRoleId,jdbcType=INTEGER}, #{learningComponentType.learningComponentTypeId,jdbcType=INTEGER}, #{subjClassification.subjClassificationId,jdbcType=INTEGER} )" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "learningcomponentid", before = true, resultType = Integer.class)
	@Results(value = {
			@Result(property = "learningComponentId", column = "learningcomponentid"),
			@Result(property = "authoredMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "learningComponentType.learningComponentTypeId", column = "learningcomponenttypeid"),
			@Result(property = "duration.duration", column = "prescribedlcduration"),
			@Result(property = "duration.durationUnits", column = "prescribedlcdurationunit"),
			@Result(property = "isLearningObject", column = "learningobjectindicator") })
	LearningComponent saveLearningComponent(LearningComponent component);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select learningcomponentid, name, description, coursestatus,learningcomponenttypeid, memberroleid, prescribedlcduration, prescribedlcdurationunit"
			+ " from corlearningcomponent where memberroleid =  #{memberRoleId,jdbcType=INTEGER} and islearningobject = #{isLearningObject,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "learningComponentId", column = "learningcomponentid"),
			@Result(property = "authoredMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "learningComponentType.learningComponentTypeId", column = "learningcomponenttypeid"),
			@Result(property = "duration.duration", column = "prescribedlcduration"),
			@Result(property = "duration.durationUnits", column = "prescribedlcdurationunit") })
	List<LearningComponent> getLearningObjects(Boolean isLearningObject,
			Integer memberRoleId);


	
	/**
	 * @param isLearningObject
	 * @param integer
	 * @return
	 */
	@Select({ "select learningcomponentid, name, description, coursestatus,learningcomponenttypeid, memberroleid, prescribedlcduration, prescribedlcdurationunit"
			+ " from corlearningcomponent where learningcomponentid =  #{learningComponentId,jdbcType=INTEGER} and islearningobject = #{isLearningObject,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "learningComponentId", column = "learningcomponentid"),
			@Result(property = "authoredMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "learningComponentType.learningComponentTypeId", column = "learningcomponenttypeid"),
			@Result(property = "duration.duration", column = "prescribedlcduration"),
			@Result(property = "duration.durationUnits", column = "prescribedlcdurationunit") })
	LearningComponent getLearningObjectById(Boolean isLearningObject,
			Integer learningComponentId);

	@Update({" update corlearningcomponent set isdelete = #{isdelete, jdbcType=BOOLEAN} where learningcomponentid =  #{learningComponentId,jdbcType=INTEGER}"})
	void delete(Boolean isDelete, Integer learningComponentId);

	
	List<LearningComponent> getComponentsByCourseId(Integer courseId);

	
	@Select({"select * from corlearningcomponent where "})
	LearningComponent getComponentsByCourseComponentId(Integer integer);

}