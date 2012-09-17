package com.ziksana.domain.assessment;

import java.util.Date;

public class QuestionBank {

	/**
	 * This field corresponds to the database column
	 * asmquestionbank.QuestionBankId
	 */
	private Integer questionBankId;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.CreationDate
	 */
	private Date creationDate;
	/**
	 * This field corresponds to the database column asmquestionbank.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.DifficultyLevel
	 */
	private Integer difficultyLevel;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.ProficiencyLevel
	 */
	private Integer proficiencyLevel;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.QuestionType
	 */
	private Integer questionType;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.QuestionContent
	 */
	private String questionContent;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.AdditionalInfoPath
	 */
	private String additionalInfoPath;
	/**
	 * This field corresponds to the database column asmquestionbank.Instruction
	 */
	private String instruction;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.MultipleCorrectAnswerIndicator
	 */
	private Boolean multipleCorrectAnswerIndicator;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.GroupWorkIndicator
	 */
	private Boolean groupWorkIndicator;
	/**
	 * This field corresponds to the database column asmquestionbank.Status
	 */
	private Integer status;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.QuestionApplicabilityType
	 */
	private Integer questionApplicabilityType;
	/**
	 * This field corresponds to the database column
	 * asmquestionbank.SubjClassificationId
	 */
	private Integer subjClassificationId;
	/**
	 * This field corresponds to the database column asmquestionbank.MemberId
	 */
	private Integer memberId;

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.QuestionBankId
	 * 
	 * @return the value of asmquestionbank.QuestionBankId
	 */
	public Integer getQuestionBankId() {
		return questionBankId;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.QuestionBankId
	 * 
	 * @param questionBankId
	 *            the value for asmquestionbank.QuestionBankId
	 */
	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.CreationDate
	 * 
	 * @return the value of asmquestionbank.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.CreationDate
	 * 
	 * @param creationDate
	 *            the value for asmquestionbank.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.Active
	 * 
	 * @return the value of asmquestionbank.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column asmquestionbank.Active
	 * 
	 * @param active
	 *            the value for asmquestionbank.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.DifficultyLevel
	 * 
	 * @return the value of asmquestionbank.DifficultyLevel
	 */
	public Integer getDifficultyLevel() {
		return difficultyLevel;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.DifficultyLevel
	 * 
	 * @param difficultyLevel
	 *            the value for asmquestionbank.DifficultyLevel
	 */
	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.ProficiencyLevel
	 * 
	 * @return the value of asmquestionbank.ProficiencyLevel
	 */
	public Integer getProficiencyLevel() {
		return proficiencyLevel;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.ProficiencyLevel
	 * 
	 * @param proficiencyLevel
	 *            the value for asmquestionbank.ProficiencyLevel
	 */
	public void setProficiencyLevel(Integer proficiencyLevel) {
		this.proficiencyLevel = proficiencyLevel;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.QuestionType
	 * 
	 * @return the value of asmquestionbank.QuestionType
	 */
	public Integer getQuestionType() {
		return questionType;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.QuestionType
	 * 
	 * @param questionType
	 *            the value for asmquestionbank.QuestionType
	 */
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.QuestionContent
	 * 
	 * @return the value of asmquestionbank.QuestionContent
	 */
	public String getQuestionContent() {
		return questionContent;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.QuestionContent
	 * 
	 * @param questionContent
	 *            the value for asmquestionbank.QuestionContent
	 */
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent == null ? null : questionContent
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.AdditionalInfoPath
	 * 
	 * @return the value of asmquestionbank.AdditionalInfoPath
	 */
	public String getAdditionalInfoPath() {
		return additionalInfoPath;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.AdditionalInfoPath
	 * 
	 * @param additionalInfoPath
	 *            the value for asmquestionbank.AdditionalInfoPath
	 */
	public void setAdditionalInfoPath(String additionalInfoPath) {
		this.additionalInfoPath = additionalInfoPath == null ? null
				: additionalInfoPath.trim();
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.Instruction
	 * 
	 * @return the value of asmquestionbank.Instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.Instruction
	 * 
	 * @param instruction
	 *            the value for asmquestionbank.Instruction
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction == null ? null : instruction.trim();
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.MultipleCorrectAnswerIndicator
	 * 
	 * @return the value of asmquestionbank.MultipleCorrectAnswerIndicator
	 */
	public Boolean getMultipleCorrectAnswerIndicator() {
		return multipleCorrectAnswerIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.MultipleCorrectAnswerIndicator
	 * 
	 * @param multipleCorrectAnswerIndicator
	 *            the value for asmquestionbank.MultipleCorrectAnswerIndicator
	 */
	public void setMultipleCorrectAnswerIndicator(
			Boolean multipleCorrectAnswerIndicator) {
		this.multipleCorrectAnswerIndicator = multipleCorrectAnswerIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.GroupWorkIndicator
	 * 
	 * @return the value of asmquestionbank.GroupWorkIndicator
	 */
	public Boolean getGroupWorkIndicator() {
		return groupWorkIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.GroupWorkIndicator
	 * 
	 * @param groupWorkIndicator
	 *            the value for asmquestionbank.GroupWorkIndicator
	 */
	public void setGroupWorkIndicator(Boolean groupWorkIndicator) {
		this.groupWorkIndicator = groupWorkIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.Status
	 * 
	 * @return the value of asmquestionbank.Status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method sets the value of the database column asmquestionbank.Status
	 * 
	 * @param status
	 *            the value for asmquestionbank.Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.QuestionApplicabilityType
	 * 
	 * @return the value of asmquestionbank.QuestionApplicabilityType
	 */
	public Integer getQuestionApplicabilityType() {
		return questionApplicabilityType;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.QuestionApplicabilityType
	 * 
	 * @param questionApplicabilityType
	 *            the value for asmquestionbank.QuestionApplicabilityType
	 */
	public void setQuestionApplicabilityType(Integer questionApplicabilityType) {
		this.questionApplicabilityType = questionApplicabilityType;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.SubjClassificationId
	 * 
	 * @return the value of asmquestionbank.SubjClassificationId
	 */
	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.SubjClassificationId
	 * 
	 * @param subjClassificationId
	 *            the value for asmquestionbank.SubjClassificationId
	 */
	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	/**
	 * This method returns the value of the database column
	 * asmquestionbank.MemberId
	 * 
	 * @return the value of asmquestionbank.MemberId
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * This method sets the value of the database column
	 * asmquestionbank.MemberId
	 * 
	 * @param memberId
	 *            the value for asmquestionbank.MemberId
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
}