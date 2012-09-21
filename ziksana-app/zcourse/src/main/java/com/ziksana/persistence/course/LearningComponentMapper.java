package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponent;

public interface LearningComponentMapper {
	/**
	 * . This method corresponds to the database table corlearningcomponent
	 */
	@Delete({ "delete from corlearningcomponent",
			"where learningcomponentid = #{learningComponentId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer learningComponentId);


	/**
	 * . This method corresponds to the database table corlearningcomponent
	 */
	int insertSelective(LearningComponent record);

	/**
	 * . This method corresponds to the database table corlearningcomponent
	 */
	@Select({
			"select",
			"learningcomponentid, validfrom, validto, coursestatus, weightage, totalcredits, extracreditsindicator, ",
			"extracredits, courseid, memberroleid, learningcomponenttypeid, subjclassificationid from corlearningcomponent",
			"where learningcomponentid = #{learningComponentId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	LearningComponent selectByPrimaryKey(Integer learningComponentId);

	/**
	 * . This method corresponds to the database table corlearningcomponent
	 */
	int updateByPrimaryKeySelective(LearningComponent record);

	/**
	 * . This method corresponds to the database table corlearningcomponent
	 */
	@Update({ "update corlearningcomponent",
			"set validfrom = #{validFrom,jdbcType=DATE},",
			"validto = #{validTo,jdbcType=DATE},",
			"coursestatus = #{courseStatus,jdbcType=INTEGER},",
			"weightage = #{weightage,jdbcType=INTEGER},",
			"totalcredits = #{totalCredits,jdbcType=VARCHAR},",
			"extracreditsindicator = #{extraCreditsIndicator,jdbcType=BIT},",
			"extracredits = #{extraCredits,jdbcType=VARCHAR},",
			"courseid = #{courseId,jdbcType=INTEGER},",
			"memberroleid = #{memberRoleId,jdbcType=INTEGER},",
			"learningcomponenttypeid = #{learningComponentTypeId,jdbcType=INTEGER}, ",
			"subjclassificationid = #{subjClassificationId,jdbcType=INTEGER} ",
			"where learningcomponentid = #{learningComponentId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(LearningComponent record);
	
	/**
	 * . This method saves the component to the database.
	 */ 
	@Insert({
			"insert into corlearningcomponent (learningcomponentid, validfrom, ",
			"validto, coursestatus, weightage, totalcredits, ",
			"extracreditsindicator, extracredits, courseid, memberroleid, learningcomponenttypeid, subjclassificationid)",
			"values (#{learningComponentId,jdbcType=INTEGER}, #{validFrom,jdbcType=DATE}, ",
			"#{validTo,jdbcType=DATE}, #{courseStatus,jdbcType=INTEGER}, ",
			"#{weightage,jdbcType=INTEGER}, #{totalCredits,jdbcType=VARCHAR}, ",
			"#{extraCreditsIndicator,jdbcType=BIT}, #{extraCredits,jdbcType=VARCHAR}, #{courseId,jdbcType=INTEGER}, ",
			"#{memberRoleId,jdbcType=INTEGER}, #{learningComponentTypeId,jdbcType=INTEGER}, #{subjClassificationId,jdbcType=INTEGER} )" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "learningComponentId", before = true, resultType = Integer.class)
	@ResultMap("BaseResultMap")
	LearningComponent saveLearningComponent(LearningComponent record);

}