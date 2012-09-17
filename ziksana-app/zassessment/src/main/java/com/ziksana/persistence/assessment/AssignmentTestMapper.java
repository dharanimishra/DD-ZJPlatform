package com.ziksana.persistence.assessment;

import com.ziksana.domain.assessment.AssignmentTest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AssignmentTestMapper {

	/**
	 * This method corresponds to the database table asmassignmenttest
	 */
	@Delete({ "delete from asmassignmenttest",
			"where AssignmentTestId = #{assignmentTestId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer assignmentTestId);

	/**
	 * This method corresponds to the database table asmassignmenttest
	 */
	@Insert({
			"insert into asmassignmenttest (AssignmentTestId, Active, ",
			"UsageStartDate, UsageEndDate, ",
			"Name, TestType, ",
			"AssignmentContent, DificultyLevel, ",
			"Instruction, ZeniCreatedIndicator, ",
			"LearnerCreatedIndicator, MultipleAttemptsAllowedIndicator, ",
			"OpenforPeerEvaluationIndicator, AsynchronousIndicator, ",
			"ProctoringNeededIndicator, AnswerWithinTime, ",
			"Status, LearningComponentId, ",
			"MemberRoleId)",
			"values (#{assignmentTestId,jdbcType=INTEGER}, #{active,jdbcType=BIT}, ",
			"#{usageStartDate,jdbcType=TIMESTAMP}, #{usageEndDate,jdbcType=TIMESTAMP}, ",
			"#{name,jdbcType=VARCHAR}, #{testType,jdbcType=INTEGER}, ",
			"#{assignmentContent,jdbcType=VARCHAR}, #{dificultyLevel,jdbcType=INTEGER}, ",
			"#{instruction,jdbcType=VARCHAR}, #{zeniCreatedIndicator,jdbcType=BIT}, ",
			"#{learnerCreatedIndicator,jdbcType=BIT}, #{multipleAttemptsAllowedIndicator,jdbcType=BIT}, ",
			"#{openforPeerEvaluationIndicator,jdbcType=BIT}, #{asynchronousIndicator,jdbcType=BIT}, ",
			"#{proctoringNeededIndicator,jdbcType=BIT}, #{answerWithinTime,jdbcType=INTEGER}, ",
			"#{status,jdbcType=INTEGER}, #{learningComponentId,jdbcType=INTEGER}, ",
			"#{memberRoleId,jdbcType=INTEGER})" })
	int insert(AssignmentTest record);

	/**
	 * This method corresponds to the database table asmassignmenttest
	 */
	int insertSelective(AssignmentTest record);

	/**
	 * This method corresponds to the database table asmassignmenttest
	 */
	@Select({
			"select",
			"AssignmentTestId, Active, UsageStartDate, UsageEndDate, Name, TestType, AssignmentContent, ",
			"DificultyLevel, Instruction, ZeniCreatedIndicator, LearnerCreatedIndicator, ",
			"MultipleAttemptsAllowedIndicator, OpenforPeerEvaluationIndicator, AsynchronousIndicator, ",
			"ProctoringNeededIndicator, AnswerWithinTime, Status, LearningComponentId, MemberRoleId",
			"from asmassignmenttest",
			"where AssignmentTestId = #{assignmentTestId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	AssignmentTest selectByPrimaryKey(Integer assignmentTestId);

	/**
	 * This method corresponds to the database table asmassignmenttest
	 */
	int updateByPrimaryKeySelective(AssignmentTest record);

	/**
	 * This method corresponds to the database table asmassignmenttest
	 */
	@Update({
			"update asmassignmenttest",
			"set Active = #{active,jdbcType=BIT},",
			"UsageStartDate = #{usageStartDate,jdbcType=TIMESTAMP},",
			"UsageEndDate = #{usageEndDate,jdbcType=TIMESTAMP},",
			"Name = #{name,jdbcType=VARCHAR},",
			"TestType = #{testType,jdbcType=INTEGER},",
			"AssignmentContent = #{assignmentContent,jdbcType=VARCHAR},",
			"DificultyLevel = #{dificultyLevel,jdbcType=INTEGER},",
			"Instruction = #{instruction,jdbcType=VARCHAR},",
			"ZeniCreatedIndicator = #{zeniCreatedIndicator,jdbcType=BIT},",
			"LearnerCreatedIndicator = #{learnerCreatedIndicator,jdbcType=BIT},",
			"MultipleAttemptsAllowedIndicator = #{multipleAttemptsAllowedIndicator,jdbcType=BIT},",
			"OpenforPeerEvaluationIndicator = #{openforPeerEvaluationIndicator,jdbcType=BIT},",
			"AsynchronousIndicator = #{asynchronousIndicator,jdbcType=BIT},",
			"ProctoringNeededIndicator = #{proctoringNeededIndicator,jdbcType=BIT},",
			"AnswerWithinTime = #{answerWithinTime,jdbcType=INTEGER},",
			"Status = #{status,jdbcType=INTEGER},",
			"LearningComponentId = #{learningComponentId,jdbcType=INTEGER},",
			"MemberRoleId = #{memberRoleId,jdbcType=INTEGER}",
			"where AssignmentTestId = #{assignmentTestId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(AssignmentTest record);
}