package com.ziksana.persistence.course;


public interface CourseGradeMapper {/*
	*//**
	 * This method corresponds to the database table sbncoursegrade
	 *//*
	@Delete({ "delete from sbncoursegrade", "where ID = #{ID,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer ID);

	*//**
	 * This method corresponds to the database table sbncoursegrade
	 *//*
	@Insert({
			"insert into sbncoursegrade (ID, CreationDate, ",
			"GradeStatus, OverallGrade, ",
			"AttendancebasedGrade, ParticipationbasedGrade, ",
			"PeerWorkbasedGrade, BadgebasedGrade, ",
			"ComparativePositioninTerm, ComparativePositionOverall, ",
			"OverallReflectionComment, SubscriptionCourseId)",
			"values (#{ID,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{gradeStatus,jdbcType=INTEGER}, #{overallGrade,jdbcType=INTEGER}, ",
			"#{attendancebasedGrade,jdbcType=INTEGER}, #{participationbasedGrade,jdbcType=INTEGER}, ",
			"#{peerWorkbasedGrade,jdbcType=INTEGER}, #{badgebasedGrade,jdbcType=INTEGER}, ",
			"#{comparativePositioninTerm,jdbcType=INTEGER}, #{comparativePositionOverall,jdbcType=INTEGER}, ",
			"#{overallReflectionComment,jdbcType=VARCHAR}, #{subscriptionCourseId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "ID", before = true, resultType = Integer.class)
	int insert(CourseGrade record);

	*//**
	 * This method corresponds to the database table sbncoursegrade
	 *//*
	int insertSelective(CourseGrade record);

	*//**
	 * This method corresponds to the database table sbncoursegrade
	 *//*
	@Select({
			"select",
			"ID, CreationDate, GradeStatus, OverallGrade, AttendancebasedGrade, ParticipationbasedGrade, ",
			"PeerWorkbasedGrade, BadgebasedGrade, ComparativePositioninTerm, ComparativePositionOverall, ",
			"OverallReflectionComment, SubscriptionCourseId",
			"from sbncoursegrade", "where ID = #{ID,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CourseGrade selectByPrimaryKey(Integer ID);

	*//**
	 * This method corresponds to the database table sbncoursegrade
	 *//*
	int updateByPrimaryKeySelective(CourseGrade record);

	*//**
	 * This method corresponds to the database table sbncoursegrade
	 *//*
	@Update({
			"update sbncoursegrade",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"GradeStatus = #{gradeStatus,jdbcType=INTEGER},",
			"OverallGrade = #{overallGrade,jdbcType=INTEGER},",
			"AttendancebasedGrade = #{attendancebasedGrade,jdbcType=INTEGER},",
			"ParticipationbasedGrade = #{participationbasedGrade,jdbcType=INTEGER},",
			"PeerWorkbasedGrade = #{peerWorkbasedGrade,jdbcType=INTEGER},",
			"BadgebasedGrade = #{badgebasedGrade,jdbcType=INTEGER},",
			"ComparativePositioninTerm = #{comparativePositioninTerm,jdbcType=INTEGER},",
			"ComparativePositionOverall = #{comparativePositionOverall,jdbcType=INTEGER},",
			"OverallReflectionComment = #{overallReflectionComment,jdbcType=VARCHAR},",
			"SubscriptionCourseId = #{subscriptionCourseId,jdbcType=INTEGER}",
			"where ID = #{ID,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CourseGrade record);
*/}