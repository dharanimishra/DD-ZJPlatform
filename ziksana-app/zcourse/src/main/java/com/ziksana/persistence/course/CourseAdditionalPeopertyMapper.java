package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CourseAdditionalProperty;

public interface CourseAdditionalPeopertyMapper {

	/**
	 * This method corresponds to the database table corcourseadditionalproperty
	 */
	@Delete({ "delete from corcourseadditionalproperty",
			"where courseAddnlPropertyId = #{courseAddnlPropertyId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer courseAddnlPropertyId);

	/**
	 * This method corresponds to the database table corcourseadditionalproperty
	 */
	@Insert({
			"insert into corcourseadditionalproperty (courseAddnlPropertyId, CreationDate, ",
			"PropertyUsageType, PropertyName, ",
			"PropertyDataType, PropertyValue, ",
			"Sequence, Active, CourseId, ",
			"MemberRoleId)",
			"values (#{courseAddnlPropertyId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{propertyUsageType,jdbcType=INTEGER}, #{propertyName,jdbcType=VARCHAR}, ",
			"#{propertyDataType,jdbcType=INTEGER}, #{propertyValue,jdbcType=VARCHAR}, ",
			"#{sequence,jdbcType=INTEGER}, #{active,jdbcType=BIT}, #{courseId,jdbcType=INTEGER}, ",
			"#{memberRoleId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "courseAddnlPropertyId", before = true, resultType = Integer.class)
	int insert(CourseAdditionalProperty record);

	/**
	 * This method corresponds to the database table corcourseadditionalproperty
	 */
	int insertSelective(CourseAdditionalProperty record);

	/**
	 * This method corresponds to the database table corcourseadditionalproperty
	 */
	@Select({
			"select",
			"courseAddnlPropertyId, CreationDate, PropertyUsageType, PropertyName, PropertyDataType, PropertyValue, ",
			"Sequence, Active, CourseId, MemberRoleId",
			"from corcourseadditionalproperty",
			"where courseAddnlPropertyId = #{courseAddnlPropertyId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CourseAdditionalProperty selectByPrimaryKey(Integer courseAddnlPropertyId);

	/**
	 * This method corresponds to the database table corcourseadditionalproperty
	 */
	int updateByPrimaryKeySelective(CourseAdditionalProperty record);

	/**
	 * This method corresponds to the database table corcourseadditionalproperty
	 */
	@Update({ "update corcourseadditionalproperty",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"PropertyUsageType = #{propertyUsageType,jdbcType=INTEGER},",
			"PropertyName = #{propertyName,jdbcType=VARCHAR},",
			"PropertyDataType = #{propertyDataType,jdbcType=INTEGER},",
			"PropertyValue = #{propertyValue,jdbcType=VARCHAR},",
			"Sequence = #{sequence,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT},",
			"CourseId = #{courseId,jdbcType=INTEGER},",
			"MemberRoleId = #{memberRoleId,jdbcType=INTEGER}",
			"where courseAddnlPropertyId = #{courseAddnlPropertyId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CourseAdditionalProperty record);
}