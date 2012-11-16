package com.ziksana.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.LearningContentReviewProgress;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CourseLearningComponentMapper;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.persistence.course.CoursePublishMapper;
import com.ziksana.persistence.course.LearningComponentContentMapper;
import com.ziksana.persistence.course.LearningComponentMapper;
import com.ziksana.service.course.CoursePublishService;
import com.ziksana.service.course.CourseSocializeService;

/**
 * @author bhashasp
 */
public class CoursePublishServiceImpl  implements CoursePublishService{
	
	@Autowired
	public CourseMapper 					courseMapper;
	@Autowired
	public LearningComponentMapper 			learningComponentMapper;
	@Autowired
	public CourseLearningComponentMapper 	courseLComponentMapper;
	@Autowired
	public LearningComponentContentMapper 	learningComponentContentMapper;
	@Autowired
	public CourseSocializeService			courseService;
	
	public CoursePublishMapper				publishMapper;
	

	@Override
	public void reviewCourse(List<LearningContentReviewProgress> reviewComponentsList, Course course) throws CourseException {
		
		if(course == null){
			throw new CourseException("Course/LearningObject/Content Cannot be null");
		}

		courseService.saveCourseComponetsForReview(reviewComponentsList);

		if(course != null){
			
			course.setCourseStatus(CourseStatus.REVIEW);
			
			courseMapper.saveReviewCourse(course);
			
		}
	}

	@Override
	public List<LearningContentReviewProgress> getCourseComponentsToPublish(ZID memberRoleId)
			throws CourseException {
		
		List<LearningContentReviewProgress> reviewList = null; 
		
		if(memberRoleId == null){
			throw new CourseException("Member RoleID cannot be null");
		}
		
		reviewList = publishMapper.getReviewComponentsByMemberRoleId(new Integer(memberRoleId.getStorageID()));
		
		return reviewList;
	}

	@Override
	public void deleteCourseReviewComment(Integer  reviewCommentId) throws CourseException {
		
		Boolean isDelete = true;
		if(reviewCommentId == null){
			throw new CourseException("Review CommentID cannot be null");
		}
		
		publishMapper.deleteReviewComment(isDelete, reviewCommentId);
		
		
	}

	@Override
	public void reviewCourseContent(Course course) throws CourseException {
		
		
	}

	@Override
	public void refineCourse(Course course) throws CourseException {
		
		
	}

	@Override
	public void releaseCourse(Course course) throws CourseException {
		
		
	}

	@Override
	public LearningContentReviewProgress getReviewDetails(ZID reviewProgressId)
			throws CourseException {
		
		LearningContentReviewProgress reviewItem = null;
		
		if(reviewProgressId == null){
			throw new CourseException("LearningContentReviewProgressID Cannot be null");
		}
		
		reviewItem = publishMapper.getReviewContentDetails(new Integer(reviewProgressId.getStorageID()));
		
		return reviewItem;
	}

}
