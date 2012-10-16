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
		
		System.out.println("List of Areas "+subjectClassificationService.getAreaList());
		System.out.println("List of Subjects "+subjectClassificationService.getSubjectList());
		System.out.println("List of Topics "+subjectClassificationService.getTopicList());
		
		subjectClassificationDomain.setArea("Religion");
		System.out.println("List of Subjects associated to area "+subjectClassificationService.getSubjectList(subjectClassificationDomain).getSubjectList());

		subjectClassificationDomain.setArea("Philosophy and psychology");
		subjectClassificationDomain.setSubject("Metaphysics");
		System.out.println("List of Topics associated to area "+subjectClassificationService.getTopicList(subjectClassificationDomain).getTopicList());

	}

}