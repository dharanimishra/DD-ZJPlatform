package com.ziksana.domain.myblogs;

import java.io.Serializable;
import java.util.Date;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class Tag  implements Serializable {
	
	private final ZID blogTagId;
	
	private final String name;
	
	private final Integer type;
	
	private final MemberPersona creatingMemberRoleId;
		
	private final Date createDate;
	
	

	public Tag(Integer blogTagId, String name, Integer type,
			Integer creatingMemberRoleId, Date createDate) {
		super();
		this.blogTagId = new IntegerZID(blogTagId);
		this.name = name;
		this.type = type;
		this.creatingMemberRoleId = new MemberPersona();
		this.creatingMemberRoleId.setMemberRoleId(creatingMemberRoleId);
		
		this.createDate = createDate;
	}

	
	public ZID getBlogTagId() {
		return blogTagId;
	}

	public String getName() {
		return name;
	}

	public Integer getType() {
		return type;
	}

	public MemberPersona getCreatingMemberRoleId() {
		return creatingMemberRoleId;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	
	
	
	
	
	
	
	

}
