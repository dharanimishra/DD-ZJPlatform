package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class CurriculumCourse implements Serializable {

	/**
	 */
	private static final long serialVersionUID = -7729244753807278238L;
	/**
	 * This field corresponds to the database column corcurriculumcourse.curriculumCourseId
	 */
	private Integer curriculumCourseId;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.CreationDate
	 */
	private Date creationDate;
	/**
	 * This field corresponds to the database column corcurriculumcourse.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.CurriculumUseType
	 */
	private Integer curriculumUseType;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.CurriculumCourseIdentifier
	 */
	private String curriculumCourseIdentifier;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.CourseVersionUsed
	 */
	private Integer courseVersionUsed;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.CourseWeightage
	 */
	private Integer courseWeightage;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.GradeType
	 */
	private Integer gradeType;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.CourseCredit
	 */
	private Integer courseCredit;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.ZiksanaOnlyIndicator
	 */
	private Boolean ziksanaOnlyIndicator;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.ClassroomIndicator
	 */
	private Boolean classroomIndicator;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.CombinedIndicator
	 */
	private Boolean combinedIndicator;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.NoSyncConstraintIndicator
	 */
	private Boolean noSyncConstraintIndicator;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.SyncAfterClass
	 */
	private Integer syncAfterClass;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.SyncBeforeClass
	 */
	private Integer syncBeforeClass;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.ValidFrom
	 */
	private Date validFrom;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.validTo
	 */
	private Date validTo;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.OverallLearnerRating
	 */
	private Integer overallLearnerRating;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.OverallPeerRating
	 */
	private Integer overallPeerRating;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.ContentSecurityNeededIndicator
	 */
	private Boolean contentSecurityNeededIndicator;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.TotalCredits
	 */
	private String totalCredits;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.ExtraCredits
	 */
	private String extraCredits;

	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.courseLevelOveriddenIndicator
	 */
	private boolean courseLevelOveriddenIndicator;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.ProgramCurriculumId
	 */
	private Integer programCurriculumId;
	/**
	 * This field corresponds to the database column
	 * corcurriculumcourse.CourseId
	 */
	private Integer courseId;

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.curriculumCourseId
	 * 
	 * @return the value of corcurriculumcourse.curriculumCourseId
	 */
	public Integer getCurriculumCourseId() {
		return curriculumCourseId;
	}

	/**
	 * This method sets the value of the database column corcurriculumcourse.curriculumCourseId
	 * 
	 * @param curriculumCourseId
	 *            the value for corcurriculumcourse.curriculumCourseId
	 */
	public void setCurriculumCourseId(Integer curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.CreationDate
	 * 
	 * @return the value of corcurriculumcourse.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corcurriculumcourse.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.Active
	 * 
	 * @return the value of corcurriculumcourse.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.Active
	 * 
	 * @param active
	 *            the value for corcurriculumcourse.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.CurriculumUseType
	 * 
	 * @return the value of corcurriculumcourse.CurriculumUseType
	 */
	public Integer getCurriculumUseType() {
		return curriculumUseType;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.CurriculumUseType
	 * 
	 * @param curriculumUseType
	 *            the value for corcurriculumcourse.CurriculumUseType
	 */
	public void setCurriculumUseType(Integer curriculumUseType) {
		this.curriculumUseType = curriculumUseType;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.CurriculumCourseIdentifier
	 * 
	 * @return the value of corcurriculumcourse.CurriculumCourseIdentifier
	 */
	public String getCurriculumCourseIdentifier() {
		return curriculumCourseIdentifier;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.CurriculumCourseIdentifier
	 * 
	 * @param curriculumCourseIdentifier
	 *            the value for corcurriculumcourse.CurriculumCourseIdentifier
	 */
	public void setCurriculumCourseIdentifier(String curriculumCourseIdentifier) {
		this.curriculumCourseIdentifier = curriculumCourseIdentifier == null ? null
				: curriculumCourseIdentifier.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.CourseVersionUsed
	 * 
	 * @return the value of corcurriculumcourse.CourseVersionUsed
	 */
	public Integer getCourseVersionUsed() {
		return courseVersionUsed;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.CourseVersionUsed
	 * 
	 * @param courseVersionUsed
	 *            the value for corcurriculumcourse.CourseVersionUsed
	 */
	public void setCourseVersionUsed(Integer courseVersionUsed) {
		this.courseVersionUsed = courseVersionUsed;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.CourseWeightage
	 * 
	 * @return the value of corcurriculumcourse.CourseWeightage
	 */
	public Integer getCourseWeightage() {
		return courseWeightage;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.CourseWeightage
	 * 
	 * @param courseWeightage
	 *            the value for corcurriculumcourse.CourseWeightage
	 */
	public void setCourseWeightage(Integer courseWeightage) {
		this.courseWeightage = courseWeightage;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.GradeType
	 * 
	 * @return the value of corcurriculumcourse.GradeType
	 */
	public Integer getGradeType() {
		return gradeType;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.GradeType
	 * 
	 * @param gradeType
	 *            the value for corcurriculumcourse.GradeType
	 */
	public void setGradeType(Integer gradeType) {
		this.gradeType = gradeType;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.CourseCredit
	 * 
	 * @return the value of corcurriculumcourse.CourseCredit
	 */
	public Integer getCourseCredit() {
		return courseCredit;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.CourseCredit
	 * 
	 * @param courseCredit
	 *            the value for corcurriculumcourse.CourseCredit
	 */
	public void setCourseCredit(Integer courseCredit) {
		this.courseCredit = courseCredit;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.ZiksanaOnlyIndicator
	 * 
	 * @return the value of corcurriculumcourse.ZiksanaOnlyIndicator
	 */
	public Boolean getZiksanaOnlyIndicator() {
		return ziksanaOnlyIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.ZiksanaOnlyIndicator
	 * 
	 * @param ziksanaOnlyIndicator
	 *            the value for corcurriculumcourse.ZiksanaOnlyIndicator
	 */
	public void setZiksanaOnlyIndicator(Boolean ziksanaOnlyIndicator) {
		this.ziksanaOnlyIndicator = ziksanaOnlyIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.ClassroomIndicator
	 * 
	 * @return the value of corcurriculumcourse.ClassroomIndicator
	 */
	public Boolean getClassroomIndicator() {
		return classroomIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.ClassroomIndicator
	 * 
	 * @param classroomIndicator
	 *            the value for corcurriculumcourse.ClassroomIndicator
	 */
	public void setClassroomIndicator(Boolean classroomIndicator) {
		this.classroomIndicator = classroomIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.CombinedIndicator
	 * 
	 * @return the value of corcurriculumcourse.CombinedIndicator
	 */
	public Boolean getCombinedIndicator() {
		return combinedIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.CombinedIndicator
	 * 
	 * @param combinedIndicator
	 *            the value for corcurriculumcourse.CombinedIndicator
	 */
	public void setCombinedIndicator(Boolean combinedIndicator) {
		this.combinedIndicator = combinedIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.NoSyncConstraintIndicator
	 * 
	 * @return the value of corcurriculumcourse.NoSyncConstraintIndicator
	 */
	public Boolean getNoSyncConstraintIndicator() {
		return noSyncConstraintIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.NoSyncConstraintIndicator
	 * 
	 * @param noSyncConstraintIndicator
	 *            the value for corcurriculumcourse.NoSyncConstraintIndicator
	 */
	public void setNoSyncConstraintIndicator(Boolean noSyncConstraintIndicator) {
		this.noSyncConstraintIndicator = noSyncConstraintIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.SyncAfterClass
	 * 
	 * @return the value of corcurriculumcourse.SyncAfterClass
	 */
	public Integer getSyncAfterClass() {
		return syncAfterClass;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.SyncAfterClass
	 * 
	 * @param syncAfterClass
	 *            the value for corcurriculumcourse.SyncAfterClass
	 */
	public void setSyncAfterClass(Integer syncAfterClass) {
		this.syncAfterClass = syncAfterClass;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.SyncBeforeClass
	 * 
	 * @return the value of corcurriculumcourse.SyncBeforeClass
	 */
	public Integer getSyncBeforeClass() {
		return syncBeforeClass;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.SyncBeforeClass
	 * 
	 * @param syncBeforeClass
	 *            the value for corcurriculumcourse.SyncBeforeClass
	 */
	public void setSyncBeforeClass(Integer syncBeforeClass) {
		this.syncBeforeClass = syncBeforeClass;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.ValidFrom
	 * 
	 * @return the value of corcurriculumcourse.ValidFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.ValidFrom
	 * 
	 * @param ValidFrom
	 *            the value for corcurriculumcourse.ValidFrom
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.validTo
	 * 
	 * @return the value of corcurriculumcourse.validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.validTo
	 * 
	 * @param validTo
	 *            the value for corcurriculumcourse.validTo
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.OverallLearnerRating
	 * 
	 * @return the value of corcurriculumcourse.OverallLearnerRating
	 */
	public Integer getOverallLearnerRating() {
		return overallLearnerRating;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.OverallLearnerRating
	 * 
	 * @param overallLearnerRating
	 *            the value for corcurriculumcourse.OverallLearnerRating
	 */
	public void setOverallLearnerRating(Integer overallLearnerRating) {
		this.overallLearnerRating = overallLearnerRating;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.OverallPeerRating
	 * 
	 * @return the value of corcurriculumcourse.OverallPeerRating
	 */
	public Integer getOverallPeerRating() {
		return overallPeerRating;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.OverallPeerRating
	 * 
	 * @param overallPeerRating
	 *            the value for corcurriculumcourse.OverallPeerRating
	 */
	public void setOverallPeerRating(Integer overallPeerRating) {
		this.overallPeerRating = overallPeerRating;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.ContentSecurityNeededIndicator
	 * 
	 * @return the value of corcurriculumcourse.ContentSecurityNeededIndicator
	 */
	public Boolean getContentSecurityNeededIndicator() {
		return contentSecurityNeededIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.ContentSecurityNeededIndicator
	 * 
	 * @param contentSecurityNeededIndicator
	 *            the value for
	 *            corcurriculumcourse.ContentSecurityNeededIndicator
	 */
	public void setContentSecurityNeededIndicator(
			Boolean contentSecurityNeededIndicator) {
		this.contentSecurityNeededIndicator = contentSecurityNeededIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.TotalCredits
	 * 
	 * @return the value of corcurriculumcourse.TotalCredits
	 */
	public String getTotalCredits() {
		return totalCredits;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.TotalCredits
	 * 
	 * @param totalCredits
	 *            the value for corcurriculumcourse.TotalCredits
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits == null ? null : totalCredits.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.ExtraCredits
	 * 
	 * @return the value of corcurriculumcourse.ExtraCredits
	 */
	public String getExtraCredits() {
		return extraCredits;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.ExtraCredits
	 * 
	 * @param extraCredits
	 *            the value for corcurriculumcourse.ExtraCredits
	 */
	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits == null ? null : extraCredits.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.ProgramCurriculumId
	 * 
	 * @return the value of corcurriculumcourse.ProgramCurriculumId
	 */
	public Integer getProgramCurriculumId() {
		return programCurriculumId;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.ProgramCurriculumId
	 * 
	 * @param programCurriculumId
	 *            the value for corcurriculumcourse.ProgramCurriculumId
	 */
	public void setProgramCurriculumId(Integer programCurriculumId) {
		this.programCurriculumId = programCurriculumId;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumcourse.CourseId
	 * 
	 * @return the value of corcurriculumcourse.CourseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumcourse.CourseId
	 * 
	 * @param courseId
	 *            the value for corcurriculumcourse.CourseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseLevelOveriddenIndicator
	 */
	public boolean isCourseLevelOveriddenIndicator() {
		return courseLevelOveriddenIndicator;
	}

	/**
	 * @param courseLevelOveriddenIndicator
	 *            the courseLevelOveriddenIndicator to set
	 */
	public void setCourseLevelOveriddenIndicator(
			boolean courseLevelOveriddenIndicator) {
		this.courseLevelOveriddenIndicator = courseLevelOveriddenIndicator;
	}
}