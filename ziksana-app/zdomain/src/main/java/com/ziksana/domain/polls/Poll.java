package com.ziksana.domain.polls;

import java.util.Date;

public class Poll {

	
    private Integer ID;

    
    private Integer creatorMemberRoleId;

    
    private Integer pollType;

    
    private Date pollStartDate;

    
    private Date pollEndDate;

    
    private Date displayEndDate;

    
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
        return pollStartDate;
    }

    
    public void setPollStartDate(Date pollStartDate) {
        this.pollStartDate = pollStartDate;
    }

    
    public Date getPollEndDate() {
        return pollEndDate;
    }

    
    public void setPollEndDate(Date pollEndDate) {
        this.pollEndDate = pollEndDate;
    }

    
    public Date getDisplayEndDate() {
        return displayEndDate;
    }

        public void setDisplayEndDate(Date displayEndDate) {
        this.displayEndDate = displayEndDate;
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
	
	
	
	
}