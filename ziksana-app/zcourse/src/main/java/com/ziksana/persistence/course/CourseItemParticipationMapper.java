package com.ziksana.persistence.course;


public interface CourseItemParticipationMapper {/*
	*//**
	 * This method corresponds to the database table sbncourseitemparticipation
	 *//*
	@Delete({ "delete from sbncourseitemparticipation",
			"where courseItemParticipationId = #{courseItemParticipationId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer courseItemParticipationId);

	*//**
	 * This method corresponds to the database table sbncourseitemparticipation
	 *//*
	@Insert({
			"insert into sbncourseitemparticipation (courseItemParticipationId, UsageDate, ",
			"StartTime, EndTime, ",
			"Duration, subCourseItemCalendarId)",
			"values (#{courseItemParticipationId,jdbcType=INTEGER}, #{usageDate,jdbcType=DATE}, ",
			"#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
			"#{duration,jdbcType=INTEGER}, #{subCourseItemCalendarId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "courseItemParticipationId", before = true, resultType = Integer.class)
	int insert(CourseItemParticipation record);

	*//**
	 * This method corresponds to the database table sbncourseitemparticipation
	 *//*
	int insertSelective(CourseItemParticipation record);

	*//**
	 * This method corresponds to the database table sbncourseitemparticipation
	 *//*
	@Select({
			"select",
			"courseItemParticipationId, UsageDate, StartTime, EndTime, Duration, subCourseItemCalendarId",
			"from sbncourseitemparticipation",
			"where courseItemParticipationId = #{courseItemParticipationId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CourseItemParticipation selectByPrimaryKey(Integer courseItemParticipationId);

	*//**
	 * This method corresponds to the database table sbncourseitemparticipation
	 *//*
	int updateByPrimaryKeySelective(CourseItemParticipation record);

	*//**
	 * This method corresponds to the database table sbncourseitemparticipation
	 *//*
	@Update({
			"update sbncourseitemparticipation",
			"set UsageDate = #{usageDate,jdbcType=DATE},",
			"StartTime = #{startTime,jdbcType=TIMESTAMP},",
			"EndTime = #{endTime,jdbcType=TIMESTAMP},",
			"Duration = #{duration,jdbcType=INTEGER},",
			"subCourseItemCalendarId = #{subCourseItemCalendarId,jdbcType=INTEGER}",
			"where courseItemParticipationId = #{courseItemParticipationId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CourseItemParticipation record);
*/}