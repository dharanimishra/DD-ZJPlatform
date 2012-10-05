package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utilz.SubjectClassification;

/**
 * @author bhashasp
 */
public class LearningComponent extends AuditHistory {

	public LearningComponent(Date validFrom, Date validTo,
			CourseStatus courseStatus, Boolean prescribedLODuration,
			LearningComponentType learningComponentType, Course course,
			MemberPersona authoredMember) {
		super();
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.courseStatus = courseStatus;
		this.prescribedLODuration = prescribedLODuration;
		this.learningComponentType = learningComponentType;
		this.course = course;
		this.authoredMember = authoredMember;
	}

	public LearningComponent(Boolean prescribedLODuration,
			LearningComponentType learningComponentType, Course course,
			MemberPersona authoredMember) {
		super();
		this.prescribedLODuration = prescribedLODuration;
		this.learningComponentType = learningComponentType;
		this.course = course;
		this.authoredMember = authoredMember;
	}

	public LearningComponent() {

	}

	public LearningComponent(LearningComponentType learningComponentType) {
		this.learningComponentType = learningComponentType;
	}

	private Integer learningComponentId;
	private String 			name;
	private Date 			validFrom 		= null;
	private Date 			validTo 		= null;
	private CourseStatus 	courseStatus 	= null;
	private Integer 		weightage 		= null;

	/**
	 * Maximum Length:5
	 */
	private String totalCredits = null;

	/**
	 * Maximum Length:1
	 */
	private Boolean extraCreditsIndicator 	= null;

	private Integer learningObjIndictor 	= null;

	/**
	 * Maximum Length:72
	 */
	private String thumbnailPicturePath 	= null;

	/**
	 * Maximum Length:1
	 */
	private Boolean templateIndicator 		= null;

	private Boolean prescribedLODuration 	= null;

	/**
	 * Maximum Length:240
	 */
	private String description = null;

	private Integer version = null;

	/**
	 * Maximum Length:240
	 */
	private String 					versionRemarks 			= null;

	private LearningComponentType 	learningComponentType 	= null;

	private Course 					course 					= null;

	private MemberPersona 			authoredMember 			= null;

	private SubjectClassification 	subjClassification 		= null;
	/**
	 * Maximum Length:5
	 */
	private String extraCredits;

	private LearningComponentDetails learningComponentDetails = null;

	/**
	 * @return the learningComponentDetails
	 */
	public LearningComponentDetails getLearningComponentDetails() {
		return learningComponentDetails;
	}

	/**
	 * @param learningComponentDetails
	 *            the learningComponentDetails to set
	 */
	public void setLearningComponentDetails(
			LearningComponentDetails learningComponentDetails) {
		this.learningComponentDetails = learningComponentDetails;
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
	 * @return the learningObjIndictor
	 */
	public Integer getLearningObjIndictor() {
		return learningObjIndictor;
	}

	/**
	 * @param learningObjIndictor
	 *            the learningObjIndictor to set
	 */
	public void setLearningObjIndictor(Integer learningObjIndictor) {
		this.learningObjIndictor = learningObjIndictor;
	}

	/**
	 * @return the thumbnailPicturePath
	 */
	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	/**
	 * @param thumbnailPicturePath
	 *            the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	/**
	 * @return the templateIndicator
	 */
	public Boolean getTemplateIndicator() {
		return templateIndicator;
	}

	/**
	 * @param templateIndicator
	 *            the templateIndicator to set
	 */
	public void setTemplateIndicator(Boolean templateIndicator) {
		this.templateIndicator = templateIndicator;
	}

	/**
	 * @return the prescribedLODuration
	 */
	public Boolean getPrescribedLODuration() {
		return prescribedLODuration;
	}

	/**
	 * @param prescribedLODuration
	 *            the prescribedLODuration to set
	 */
	public void setPrescribedLODuration(Boolean prescribedLODuration) {
		this.prescribedLODuration = prescribedLODuration;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
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
	 * @param versionRemarks
	 *            the versionRemarks to set
	 */
	public void setVersionRemarks(String versionRemarks) {
		this.versionRemarks = versionRemarks;
	}

	/**
	 * @return the courseStatus
	 */
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	/**
	 * @param courseStatus
	 *            the courseStatus to set
	 */
	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * @return the learningComponentType
	 */
	public LearningComponentType getLearningComponentType() {
		return learningComponentType;
	}

	/**
	 * @param learningComponentType
	 *            the learningComponentType to set
	 */
	public void setLearningComponentType(
			LearningComponentType learningComponentType) {
		this.learningComponentType = learningComponentType;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the authoredMember
	 */
	public MemberPersona getAuthoredMember() {
		return authoredMember;
	}

	/**
	 * @param authoredMember
	 *            the authoredMember to set
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
	 * @param subjClassification
	 *            the subjClassification to set
	 */
	public void setSubjClassification(SubjectClassification subjClassification) {
		this.subjClassification = subjClassification;
	}

	@Override
	public String toString() {
		return "LearningComponent [validFrom=" + validFrom + ", validTo="
				+ validTo + ", courseStatus=" + courseStatus
				+ ", learningObjIndictor=" + learningObjIndictor
				+ ", learningComponentType=" + learningComponentType + "]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}