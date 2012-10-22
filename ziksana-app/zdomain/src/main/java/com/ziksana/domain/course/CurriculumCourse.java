/**
 * 
 */
package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CurriculumCourse extends AuditHistory {
	

	public CurriculumCourse(Boolean active, CourseUseType courseUseType,
			String curruclmCourseIdentifier, Integer courseVersionUsed,
			com.ziksana.domain.course.GradeType gradeType, Date validFrom,
			Date validTo, Duration prescribedDuration,
			Boolean securityNeededIndicator) {
		this.active = active;
		this.courseUseType = courseUseType;
		this.curruclmCourseIdentifier = curruclmCourseIdentifier;
		this.courseVersionUsed = courseVersionUsed;
		this.gradeType = gradeType;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.prescribedDuration = prescribedDuration;
		this.securityNeededIndicator = securityNeededIndicator;
	}

	  private ZID 					curriculumCourseId; 
	  private Boolean 				active							= null; 
	  private CourseUseType 		courseUseType					= null; 
	  private String 				curruclmCourseIdentifier		= null; 
	  private Integer 				courseVersionUsed				= null; 
	  private Integer 				courseWeightage					= null; 
	  private GradeType 			gradeType						= null; 
	  private Integer 				courseCredit					= null; 
	  private Boolean 				ziksanaOnlyIndicator			= null; 
	  private Boolean 				classroomIndicator				= null; 
	  private Boolean 				combinedIndicator				= null; 
	  private Boolean 				noSyncConstraintIndicator		= null; 
	  private Sync 					syncAfterClass					= null; 
	  private Sync 					syncBeforeClass					= null; 
	  private Date 					validFrom						= null; 
	  private Date 					validTo							= null; 
	  private Duration 				prescribedDuration				= null; 
	  private Rating 				overallLearnerRating			= null; 
	  private Rating 				overallPeerRating				= null; 
	  private Boolean 				securityNeededIndicator			= null; 
	  private Integer 				totalCredits					= null; 
	  private Integer 				extraCredits					= null; 
	  private Boolean 				courseLevelOveriddenIndicator	= null; 
	  private ProgramCurriculum 	programCurriculum				= null; 
	  private Course 				course							= null;
	  
	  
	/**
	 * @return the curriculumCourseId
	 */
	public ZID getCurriculumCourseId() {
		return curriculumCourseId;
	}
	/**
	 * @param curriculumCourseId the curriculumCourseId to set
	 */
	public void setCurriculumCourseId(ZID curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
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
	 * @return the courseUseType
	 */
	public CourseUseType getCourseUseType() {
		return courseUseType;
	}
	/**
	 * @param courseUseType the courseUseType to set
	 */
	public void setCourseUseType(CourseUseType courseUseType) {
		this.courseUseType = courseUseType;
	}
	/**
	 * @return the curruclmCourseIdentifier
	 */
	public String getCurruclmCourseIdentifier() {
		return curruclmCourseIdentifier;
	}
	/**
	 * @param curruclmCourseIdentifier the curruclmCourseIdentifier to set
	 */
	public void setCurruclmCourseIdentifier(String curruclmCourseIdentifier) {
		this.curruclmCourseIdentifier = curruclmCourseIdentifier;
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
	public Sync getSyncAfterClass() {
		return syncAfterClass;
	}
	/**
	 * @param syncAfterClass the syncAfterClass to set
	 */
	public void setSyncAfterClass(Sync syncAfterClass) {
		this.syncAfterClass = syncAfterClass;
	}
	/**
	 * @return the syncBeforeClass
	 */
	public Sync getSyncBeforeClass() {
		return syncBeforeClass;
	}
	/**
	 * @param syncBeforeClass the syncBeforeClass to set
	 */
	public void setSyncBeforeClass(Sync syncBeforeClass) {
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
	 * @return the prescribedDuration
	 */
	public Duration getPrescribedDuration() {
		return prescribedDuration;
	}
	/**
	 * @param prescribedDuration the prescribedDuration to set
	 */
	public void setPrescribedDuration(Duration prescribedDuration) {
		this.prescribedDuration = prescribedDuration;
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
	 * @return the securityNeededIndicator
	 */
	public Boolean getSecurityNeededIndicator() {
		return securityNeededIndicator;
	}
	/**
	 * @param securityNeededIndicator the securityNeededIndicator to set
	 */
	public void setSecurityNeededIndicator(Boolean securityNeededIndicator) {
		this.securityNeededIndicator = securityNeededIndicator;
	}
	/**
	 * @return the totalCredits
	 */
	public Integer getTotalCredits() {
		return totalCredits;
	}
	/**
	 * @param totalCredits the totalCredits to set
	 */
	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}
	/**
	 * @return the extraCredits
	 */
	public Integer getExtraCredits() {
		return extraCredits;
	}
	/**
	 * @param extraCredits the extraCredits to set
	 */
	public void setExtraCredits(Integer extraCredits) {
		this.extraCredits = extraCredits;
	}
	/**
	 * @return the corseLevelOveriddenIndicator
	 */
	public Boolean getCorseLevelOveriddenIndicator() {
		return courseLevelOveriddenIndicator;
	}
	/**
	 * @param corseLevelOveriddenIndicator the corseLevelOveriddenIndicator to set
	 */
	public void setCorseLevelOveriddenIndicator(Boolean courseLevelOveriddenIndicator) {
		this.courseLevelOveriddenIndicator = courseLevelOveriddenIndicator;
	}
	/**
	 * @return the programCurriculum
	 */
	public ProgramCurriculum getProgramCurriculum() {
		return programCurriculum;
	}
	/**
	 * @param programCurriculum the programCurriculum to set
	 */
	public void setProgramCurriculum(ProgramCurriculum programCurriculum) {
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
	  
	@Override
	public String toString() {
		return "CurriculumCourse [active=" + active + ", courseUseType="
				+ courseUseType + ", courseVersionUsed=" + courseVersionUsed
				+ ", GradeType=" + gradeType + ", courseCredit=" + courseCredit
				+ ", ziksanaOnlyIndicator=" + ziksanaOnlyIndicator
				+ ", classroomIndicator=" + classroomIndicator
				+ ", combinedIndicator=" + combinedIndicator
				+ ", noSyncConstraintIndicator=" + noSyncConstraintIndicator
				+ ", SyncAfterClass=" + syncAfterClass + ", SyncBeforeClass="
				+ syncBeforeClass + ", ValidFrom=" + validFrom + ", ValidTo="
				+ validTo + ", prescribedDuration=" + prescribedDuration
				+ ", overallLearnerRating=" + overallLearnerRating
				+ ", overallPeerRating=" + overallPeerRating
				+ ", totalCredits=" + totalCredits + ", extraCredits="
				+ extraCredits + "]";
	}
	  

}
