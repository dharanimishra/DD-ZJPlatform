package com.ziksana.persistence.course;


public interface CurriculumCourseMapper {/*

	*//**
	 * This method corresponds to the database table corcurriculumcourse
	 *//*
	@Delete({ "delete from corcurriculumcourse",
			"where curriculumCourseId = #{curriculumCourseId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer curriculumCourseId);

	*//**
	 * This method corresponds to the database table corcurriculumcourse
	 *//*
	@Insert({
			"insert into corcurriculumcourse (curriculumCourseId, CreationDate, ",
			"Active, CurriculumUseType, ",
			"CurriculumCourseIdentifier, CourseVersionUsed, ",
			"CourseWeightage, GradeType, ",
			"CourseCredit, ZiksanaOnlyIndicator, ",
			"ClassroomIndicator, CombinedIndicator, ",
			"NoSyncConstraintIndicator, SyncAfterClass, ",
			"SyncBeforeClass, CourseStartDate, ",
			"CourseEndDate, ",
			"OverallLearnerRating, OverallPeerRating, ",
			"ContentSecurityNeededIndicator, TotalCredits, ",
			"ExtraCredits, CourseLevelOveriddenIndicator, ProgramCurriculumId, ",
			"CourseId)",
			"values (#{curriculumCourseId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, #{curriculumUseType,jdbcType=INTEGER}, ",
			"#{curriculumCourseIdentifier,jdbcType=VARCHAR}, #{courseVersionUsed,jdbcType=INTEGER}, ",
			"#{courseWeightage,jdbcType=INTEGER}, #{gradeType,jdbcType=INTEGER}, ",
			"#{courseCredit,jdbcType=INTEGER}, #{ziksanaOnlyIndicator,jdbcType=BIT}, ",
			"#{classroomIndicator,jdbcType=BIT}, #{combinedIndicator,jdbcType=BIT}, ",
			"#{noSyncConstraintIndicator,jdbcType=BIT}, #{syncAfterClass,jdbcType=INTEGER}, ",
			"#{syncBeforeClass,jdbcType=INTEGER}, #{courseStartDate,jdbcType=TIMESTAMP}, ",
			"#{courseEndDate,jdbcType=TIMESTAMP}, ",
			"#{overallLearnerRating,jdbcType=INTEGER}, #{overallPeerRating,jdbcType=INTEGER}, ",
			"#{contentSecurityNeededIndicator,jdbcType=BIT}, #{totalCredits,jdbcType=VARCHAR}, ",
			"#{extraCredits,jdbcType=VARCHAR}, #{courseLevelOveriddenIndicator,jdbcType=TINYINT}, #{programCurriculumId,jdbcType=INTEGER}, ",
			"#{courseId,jdbcType=INTEGER})" })
	int insert(CurriculumCourse record);

	*//**
	 * This method corresponds to the database table corcurriculumcourse
	 *//*
	int insertSelective(CurriculumCourse record);

	*//**
	 * This method corresponds to the database table corcurriculumcourse
	 *//*
	@Select({
			"select",
			"curriculumCourseId, CreationDate, Active, CurriculumUseType, CurriculumCourseIdentifier, CourseVersionUsed, ",
			"CourseWeightage, GradeType, CourseCredit, ZiksanaOnlyIndicator, ClassroomIndicator, ",
			"CombinedIndicator, NoSyncConstraintIndicator, SyncAfterClass, SyncBeforeClass, ",
			"CourseStartDate, CourseEndDate, OverallLearnerRating, OverallPeerRating, ",
			"ContentSecurityNeededIndicator, TotalCredits, ExtraCredits, courseLevelOveriddenIndicator, ProgramCurriculumId, ",
			"CourseId", "from corcurriculumcourse",
			"where curriculumCourseId = #{curriculumCourseId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	CurriculumCourse selectByPrimaryKey(Integer curriculumCourseId);

	*//**
	 * This method corresponds to the database table corcurriculumcourse
	 *//*
	int updateByPrimaryKeySelective(CurriculumCourse record);

	*//**
	 * This method corresponds to the database table corcurriculumcourse
	 *//*
	@Update({
			"update corcurriculumcourse",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"Active = #{active,jdbcType=BIT},",
			"CurriculumUseType = #{curriculumUseType,jdbcType=INTEGER},",
			"CurriculumCourseIdentifier = #{curriculumCourseIdentifier,jdbcType=VARCHAR},",
			"CourseVersionUsed = #{courseVersionUsed,jdbcType=INTEGER},",
			"CourseWeightage = #{courseWeightage,jdbcType=INTEGER},",
			"GradeType = #{gradeType,jdbcType=INTEGER},",
			"CourseCredit = #{courseCredit,jdbcType=INTEGER},",
			"ZiksanaOnlyIndicator = #{ziksanaOnlyIndicator,jdbcType=BIT},",
			"ClassroomIndicator = #{classroomIndicator,jdbcType=BIT},",
			"CombinedIndicator = #{combinedIndicator,jdbcType=BIT},",
			"NoSyncConstraintIndicator = #{noSyncConstraintIndicator,jdbcType=BIT},",
			"SyncAfterClass = #{syncAfterClass,jdbcType=INTEGER},",
			"SyncBeforeClass = #{syncBeforeClass,jdbcType=INTEGER},",
			"CourseStartDate = #{courseStartDate,jdbcType=TIMESTAMP},",
			"CourseEndDate = #{courseEndDate,jdbcType=TIMESTAMP},",
			"OverallLearnerRating = #{overallLearnerRating,jdbcType=INTEGER},",
			"OverallPeerRating = #{overallPeerRating,jdbcType=INTEGER},",
			"ContentSecurityNeededIndicator = #{contentSecurityNeededIndicator,jdbcType=BIT},",
			"TotalCredits = #{totalCredits,jdbcType=VARCHAR},",
			"ExtraCredits = #{extraCredits,jdbcType=VARCHAR},",
			"CourseLevelOveriddenIndicator=#{courseLevelOveriddenIndicator,jdbcType=TINYINT}, ",
			"ProgramCurriculumId = #{programCurriculumId,jdbcType=INTEGER},",
			"CourseId = #{courseId,jdbcType=INTEGER}",
			"where curriculumCourseId = #{curriculumCourseId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CurriculumCourse record);
*/}