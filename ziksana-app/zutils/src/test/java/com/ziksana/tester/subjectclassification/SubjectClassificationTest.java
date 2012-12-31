package com.ziksana.tester.subjectclassification;

import com.ziksana.exception.subjectclassification.SubjectClassificationException;
import com.ziksana.service.subjectclassification.SubjectClassificationService;
import com.ziksana.service.subjectclassification.impl.MockSubjectClassificationServiceImpl;

public class SubjectClassificationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SubjectClassificationException{
		// TODO Auto-generated method stub

		SubjectClassificationService subjectClassificationService = new MockSubjectClassificationServiceImpl();
		
		// Retrieve the list of areas
		System.out.println("List of Areas " + subjectClassificationService.getAreaList());

		// Retrieve the list of subjects
		System.out.println("List of Subjects " + subjectClassificationService.getSubjectList("Philosophy and psychology"));
		
		// Retrieve the list of topics
		System.out.println("List of Topics " + subjectClassificationService.getTopicList("Philosophy and psychology", "Metaphysics"));
	}

}