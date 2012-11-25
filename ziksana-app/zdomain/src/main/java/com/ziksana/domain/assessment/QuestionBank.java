package com.ziksana.domain.assessment;

import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.Member;
import com.ziksana.domain.utils.SubjectClassification;
import com.ziksana.id.ZID;

public class QuestionBank extends AuditHistory{


	public QuestionBank(Boolean active, DifficultyLevel difficultyLevel,
			ProficiencyLevel proficiencyLevel, QuestionType questionType,
			String questionText, String instruction,
			QuestionApplicableType questionApplicableType, Member owningMember) {
		this.active = active;
		this.difficultyLevel = difficultyLevel;
		this.proficiencyLevel = proficiencyLevel;
		this.questionType = questionType;
		this.questionText = questionText;
		this.instruction = instruction;
		this.questionApplicableType = questionApplicableType;
		this.owningMember = owningMember;
	}

	private ZID 					questionBankId;
	private Date 					creationDate					= null;
	private Boolean 				active							= null;
	private DifficultyLevel 		difficultyLevel					= null;
	private Integer			 		difficultyLevelId				= null;
	private ProficiencyLevel 		proficiencyLevel				= null;
	private Integer 				proficiencyLevelId				= null;
	private QuestionType 			questionType					= null;
	private Integer		 			questionTypeId					= null;
	private String 					questionText					= null;//question content
	private String 					additionalInfoPath				= null;
	private String 					instruction						= null;
	private Boolean 				multipleAnswerIndicator			= null;
	private Boolean 				groupWorkIndicator				= null;
	private Status 					status							= null;
	private Integer 				statusId						= null;
	private QuestionApplicableType 	questionApplicableType			= null;
	private Integer 				questionApplicableTypeId		= null;
	private SubjectClassification 	subjClassification				= null;
	private Member 					owningMember					= null;
	private List<QuestionTagcloud>	qtnTagCloudList					= null;
	private QuestionVisual			qtnVisual						= null;
	private QuestionBankAnswer		qtnBankAnswer					= null;

	/*private TestQuestion      	question						= null;
	private NextBestQuestion		nextBestQtn						= null;		
	*/
	
	/**
	 * @return the questionBankId
	 */
	public ZID getQuestionBankId() {
		return questionBankId;
	}
	/**
	 * @param questionBankId the questionBankId to set
	 */
	public void setQuestionBankId(ZID questionBankId) {
		this.questionBankId = questionBankId;
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
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the difficultyLevel
	 */
	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}
	/**
	 * @param difficultyLevel the difficultyLevel to set
	 */
	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	/**
	 * @return the difficultyLevelId
	 */
	public Integer getDifficultyLevelId() {
		return difficultyLevelId;
	}
	/**
	 * @param difficultyLevelId the difficultyLevelId to set
	 */
	public void setDifficultyLevelId(Integer difficultyLevelId) {
		this.difficultyLevelId = difficultyLevelId;
	}
	/**
	 * @return the proficiencyLevel
	 */
	public ProficiencyLevel getProficiencyLevel() {
		return proficiencyLevel;
	}
	/**
	 * @param proficiencyLevel the proficiencyLevel to set
	 */
	public void setProficiencyLevel(ProficiencyLevel proficiencyLevel) {
		this.proficiencyLevel = proficiencyLevel;
	}
	/**
	 * @return the proficiencyLevelId
	 */
	public Integer getProficiencyLevelId() {
		return proficiencyLevelId;
	}
	/**
	 * @param proficiencyLevelId the proficiencyLevelId to set
	 */
	public void setProficiencyLevelId(Integer proficiencyLevelId) {
		this.proficiencyLevelId = proficiencyLevelId;
	}
	/**
	 * @return the questionType
	 */
	public QuestionType getQuestionType() {
		return questionType;
	}
	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	/**
	 * @return the questionTypeId
	 */
	public Integer getQuestionTypeId() {
		return questionTypeId;
	}
	/**
	 * @param questionTypeId the questionTypeId to set
	 */
	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}
	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	/**
	 * @return the additionalInfoPath
	 */
	public String getAdditionalInfoPath() {
		return additionalInfoPath;
	}
	/**
	 * @param additionalInfoPath the additionalInfoPath to set
	 */
	public void setAdditionalInfoPath(String additionalInfoPath) {
		this.additionalInfoPath = additionalInfoPath;
	}
	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}
	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	/**
	 * @return the groupWorkIndicator
	 */
	public Boolean getGroupWorkIndicator() {
		return groupWorkIndicator;
	}
	/**
	 * @param groupWorkIndicator the groupWorkIndicator to set
	 */
	public void setGroupWorkIndicator(Boolean groupWorkIndicator) {
		this.groupWorkIndicator = groupWorkIndicator;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	/**
	 * @return the questionApplicableType
	 */
	public QuestionApplicableType getQuestionApplicableType() {
		return questionApplicableType;
	}
	/**
	 * @param questionApplicableType the questionApplicableType to set
	 */
	public void setQuestionApplicableType(
			QuestionApplicableType questionApplicableType) {
		this.questionApplicableType = questionApplicableType;
	}
	/**
	 * @return the questionApplicableTypeId
	 */
	public Integer getQuestionApplicableTypeId() {
		return questionApplicableTypeId;
	}
	/**
	 * @param questionApplicableTypeId the questionApplicableTypeId to set
	 */
	public void setQuestionApplicableTypeId(Integer questionApplicableTypeId) {
		this.questionApplicableTypeId = questionApplicableTypeId;
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
	 * @return the owningMember
	 */
	public Member getOwningMember() {
		return owningMember;
	}
	/**
	 * @param owningMember the owningMember to set
	 */
	public void setOwningMember(Member owningMember) {
		this.owningMember = owningMember;
	}
	/**
	 * @return the qtnTagCloudList
	 */
	public List<QuestionTagcloud> getQtnTagCloudList() {
		return qtnTagCloudList;
	}
	/**
	 * @param qtnTagCloudList the qtnTagCloudList to set
	 */
	public void setQtnTagCloudList(List<QuestionTagcloud> qtnTagCloudList) {
		this.qtnTagCloudList = qtnTagCloudList;
	}
	/**
	 * @return the qtnVisual
	 */
	public QuestionVisual getQtnVisual() {
		return qtnVisual;
	}
	/**
	 * @param qtnVisual the qtnVisual to set
	 */
	public void setQtnVisual(QuestionVisual qtnVisual) {
		this.qtnVisual = qtnVisual;
	}
	/**
	 * @return the multipleAnswerIndicator
	 */
	public Boolean getMultipleAnswerIndicator() {
		return multipleAnswerIndicator;
	}
	/**
	 * @param multipleAnswerIndicator the multipleAnswerIndicator to set
	 */
	public void setMultipleAnswerIndicator(Boolean multipleAnswerIndicator) {
		this.multipleAnswerIndicator = multipleAnswerIndicator;
	}

	/**
	 * @return the qtnBankAnswer
	 */
	public QuestionBankAnswer getQtnBankAnswer() {
		return qtnBankAnswer;
	}
	/**
	 * @param qtnBankAnswer the qtnBankAnswer to set
	 */
	public void setQtnBankAnswer(QuestionBankAnswer qtnBankAnswer) {
		this.qtnBankAnswer = qtnBankAnswer;
	}
	/**
	 * @return the question
	 *//*
	public TestQuestion getQuestion() {
		return question;
	}
	*//**
	 * @param question the question to set
	 *//*
	public void setQuestion(TestQuestion question) {
		this.question = question;
	}
	*//**
	 * @return the qtnBankAnswer
	 *//*
	public QuestionBankAnswer getQtnBankAnswer() {
		return qtnBankAnswer;
	}

	*//**
	 * @param qtnBankAnswer the qtnBankAnswer to set
	 *//*
	public void setQtnBankAnswer(QuestionBankAnswer qtnBankAnswer) {
		this.qtnBankAnswer = qtnBankAnswer;
	}

	*//**
	 * @return the qtnTagCloud
	 *//*
	public QuestionTagcloud getQtnTagCloud() {
		return qtnTagCloud;
	}
	*//**
	 * @param qtnTagCloud the qtnTagCloud to set
	 *//*
	public void setQtnTagCloud(QuestionTagcloud qtnTagCloud) {
		this.qtnTagCloud = qtnTagCloud;
	}
	*//**
	 * @return the qtnVisual
	 *//*
	public QuestionVisual getQtnVisual() {
		return qtnVisual;
	}
	*//**
	 * @param qtnVisual the qtnVisual to set
	 *//*
	public void setQtnVisual(QuestionVisual qtnVisual) {
		this.qtnVisual = qtnVisual;
	}
	*//**
	 * @return the nextBestQtn
	 *//*
	public NextBestQuestion getNextBestQtn() {
		return nextBestQtn;
	}
	*//**
	 * @param nextBestQtn the nextBestQtn to set
	 *//*
	public void setNextBestQtn(NextBestQuestion nextBestQtn) {
		this.nextBestQtn = nextBestQtn;
	}
*/	@Override
	public String toString() {
		return "QuestionBank [difficultyLevel=" + difficultyLevel
				+ ", proficiencyLevel=" + proficiencyLevel + ", questionType="
				+ questionType + ", questionText=" + questionText
				+ ", instruction=" + instruction + ", status=" + status
				+ ", questionApplicableType=" + questionApplicableType + "]";
	}
	
}