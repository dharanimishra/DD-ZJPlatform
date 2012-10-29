package com.ziksana.service.course;

import java.util.List;
import java.util.Map;

import com.ziksana.domain.course.CoursePlaybook;
import com.ziksana.domain.course.CoursePlaybookView;
import com.ziksana.domain.course.PlaybookComponent;
import com.ziksana.domain.course.PlaybookType;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;

/**
 * @bhasshasp
 * 
 */
public interface PlaybookService {
	 
	/**
	 * Gets the Default Course Playbook for Member.
	 * 
	 * @param playbook
	 * @return
	 * @throws CourseException
	 */
	public CoursePlaybook getCoursePlaybook(CoursePlaybook playbook)
			throws CourseException;

	/**
	 * PlaybookNameType: Enum holds the
	 * DefaultCoursePlaybook,DefaultLearningProgramPlaybook, CoursePlaybook,
	 * Course Playbook, LearningObject Playbook Types. <br>
	 * PlaybookComponent :
	 * Generic domain holds the getter and setter methods of CoursePlaybook
	 * List, LearningObjectPlaybook List, LearningProgram PlaybookList
	 * 
	 * @param courseId
	 * @return
	 * @throws CourseException
	 */
	public Map<PlaybookType, PlaybookComponent> getPlaybookList(ZID courseId)
			throws CourseException;

	/**
	 * Retrieves the playbook components for course and learning component
	 * @param courseId
	 * @return
	 * @throws CourseException
	 */
	public List<CoursePlaybook> getCoursePlaybookList(ZID courseId)	throws CourseException;
			
	/**
	 * @param member
	 * @param course
	 * @param coursePB
	 * @param coursePBView
	 * @return
	 * @throws CourseException
	 */
	public void  createNewCoursePlaybook(CoursePlaybook coursePB,CoursePlaybookView coursePBView) throws CourseException;
	
	/**
	 * @param coursePB
	 * @param coursePBView
	 * @throws CourseException
	 */
	public void updateCoursePlaybook(CoursePlaybook coursePB) throws CourseException;
	
	/**
	 * @param coursePB
	 * @param coursePBView
	 * @throws CourseException
	 */
	public void deleteCoursePlaybook(ZID coursePBId) throws CourseException;
	
	/**
	 * @param coursePB
	 * @throws CourseException
	 */
	public void previewPlaybook(CoursePlaybook coursePB) throws CourseException;

	/**
	 * Creates the Default playbook for all course components.
	 * @param coursePB
	 * @throws CourseException
	 */
	public void  generatePlaybook(CoursePlaybook coursePB) throws CourseException;
	

	/**
	 * Saves the generated defaultPlaybook(course and its components).
	 * @param course
	 * @throws CourseException
	 */
	public void createDefaultPlaybook(CoursePlaybook coursePlaybook)  throws CourseException;
}
