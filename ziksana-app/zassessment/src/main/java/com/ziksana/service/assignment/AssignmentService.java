package com.ziksana.service.assignment;

import java.util.List;

import com.ziksana.domain.assessment.AssignmentTest;
import com.ziksana.domain.assessment.QuestionBank;
import com.ziksana.domain.assessment.TestQuestion;
import com.ziksana.domain.course.Course;
import com.ziksana.exception.assignment.AssignmentException;

/**
 * @author bhashasp
 */
public interface AssignmentService {

	/** 
	 * Saves the Test for Assignment
	 * @param course
	 * @param assignmentTest
	 * @return
	 */
	public AssignmentTest saveAssignmentTest(Course course,
			AssignmentTest assignmentTest) throws AssignmentException;

	/**
	 * Get the Test question from QuestionBank
	 * @param testQtn
	 * @param assignmentTest
	 * @return
	 */
	public AssignmentTest getAssignmentQuestion(TestQuestion testQtn,
			AssignmentTest assignmentTest) throws AssignmentException;

	/**
	 * Updates the Test Question.
	 * 
	 * @param testQtn
	 * @param assignmentTest
	 */
	public void updateAssignmentQuestion(TestQuestion testQtn,
			AssignmentTest assignmentTest) throws AssignmentException;

	/**
	 * Soft delete the associated Test Question.
	 * @param testQtn
	 * @param assignmentTest
	 */
	public void deleteAssignmentQuestion(TestQuestion testQtn,
			AssignmentTest assignmentTest) throws AssignmentException;

	/**
	 * Searches the Question from QuestionBank
	 * @param questionBank
	 * @return
	 */
	public List<QuestionBank> searchQuestion(QuestionBank questionBank) throws AssignmentException;

	/**
	 * Adds the associated question to Test
	 * @param list
	 * @param assignmentTest
	 */
	public void addAssignmentQuestions(List<TestQuestion> list,
			AssignmentTest assignmentTest) throws AssignmentException;

	/**
	 * Create new question 
	 * @param qtnBankAmswer
	 * @param testQtn
	 * @param assignmentTest
	 */
	public void createNewQuestion(QuestionBank qtnBank,
			TestQuestion testQtn, AssignmentTest assignmentTest) throws AssignmentException;

	/**
	 * Updates the AssignmentTest
	 * 
	 * @param assignmentTest
	 */
	public void updateAssignmentTest(AssignmentTest assignmentTest) throws AssignmentException;

	/**
	 * Soft deletes the assignmentTest
	 * @param assignmentTest
	 */
	public void deleteAssignmentTest(AssignmentTest assignmentTest) throws AssignmentException;

	/**
	 * Gets the Assignment Test
	 * @param assignmentTest
	 * @return
	 */
	public AssignmentTest getAssignmentTest(AssignmentTest assignmentTest) throws AssignmentException;

}
