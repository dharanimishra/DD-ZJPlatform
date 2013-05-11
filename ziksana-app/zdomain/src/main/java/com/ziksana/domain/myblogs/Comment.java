package com.ziksana.domain.myblogs;

import java.util.Date;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class Comment {
	
	
	private final ZID commentId;
	
	private final String commentText;
	
	private final MemberPersona commentingMemberRoleId;
	
	private final Date createDate;

	
	public Comment(Integer commentId, String comment,
			Integer commentingMemberRoleId, Date createDate) {
		
		this.commentId = new IntegerZID(commentId);
		this.commentText = comment;
		this.commentingMemberRoleId = new MemberPersona();
		this.commentingMemberRoleId.setMemberRoleId(commentingMemberRoleId);
		
		this.createDate = createDate;
	}
	
	
	
	
	

	public ZID getCommentId() {
		return commentId;
	}






	public String getCommentText() {
		return commentText;
	}


	public MemberPersona getCommentingMemberRoleId() {
		return commentingMemberRoleId;
	}


	public Date getCreateDate() {
		return createDate;
	}

	
	
	
	

}
