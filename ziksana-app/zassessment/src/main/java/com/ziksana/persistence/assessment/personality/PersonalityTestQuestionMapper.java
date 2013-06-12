package com.ziksana.persistence.assessment.personality;


public interface PersonalityTestQuestionMapper {/*

	*//**
	 * This method corresponds to the database table psttestquestion
	 *//*
	@Delete({ "delete from psttestquestion",
			"where TestQuestionId = #{testQuestionId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer testQuestionId);

	*//**
	 * This method corresponds to the database table psttestquestion
	 *//*
	@Insert({
			"insert into psttestquestion (TestQuestionId, Sequence, ",
			"VersionUsed, Active, ",
			"TestId, QuestionBankId)",
			"values (#{testQuestionId,jdbcType=INTEGER}, #{sequence,jdbcType=INTEGER}, ",
			"#{versionUsed,jdbcType=INTEGER}, #{active,jdbcType=BIT}, ",
			"#{testId,jdbcType=INTEGER}, #{questionBankId,jdbcType=INTEGER})" })
	int insert(PersonalityTestQuestion record);

	*//**
	 * This method corresponds to the database table psttestquestion
	 *//*
	int insertSelective(PersonalityTestQuestion record);

	*//**
	 * This method corresponds to the database table psttestquestion
	 *//*
	@Select({
			"select",
			"TestQuestionId, Sequence, VersionUsed, Active, TestId, QuestionBankId",
			"from psttestquestion",
			"where TestQuestionId = #{testQuestionId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	PersonalityTestQuestion selectByPrimaryKey(Integer testQuestionId);

	*//**
	 * This method corresponds to the database table psttestquestion
	 *//*
	int updateByPrimaryKeySelective(PersonalityTestQuestion record);

	*//**
	 * This method corresponds to the database table psttestquestion
	 *//*
	@Update({ "update psttestquestion",
			"set Sequence = #{sequence,jdbcType=INTEGER},",
			"VersionUsed = #{versionUsed,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT},",
			"TestId = #{testId,jdbcType=INTEGER},",
			"QuestionBankId = #{questionBankId,jdbcType=INTEGER}",
			"where TestQuestionId = #{testQuestionId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalityTestQuestion record);
*/}