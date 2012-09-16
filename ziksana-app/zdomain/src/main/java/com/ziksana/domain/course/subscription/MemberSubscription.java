package com.ziksana.domain.course.subscription;

import java.util.Date;

public class MemberSubscription {
	/**
	 * 
	 * This field corresponds to the database column sbnmembersubscription.memSubscriptionId
	 * 
	 */
	private Integer memSubscriptionId;

	/**
	 * 
	 * This field corresponds to the database column sbnmembersubscription.Date
	 * 
	 */
	private Date date;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.Status
	 * 
	 */
	private Integer status;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.Description
	 * 
	 */
	private String description;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.TargetProficiency
	 * 
	 */
	private Integer targetProficiency;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.TargetCompletionDate
	 * 
	 */
	private Date targetCompletionDate;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.TargetStartDate
	 * 
	 */
	private Date targetStartDate;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.SubscriptionItemRating
	 * 
	 */
	private Integer subscriptionItemRating;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.SubscriptionItemAuthorRating
	 * 
	 */
	private Integer subscriptionItemAuthorRating;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.SubscrptionItemRatingDescription
	 * 
	 */
	private String subscrptionItemRatingDescription;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.SubscriptionItemAuthorRatingDescription
	 * 
	 */
	private String subscriptionItemAuthorRatingDescription;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.CertificatePath
	 * 
	 */
	private String certificatePath;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.MemberRoleId
	 * 
	 */
	private Integer memberRoleId;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.LearningProgramId
	 * 
	 */
	private Integer learningProgramId;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnmembersubscription.CurriculumDeliveryId
	 * 
	 */
	private Integer curriculumDeliveryId;

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.memSubscriptionId
	 * 
	 * @return the value of sbnmembersubscription.memSubscriptionId
	 * 
	 */
	public Integer getMemSubscriptionId() {
		return memSubscriptionId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.memSubscriptionId
	 * 
	 * @param memSubscriptionId
	 *            the value for sbnmembersubscription.memSubscriptionId
	 * 
	 */
	public void setMemSubscriptionId(Integer memSubscriptionId) {
		this.memSubscriptionId = memSubscriptionId;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.Date
	 * 
	 * @return the value of sbnmembersubscription.Date
	 * 
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.Date
	 * 
	 * @param date
	 *            the value for sbnmembersubscription.Date
	 * 
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.Status
	 * 
	 * @return the value of sbnmembersubscription.Status
	 * 
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.Status
	 * 
	 * @param status
	 *            the value for sbnmembersubscription.Status
	 * 
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.Description
	 * 
	 * @return the value of sbnmembersubscription.Description
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.Description
	 * 
	 * @param description
	 *            the value for sbnmembersubscription.Description
	 * 
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.TargetProficiency
	 * 
	 * @return the value of sbnmembersubscription.TargetProficiency
	 * 
	 */
	public Integer getTargetProficiency() {
		return targetProficiency;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.TargetProficiency
	 * 
	 * @param targetProficiency
	 *            the value for sbnmembersubscription.TargetProficiency
	 * 
	 */
	public void setTargetProficiency(Integer targetProficiency) {
		this.targetProficiency = targetProficiency;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.TargetCompletionDate
	 * 
	 * @return the value of sbnmembersubscription.TargetCompletionDate
	 * 
	 */
	public Date getTargetCompletionDate() {
		return targetCompletionDate;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.TargetCompletionDate
	 * 
	 * @param targetCompletionDate
	 *            the value for sbnmembersubscription.TargetCompletionDate
	 * 
	 */
	public void setTargetCompletionDate(Date targetCompletionDate) {
		this.targetCompletionDate = targetCompletionDate;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.TargetStartDate
	 * 
	 * @return the value of sbnmembersubscription.TargetStartDate
	 * 
	 */
	public Date getTargetStartDate() {
		return targetStartDate;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.TargetStartDate
	 * 
	 * @param targetStartDate
	 *            the value for sbnmembersubscription.TargetStartDate
	 * 
	 */
	public void setTargetStartDate(Date targetStartDate) {
		this.targetStartDate = targetStartDate;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.SubscriptionItemRating
	 * 
	 * @return the value of sbnmembersubscription.SubscriptionItemRating
	 * 
	 */
	public Integer getSubscriptionItemRating() {
		return subscriptionItemRating;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.SubscriptionItemRating
	 * 
	 * @param subscriptionItemRating
	 *            the value for sbnmembersubscription.SubscriptionItemRating
	 * 
	 */
	public void setSubscriptionItemRating(Integer subscriptionItemRating) {
		this.subscriptionItemRating = subscriptionItemRating;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.SubscriptionItemAuthorRating
	 * 
	 * @return the value of sbnmembersubscription.SubscriptionItemAuthorRating
	 * 
	 */
	public Integer getSubscriptionItemAuthorRating() {
		return subscriptionItemAuthorRating;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.SubscriptionItemAuthorRating
	 * 
	 * @param subscriptionItemAuthorRating
	 *            the value for
	 *            sbnmembersubscription.SubscriptionItemAuthorRating
	 * 
	 */
	public void setSubscriptionItemAuthorRating(
			Integer subscriptionItemAuthorRating) {
		this.subscriptionItemAuthorRating = subscriptionItemAuthorRating;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.SubscrptionItemRatingDescription
	 * 
	 * @return the value of
	 *         sbnmembersubscription.SubscrptionItemRatingDescription
	 * 
	 */
	public String getSubscrptionItemRatingDescription() {
		return subscrptionItemRatingDescription;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.SubscrptionItemRatingDescription
	 * 
	 * @param subscrptionItemRatingDescription
	 *            the value for
	 *            sbnmembersubscription.SubscrptionItemRatingDescription
	 * 
	 */
	public void setSubscrptionItemRatingDescription(
			String subscrptionItemRatingDescription) {
		this.subscrptionItemRatingDescription = subscrptionItemRatingDescription == null ? null
				: subscrptionItemRatingDescription.trim();
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.SubscriptionItemAuthorRatingDescription
	 * 
	 * @return the value of
	 *         sbnmembersubscription.SubscriptionItemAuthorRatingDescription
	 * 
	 */
	public String getSubscriptionItemAuthorRatingDescription() {
		return subscriptionItemAuthorRatingDescription;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.SubscriptionItemAuthorRatingDescription
	 * 
	 * @param subscriptionItemAuthorRatingDescription
	 *            the value for sbnmembersubscription.
	 *            SubscriptionItemAuthorRatingDescription
	 * 
	 */
	public void setSubscriptionItemAuthorRatingDescription(
			String subscriptionItemAuthorRatingDescription) {
		this.subscriptionItemAuthorRatingDescription = subscriptionItemAuthorRatingDescription == null ? null
				: subscriptionItemAuthorRatingDescription.trim();
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.CertificatePath
	 * 
	 * @return the value of sbnmembersubscription.CertificatePath
	 * 
	 */
	public String getCertificatePath() {
		return certificatePath;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.CertificatePath
	 * 
	 * @param certificatePath
	 *            the value for sbnmembersubscription.CertificatePath
	 * 
	 */
	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath == null ? null : certificatePath
				.trim();
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.MemberRoleId
	 * 
	 * @return the value of sbnmembersubscription.MemberRoleId
	 * 
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for sbnmembersubscription.MemberRoleId
	 * 
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.LearningProgramId
	 * 
	 * @return the value of sbnmembersubscription.LearningProgramId
	 * 
	 */
	public Integer getLearningProgramId() {
		return learningProgramId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.LearningProgramId
	 * 
	 * @param learningProgramId
	 *            the value for sbnmembersubscription.LearningProgramId
	 * 
	 */
	public void setLearningProgramId(Integer learningProgramId) {
		this.learningProgramId = learningProgramId;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnmembersubscription.CurriculumDeliveryId
	 * 
	 * @return the value of sbnmembersubscription.CurriculumDeliveryId
	 * 
	 */
	public Integer getCurriculumDeliveryId() {
		return curriculumDeliveryId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnmembersubscription.CurriculumDeliveryId
	 * 
	 * @param curriculumDeliveryId
	 *            the value for sbnmembersubscription.CurriculumDeliveryId
	 * 
	 */
	public void setCurriculumDeliveryId(Integer curriculumDeliveryId) {
		this.curriculumDeliveryId = curriculumDeliveryId;
	}
}