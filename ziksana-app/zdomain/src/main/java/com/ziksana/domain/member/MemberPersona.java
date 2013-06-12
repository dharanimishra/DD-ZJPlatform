/**
 * 
 */
package com.ziksana.domain.member;

import java.io.Serializable;
import java.util.Date;



/**
 * @author prabu
 *
 */
public class MemberPersona implements Serializable{
	
	  
	/**serial versionId
	 */
	private static final long serialVersionUID = 7165720043627931112L;

	private int            memberRoleId;
	private MemberRoleType roleType;
	private Date           roleStartDate = new Date();
	private Boolean        active;
	private Boolean        doNotMarketIndicator;
	private String        thumbnailPicturePath;
	private Member         member;
	private Integer rightsOwningMemberRoleId;

	
	
	
	public MemberPersona() {
		super();
	}

	public MemberPersona(MemberRoleType role) {
		this.roleType = role;
	}
	
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	public MemberRoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(MemberRoleType roleType) {
		this.roleType = roleType;
	}

	public Date getRoleStartDate() {
		return new Date(roleStartDate.getTime());
	}

	public void setRoleStartDate(Date roleStartDate) {
		this.roleStartDate = new Date(roleStartDate.getTime());
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getDoNotMarketIndicator() {
		return doNotMarketIndicator;
	}

	public void setDoNotMarketIndicator(Boolean doNotMarketIndicator) {
		this.doNotMarketIndicator = doNotMarketIndicator;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	public Integer getRightsOwningMemberRoleId() {
		return rightsOwningMemberRoleId;
	}

	public void setRightsOwningMemberRoleId(Integer rightsOwningMemberRoleId) {
		this.rightsOwningMemberRoleId = rightsOwningMemberRoleId;
	}

	public void setMemberRoleId(int memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
	  
	  

	
	
	  
	  
	  
	  
	

}
