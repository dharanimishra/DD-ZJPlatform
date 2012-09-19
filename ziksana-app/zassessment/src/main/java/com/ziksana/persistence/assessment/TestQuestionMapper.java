package com.ziksana.persistence.assessment;

import com.ziksana.domain.assessment.TestQuestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TestQuestionMapper {

	/**
	 * This method corresponds to the database table asmtestquestion
	 */
	@Delete({ "delete from asmtestquestion",
			"where TestQuestionId = #{testQuestionId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer testQuestionId);

	/**
	 * This method corresponds to the database table asmtestquestion
	 */
	@Insert({
			"insert into asmtestquestion (TestQuestionId, CreationDate, ",
			"Active, PointsIfCorrect, ",
			"ExtraCreditPoints, PenaltyIfIncorrectIndicator, ",
			"PenaltyFactor, AnswerWithinTime, ",
			"QuestionContentMarkup, VideoAnswerAllowedIndicator, ",
			"AudioAnwerAllowedIndicator, AssignmentTestId, ",
			"QuestionBankId)",
			"values (#{testQuestionId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, #{pointsIfCorrect,jdbcType=INTEGER}, ",
			"#{extraCreditPoints,jdbcType=INTEGER}, #{penaltyIfIncorrectIndicator,jdbcType=BIT}, ",
			"#{penaltyFactor,jdbcType=INTEGER}, #{answerWithinTime,jdbcType=INTEGER}, ",
			"#{questionContentMarkup,jdbcType=VARCHAR}, #{videoAnswerAllowedIndicator,jdbcType=BIT}, ",
			"#{audioAnwerAllowedIndicator,jdbcType=BIT}, #{assignmentTestId,jdbcType=INTEGER}, ",
			"#{questionBankId,jdbcType=INTEGER})" })
	int insert(TestQuestion record);

	/**
	 * This method corresponds to the database table asmtestquestion
	 */
	int insertSelective(TestQuestion record);

	/**
	 * This method corresponds to the database table asmtestquestion
	 */
	@Select({
			"select",
			"TestQuestionId, CreationDate, Active, PointsIfCorrect, ExtraCreditPoints, PenaltyIfIncorrectIndicator, ",
			"PenaltyFactor, AnswerWithinTime, QuestionContentMarkup, VideoAnswerAllowedIndicator, ",
			"AudioAnwerAllowedIndicator, AssignmentTestId, QuestionBankId",
			"from asmtestquestion",
			"where TestQuestionId = #{testQuestionId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	TestQuestion selectByPrimaryKey(Integer testQuestionId);

	/**
	 * This method corresponds to the database table asmtestquestion
	 */
	int updateByPrimaryKeySelective(TestQuestion record);

	/**
	 * This method corresponds to the database table asmtestquestion
	 */
	@Update({
			"update asmtestquestion",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"Active = #{active,jdbcType=BIT},",
			"PointsIfCorrect = #{pointsIfCorrect,jdbcType=INTEGER},",
			"ExtraCreditPoints = #{extraCreditPoints,jdbcType=INTEGER},",
			"PenaltyIfIncorrectIndicator = #{penaltyIfIncorrectIndicator,jdbcType=BIT},",
			"PenaltyFactor = #{penaltyFactor,jdbcType=INTEGER},",
			"AnswerWithinTime = #{answerWithinTime,jdbcType=INTEGER},",
			"QuestionContentMarkup = #{questionContentMarkup,jdbcType=VARCHAR},",
			"VideoAnswerAllowedIndicator = #{videoAnswerAllowedIndicator,jdbcType=BIT},",
			"AudioAnwerAllowedIndicator = #{audioAnwerAllowedIndicator,jdbcType=BIT},",
			"AssignmentTestId = #{assignmentTestId,jdbcType=INTEGER},",
			"QuestionBankId = #{questionBankId,jdbcType=INTEGER}",
			"where TestQuestionId = #{testQuestionId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(TestQuestion record);
}