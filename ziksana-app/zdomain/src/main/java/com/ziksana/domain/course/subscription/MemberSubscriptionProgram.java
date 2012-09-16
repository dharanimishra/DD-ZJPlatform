package com.ziksana.domain.course.subscription;

import java.util.Date;

public class MemberSubscriptionProgram {

	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.MemSubscriptionProgId
	 */
	private Integer memSubscriptionProgId;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.Date
	 */
	private Date date;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.Status
	 */
	private Integer status;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.Description
	 */
	private String description;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.TargetProficiency
	 */
	private Integer targetProficiency;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.TargetCompletionDate
	 */
	private Date targetCompletionDate;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.TargetStartDate
	 */
	private Date targetStartDate;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemRating
	 */
	private Integer subscriptionItemRating;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemAuthorRating
	 */
	private Integer subscriptionItemAuthorRating;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.SubscrptionItemRatingDescription
	 */
	private String subscrptionItemRatingDescription;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemAuthorRatingDescription
	 */
	private String subscriptionItemAuthorRatingDescription;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.CertificatePath
	 */
	private String certificatePath;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.MemberRoleId
	 */
	private Integer memberRoleId;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.LearningProgramId
	 */
	private Integer learningProgramId;
	/**
	 * This field corresponds to the database column
	 * sbnmembersubscriptionprogram.CurriculumDeliveryId
	 */
	private Integer curriculumDeliveryId;

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.MemSubscriptionProgId
	 * 
	 * @return the value of sbnmembersubscriptionprogram.MemSubscriptionProgId
	 */
	public Integer getMemSubscriptionProgId() {
		return memSubscriptionProgId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.MemSubscriptionProgId
	 * 
	 * @param memSubscriptionProgId
	 *            the value for
	 *            sbnmembersubscriptionprogram.MemSubscriptionProgId
	 */
	public void setMemSubscriptionProgId(Integer memSubscriptionProgId) {
		this.memSubscriptionProgId = memSubscriptionProgId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.Date
	 * 
	 * @return the value of sbnmembersubscriptionprogram.Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.Date
	 * 
	 * @param date
	 *            the value for sbnmembersubscriptionprogram.Date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.Status
	 * 
	 * @return the value of sbnmembersubscriptionprogram.Status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.Status
	 * 
	 * @param status
	 *            the value for sbnmembersubscriptionprogram.Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.Description
	 * 
	 * @return the value of sbnmembersubscriptionprogram.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.Description
	 * 
	 * @param description
	 *            the value for sbnmembersubscriptionprogram.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.TargetProficiency
	 * 
	 * @return the value of sbnmembersubscriptionprogram.TargetProficiency
	 */
	public Integer getTargetProficiency() {
		return targetProficiency;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.TargetProficiency
	 * 
	 * @param targetProficiency
	 *            the value for sbnmembersubscriptionprogram.TargetProficiency
	 */
	public void setTargetProficiency(Integer targetProficiency) {
		this.targetProficiency = targetProficiency;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.TargetCompletionDate
	 * 
	 * @return the value of sbnmembersubscriptionprogram.TargetCompletionDate
	 */
	public Date getTargetCompletionDate() {
		return targetCompletionDate;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.TargetCompletionDate
	 * 
	 * @param targetCompletionDate
	 *            the value for
	 *            sbnmembersubscriptionprogram.TargetCompletionDate
	 */
	public void setTargetCompletionDate(Date targetCompletionDate) {
		this.targetCompletionDate = targetCompletionDate;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.TargetStartDate
	 * 
	 * @return the value of sbnmembersubscriptionprogram.TargetStartDate
	 */
	public Date getTargetStartDate() {
		return targetStartDate;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.TargetStartDate
	 * 
	 * @param targetStartDate
	 *            the value for sbnmembersubscriptionprogram.TargetStartDate
	 */
	public void setTargetStartDate(Date targetStartDate) {
		this.targetStartDate = targetStartDate;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemRating
	 * 
	 * @return the value of sbnmembersubscriptionprogram.SubscriptionItemRating
	 */
	public Integer getSubscriptionItemRating() {
		return subscriptionItemRating;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemRating
	 * 
	 * @param subscriptionItemRating
	 *            the value for
	 *            sbnmembersubscriptionprogram.SubscriptionItemRating
	 */
	public void setSubscriptionItemRating(Integer subscriptionItemRating) {
		this.subscriptionItemRating = subscriptionItemRating;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemAuthorRating
	 * 
	 * @return the value of
	 *         sbnmembersubscriptionprogram.SubscriptionItemAuthorRating
	 */
	public Integer getSubscriptionItemAuthorRating() {
		return subscriptionItemAuthorRating;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemAuthorRating
	 * 
	 * @param subscriptionItemAuthorRating
	 *            the value for
	 *            sbnmembersubscriptionprogram.SubscriptionItemAuthorRating
	 */
	public void setSubscriptionItemAuthorRating(
			Integer subscriptionItemAuthorRating) {
		this.subscriptionItemAuthorRating = subscriptionItemAuthorRating;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.SubscrptionItemRatingDescription
	 * 
	 * @return the value of
	 *         sbnmembersubscriptionprogram.SubscrptionItemRatingDescription
	 */
	public String getSubscrptionItemRatingDescription() {
		return subscrptionItemRatingDescription;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.SubscrptionItemRatingDescription
	 * 
	 * @param subscrptionItemRatingDescription
	 *            the value for sbnmembersubscriptionprogram.
	 *            SubscrptionItemRatingDescription
	 */
	public void setSubscrptionItemRatingDescription(
			String subscrptionItemRatingDescription) {
		this.subscrptionItemRatingDescription = subscrptionItemRatingDescription == null ? null
				: subscrptionItemRatingDescription.trim();
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemAuthorRatingDescription
	 * 
	 * @return the value of
	 *         sbnmembersubscriptionprogram.SubscriptionItemAuthorRatingDescription
	 */
	public String getSubscriptionItemAuthorRatingDescription() {
		return subscriptionItemAuthorRatingDescription;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.SubscriptionItemAuthorRatingDescription
	 * 
	 * @param subscriptionItemAuthorRatingDescription
	 *            the value for sbnmembersubscriptionprogram.
	 *            SubscriptionItemAuthorRatingDescription
	 */
	public void setSubscriptionItemAuthorRatingDescription(
			String subscriptionItemAuthorRatingDescription) {
		this.subscriptionItemAuthorRatingDescription = subscriptionItemAuthorRatingDescription == null ? null
				: subscriptionItemAuthorRatingDescription.trim();
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.CertificatePath
	 * 
	 * @return the value of sbnmembersubscriptionprogram.CertificatePath
	 */
	public String getCertificatePath() {
		return certificatePath;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.CertificatePath
	 * 
	 * @param certificatePath
	 *            the value for sbnmembersubscriptionprogram.CertificatePath
	 */
	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath == null ? null : certificatePath
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.MemberRoleId
	 * 
	 * @return the value of sbnmembersubscriptionprogram.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for sbnmembersubscriptionprogram.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.LearningProgramId
	 * 
	 * @return the value of sbnmembersubscriptionprogram.LearningProgramId
	 */
	public Integer getLearningProgramId() {
		return learningProgramId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.LearningProgramId
	 * 
	 * @param learningProgramId
	 *            the value for sbnmembersubscriptionprogram.LearningProgramId
	 */
	public void setLearningProgramId(Integer learningProgramId) {
		this.learningProgramId = learningProgramId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnmembersubscriptionprogram.CurriculumDeliveryId
	 * 
	 * @return the value of sbnmembersubscriptionprogram.CurriculumDeliveryId
	 */
	public Integer getCurriculumDeliveryId() {
		return curriculumDeliveryId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnmembersubscriptionprogram.CurriculumDeliveryId
	 * 
	 * @param curriculumDeliveryId
	 *            the value for
	 *            sbnmembersubscriptionprogram.CurriculumDeliveryId
	 */
	public void setCurriculumDeliveryId(Integer curriculumDeliveryId) {
		this.curriculumDeliveryId = curriculumDeliveryId;
	}
}