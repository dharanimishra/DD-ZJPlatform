package com.ziksana.security.util;

import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.id.ZID;

public class SecurityToken  {
	
	 protected ZID memberId;

	 protected ZID memberPersonaId;

	 protected MemberRoleType role;

	
	public SecurityToken(ZID memberId, ZID memberPersonaId, MemberRoleType role) {
		
		this.memberId = memberId;
		this.memberPersonaId = memberPersonaId;
		this.role = role;
	}


	public ZID getMemberId() {
		return memberId;
	}


	public ZID getMemberPersonaId() {
		return memberPersonaId;
	}


	public MemberRoleType getRole() {
		return role;
	}
	
	
	
	
	
	
	
	
	

}
