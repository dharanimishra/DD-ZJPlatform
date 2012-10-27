package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import com.ziksana.domain.course.LearningComponent;

public interface LearningComponentMapper {
	/**
	 * This method saves the Learning component
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
			@Result(property = "learningcomponentid", column = "learningcomponentid"),
			@Result(property = "authoredMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "learningComponentType.learningComponentTypeId", column = "learningcomponenttypeid"),
			@Result(property = "duration.duration", column = "prescribedlcduration"),
			@Result(property = "duration.durationUnits", column = "prescribedlcdurationunit"),
			@Result(property = "isLearningObject", column = "learningobjectindicator")
	})
	LearningComponent saveLearningComponent(LearningComponent component);

}