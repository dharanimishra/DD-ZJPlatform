package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Course;

import com.ziksana.domain.course.SearchReviewerCriteria;

import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public interface CourseSocializeService {

	/**
	 * @param reviewComponentsList
	 * @throws CourseException
	 */
//	public void saveCourseComponetsForReview(
//			List<LearningContentReviewProgress> reviewComponentsList)
//			throws CourseException;
//
//	/**
//	 * @param reviewComponent
//	 * @throws CourseException
//	 */
//	public void deleteReviewCourseComponent(
//			LearningContentReviewProgress reviewComponent)
//			throws CourseException;
//
//	/**
//	 * @param searchCriteria
//	 * @return
//	 * @throws CourseException
//	 */
//	public List<Member> searchReviewers(SearchReviewerCriteria searchCriteria)
//			throws CourseException;
//
//	/**
//	 * @param review
//	 * @param memberList
//	 * @throws CourseException
//	 */
//	public void associateReviwers(LearningContentReviewProgress review,
//			List<Member> memberList) throws CourseException;
//
//	/**
//	 * @param workflowParticipantId
//	 * @throws CourseException
//	 */
//	public void deleteReviewer(WorkflowParticipant workflowParticipant)
//			throws CourseException;
//
//	/**
//	 * @param contentReviewWorkflowId
//	 * @return
//	 * @throws CourseException
//	 */
//	public List<WorkflowParticipant> gerReviewers(ZID contentReviewWorkflowId)
//			throws CourseException;
//
//	/**
//	 * Saves Notes, completeBy and Rate information.
//	 * 
//	 * @param reviewContent
//	 * @throws CourseException
//	 */
//	public void saveCourseReviewInfo(Course course,
//			List<ContentReviewWorkflow> reviewContent) throws CourseException;

	/**
	 * Creates the course and updates the course status is Review
	 * 
	 * @param course
	 * @throws CourseException
	 */
	public void createCourse(Course course) throws CourseException;

}
