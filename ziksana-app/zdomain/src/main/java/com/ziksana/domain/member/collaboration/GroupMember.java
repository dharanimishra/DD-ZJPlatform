package com.ziksana.domain.member.collaboration;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class GroupMember {
	
	private ZID 				groupMemberId;
	private Boolean 			isLead 				= null;
	private Boolean 			isNominated 		= null;
	private Boolean 			isVolunteered 		= null;
	private Integer 			totalMemberTime 	= null;
	private GroupPersonality 	groupPersonality 	= null;
	private Group 				group 				= null;
	private MemberPersona 		memberRole 			= null;
	
	/**
	 * @return the groupMemberId
	 */
	public ZID getGroupMemberId() {
		return groupMemberId;
	}
	/**
	 * @param groupMemberId the groupMemberId to set
	 */
	public void setGroupMemberId(Integer groupMemberId) {
		this.groupMemberId = new IntegerZID(groupMemberId);
	}
	/**
	 * @return the isLead
	 */
	public Boolean getIsLead() {
		return isLead;
	}
	/**
	 * @param isLead the isLead to set
	 */
	public void setIsLead(Boolean isLead) {
		this.isLead = isLead;
	}
	/**
	 * @return the isNominated
	 */
	public Boolean getIsNominated() {
		return isNominated;
	}
	/**
	 * @param isNominated the isNominated to set
	 */
	public void setIsNominated(Boolean isNominated) {
		this.isNominated = isNominated;
	}
	/**
	 * @return the isVolunteered
	 */
	public Boolean getIsVolunteered() {
		return isVolunteered;
	}
	/**
	 * @param isVolunteered the isVolunteered to set
	 */
	public void setIsVolunteered(Boolean isVolunteered) {
		this.isVolunteered = isVolunteered;
	}
	/**
	 * @return the totalMemberTime
	 */
	public Integer getTotalMemberTime() {
		return totalMemberTime;
	}
	/**
	 * @param totalMemberTime the totalMemberTime to set
	 */
	public void setTotalMemberTime(Integer totalMemberTime) {
		this.totalMemberTime = totalMemberTime;
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
	 * @return the memberRole
	 */
	public MemberPersona getMemberRole() {
		return memberRole;
	}
	/**
	 * @param memberRole the memberRole to set
	 */
	public void setMemberRole(MemberPersona memberRole) {
		this.memberRole = memberRole;
	}
	
	
	
}
