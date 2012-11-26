package com.ziksana.domain.member.collaboration;

import java.util.Date;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.institution.CurriculumCourse;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class GroupContext {
	
	private ZID 				contextId;
	private Date 				creationDate 		= null;
	private Date 				closedDate 			= null;
	private LearningComponent 	learningComponent 	= null;
	private Course 				course 				= null;
	private CurriculumCourse 	curriculumCourse 	= null;
	
	/**
	 * @return the contextId
	 */
	public ZID getContextId() {
		return contextId;
	}
	/**
	 * @param contextId the contextId to set
	 */
	public void setContextId(Integer contextId) {
		this.contextId = new IntegerZID(contextId);
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the closedDate
	 */
	public Date getClosedDate() {
		return closedDate;
	}
	/**
	 * @param closedDate the closedDate to set
	 */
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}
	/**
	 * @return the learningComponent
	 */
	public LearningComponent getLearningComponent() {
		return learningComponent;
	}
	/**
	 * @param learningComponent the learningComponent to set
	 */
	public void setLearningComponent(LearningComponent learningComponent) {
		this.learningComponent = learningComponent;
	}
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
	/**
	 * @return the curriculumCourse
	 */
	public CurriculumCourse getCurriculumCourse() {
		return curriculumCourse;
	}
	/**
	 * @param curriculumCourse the curriculumCourse to set
	 */
	public void setCurriculumCourse(CurriculumCourse curriculumCourse) {
		this.curriculumCourse = curriculumCourse;
	}
			

}
