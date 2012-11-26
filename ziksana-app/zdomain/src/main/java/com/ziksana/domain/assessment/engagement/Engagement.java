package com.ziksana.domain.assessment.engagement;

import java.util.Date;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.institution.CurriculumCourse;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class Engagement {
	
	public Engagement(EngagementMode engagementMode, Boolean isHierarchy) {
		super();
		this.engagementMode = engagementMode;
		this.isHierarchy = isHierarchy;
	}
	
	private ZID 						engagementId;
	private Date 						createDate 					= null;
	private EngagementMode 				engagementMode 				= null;
	private Boolean 					isHierarchy					= null;
	private CurriculumCourse 			curriculumCourse 			= null;
	private EngagementCriteria 			engagementCriteria 			= null;
	private Course 						course 						= null;
	private CourseLearningComponent 	courseLearningComponent 	= null;
	
	
	/**
	 * @return the engagementId
	 */
	public ZID getEngagementId() {
		return engagementId;
	}
	/**
	 * @param engagementId the engagementId to set
	 */
	public void setEngagementId(Integer engagementId) {
		this.engagementId = new IntegerZID(engagementId);
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the engagementMode
	 */
	public EngagementMode getEngagementMode() {
		return engagementMode;
	}
	/**
	 * @param engagementMode the engagementMode to set
	 */
	public void setEngagementMode(EngagementMode engagementMode) {
		this.engagementMode = engagementMode;
	}
	/**
	 * @return the isHierarchy
	 */
	public Boolean getIsHierarchy() {
		return isHierarchy;
	}
	/**
	 * @param isHierarchy the isHierarchy to set
	 */
	public void setIsHierarchy(Boolean isHierarchy) {
		this.isHierarchy = isHierarchy;
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
	/**
	 * @return the engagementCriteriaId
	 */
	public EngagementCriteria getEngagementCriteria() {
		return engagementCriteria;
	}
	/**
	 * @param engagementCriteriaId the engagementCriteriaId to set
	 */
	public void setEngagementCriteria(EngagementCriteria engagementCriteria) {
		this.engagementCriteria = engagementCriteria;
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
	 * @return the courseLearningComponent
	 */
	public CourseLearningComponent getCourseLearningComponent() {
		return courseLearningComponent;
	}
	/**
	 * @param courseLearningComponent the courseLearningComponent to set
	 */
	public void setCourseLearningComponent(
			CourseLearningComponent courseLearningComponent) {
		this.courseLearningComponent = courseLearningComponent;
	}

	@Override
	public String toString() {
		return "Engagement [createDate=" + createDate + ", engagementMode="
				+ engagementMode + ", isHierarchy=" + isHierarchy + "]";
	}

}
