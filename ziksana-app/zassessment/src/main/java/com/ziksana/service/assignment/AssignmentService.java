package com.ziksana.service.assignment;

import java.util.List;

import com.ziksana.domain.assessment.Assignment;
import com.ziksana.domain.assessment.QuestionBank;
import com.ziksana.domain.assessment.Test;
import com.ziksana.domain.assessment.TestQuestion;
import com.ziksana.domain.assessment.member.StudentInfo;
import com.ziksana.domain.assessment.member.TestSubmission;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.exception.assignment.AssignmentException;
import com.ziksana.service.assignment.impl.QuestionSearchCriteria;

/**
 * @author bhashasp
 */
public interface AssignmentService {
	
	/**
	 * Saves the Assignment
	 * @param course
	 * @param assignment
	 * @return
	 * @throws AssignmentException
	 */
	public void saveOrUpdateAssignment(LearningComponent component,
			Assignment assignment) throws AssignmentException;

	/** 
	 * Saves the Test for Assignment
	 * @param course
	 * @param assignment
	 * @return
	 */
	public void saveOrUpdateTest(Assignment assignment) throws AssignmentException;

	/**
	 * Get the Test question from QuestionBank
	 * @param testQtn
	 * @param assignment
	 * @return
	 */
	public TestQuestion getAssignmentQuestion(Integer testQuestionId) throws AssignmentException;


	/**
	 * Soft delete the associated Test Question.
	 * @param testQtn
	 * @param assignment
	 */
	public void deleteAssignmentQuestion(TestQuestion testQtn,
			Assignment assignment) throws AssignmentException;

	/**
	 * Advance Searches the Question from QuestionBank 
	 * @param questionBank
	 * @return
	 */
	public List<QuestionBank> advanceSearch(QuestionSearchCriteria searchCriteria) throws AssignmentException;

	/**
	 * Adds the searched Questions from QuestionBank and adds to Test
	 * @param testQuestion
	 * @throws AssignmentException
	 */
	public void addAssignmentQuestionsToTest(Test test, List<QuestionBank> qtnBankList) throws AssignmentException ;

	/**
	 * Create new question 
	 * @param qtnBankAmswer
	 * @param testQtn
	 * @param assignment
	 */
	public void createOrUpdateNewQuestion(TestQuestion testQuestion) throws AssignmentException;


	/**
	 * Soft deletes the assignmentTest
	 * @param assignment
	 */
	public void deleteTest(Integer testId) throws AssignmentException;

	/**
	 * Gets the Assignment Test
	 * @param assignment
	 * @return
	 */
	public Assignment getAssignment(Integer assignmentId) throws AssignmentException;
	
	/**
	 * Retrieves the questions which are associated to Test.
	 * @param test
	 * @return
	 * @throws AssignmentException
	 */
	public List<TestQuestion> getTestAssociateQuestions(Test test) throws AssignmentException;

	
	/**
	 * Updates the questions options{marks, time and factor)
	 * @param Test
	 * @throws AssignmentException
	 */
	void updateTestQuestionOptions(Test test) throws AssignmentException;

	
	/**
	 * Peforms basic Question search (by name only)
	 * @param searchCriteria
	 * @return
	 * @throws AssignmentException
	 */
	public List<QuestionBank> basicSearch(QuestionSearchCriteria searchCriteria)
			throws AssignmentException;
	
	/**
	 * @param courseId
	 * @return
	 * @throws AssignmentException
	 */
	public List<Test> getAssignmentTest(Integer courseId) throws AssignmentException;
	
	
	/**
	 * @param testId
	 * @return
	 * @throws AssignmentException
	 */
	public List<StudentInfo> getStudentsByAssignmentId(Integer testId) throws AssignmentException;
	
	/**
	 * @param memberRoleId
	 * @return
	 * @throws AssignmentException
	 */
	public TestSubmission getTestSubmissionInfo(Integer memberRoleId) throws AssignmentException;
	
	
	/**
	 * CReates assignment and returns the created assignment
	 * @return
	 */
	public Assignment createAssignment(Assignment assignment);
	
	
	
	

	
}
