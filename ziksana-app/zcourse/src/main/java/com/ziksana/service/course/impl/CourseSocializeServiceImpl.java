package com.ziksana.service.course.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.ziksana.domain.course.ContentReviewWorkflow;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.LearningContentReviewProgress;
import com.ziksana.domain.course.SearchReviewerCriteria;
import com.ziksana.domain.course.WorkflowItemStatus;
import com.ziksana.domain.course.WorkflowParticipant;
import com.ziksana.domain.course.WorkflowParticipantComment;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.SocializeMapper;
import com.ziksana.service.course.CourseSocializeService;

/**;
 * @author bhashasp
 */
public class CourseSocializeServiceImpl implements CourseSocializeService {

	private static Logger logger = Logger.getLogger(CourseSocializeServiceImpl.class);
	
	@Autowired
	public SocializeMapper socializeMapper;
	
	@Transactional
	@Override
	public void saveCourseComponetsForReview(List<LearningContentReviewProgress> reviewComponentsList)
			throws CourseException {
		
		if(reviewComponentsList== null){
			throw new CourseException("Review Components list cannot be null");
		}
		
		if(reviewComponentsList.size()>0){

			for (LearningContentReviewProgress learningContentReviewProgress : reviewComponentsList) {
				
				logger.debug("Saving the Course component for Review ... ");
				
				socializeMapper.saveComponentForReview(learningContentReviewProgress);
				
			}
		}
	}

	@Override
	public void deleteReviewCourseComponent(
			LearningContentReviewProgress reviewComponent)
			throws CourseException {
		
		Boolean isDelete = true;
		if(reviewComponent == null){
			throw new CourseException("Review Components cannot be null");
		}
		
		socializeMapper.deleteReviewComponent(isDelete, reviewComponent);
		
	}

	@Override
	public List<Member> searchReviewers(SearchReviewerCriteria searchCriteria)
			throws CourseException {
	
		List<Member> memberList = null;
		
		if(searchCriteria == null){
			throw new CourseException("Search Criteri cannot be null");
		}
		
		if(searchCriteria.getName()!=null){
			
			memberList = socializeMapper.basicReviewersSearch(searchCriteria.getName());
			
			return memberList;
		}
		
		memberList = socializeMapper.advanceReviewersSearch(searchCriteria);
		
		return memberList;
	}


	@Transactional
	@Override
	public void associateReviwers(LearningContentReviewProgress review, List<Member> memberList)
			throws CourseException {
		ContentReviewWorkflow 		workflow 		= null;
		WorkflowParticipant 		participant		= null;
		
		if(review.getReviewProgressId() == null){
			throw new CourseException("Review cannot be null");
		}
	
		workflow = review.getContentReviewWorkflow();
		
		workflow.setContentReviewWorkflowId(review.getReviewProgressId());
		
		socializeMapper.saveReviewWorkflow(workflow);
		
		for (Member member : memberList) {
			
			participant = new WorkflowParticipant();
			
			participant.setParticipateMemberRole(member.getMemberPersona());
			
			participant.setCourseWorkflow(workflow);
			
			socializeMapper.saveWorkflowParticipant(participant);
			
		}
		
	}

	@Override
	public void deleteReviewer(WorkflowParticipant workflowParticipant) throws CourseException {

		Boolean 					isDelete 	= true;
		WorkflowParticipantComment 	comment 	= null;
		if( workflowParticipant == null){
			throw new CourseException("Participant ID cannot null");
		}
		
		comment = workflowParticipant.getParticipantComment();
		
		if((comment.getStatus().equals(WorkflowItemStatus.REVIEW_IN_PROGRESS)) || 
				(comment.getStatus().equals(WorkflowItemStatus.OPEN_FOR_REVIEW))){
			
			socializeMapper.deleteReviewer(isDelete, new Integer(workflowParticipant.getParticipantId() .getStorageID()));
			
		}else{
			throw new CourseException("Cannot delete the Reviewer with review status as Completed/Declineda");
		}
		
	}

	
	@Override
	public List<WorkflowParticipant> gerReviewers(ZID contentReviewWorkflowId)
			throws CourseException {

		List<WorkflowParticipant> reviewerParticipantsList = null;
		
		if(contentReviewWorkflowId == null){
			throw new CourseException("ContentReviewWorkflow ID cannot be null");
		}
		
		reviewerParticipantsList = socializeMapper.getReviewerList(new Integer(contentReviewWorkflowId.getStorageID()));
		
		return reviewerParticipantsList;
	}

	@Transactional
	@Override
	public void saveCourse(Course course, List<ContentReviewWorkflow> reviewContentList)
			throws CourseException {
		
		if(reviewContentList == null){
			throw new CourseException("ContentReviewWorkflow list cannot be null");
		}
		
		for (ContentReviewWorkflow contentReviewWorkflow : reviewContentList) {
			
			logger.debug("Completeby :"+contentReviewWorkflow.getCompleteBy()+" :: Note :"+contentReviewWorkflow.getNotes());
			
			if(contentReviewWorkflow.getContentReviewWorkflowId()!=null){

				socializeMapper.saveContentReviewInfo(contentReviewWorkflow);	
				
			}
		}
		
		if(course.getCourseId()==null){
			throw new CourseException("Course ID cannot be null");
		}
		
		course.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
		socializeMapper.createCourse(course);
		
	}
	

	@Override
	public void createCourse(Course course) throws CourseException {
		
	
		if(course.getCourseId()==null){
			throw new CourseException("Course ID cannot be null");
		}
		
		course.setCourseStatus(CourseStatus.REVIEW);
		
		socializeMapper.createCourse(course);
		
		//TODO: send the notification to reviewers to review.
	}

}
