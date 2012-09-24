package com.ziksana.domain.polls;

import java.util.Date;

public class Poll {

	
    private Integer ID;

    
    private Integer creatorMemberRoleId;

    
    private Integer pollType;

    
    private Date pollStartDate = null;

    
    private Date pollEndDate = null;

    
    private Date displayEndDate = null;

    
    private Integer pollVisibility;

    
    private Boolean active;

    
    private Integer totalResponses;

    
    private Integer targetedMemberRoleType;

    
    public Integer getID() {
        return ID;
    }

    
    public void setID(Integer ID) {
        this.ID = ID;
    }

    
    public Integer getCreatorMemberRoleId() {
        return creatorMemberRoleId;
    }

    
    public void setCreatorMemberRoleId(Integer creatorMemberRoleId) {
        this.creatorMemberRoleId = creatorMemberRoleId;
    }

    
    public Integer getPollType() {
        return pollType;
    }

    
    public void setPollType(Integer pollType) {
        this.pollType = pollType;
    }

    
    public Date getPollStartDate() {
        if (null == pollStartDate)
        	throw new NullPointerException("pollStartDate is null.");
    	
        return new Date(pollStartDate.getTime());
        
    }

    
    public void setPollStartDate(Date pollStartDate) {
        this.pollStartDate = new Date(pollStartDate.getTime());
    }

    
    public Date getPollEndDate() {
    	if (null == pollEndDate)
        	throw new NullPointerException("pollStartDate is null.");
    	
    	return new Date(pollEndDate.getTime());
    }

    
    public void setPollEndDate(Date pollEndDate) {
        this.pollEndDate = new Date(pollEndDate.getTime());
    }

    
    public Date getDisplayEndDate() {
        
    	if (null == displayEndDate)
        	throw new NullPointerException("pollStartDate is null.");
        return new Date(displayEndDate.getTime());
    }

        public void setDisplayEndDate(Date displayEndDate) {
        this.displayEndDate = new Date(displayEndDate.getTime());
    }

    
    public Integer getPollVisibility() {
        return pollVisibility;
    }

    
    public void setPollVisibility(Integer pollVisibility) {
        this.pollVisibility = pollVisibility;
    }

    
    public Boolean getActive() {
        return active;
    }

    
    public void setActive(Boolean active) {
        this.active = active;
    }

    
    public Integer getTotalResponses() {
        return totalResponses;
    }

    
    public void setTotalResponses(Integer totalResponses) {
        this.totalResponses = totalResponses;
    }

    
    public Integer getTargetedMemberRoleType() {
        return targetedMemberRoleType;
    }

    
    public void setTargetedMemberRoleType(Integer targetedMemberRoleType) {
        this.targetedMemberRoleType = targetedMemberRoleType;
    }


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Poll [ID=" + ID + ", creatorMemberRoleId="
				+ creatorMemberRoleId + ", pollType=" + pollType
				+ ", pollStartDate=" + pollStartDate + ", pollEndDate="
				+ pollEndDate + ", displayEndDate=" + displayEndDate
				+ ", pollVisibility=" + pollVisibility + ", totalResponses="
				+ totalResponses + ", targetedMemberRoleType="
				+ targetedMemberRoleType + "]";
	}
	
	
	
	
}