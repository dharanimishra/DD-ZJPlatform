package com.ziksana.service.course;

import java.util.Map;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CoursePlaybook;
import com.ziksana.domain.course.CoursePlaybookView;
import com.ziksana.domain.course.PlaybookComponent;
import com.ziksana.domain.course.PlaybookType;
import com.ziksana.domain.course.ProgramCurriculumPlaybook;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;

/**
 * @bhasshasp
 * 
 */
public interface CoursePlaybookService {
	 
	/**
	 * Gets the Default Course Playbook for Member.
	 * 
	 * @param progNameType
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public CoursePlaybook getDefaultCoursePlaybook(Member member)
			throws CourseException;

	/**
	 * Gets the Default Learning Program Playbook for Member.
	 * 
	 * @param progNameType
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public ProgramCurriculumPlaybook getDefaultLearningLProgramPlaybook(
			Member member) throws CourseException;

	/**
	 * PlaybookNameType: Enum holds the
	 * DefaultCoursePlaybook,DefaultLearningProgramPlaybook, CoursePlaybook,
	 * Course Playbook, LearningObject Playbook Types. <br>
	 * PlaybookComponent :
	 * Generic domain holds the getter and setter methods of CoursePlaybook
	 * List, LearningObjectPlaybook List, LearningProgram PlaybookList
	 * 
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public Map<PlaybookType, PlaybookComponent> getPlaybookList(Member member)
			throws CourseException;

	/**
	 * @param member
	 * @param course
	 * @param coursePB
	 * @param coursePBView
	 * @return
	 * @throws CourseException
	 */
	public CoursePlaybook  createNewPlaybook(Member member, Course course, CoursePlaybook coursePB,CoursePlaybookView coursePBView) throws CourseException;
	
	/**
	 * @param coursePB
	 * @param coursePBView
	 * @throws CourseException
	 */
	public void updateCoursePlaybook(CoursePlaybook coursePB,CoursePlaybookView coursePBView) throws CourseException;
	
	/**
	 * @param coursePB
	 * @param coursePBView
	 * @throws CourseException
	 */
	public void deleteCoursePlaybook(CoursePlaybook coursePB) throws CourseException;
	
	/**
	 * @param coursePB
	 * @throws CourseException
	 */
	public void previewPlaybook(CoursePlaybook coursePB) throws CourseException;

	/**
	 * @param coursePB
	 * @throws CourseException
	 */
	public CoursePlaybook  getPlaybook(CoursePlaybook coursePB) throws CourseException;
	
	/**
	 * @param coursePB
	 * @throws CourseException
	 */
	public void  generatePlaybook(CoursePlaybook coursePB) throws CourseException;}
