package com.ziksana.domain.member;

import java.sql.Timestamp;
import java.util.Date;

import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class GroupMemberConversation {
	
	private ZID 				conversationId;
	private Date 				creationDate 		= null;
	private Timestamp 			startTime 			= null;
	private Timestamp 			endTime 			= null;
	private ConversationMode  	conversationMode 	= null;
	private String 				conversationText 	= null;
	private String 				recordingPath 		= null;
	private GroupMember 		sourceGroupMember 	= null;
	private GroupMember 		targetGroupMember 	= null;
	
	
	/**
	 * @return the conversationId
	 */
	public ZID getConversationId() {
		return conversationId;
	}
	/**
	 * @param conversationId the conversationId to set
	 */
	public void setConversationId(ZID conversationId) {
		this.conversationId = conversationId;
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
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the conversationMode
	 */
	public ConversationMode getConversationMode() {
		return conversationMode;
	}
	/**
	 * @param conversationMode the conversationMode to set
	 */
	public void setConversationMode(ConversationMode conversationMode) {
		this.conversationMode = conversationMode;
	}
	/**
	 * @return the conversationText
	 */
	public String getConversationText() {
		return conversationText;
	}
	/**
	 * @param conversationText the conversationText to set
	 */
	public void setConversationText(String conversationText) {
		this.conversationText = conversationText;
	}
	/**
	 * @return the recordingPath
	 */
	public String getRecordingPath() {
		return recordingPath;
	}
	/**
	 * @param recordingPath the recordingPath to set
	 */
	public void setRecordingPath(String recordingPath) {
		this.recordingPath = recordingPath;
	}
	/**
	 * @return the sourceGroupMember
	 */
	public GroupMember getSourceGroupMember() {
		return sourceGroupMember;
	}
	/**
	 * @param sourceGroupMember the sourceGroupMember to set
	 */
	public void setSourceGroupMember(GroupMember sourceGroupMember) {
		this.sourceGroupMember = sourceGroupMember;
	}
	/**
	 * @return the targetGroupMember
	 */
	public GroupMember getTargetGroupMember() {
		return targetGroupMember;
	}
	/**
	 * @param targetGroupMember the targetGroupMember to set
	 */
	public void setTargetGroupMember(GroupMember targetGroupMember) {
		this.targetGroupMember = targetGroupMember;
	}

	@Override
	public String toString() {
		return "GroupMemberConversation [creationDate=" + creationDate
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", conversationMode=" + conversationMode
				+ ", conversationText=" + conversationText + ", recordingPath="
				+ recordingPath + "]";
	}
}
