package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.ContentReviewRating;
import com.ziksana.domain.course.ContentReviewWorkflow;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContentReviewProgress;
import com.ziksana.domain.course.WorkflowParticipant;
import com.ziksana.domain.course.WorkflowParticipantComment;

/**
 * @author bhashasp
 */
public interface CoursePublishMapper {

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({"select reviewprogressid, durationunit, duration, degreeofcompletion," +
			" description, averagerating, courseid, learningcomponentid, learningcomponentcontentid " +
			" from corlearningcontentreviewprogress where memberroleid = #{memberRoleId,jdbcType=INTEGER}"})
	@Results(value = { 
			@Result(property = "reviewProgressId", column = "reviewprogressid"),
			@Result(property = "courseId", column = "courseid"),
			@Result(property = "degreeOfCompletion", column = "degreeofcompletion"),
			@Result(property = "description", column = "description"),
			@Result(property = "averageRating", column = "averagerating"),
			@Result(property = "learningComponent.learningComponentId", column = "learningcomponentid"),
			@Result(property = "learningComponentContent.learningComponentContentId", column = "learningcomponentcontentid"),
			@Result(property = "authoringMemberRole.memberRoleId", column = "memberroleid"),
			@Result(property = "totalDuration.duration", column = "duration"),
			@Result(property = "totalDuration.durationUnit", column = "durationunit")
			})
	List<LearningContentReviewProgress> getReviewComponentsByMemberRoleId(
			Integer memberRoleId);

	/**
	 * @param isDelete
	 * @param reviewCommentId
	 */
	@Update({"update corworkflowparticipantcomment set isdelete = #{isDelete, jdbcType=BOOLEAN} where " +
			" workflowparticipantcommentid = #{reviewCommentId, jdbcType=INTEGER}"})
	void deleteReviewComment(Boolean isDelete, Integer reviewCommentId);


	/**
	 * @param reviewProgressId
	 * @return
	 */
	@Select({"select reviewprogressid from corlearningcontentreviewprogress where reviewprogressid = #{reviewProgressId,jdbcType=INTEGER}"})
	@Results(value = { 
			@Result(property = "reviewProgressId", column = "reviewprogressid")
	})
	LearningContentReviewProgress getReviewContentDetails(Integer reviewProgressId);
	
	
	/**
	 * @param reviewProgressId
	 * @return
	 */
	@Select({"select contentreviewworkflowid, workflowtype, completeby, notes from corcontentreviewworkflow " +
			" where reviewprogressid = #{reviewProgressId,jdbcType=INTEGER} "})
	@Results(value = { 
			@Result(property = "contentReviewWorkflowId", column = "contentreviewworkflowid"),
			@Result(property = "workflowType", column = "workflowtype"),
			@Result(property = "completeBy", column = "completeby"),
			@Result(property = "notes", column = "notes"),
			@Result(property = "reviewerList", column="contentreviewworkflowid", javaType=List.class,many=@Many(select="getWorkflowParticipants"))
			})
	ContentReviewWorkflow getWorkflow(Integer reviewProgressId);
	
	
	/**
	 * @param contentReviewWorkflowId
	 * @return
	 */
	@Select({"select participantid, startdate, enddate, participanttype from corworkflowparticipant " +
			"where contentReviewWorkflowId = #{contentReviewWorkflowId,jdbcType=INTEGER}"})
	@Results(value = { 
			@Result(property = "participantId", column = "participantid"),
			@Result(property = "startDate", column = "startdate"),
			@Result(property = "endDate", column = "enddate"),
			@Result(property = "participantType", column = "participanttype"),
			@Result(property = "participantComment", column="participantid", javaType=WorkflowParticipantComment.class,one=@One(select="getWorkflowParticipantComment"))
			})
	List<WorkflowParticipant> getWorkflowParticipants(Integer contentReviewWorkflowId);
	
	/**
	 * @param participantId
	 * @return
	 */
	@Select({"select participantcommentid, status, criticality from corworkflowparticipantcomment " +
	"where contentReviewWorkflowId = #{contentReviewWorkflowId,jdbcType=INTEGER}"})
	@Results(value = { 
			@Result(property = "participantCommentId", column = "participantcommentid"),
			@Result(property = "status", column = "status"),
			@Result(property = "criticality", column = "criticality")
	})
	WorkflowParticipantComment getWorkflowParticipantComment(
			Integer participantId);

	/**
	 * @param workflow
	 * @return
	 */
	@Insert({"insert into corcontentreviewworkflow" +
			" (creationdate, workflowtype, completeby, notes, reviewprogressid) values " +
			"(sysdate(), #{workflowType, jdbcType=INTEGER}, #{completeBy, jdbcType=DATE}, " +
			"#{notes, jdbcType=VARCHAR}, #{reviewProgress.reviewProgressId, jdbcType=INTEGER} )"})
	@Results(value = { 
			@Result(property = "contentReviewWorkflowId", column = "contentreviewworkflowid"),
			@Result(property = "workflowType", column = "workflowtype"),
			@Result(property = "completeBy", column = "completeby"),
			@Result(property = "notes", column = "notes"),
		})
	ContentReviewWorkflow saveContentReviewWorkflow(ContentReviewWorkflow workflow);
	

	/**
	 * @param newParticipant
	 * @return
	 */
	@Insert({"insert into corworkflowparticipant " +
			"(startdate, enddate, participanttype, contentreviewworkflowid, memberroleid) values " +
			"( #{startDate, jdbcType=DATE}, #{endDate, jdbcType=DATE}, " +
			"#{participantType, jdbcType=INTEGER}, #{courseWorkflow.contentReviewWorkflowId, jdbcType=INTEGER}, #{participateMemberRole.memberRoleId, jdbcType=INTEGER}) "})
	@Results(value = { 
			@Result(property = "participantId", column = "participantid"),
			@Result(property = "startDate", column = "startdate"),
			@Result(property = "endDate", column = "enddate"),
			@Result(property = "participantType", column = "participanttype")
			})
	WorkflowParticipant createWorkflowParticipant(
			WorkflowParticipant newParticipant);

	
	/**
	 * @param comment
	 */
	@Insert({"insert into corworkflowparticipantcomment " +
			" ( commentdate, comment, status, criticality )" +
	"values (sysdate(), #{comment,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{criticality,jdbcType=INTEGER}, #{participant.participantId,jdbcType=INTEGER} )"})
	void saveWorkflowComment(WorkflowParticipantComment comment);

	
	@Select({"select reviewratingid, reviewrating from corcontentreviewrating where reviewprogressid = #{reviewProgressId, jdbcType=INTEGER}"})
	@Results(value = { 
			@Result(property = "reviewRatingId", column = "reviewratingid"),
			@Result(property = "reviewRating", column = "reviewrating")
	})
	List<ContentReviewRating> getContentReviewRating(Integer reviewProgressId);

	
	
	@Select({"select rr.reviewratingid, rr.reviewrating from corcontentreviewrating rr, corworkflowparticipant wp " +
			" where wp.memberroleid = #{memberRoleId, jdbcType=INTEGER} and wp.participantid = rr.participantid "})
	@Results(value = { 
			@Result(property = "reviewRatingId", column = "reviewratingid"),
			@Result(property = "reviewRating", column = "reviewrating")
	})
	List<ContentReviewRating> getAuthorReviewRating(Integer memberRoleId);

}
