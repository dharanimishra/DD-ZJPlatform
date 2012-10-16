package com.ziksana.service.subjectclassification.impl;

import com.ziksana.domain.utilz.SubjectClassification;
import com.ziksana.exception.subjectclassification.SubjectClassificationException;
import com.ziksana.service.subjectclassification.SubjectClassificationService;

public class SubjectClassificationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SubjectClassificationException{
		// TODO Auto-generated method stub

		SubjectClassificationService subjectClassificationService = new MockSubjectClassificationServiceImpl();
		SubjectClassification subjectClassificationDomain = new SubjectClassification();
		
		// Retrieve the list of areas
		System.out.println("List of Areas "+subjectClassificationService.getAreaList());

		// Retrieve the list of subjects
		System.out.println("List of Subjects "+subjectClassificationService.getSubjectList());
		
		// Retrieve the list of topics
		System.out.println("List of Topics "+subjectClassificationService.getTopicList());
		
		// Retrieve the list of subjects based on the area Religion		
		subjectClassificationDomain.setArea("Religion");
		System.out.println("List of Subjects associated to area "+subjectClassificationService.getSubjectList(subjectClassificationDomain).getSubjectList());

		//Retrieve the list of topics based on the area "Philosophy and psychology" and "Metaphysics" 
		subjectClassificationDomain.setArea("Philosophy and psychology");
		subjectClassificationDomain.setSubject("Metaphysics");
		System.out.println("List of Topics associated to area "+subjectClassificationService.getTopicList(subjectClassificationDomain).getTopicList());

	}

}