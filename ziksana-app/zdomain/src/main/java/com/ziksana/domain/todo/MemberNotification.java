/**
 * 
 */
package com.ziksana.domain.todo;

import java.util.Date;

/**
 * @author ratneshkumar
 * 
 */
public class MemberNotification {

	private long id;

	private Date creationDate;

	private int notificationType;

	private String category;

	private String notificationContent;

	private String description;

	private int priority;

	private int status;

	private Date completeBy;

	private int creatorType;

	private Date activationDate;

	private MemberPersona creatingMember;

	private MemberPersona forMember;

	/**
	 * 
	 */
	public MemberNotification() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(int notificationType) {
		this.notificationType = notificationType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNotificationContent() {
		return notificationContent;
	}

	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCompleteBy() {
		return completeBy;
	}

	public void setCompleteBy(Date completeBy) {
		this.completeBy = completeBy;
	}

	public int getCreatorType() {
		return creatorType;
	}

	public void setCreatorType(int creatorType) {
		this.creatorType = creatorType;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public MemberPersona getCreatingMember() {
		return creatingMember;
	}

	public void setCreatingMember(MemberPersona creatingMember) {
		this.creatingMember = creatingMember;
	}

	public MemberPersona getForMember() {
		return forMember;
	}

	public void setForMember(MemberPersona forMember) {
		this.forMember = forMember;
	}

}
