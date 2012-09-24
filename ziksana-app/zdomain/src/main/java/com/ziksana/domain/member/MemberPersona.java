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

	private int            memberRoleId;
	private MemberRoleType roleType;
	private Date           roleStartDate = null;
	private Boolean        active;
	private Boolean        doNotMarketIndicator;
	private Integer        thumbnailPicturePath;
	private Member         member;

	
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

	public Integer getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(Integer thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}
	  
	  

	
	
	  
	  
	  
	  
	

}
