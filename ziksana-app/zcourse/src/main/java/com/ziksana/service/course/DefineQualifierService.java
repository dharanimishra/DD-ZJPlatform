package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;

public interface DefineQualifierService {
	
	/**
	 * Associated Qualifiers populated with already defined qualifiers.  
	 * @param course
	 * @return
	 * @throws CourseException
	 */
	public List<LearningComponentType> getDefinedQualifiers(Member member) throws CourseException;
	
	/**
	 * Delete the Institution/User defined Qualifiers.
	 * @param learningComponent
	 * @throws CourseException
	 */
	public void deleteQualifier(ZID learningComponentTypeId) throws CourseException;
	
	/**
	 * Modify User defined Qualifiers only.
	 * @param learningComponent
	 * @throws CourseException
	 */
	public void updateQualifier(ZID learningComponentTypeId, LearningComponent learningComponent) throws CourseException;
	
	/**
	 * Search the Define Qualifiers based on the search criteria(All/Used Defined/Institution Defined)
	 * @param learningComponent
	 * @return
	 * @throws CourseException
	 */
	public List<LearningComponent> searchQualifier(LearningComponent learningComponent) throws CourseException;
	
	/**
	 * associates the define qualifier to component
	 * @param learningComponent
	 * @throws CourseException
	 */
	public void associateNewQualifier(LearningComponent learningComponent) throws CourseException;
	
}
