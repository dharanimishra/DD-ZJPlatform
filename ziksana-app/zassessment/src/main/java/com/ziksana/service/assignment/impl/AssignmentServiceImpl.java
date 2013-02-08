package com.ziksana.service.assignment.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.assessment.Assignment;
import com.ziksana.domain.assessment.AssignmentTestRubric;
import com.ziksana.domain.assessment.AssignmentTestSettings;
import com.ziksana.domain.assessment.QuestionBank;
import com.ziksana.domain.assessment.QuestionBankAnswer;
import com.ziksana.domain.assessment.QuestionType;
import com.ziksana.domain.assessment.QuestionVisual;
import com.ziksana.domain.assessment.Rubric;
import com.ziksana.domain.assessment.RubricMatrix;
import com.ziksana.domain.assessment.Test;
import com.ziksana.domain.assessment.TestQuestion;
import com.ziksana.domain.assessment.VisualSpot;
import com.ziksana.domain.assessment.member.StudentInfo;
import com.ziksana.domain.assessment.member.StudentTest;
import com.ziksana.domain.assessment.member.TestGrade;
import com.ziksana.domain.assessment.member.TestSubmission;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.assignment.AssignmentException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.assessment.AssignmentTestMapper;
import com.ziksana.persistence.assessment.TestQuestionMapper;
import com.ziksana.persistence.course.CourseLearningComponentMapper;
import com.ziksana.persistence.course.LearningComponentMapper;
import com.ziksana.service.assignment.AssignmentService;

/**
 * @author bhashasp
 */
public class AssignmentServiceImpl implements AssignmentService {

	private static Logger logger = Logger
			.getLogger(AssignmentServiceImpl.class);

	@Autowired
	public AssignmentTestMapper assignmentTestMapper;
	@Autowired
	public LearningComponentMapper componentMapper;
	@Autowired
	public CourseLearningComponentMapper courseComponentMapper;
	@Autowired
	public TestQuestionMapper testQuestionMapper;

	@Transactional
	@Override
	public void saveOrUpdateAssignment(LearningComponent component,
			Assignment assignment) throws AssignmentException {
		logger.debug("Entering into saveAssignment method ... ");

		if (assignment == null) {
			throw new AssignmentException("Assignment cannot be null");
		}

		if (component.getLearningComponentId() == null) {
			throw new AssignmentException(
					"LearningComponent ID is null, Cannot create Assignment");
		}

		assignment.setLearningComponent(component);

		if (assignment.getAssignmentId() != null) {
			logger.debug("UPDATING the Assignment ... ");
			assignmentTestMapper.updateAssignment(assignment);

		} else {
			logger.debug("SAVING the Assignment ... ");
			assignmentTestMapper.saveAssignment(assignment);

		}

	}

	@Transactional
	@Override
	public void saveOrUpdateTest(Assignment assignment)
			throws AssignmentException {

		List<Test> testList = null;
		AssignmentTestSettings testSettings = null;
		Rubric rubric = null;
		RubricMatrix rubricMatrix = null;
		AssignmentTestRubric testRubric = null;
		testList = new ArrayList<Test>();
		Integer testId = null;

		if (assignment.getAssignmentId() == null) {
			throw new AssignmentException(
					"Cannot create Test for Assignment, Assignment ID cannot be null ");
		}

		testList = assignment.getTestList();

		for (Test test : testList) {

			test.setAssignment(assignment);

			testId = assignmentTestMapper.isTestExists(test.getName().trim());

			if (testId != null) {
				throw new AssignmentException("Test with name:["
						+ test.getName()
						+ "]  already exists, Enter different Test Name");
			}

			if (test.getTestId() != null) {
				// UPDATE OPERATION
				logger.debug("UPDATING the Test ... ");
				assignmentTestMapper.updateTest(test);

			} else {
				logger.debug("SAVING the Test ... ");
				// SAVE OPERATION
				assignmentTestMapper.saveTest(test);
			}

			logger.debug("Assignment : [" + assignment.getName()
					+ "]  Test ID : " + test.getTestId());

			testSettings = test.getAssignmentTestSettings();

			if (testSettings != null) {

				testSettings.setTest(test);

				if (testSettings.getTestSettingsId() != null) {

					assignmentTestMapper.updateTestSettings(testSettings);

				} else {

					assignmentTestMapper.saveTestSettings(testSettings);

				}
			}

			testRubric = test.getTestRubric();

			if (testRubric != null) {

				rubric = testRubric.getRubric();
				rubricMatrix = testRubric.getRubricMatrix();

				testRubric.setTest(test);
				testRubric.setRubric(rubric);
				testRubric.setRubricMatrix(rubricMatrix);

				if (testRubric.getAssignmentTestRubricId() != null) {
					assignmentTestMapper.updateTestRubric(testRubric);
				} else {
					assignmentTestMapper.saveTestRubric(testRubric);
				}

			}
		}
	}

	@Override
	public TestQuestion getAssignmentQuestion(Integer testQuestionId)
			throws AssignmentException {

		TestQuestion testQtn = null;

		if (testQuestionId == null) {
			throw new AssignmentException("Test Question Id cannot be null");
		}

		testQtn = testQuestionMapper.getTestQuestion(testQuestionId);

		if (testQtn != null) {
			logger.debug("Test Question : " + testQtn.toString());
			return testQtn;
		}

		return null;
	}

	@Transactional
	@Override
	public void updateTestQuestionOptions(Test test) throws AssignmentException {

		List<TestQuestion> testQtnList = null;

		if (test == null || test.getTestId() == null) {
			throw new AssignmentException("Test cannot be null");
		}

		testQtnList = test.getTestQuestionList();

		if (testQtnList == null || testQtnList.size() == 0) {
			throw new AssignmentException("Test Questions cannot be null");
		}

		for (TestQuestion testQuestion : testQtnList) {

			logger.debug("Updating the Test Questions options .....");
			testQuestionMapper.updateTestQuestionOptions(testQuestion);

		}

	}

	@Transactional
	@Override
	public void deleteAssignmentQuestion(TestQuestion testQtn,
			Assignment assignment) throws AssignmentException {

		// to soft delete
		Boolean isDelete = true;
		ZID testQuestiondId = testQtn.getTestQuestionId();

		if (testQuestiondId == null) {
			throw new AssignmentException("Test question cannot be null");
		}

		logger.debug("Deleting the Test Questions");
		assignmentTestMapper.deleteTestQuestion(
				new Integer(testQuestiondId.getStorageID()), isDelete);
	}

	@Override
	public List<QuestionBank> advanceSearch(
			QuestionSearchCriteria searchCriteria) throws AssignmentException {

		List<QuestionBank> qtnBankList = null;
		List<QuestionType> questionTypes = null;
		if (searchCriteria == null) {
			throw new AssignmentException(
					"Search Criteria cannot be null question cannot be null");
		}

		questionTypes = searchCriteria.getQuestionTypes();

		StringBuffer qtnType = new StringBuffer();
		int i = 0;
		for (QuestionType questionType : questionTypes) {

			i = i + 1;
			if (i <= questionTypes.size()) {
				qtnType.append(questionType.getID() + ",");
			} else {
				qtnType.append(questionType.getID());
			}
		}

		qtnBankList = testQuestionMapper.searchQuestions(searchCriteria,
				qtnType);

		return qtnBankList;
	}

	@Override
	public List<QuestionBank> basicSearch(QuestionSearchCriteria searchCriteria)
			throws AssignmentException {

		List<QuestionBank> qtnBankList = null;

		if (searchCriteria == null) {
			throw new AssignmentException(
					"Search Criteria cannot be null question cannot be null");
		}

		qtnBankList = testQuestionMapper.basicSearch(searchCriteria.getName());

		return qtnBankList;
	}

	@Transactional
	@Override
	public void addAssignmentQuestionsToTest(Test test,
			List<QuestionBank> qtnBankList) throws AssignmentException {

		TestQuestion testQtn = null;

		if (test.getTestId() == null) {
			throw new AssignmentException(
					"Test Question cannot be null to add to Test");
		}

		for (QuestionBank qtnBank : qtnBankList) {

			testQtn = new TestQuestion();
			testQtn.setTest(test);
			testQtn.setQuestionBank(qtnBank);

			testQuestionMapper.saveTestQuestion(testQtn);

		}

	}

	@Transactional
	@Override
	public void createOrUpdateNewQuestion(TestQuestion testQuestion)
			throws AssignmentException {

		QuestionBank qtnBank = null;
		QuestionBankAnswer qtnBankAnswer = null;
		QuestionVisual questionVisual = null;
		List<VisualSpot> visualSpotList = null;

		if (testQuestion == null) {
			throw new AssignmentException("Test cannot be null");
		}

		if (testQuestion.getTest() == null) {
			throw new AssignmentException("Test cannot be null");
		}

		qtnBank = testQuestion.getQuestionBank();

		if (qtnBank == null) {
			throw new AssignmentException(
					"QuestionBank cannot be null to create a TestQuestion");
		}

		questionVisual = qtnBank.getQtnVisual();

		visualSpotList = questionVisual.getVisualSpotList();

		qtnBankAnswer = qtnBank.getQtnBankAnswer();

		if (testQuestion.getTestQuestionId() != null) {
			// UPDATE OPERATION.
			testQuestionMapper.updateTestQuestion(testQuestion);

			testQuestionMapper.updateQuestionBank(qtnBank);

			// TODO: UNCOMMED WHEN QUESTIONVISUAL IS IN PLACE.
			if (questionVisual.getQuestionVisualId() != null) {

				testQuestionMapper.updateQuestionVisualInfo(questionVisual);

				if (visualSpotList != null) {
					for (VisualSpot visualSpot : visualSpotList) {

						if (visualSpot.getVisualSpotId() != null) {
							testQuestionMapper.updateVisualSpot(visualSpot);
						} else {
							visualSpot.setQuestionVisual(questionVisual);

							testQuestionMapper.saveVisualSpot(visualSpot);
						}

					}
				}
			}

			testQuestionMapper.updateQuestionBankAnswerInfo(qtnBankAnswer);

		} else {
			// SAVE OPERATION
			if (qtnBankAnswer.getQuestionBankAnswerId() != null) {

				testQuestionMapper.updateQuestionBankAnswerInfo(qtnBankAnswer);

			} else {

				testQuestionMapper.saveQuestionBankAnswerInfo(qtnBankAnswer);

			}
			if (qtnBank.getQuestionBankId() != null) {

				testQuestionMapper.updateQuestionBank(qtnBank);

			} else {
				testQuestionMapper.saveQuestionBank(qtnBank);

				logger.debug("After saving the Question Bank , ID : "
						+ qtnBank.getQuestionBankId());
			}

			testQuestion.setQuestionBank(qtnBank);

			testQuestionMapper.saveTestQuestion(testQuestion);

		}

	}

	@Override
	public void deleteTest(Integer testId) throws AssignmentException {

		if (testId == null) {
			throw new AssignmentException("Test ID  cannot be null");
		}

		assignmentTestMapper.deleteTest(testId, true);
	}

	@Override
	public Assignment getAssignment(Integer assignmentId)
			throws AssignmentException {

		Assignment assignment = null;

		if (assignmentId == null) {
			throw new AssignmentException("Assignment ID cannot be null ");
		}

		assignment = assignmentTestMapper.getAssignmentDetails(assignmentId);

		logger.debug("Assignment details : " + assignment.toString());

		return assignment;
	}

	@Override
	public List<TestQuestion> getTestAssociateQuestions(Test test)
			throws AssignmentException {

		Integer testId = null;
		List<TestQuestion> questionList = null;
		questionList = new ArrayList<TestQuestion>();

		testId = new Integer(test.getTestId().getStorageID());

		if (test.getTestId() == null) {
			throw new AssignmentException("Test ID cannot be null ");
		}

		logger.debug("Getting the Test questions for the Test :["
				+ test.getName() + "]");
		questionList = testQuestionMapper.getTestQuestions(testId);

		logger.debug("Test [" + test.getName() + "]  Questions list size : "
				+ questionList.size());

		return questionList;
	}

	@Transactional
	@Override
	public List<Test> getAssignmentTest(Integer courseId)
			throws AssignmentException {

		List<Test> testList = null;
		List<Test> updatedTestList = null;
		List<Assignment> assignmentList = null;
		List<CourseLearningComponent> courseComponentList = null;
		LearningComponent learrningComponent = null;
		Integer componentId = null;

		if (courseId == null) {
			throw new AssignmentException("CourseID  cannot be null for Test");
		}

		testList = new ArrayList<Test>();
		updatedTestList = new ArrayList<Test>();
		courseComponentList = courseComponentMapper
				.getCourseLearningComponentByCourse(courseId);

		for (CourseLearningComponent courseLearningComponent : courseComponentList) {

			learrningComponent = courseLearningComponent.getLearningComponent();

			if (learrningComponent.getLearningComponentId() != null) {

				componentId = Integer.valueOf(learrningComponent
						.getLearningComponentId().getStorageID());

				assignmentList = assignmentTestMapper
						.getAssignmentByComponentId(componentId);

				if (assignmentList != null) {

					for (Assignment assignment : assignmentList) {

						testList = assignmentTestMapper
								.getTestsByAssignmentId(new Integer(assignment
										.getAssignmentId().getStorageID()));

						if (testList != null) {

							for (Test test : testList) {
								updatedTestList.add(test);
							}

						}
					}
				}
			}

		}
		return updatedTestList;
	}

	@Transactional
	@Override
	public List<StudentInfo> getStudentsByAssignmentId(Integer testId)
			throws AssignmentException {

		List<StudentInfo> studentList = null;
		StudentInfo studentInfo = null;

		if (testId == null) {
			throw new AssignmentException("Test ID  cannot be null");
		}

		studentList = new ArrayList<StudentInfo>();

		StudentTest studentTest = assignmentTestMapper
				.getStudentsInfoByTestId(testId);

		Integer studentTestId = new Integer(studentTest.getTestId()
				.getStorageID());

		List<TestGrade> testGradeList = assignmentTestMapper
				.getStudentTestInfoByStudentTestId(studentTestId);

		for (TestGrade testGrade : testGradeList) {

			studentInfo = new StudentInfo();

			Member member = testGrade.getEvaluatingMemberRole().getMember();

			studentInfo.setGrade(testGrade.getGrade());
			studentInfo.setName(member.getFirstName() + " "
					+ member.getLastName());

			TestSubmission testSubmission = assignmentTestMapper
					.getTestSubmissionByMemberRoleId(testGrade
							.getEvaluatingMemberRole().getMemberRoleId());

			studentInfo
					.setTestSubmissionDate(testSubmission.getSubmittedDate());

			studentList.add(studentInfo);
		}

		return studentList;
	}

	@Override
	public TestSubmission getTestSubmissionInfo(Integer memberRoleId)
			throws AssignmentException {

		TestSubmission testSubmission = null;

		if (memberRoleId == null) {
			throw new AssignmentException("MemberRole ID  cannot be null");
		}

		testSubmission = assignmentTestMapper
				.getTestSubmissionByMemberRoleId(memberRoleId);

		return testSubmission;
	}

	@Override
	public Assignment createAssignment(Integer learningComponentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
