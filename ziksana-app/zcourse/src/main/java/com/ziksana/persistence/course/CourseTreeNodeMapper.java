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

	@Select({ "select ID as courseid,Name as coursename  from  corcourse where ID=#{courseId,jdbcType=INTEGER} and isdelete=false" })
	@Results(value = { @Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "coursename") })
	List<TreeNode> getCourseComponent(Integer courseId);

	@Select({ "select cclc.CourseId as courseid,cclc.ID as courselearningcomponentid ,c.ID as learningcomponentid, c.Name as modulename  from corcourse course, corcourselearningcomponent cclc, corlearningcomponent c where cclc.LearningComponentId=c.ID and  cclc.courseid=#{courseId,jdbcType=INTEGER} and c.isdelete=false and course.ID= cclc.courseid and course.IsDelete=false" })
	@Results(value = { @Result(property = "courseId", column = "courseid"),
			@Result(property = "parentId", column = "courseid"),
			@Result(property = "id", column = "learningcomponentid"),
			@Result(property = "title", column = "modulename") })
	List<TreeNode> getModuleComponents(Integer courseId);

	@Select({ "select clc.ID AS LearningComponentId, clcc.ID AS LearningComponentContentId,corlearncontent.ID AS contentid,corlearncontent.ContentName AS contentname,corlearncontent.ContentPath AS contentpath,corlearncontent.ContentType AS contenttype from corlearningcomponent clc, corlearningcomponentcontent clcc, corlearningcontent corlearncontent  where clcc.LearningContentId = corlearncontent.ID and  clcc.LearningComponentId=clc.ID and clc.ID=#{learningComponentId,jdbcType=INTEGER} and corlearncontent.isdelete=false and clc.isdelete=false" })
	@Results(value = {
			@Result(property = "parentId", column = "LearningComponentId"),
			@Result(property = "id", column = "LearningComponentContentId"),
			@Result(property = "contentId", column = "contentid"),
			@Result(property = "title", column = "contentname"),
			@Result(property = "icon", column = "contentpath"),
			@Result(property = "contentType", column = "contenttype") })
	List<TreeNode> getModuleContents(Integer learningComponentId);

	// @Select({
	// "select courseid,coursename,CourseLearningComponentId,LearningComponentId,title from  getparentnode where courseid=#{courseId,jdbcType=INTEGER}"
	// })
	@Select({ "select cclc.CourseId as courseid,cclc.ID as courselearningcomponentid ,c.ID as learningcomponentid, c.Name as modulename  from corcourse course, corcourselearningcomponent cclc, corlearningcomponent c where cclc.LearningComponentId=c.ID and  cclc.courseid=#{courseId,jdbcType=INTEGER} and c.isdelete=false and course.ID= cclc.courseid and course.IsDelete=false" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "modulename"),
			@Result(property = "parentId", column = "courselearningcomponentid"),
			@Result(property = "id", column = "learningcomponentid"),
			@Result(property = "title", column = "modulename") })
	List<TreeNode> getParentTreeComponents(Integer courseId);

	// @Select({
	// "select LearningComponentId,contentid,contenttype,contentname,contentpath from  getchildnode where LearningComponentId=#{learningComponentId,jdbcType=INTEGER}"
	// })
	@Select({ "select clc.ID AS LearningComponentId,corlearncontent.ID AS contentid,corlearncontent.ContentName AS contentname,corlearncontent.ContentPath AS contentpath,corlearncontent.ContentType AS contenttype from corlearningcomponent clc, corlearningcomponentcontent clcc, corlearningcontent corlearncontent  where clcc.LearningContentId = corlearncontent.ID and  clcc.LearningComponentId=clc.ID and clc.ID=#{learningComponentId,jdbcType=INTEGER} and corlearncontent.isdelete=false and clc.isdelete=false" })
	@Results(value = {
			@Result(property = "parentId", column = "LearningComponentId"),
			@Result(property = "id", column = "contentid"),
			@Result(property = "contentname", column = "contentname"),
			@Result(property = "icon", column = "contentpath"),
			@Result(property = "contentType", column = "contenttype"), })
	List<TreeNode> getTreeContentComponents(Integer learningComponentId);

}
