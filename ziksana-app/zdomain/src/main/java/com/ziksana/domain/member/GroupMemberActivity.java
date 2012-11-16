package com.ziksana.domain.member;

import java.sql.Timestamp;

import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class GroupMemberActivity {
	
	private ZID 			activityId;
	private Timestamp 		startTime 	= null;
	private Timestamp 		endTime 	= null;
	private String 			desription 	= null;
	private GroupMember 	groupMember = null;
	
	/**
	 * @return the activityId
	 */
	public ZID getActivityId() {
		return activityId;
	}
	/**
	 * @param activityId the activityId to set
	 */
	public void setActivityId(ZID activityId) {
		this.activityId = activityId;
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
	 * @return the desription
	 */
	public String getDesription() {
		return desription;
	}
	/**
	 * @param desription the desription to set
	 */
	public void setDesription(String desription) {
		this.desription = desription;
	}
	/**
	 * @return the groupMember
	 */
	public GroupMember getGroupMember() {
		return groupMember;
	}
	/**
	 * @param groupMember the groupMember to set
	 */
	public void setGroupMember(GroupMember groupMember) {
		this.groupMember = groupMember;
	}

	@Override
	public String toString() {
		return "GroupMemberActivity [activityId=" + activityId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", desription="
				+ desription + "]";
	}

}
