package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class CurriculumCourse extends AuditHistory{

	private Integer curriculumCourseId;
	private Date creationDate;
	private Boolean active;
	private CurriculumUseType curriculumUseType;
	private String curriculumCourseIdentifier;
	private Integer courseVersionUsed;
	private Integer courseWeightage;
	private GradeType gradeType;
	private Integer courseCredit;
	private Boolean ziksanaOnlyIndicator;
	private Boolean classroomIndicator;
	private Boolean combinedIndicator;
	private Boolean noSyncConstraintIndicator;
	private Integer syncAfterClass;
	private Integer syncBeforeClass;
	private Date validFrom;
	private Date validTo;
	private Rating overallLearnerRating;
	private Rating overallPeerRating;
	private Boolean contentSecurityNeededIndicator;
	private String totalCredits;
	private String extraCredits;
	private boolean courseLevelOveriddenIndicator;
	private ProgrammCurriculum programCurriculum;
	private Course course;

	/**
	 * @return the curriculumCourseId
	 */
	public Integer getCurriculumCourseId() {
		return curriculumCourseId;
	}
	/**
	 * @param curriculumCourseId the curriculumCourseId to set
	 */
	public void setCurriculumCourseId(Integer curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
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
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the curriculumUseType
	 */
	public CurriculumUseType getCurriculumUseType() {
		return curriculumUseType;
	}
	/**
	 * @param curriculumUseType the curriculumUseType to set
	 */
	public void setCurriculumUseType(CurriculumUseType curriculumUseType) {
		this.curriculumUseType = curriculumUseType;
	}
	/**
	 * @return the curriculumCourseIdentifier
	 */
	public String getCurriculumCourseIdentifier() {
		return curriculumCourseIdentifier;
	}
	/**
	 * @param curriculumCourseIdentifier the curriculumCourseIdentifier to set
	 */
	public void setCurriculumCourseIdentifier(String curriculumCourseIdentifier) {
		this.curriculumCourseIdentifier = curriculumCourseIdentifier;
	}
	/**
	 * @return the courseVersionUsed
	 */
	public Integer getCourseVersionUsed() {
		return courseVersionUsed;
	}
	/**
	 * @param courseVersionUsed the courseVersionUsed to set
	 */
	public void setCourseVersionUsed(Integer courseVersionUsed) {
		this.courseVersionUsed = courseVersionUsed;
	}
	/**
	 * @return the courseWeightage
	 */
	public Integer getCourseWeightage() {
		return courseWeightage;
	}
	/**
	 * @param courseWeightage the courseWeightage to set
	 */
	public void setCourseWeightage(Integer courseWeightage) {
		this.courseWeightage = courseWeightage;
	}
	/**
	 * @return the gradeType
	 */
	public GradeType getGradeType() {
		return gradeType;
	}
	/**
	 * @param gradeType the gradeType to set
	 */
	public void setGradeType(GradeType gradeType) {
		this.gradeType = gradeType;
	}
	/**
	 * @return the courseCredit
	 */
	public Integer getCourseCredit() {
		return courseCredit;
	}
	/**
	 * @param courseCredit the courseCredit to set
	 */
	public void setCourseCredit(Integer courseCredit) {
		this.courseCredit = courseCredit;
	}
	/**
	 * @return the ziksanaOnlyIndicator
	 */
	public Boolean getZiksanaOnlyIndicator() {
		return ziksanaOnlyIndicator;
	}
	/**
	 * @param ziksanaOnlyIndicator the ziksanaOnlyIndicator to set
	 */
	public void setZiksanaOnlyIndicator(Boolean ziksanaOnlyIndicator) {
		this.ziksanaOnlyIndicator = ziksanaOnlyIndicator;
	}
	/**
	 * @return the classroomIndicator
	 */
	public Boolean getClassroomIndicator() {
		return classroomIndicator;
	}
	/**
	 * @param classroomIndicator the classroomIndicator to set
	 */
	public void setClassroomIndicator(Boolean classroomIndicator) {
		this.classroomIndicator = classroomIndicator;
	}
	/**
	 * @return the combinedIndicator
	 */
	public Boolean getCombinedIndicator() {
		return combinedIndicator;
	}
	/**
	 * @param combinedIndicator the combinedIndicator to set
	 */
	public void setCombinedIndicator(Boolean combinedIndicator) {
		this.combinedIndicator = combinedIndicator;
	}
	/**
	 * @return the noSyncConstraintIndicator
	 */
	public Boolean getNoSyncConstraintIndicator() {
		return noSyncConstraintIndicator;
	}
	/**
	 * @param noSyncConstraintIndicator the noSyncConstraintIndicator to set
	 */
	public void setNoSyncConstraintIndicator(Boolean noSyncConstraintIndicator) {
		this.noSyncConstraintIndicator = noSyncConstraintIndicator;
	}
	/**
	 * @return the syncAfterClass
	 */
	public Integer getSyncAfterClass() {
		return syncAfterClass;
	}
	/**
	 * @param syncAfterClass the syncAfterClass to set
	 */
	public void setSyncAfterClass(Integer syncAfterClass) {
		this.syncAfterClass = syncAfterClass;
	}
	/**
	 * @return the syncBeforeClass
	 */
	public Integer getSyncBeforeClass() {
		return syncBeforeClass;
	}
	/**
	 * @param syncBeforeClass the syncBeforeClass to set
	 */
	public void setSyncBeforeClass(Integer syncBeforeClass) {
		this.syncBeforeClass = syncBeforeClass;
	}
	/**
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}
	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	/**
	 * @return the validTo
	 */
	public Date getValidTo() {
		return validTo;
	}
	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	/**
	 * @return the overallLearnerRating
	 */
	public Rating getOverallLearnerRating() {
		return overallLearnerRating;
	}
	/**
	 * @param overallLearnerRating the overallLearnerRating to set
	 */
	public void setOverallLearnerRating(Rating overallLearnerRating) {
		this.overallLearnerRating = overallLearnerRating;
	}
	/**
	 * @return the overallPeerRating
	 */
	public Rating getOverallPeerRating() {
		return overallPeerRating;
	}
	/**
	 * @param overallPeerRating the overallPeerRating to set
	 */
	public void setOverallPeerRating(Rating overallPeerRating) {
		this.overallPeerRating = overallPeerRating;
	}
	/**
	 * @return the contentSecurityNeededIndicator
	 */
	public Boolean getContentSecurityNeededIndicator() {
		return contentSecurityNeededIndicator;
	}
	/**
	 * @param contentSecurityNeededIndicator the contentSecurityNeededIndicator to set
	 */
	public void setContentSecurityNeededIndicator(
			Boolean contentSecurityNeededIndicator) {
		this.contentSecurityNeededIndicator = contentSecurityNeededIndicator;
	}
	/**
	 * @return the totalCredits
	 */
	public String getTotalCredits() {
		return totalCredits;
	}
	/**
	 * @param totalCredits the totalCredits to set
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits;
	}
	/**
	 * @return the extraCredits
	 */
	public String getExtraCredits() {
		return extraCredits;
	}
	/**
	 * @param extraCredits the extraCredits to set
	 */
	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits;
	}
	/**
	 * @return the courseLevelOveriddenIndicator
	 */
	public boolean isCourseLevelOveriddenIndicator() {
		return courseLevelOveriddenIndicator;
	}
	/**
	 * @param courseLevelOveriddenIndicator the courseLevelOveriddenIndicator to set
	 */
	public void setCourseLevelOveriddenIndicator(
			boolean courseLevelOveriddenIndicator) {
		this.courseLevelOveriddenIndicator = courseLevelOveriddenIndicator;
	}
	/**
	 * @return the programCurriculum
	 */
	public ProgrammCurriculum getProgramCurriculum() {
		return programCurriculum;
	}
	/**
	 * @param programCurriculum the programCurriculum to set
	 */
	public void setProgramCurriculum(ProgrammCurriculum programCurriculum) {
		this.programCurriculum = programCurriculum;
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
	
}