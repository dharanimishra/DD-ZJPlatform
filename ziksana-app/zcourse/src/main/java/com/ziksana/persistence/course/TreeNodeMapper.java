package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.NestContentNode;
import com.ziksana.domain.course.NestTreeNode;

public interface TreeNodeMapper {

	@Select({ "select ID as courseid,Name as coursename,CourseDuration as duration  from  corcourse where ID=#{courseId,jdbcType=INTEGER} and isdelete=false" })
	@Results(value = { @Result(property = "courseId", column = "courseid"),
			@Result(property = "coursename", column = "coursename"),
			@Result(property = "duration", column = "duration")})
	List<NestTreeNode> getCourseComponent(Integer courseId);

	@Select({ "select cclc.CourseId as courseid,course.CourseDuration as duration,c.ID as learningcomponentid, c.Name as modulename,nest.ParentLearningComponentId as ParentLearningComponentId,nest.NestLearningComponentId as NestLearningComponentId  from corcourse course, corcourselearningcomponent cclc, corlearningcomponent c,corlearningcomponentnest nest where cclc.LearningComponentId=c.ID and  cclc.courseid=#{courseId,jdbcType=INTEGER} and c.isdelete=false and course.ID= cclc.courseid and course.IsDelete=false and c.ID=nest.NestLearningComponentId" })
	@Results(value = {
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "id", column = "learningcomponentid"),
			@Result(property = "title", column = "modulename"),
			@Result(property = "parentLearningComponentId", column = "ParentLearningComponentId"),
			@Result(property = "nestLearningComponentId", column = "NestLearningComponentId"),
			@Result(property = "duration", column = "duration")

	})
	List<NestTreeNode> getModuleComponents(Integer courseId);

	//@Select({ "select clc.ID AS LearningComponentId, clcc.ID AS LearningComponentContentId,corlearncontent.ID AS contentid,corlearncontent.ContentName AS contentname,corlearncontent.ContentPath AS contentpath,corlearncontent.ContentType AS contenttype from corcourselearningcomponent cclc,corlearningcomponent clc, corlearningcomponentcontent clcc, corlearningcontent corlearncontent  where clcc.LearningContentId = corlearncontent.ID and  clcc.LearningComponentId=clc.ID and cclc.CourseId=#{courseId,jdbcType=INTEGER} and cclc.LearningComponentId=clc.ID and clcc.isdelete=false" })
	@Select({ " select " +  
		"clc.ID AS LearningComponentId, clcc.ID " + 
		"AS LearningComponentContentId, " +
		"corlearncontent.ID AS contentid, " +
		"corlearncontent.ContentName AS contentname, " +
		"corlearncontent.ContentPath AS contentpath, " +
		"learning_content_decoration.ContentDecorationType AS decorationType, " +
		"corlearncontent.ContentType AS contenttype   " +
		"from corcourselearningcomponent cclc,corlearningcomponent clc,  " +
		"corlearningcomponentcontent clcc, corlearningcontent corlearncontent   " +
		"LEFT OUTER JOIN corlearningcontentdecoration learning_content_decoration  " +
		"	ON corlearncontent.ID = learning_content_decoration.LearningContentId " +
		"LEFT OUTER JOIN corlearningcontentdecoration learning_content_decoration1  " +
		"ON corlearncontent.ID = learning_content_decoration1.LearningContentId " +
	    "AND learning_content_decoration.ID < learning_content_decoration1.ID " +
		"where clcc.LearningContentId = corlearncontent.ID " + 
		"and   " +
		"clcc.LearningComponentId=clc.ID  " +
		"and cclc.CourseId=#{courseId,jdbcType=INTEGER} and cclc.LearningComponentId=clc.ID and clcc.isdelete=false " + 
		"and learning_content_decoration1.ID IS NULL"
		})
	@Results(value = {
			@Result(property = "parentLearningComponentId", column = "LearningComponentId"),
			@Result(property = "id", column = "LearningComponentContentId"),
			@Result(property = "contentId", column = "contentid"),
			@Result(property = "contentname", column = "contentname"),
			@Result(property = "decorationTypeId", column = "decorationType"),
			@Result(property = "icon", column = "contentpath"),
			@Result(property = "contentType", column = "contenttype") })
	List<NestContentNode> getContentComponents(Integer courseId);

}
