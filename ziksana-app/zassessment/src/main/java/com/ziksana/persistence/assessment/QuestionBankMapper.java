package com.ziksana.persistence.assessment;

import com.ziksana.domain.assessment.QuestionBank;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface QuestionBankMapper {

	/**
	 * This method corresponds to the database table asmquestionbank
	 */
	@Delete({ "delete from asmquestionbank",
			"where QuestionBankId = #{questionBankId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer questionBankId);

	/**
	 * This method corresponds to the database table asmquestionbank
	 */
	@Insert({
			"insert into asmquestionbank (QuestionBankId, CreationDate, ",
			"Active, DifficultyLevel, ",
			"ProficiencyLevel, QuestionType, ",
			"QuestionContent, AdditionalInfoPath, ",
			"Instruction, MultipleCorrectAnswerIndicator, ",
			"GroupWorkIndicator, Status, ",
			"QuestionApplicabilityType, SubjClassificationId, ",
			"MemberId)",
			"values (#{questionBankId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, #{difficultyLevel,jdbcType=INTEGER}, ",
			"#{proficiencyLevel,jdbcType=INTEGER}, #{questionType,jdbcType=INTEGER}, ",
			"#{questionContent,jdbcType=VARCHAR}, #{additionalInfoPath,jdbcType=VARCHAR}, ",
			"#{instruction,jdbcType=VARCHAR}, #{multipleCorrectAnswerIndicator,jdbcType=BIT}, ",
			"#{groupWorkIndicator,jdbcType=BIT}, #{status,jdbcType=INTEGER}, ",
			"#{questionApplicabilityType,jdbcType=INTEGER}, #{subjClassificationId,jdbcType=INTEGER}, ",
			"#{memberId,jdbcType=INTEGER})" })
	int insert(QuestionBank record);

	/**
	 * This method corresponds to the database table asmquestionbank
	 */
	int insertSelective(QuestionBank record);

	/**
	 * This method corresponds to the database table asmquestionbank
	 */
	@Select({
			"select",
			"QuestionBankId, CreationDate, Active, DifficultyLevel, ProficiencyLevel, QuestionType, ",
			"QuestionContent, AdditionalInfoPath, Instruction, MultipleCorrectAnswerIndicator, ",
			"GroupWorkIndicator, Status, QuestionApplicabilityType, SubjClassificationId, ",
			"MemberId", "from asmquestionbank",
			"where QuestionBankId = #{questionBankId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	QuestionBank selectByPrimaryKey(Integer questionBankId);

	/**
	 * This method corresponds to the database table asmquestionbank
	 */
	int updateByPrimaryKeySelective(QuestionBank record);

	/**
	 * This method corresponds to the database table asmquestionbank
	 */
	@Update({
			"update asmquestionbank",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"Active = #{active,jdbcType=BIT},",
			"DifficultyLevel = #{difficultyLevel,jdbcType=INTEGER},",
			"ProficiencyLevel = #{proficiencyLevel,jdbcType=INTEGER},",
			"QuestionType = #{questionType,jdbcType=INTEGER},",
			"QuestionContent = #{questionContent,jdbcType=VARCHAR},",
			"AdditionalInfoPath = #{additionalInfoPath,jdbcType=VARCHAR},",
			"Instruction = #{instruction,jdbcType=VARCHAR},",
			"MultipleCorrectAnswerIndicator = #{multipleCorrectAnswerIndicator,jdbcType=BIT},",
			"GroupWorkIndicator = #{groupWorkIndicator,jdbcType=BIT},",
			"Status = #{status,jdbcType=INTEGER},",
			"QuestionApplicabilityType = #{questionApplicabilityType,jdbcType=INTEGER},",
			"SubjClassificationId = #{subjClassificationId,jdbcType=INTEGER},",
			"MemberId = #{memberId,jdbcType=INTEGER}",
			"where QuestionBankId = #{questionBankId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(QuestionBank record);
}