package com.ziksana.persistence.course;


public interface CourseTagcloudMapper {/*
	*//**
	 * This method corresponds to the database table corcoursetagcloud
	 *//*
	@Delete({ "delete from corcoursetagcloud",
			"where courseTagCloudId = #{courseTagCloudId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer courseTagCloudId);

	*//**
	 * This method corresponds to the database table corcoursetagcloud
	 *//*
	@Insert({
			"insert into corcoursetagcloud (courseTagCloudId, CreationDate, ",
			"TagName, TagType, ",
			"ZeniSuggestedIndicator, CourseId, ",
			"MemberRoleId)",
			"values (#{courseTagCloudId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{tagName,jdbcType=VARCHAR}, #{tagType,jdbcType=INTEGER}, ",
			"#{zeniSuggestedIndicator,jdbcType=BIT}, #{courseId,jdbcType=INTEGER}, ",
			"#{memberRoleId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "courseTagCloudId", before = true, resultType = Integer.class)
	int insert(CourseTagcloud record);

	*//**
	 * This method corresponds to the database table corcoursetagcloud
	 *//*
	int insertSelective(CourseTagcloud record);

	*//**
	 * This method corresponds to the database table corcoursetagcloud
	 *//*
	@Select({
			"select",
			"courseTagCloudId, CreationDate, TagName, TagType, ZeniSuggestedIndicator, CourseId, MemberRoleId",
			"from corcoursetagcloud", "where courseTagCloudId = #{courseTagCloudId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CourseTagcloud selectByPrimaryKey(Integer courseTagCloudId);

	*//**
	 * This method corresponds to the database table corcoursetagcloud
	 *//*
	int updateByPrimaryKeySelective(CourseTagcloud record);

	*//**
	 * This method corresponds to the database table corcoursetagcloud
	 *//*
	@Update({ "update corcoursetagcloud",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"TagName = #{tagName,jdbcType=VARCHAR},",
			"TagType = #{tagType,jdbcType=INTEGER},",
			"ZeniSuggestedIndicator = #{zeniSuggestedIndicator,jdbcType=BIT},",
			"CourseId = #{courseId,jdbcType=INTEGER},",
			"MemberRoleId = #{memberRoleId,jdbcType=INTEGER}",
			"where courseTagCloudId = #{courseTagCloudId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CourseTagcloud record);
*/}