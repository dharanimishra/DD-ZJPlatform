package com.ziksana.persistence.assessment;


public interface QuestionBankAnswerMapper {/*

	*//**
	 * This method corresponds to the database table asmquestionbankanswer
	 *//*
	@Delete({ "delete from asmquestionbankanswer",
			"where QuestionBankAnswerId = #{questionBankAnswerId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer questionBankAnswerId);

	*//**
	 * This method corresponds to the database table asmquestionbankanswer
	 *//*
	@Insert({
			"insert into asmquestionbankanswer (QuestionBankAnswerId, CreationDate, ",
			"Active, AnswerContent, ",
			"CorrectnessIndicator, AnswerSequence, ",
			"AnswerReflectionComment, AnswerKeywordWeight, ",
			"Status, QuestionBankId, ",
			"MatchingQuestionBankAnswerId, VisualSpotId)",
			"values (#{questionBankAnswerId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, #{answerContent,jdbcType=VARCHAR}, ",
			"#{correctnessIndicator,jdbcType=BIT}, #{answerSequence,jdbcType=INTEGER}, ",
			"#{answerReflectionComment,jdbcType=VARCHAR}, #{answerKeywordWeight,jdbcType=INTEGER}, ",
			"#{status,jdbcType=INTEGER}, #{questionBankId,jdbcType=INTEGER}, ",
			"#{matchingQuestionBankAnswerId,jdbcType=INTEGER}, #{visualSpotId,jdbcType=INTEGER})" })
	int insert(QuestionBankAnswer record);

	*//**
	 * This method corresponds to the database table asmquestionbankanswer
	 *//*
	int insertSelective(QuestionBankAnswer record);

	*//**
	 * This method corresponds to the database table asmquestionbankanswer
	 *//*
	@Select({
			"select",
			"QuestionBankAnswerId, CreationDate, Active, AnswerContent, CorrectnessIndicator, ",
			"AnswerSequence, AnswerReflectionComment, AnswerKeywordWeight, Status, QuestionBankId, ",
			"MatchingQuestionBankAnswerId, VisualSpotId",
			"from asmquestionbankanswer",
			"where QuestionBankAnswerId = #{questionBankAnswerId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	QuestionBankAnswer selectByPrimaryKey(Integer questionBankAnswerId);

	*//**
	 * This method corresponds to the database table asmquestionbankanswer
	 *//*
	int updateByPrimaryKeySelective(QuestionBankAnswer record);

	*//**
	 * This method corresponds to the database table asmquestionbankanswer
	 *//*
	@Update({
			"update asmquestionbankanswer",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"Active = #{active,jdbcType=BIT},",
			"AnswerContent = #{answerContent,jdbcType=VARCHAR},",
			"CorrectnessIndicator = #{correctnessIndicator,jdbcType=BIT},",
			"AnswerSequence = #{answerSequence,jdbcType=INTEGER},",
			"AnswerReflectionComment = #{answerReflectionComment,jdbcType=VARCHAR},",
			"AnswerKeywordWeight = #{answerKeywordWeight,jdbcType=INTEGER},",
			"Status = #{status,jdbcType=INTEGER},",
			"QuestionBankId = #{questionBankId,jdbcType=INTEGER},",
			"MatchingQuestionBankAnswerId = #{matchingQuestionBankAnswerId,jdbcType=INTEGER},",
			"VisualSpotId = #{visualSpotId,jdbcType=INTEGER}",
			"where QuestionBankAnswerId = #{questionBankAnswerId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(QuestionBankAnswer record);
*/}