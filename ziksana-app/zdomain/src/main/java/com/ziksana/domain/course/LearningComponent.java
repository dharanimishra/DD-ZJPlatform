package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.id.ZID;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utils.SubjectClassification;

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

	public LearningComponent(Integer learningObjectDuration,
			LearningComponentType learningComponentType, Course course,
			MemberPersona authoredMember) {
		this.learningObjectDuration = learningObjectDuration;
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
	private Integer 		weightage 				= null;
	private Integer 		learningObjIndictor 	= null;
	/**
	 * Maximum Length:72
	 */
	private String 			thumbnailPicturePath 	= null;
	private Integer 		learningObjectDuration 	= null;
	private Integer 		version 				= null;

	/**
	 * Maximum Length:240
	 */
	private String 					versionRemarks 			= null;
	private LearningComponentType 	learningComponentType 	= null;
	private MemberPersona 			authoredMember 			= null;
	private SubjectClassification 	subjClassification 		= null;

	private LearningComponentDetails learningComponentDetails = null;

	
		/**
	 * @return the learningComponentId
	 */
	public ZID	 getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * @param learningComponentId the learningComponentId to set
	 */
	public void setLearningComponentId(ZID learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

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
	public Integer getLearningObjIndictor() {
		return learningObjIndictor;
	}

	/**
	 * @param learningObjIndictor the learningObjIndictor to set
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
	 * @param thumbnailPicturePath the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	/**
	 * @return the learningObjectDuration
	 */
	public Integer getLearningObjectDuration() {
		return learningObjectDuration;
	}

	/**
	 * @param learningObjectDuration the learningObjectDuration to set
	 */
	public void setLearningObjectDuration(Integer learningObjectDuration) {
		this.learningObjectDuration = learningObjectDuration;
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
		return "LearningComponent [validFrom=" + validFrom + ", validTo="
				+ validTo + ", courseStatus=" + courseStatus
				+ ", learningObjIndictor=" + learningObjIndictor
				+ ", learningComponentType=" + learningComponentType + "]";
	}
}