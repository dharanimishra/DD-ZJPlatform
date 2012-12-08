package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.contacts.RelationshipType;
import com.ziksana.domain.course.ContentReviewWorkflow;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.LearningContentReviewProgress;
import com.ziksana.domain.course.SearchReviewerCriteria;
import com.ziksana.domain.course.WorkflowItemStatus;
import com.ziksana.domain.course.WorkflowParticipant;
import com.ziksana.domain.course.WorkflowParticipantComment;
import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
//import com.ziksana.persistence.contacts.ContactMapper;
import com.ziksana.persistence.course.SocializeMapper;
import com.ziksana.service.course.CourseSocializeService;

/**
 * ;
 * 
 * @author bhashasp
 */
public class CourseSocializeServiceImpl implements CourseSocializeService {

	private final static Logger LOGGER = Logger
			.getLogger(CourseSocializeServiceImpl.class);

	@Autowired
	public SocializeMapper socializeMapper;

	/*
	 * @Autowired public ContactMapper contactMapper;
	 */
	@Transactional
	@Override
	public void saveCourseComponetsForReview(
			List<LearningContentReviewProgress> reviewComponentsList)
			throws CourseException {

		if (reviewComponentsList == null) {
			throw new CourseException("Review Components  cannot be null");
		}

		LOGGER.debug("Saving the Course component for Review ... ");

		for (LearningContentReviewProgress learningContentReviewProgress : reviewComponentsList) {
			socializeMapper
					.saveComponentForReview(learningContentReviewProgress);
		}

	}

	@Override
	public void deleteReviewCourseComponent(
			LearningContentReviewProgress reviewComponent)
			throws CourseException {

		Boolean isDelete = true;
		if (reviewComponent == null) {
			throw new CourseException("Review Components cannot be null");
		}

		socializeMapper.deleteReviewComponent(isDelete, reviewComponent);

	}

	@Override
	public List<Member> searchReviewers(SearchReviewerCriteria searchCriteria)
			throws CourseException {

		List<Member> memberList = null;
		MemberPersona memberRole = null;
		RelationshipType circle = null;
		Integer relationshipId = null;

		if (searchCriteria == null) {
			throw new CourseException("Seaatrch Criteri cannot be null");
		}

		// Basic search
		if (searchCriteria.getName() != null) {

			memberList = socializeMapper.basicReviewersSearch(searchCriteria
					.getName());

			return memberList;
		}

		// Advance Search Criteria {firstName, lastName, Circle}
		// TODO: Department filter is waiting for confirmation about relation
		// with Member
		memberList = socializeMapper.advanceReviewersSearch(searchCriteria);

		memberList = new ArrayList<Member>();

		for (Member member : memberList) {
			memberRole = member.getMemberPersona();

			circle = searchCriteria.getCircle();

			if (circle != null) {

				relationshipId = getCircleId(circle);

				memberRole = socializeMapper.getMemberRoleByCircle(
						memberRole.getMemberRoleId(), relationshipId);

				memberRole.setMember(member);
			}

			memberList.add(member);
		}

		return memberList;
	}

	private Integer getCircleId(RelationshipType relationshipType) {

		if (relationshipType.equals(RelationshipType.CIRCLEFIRST)) {
			return Integer.valueOf(1000);
		} else if (relationshipType.equals(RelationshipType.CIRCLESECOND)) {
			return Integer.valueOf(1001);
		} else {
			return Integer.valueOf(1002);
		}

	}

	@Transactional
	@Override
	public void associateReviwers(LearningContentReviewProgress review,
			List<Member> memberList) throws CourseException {
		ContentReviewWorkflow workflow = null;
		WorkflowParticipant participant = null;

		if (review.getReviewProgressId() == null) {
			throw new CourseException("Review cannot be null");
		}

		workflow = review.getContentReviewWorkflow();

		workflow.setContentReviewWorkflowId(Integer.valueOf(review
				.getReviewProgressId().getStorageID()));

		socializeMapper.saveReviewWorkflow(workflow);

		for (Member member : memberList) {

			participant = new WorkflowParticipant();

			participant.setParticipateMemberRole(member.getMemberPersona());

			participant.setCourseWorkflow(workflow);

			socializeMapper.saveWorkflowParticipant(participant);

		}

	}

	@Override
	public void deleteReviewer(WorkflowParticipant workflowParticipant)
			throws CourseException {

		Boolean isDelete = true;
		WorkflowParticipantComment comment = null;
		if (workflowParticipant == null) {
			throw new CourseException("Participant ID cannot null");
		}

		comment = workflowParticipant.getParticipantComment();

		if ((comment.getStatus().equals(WorkflowItemStatus.REVIEW_IN_PROGRESS))
				|| (comment.getStatus()
						.equals(WorkflowItemStatus.OPEN_FOR_REVIEW))) {

			socializeMapper.deleteReviewer(isDelete, new Integer(
					workflowParticipant.getParticipantId().getStorageID()));

		} else {
			throw new CourseException(
					"Cannot delete the Reviewer with review status as Completed/Declineda");
		}

	}

	@Override
	public List<WorkflowParticipant> gerReviewers(ZID contentReviewWorkflowId)
			throws CourseException {

		List<WorkflowParticipant> reviewerParticipantsList = null;

		if (contentReviewWorkflowId == null) {
			throw new CourseException("ContentReviewWorkflow ID cannot be null");
		}

		reviewerParticipantsList = socializeMapper.getReviewerList(new Integer(
				contentReviewWorkflowId.getStorageID()));

		return reviewerParticipantsList;
	}

	@Transactional
	@Override
	public void saveCourseReviewInfo(Course course,
			List<ContentReviewWorkflow> reviewContentList)
			throws CourseException {

		if (reviewContentList == null) {
			throw new CourseException(
					"ContentReviewWorkflow list cannot be null");
		}

		for (ContentReviewWorkflow contentReviewWorkflow : reviewContentList) {

			LOGGER.debug("ContentReviewWorkflow  :"
					+ contentReviewWorkflow.toString());

			if (contentReviewWorkflow.getContentReviewWorkflowId() != null) {

				socializeMapper.updateContentReviewInfo(contentReviewWorkflow);

			}
		}

		if (course.getCourseId() == null) {
			throw new CourseException("Course ID cannot be null");
		}

		course.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
		socializeMapper.createCourse(course);

	}

	@Override
	public void createCourse(Course course) throws CourseException {

		if (course.getCourseId() == null) {
			throw new CourseException("Course ID cannot be null");
		}

		course.setCourseStatus(CourseStatus.REVIEW);

		socializeMapper.createCourse(course);

		// TODO: send the notification to reviewers to review.
	}

}
