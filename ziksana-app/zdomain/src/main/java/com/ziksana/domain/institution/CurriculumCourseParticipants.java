package com.ziksana.domain.institution;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CurriculumCourseParticipants extends AuditHistory{
	
	public CurriculumCourseParticipants(ParticipatingType participatingType,
			Date startDate, Date endDate) {
		this.participatingType = participatingType;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	private ZID 				currCourseParticipantsId;
	private ParticipatingType 	participatingType 		= null;
	private Date 				startDate 				= null;
	private Date 				endDate 				= null;
	private Boolean				isActive				= null;
	
	
	/**
	 * @return the currCourseParticipantsId
	 */
	public ZID getCurrCourseParticipantsId() {
		return currCourseParticipantsId;
	}
	/**
	 * @param currCourseParticipantsId the currCourseParticipantsId to set
	 */
	public void setCurrCourseParticipantsId(Integer currCourseParticipantsId) {
		this.currCourseParticipantsId = new IntegerZID(currCourseParticipantsId);
	}
	/**
	 * @return the participatingType
	 */
	public ParticipatingType getParticipatingType() {
		return participatingType;
	}
	/**
	 * @param participatingType the participatingType to set
	 */
	public void setParticipatingType(ParticipatingType participatingType) {
		this.participatingType = participatingType;
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
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "CurriculumCourseParticipants [participatingType="
				+ participatingType + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	} 
	

}
