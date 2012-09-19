package com.ziksana.domain.course.subscription;

public class ParticipationStatistics {
	/**
	 * 
	 * This field corresponds to the database column
	 * sbnparticipationstatistics.participationStatisticsId
	 * 
	 */
	private Integer participationStatisticsId;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnparticipationstatistics.CreationDate
	 * 
	 */
	private String creationDate;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnparticipationstatistics.ParticipationParameterName
	 * 
	 */
	private Integer participationParameterName;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnparticipationstatistics.ParticipationParameterValue
	 * 
	 */
	private String participationParameterValue;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnparticipationstatistics.Status
	 * 
	 */
	private Integer status;

	/**
	 * 
	 * This field corresponds to the database column
	 * sbnparticipationstatistics.SubscriptionCourseId
	 * 
	 */
	private Integer subscriptionCourseId;

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnparticipationstatistics.participationStatisticsId
	 * 
	 * @return the value of sbnparticipationstatistics.participationStatisticsId
	 * 
	 */
	public Integer getParticipationStatisticsId() {
		return participationStatisticsId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnparticipationstatistics.participationStatisticsId
	 * 
	 * @param participationStatisticsId
	 *            the value for sbnparticipationstatistics.participationStatisticsId
	 * 
	 */
	public void setParticipationStatisticsId(Integer participationStatisticsId) {
		this.participationStatisticsId = participationStatisticsId;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnparticipationstatistics.CreationDate
	 * 
	 * @return the value of sbnparticipationstatistics.CreationDate
	 * 
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnparticipationstatistics.CreationDate
	 * 
	 * @param creationDate
	 *            the value for sbnparticipationstatistics.CreationDate
	 * 
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate == null ? null : creationDate.trim();
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnparticipationstatistics.ParticipationParameterName
	 * 
	 * @return the value of
	 *         sbnparticipationstatistics.ParticipationParameterName
	 * 
	 */
	public Integer getParticipationParameterName() {
		return participationParameterName;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnparticipationstatistics.ParticipationParameterName
	 * 
	 * @param participationParameterName
	 *            the value for
	 *            sbnparticipationstatistics.ParticipationParameterName
	 * 
	 */
	public void setParticipationParameterName(Integer participationParameterName) {
		this.participationParameterName = participationParameterName;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnparticipationstatistics.ParticipationParameterValue
	 * 
	 * @return the value of
	 *         sbnparticipationstatistics.ParticipationParameterValue
	 * 
	 */
	public String getParticipationParameterValue() {
		return participationParameterValue;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnparticipationstatistics.ParticipationParameterValue
	 * 
	 * @param participationParameterValue
	 *            the value for
	 *            sbnparticipationstatistics.ParticipationParameterValue
	 * 
	 */
	public void setParticipationParameterValue(
			String participationParameterValue) {
		this.participationParameterValue = participationParameterValue == null ? null
				: participationParameterValue.trim();
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnparticipationstatistics.Status
	 * 
	 * @return the value of sbnparticipationstatistics.Status
	 * 
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnparticipationstatistics.Status
	 * 
	 * @param status
	 *            the value for sbnparticipationstatistics.Status
	 * 
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * sbnparticipationstatistics.SubscriptionCourseId
	 * 
	 * @return the value of sbnparticipationstatistics.SubscriptionCourseId
	 * 
	 */
	public Integer getSubscriptionCourseId() {
		return subscriptionCourseId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * sbnparticipationstatistics.SubscriptionCourseId
	 * 
	 * @param subscriptionCourseId
	 *            the value for sbnparticipationstatistics.SubscriptionCourseId
	 * 
	 */
	public void setSubscriptionCourseId(Integer subscriptionCourseId) {
		this.subscriptionCourseId = subscriptionCourseId;
	}
}