/**
 * 
 */
package com.ziksana.persistence.course;

import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


/**
 * @author vtg-p6 Dec 15, 2012
 * 
 * 
 */
public interface CourseSubjectDetailMapper {

	/**
	 * Retrieves the base course information by Member's (MemberPersona).
	 * 
	 * @param courseId
	 * @return
	 */

	@Select({ "select SubjClassificationId, SubjectCategory from utlsubjectclassification " })
	@Results(value = {
			@Result(property = "subjectClassificationId", column = "courseid"),
			@Result(property = "subjectCategory", column = "description") })
	Map<String, String> getSubjectCategory();

	@Select({ "select SubjClassificationId, SubjectArea from utlsubjectclassification  where SubjectCategory = #{courseId,jdbcType=VARCHAR}" })
	@Results(value = {
			@Result(property = "subjectClassificationId", column = "SubjectClassificationId"),
			@Result(property = "subjectArea", column = "SubjectArea") })
	Map<String, String> getSubjectArea(String subjectArea);

	@Select({ "select SubjClassificationId, SubjectTopic from utlsubjectclassification  where SubjectArea = #{subjectArea,jdbcType=VARCHAR}" })
	@Results(value = {
			@Result(property = "subjectClassificationId", column = "SubjectClassificationId"),
			@Result(property = "subjectTopic", column = "SubjecTopic") })
	Map<String, String> getSubjectTopic(String subjectArea);

}
