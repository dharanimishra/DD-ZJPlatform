/**
 * 
 */
package com.ziksana.domain.member;

import java.util.Date;

import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberRole;

/**
 * @author prabu
 *
 */
public class MemberPersona {
	
	  
	/**serial versionId
	 */
	private static final long serialVersionUID = 7165720043627931112L;

	/**
	 * This field corresponds to the database column memmemberrole.ID
	 */
	private Integer memberRoleId;

	/**
	 * This field corresponds to the database column memmemberrole.RoleType
	 */
	private Integer roleType;

	/**
	 * This field corresponds to the database column memmemberrole.RoleStartDate
	 */
	private Date roleStartDate;

	/**
	 * This field corresponds to the database column memmemberrole.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * memmemberrole.DoNotMarketIndicator
	 */
	private Boolean doNotMarketIndicator;

	/**
	 * This field corresponds to the database column memmemberrole.thumbnailPicturePath
	 */
	private Integer thumbnailPicturePath;

	/**
	 * This field corresponds to the database column memmemberrole.memberid
	 */
	private Integer memberId;

	/**
	 * . This method returns the value of the database column memmemberrole.ID
	 * @return the value of memmemberrole.ID
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * . This method sets the value of the database column memmemberrole.ID
	 * @param ID
	 *            the value for memmemberrole.ID
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * . This method returns the value of the database column
	 * memmemberrole.RoleType
	 * @return the value of memmemberrole.RoleType
	 */
	public Integer getRoleType() {
		return roleType;
	}

	/**
	 * . This method sets the value of the database column
	 * memmemberrole.RoleType
	 * @param roleType
	 *            the value for memmemberrole.RoleType
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	/**
	 * . This method returns the value of the database column
	 * memmemberrole.RoleStartDate
	 * @return the value of memmemberrole.RoleStartDate
	 */
	public Date getRoleStartDate() {
		return roleStartDate;
	}

	/**
	 * . This method sets the value of the database column
	 * memmemberrole.RoleStartDate
	 * @param roleStartDate
	 *            the value for memmemberrole.RoleStartDate
	 */
	public void setRoleStartDate(Date roleStartDate) {
		this.roleStartDate = roleStartDate;
	}

	/**
	 * . This method returns the value of the database column
	 * memmemberrole.Active
	 * @return the value of memmemberrole.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * . This method sets the value of the database column memmemberrole.Active
	 * @param active
	 *            the value for memmemberrole.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * . This method returns the value of the database column
	 * memmemberrole.DoNotMarketIndicator
	 * @return the value of memmemberrole.DoNotMarketIndicator
	 */
	public Boolean getDoNotMarketIndicator() {
		return doNotMarketIndicator;
	}

	/**
	 * . This method sets the value of the database column
	 * memmemberrole.DoNotMarketIndicator
	 * @param doNotMarketIndicator
	 *            the value for memmemberrole.DoNotMarketIndicator
	 */
	public void setDoNotMarketIndicator(Boolean doNotMarketIndicator) {
		this.doNotMarketIndicator = doNotMarketIndicator;
	}

	/**
	 * @return the memberId
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the thumbnailPicturePath
	 */
	public Integer getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	/**
	 * @param thumbnailPicturePath the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(Integer thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	  
	  

	
	
	  
	  
	  
	  
	

}
