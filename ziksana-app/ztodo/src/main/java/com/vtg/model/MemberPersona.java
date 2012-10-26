package com.vtg.model;

import java.io.Serializable;
import java.util.Date;

public class MemberPersona implements Serializable {

	private static final long serialVersionUID = 2945917870151547594L;

	private int id;

	private int memberType;

	private int relationshipStatus;

	private Date joinedDate;

	private String firstname;

	private String lastname;

	private String middlename;

	private String nickname;

	private int salutation;

	private Date dateofbirth;

	private int sunsign;

	private int moodsign;

	private int active;

	private int doNotDistrubIndicator;

	private int gender;

	private String picturePath;

	public MemberPersona() {
		super();
	}

	/**
	 * @param id
	 * @param memberType
	 * @param relationshipStatus
	 * @param joinedDate
	 * @param firstname
	 * @param lastname
	 * @param middlename
	 * @param nickname
	 * @param salutation
	 * @param dateofbirth
	 * @param sunsign
	 * @param moodsign
	 * @param active
	 * @param doNotDistrubIndicator
	 * @param gender
	 * @param picturePath
	 */
	public MemberPersona(int id, int memberType, int relationshipStatus,
			Date joinedDate, String firstname, String lastname,
			String middlename, String nickname, int salutation,
			Date dateofbirth, int sunsign, int moodsign, int active,
			int doNotDistrubIndicator, int gender, String picturePath) {
		super();
		this.id = id;
		this.memberType = memberType;
		this.relationshipStatus = relationshipStatus;
		this.joinedDate = joinedDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.nickname = nickname;
		this.salutation = salutation;
		this.dateofbirth = dateofbirth;
		this.sunsign = sunsign;
		this.moodsign = moodsign;
		this.active = active;
		this.doNotDistrubIndicator = doNotDistrubIndicator;
		this.gender = gender;
		this.picturePath = picturePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public int getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(int relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSalutation() {
		return salutation;
	}

	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public int getSunsign() {
		return sunsign;
	}

	public void setSunsign(int sunsign) {
		this.sunsign = sunsign;
	}

	public int getMoodsign() {
		return moodsign;
	}

	public void setMoodsign(int moodsign) {
		this.moodsign = moodsign;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getDoNotDistrubIndicator() {
		return doNotDistrubIndicator;
	}

	public void setDoNotDistrubIndicator(int doNotDistrubIndicator) {
		this.doNotDistrubIndicator = doNotDistrubIndicator;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Id = ").append(id).append(" - ");
		sb.append("memberType = ").append(memberType).append(" - ");
		sb.append("relationshipStatus = ").append(relationshipStatus)
				.append(" - ");
		sb.append("joinedDate = ").append(joinedDate).append(" - ");
		sb.append("firstname = ").append(firstname).append(" - ");
		sb.append("lastname = ").append(lastname).append(" - ");
		return sb.toString();
	}

	public boolean equals(Object obj) {
		final MemberPersona member = (MemberPersona) obj;
		if (this.id != member.getId()) {
			return false;
		}
		if (this.memberType != member.getMemberType()) {
			return false;
		}
		if (this.relationshipStatus != member.getRelationshipStatus()) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (memberType ^ (memberType >>> 32));

		return result;

	}
}
