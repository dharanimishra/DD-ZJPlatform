package com.ziksana.persistence.assessment.member;


public interface CourseAssignmentMapper {/*
	*//**
	 * This method corresponds to the database table msmcourseassignment
	 *//*
	@Delete({ "delete from msmcourseassignment",
			"where CourseAssignmentId = #{courseAssignmentId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer courseAssignmentId);

	*//**
	 * This method corresponds to the database table msmcourseassignment
	 *//*
	@Insert({
			"insert into msmcourseassignment (CourseAssignmentId, AssignmentName, ",
			"StartDate, EndDate, ",
			"Duration, Effort, ",
			"Active, Progress, SubscriptionCourseId, ",
			"LearningComponentId)",
			"values (#{courseAssignmentId,jdbcType=INTEGER}, #{assignmentName,jdbcType=VARCHAR}, ",
			"#{startDate,jdbcType=TIMESTAMP}, #{endDate,jdbcType=TIMESTAMP}, ",
			"#{duration,jdbcType=INTEGER}, #{effort,jdbcType=INTEGER}, ",
			"#{active,jdbcType=BIT}, #{progress,jdbcType=INTEGER}, #{subscriptionCourseId,jdbcType=INTEGER}, ",
			"#{learningComponentId,jdbcType=INTEGER})" })
	int insert(CourseAssignment record);

	*//**
	 * This method corresponds to the database table msmcourseassignment
	 *//*
	int insertSelective(CourseAssignment record);

	*//**
	 * This method corresponds to the database table msmcourseassignment
	 *//*
	@Select({
			"select",
			"CourseAssignmentId, AssignmentName, StartDate, EndDate, Duration, Effort, Active, ",
			"Progress, SubscriptionCourseId, LearningComponentId",
			"from msmcourseassignment",
			"where CourseAssignmentId = #{courseAssignmentId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CourseAssignment selectByPrimaryKey(Integer courseAssignmentId);

	*//**
	 * This method corresponds to the database table msmcourseassignment
	 *//*
	int updateByPrimaryKeySelective(CourseAssignment record);

	*//**
	 * This method corresponds to the database table msmcourseassignment
	 *//*
	@Update({ "update msmcourseassignment",
			"set AssignmentName = #{assignmentName,jdbcType=VARCHAR},",
			"StartDate = #{startDate,jdbcType=TIMESTAMP},",
			"EndDate = #{endDate,jdbcType=TIMESTAMP},",
			"Duration = #{duration,jdbcType=INTEGER},",
			"Effort = #{effort,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT},",
			"Progress = #{progress,jdbcType=INTEGER},",
			"SubscriptionCourseId = #{subscriptionCourseId,jdbcType=INTEGER},",
			"LearningComponentId = #{learningComponentId,jdbcType=INTEGER}",
			"where CourseAssignmentId = #{courseAssignmentId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CourseAssignment record);
*/}