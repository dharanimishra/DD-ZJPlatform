package com.ziksana.domain.course;

import java.util.List;

public class Course  {

	/**
	 * This field corresponds to the property courseId
	 */
	private Integer courseId;

	/**
	 * This field corresponds to the property Name
	 */
	private String name;

	/**
	 * This field corresponds to the property CourseIdentifier
	 */
	private String courseIdentifier;
	
	/**
	 * This field corresponds to the property Description
	 */
	private String description;

	/**
	 * This field corresponds to the property subjClassificationId
	 */
	private Integer subjClassificationId;
	
	/**
	 * This field corresponds to the property memberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This field corresponds to the details about the Course
	 */
	private CourseDetails courseDetails;

	/**
	 * association with the Learning Component,
	 * Course contains the one or more Learning Components.
	 */
	private List<LearningComponent> learningComponents;

	/**
	 * @param learningComponent
	 */
	public void addLearningComponent(LearningComponent learningComponent) {

		if (learningComponent != null
				&& learningComponent.getLearningComponentId() != null) {
			learningComponents.add(learningComponent);
		}
	}

	/**
	 * @param learningComponentId
	 */
	public void removeLearningComponent(Integer learningComponentId) {

		for (LearningComponent learningComponent : learningComponents) {

			if (learningComponent.getLearningComponentId().equals(
					learningComponentId)) {
				learningComponents.remove(learningComponent);
			}

		}

	}

	// private List<CourseLearningComponent> courseLearningComponents;


	/**
	 * This field corresponds to the property Version
	 */
	private Integer version;

	/**
	 * This method returns the value of the property Name
	 * 
	 * @return the value of corcourse.Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the value of the property Name
	 * 
	 * @param name
	 *            the value for corcourse.Name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourse.CourseIdentifier
	 * 
	 * @return the value of corcourse.CourseIdentifier
	 */
	public String getCourseIdentifier() {
		return courseIdentifier;
	}

	/**
	 * This method sets the value of the database column
	 * corcourse.CourseIdentifier
	 * 
	 * @param courseIdentifier
	 *            the value for corcourse.CourseIdentifier
	 */
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier == null ? null
				: courseIdentifier.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourse.Description
	 * 
	 * @return the value of corcourse.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the property Description
	 * 
	 * @param description
	 *            the value for corcourse.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the property Version
	 * 
	 * @return the value of corcourse.Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the property Version
	 * 
	 * @param version
	 *            the value for corcourse.Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the subjClassificationId
	 */
	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	/**
	 * @param subjClassificationId
	 *            the subjClassificationId to set
	 */
	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	/**
	 * @return the memberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * @param memberRoleId
	 *            the memberRoleId to set
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * This method returns the value of the property courseId
	 * 
	 * @return the value of corcourse.courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the property courseId
	 * 
	 * @param courseId
	 *            the value for corcourse.courseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/*
	 * public List<CourseLearningComponent> getCourseLearningComponents() {
	 * return courseLearningComponents; }
	 * 
	 * public void addCourseLearningComponents( List<CourseLearningComponent>
	 * courseLearningComponents) { this.courseLearningComponents =
	 * courseLearningComponents; }
	 */
	/**
	 * @return the learningComponents
	 */
	public List<LearningComponent> getLearningComponents() {
		return learningComponents;
	}

	/**
	 * @param learningComponents
	 *            the learningComponents to set
	 */
	public void addLearningComponents(List<LearningComponent> learningComponents) {
		this.learningComponents = learningComponents;
	}

	/**
	 * @return the courseDetails
	 */
	public CourseDetails getCourseDetails() {
		return courseDetails;
	}

	/**
	 * @param courseDetails the courseDetails to set
	 */
	public void setCourseDetails(CourseDetails courseDetails) {
		this.courseDetails = courseDetails;
	}

}