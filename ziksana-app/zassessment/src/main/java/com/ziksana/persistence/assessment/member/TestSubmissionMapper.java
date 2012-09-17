package com.ziksana.persistence.assessment.member;

import com.ziksana.domain.assessment.member.TestSubmission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TestSubmissionMapper {
	/**
	 * This method corresponds to the database table msmtestsubmission
	 */
	@Delete({ "delete from msmtestsubmission",
			"where TestSubmissionId = #{testSubmissionId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer testSubmissionId);

	/**
	 * This method corresponds to the database table msmtestsubmission
	 */
	@Insert({
			"insert into msmtestsubmission (TestSubmissionId, SubmittedResponse, ",
			"Duration, ZeniEvaluatedIndicator, ",
			"ResponseTypeIndicator, ResponseContentLink, ",
			"CorrectnessIndicator, FeedbackComment, ",
			"ZeniCommentedIndicator, PeerEvaluatedIndicator, ",
			"AssignmentTestId, TestQuestionId, ",
			"QuestionBankAnswerId, MemberRoleId)",
			"values (#{testSubmissionId,jdbcType=INTEGER}, #{submittedResponse,jdbcType=VARCHAR}, ",
			"#{duration,jdbcType=INTEGER}, #{zeniEvaluatedIndicator,jdbcType=BIT}, ",
			"#{responseTypeIndicator,jdbcType=BIT}, #{responseContentLink,jdbcType=VARCHAR}, ",
			"#{correctnessIndicator,jdbcType=BIT}, #{feedbackComment,jdbcType=VARCHAR}, ",
			"#{zeniCommentedIndicator,jdbcType=BIT}, #{peerEvaluatedIndicator,jdbcType=BIT}, ",
			"#{assignmentTestId,jdbcType=INTEGER}, #{testQuestionId,jdbcType=INTEGER}, ",
			"#{questionBankAnswerId,jdbcType=INTEGER}, #{memberRoleId,jdbcType=INTEGER})" })
	int insert(TestSubmission record);

	/**
	 * This method corresponds to the database table msmtestsubmission
	 */
	int insertSelective(TestSubmission record);

	/**
	 * This method corresponds to the database table msmtestsubmission
	 */
	@Select({
			"select",
			"TestSubmissionId, SubmittedResponse, Duration, ZeniEvaluatedIndicator, ResponseTypeIndicator, ",
			"ResponseContentLink, CorrectnessIndicator, FeedbackComment, ZeniCommentedIndicator, ",
			"PeerEvaluatedIndicator, AssignmentTestId, TestQuestionId, QuestionBankAnswerId, ",
			"MemberRoleId", "from msmtestsubmission",
			"where TestSubmissionId = #{testSubmissionId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	TestSubmission selectByPrimaryKey(Integer testSubmissionId);

	/**
	 * This method corresponds to the database table msmtestsubmission
	 */
	int updateByPrimaryKeySelective(TestSubmission record);

	/**
	 * This method corresponds to the database table msmtestsubmission
	 */
	@Update({ "update msmtestsubmission",
			"set SubmittedResponse = #{submittedResponse,jdbcType=VARCHAR},",
			"Duration = #{duration,jdbcType=INTEGER},",
			"ZeniEvaluatedIndicator = #{zeniEvaluatedIndicator,jdbcType=BIT},",
			"ResponseTypeIndicator = #{responseTypeIndicator,jdbcType=BIT},",
			"ResponseContentLink = #{responseContentLink,jdbcType=VARCHAR},",
			"CorrectnessIndicator = #{correctnessIndicator,jdbcType=BIT},",
			"FeedbackComment = #{feedbackComment,jdbcType=VARCHAR},",
			"ZeniCommentedIndicator = #{zeniCommentedIndicator,jdbcType=BIT},",
			"PeerEvaluatedIndicator = #{peerEvaluatedIndicator,jdbcType=BIT},",
			"AssignmentTestId = #{assignmentTestId,jdbcType=INTEGER},",
			"TestQuestionId = #{testQuestionId,jdbcType=INTEGER},",
			"QuestionBankAnswerId = #{questionBankAnswerId,jdbcType=INTEGER},",
			"MemberRoleId = #{memberRoleId,jdbcType=INTEGER}",
			"where TestSubmissionId = #{testSubmissionId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(TestSubmission record);
}