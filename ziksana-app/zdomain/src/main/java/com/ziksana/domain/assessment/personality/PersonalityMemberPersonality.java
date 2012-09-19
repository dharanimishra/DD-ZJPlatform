package com.ziksana.domain.assessment.personality;

import java.util.Date;

public class PersonalityMemberPersonality {

	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.MemberPersonalityId
	 */
	private Integer memberPersonalityId;
	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.CreationDate
	 */
	private Date creationDate;
	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.PersonalityType
	 */
	private Integer personalityType;
	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.Characteristic
	 */
	private String characteristic;
	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.Cluster
	 */
	private String cluster;
	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.Quotient
	 */
	private String quotient;
	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.Certificate
	 */
	private String certificate;
	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.MemberId
	 */
	private Integer memberId;
	/**
	 * This field corresponds to the database column
	 * pstmemberpersonality.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.MemberPersonalityId
	 * 
	 * @return the value of pstmemberpersonality.MemberPersonalityId
	 */
	public Integer getMemberPersonalityId() {
		return memberPersonalityId;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.MemberPersonalityId
	 * 
	 * @param memberPersonalityId
	 *            the value for pstmemberpersonality.MemberPersonalityId
	 */
	public void setMemberPersonalityId(Integer memberPersonalityId) {
		this.memberPersonalityId = memberPersonalityId;
	}

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.CreationDate
	 * 
	 * @return the value of pstmemberpersonality.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.CreationDate
	 * 
	 * @param creationDate
	 *            the value for pstmemberpersonality.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.PersonalityType
	 * 
	 * @return the value of pstmemberpersonality.PersonalityType
	 */
	public Integer getPersonalityType() {
		return personalityType;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.PersonalityType
	 * 
	 * @param personalityType
	 *            the value for pstmemberpersonality.PersonalityType
	 */
	public void setPersonalityType(Integer personalityType) {
		this.personalityType = personalityType;
	}

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.Characteristic
	 * 
	 * @return the value of pstmemberpersonality.Characteristic
	 */
	public String getCharacteristic() {
		return characteristic;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.Characteristic
	 * 
	 * @param characteristic
	 *            the value for pstmemberpersonality.Characteristic
	 */
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic == null ? null : characteristic
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.Cluster
	 * 
	 * @return the value of pstmemberpersonality.Cluster
	 */
	public String getCluster() {
		return cluster;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.Cluster
	 * 
	 * @param cluster
	 *            the value for pstmemberpersonality.Cluster
	 */
	public void setCluster(String cluster) {
		this.cluster = cluster == null ? null : cluster.trim();
	}

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.Quotient
	 * 
	 * @return the value of pstmemberpersonality.Quotient
	 */
	public String getQuotient() {
		return quotient;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.Quotient
	 * 
	 * @param quotient
	 *            the value for pstmemberpersonality.Quotient
	 */
	public void setQuotient(String quotient) {
		this.quotient = quotient == null ? null : quotient.trim();
	}

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.Certificate
	 * 
	 * @return the value of pstmemberpersonality.Certificate
	 */
	public String getCertificate() {
		return certificate;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.Certificate
	 * 
	 * @param certificate
	 *            the value for pstmemberpersonality.Certificate
	 */
	public void setCertificate(String certificate) {
		this.certificate = certificate == null ? null : certificate.trim();
	}

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.MemberId
	 * 
	 * @return the value of pstmemberpersonality.MemberId
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.MemberId
	 * 
	 * @param memberId
	 *            the value for pstmemberpersonality.MemberId
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * This method returns the value of the database column
	 * pstmemberpersonality.MemberRoleId
	 * 
	 * @return the value of pstmemberpersonality.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * pstmemberpersonality.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for pstmemberpersonality.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}