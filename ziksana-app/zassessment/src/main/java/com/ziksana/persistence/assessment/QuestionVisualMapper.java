package com.ziksana.persistence.assessment;


public interface QuestionVisualMapper {/*

	*//**
	 * This method corresponds to the database table asmquestionvisual
	 *//*
	@Delete({ "delete from asmquestionvisual",
			"where QuestionVisualId = #{questionVisualId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer questionVisualId);

	*//**
	 * This method corresponds to the database table asmquestionvisual
	 *//*
	@Insert({
			"insert into asmquestionvisual (QuestionVisualId, CreationDate, ",
			"Active, VisualType, ",
			"VisualPath, InternalIndicator, ",
			"VisualSource, QuestionBankId)",
			"values (#{questionVisualId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, #{visualType,jdbcType=INTEGER}, ",
			"#{visualPath,jdbcType=VARCHAR}, #{internalIndicator,jdbcType=BIT}, ",
			"#{visualSource,jdbcType=INTEGER}, #{questionBankId,jdbcType=INTEGER})" })
	int insert(QuestionVisual record);

	*//**
	 * This method corresponds to the database table asmquestionvisual
	 *//*
	int insertSelective(QuestionVisual record);

	*//**
	 * This method corresponds to the database table asmquestionvisual
	 *//*
	@Select({
			"select",
			"QuestionVisualId, CreationDate, Active, VisualType, VisualPath, InternalIndicator, ",
			"VisualSource, QuestionBankId", "from asmquestionvisual",
			"where QuestionVisualId = #{questionVisualId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	QuestionVisual selectByPrimaryKey(Integer questionVisualId);

	*//**
	 * This method corresponds to the database table asmquestionvisual
	 *//*
	int updateByPrimaryKeySelective(QuestionVisual record);

	*//**
	 * This method corresponds to the database table asmquestionvisual
	 *//*
	@Update({ "update asmquestionvisual",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"Active = #{active,jdbcType=BIT},",
			"VisualType = #{visualType,jdbcType=INTEGER},",
			"VisualPath = #{visualPath,jdbcType=VARCHAR},",
			"InternalIndicator = #{internalIndicator,jdbcType=BIT},",
			"VisualSource = #{visualSource,jdbcType=INTEGER},",
			"QuestionBankId = #{questionBankId,jdbcType=INTEGER}",
			"where QuestionVisualId = #{questionVisualId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(QuestionVisual record);
*/}