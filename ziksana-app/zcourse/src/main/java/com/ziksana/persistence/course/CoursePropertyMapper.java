package com.ziksana.persistence.course;


public interface CoursePropertyMapper {/*
	*//**
	 * This method corresponds to the database table sbncourseproperty
	 *//*
	@Delete({ "delete from sbncourseproperty",
			"where coursepropertyid = #{coursePropertyId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer coursePropertyId);

	*//**
	 * This method corresponds to the database table sbncourseproperty
	 *//*
	@Insert({
			"insert into sbncourseproperty (coursepropertyid, creationdate, ",
			"propertyname, propertyvalue, ",
			"active, subscriptioncourseid, ",
			"currcoursepropertyid)",
			"values (#{coursePropertyId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{propertyName,jdbcType=INTEGER}, #{propertyValue,jdbcType=VARCHAR}, ",
			"#{active,jdbcType=BIT}, #{subscriptionCourseId,jdbcType=INTEGER}, ",
			"#{currCoursePropertyId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "coursePropertyId", before = true, resultType = Integer.class)
	int insert(CourseProperty record);

	*//**
	 * This method corresponds to the database table sbncourseproperty
	 *//*
	int insertSelective(CourseProperty record);

	*//**
	 * This method corresponds to the database table sbncourseproperty
	 *//*
	@Select({
			"select",
			"coursepropertyid, creationdate, propertyname, propertyvalue, active, subscriptioncourseid, ",
			"currcoursepropertyid", "from sbncourseproperty",
			"where coursepropertyid = #{coursePropertyId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CourseProperty selectByPrimaryKey(Integer coursePropertyId);

	*//**
	 * This method corresponds to the database table sbncourseproperty
	 *//*
	int updateByPrimaryKeySelective(CourseProperty record);

	*//**
	 * This method corresponds to the database table sbncourseproperty
	 *//*
	@Update({
			"update sbncourseproperty",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"PropertyName = #{propertyName,jdbcType=INTEGER},",
			"PropertyValue = #{propertyValue,jdbcType=VARCHAR},",
			"Active = #{active,jdbcType=BIT},",
			"SubscriptionCourseId = #{subscriptionCourseId,jdbcType=INTEGER},",
			"CurrCoursePropertyId = #{currCoursePropertyId,jdbcType=INTEGER}",
			"where coursePropertyId = #{coursePropertyId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CourseProperty record);
*/}