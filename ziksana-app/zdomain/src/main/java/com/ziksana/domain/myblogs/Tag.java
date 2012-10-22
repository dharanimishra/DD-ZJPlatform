package com.ziksana.domain.myblogs;

import java.util.Date;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class Tag {
	
	private ZID blogTagId;
	
	private String name;
	
	private Integer type;
	
	private MemberPersona creatingMemberRoleId;
		
	private Date createDate;
	
	

	public Tag(Integer blogTagId, String name, Integer type,
			MemberPersona creatingMemberRoleId, Date createDate) {
		super();
		this.blogTagId = new IntegerZID(blogTagId);
		this.name = name;
		this.type = type;
		this.creatingMemberRoleId = creatingMemberRoleId;
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
