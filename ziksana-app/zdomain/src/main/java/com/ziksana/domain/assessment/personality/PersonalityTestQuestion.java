package com.ziksana.domain.assessment.personality;

public class PersonalityTestQuestion {

	/**
	 * This field corresponds to the database column
	 * psttestquestion.TestQuestionId
	 */
	private Integer testQuestionId;
	/**
	 * This field corresponds to the database column psttestquestion.Sequence
	 */
	private Integer sequence;
	/**
	 * This field corresponds to the database column psttestquestion.VersionUsed
	 */
	private Integer versionUsed;
	/**
	 * This field corresponds to the database column psttestquestion.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column psttestquestion.TestId
	 */
	private Integer testId;
	/**
	 * This field corresponds to the database column
	 * psttestquestion.QuestionBankId
	 */
	private Integer questionBankId;

	/**
	 * This method returns the value of the database column
	 * psttestquestion.TestQuestionId
	 * 
	 * @return the value of psttestquestion.TestQuestionId
	 */
	public Integer getTestQuestionId() {
		return testQuestionId;
	}

	/**
	 * This method sets the value of the database column
	 * psttestquestion.TestQuestionId
	 * 
	 * @param testQuestionId
	 *            the value for psttestquestion.TestQuestionId
	 */
	public void setTestQuestionId(Integer testQuestionId) {
		this.testQuestionId = testQuestionId;
	}

	/**
	 * This method returns the value of the database column
	 * psttestquestion.Sequence
	 * 
	 * @return the value of psttestquestion.Sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * This method sets the value of the database column
	 * psttestquestion.Sequence
	 * 
	 * @param sequence
	 *            the value for psttestquestion.Sequence
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * This method returns the value of the database column
	 * psttestquestion.VersionUsed
	 * 
	 * @return the value of psttestquestion.VersionUsed
	 */
	public Integer getVersionUsed() {
		return versionUsed;
	}

	/**
	 * This method sets the value of the database column
	 * psttestquestion.VersionUsed
	 * 
	 * @param versionUsed
	 *            the value for psttestquestion.VersionUsed
	 */
	public void setVersionUsed(Integer versionUsed) {
		this.versionUsed = versionUsed;
	}

	/**
	 * This method returns the value of the database column
	 * psttestquestion.Active
	 * 
	 * @return the value of psttestquestion.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column psttestquestion.Active
	 * 
	 * @param active
	 *            the value for psttestquestion.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * psttestquestion.TestId
	 * 
	 * @return the value of psttestquestion.TestId
	 */
	public Integer getTestId() {
		return testId;
	}

	/**
	 * This method sets the value of the database column psttestquestion.TestId
	 * 
	 * @param testId
	 *            the value for psttestquestion.TestId
	 */
	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	/**
	 * This method returns the value of the database column
	 * psttestquestion.QuestionBankId
	 * 
	 * @return the value of psttestquestion.QuestionBankId
	 */
	public Integer getQuestionBankId() {
		return questionBankId;
	}

	/**
	 * This method sets the value of the database column
	 * psttestquestion.QuestionBankId
	 * 
	 * @param questionBankId
	 *            the value for psttestquestion.QuestionBankId
	 */
	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}
}