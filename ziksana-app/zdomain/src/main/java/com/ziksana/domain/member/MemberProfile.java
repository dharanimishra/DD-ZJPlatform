package com.ziksana.domain.member;

public class MemberProfile {

	private int profileId;
	
	private int memberId;
	
	private String securityQuestionId;
	
	private String securityQuestionText;
	
	private String memberAnswer;
	
	private String alternateEmailId;
	
	private int active;

	/**
	 * @return the profileId
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId
	 *            the profileId to set
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	
	/**
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the securityQuestionId
	 */
	public String getSecurityQuestionId() {
		return securityQuestionId;
	}

	/**
	 * @param securityQuestionId
	 *            the securityQuestionId to set
	 */
	public void setSecurityQuestionId(String securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	/**
	 * @return the securityQuestionText
	 */
	public String getSecurityQuestionText() {
		return securityQuestionText;
	}

	/**
	 * @param securityQuestionText
	 *            the securityQuestionText to set
	 */
	public void setSecurityQuestionText(String securityQuestionText) {
		this.securityQuestionText = securityQuestionText;
	}

	/**
	 * @return the memberAnswer
	 */
	public String getMemberAnswer() {
		return memberAnswer;
	}

	/**
	 * @param memberAnswer
	 *            the memberAnswer to set
	 */
	public void setMemberAnswer(String memberAnswer) {
		this.memberAnswer = memberAnswer;
	}

	/**
	 * @return the alternateEmailId
	 */
	public String getAlternateEmailId() {
		return alternateEmailId;
	}

	/**
	 * @param alternateEmailId
	 *            the alternateEmailId to set
	 */
	public void setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}

	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

}
