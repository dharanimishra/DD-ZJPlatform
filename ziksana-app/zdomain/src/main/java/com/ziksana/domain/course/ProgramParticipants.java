package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class ProgramParticipants implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1061941286990583989L;
	/**
	 * This field corresponds to the database column corprogramparticipants.progParticipantsId
	 */
	private Integer progParticipantsId;
	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.StartDate
	 */
	private Date startDate;
	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.EndDate
	 */
	private Date endDate;
	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.ParticipatingType
	 */
	private Integer participatingType;
	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.ParticipationDescription
	 */
	private String participationDescription;
	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.ExternalIndicator
	 */
	private Boolean externalIndicator;

	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.certifiesIndicator
	 */
	private Boolean certifiesIndicator;

	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.certificationType
	 */
	private Integer certificationType;

	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.certificationTemplatePath
	 */
	private String certificationTemplatePath;
	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.MemberRoleId
	 */
	private Integer memberRoleId;
	/**
	 * This field corresponds to the database column
	 * corprogramparticipants.LearningProgramId
	 */
	private Integer learningProgramId;

	/**
	 * This method returns the value of the database column
	 * corprogramparticipants.progParticipantsId
	 * 
	 * @return the value of corprogramparticipants.progParticipantsId
	 */
	public Integer getProgParticipantsId() {
		return progParticipantsId;
	}

	/**
	 * This method sets the value of the database column
	 * corprogramparticipants.progParticipantsId
	 * 
	 * @param progParticipantsId
	 *            the value for corprogramparticipants.progParticipantsId
	 */
	public void setProgParticipantsId(Integer progParticipantsId) {
		this.progParticipantsId = progParticipantsId;
	}

	/**
	 * This method returns the value of the database column
	 * corprogramparticipants.StartDate
	 * 
	 * @return the value of corprogramparticipants.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method sets the value of the database column
	 * corprogramparticipants.StartDate
	 * 
	 * @param startDate
	 *            the value for corprogramparticipants.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method returns the value of the database column
	 * corprogramparticipants.EndDate
	 * 
	 * @return the value of corprogramparticipants.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method sets the value of the database column
	 * corprogramparticipants.EndDate
	 * 
	 * @param endDate
	 *            the value for corprogramparticipants.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method returns the value of the database column
	 * corprogramparticipants.ParticipatingType
	 * 
	 * @return the value of corprogramparticipants.ParticipatingType
	 */
	public Integer getParticipatingType() {
		return participatingType;
	}

	/**
	 * This method sets the value of the database column
	 * corprogramparticipants.ParticipatingType
	 * 
	 * @param participatingType
	 *            the value for corprogramparticipants.ParticipatingType
	 */
	public void setParticipatingType(Integer participatingType) {
		this.participatingType = participatingType;
	}

	/**
	 * This method returns the value of the database column
	 * corprogramparticipants.ParticipationDescription
	 * 
	 * @return the value of corprogramparticipants.ParticipationDescription
	 */
	public String getParticipationDescription() {
		return participationDescription;
	}

	/**
	 * This method sets the value of the database column
	 * corprogramparticipants.ParticipationDescription
	 * 
	 * @param participationDescription
	 *            the value for corprogramparticipants.ParticipationDescription
	 */
	public void setParticipationDescription(String participationDescription) {
		this.participationDescription = participationDescription == null ? null
				: participationDescription.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corprogramparticipants.ExternalIndicator
	 * 
	 * @return the value of corprogramparticipants.ExternalIndicator
	 */
	public Boolean getExternalIndicator() {
		return externalIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corprogramparticipants.ExternalIndicator
	 * 
	 * @param externalIndicator
	 *            the value for corprogramparticipants.ExternalIndicator
	 */
	public void setExternalIndicator(Boolean externalIndicator) {
		this.externalIndicator = externalIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corprogramparticipants.MemberRoleId
	 * 
	 * @return the value of corprogramparticipants.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corprogramparticipants.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corprogramparticipants.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * This method returns the value of the database column
	 * corprogramparticipants.LearningProgramId
	 * 
	 * @return the value of corprogramparticipants.LearningProgramId
	 */
	public Integer getLearningProgramId() {
		return learningProgramId;
	}

	/**
	 * This method sets the value of the database column
	 * corprogramparticipants.LearningProgramId
	 * 
	 * @param LearningProgramId
	 *            the value for corprogramparticipants.LearningProgramId
	 */
	public void setLearningProgramId(Integer learningProgramId) {
		this.learningProgramId = learningProgramId;
	}

	/**
	 * @return the certifiesIndicator
	 */
	public Boolean getCertifiesIndicator() {
		return certifiesIndicator;
	}

	/**
	 * @param certifiesIndicator
	 *            the certifiesIndicator to set
	 */
	public void setCertifiesIndicator(Boolean certifiesIndicator) {
		this.certifiesIndicator = certifiesIndicator;
	}

	/**
	 * @return the certificationType
	 */
	public Integer getCertificationType() {
		return certificationType;
	}

	/**
	 * @param certificationType
	 *            the certificationType to set
	 */
	public void setCertificationType(Integer certificationType) {
		this.certificationType = certificationType;
	}

	/**
	 * @return the certificationTemplatePath
	 */
	public String getCertificationTemplatePath() {
		return certificationTemplatePath;
	}

	/**
	 * @param certificationTemplatePath
	 *            the certificationTemplatePath to set
	 */
	public void setCertificationTemplatePath(String certificationTemplatePath) {
		this.certificationTemplatePath = certificationTemplatePath;
	}
}