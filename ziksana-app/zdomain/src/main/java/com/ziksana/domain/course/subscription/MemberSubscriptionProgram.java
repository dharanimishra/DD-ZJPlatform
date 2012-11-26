package com.ziksana.domain.course.subscription;

import java.util.Date;
import java.util.List;

import com.ziksana.domain.assessment.ProficiencyLevel;
import com.ziksana.domain.course.Rating;
import com.ziksana.domain.institution.CurriculumDelivery;
import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class MemberSubscriptionProgram {
	
	private ZID 				subscriptionProgramId;
	private Date 				creationDate 					= null;
	private SubscriptionStatus 	status 							= null;
	private String 				description						= null;
	private ProficiencyLevel	proficiency						= null;
	private Date				targetCompletionDate			= null;
	private Date				targetStartDate					= null;
	private Rating				subcriptionItemRating			= null;
	private Rating				subcriptionItemAuthorRating		= null;
	private Rating				subcriptionItemRatingDesc		= null;
	private Rating				subcriptionItemAuthorRatingDesc	= null;
	private String				certificatePath					= null;
	private MemberPersona 		memberRole 						= null;
	private LearningProgram 	academicProgram 				= null;
	private CurriculumDelivery 	curriculumDelivery 				= null;
	private List<SubscriptionCourse> sbnCourseList				= null;
	/**
	 * @return the subscriptionProgramId
	 */
	public ZID getSubscriptionProgramId() {
		return subscriptionProgramId;
	}
	/**
	 * @param subscriptionProgramId the subscriptionProgramId to set
	 */
	public void setSubscriptionProgramId(Integer subscriptionProgramId) {
		this.subscriptionProgramId = new IntegerZID(subscriptionProgramId);
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
	 * @return the status
	 */
	public SubscriptionStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(SubscriptionStatus status) {
		this.status = status;
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
	 * @return the proficiency
	 */
	public ProficiencyLevel getProficiency() {
		return proficiency;
	}
	/**
	 * @param proficiency the proficiency to set
	 */
	public void setProficiency(ProficiencyLevel proficiency) {
		this.proficiency = proficiency;
	}
	/**
	 * @return the targetCompletionDate
	 */
	public Date getTargetCompletionDate() {
		return targetCompletionDate;
	}
	/**
	 * @param targetCompletionDate the targetCompletionDate to set
	 */
	public void setTargetCompletionDate(Date targetCompletionDate) {
		this.targetCompletionDate = targetCompletionDate;
	}
	/**
	 * @return the targetStartDate
	 */
	public Date getTargetStartDate() {
		return targetStartDate;
	}
	/**
	 * @param targetStartDate the targetStartDate to set
	 */
	public void setTargetStartDate(Date targetStartDate) {
		this.targetStartDate = targetStartDate;
	}
	/**
	 * @return the subcriptionItemRating
	 */
	public Rating getSubcriptionItemRating() {
		return subcriptionItemRating;
	}
	/**
	 * @param subcriptionItemRating the subcriptionItemRating to set
	 */
	public void setSubcriptionItemRating(Rating subcriptionItemRating) {
		this.subcriptionItemRating = subcriptionItemRating;
	}
	/**
	 * @return the subcriptionItemAuthorRating
	 */
	public Rating getSubcriptionItemAuthorRating() {
		return subcriptionItemAuthorRating;
	}
	/**
	 * @param subcriptionItemAuthorRating the subcriptionItemAuthorRating to set
	 */
	public void setSubcriptionItemAuthorRating(Rating subcriptionItemAuthorRating) {
		this.subcriptionItemAuthorRating = subcriptionItemAuthorRating;
	}
	/**
	 * @return the subcriptionItemRatingDesc
	 */
	public Rating getSubcriptionItemRatingDesc() {
		return subcriptionItemRatingDesc;
	}
	/**
	 * @param subcriptionItemRatingDesc the subcriptionItemRatingDesc to set
	 */
	public void setSubcriptionItemRatingDesc(Rating subcriptionItemRatingDesc) {
		this.subcriptionItemRatingDesc = subcriptionItemRatingDesc;
	}
	/**
	 * @return the subcriptionItemAuthorRatingDesc
	 */
	public Rating getSubcriptionItemAuthorRatingDesc() {
		return subcriptionItemAuthorRatingDesc;
	}
	/**
	 * @param subcriptionItemAuthorRatingDesc the subcriptionItemAuthorRatingDesc to set
	 */
	public void setSubcriptionItemAuthorRatingDesc(
			Rating subcriptionItemAuthorRatingDesc) {
		this.subcriptionItemAuthorRatingDesc = subcriptionItemAuthorRatingDesc;
	}
	/**
	 * @return the certificatePath
	 */
	public String getCertificatePath() {
		return certificatePath;
	}
	/**
	 * @param certificatePath the certificatePath to set
	 */
	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}
	/**
	 * @return the memberRole
	 */
	public MemberPersona getMemberRole() {
		return memberRole;
	}
	/**
	 * @param memberRole the memberRole to set
	 */
	public void setMemberRole(MemberPersona memberRole) {
		this.memberRole = memberRole;
	}
	/**
	 * @return the academicProgram
	 */
	public LearningProgram getAcademicProgram() {
		return academicProgram;
	}
	/**
	 * @param academicProgram the academicProgram to set
	 */
	public void setAcademicProgram(LearningProgram academicProgram) {
		this.academicProgram = academicProgram;
	}
	/**
	 * @return the curriculumDelivery
	 */
	public CurriculumDelivery getCurriculumDelivery() {
		return curriculumDelivery;
	}
	/**
	 * @param curriculumDelivery the curriculumDelivery to set
	 */
	public void setCurriculumDelivery(CurriculumDelivery curriculumDelivery) {
		this.curriculumDelivery = curriculumDelivery;
	}
	/**
	 * @return the sbnCourseList
	 */
	public List<SubscriptionCourse> getSbnCourseList() {
		return sbnCourseList;
	}
	/**
	 * @param sbnCourseList the sbnCourseList to set
	 */
	public void setSbnCourseList(List<SubscriptionCourse> sbnCourseList) {
		this.sbnCourseList = sbnCourseList;
	}

}
