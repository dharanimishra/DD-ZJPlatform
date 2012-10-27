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
import com.ziksana.domain.assessment.Rubric;
import com.ziksana.domain.assessment.RubricMatrix;
import com.ziksana.domain.assessment.Test;
import com.ziksana.domain.assessment.TestQuestion;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.exception.assignment.AssignmentException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.assessment.AssignmentTestMapper;
import com.ziksana.service.assignment.AssignmentService;

/**
 * @author bhashasp
 */
public class AssignmentServiceImpl implements AssignmentService {
	
	private static Logger logger = Logger.getLogger(AssignmentServiceImpl.class);
	
	@Autowired
	public AssignmentTestMapper assignmentTestMapper;
	

	@Transactional
	@Override
	public void saveAssignment(LearningComponent component,
			Assignment assignment) throws AssignmentException {
		logger.debug("Entering into saveAssignment method ... ");
		
		if(assignment == null){
			throw new AssignmentException("Assignment cannot be null");
		}

		if(component!=null){
			
			assignment.setLearningComponent(component);
			assignmentTestMapper.saveAssignment(assignment);
			
		}
	}

	@Transactional
	@Override
	public void saveTest(Assignment assignment) throws AssignmentException {
		
		List<Test>  			testList		= null;
		AssignmentTestSettings 	testSettings 	= null;
		Rubric 					rubric 			= null;
		RubricMatrix 			rubricMatrix 	= null;
		AssignmentTestRubric 	testRubric 		= null;
		testList 				= new ArrayList<Test>();
		Integer 				testId 			= null;
				
		if(assignment.getLearningComponent() == null){
			throw new AssignmentException("LearningComponent cannot be null");
		}
		
		if(assignment.getAssignmentId() == null){
			throw new AssignmentException("Assignment cannot be null");
		} 
		
		testList = assignment.getTestList();
		
		for (Test test : testList) {
			
			test.setAssignment(assignment);
			
			
			testId =  assignmentTestMapper.isTestExists(test.getName().trim());
			
			if(testId!=null){
				throw new AssignmentException("Test with name:["+test.getName()+"]  already exists, Enter different Test Name");
			}
			
			assignmentTestMapper.saveTest(test);
			
			testSettings = test.getAssignmentTestSettings();
			
			if(testSettings!=null){
				testSettings.setTest(test);
				assignmentTestMapper.saveTestSettings(testSettings);
			}
		
			testRubric = test.getTestRubric();
			
			if(testRubric!=null){
				rubric = testRubric.getRubric();
				rubricMatrix = testRubric.getRubricMatrix();
				
				testRubric.setTest(test);
				testRubric.setRubric(rubric);
				testRubric.setRubricMatrix(rubricMatrix);
				
				assignmentTestMapper.saveTestRubric(testRubric);
			}
		}
	}


	@Override
	public TestQuestion getAssignmentQuestion(Integer testQuestionId) throws AssignmentException {
		
		TestQuestion testQtn  = null;
		
		if(testQuestionId == null){
			throw new AssignmentException("Test Question Id cannot be null");
		}
		
		testQtn  = assignmentTestMapper.getTestQuestion(testQuestionId);
		
		return testQtn;
	}
	

	@Transactional
	@Override
	public void updateAssignmentQuestion(TestQuestion testQuestion) throws AssignmentException {
		
		QuestionBank qtnBank = null;
		
		if(testQuestion == null){
			throw new AssignmentException("Test Question  cannot be null"); 
		}
	
		qtnBank = testQuestion.getQuestionBank();
		
		if(qtnBank==null){
			throw new AssignmentException("QuestionBank  cannot be null");
		}
		
		assignmentTestMapper.updateQuestionBank(qtnBank);
		
		assignmentTestMapper.updateTestQuestion(testQuestion);
	}

	@Transactional
	@Override
	public void updateTestQuestionOptions(Test test) throws AssignmentException {
		
		List<TestQuestion> testQtnList = null;
				
		if(test == null || test.getTestId()==null){
			throw new AssignmentException("Test cannot be null");
		}
		
		testQtnList = test.getTestQuestionList();
		
		if(testQtnList == null || testQtnList.size()==0){
			throw new AssignmentException("Test Questions cannot be null");
		}
		
		for (TestQuestion testQuestion : testQtnList) {
			
			logger.debug("Updating the Test Questions options .....");
			assignmentTestMapper.updateTestQuestionOptions(testQuestion);
			
		}
	
	}
	
	@Transactional
	@Override
	public void deleteAssignmentQuestion(TestQuestion testQtn,
			Assignment assignment) throws AssignmentException {

		//to soft delete
		Boolean 				isDelete = true;
		ZID testQuestiondId = 	testQtn.getTestQuestionId();
				
		if(testQuestiondId == null){
			throw new AssignmentException("Test question cannot be null");
		}
		
		logger.debug("Deleting the Test Questions");
		assignmentTestMapper.deleteTestQuestion(new Integer(testQuestiondId.getStorageID()), isDelete);
	}

	@Override
	public List<QuestionBank> advanceSearch(QuestionSearchCriteria searchCriteria)
			throws AssignmentException {
		
		List<QuestionBank> qtnBankList = null;
		
		if(searchCriteria == null){
			throw new AssignmentException("Search Criteria cannot be null question cannot be null");
		}
		
		qtnBankList = assignmentTestMapper.searchQuestions(searchCriteria);
		
		return qtnBankList;
	}

	@Override
	public List<QuestionBank> basicSearch(QuestionSearchCriteria searchCriteria)
			throws AssignmentException {
		
		List<QuestionBank> qtnBankList = null;
		
		if(searchCriteria == null){
			throw new AssignmentException("Search Criteria cannot be null question cannot be null");
		}
		
		qtnBankList = assignmentTestMapper.basicSearch(searchCriteria.getName());
		
		return qtnBankList;
	}

	@Transactional
	@Override
	public void addAssignmentQuestionsToTest(Integer testId, Assignment assignment, List<QuestionBank> qtnBankList) throws AssignmentException {
		
		List<Test> testList = new ArrayList<Test>();
		TestQuestion testQuestion = null;

		//Test need to be created to associate questions. 
		if(testId== null){
			throw new AssignmentException("Test cannot be null");
		}
		
		if(qtnBankList == null || qtnBankList.size()==0){
			throw new AssignmentException("TestQuestions List cannot be empty");
		}
	
		testList = assignment.getTestList();
		
		for (Test test : testList) {
			
			Integer newTestId = new Integer(test.getTestId().getStorageID());
			
			if(newTestId.equals(testId)){

				for (QuestionBank qtnBank : qtnBankList){
					
					testQuestion = new TestQuestion();
					testQuestion.setQuestionBank(qtnBank);
					testQuestion.setTest(test);
					
					assignmentTestMapper.saveTestQuestion(testQuestion);
				}
			}
		}
	}

	@Transactional
	@Override
	public void createNewQuestion(TestQuestion testQuestion) throws AssignmentException {
		
		QuestionBank qtnBank = null;
		
		if(testQuestion == null){
			throw new AssignmentException("Test Question  cannot be null"); 
		}
	
		qtnBank = testQuestion.getQuestionBank();
		
		if(qtnBank==null){
			throw new AssignmentException("QuestionBank  cannot be null");
		}
		
		assignmentTestMapper.updateQuestionBank(qtnBank);
		
		assignmentTestMapper.updateTestQuestion(testQuestion);
	
	}

	@Override
	public void updateTest(Test test) throws AssignmentException {
		
		if(test == null){
			
			throw new AssignmentException("Test cannot be null"); 
		}
		
		assignmentTestMapper.updateTest(test);
		
	
	}

	@Override
	public void deleteTest(Integer testId) throws AssignmentException {
		
		if(testId == null){
			throw new AssignmentException("Test ID  cannot be null"); 
		}
		
		assignmentTestMapper.deleteTest(testId, true);
	}

	@Override
	public Assignment getAssignment(Integer assignmentId)
			throws AssignmentException {
		
		Assignment assignment = null;
		
		if(assignmentId == null){
			throw new AssignmentException("Assignment ID cannot be null ");
		}
		
		assignment = assignmentTestMapper.getAssignmentDetails(assignmentId);
		
		logger.debug("Assignment details : "+assignment.toString());
		
		return assignment;
	}

	@Override
	public List<TestQuestion> getTestAssociateQuestions(Test test)
			throws AssignmentException {
		
		Integer 			testId  		= null;	
		List<TestQuestion> 	questionList 	= null;
		questionList = new ArrayList<TestQuestion>();
		
		testId  = new Integer(test.getTestId().getStorageID());
		
		if(test.getTestId() == null){
			throw new AssignmentException("Test ID cannot be null ");
		} 
		
		logger.debug("Getting the Test questions for the Test :["+test.getName()+"]");
		questionList = assignmentTestMapper.getTestQuestions(testId);
		
		logger.debug("Test ["+test.getName()+"]  Questions list size : "+questionList.size());
		
		return questionList;
	}


}
