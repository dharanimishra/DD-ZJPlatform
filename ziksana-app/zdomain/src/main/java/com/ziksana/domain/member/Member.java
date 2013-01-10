package com.ziksana.domain.member;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Member implements Serializable {
	/**
	 */
	private static final long serialVersionUID = 2142198565471578852L;

	private List<MemberPersona> memberPersonas;

	/**
	 * This field corresponds to the database column memmember.ID
	 */
	private Integer memberId;

	/**
	 * This field corresponds to the database column memmember.MemberType
	 */
	private Integer memberType;

	/**
	 * This field corresponds to the database column
	 * memmember.RelationshipStatus
	 */
	private Integer relationshipStatus;

	/**
	 * This field corresponds to the database column memmember.JoinedDate
	 */
	private Date joinedDate;

	/**
	 * This field corresponds to the database column memmember.FirstName
	 */
	private String firstName;

	/**
	 * This field corresponds to the database column memmember.LastName
	 */
	private String lastName;

	/**
	 * This field corresponds to the database column memmember.MiddleName
	 */
	private String middleName;

	/**
	 * This field corresponds to the database column memmember.NickName
	 */
	private String nickName;

	/**
	 * This field corresponds to the database column memmember.Salutation
	 */
	private Integer salutation;

	/**
	 * This field corresponds to the database column memmember.DateofBirth
	 */
	private Date dateofBirth;

	/**
	 * This field corresponds to the database column memmember.SunSign
	 */
	private Integer sunSign;

	/**
	 * This field corresponds to the database column memmember.MoonSign
	 */
	private Integer moonSign;

	/**
	 * This field corresponds to the database column memmember.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * memmember.DoNotDistrubIndicator
	 */
	private Boolean doNotDistrubIndicator;

	/**
	 * This field corresponds to the database column memmember.Gender
	 */
	private Integer gender;

	/**
	 * This field corresponds to the database column memmember.Picture
	 */
	private String picturePath;
	
	private String designation;

	/**
	 * This method returns the value of the database column memmember.ID
	 * 
	 * @return the value of memmember.ID
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * This method sets the value of the database column memmember.ID
	 * 
	 * @param ID
	 *            the value for memmember.ID
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * This method returns the value of the database column memmember.MemberType
	 * 
	 * @return the value of memmember.MemberType
	 */
	public Integer getMemberType() {
		return memberType;
	}

	/**
	 * This method sets the value of the database column memmember.MemberType
	 * 
	 * @param memberType
	 *            the value for memmember.MemberType
	 */
	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	/**
	 * This method returns the value of the database column
	 * memmember.RelationshipStatus
	 * 
	 * @return the value of memmember.RelationshipStatus
	 */
	public Integer getRelationshipStatus() {
		return relationshipStatus;
	}

	/**
	 * This method sets the value of the database column
	 * memmember.RelationshipStatus
	 * 
	 * @param relationshipStatus
	 *            the value for memmember.RelationshipStatus
	 */
	public void setRelationshipStatus(Integer relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	/**
	 * This method returns the value of the database column memmember.JoinedDate
	 * 
	 * @return the value of memmember.JoinedDate
	 */
	public Date getJoinedDate() {
		return joinedDate;
	}

	/**
	 * This method sets the value of the database column memmember.JoinedDate
	 * 
	 * @param joinedDate
	 *            the value for memmember.JoinedDate
	 */
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	/**
	 * This method returns the value of the database column memmember.FirstName
	 * 
	 * @return the value of memmember.FirstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method sets the value of the database column memmember.FirstName
	 * 
	 * @param firstName
	 *            the value for memmember.FirstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName == null ? null : firstName.trim();
	}

	/**
	 * This method returns the value of the database column memmember.LastName
	 * 
	 * @return the value of memmember.LastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method sets the value of the database column memmember.LastName
	 * 
	 * @param lastName
	 *            the value for memmember.LastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName == null ? null : lastName.trim();
	}

	/**
	 * This method returns the value of the database column memmember.MiddleName
	 * 
	 * @return the value of memmember.MiddleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * This method sets the value of the database column memmember.MiddleName
	 * 
	 * @param middleName
	 *            the value for memmember.MiddleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName == null ? null : middleName.trim();
	}

	/**
	 * This method returns the value of the database column memmember.NickName
	 * 
	 * @return the value of memmember.NickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * This method sets the value of the database column memmember.NickName
	 * 
	 * @param nickName
	 *            the value for memmember.NickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	/**
	 * This method returns the value of the database column memmember.Salutation
	 * 
	 * @return the value of memmember.Salutation
	 */
	public Integer getSalutation() {
		return salutation;
	}

	/**
	 * This method sets the value of the database column memmember.Salutation
	 * 
	 * @param salutation
	 *            the value for memmember.Salutation
	 */
	public void setSalutation(Integer salutation) {
		this.salutation = salutation;
	}

	/**
	 * This method returns the value of the database column
	 * memmember.DateofBirth
	 * 
	 * @return the value of memmember.DateofBirth
	 */
	public Date getDateofBirth() {
		return dateofBirth;
	}

	/**
	 * This method sets the value of the database column memmember.DateofBirth
	 * 
	 * @param dateofBirth
	 *            the value for memmember.DateofBirth
	 */
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	/**
	 * This method returns the value of the database column memmember.SunSign
	 * 
	 * @return the value of memmember.SunSign
	 */
	public Integer getSunSign() {
		return sunSign;
	}

	/**
	 * This method sets the value of the database column memmember.SunSign
	 * 
	 * @param sunSign
	 *            the value for memmember.SunSign
	 */
	public void setSunSign(Integer sunSign) {
		this.sunSign = sunSign;
	}

	/**
	 * This method returns the value of the database column memmember.MoonSign
	 * 
	 * @return the value of memmember.MoonSign
	 */
	public Integer getMoonSign() {
		return moonSign;
	}

	/**
	 * This method sets the value of the database column memmember.MoonSign
	 * 
	 * @param moonSign
	 *            the value for memmember.MoonSign
	 */
	public void setMoonSign(Integer moonSign) {
		this.moonSign = moonSign;
	}

	/**
	 * This method returns the value of the database column memmember.Active
	 * 
	 * @return the value of memmember.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column memmember.Active
	 * 
	 * @param active
	 *            the value for memmember.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * memmember.DoNotDistrubIndicator
	 * 
	 * @return the value of memmember.DoNotDistrubIndicator
	 */
	public Boolean getDoNotDistrubIndicator() {
		return doNotDistrubIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * memmember.DoNotDistrubIndicator
	 * 
	 * @param doNotDistrubIndicator
	 *            the value for memmember.DoNotDistrubIndicator
	 */
	public void setDoNotDistrubIndicator(Boolean doNotDistrubIndicator) {
		this.doNotDistrubIndicator = doNotDistrubIndicator;
	}

	/**
	 * This method returns the value of the database column memmember.Gender
	 * 
	 * @return the value of memmember.Gender
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * This method sets the value of the database column memmember.Gender
	 * 
	 * @param gender
	 *            the value for memmember.Gender
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * This method returns the value of the database column memmember.Picture
	 * 
	 * @return the value of memmember.Picture
	 */
	public String getPicturePath() {
		return picturePath;
	}

	/**
	 * This method sets the value of the database column memmember.Picture
	 * 
	 * @param picture
	 *            the value for memmember.Picture
	 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath == null ? null : picturePath.trim();
	}

	public List<MemberPersona> getMemberPersonas() {
		return memberPersonas;
	}

	public void setMemberPersonas(List<MemberPersona> memberPersonas) {
		this.memberPersonas = memberPersonas;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}