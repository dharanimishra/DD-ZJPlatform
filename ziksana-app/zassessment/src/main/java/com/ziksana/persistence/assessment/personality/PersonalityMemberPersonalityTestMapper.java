package com.ziksana.persistence.assessment.personality;


public interface PersonalityMemberPersonalityTestMapper {/*

	*//**
	 * This method corresponds to the database table pstmemberpersonalitytest
	 *//*
	@Delete({ "delete from pstmemberpersonalitytest",
			"where MemberPersonalityTestId = #{memberPersonalityTestId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer memberPersonalityTestId);

	*//**
	 * This method corresponds to the database table pstmemberpersonalitytest
	 *//*
	@Insert({
			"insert into pstmemberpersonalitytest (MemberPersonalityTestId, CreationDate, ",
			"DateTestStarted, DateTestEnded, ",
			"CompletedIndicator, RepeatAfter, ",
			"ModelId, TestId, ",
			"MemberRoleId, MemberId)",
			"values (#{memberPersonalityTestId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{dateTestStarted,jdbcType=TIMESTAMP}, #{dateTestEnded,jdbcType=TIMESTAMP}, ",
			"#{completedIndicator,jdbcType=BIT}, #{repeatAfter,jdbcType=INTEGER}, ",
			"#{modelId,jdbcType=INTEGER}, #{testId,jdbcType=INTEGER}, ",
			"#{memberRoleId,jdbcType=INTEGER}, #{memberId,jdbcType=INTEGER})" })
	int insert(PersonalityMemberPersonalityTest record);

	*//**
	 * This method corresponds to the database table pstmemberpersonalitytest
	 *//*
	int insertSelective(PersonalityMemberPersonalityTest record);

	*//**
	 * This method corresponds to the database table pstmemberpersonalitytest
	 *//*
	@Select({
			"select",
			"MemberPersonalityTestId, CreationDate, DateTestStarted, DateTestEnded, CompletedIndicator, ",
			"RepeatAfter, ModelId, TestId, MemberRoleId, MemberId",
			"from pstmemberpersonalitytest",
			"where MemberPersonalityTestId = #{memberPersonalityTestId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	PersonalityMemberPersonalityTest selectByPrimaryKey(
			Integer memberPersonalityTestId);

	*//**
	 * This method corresponds to the database table pstmemberpersonalitytest
	 *//*
	int updateByPrimaryKeySelective(PersonalityMemberPersonalityTest record);

	*//**
	 * This method corresponds to the database table pstmemberpersonalitytest
	 *//*
	@Update({ "update pstmemberpersonalitytest",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"DateTestStarted = #{dateTestStarted,jdbcType=TIMESTAMP},",
			"DateTestEnded = #{dateTestEnded,jdbcType=TIMESTAMP},",
			"CompletedIndicator = #{completedIndicator,jdbcType=BIT},",
			"RepeatAfter = #{repeatAfter,jdbcType=INTEGER},",
			"ModelId = #{modelId,jdbcType=INTEGER},",
			"TestId = #{testId,jdbcType=INTEGER},",
			"MemberRoleId = #{memberRoleId,jdbcType=INTEGER},",
			"MemberId = #{memberId,jdbcType=INTEGER}",
			"where MemberPersonalityTestId = #{memberPersonalityTestId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalityMemberPersonalityTest record);
*/}