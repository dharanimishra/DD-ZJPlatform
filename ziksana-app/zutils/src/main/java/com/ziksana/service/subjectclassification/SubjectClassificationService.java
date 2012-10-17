package com.ziksana.service.subjectclassification;

import java.util.List;

import com.ziksana.domain.utils.SubjectClassification;
import com.ziksana.domain.utils.Topic;
import com.ziksana.exception.subjectclassification.SubjectClassificationException;

public interface SubjectClassificationService {

	/**
	 * Retrieve list of areas.
	 * 
	 * @param 
	 * @return
	 * @throws SubjectClassificationException
	 */
	public List<String> getAreaList() throws SubjectClassificationException;

	/**
	 * Retrieve list of Subjects.
	 * 
	 * @param 
	 * @return
	 * @throws SubjectClassificationException
	 */
	public List<String> getSubjectList(String area) throws SubjectClassificationException;
	
	/**
	 * Retrieve list of Topics.
	 * 
	 * @param 
	 * @return
	 * @throws SubjectClassificationException
	 */
	public List<Topic> getTopicList(String area, String subject) throws SubjectClassificationException;

	/**
	 * Retrieve the whole list (Area - Subject - Topic).
	 * 
	 * @return SubjectClassification
	 * @throws SubjectClassificationException
	 */
	public SubjectClassification getSubjectClassification() throws SubjectClassificationException;
}