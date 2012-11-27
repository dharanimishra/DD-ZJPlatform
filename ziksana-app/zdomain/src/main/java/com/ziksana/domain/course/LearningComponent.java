package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utils.SubjectClassification;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class LearningComponent extends AuditHistory {


	public LearningComponent(Date validFrom, Date validTo,
			CourseStatus courseStatus,
			LearningComponentType learningComponentType, Course course,
			MemberPersona authoredMember) {
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.courseStatus = courseStatus;
		this.learningComponentType = learningComponentType;
		this.authoredMember = authoredMember;
	}

	public LearningComponent(Duration prescribedDuration,
			LearningComponentType learningComponentType, Course course,
			MemberPersona authoredMember) {
		this.prescribedDuration = prescribedDuration;
		this.learningComponentType = learningComponentType;
			this.authoredMember = authoredMember;
	}

	public LearningComponent() {
	}

	public LearningComponent(LearningComponentType learningComponentType) {
		this.learningComponentType = learningComponentType;
	}

	protected ZID	 		learningComponentId;
	private String 			name					= null;
	/**
	 * Maximum Length:240
	 */
	private String 			description				= null;
	private Date 			validFrom 				= null;
	private Date 			validTo 				= null;
	private CourseStatus 	courseStatus 			= null;
	private Integer	 		courseStatusId 			= null;
	private Integer 		weightage 				= null;
	private Integer 		learningObjIndicator 	= null;
	/**						
	 * Maximum Length:72
	 */
	private String 			thumbnailPicturePath 	= null;
	private Duration 		prescribedDuration 	= null;
	private Integer 		version 				= null;
	private Integer			totalCredits			= null;
	private Integer			extraCredits			= null;
	private Integer			extraCreditsIndicator   = null;

	/**
	 * Maximum Length:240
	 */
	private String 					versionRemarks 			= null;
	private LearningComponentType 	learningComponentType 	= null;
	private MemberPersona 			authoredMember 			= null;
	private SubjectClassification 	subjClassification 		= null;

	private LearningComponentDetails learningComponentDetails = null;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the courseStatus
	 */
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	/**
	 * @param courseStatus the courseStatus to set
	 */
	public void setCourseStatus(CourseStatus courseStatus) {
		
		if(courseStatusId!=null){
			courseStatus = CourseStatus.getCourseStatus(courseStatusId);
		}
		this.courseStatus = courseStatus;
	}

	/**
	 * @return the weightage
	 */
	public Integer getWeightage() {
		return weightage;
	}

	/**
	 * @param weightage the weightage to set
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	/**
	 * @return the learningObjIndictor
	 */
	public Integer getLearningObjIndicator() {
		return learningObjIndicator;
	}

	/**
	 * @param learningObjIndictor the learningObjIndictor to set
	 */
	public void setLearningObjIndicator(Integer learningObjIndicator) {
		this.learningObjIndicator = learningObjIndicator;
	}

	/**
	 * @return the thumbnailPicturePath
	 */
	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	/**
	 * @param thumbnailPicturePath the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the versionRemarks
	 */
	public String getVersionRemarks() {
		return versionRemarks;
	}

	/**
	 * @param versionRemarks the versionRemarks to set
	 */
	public void setVersionRemarks(String versionRemarks) {
		this.versionRemarks = versionRemarks;
	}

	/**
	 * @return the learningComponentType
	 */
	public LearningComponentType getLearningComponentType() {
		return learningComponentType;
	}

	/**
	 * @param learningComponentType the learningComponentType to set
	 */
	public void setLearningComponentType(LearningComponentType learningComponentType) {
		this.learningComponentType = learningComponentType;
	}

	/**
	 * @return the authoredMember
	 */
	public MemberPersona getAuthoredMember() {
		return authoredMember;
	}

	/**
	 * @param authoredMember the authoredMember to set
	 */
	public void setAuthoredMember(MemberPersona authoredMember) {
		this.authoredMember = authoredMember;
	}

	/**
	 * @return the subjClassification
	 */
	public SubjectClassification getSubjClassification() {
		return subjClassification;
	}

	/**
	 * @param subjClassification the subjClassification to set
	 */
	public void setSubjClassification(SubjectClassification subjClassification) {
		this.subjClassification = subjClassification;
	}

	/**
	 * @return the learningComponentDetails
	 */
	public LearningComponentDetails getLearningComponentDetails() {
		return learningComponentDetails;
	}

	/**
	 * @param learningComponentDetails the learningComponentDetails to set
	 */
	public void setLearningComponentDetails(
			LearningComponentDetails learningComponentDetails) {
		this.learningComponentDetails = learningComponentDetails;
	}
	
	@Override
	public String toString() {
		return "LearningComponent [name=" + name + ", description="
				+ description + ", validFrom=" + validFrom + ", validTo="
				+ validTo + ", courseStatus=" + courseStatus + ", weightage="
				+ weightage + ", learningObjIndictor=" + learningObjIndicator
				+ ", thumbnailPicturePath=" + thumbnailPicturePath
				+ ", prescribedLCDuration=" + prescribedDuration
				+ ", learningComponentDetails=" + learningComponentDetails
				+ "]";
	}

	/**
	 * @return the prescribedLCDuration
	 */
	public Duration getPrescribedDuration() {
		return prescribedDuration;
	}

	/**
	 * @param prescribedLCDuration the prescribedLCDuration to set
	 */
	public void setPrescribedDuration(Duration prescribedDuration) {
		this.prescribedDuration = prescribedDuration;
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
	 * @return the extraCreditsIndicator
	 */
	public Integer getExtraCreditsIndicator() {
		return extraCreditsIndicator;
	}

	/**
	 * @param extraCreditsIndicator the extraCreditsIndicator to set
	 */
	public void setExtraCreditsIndicator(Integer extraCreditsIndicator) {
		this.extraCreditsIndicator = extraCreditsIndicator;
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
	 * @return the learningComponentId
	 */
	public ZID getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * @param learningComponentId the learningComponentId to set
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = new IntegerZID(learningComponentId);
	}

	/**
	 * @return the courseStatusId
	 */
	public Integer getCourseStatusId() {
		return courseStatusId;
	}

	/**
	 * @param courseStatusId the courseStatusId to set
	 */
	public void setCourseStatusId(Integer courseStatusId) {
		this.courseStatusId = courseStatusId;
	}


}