package com.ziksana.persistence.assessment;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.assessment.Assignment;
import com.ziksana.domain.assessment.AssignmentTestRubric;
import com.ziksana.domain.assessment.AssignmentTestSettings;
import com.ziksana.domain.assessment.Test;
import com.ziksana.domain.assessment.member.StudentTest;
import com.ziksana.domain.assessment.member.TestGrade;
import com.ziksana.domain.assessment.member.TestProgress;
import com.ziksana.domain.assessment.member.TestSubmission;

public interface AssignmentTestMapper {

	/**
	 * Saves the assignment.
	 * @param assignment
	 */
	Integer saveAssignment(Assignment assignment);

	/**
	 * Saves the Test for Assignment.
	 * @param test
	 */
	Integer saveTest(Test test);

	/**
	 * Updates the assignment.
	 * @param assignment
	 */
	Integer updateAssignment(Assignment assignment);

	/**
	 * Updates the Test for Assignment.
	 * @param test
	 */
	Integer updateTest(Test test);

	/**
	 * @param testSettings
	 */
	Integer saveTestSettings(AssignmentTestSettings testSettings);

	/**
	 * @param testRubric
	 */
	Integer saveTestRubric(AssignmentTestRubric testRubric);

	/**
	 * @param name
	 * @return
	 */
	@Select({ "select testid from asmtest where name = #{name,jdbcType=VARCHAR} and isdelete = 'false' " })
	@Results(value = { @Result(property = "testId", column = "testid") })
	Integer isTestExists(String name);

	/**
	 * Updates the testquestion's delete indicator to make a soft delete.
	 * @param testQuestiondId
	 * @param isDelete
	 */
	@Update({ "update asmtestquestion set isdelete=#{isDelete,jdbcType=BOOLEAN} where " +
			"testquestionid = #{testQuestionId,jdbcType=INTEGER}" })
	void deleteTestQuestion(@Param("testQuestiondId") Integer testQuestiondId,
			@Param("isDelete") Boolean isDelete);

	/**
	 * @param assignmentId
	 * @return
	 */
	@Select({ "select name, assignmentcontent, status, learningcomponentid, memberroleid from  asmassignment " +
			"where assignmentid = #{assignmentId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "name", column = "name"),
			@Result(property = "assignmentcontent", column = "assignmentContent"),
			@Result(property = "status", column = "status"),
			@Result(property = "learningcomponentid", column = "learningComponentId"),
			@Result(property = "creatorMemberPersona.memberroleid", column = "memberRoleId") })
	Assignment getAssignmentDetails(Integer assignmentId);

	/**
	 * @param testId
	 * @param isDelete
	 */
	@Update({ "update asmtest set isdelete = #{isDelete, jdbcType=BOOLEAN} where testid = #{testId, jdbcType=INTEGER}" })
	void deleteTest(Integer testId, Boolean isDelete);

	/**
	 * @param componentId
	 * @return
	 */
	@Select({ "select assignmentid, name, assignmentcontent, status, learningcomponentid, memberroleid from  asmassignment "
			+ " where assignmentid = #{assignmentId,jdbcType=INTEGER} and isdelete='false' " })
	@Results(value = {
			@Result(property = "assignmentId", column = "assignmentid"),
			@Result(property = "name", column = "name"),
			@Result(property = "assignmentContent", column = "assignmentContent"),
			@Result(property = "status", column = "status") })
	List<Assignment> getAssignmentByComponentId(Integer componentId);

	/**
	 * @param assignmentId
	 * @return
	 */
	@Select({ "select testid, name, testtype, testcontent, assignmentid from asmtest "
			+ "where assignmentid = #{assignmentId,jdbcType=VARCHAR} and isdelete = 'false' " })
	@Results(value = {
			@Result(property = "testId", column = "testid"),
			@Result(property = "name", column = "name"),
			@Result(property = "testType", column = "testtype"),
			@Result(property = "testContent", column = "testcontent"),
			@Result(property = "assignment.assignmentId", column = "assignmentid") })
	List<Test> getTestsByAssignmentId(Integer assignmentId);

	/**
	 * @param testId
	 * @return
	 */
	@Select({ "select assignmenttestid, totalduration,courseassignmentid, testid from msmassignmenttest where testid = #{testId,jdbcType=INTEGER} and isdelete = 'false' " })
	@Results(value = {
			@Result(property = "assignmentTestId", column = "assignmenttestid"),
			@Result(property = "totalDuration", column = "totalduration"),
			@Result(property = "subscribedCourseAssignment.courseAssignmentId", column = "courseassignmentid"),
			@Result(property = "test.testId", column = "testid"),
			@Result(property = "subscribedCourseAssignment.assignmentId", column = "assignmentid") })
	StudentTest getStudentsInfoByTestId(Integer testId);

	/**
	 * @param studentTestId
	 * @return
	 */
	@Select({ "select testgradeid,grade, assignmenttestid, memberroleid from msmassignmenttestgrade where studentTestId = #{studentTestId, jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "testGradeId", column = "testgradeid"),
			@Result(property = "grade", column = "grade"),
			@Result(property = "studentTest.studentTestId", column = "assignmenttestid"),
			@Result(property = "evaluatingMemberRole.memberRoleId", column = "memberroleid") })
	List<TestGrade> getStudentTestInfoByStudentTestId(Integer studentTestId);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select testsubmissionid, submitteddate, memberroleid from msmtestsubmission where memberroleid = #{memberRoleId, jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "testsubmissionid", column = "testsubmissionid"),
			@Result(property = "submitteddate", column = "submitteddate") })
	TestSubmission getTestSubmissionByMemberRoleId(Integer memberRoleId);

	/**
	 * @param testSubmission
	 */
	@Update({ "update msmtestsubmission set feedback=#{feedback,jdbcType=VARCHAR}, "
			+ " submittedResponse = #{response,jdbcType=VARCHAR} where submissionid =  #{submissionId, jdbcType=INTEGER}" })
	void saveStudentFeedback(TestSubmission testSubmission);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select testsubmissionid, submitteddate, memberroleid from msmtestsubmission where memberroleid = #{memberRoleId, jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "testsubmissionid", column = "testsubmissionid"),
			@Result(property = "submitteddate", column = "submitteddate"),
			@Result(property = "assignmenttestid", column = "assignmenttestid"),
			@Result(property = "test", column = "assignmenttestid", javaType = StudentTest.class, one = @One(select = "getStudentTestById")) })
	TestSubmission getStudentAssignmentPerformance(Integer memberRoleId);

	/**
	 * @param assignmentTestId
	 * @return
	 */
	@Select({ "select assignmenttestid, totalduration from msmassignmenttest where "
			+ "assignmentTestId = #{assignmentTestId,jdbcType=INTEGER }" })
	@Results(value = {
			@Result(property = "assignmentTestId", column = "assignmenttestid"),
			@Result(property = "totalDuration", column = "totalduration") })
	StudentTest getStudentTestById(Integer assignmentTestId);

	/**
	 * @param studentTestId
	 * @return
	 */
	@Select({ "select testprogressid, starttime, endtime, progress from msmassignmentprogress where "
			+ "assignmenttestid = #{studentTestId,jdbcType=INTEGER }" })
	@Results(value = {
			@Result(property = "testprogressid", column = "testprogressid"),
			@Result(property = "starttime", column = "starttime"),
			@Result(property = "endtime", column = "endtime"),
			@Result(property = "progress", column = "progress") })
	TestProgress getStudentTestProgress(Integer studentTestId);

}