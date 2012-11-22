package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.ContentReviewWorkflow;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContentReviewProgress;
import com.ziksana.domain.course.SearchReviewerCriteria;
import com.ziksana.domain.course.WorkflowParticipant;
import com.ziksana.domain.course.WorkflowParticipantComment;
import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberPersona;

/**
 * @author bhashasp
 */
public interface SocializeMapper {

	/**
	 * @param learningContentReviewProgress
	 */
	void saveComponentForReview(
			LearningContentReviewProgress learningContentReviewProgress);

	
	/**
	 * @param isDelete
	 * @param reviewComponent
	 */
	@Update({
			"update corlearningcontentreviewprogress set isdelete = #{isDelete,jdbcType=BOOLEAN} where ",
			" courseid = #{course.courseId,jdbcType=INTEGER} or learningcomponentid = #{learningComponent.learningComponentId,jdbcType=INTEGER}",
			" or learningcomponentcontentid = #{learningComponentContent.learningComponentContentId,jdbcType=INTEGER}" })
	void deleteReviewComponent(Boolean isDelete,
			LearningContentReviewProgress reviewComponent);

	
	/**
	 * @param name
	 * @return
	 */
	@Select({ "select memberid, firstname, lastname  from memmember where firstname in #{name,jdbcType=VARCHAR} or lastname in #{name,jdbcType=VARCHAR}" })
	@Results(value = {
			@Result(property = "memberId", column = "memberid"),
			@Result(property = "firstName", column = "firstname"),
			@Result(property = "lastName", column = "lastname"),
			@Result(property = "memberRoleList", column = "memberid", javaType = MemberPersona.class, one = @One(select = "getMemberRole")) })
	List<Member> basicReviewersSearch(String name);

	
	/**
	 * Role Type shoulbe a Educator{1}
	 * @param memberId
	 * @return
	 */
	@Select({ "select memberroleid,roletype, thumnailpicturepath"
			+ " from memmemberrole where memberid = #{memberId,jdbcType=INTEGER} and roletype= 1 " })
	@Results(value = {
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "roleType", column = "roletype"),
			@Result(property = "thumnailPicturePath", column = "thumnailpicturepath") })
	MemberPersona getMemberRole(Integer memberId);
	

	/**
	 * @param searchCriteria
	 * @return
	 */
	@Select({ "select memberid, firstname, lastname  from memmember ",
			 " where firstname = #{firstName,jdbcType=VARCHAR} and lastname = #{lastName,jdbcType=VARCHAR}" })
	@Results(value = {
			@Result(property = "memberId", column = "memberid"),
			@Result(property = "firstName", column = "firstname"),
			@Result(property = "lastName", column = "lastname"),
			@Result(property = "memberPersona", column = "memberid", javaType = MemberPersona.class, one = @One(select = "getMemberRole")) })
	List<Member> advanceReviewersSearch(SearchReviewerCriteria searchCriteria);

	
	/**
	 * @param workflow
	 */
	@Insert({
			"insert into corcontentreviewworkflow (createdate, workflowtype, learningcontentreviewprogressid )",
			"value (sysdate(), #{workflowType,jdbcType=INTEGER}, #{reviewProgress.reviewProgressId,jdbcType=INTEGER} ",
			" )" })
	void saveReviewWorkflow(ContentReviewWorkflow workflow);

	
	/**
	 * @param participant
	 */
	@Insert({
			"insert into corworkflowparticipant (participanttye, memberroleid, contentreviewworkflowid, isdelete)",
			" values(#{participatingtype,jdbcType=INTEGER}, #{participateMemberRole.memberRoleId,jdbcType=INTEGER},",
			" #{courseWorkflow.contentReviewWorkflowId,jdbcType=INTEGER}, #{isDelete, jdbcType=BOOLEAN}  ) " })
	void saveWorkflowParticipant(WorkflowParticipant participant);

	
	@Update({
			" update corworkflowparticipant set isdelete = #{isDelete, jdbcType=BOOLEAN} where",
			" workflowparticipantid = #{participantId, jdbcType=INTEGER}" })
	void deleteReviewer(Boolean isDelete, Integer participantId);

	
	/**
	 * @param contentReviewWorkflowId
	 * @return
	 */
	@Select({
			"select workflowparticipantid, participanttye, memberroleid, contentreviewworkflowid",
			" from corworkflowparticipant where contentreviewworkflowid = #{contentReviewWorkflowId,jdbcType=INTEGER } and isdelete = #{isDelete,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "workflowparticipantid", column = "workflowparticipantid"),
			@Result(property = "participanttye", column = "participanttye"),
			@Result(property = "memberroleid", column = "memberroleid"),
			@Result(property = "contentreviewworkflowid", column = "contentreviewworkflowid"),
			@Result(property = "memberPersona", column = "memberroleid", javaType = MemberPersona.class, one = @One(select = "getMemberRoleByRoleId")),
			@Result(property = "participantComment", column = "workflowparticipantid", javaType = WorkflowParticipantComment.class, one = @One(select = "getReviewComment")) })
	List<WorkflowParticipant> getReviewerList(Integer contentReviewWorkflowId);

	
	/**
	 * @param workflowParticipantId
	 * @return
	 */
	@Select({ "select workflowparticipantcommentid, comment, status, closingremarks, commenteddate from corworkflowparticipantcomment where workflowparticipantid = #{workflowParticipantId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "workflowParticipantCommentId", column = "workflowparticipantcommentid"),
			@Result(property = "comment", column = "comment"),
			@Result(property = "status", column = "status"),
			@Result(property = "closingRemarks", column = "closingremarks"),
			@Result(property = "commentedDate", column = "commenteddate"), })
	WorkflowParticipantComment getReviewComment(Integer workflowParticipantId);

	
	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select memberroleid, roletype, thumnailpicturepath from memmemberrole where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "roleType", column = "roletype"),
			@Result(property = "thumnailPicturePath", column = "thumnailpicturepath") })
	MemberPersona getMemberRoleByRoleId(Integer memberRoleId);

	
	/**
	 * @param contentReviewWorkflow
	 */
	@Update({ "update corcontentreviewworkflow set completeby = #{completeBy,jdbcType=TIMESTAMP}, " +
			"notes=#{notes, jdbcType=VARCHAR} where contentReviewWorkflowid = #{contentReviewWorkflowId, jdbcType=INTEGER} " })
	void saveContentReviewInfo(ContentReviewWorkflow contentReviewWorkflow);

	
	/**
	 * @param course
	 */
	@Update({
			"update course set coursestatus = #{coursestatus,jdbcType=INTEGER}, version = #{version,jdbcType=INTEGER}",
			" where courid = #{courseId, jdbcType=INTEGER}" })
	void createCourse(Course course);

	
	/**
	 * @param memberRoleId
	 * @param relationshipId
	 * @return
	 */
	@Select({" select mr.memberroleid, mr.roletype, mr.thumnailpicturepath from memmemberrole mr, memmemberrelationship mrs" +
			" where mr.memberroleid = #{memberRoleId,jdbcType=INTEGER} and (mrs.relationshiptype = #{relationshipId, jdbcType=INTEGER}" +
			" and mr.memberroleid = mrs.memberroleid)"})
	@Results(value = {
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "roleType", column = "roletype"),
			@Result(property = "thumnailPicturePath", column = "thumnailpicturepath") })
	MemberPersona getMemberRoleByCircle(Integer memberRoleId, Integer relationshipId);


	@Select({"select reviewprogressid from corlearningcontentreviewprogress where " +
			" courseid = #{course.courseId,jdbcType=INTEGER} and memberroleid = #{authoringMemberRole.memberRoleId, jdbcType=INTEGER} "})
	Integer isSocializeExists(Integer courseId, Integer memberRoleId);

}
