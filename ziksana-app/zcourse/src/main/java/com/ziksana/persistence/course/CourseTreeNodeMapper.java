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

	// create view getparentnode as select cc.CourseId as courseid, cc.Name as
	// coursename,cclc.CourseLearningComponentId as
	// CourseLearningComponentId,clc.LearningComponentId as
	// LearningComponentId,clc.Name as title from corcourse cc ,
	// corcourselearningcomponent cclc , corlearningcomponent clc where
	// cclc.LearningComponentId=clc.LearningComponentId
	@Select({ "select courseid,coursename,CourseLearningComponentId,LearningComponentId,title from  getparentnode where courseid=#{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "coursename"),
			@Result(property = "parentId", column = "CourseLearningComponentId"),
			@Result(property = "id", column = "CourseLearningComponentId"),
			@Result(property = "title", column = "title") })
	List<TreeNode> getParentTreeComponents(Integer courseId);

	// create view getchildnode as select distinct clcc.LearningComponentId as
	// LearningComponentId ,clcon.LearningContentId as
	// contentid,clcon.ContentType as contenttype,clcon.ContentName as
	// contentname,clcon.ContentPath as contentpath from
	// corlearningcomponentcontent clcc, corlearningcontent clcon where
	// clcc.LearningComponentId=clcon.LinkedLearningContentId
	@Select({ "select LearningComponentId,contentid,contenttype,contentname,contentpath from  getchildnode where LearningComponentId=#{learningComponentId,jdbcType=INTEGER}" })
	@Results(value = {

	@Result(property = "parentId", column = "LearningComponentId"),
			@Result(property = "id", column = "contentid"),
			@Result(property = "contentType", column = "contenttype"),
			@Result(property = "contentname", column = "contentname"),
			@Result(property = "icon", column = "contentpath") })
	List<TreeNode> getTreeContentComponents(Integer learningComponentId);

}
