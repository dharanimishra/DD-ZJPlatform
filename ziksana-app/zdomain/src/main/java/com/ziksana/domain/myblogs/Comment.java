package com.ziksana.domain.myblogs;

import java.util.Date;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class Comment {
	
	
	private ZID commentId;
	
	private String comment;
	
	private MemberPersona commentingMemberRoleId;
	
	private Date createDate;

	
	public Comment(Integer commentId, String comment,
			Integer commentingMemberRoleId, Date createDate) {
		
		this.commentId = new IntegerZID(commentId);
		this.comment = comment;
		this.commentingMemberRoleId = new MemberPersona();
		this.commentingMemberRoleId.setMemberRoleId(commentingMemberRoleId);
		
		this.createDate = createDate;
	}
	
	
	
	
	

	public ZID getCommentId() {
		return commentId;
	}






	public String getComment() {
		return comment;
	}


	public MemberPersona getCommentingMemberRoleId() {
		return commentingMemberRoleId;
	}


	public Date getCreateDate() {
		return createDate;
	}

	
	
	
	

}
