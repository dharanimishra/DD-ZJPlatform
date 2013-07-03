package com.ziksana.domain.recommendations;

import java.util.Date;

public class Recommendation {

	private Integer ID;

	private String title;

	private String description;

	private Integer category;

	private String currentState;

	private String targetState;

	private Date creationDate;

	private int durationtoBump;

	private int active;

	private int memberRoleId;
	
	private int ignoreCount;

	/**
	 * 
	 */
	public Recommendation() {
		super();
	}

	/**
	 * @param ID
	 * @param title
	 * @param description
	 * @param category
	 * @param memberPersona
	 * @param currentState
	 * @param targetState
	 * @param creationDate
	 * @param durationtoBump
	 * @param active
	 * @param memberRoleId
	 */
	public Recommendation(Integer ID, String title, String description,
			Integer category, String currentState, String targetState,
			Date creationDate, int durationtoBump, int active, int memberRoleId) {
		super();
		this.ID = ID;
		this.title = title;
		this.description = description;
		this.category = category;
		this.currentState = currentState;
		this.targetState = targetState;
		this.creationDate = creationDate;
		this.durationtoBump = durationtoBump;
		this.active = active;
		this.memberRoleId = memberRoleId;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getTargetState() {
		return targetState;
	}

	public void setTargetState(String targetState) {
		this.targetState = targetState;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getDurationtoBump() {
		return durationtoBump;
	}

	public void setDurationtoBump(int durationtoBump) {
		this.durationtoBump = durationtoBump;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(int memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the ignoreCount
	 */
	public int getIgnoreCount() {
		return ignoreCount;
	}

	/**
	 * @param ignoreCount the ignoreCount to set
	 */
	public void setIgnoreCount(int ignoreCount) {
		this.ignoreCount = ignoreCount;
	}

}
