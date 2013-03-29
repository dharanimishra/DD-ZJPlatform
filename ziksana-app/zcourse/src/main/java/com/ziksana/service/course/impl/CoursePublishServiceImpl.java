package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.ContentReviewRating;
import com.ziksana.domain.course.ContentReviewWorkflow;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.LearningContentReviewProgress;
import com.ziksana.domain.course.ParticipantType;
import com.ziksana.domain.course.WorkflowItemStatus;
import com.ziksana.domain.course.WorkflowParticipant;
import com.ziksana.domain.course.WorkflowParticipantComment;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CourseLearningComponentMapper;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.persistence.course.CoursePublishMapper;
import com.ziksana.persistence.course.LearningComponentContentMapper;
import com.ziksana.persistence.course.LearningComponentMapper;
import com.ziksana.persistence.course.SocializeMapper;
import com.ziksana.service.course.CoursePublishService;
import com.ziksana.service.course.CourseSocializeService;

/**
 * @author bhashasp
 */

public class CoursePublishServiceImpl implements CoursePublishService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CoursePublishServiceImpl.class);

	@Autowired
	public CourseMapper courseMapper;
	@Autowired
	public LearningComponentMapper learningComponentMapper;
	@Autowired
	public CourseLearningComponentMapper courseLComponentMapper;
	@Autowired
	public LearningComponentContentMapper learningComponentContentMapper;
	@Autowired
	public CourseSocializeService courseService;
	@Autowired
	public CoursePublishMapper publishMapper;
	@Autowired
	public SocializeMapper socializeMapper;

	@Transactional
	@Override
	public void reviewCourse(
			List<LearningContentReviewProgress> reviewComponentsList,
			Course course) throws CourseException {

		courseService.saveCourseComponetsForReview(reviewComponentsList);

		if (course != null) {

			course.setCourseStatus(CourseStatus.REVIEW);

			courseMapper.saveReviewCourse(course);

		}
	}

	@Override
	public List<LearningContentReviewProgress> getCourseComponentsToPublish(
			ZID memberRoleId) throws CourseException {

		List<LearningContentReviewProgress> reviewList = null;

		reviewList = publishMapper
				.getReviewComponentsByMemberRoleId(new Integer(memberRoleId
						.getStorageID()));

		return reviewList;
	}

	@Override
	public void deleteCourseReviewComment(Integer reviewCommentId)
			throws CourseException {

		Boolean isDelete = true;

		publishMapper.deleteReviewComment(isDelete, reviewCommentId);

	}

	@Override
	public void reviewCourseContent(Course course) throws CourseException {

		if (course != null) {

			course.setCourseStatus(CourseStatus.REVIEW);

			courseMapper.saveReviewCourse(course);

		}

	}

	@Override
	public void refineCourse(Course course) throws CourseException {

		if (course != null) {

			course.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);

			courseMapper.saveReviewCourse(course);

		}

	}

	@Override
	public void releaseCourse(Course course) throws CourseException {

		if (course != null) {

			course.setCourseStatus(CourseStatus.RELEASE);

			courseMapper.saveReviewCourse(course);

		}

	}

	@Override
	public LearningContentReviewProgress getReviewDetails(ZID reviewProgressId)
			throws CourseException {

		LearningContentReviewProgress reviewItem = null;

		reviewItem = publishMapper.getReviewContentDetails(new Integer(
				reviewProgressId.getStorageID()));

		return reviewItem;
	}

	@Override
	public ContentReviewWorkflow getWorkflowDetails(Integer reviewProgressId)
			throws CourseException {

		ContentReviewWorkflow workflow = null;

		workflow = publishMapper.getWorkflow(reviewProgressId);

		LOGGER.debug("Workflow details : " + workflow.toString());

		return workflow;
	}

	@Transactional
	@Override
	public void addContentReviewComment(MemberPersona memberRole,
			ContentReviewWorkflow workflow, WorkflowParticipantComment comment)
			throws CourseException {

		if (memberRole.getMemberRoleId() == null) {
			throw new CourseException("Member Role ID cannot be null");
		}

		LOGGER.debug(" Member Role ID " + memberRole.getMemberRoleId());

		socializeMapper.saveReviewWorkflow(workflow);

		if (workflow.getContentReviewWorkflowId() != null) {

			WorkflowParticipant newParticipant = new WorkflowParticipant();
			newParticipant.setParticipateMemberRole(memberRole);
			newParticipant.setParticipantType(ParticipantType.PEER_REVIEWER);
			newParticipant.setCourseWorkflow(workflow);

			socializeMapper.saveWorkflowParticipant(newParticipant);

			if (newParticipant.getParticipantId() != null) {

				comment.setParticipant(newParticipant);
				comment.setStatus(WorkflowItemStatus.OPEN_FOR_REVIEW);

				publishMapper.saveWorkflowComment(comment);

			}

		}

	}

	@Override
	public ContentReviewRating getReviewRating(Integer memberRoleId,
			Integer reviewProgressId) throws CourseException {

		ContentReviewRating reviewRating = null;

		if (memberRoleId == null) {
			throw new CourseException("Member Role ID cannot be null");
		}

		publishMapper.getContentReviewRating(reviewProgressId);

		publishMapper.getAuthorReviewRating(memberRoleId);

		// TODO need to add business logic here for review rating

		return reviewRating;
	}

}
