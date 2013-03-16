package com.ziksana.service.assignment.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.assessment.member.TestProgress;
import com.ziksana.domain.assessment.member.TestSubmission;
import com.ziksana.persistence.assessment.AssignmentTestMapper;
import com.ziksana.service.assignment.AssignmentTestService;

public class AssignmentTestServiceImpl implements AssignmentTestService {

	private static Logger LOGGER = LoggerFactory
			.getLogger(AssignmentTestServiceImpl.class);

	@Autowired
	AssignmentTestMapper assignmentTestMapper;

	@Override
	public TestSubmission getStudentAssignmentPerformance(Integer memberRoleId) {

		TestSubmission testSubmission = assignmentTestMapper
				.getStudentAssignmentPerformance(memberRoleId);
		LOGGER.debug(" In method getStudentAssignmentPerformance(Integer memberRoleId) ");
		return testSubmission;
	}

	@Override
	public TestProgress getStudentTestProgress(Integer testId) {
		TestProgress testProgress = assignmentTestMapper
				.getStudentTestProgress(testId);
		LOGGER.debug(" In method getStudentTestProgress(Integer testId) ");

		return testProgress;
	}

	@Override
	public void saveStudentFeedback(TestSubmission testSubmission) {
		assignmentTestMapper.saveStudentFeedback(testSubmission);
		LOGGER.debug(" In method saveStudentFeedback(TestSubmission testSubmission) ");
	}

}
