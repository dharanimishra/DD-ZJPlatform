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
	@Select({ "select courseid, name, description, memberroleid from corcourse where courseid = #{courseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "accountableMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"), })
	Course getCourseComponents(Integer courseId);


	//create view gettreenode as select cc.courseid as courseid,cc.name as coursename,cn.LearningComponentId as learningcomponentid,cn.name as title,cn.LearningComponentTypeId as LearningComponentTypeId ,lc.LearningContentId as contentid,lc.ContentType as contenttype ,lc.ContentName as contentname, lc.ContentPath as contentpath from  corcourse cc, corcourselearningcomponent ccc ,corlearningcomponent cn,corlearningcontent lc where  cc.CourseId=ccc.CourseId and ccc.CourseLearningComponentId=cn.LearningComponentId  
	@Select({ "select courseid,coursename,CourseLearningComponentId,learningcomponentid,title,LearningComponentTypeId,contentid,contenttype,contentname,contentpath from  gettreenode where courseid=#{courseId,jdbcType=INTEGER}"})
	@Results(value = { @Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "coursename"),
			@Result(property = "parentId", column = "CourseLearningComponentId"),
			@Result(property = "id", column = "learningcomponentid"),
			@Result(property = "parentId", column = "learningcomponentid"),
			@Result(property = "title", column = "title"),
			@Result(property = "contentTypeId", column = "LearningComponentTypeId"),
			@Result(property = "contentId", column = "contentid"),
			@Result(property = "contentType", column = "contenttype"),
			@Result(property = "contentname", column = "contentname"),
			@Result(property = "icon", column = "contentpath") })
	List<TreeNode> getTreeComponents(Integer courseId);

}
