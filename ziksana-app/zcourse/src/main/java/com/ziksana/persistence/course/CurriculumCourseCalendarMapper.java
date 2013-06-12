package com.ziksana.persistence.course;


public interface CurriculumCourseCalendarMapper {/*
	*//**
	 * This method corresponds to the database table corcurriculumcoursecalendar
	 *//*
	@Delete({ "delete from corcurriculumcoursecalendar",
			"where currCourseCalendarId = #{currCourseCalendarId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer currCourseCalendarId);

	*//**
	 * This method corresponds to the database table corcurriculumcoursecalendar
	 *//*
	@Insert({
			"insert into corcurriculumcoursecalendar (currCourseCalendarId, CreationDate, ",
			"StartDate, EndDate, StartTime, ",
			"EndTime, Duration, ",
			"ZeniSuggestedIndicator, CurriculumCourseId, ",
			"CourseId, CourseLearningComponentId, ",
			"CurriculumCourseCalendarId, CurriculumDeliveryId)",
			"values (#{currCourseCalendarId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, #{startTime,jdbcType=TIME}, ",
			"#{endTime,jdbcType=TIME}, #{duration,jdbcType=INTEGER}, ",
			"#{zeniSuggestedIndicator,jdbcType=BIT}, #{curriculumCourseId,jdbcType=INTEGER}, ",
			"#{courseId,jdbcType=INTEGER}, #{courseLearningComponentId,jdbcType=INTEGER}, ",
			"#{curriculumCourseCalendarId,jdbcType=INTEGER}, #{curriculumDeliveryId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "currCourseCalendarId", before = true, resultType = Integer.class)
	int insert(CurriculumCourseCalendar record);

	*//**
	 * This method corresponds to the database table corcurriculumcoursecalendar
	 *//*
	int insertSelective(CurriculumCourseCalendar record);

	*//**
	 * This method corresponds to the database table corcurriculumcoursecalendar
	 *//*
	@Select({
			"select",
			"currCourseCalendarId, CreationDate, StartDate, EndDate, StartTime, EndTime, Duration, ZeniSuggestedIndicator, ",
			"CurriculumCourseId, CourseId, CourseLearningComponentId, CurriculumCourseCalendarId, ",
			"CurriculumDeliveryId", "from corcurriculumcoursecalendar",
			"where currCourseCalendarId = #{currCourseCalendarId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CurriculumCourseCalendar selectByPrimaryKey(Integer currCourseCalendarId);

	*//**
	 * This method corresponds to the database table corcurriculumcoursecalendar
	 *//*
	int updateByPrimaryKeySelective(CurriculumCourseCalendar record);

	*//**
	 * This method corresponds to the database table corcurriculumcoursecalendar
	 *//*
	@Update({
			"update corcurriculumcoursecalendar",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"StartDate = #{startDate,jdbcType=DATE},",
			"EndDate = #{endDate,jdbcType=DATE},",
			"StartTime = #{startTime,jdbcType=TIME},",
			"EndTime = #{endTime,jdbcType=TIME},",
			"Duration = #{duration,jdbcType=INTEGER},",
			"ZeniSuggestedIndicator = #{zeniSuggestedIndicator,jdbcType=BIT},",
			"CurriculumCourseId = #{curriculumCourseId,jdbcType=INTEGER},",
			"CourseId = #{courseId,jdbcType=INTEGER},",
			"CourseLearningComponentId = #{courseLearningComponentId,jdbcType=INTEGER},",
			"CurriculumCourseCalendarId = #{curriculumCourseCalendarId,jdbcType=INTEGER},",
			"CurriculumDeliveryId = #{curriculumDeliveryId,jdbcType=INTEGER}",
			"where currCourseCalendarId = #{currCourseCalendarId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CurriculumCourseCalendar record);
*/}