/**
 * 
 */
package com.vtg.model;

import java.util.Date;

/**
 * @author
 * 
 */
public class MemberNotification {

	private long id;

	private Date creationDate;

	private int notificationType;

	private String category;

	private String notificationContent;

	private int priority;

	private int status;

	private Date completeBy;

	private int creatorType;

	private Date activationDate;

	/**
	 * 
	 */
	public MemberNotification() {
		super();
	}

	/**
	 * @param id
	 * @param creationDate
	 * @param notificationType
	 * @param category
	 * @param notificationContent
	 * @param priority
	 * @param status
	 * @param completeBy
	 * @param creatorType
	 * @param activationDate
	 */
	public MemberNotification(long id, Date creationDate, int notificationType,
			String category, String notificationContent, int priority,
			int status, Date completeBy, int creatorType, Date activationDate) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.notificationType = notificationType;
		this.category = category;
		this.notificationContent = notificationContent;
		this.priority = priority;
		this.status = status;
		this.completeBy = completeBy;
		this.creatorType = creatorType;
		this.activationDate = activationDate;
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

}
