package com.ziksana.persistence.course;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.ContentReviewWorkflow;
import com.ziksana.domain.course.LearningContentReviewProgress;

/**
 * @author bhashasp
 */
public interface CoursePublishMapper {

	@Select({"select * from corlearningcontentreviewprogress where memberroleid = #{memberRoleId,jdbcType=INTEGER}"})
	List<LearningContentReviewProgress> getReviewComponentsByMemberRoleId(
			Integer memberRoleId);
	
	

	@Update({"update corworkflowparticipantcomment set isdelete = #{isDelete, jdbcType=BOOLEAN} where " +
			" workflowparticipantcommentid = #{reviewCommentId, jdbcType=INTEGER}"})
	void deleteReviewComment(Boolean isDelete, Integer reviewCommentId);


	@Select({"select reviewprogressid from corlearningcontentreviewprogress where reviewprogressid = #{reviewProgressId,jdbcType=INTEGER}"})
	LearningContentReviewProgress getReviewContentDetails(Integer reviewProgressId);
	
	
	@Select({"select * from corcontentreviewworkflowc wf, corworkflowparticipant wp, corworkflowparticipantcomment wpc " +
			" where wf.reviewprogressid = #{reviewProgressId,jdbcType=INTEGER} "})
	ContentReviewWorkflow getWorkflow(Integer reviewProgressId);

}
