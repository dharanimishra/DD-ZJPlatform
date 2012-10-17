package com.ziksana.service.subjectclassification;

import java.util.List;

import com.ziksana.domain.utilz.SubjectClassification;
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
	public List<String> getTopicList(String area, String subject) throws SubjectClassificationException;

	/**
	 * Retrieve the whole list (Area - Subject - Topic).
	 * 
	 * @param area
	 * @return
	 * @throws SubjectClassificationException
	 */
	public List<SubjectClassification> getSubjectClassification() throws SubjectClassificationException;
}