package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContentReviewProgress;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public interface CoursePublishService {
	
	/**
	 * @param course
	 * @throws CourseException
	 */
	public void reviewCourse(List<LearningContentReviewProgress> reviewComponentsList,Course course) throws CourseException; 
	/**
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public List<LearningContentReviewProgress> getCourseComponentsToPublish(ZID memberRoleId) throws CourseException;
	
	/**
	 * @param reviewProgressId
	 * @return
	 * @throws CourseException
	 */
	public LearningContentReviewProgress getReviewDetails(ZID reviewProgressId) throws CourseException;
	/**
	 * @param course
	 * @throws CourseException
	 */
	public void deleteCourseReviewComment(Integer  reviewCommentId) throws CourseException;
	/**
	 * @param course
	 * @throws CourseException
	 */
	public void reviewCourseContent(Course  course) throws CourseException;
	/**
	 * @param course
	 * @throws CourseException
	 */
	public void refineCourse(Course  course) throws CourseException;
	/**
	 * @param course
	 * @throws CourseException
	 */
	public void releaseCourse(Course  course) throws CourseException;

}
