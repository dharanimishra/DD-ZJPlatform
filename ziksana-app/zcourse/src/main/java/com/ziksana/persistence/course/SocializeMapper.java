package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
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

	@Insert({
			"insert into corlearningcontentreviewprogress (startdate, enddate, duration, durationunits, averagerating,"
					+ " degreeofcompletion, coursestatus, description, courseid, learningcomponentid, ",
			" leraningcomponentcontentid, authoringmemberroleid) ",
			" values (#{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, #{duration,jdbcType=INTEGER}, ",
			" #{durationUnits,jdbcType=INTEGER},  #{averageRating,jdbcType=INTEGER}, #{degreeOfCompletion,jdbcType=INTEGER},",
			" #{courseStatus,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, #{course.courseId,jdbcType=INTEGER},",
			" #{learningComponent.learningComponentId,jdbcType=INTEGER}, ",
			" #{learningComponentContent.learningComponentContentId,jdbcType=INTEGER},",
			" #{authoringMemberRole.memberRoleId,jdbcType=INTEGER}) " })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "reviewprogressid", before = true, resultType = Integer.class)
	void saveComponentForReview(
			LearningContentReviewProgress learningContentReviewProgress);

	@Update({
			"update corlearningcontentreviewprogress set isdelete = #{isDelete,jdbcType=BOOLEAN} where ",
			" courseid = #{course.courseId,jdbcType=INTEGER} or learningcomponentid = #{learningComponent.learningComponentId,jdbcType=INTEGER}",
			" or learningcomponentcontentid = #{learningComponentContent.learningComponentContentId,jdbcType=INTEGER}" })
	void deleteReviewComponent(Boolean isDelete,
			LearningContentReviewProgress reviewComponent);

	@Select({ "select memberid, firstname, lastname  from memmember where firstname in #{name,jdbcType=VARCHAR} or lastname in #{name,jdbcType=VARCHAR}" })
	@Results(value = {
			@Result(property = "memberId", column = "memberid"),
			@Result(property = "firstName", column = "firstname"),
			@Result(property = "lastName", column = "lastname"),
			@Result(property = "memberPersona", column = "memberid", javaType = List.class, many = @Many(select = "getMemberRoles")) })
	List<Member> basicReviewersSearch(String name);

	@Select({ "select memberroleid, roletype, thumnailpicturepath from memmemberrole where memberid = #{memberId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "roleType", column = "roletype"),
			@Result(property = "thumnailPicturePath", column = "thumnailpicturepath") })
	List<MemberPersona> getMemberRoles(Integer memberId);

	@Select({ "select memberid, firstname, lastname  from memmember where firstname = #{firstName,jdbcType=VARCHAR} and lastname = #{lastName,jdbcType=VARCHAR}" })
	@Results(value = {
			@Result(property = "memberId", column = "memberid"),
			@Result(property = "firstName", column = "firstname"),
			@Result(property = "lastName", column = "lastname"),
			@Result(property = "memberPersona", column = "memberid", javaType = List.class, many = @Many(select = "getMemberRoles")) })
	List<Member> advanceReviewersSearch(SearchReviewerCriteria searchCriteria);

	@Insert({
			"insert into corcontentreviewworkflow (createdate, workflowtype, learningcontentreviewprogressid )",
			"value (sysdate(), #{workflowType,jdbcType=INTEGER}, #{reviewProgress.reviewProgressId,jdbcType=INTEGER} ",
			" )" })
	void saveReviewWorkflow(ContentReviewWorkflow workflow);

	@Insert({
			"insert into corworkflowparticipant (participanttye, memberroleid, contentreviewworkflowid, isdelete)",
			" values(#{participatingtype,jdbcType=INTEGER}, #{participateMemberRole.memberRoleId,jdbcType=INTEGER},",
			" #{courseWorkflow.contentReviewWorkflowId,jdbcType=INTEGER}, #{isDelete, jdbcType=BOOLEAN}  ) " })
	void saveWorkflowParticipant(WorkflowParticipant participant);

	@Update({
			" update corworkflowparticipant set isdelete = #{isDelete, jdbcType=BOOLEAN} where",
			" workflowparticipantid = #{participantId, jdbcType=INTEGER}" })
	void deleteReviewer(Boolean isDelete, Integer participantId);
	

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
	
	

	@Select({ "select workflowparticipantcommentid, comment, status, closingremarks, commenteddate from corworkflowparticipantcomment where workflowparticipantid = #{workflowParticipantId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "workflowParticipantCommentId", column = "workflowparticipantcommentid"),
			@Result(property = "comment", column = "comment"),
			@Result(property = "status", column = "status"),
			@Result(property = "closingRemarks", column = "closingremarks"),
			@Result(property = "commentedDate", column = "commenteddate"),
			})
	WorkflowParticipantComment getReviewComment(Integer workflowParticipantId);
 
	
	
	@Select({ "select memberroleid, roletype, thumnailpicturepath from memmemberrole where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "memberId", column = "memberid"),
			@Result(property = "roleType", column = "roletype"),
			@Result(property = "thumnailPicturePath", column = "thumnailpicturepath") })
	MemberPersona getMemberRoleByRoleId(Integer memberRoleId);

	
	@Update({"update corcontentreviewworkflow set completeby = #{completeBy,jdbcType=TIMESTAMP}, notes=#{notes, jdbcType=VARCHAR} where contentReviewWorkflowid = #{contentReviewWorkflowId, jdbcType=INTEGER} "})
	void saveContentReviewInfo(ContentReviewWorkflow contentReviewWorkflow);

	
	
	@Update({"update course set coursestatus = #{coursestatus,jdbcType=INTEGER}, version = #{version,jdbcType=INTEGER}" ,
			" where courid = #{courseId, jdbcType=INTEGER}"})
	void createCourse(Course course);

	
	
}
