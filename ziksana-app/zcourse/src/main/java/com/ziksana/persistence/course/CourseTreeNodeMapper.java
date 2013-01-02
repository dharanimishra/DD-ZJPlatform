/**
 * 
 */
package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.TreeNode;

/**
 * @author vtg-p6 Dec 10, 2012
 * 
 * 
 */
public interface CourseTreeNodeMapper {

	/**
	 * This method will retrieves the course learning components and its
	 * contents from the database.
	 * 
	 * @param course
	 * @return
	 */

	@Select({ "select courseid,coursename,CourseLearningComponentId,learningcomponentid,title,contentid,contenttype,contentpath from  gettreenode where courseid=#{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "coursename"),
			@Result(property = "parentId", column = "CourseLearningComponentId"),
			@Result(property = "id", column = "CourseLearningComponentId"),
			@Result(property = "title", column = "title"),
			@Result(property = "contentId", column = "contentid"),
			@Result(property = "contentType", column = "contenttype"),
			@Result(property = "icon", column = "contentpath") })
	List<TreeNode> getParentTreeComponents(Integer courseId);


	@Select({ "select courseid,coursename,CourseLearningComponentId,contentid,contenttype,contentname,contentpath from  gettreenode where courseid=#{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "coursename"),
			@Result(property = "parentId", column = "CourseLearningComponentId"),
			@Result(property = "id", column = "contentid"),
			@Result(property = "contentType", column = "contenttype"),
			@Result(property = "contentname", column = "contentname"),
			@Result(property = "icon", column = "contentpath") })
	List<TreeNode> getTreeContentComponents(Integer courseId);

}
