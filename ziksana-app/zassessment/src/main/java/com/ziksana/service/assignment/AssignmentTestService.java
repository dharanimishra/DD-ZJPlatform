package com.ziksana.service.assignment;

import com.ziksana.domain.assessment.member.TestProgress;
import com.ziksana.domain.assessment.member.TestSubmission;

public interface AssignmentTestService {

	TestSubmission getStudentAssignmentPerformance(Integer memberRoleId);

	TestProgress getStudentTestProgress(Integer testId);

	void saveStudentFeedback(TestSubmission testSubmission);

}
