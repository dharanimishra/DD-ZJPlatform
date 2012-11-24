package com.ziksana.persistence.assessment;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.assessment.QuestionBank;
import com.ziksana.domain.assessment.TestQuestion;
import com.ziksana.service.assignment.impl.QuestionSearchCriteria;
public interface TestQuestionMapper {
	
	/**
	 * @param testQuestion
	 */
	Integer saveTestQuestion(TestQuestion testQuestion);

	/**
	 * @param testQuestion
	 */
	Integer updateTestQuestion(TestQuestion testQuestion);

	/**
	 * This method corresponds to the database table asmtestquestion
	 */
	@Delete({ "delete from asmtestquestion",
			"where TestQuestionId = #{testQuestionId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer testQuestionId);

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
	 * @param testId
	 * @return
	 */
	@Select({ "select testquestionid, questionbankid from  asmtestquestion where testid = #{testId,jdbcType=INTEGER} and isdelete = 'false' " })
	@Results(value = {
			@Result(property = "testQuestionId", column = "testquestionid"),
			@Result(property = "questionBankId", column = "questionbankid"),
			@Result(property = "questionBank", column = "testQuestionId", javaType = QuestionBank.class, one = @One(select = "selectQuestionBank")) })
	List<TestQuestion> getTestQuestions(@Param("testId") Integer testId);

	/**
	 * @param testQuestionId
	 * @return
	 */
	@Select({
			"select questionbankid, questioncontent as name, questiontype, instruction, memberid  from  asmquestionbank  where ",
			"testQuestionId = #{testQuestionId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "questionBankId", column = "questionbankid"),
			@Result(property = "instruction", column = "instruction"),
			@Result(property = "owningMember.memberId", column = "memberid"),
			@Result(property = "questionType", column = "questiontype"),
			@Result(property = "name", column = "questioncontent") })
	QuestionBank selectQuestionBank(Integer testQuestionId);


	@Update({
		"update asmtestquestion set marks=#{marks, jdbcType=INTEGER}, answerwithintime=#{answerWithInTime,jdbcType=INTEGER },",
		" panaltyfactor=#{penaltyMarks,jdbcType=INTEGER}",
		" where testquestionid = #{testQuestiondId, jdbcType=INTEGER}" })
	void updateTestQuestionOptions(TestQuestion testQuestion);
	
	
	/**
	 * This performs the full/advanced search
	 * @param searchCriteria
	 * @return
	 */
	@Select({ "selecgt name, questionbankid, memberid, questiontype from asmquestionbank where name like #{name,jdbcType=VARCHAR} " })
	@Results(value = {
			@Result(property = "questionBankId", column = "questionbankid"),
			@Result(property = "owningMember.memberId", column = "memberid"),
			@Result(property = "questionType", column = "questiontype"),
			@Result(property = "name", column = "questioncontent"), })
	List<QuestionBank> searchQuestions(QuestionSearchCriteria searchCriteria);

	/**
	 * @param qtnBank
	 */
	@Update({
			"update asmquestionbank set difficultylevel=#{difficultyLevel , jdbcType=INTEGER}, profficiencylevel=#{proficiencyLeveel, jdbcType=INTEGER}, ",
			"questiontype=#{questionType, jdbcType=INTEGER}, ",
			"questioncontent=#{name, jdbcType=VARCHAR}, instruction=#{instruction, jdbcType=VARCHAR},",
			" ismulticorrectanswer=#{isMultiCorrectAnswer,jdbcType=BOOLEAN}, additionalinfopath=#{additionalInfoPath, jdbcType=VARCHAR} ,",
			"isgroupwork=#{isGroupWork,jdbcType=BOOLEAN} , questionapplicabilitytype=#{questionApplicabilityType, jdbcType=INTEGER} ",
			" where questionbankid=#{questionBankId, jdbcType=INTEGER}" })
	void updateQuestionBank(QuestionBank qtnBank);

	/**
	 * This performs the basic search
	 * @param name
	 * @return
	 */
	@Select({ "select name, questionbankid,memberid,questiontype from asmquestionbank where name like #{name,jdbcType=VARCHAR} " })
	@Results(value = {
			@Result(property = "questionBankId", column = "questionbankid"),
			@Result(property = "owningMember.memberId", column = "memberid"),
			@Result(property = "questionType", column = "questiontype"),
			@Result(property = "name", column = "questioncontent"), })
	List<QuestionBank> basicSearch(String name);


	/**
	 * Retrieves the Testquestion and its questionbank details.
	 * @param testQuestionId
	 * @return
	 */
	@Select({ "select testquestionid, active, questionbankid from  asmtestquestion where testquestionid = #{testQuestionId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "testQuestionId", column = "testquestionid"),
			@Result(property = "questionBankId", column = "questionbankid"),
			@Result(property = "questionBank", column = "questionbankid", javaType = QuestionBank.class, one = @One(select = "selectQuestionBank")) })
	TestQuestion getTestQuestion(Integer testQuestionId);


}