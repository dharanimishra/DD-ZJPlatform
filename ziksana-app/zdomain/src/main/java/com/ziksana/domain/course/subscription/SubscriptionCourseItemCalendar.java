package com.ziksana.domain.course.subscription;

import java.util.Date;
import com.ziksana.domain.assessment.Status;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class SubscriptionCourseItemCalendar {
	
	public SubscriptionCourseItemCalendar(Date creationDate, Date startDate,
			Date endDate, Status status, Integer statusId, String description) {
		super();
		this.creationDate = creationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.statusId = statusId;
		this.description = description;
	}
	
	private ZID 		calendearId;
	private Date 		creationDate 		= null;
	private Date 		startDate 			= null;
	private Date 		endDate 			= null;
	private Status 		status 				= null;
	private Integer 	statusId 			= null;
	private String 		description 		= null;
	private Boolean 	isZeniRecommended 	= null;
	
	/**
	 * @return the calendearId
	 */
	public ZID getCalendearId() {
		return calendearId;
	}
	/**
	 * @param calendearId the calendearId to set
	 */
	public void setCalendearId(ZID calendearId) {
		this.calendearId = calendearId;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the isZeniRecommended
	 */
	public Boolean getIsZeniRecommended() {
		return isZeniRecommended;
	}
	/**
	 * @param isZeniRecommended the isZeniRecommended to set
	 */
	public void setIsZeniRecommended(Boolean isZeniRecommended) {
		this.isZeniRecommended = isZeniRecommended;
	}

}
