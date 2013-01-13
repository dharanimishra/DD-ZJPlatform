/**
 * 
 */
package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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

	@Select({ "select courseid,coursename,learningcomponentid,modulename from  getmoduletree where courseid=#{courseId,jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "coursename"),
			@Result(property = "id", column = "learningcomponentid"),
			@Result(property = "title", column = "modulename") })
	List<TreeNode> getModuleComponents(Integer courseId);

	@Select({ "select LearningComponentId,LearningComponentContentId,contentid,contentname,contentpath,contenttype from  getcontenttree where LearningComponentId=#{learningComponentId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "parentId", column = "LearningComponentId"),
			@Result(property = "id", column = "LearningComponentContentId"),
			@Result(property = "contentId", column = "contentid"),
			@Result(property = "title", column = "contentname"),
			@Result(property = "icon", column = "contentpath"),
			@Result(property = "contentType", column = "contenttype") })
	List<TreeNode> getModuleContents(Integer learningComponentId);

	@Select({ "select courseid,coursename,CourseLearningComponentId,LearningComponentId,title from  getparentnode where courseid=#{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "coursename"),
			@Result(property = "parentId", column = "CourseLearningComponentId"),
			@Result(property = "id", column = "CourseLearningComponentId"),
			@Result(property = "title", column = "title") })
	List<TreeNode> getParentTreeComponents(Integer courseId);

	@Select({ "select LearningComponentId,contentid,contenttype,contentname,contentpath from  getchildnode where LearningComponentId=#{learningComponentId,jdbcType=INTEGER}" })
	@Results(value = {

	@Result(property = "parentId", column = "LearningComponentId"),
			@Result(property = "id", column = "contentid"),
			@Result(property = "contentType", column = "contenttype"),
			@Result(property = "contentname", column = "contentname"),
			@Result(property = "icon", column = "contentpath") })
	List<TreeNode> getTreeContentComponents(Integer learningComponentId);

}
