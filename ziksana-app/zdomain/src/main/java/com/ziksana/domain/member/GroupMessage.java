package com.ziksana.domain.member;

import java.util.Date;

import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class GroupMessage {
	
	private ZID 				messageId;
	private Date 				creationDate 		= null;
	private String 				message 			= null;
	private Boolean 			isVotingAllowed 	= null;
	private MessageType 		messageType 		= null;
	private MessageVisibility 	visibility 			= null;
	private Group 				group 				= null;
	private GroupMember 		postingGroupMember 	= null;
	
	/**
	 * @return the messageId
	 */
	public ZID getMessageId() {
		return messageId;
	}
	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(ZID messageId) {
		this.messageId = messageId;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the isVotingAllowed
	 */
	public Boolean getIsVotingAllowed() {
		return isVotingAllowed;
	}
	/**
	 * @param isVotingAllowed the isVotingAllowed to set
	 */
	public void setIsVotingAllowed(Boolean isVotingAllowed) {
		this.isVotingAllowed = isVotingAllowed;
	}
	/**
	 * @return the messageType
	 */
	public MessageType getMessageType() {
		return messageType;
	}
	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	/**
	 * @return the visibility
	 */
	public MessageVisibility getVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(MessageVisibility visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}
	/**
	 * @return the postingGroupMember
	 */
	public GroupMember getPostingGroupMember() {
		return postingGroupMember;
	}
	/**
	 * @param postingGroupMember the postingGroupMember to set
	 */
	public void setPostingGroupMember(GroupMember postingGroupMember) {
		this.postingGroupMember = postingGroupMember;
	}

}
