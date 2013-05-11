package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.Option;

/**
 * @author Ratnesh Kumar, Jan 01, 2013
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

	@Select({ "select distinct SubjectArea,SubjectArea from utlsubjectclassification" })
	@Results(value = { @Result(property = "value", column = "SubjectArea"),
			@Result(property = "label", column = "SubjectArea") })
	List<Option> getSubjectCategory();

	@Select({ "select  distinct SubjectCategory,SubjectCategory from utlsubjectclassification  where SubjectArea = #{subjectArea,jdbcType=VARCHAR}" })
	@Results(value = { @Result(property = "value", column = "SubjectCategory"),
			@Result(property = "label", column = "SubjectCategory") })
	List<Option> getSubjectArea(String subjectArea);

	@Select({ "select  distinct SubjectTopic, SubjectTopic from utlsubjectclassification  where SubjectCategory = #{subjectCategory,jdbcType=VARCHAR}" })
	@Results(value = { @Result(property = "value", column = "SubjectTopic"),
			@Result(property = "label", column = "SubjectTopic") })
	List<Option> getSubjectTopic(String subjectCategory);

	@Select({ "select ID,SubjectArea, SubjectCategory,SubjectTopic from utlsubjectclassification  where  SubjectTopic=#{subjectTopic,jdbcType=VARCHAR}" })
	@Results(value = {
			@Result(property = "subjClassificationId", column = "ID"),
			@Result(property = "subjectArea", column = "SubjectArea"),
			@Result(property = "subjectCategory", column = "SubjectCategory"),
			@Result(property = "subjectTopic", column = "SubjectTopic") })
	CourseSubjectClassification getSubjectClassification(String subjectTopic);

	@Select({ "select utl.ID as ID, SubjectArea, SubjectCategory,SubjectTopic from utlsubjectclassification utl,corcourse course where utl.ID=course.SubjClassificationId and course.id= #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "subjClassificationId", column = "ID"),
			@Result(property = "subjectArea", column = "SubjectArea"),
			@Result(property = "subjectCategory", column = "SubjectCategory"),
			@Result(property = "subjectTopic", column = "SubjectTopic") })
	CourseSubjectClassification getCourseClassification(Integer courseId);

}
