package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utilz.SubjectClassification;

/**
 * @author bhashasp
 */
public class LearningComponent extends AuditHistory{
	

	public LearningComponent(){
		
	}
	public LearningComponent(LearningComponentType learningComponentType) {
		this.learningComponentType = learningComponentType;
	}

	/**
	 * This field corresponds property ID
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds property validfrom {Start Date}
	 */
	private Date validFrom;

	/**
	 * This field corresponds property validTo{End Date}
	 */
	private Date validTo;

	/**
	 * This field corresponds property CourseStatus<br>
	 */
	private CourseStatus courseStatus;

	/**
	 * This field corresponds property Weightage
	 */
	private Integer weightage;

	/**
	 * This field corresponds property TotalCredits<br>
	 * Maximum Length:5
	 */
	private String totalCredits;

	/**
	 * This field corresponds property ExtraCreditsIndicator<br>
	 * Maximum Length:1
	 */
	private Boolean extraCreditsIndicator;

	/**
	 * This field corresponds to the attribute learningObjIndictor
	 */
	private Integer learningObjIndictor;

	/**
	 * This field corresponds to the attribute thumbnailPicturePath<br>
	 * Maximum Length:72
	 */
	private String thumbnailPicturePath;

	/**
	 * This field corresponds to the attribute templateIndicator<br>
	 * Maximum Length:1
	 */
	private Boolean templateIndicator;

	/**
	 * This field corresponds to the attribute prescribedLODuration<br>
	 */
	private Boolean prescribedLODuration;

	/**
	 * This field corresponds property learningComponentTypeId
	 */
	private LearningComponentType learningComponentType;

	/**
	 * This field corresponds property course
	 */
	private Course course;

	/**
	 * This field corresponds property memberPersona
	 */
	private MemberPersona authoredMember;

	/**
	 * This field corresponds property subjClassification
	 */
	private SubjectClassification subjClassification;
	/**
	 * This field corresponds property ExtraCredits<br>
	 * Maximum Length:5
	 */
	private String extraCredits;

	/**
	 * The Object contains the more information(associations, compositions)
	 * about LearningComponent
	 */
	private LearningComponentDetails learningComponentDetails;
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
	 * @return the value of property learningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column property
	 * learningComponentId
	 * @param learningComponentId
	 *            the value for property learningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column property validfrom
	 * @return the value of property validfrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * This method sets the value of the database column property validfrom
	 * @param validfrom
	 *            the value for property validfrom
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * This method returns the value of the database column property validTo
	 * @return the value of property validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * This method sets the value of the database column property validTo
	 * @param validTo
	 *            the value for property validTo
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * This method returns the value of the database column property Weightage
	 * @return the value of property Weightage
	 */
	public Integer getWeightage() {
		return weightage;
	}

	/**
	 * This method sets the value of the database column property Weightage
	 * @param weightage
	 *            the value for property Weightage
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	/**
	 * This method returns the value of the database column property
	 * TotalCredits
	 * @return the value of property TotalCredits
	 */
	public String getTotalCredits() {
		return totalCredits;
	}

	/**
	 * This method sets the value of the database column property TotalCredits
	 * @param totalCredits
	 *            the value for property TotalCredits
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits == null ? null : totalCredits.trim();
	}

	/**
	 * This method returns the value of the database column property
	 * ExtraCreditsIndicator
	 * @return the value of property ExtraCreditsIndicator
	 */
	public Boolean getExtraCreditsIndicator() {
		return extraCreditsIndicator;
	}

	/**
	 * This method sets the value of the database column property
	 * ExtraCreditsIndicator
	 * @param extraCreditsIndicator
	 *            the value for property ExtraCreditsIndicator
	 */
	public void setExtraCreditsIndicator(Boolean extraCreditsIndicator) {
		this.extraCreditsIndicator = extraCreditsIndicator;
	}

	/**
	 * This method returns the value of the database column property
	 * ExtraCredits
	 * @return the value of property ExtraCredits
	 */
	public String getExtraCredits() {
		return extraCredits;
	}

	/**
	 * This method sets the value of the database column property ExtraCredits
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

	@Override
	public String toString() {
		return "LearningComponent [validFrom=" + validFrom + ", validTo="
				+ validTo + ", courseStatus=" + courseStatus
				+ ", learningObjIndictor=" + learningObjIndictor
				+ ", learningComponentType=" + learningComponentType + "]";
	}
}