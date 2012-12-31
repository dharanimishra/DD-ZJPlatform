package com.ziksana.service.subjectclassification.impl;


import java.util.List;

import com.ziksana.id.StringZID;
import com.ziksana.domain.utils.SubjectClassification;
import com.ziksana.domain.utils.Topic;
import com.ziksana.exception.subjectclassification.SubjectClassificationException;
import com.ziksana.service.subjectclassification.SubjectClassificationService;

public class MockSubjectClassificationServiceImpl implements SubjectClassificationService{

	SubjectClassification sClassification = null;
	
	/**
	 * While object is being created instantiates all the required values
	 * 
	 */
	public MockSubjectClassificationServiceImpl() {

		sClassification = new SubjectClassification();

		sClassification.add(new Topic(new StringZID("003"), "Computer science, Information & General works", 
				                                            "Computer science, knowledge & systems", 
				                                            "Systems"));
		sClassification.add(new Topic(new StringZID("004"), "Computer science, Information & General works",
				                                            "Computer science, knowledge & systems", 
				                                            "Data processing & computer science"));
		sClassification.add(new Topic(new StringZID("006"), "Computer science, Information & General works",
				                                            "Computer science, knowledge & systems", 
				                                            "Special computer methods"));
		
		sClassification.add(new Topic(new StringZID("101"), "Philosophy and psychology", 
				                                            "Philosophy", 
				                                            "Theory of philosophy"));
		sClassification.add(new Topic(new StringZID("110"), "Philosophy and psychology", 
				                                            "Metaphysics", 
				                                            "Metaphysics"));
		sClassification.add(new Topic(new StringZID("114"), "Philosophy and psychology", 
													        "Metaphysics", 
														    "Space"));
		sClassification.add(new Topic(new StringZID("111"), "Philosophy and psychology", 
				                                            "Metaphysics", 
				                                            "Ontology"));
		sClassification.add(new Topic(new StringZID("122"), "Philosophy and psychology",
				            							    "Epistemology", 
				            							    "Causation"));
		
		sClassification.add(new Topic(new StringZID("512"), "Science", 
				                                            "Mathematics", 
				                                            "Algebra & Number Theory"));
		sClassification.add(new Topic(new StringZID("531"), "Science", 
				                                            "Physics", 
				                                            "Classical mechanics; Solid mechanics"));
		sClassification.add(new Topic(new StringZID("537"), "Science", 
                                                            "Physics", 
                                                            "Electricity & Electronics"));
	}

	/**
	 * This method will return only the list of Areas
	 * 
	 */
	@Override
	public List<String> getAreaList()
			throws SubjectClassificationException {
		
		return sClassification.getAreaList();
	}
	
	/**
	 * This method will return only the list of Subjects
	 * 
	 */
	@Override
	public List<String> getSubjectList(String area)
			throws SubjectClassificationException {

		return sClassification.getSubjectList(area);
	}

	/**
	 * This method will return only the list of Topics
	 * 
	 */
	@Override
	public List<Topic> getTopicList(String area, String subject)
			throws SubjectClassificationException {
		
		return sClassification.getTopicList(area, subject);
	}

	@Override
	public SubjectClassification getSubjectClassification()
			throws SubjectClassificationException {
		
		return sClassification;
	}

	
}