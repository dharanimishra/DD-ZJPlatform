package com.ziksana.domain.course;

import java.util.Date;
import java.util.List;

public class LearningComponent {

	/**
	 * This field corresponds property ID
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds property validfrom
	 */
	private Date validFrom;

	/**
	 * This field corresponds property validTo
	 */
	private Date validTo;

	/**
	 * This field corresponds property CourseStatus
	 */
	private Integer courseStatus;

	/**
	 * This field corresponds property Weightage
	 */
	private Integer weightage;

	/**
	 * This field corresponds property TotalCredits
	 */
	private String totalCredits;

	/**
	 * This field corresponds property ExtraCreditsIndicator
	 */
	private Boolean extraCreditsIndicator;

	/**
	 * This field corresponds property learningComponentTypeId
	 */
	private Integer learningComponentTypeId;

	/**
	 * This field corresponds property courseId
	 */
	private Integer courseId;

	/**
	 * This field corresponds property memberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This field corresponds property subjClassificationId
	 */
	private Integer subjClassificationId;

	/**
	 * This field corresponds property ExtraCredits
	 */
	private String extraCredits;

	private List<LearningComponentNest> learningComponentNestList;

	/*
	 * private List<CoursePlaybookView> coursePlaybookViewList;
	 * 
	 * private CourseLearningComponent courseLearningComponent;
	 * 
	 * private List<LearningElementWall> learningElementWallList;
	 */

	/**
	 * The attributes(componentNestId, parentLearningComponentId,
	 * nestLearningComponentId) need to add for tree construction.
	 * Eg: LearningComponetId:100, having a child of another Learningcomponentid:200
	 *  componentNestId : 1      , parentLearningComponentId : null  , nestLearningComponentId : 100
	 *  componentNestId : 2      , parentLearningComponentId : 100  ,  nestLearningComponentId : 200
	 * @param learningComponentNest
	 */
	public void addLearningComponentNest(
			LearningComponentNest learningComponentNest) {

		if (learningComponentNest != null
				&& learningComponentNest.getComponentNestId() != null) {
			learningComponentNestList.add(learningComponentNest);
		}
	}

	/**
	 * Association for the Learning component content. Each LearningComponent
	 * can have association of one - to - many with LearningComponentContent.
	 */
	private List<LearningComponentContent> learningCompContentList;

	/**
	 * Constructor is for constructing the specific attributes.
	 * 
	 * @param learningComponentId
	 * @param learningComponentTypeId
	 */
	public LearningComponent(Integer learningComponentId,
			Integer learningComponentTypeId) {
		this.learningComponentId = learningComponentId;
		this.learningComponentTypeId = learningComponentTypeId;
	}

	/**
	 * @param learningComponent
	 */
	public void addLearningComponentContent(
			LearningComponentContent learningComponentContent) {

		if (learningComponentContent != null
				&& learningComponentContent.getLearningComponentContentId() != null) {

			learningCompContentList.add(learningComponentContent);
		}
	}

	/**
	 * @param learningComponentId
	 */
	public void removeLearningComponentContent(
			Integer learningComponentContentId) {

		for (LearningComponentContent learningComponentContent : learningCompContentList) {

			if (learningComponentContent.getLearningComponentContentId()
					.equals(learningComponentContentId)) {
				learningCompContentList.remove(learningComponentContent);
			}

		}

	}

	/**
	 * This method returns the value of the database column property
	 * learningComponentId
	 * 
	 * @return the value of property learningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column property
	 * learningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for property learningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column property validfrom
	 * 
	 * @return the value of property validfrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * This method sets the value of the database column property validfrom
	 * 
	 * @param validfrom
	 *            the value for property validfrom
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * This method returns the value of the database column property validTo
	 * 
	 * @return the value of property validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * This method sets the value of the database column property validTo
	 * 
	 * @param validTo
	 *            the value for property validTo
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * This method returns the value of the database column property
	 * CourseStatus
	 * 
	 * @return the value of property CourseStatus
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 * This method sets the value of the database column property CourseStatus
	 * 
	 * @param courseStatus
	 *            the value for property CourseStatus
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * This method returns the value of the database column property Weightage
	 * 
	 * @return the value of property Weightage
	 */
	public Integer getWeightage() {
		return weightage;
	}

	/**
	 * This method sets the value of the database column property Weightage
	 * 
	 * @param weightage
	 *            the value for property Weightage
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	/**
	 * This method returns the value of the database column property
	 * TotalCredits
	 * 
	 * @return the value of property TotalCredits
	 */
	public String getTotalCredits() {
		return totalCredits;
	}

	/**
	 * This method sets the value of the database column property TotalCredits
	 * 
	 * @param totalCredits
	 *            the value for property TotalCredits
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits == null ? null : totalCredits.trim();
	}

	/**
	 * This method returns the value of the database column property
	 * ExtraCreditsIndicator
	 * 
	 * @return the value of property ExtraCreditsIndicator
	 */
	public Boolean getExtraCreditsIndicator() {
		return extraCreditsIndicator;
	}

	/**
	 * This method sets the value of the database column property
	 * ExtraCreditsIndicator
	 * 
	 * @param extraCreditsIndicator
	 *            the value for property ExtraCreditsIndicator
	 */
	public void setExtraCreditsIndicator(Boolean extraCreditsIndicator) {
		this.extraCreditsIndicator = extraCreditsIndicator;
	}

	/**
	 * This method returns the value of the database column property
	 * ExtraCredits
	 * 
	 * @return the value of property ExtraCredits
	 */
	public String getExtraCredits() {
		return extraCredits;
	}

	/**
	 * This method sets the value of the database column property ExtraCredits
	 * 
	 * @param extraCredits
	 *            the value for property ExtraCredits
	 */
	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits == null ? null : extraCredits.trim();
	}

	/**
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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
	 * @return the learningComponentTypeId
	 */
	public Integer getLearningComponentTypeId() {
		return learningComponentTypeId;
	}

	/**
	 * @param learningComponentTypeId
	 *            the learningComponentTypeId to set
	 */
	public void setLearningComponentTypeId(Integer learningComponentTypeId) {
		this.learningComponentTypeId = learningComponentTypeId;
	}

	/**
	 * @return the learningComponentNestList
	 */
	public List<LearningComponentNest> getLearningComponentNestList() {
		return learningComponentNestList;
	}

	/**
	 * @param learningComponentNestList
	 *            the learningComponentNestList to set
	 */
	public void addLearningComponentNestList(
			List<LearningComponentNest> learningComponentNestList) {
		this.learningComponentNestList = learningComponentNestList;
	}

	/*	*//**
	 * @return the coursePlaybookViewList
	 */
	/*
	 * public List<CoursePlaybookView> getCoursePlaybookViewList() { return
	 * coursePlaybookViewList; }
	 */
	/*
	*//**
	 * @param coursePlaybookViewList
	 *            the coursePlaybookViewList to set
	 */
	/*
	 * public void addCoursePlaybookViewList( List<CoursePlaybookView>
	 * coursePlaybookViewList) { this.coursePlaybookViewList =
	 * coursePlaybookViewList; }
	 *//**
	 * @return the courseLearningComponent
	 */
	/*
	 * public CourseLearningComponent getCourseLearningComponent() { return
	 * courseLearningComponent; }
	 *//**
	 * @param courseLearningComponent
	 *            the courseLearningComponent to set
	 */
	/*
	 * public void addCourseLearningComponent( CourseLearningComponent
	 * courseLearningComponent) { this.courseLearningComponent =
	 * courseLearningComponent; }
	 */
	/**
	 * @return the learningCompContentList
	 */
	public List<LearningComponentContent> getLearningCompContentList() {
		return learningCompContentList;
	}

	/**
	 * @param learningCompContentList
	 *            the learningCompContentList to set
	 */
	public void addLearningCompContentList(
			List<LearningComponentContent> learningCompContentList) {
		this.learningCompContentList = learningCompContentList;
	}

	/*	*//**
	 * @return the learningElementWallList
	 */
	/*
	 * public List<LearningElementWall> getLearningElementWallList() { return
	 * learningElementWallList; }
	 *//**
	 * @param learningElementWallList
	 *            the learningElementWallList to set
	 */
	/*
	 * public void addLearningElementWallList( List<LearningElementWall>
	 * learningElementWallList) { this.learningElementWallList =
	 * learningElementWallList; }
	 */
}