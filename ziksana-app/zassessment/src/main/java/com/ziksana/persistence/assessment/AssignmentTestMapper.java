package com.ziksana.persistence.assessment;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.assessment.Assignment;
import com.ziksana.domain.assessment.AssignmentTestRubric;
import com.ziksana.domain.assessment.AssignmentTestSettings;
import com.ziksana.domain.assessment.QuestionBank;
import com.ziksana.domain.assessment.Test;
import com.ziksana.domain.assessment.TestQuestion;
import com.ziksana.service.assignment.impl.QuestionSearchCriteria;

public interface AssignmentTestMapper {

	/**Saves the assignment.
	 * @param assignment
	 */
	@Insert({
			"insert into asmassignmenttest (active, name, assignmentcontent, status, learningcomponentid, memberroleid)",
			"values (#{active,jdbcType=BOOLEAN}, #{name,jdbcType=VARCHAR}, #{assignmentContent,jdbcType=VARCHAR},",
			" #{status,jdbcType=INTEGER}, #{learningComponent.learningComponentId,jdbcType=INTEGER}, #{creatorMemberPersona.memberRoleId,jdbcType=INTEGER})" })
	void saveAssignment(Assignment assignment);

	/**Saves the Test for Assignment.
	 * @param test
	 */
	@Insert({
			"insert into asmtest (active, name, testtype, testcontent, dificultylevel, ",
			"instruction, zenicreatedindicator, learnercreatedindicator, multipleattemptsallowedindicator, ",
			"openforpeerevaluationindicator, asynchronousindicator, proctoringneededindicator, ",
			"status, assignmentid)",
			"values (#{active,jdbcType=BOOLEAN}, ",
			"#{name,jdbcType=VARCHAR}, #{testType,jdbcType=INTEGER}, ",
			"#{testContent,jdbcType=VARCHAR}, #{dificultyLevel,jdbcType=INTEGER}, ",
			"#{instruction,jdbcType=VARCHAR}, #{isZeniCreated,jdbcType=BOOLEAN}, ",
			"#{isLearner,jdbcType=BOOLEAN}, #{isMultipleAttemptsAllowed,jdbcType=BOOLEAN}, ",
			"#{isOpenforPeerEvaluation,jdbcType=BOOLEAN}, #{isAsynchronous,jdbcType=BOOLEAN}, ",
			"#{isProctoringNeeded,jdbcType=BOOLEAN}, ",
			"#{status,jdbcType=INTEGER}, #{assignmentId,jdbcType=INTEGER}" })
	@Results(value={
			@Result(property="testId", column="testid"),
			@Result(property="name", column="name"),
			@Result(property="testType", column="testtype"),
			@Result(property="testContent", column="testcontent"),
			@Result(property="dificultyLevel", column="dificultylevel"),
			@Result(property="instruction", column="instruction"),
			@Result(property="status", column="status"),
			@Result(property="assignment.assignmentid", column="assignmentid")
	})
	Test saveTest(Test test);

	@Insert({" insert into asmassignmenttestsettings ",
			"(creationdate, active, property, propertyvaluetype, propertyvalue, testid) " ,
			" values (#{creationDate,jdbcType=TIMESTAMP}, #{active,jdbcType=BOOLEAN}, #{property,jdbcType=INTEGER}, #{propertyValueType,jdbcType=INTEGER},",
			" #{propertyValue,jdbcType=VARCHAR}, #{test.testId,jdbcType=INTEGER}) "})
	void saveTestSettings(AssignmentTestSettings testSettings);

	
	@Insert({"insert into asmAssignmentTestRubric ",
		"(creatiodate, cellvalue, active, testid, rubricid, rubricmatrixid) ",
		"values (sysdate(), #{cellValue,jdbcType=INTEGER}, #{active,jdbcType=BOOLEAN}, #{test.testId,jdbcType=INTEGER}",
		" #{rubric.rubricId,jdbcType=INTEGER}, #{rubricMatrix.rubricMatrixId,jdbcType=INTEGER})"})
	void saveTestRubric(AssignmentTestRubric testRubric);

	
	@Select({"select testid from asmtest where name = #{name,jdbcType=VARCHAR}"})
	@Results(value={
			@Result(property="testId", column="testid"),
	})
	Integer isTestExists(String name);

	
	@Select({"select testquestionid, questionbankid from  asmtestquestion where testid = #{testId,jdbcType=INTEGER}"})
	@Results(value={
			@Result(property="testQuestionId", column="testquestionid"),
			@Result(property="questionBankId", column="questionbankid"),
			@Result(property="questionBank", column="testQuestionId", javaType=QuestionBank.class,one=@One(select="selectQuestionBank"))
	})
	List<TestQuestion> getTestQuestions(@Param("testId") Integer testId);
	
	
	@Select({"select questionbankid, questioncontent as name, questiontype, instruction, memberid  from  asmquestionbank  where ",
			"testQuestionId = #{testQuestionId,jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property="questionBankId", column="questionbankid"),
			@Result(property="instruction", column="instruction"),
			@Result(property="owningMember.memberId", column="memberid"),
			@Result(property="questionType", column="questiontype"),
			@Result(property="name", column="questioncontent"),
	})
	QuestionBank selectQuestionBank(Integer testQuestionId);

	/**
	 * Updates the testquestion's delete indicator to make a soft delete.
	 * @param testQuestiondId
	 * @param isDelete
	 */
	@Update({"update asmtestquestion set isdelete=#{isDelete,jdbcType=BOOLEAN} where testquestionid = #{testQuestionId,jdbcType=INTEGER}"})
	void deleteTestQuestion(@Param("testQuestiondId") Integer testQuestiondId, @Param("isDelete") Boolean isDelete);
	
	
	@Update({"update asmtestquestion set marks=#{marks, jdbcType=INTEGER}, answerwithintime=#{answerWithInTime,jdbcType=INTEGER },",
		" panaltyfactor=#{penaltyMarks,jdbcType=INTEGER}",
		" where testquestionid = #{testQuestiondId, jdbcType=INTEGER}"})
	void updateTestQuestionOptions(TestQuestion testQuestion);
	
	
	/**
	 * This performs the basic search
	 * @param name
	 * @return
	 */
	@Select({"select name, questionbankid,memberid,questiontype from asmquestionbank where name like #{name,jdbcType=VARCHAR} "})
	@Results(value = {
			@Result(property="questionBankId", column="questionbankid"),
			@Result(property="owningMember.memberId", column="memberid"),
			@Result(property="questionType", column="questiontype"),
			@Result(property="name", column="questioncontent"),
	})
	List<QuestionBank> basicSearch(String name);

	
	/**
	 * This performs the full/advanced search
	 * @param searchCriteria
	 * @return
	 */
	@Select({"selecgt name, questionbankid,memberid, questiontype from asmquestionbank where name like #{name,jdbcType=VARCHAR} "})
	@Results(value = {
			@Result(property="questionBankId", column="questionbankid"),
			@Result(property="owningMember.memberId", column="memberid"),
			@Result(property="questionType", column="questiontype"),
			@Result(property="name", column="questioncontent"),
	})
	List<QuestionBank> searchQuestions(QuestionSearchCriteria searchCriteria);
	
	
	@Insert({"insert into asmtestquestion (creationdate,active,testid,questionbankid) ",
		" values (sysdate(), #{active, jdbcType=BOOLEAN}, #{testId, jdbcType=INTEGER}, #{questionBankId, jdbcType=INTEGER})"})
	void saveTestQuestion(TestQuestion testQuestion);


	/**
	 * Retrieves the Testquestion and its questionbank details.
	 * @param testQuestionId
	 * @return
	 */
	@Select({"select testquestionid, active, questionbankid from  asmtestquestion where testquestionid = #{testQuestionId,jdbcType=INTEGER}"})
	@Results(value={
			@Result(property="testQuestionId", column="testquestionid"),
			@Result(property="questionBankId", column="questionbankid"),
			@Result(property="questionBank", column="questionbankid", javaType=QuestionBank.class,one=@One(select="selectQuestionBank"))
	})
	TestQuestion getTestQuestion(Integer testQuestionId);
	

	@Update({"update asmquestionbank set difficultylevel=#{difficultyLevel , jdbcType=INTEGER}, profficiencylevel=#{proficiencyLeveel, jdbcType=INTEGER}, ",
		"questiontype=#{questionType, jdbcType=INTEGER}, ",
		"questioncontent=#{name, jdbcType=VARCHAR}, instruction=#{instruction, jdbcType=VARCHAR},",
		" ismulticorrectanswer=#{isMultiCorrectAnswer,jdbcType=BOOLEAN}, additionalinfopath=#{additionalInfoPath, jdbcType=VARCHAR} ,",
		"isgroupwork=#{isGroupWork,jdbcType=BOOLEAN} , questionapplicabilitytype=#{questionApplicabilityType, jdbcType=INTEGER} ",
		" where questionbankid=#{questionBankId, jdbcType=INTEGER}"})
	void updateQuestionBank(QuestionBank qtnBank);
	

	@Update({"update asmtestquestion set marks=#{marks, jdbcType=INTEGER}, answerwithintime=#{answerWithInTime,jdbcType=INTEGER },",
		" panaltyfactor=#{penaltyMarks,jdbcType=INTEGER}  where testquestionid=#{testQuestionId, jdbcType=INTEGER}"})
	void updateTestQuestion(TestQuestion testQuestion);
	
	
	@Select({"select name, assignmentcontent, status, learningcomponentid, memberroleid from  asmassignment where assignmentid = #{assignmentId,jdbcType=INTEGER}"})
	@Results(value={
			@Result(property="name", column="name"),
			@Result(property="assignmentcontent", column="assignmentContent"),
			@Result(property="status", column="status"),
			@Result(property="learningcomponentid", column="learningComponentId"),
			@Result(property="creatorMemberPersona.memberroleid", column="memberRoleId")
	})
	Assignment getAssignmentDetails(Integer assignmentId);
	
	
	@Update({"update asmtest set isdelete = #{isDelete, jdbcType=BOOLEAN} where testid = #{testId, jdbcType=INTEGER}"})
	void deleteTest(Integer testId, Boolean isDelete);

	
	@Update({"update asmtest set active = #{active,jdbcType=BOOLEAN},",
			"name = #{name,jdbcType=VARCHAR},",
			"AssignmentContent = #{assignmentContent,jdbcType=VARCHAR},",
			"Status = #{status,jdbcType=INTEGER},",
			"LearningComponentId = #{learningComponent.learningComponentId,jdbcType=INTEGER},",
			"MemberRoleId = #{creatorMemberPersona.memberRoleId,jdbcType=INTEGER} ",
			" where testid = #{testId, jdbcType=INTEGER}"})
	void updateTest(Test test);
}