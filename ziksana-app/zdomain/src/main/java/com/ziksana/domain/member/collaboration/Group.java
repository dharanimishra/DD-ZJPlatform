package com.ziksana.domain.member.collaboration;

import java.util.List;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/** 
 * @author bhashasp
 */
public class Group {

	private ZID 				groupId;
	private Integer 			totalParticipants 	= null;
	private String 				name 				= null;
	private GroupPersonality 	groupPersonality	= null;
	private Boolean 			isZeniSuggested 	= null;
	private GroupContext 		groupContext 		= null;
	private List<GroupMember> 	groupMemberList 	= null;
	private List<GroupMessage>  groupMessageList    = null;
	
	/**
	 * @return the groupId
	 */
	public ZID getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = new IntegerZID(groupId);
	}
	/**
	 * @return the totalParticipants
	 */
	public Integer getTotalParticipants() {
		return totalParticipants;
	}
	/**
	 * @param totalParticipants the totalParticipants to set
	 */
	public void setTotalParticipants(Integer totalParticipants) {
		this.totalParticipants = totalParticipants;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the groupPersonality
	 */
	public GroupPersonality getGroupPersonality() {
		return groupPersonality;
	}
	/**
	 * @param groupPersonality the groupPersonality to set
	 */
	public void setGroupPersonality(GroupPersonality groupPersonality) {
		this.groupPersonality = groupPersonality;
	}
	/**
	 * @return the isZeniSuggested
	 */
	public Boolean getIsZeniSuggested() {
		return isZeniSuggested;
	}
	/**
	 * @param isZeniSuggested the isZeniSuggested to set
	 */
	public void setIsZeniSuggested(Boolean isZeniSuggested) {
		this.isZeniSuggested = isZeniSuggested;
	}
	/**
	 * @return the groupContext
	 */
	public GroupContext getGroupContext() {
		return groupContext;
	}
	/**
	 * @param groupContext the groupContext to set
	 */
	public void setGroupContext(GroupContext groupContext) {
		this.groupContext = groupContext;
	}
	/**
	 * @return the groupMemberList
	 */
	public List<GroupMember> getGroupMemberList() {
		return groupMemberList;
	}
	/**
	 * @param groupMemberList the groupMemberList to set
	 */
	public void setGroupMemberList(List<GroupMember> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}
	/**
	 * @return the groupMessageList
	 */
	public List<GroupMessage> getGroupMessageList() {
		return groupMessageList;
	}
	/**
	 * @param groupMessageList the groupMessageList to set
	 */
	public void setGroupMessageList(List<GroupMessage> groupMessageList) {
		this.groupMessageList = groupMessageList;
	}
	
	
}
