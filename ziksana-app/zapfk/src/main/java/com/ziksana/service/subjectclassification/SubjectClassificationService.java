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
	public List<String> getSubjectList() throws SubjectClassificationException;
	
	/**
	 * Retrieve list of Topics.
	 * 
	 * @param 
	 * @return
	 * @throws SubjectClassificationException
	 */
	public List<String> getTopicList() throws SubjectClassificationException;

	/**
	 * Retrieve list of Subjects based on area.
	 * 
	 * @param area
	 * @return
	 * @throws SubjectClassificationException
	 */
	public SubjectClassification getSubjectList(SubjectClassification subjectClassification) throws SubjectClassificationException;


	/**
	 * Retrieve list of Topics based on area and subject.
	 * 
	 * @param area subject
	 * @return
	 * @throws SubjectClassificationException
	 */
	public SubjectClassification getTopicList(SubjectClassification subjectClassification) throws SubjectClassificationException;

}