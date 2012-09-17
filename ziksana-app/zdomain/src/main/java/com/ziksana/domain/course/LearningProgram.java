package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class LearningProgram implements Serializable {
	/**
	 */
	private static final long serialVersionUID = 5761244172083794586L;

	/**
	 * This field corresponds to the database column coracademicprogram.learningProgramId
	 */
	private Integer learningProgramId;

	/**
	 * This field corresponds to the database column
	 * coracademicprogram.ProgramName
	 */
	private String programName;

	/**
	 * This field corresponds to the database column
	 * coracademicprogram.ProgramStarDate
	 */
	private Date programStarDate;

	/**
	 * This field corresponds to the database column
	 * coracademicprogram.ProgramEndDate
	 */
	private Date programEndDate;

	/**
	 * This field corresponds to the database column
	 * coracademicprogram.ProgramDescription
	 */
	private String programDescription;

	/**
	 * This field corresponds to the database column
	 * coracademicprogram.ProgramRating
	 */
	private Integer programRating;

	/**
	 * This field corresponds to the database column
	 * coracademicprogram.ProgramType
	 */
	private Integer programType;

	/**
	 * This field corresponds to the database column
	 * coracademicprogram.ExclusivetoZiksanaIndicator
	 */
	private Boolean exclusivetoZiksanaIndicator;

	/**
	 * This field corresponds to the database column
	 * coracademicprogram.ProgramIdentifier
	 */
	private String programIdentifier;

	private Integer certificateType;
	
	private Integer programDuration;
	
	private Integer institutionId;
	/**
	 * This field corresponds to the database column coracademicprogram.Version
	 */
	private Integer version;
	

	//private List<ProgrammCurriculum> corProgramCurriculums;
/*	private List<CorProgramParticipants> corProgramParticipants;
	private List<CorProgrammCurriculumPlaybook> progCurrPlaybookList;
	private List<MemberSubscriptionProgramm> memSubscProgramList;
	private List<LearningElementPricing> learningElementPricinList;
*/	
	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.learningProgramId
	 * @return the value of coracademicprogram.learningProgramId
	 */
	public Integer getLearningProgramId() {
		return learningProgramId;
	}

	/**
	 * . This method sets the value of the database column coracademicprogram.learningProgramId
	 * 
	 * @param ID
	 *            the value for coracademicprogram.learningProgramId
	 */
	public void setLearningProgramId(Integer learningProgramId) {
		this.learningProgramId = learningProgramId;
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.ProgramName
	 * 
	 * @return the value of coracademicprogram.ProgramName
	 */
	public String getProgramName() {
		return programName;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.ProgramName
	 * 
	 * @param programName
	 *            the value for coracademicprogram.ProgramName
	 */
	public void setProgramName(String programName) {
		this.programName = programName == null ? null : programName.trim();
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.ProgramStarDate
	 * 
	 * @return the value of coracademicprogram.ProgramStarDate
	 */
	public Date getProgramStarDate() {
		return programStarDate;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.ProgramStarDate
	 * 
	 * @param programStarDate
	 *            the value for coracademicprogram.ProgramStarDate
	 */
	public void setProgramStarDate(Date programStarDate) {
		this.programStarDate = programStarDate;
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.ProgramEndDate
	 * 
	 * @return the value of coracademicprogram.ProgramEndDate
	 */
	public Date getProgramEndDate() {
		return programEndDate;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.ProgramEndDate
	 * 
	 * @param programEndDate
	 *            the value for coracademicprogram.ProgramEndDate
	 */
	public void setProgramEndDate(Date programEndDate) {
		this.programEndDate = programEndDate;
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.ProgramDescription
	 * 
	 * @return the value of coracademicprogram.ProgramDescription
	 */
	public String getProgramDescription() {
		return programDescription;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.ProgramDescription
	 * 
	 * @param programDescription
	 *            the value for coracademicprogram.ProgramDescription
	 */
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription == null ? null
				: programDescription.trim();
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.ProgramRating
	 * 
	 * @return the value of coracademicprogram.ProgramRating
	 */
	public Integer getProgramRating() {
		return programRating;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.ProgramRating
	 * 
	 * @param programRating
	 *            the value for coracademicprogram.ProgramRating
	 */
	public void setProgramRating(Integer programRating) {
		this.programRating = programRating;
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.ProgramType
	 * 
	 * @return the value of coracademicprogram.ProgramType
	 */
	public Integer getProgramType() {
		return programType;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.ProgramType
	 * 
	 * @param programType
	 *            the value for coracademicprogram.ProgramType
	 */
	public void setProgramType(Integer programType) {
		this.programType = programType;
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.ExclusivetoZiksanaIndicator
	 * 
	 * @return the value of coracademicprogram.ExclusivetoZiksanaIndicator
	 */
	public Boolean getExclusivetoZiksanaIndicator() {
		return exclusivetoZiksanaIndicator;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.ExclusivetoZiksanaIndicator
	 * 
	 * @param exclusivetoZiksanaIndicator
	 *            the value for coracademicprogram.ExclusivetoZiksanaIndicator
	 */
	public void setExclusivetoZiksanaIndicator(
			Boolean exclusivetoZiksanaIndicator) {
		this.exclusivetoZiksanaIndicator = exclusivetoZiksanaIndicator;
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.ProgramIdentifier
	 * 
	 * @return the value of coracademicprogram.ProgramIdentifier
	 */
	public String getProgramIdentifier() {
		return programIdentifier;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.ProgramIdentifier
	 * 
	 * @param programIdentifier
	 *            the value for coracademicprogram.ProgramIdentifier
	 */
	public void setProgramIdentifier(String programIdentifier) {
		this.programIdentifier = programIdentifier == null ? null
				: programIdentifier.trim();
	}

	public Integer getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * . This method returns the value of the database column
	 * coracademicprogram.Version
	 * 
	 * @return the value of coracademicprogram.Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * . This method sets the value of the database column
	 * coracademicprogram.Version
	 * 
	 * @param version
	 *            the value for coracademicprogram.Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

/*	*//**
	 * @return the corProgramCurriculums
	 *//*
	public List<ProgrammCurriculum> getCorProgramCurriculums() {
		return corProgramCurriculums;
	}

	*//**
	 * @param corProgramCurriculums
	 *            the corProgramCurriculums to set
	 *//*
	public void setCorProgramCurriculums(
			List<ProgrammCurriculum> corProgramCurriculums) {
		this.corProgramCurriculums = corProgramCurriculums;
	}
*/
	/**
	 * @return the programDuration
	 */
	public Integer getProgramDuration() {
		return programDuration;
	}

	/**
	 * @param programDuration the programDuration to set
	 */
	public void setProgramDuration(Integer programDuration) {
		this.programDuration = programDuration;
	}

	/**
	 * @return the certificateType
	 */
	public Integer getCertificateType() {
		return certificateType;
	}

	/**
	 * @param certificateType the certificateType to set
	 */
	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	/*	*//**
	 * @return the corProgramParticipants
	 */
	/*
	 * public List<CorProgramParticipants> getCorProgramParticipants() { return
	 * corProgramParticipants; }
	 *//**
	 * @param corProgramParticipants
	 *            the corProgramParticipants to set
	 */
	/*
	 * public void setCorProgramParticipants( List<CorProgramParticipants>
	 * corProgramParticipants) { this.corProgramParticipants =
	 * corProgramParticipants; }
	 */
}