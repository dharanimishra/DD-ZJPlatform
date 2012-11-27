package com.ziksana.domain.institution;

import java.util.Date;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class ProgramParticipants extends AuditHistory {
	
	public ProgramParticipants(Date startDate, Date endDate,
			String description, ParticipatingType participatingType,
			Integer participatingTypeId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.participatingType = participatingType;
		this.participatingTypeId = participatingTypeId;
	}
	
	private ZID 				participantsId;
	private Date 				startDate 				= null;
	private Date 				endDate 				= null;
	private String 				description 			= null;
	private ParticipatingType 	participatingType 		= null;
	private Integer 			participatingTypeId 	= null;
	private MemberPersona 		participatingMbmberRole = null;
	private LearningProgram		participatedProgram 	= null;
	
	/**
	 * @return the participantsId
	 */
	public ZID getParticipantsId() {
		return participantsId;
	}
	/**
	 * @param participantsId the participantsId to set
	 */
	public void setParticipantsId(ZID participantsId) {
		this.participantsId = participantsId;
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
	 * @return the participatingTypeId
	 */
	public Integer getParticipatingTypeId() {
		return participatingTypeId;
	}
	/**
	 * @param participatingTypeId the participatingTypeId to set
	 */
	public void setParticipatingTypeId(Integer participatingTypeId) {
		this.participatingTypeId = participatingTypeId;
	}
	/**
	 * @return the participatingMbmberRole
	 */
	public MemberPersona getParticipatingMbmberRole() {
		return participatingMbmberRole;
	}
	/**
	 * @param participatingMbmberRole the participatingMbmberRole to set
	 */
	public void setParticipatingMbmberRole(MemberPersona participatingMbmberRole) {
		this.participatingMbmberRole = participatingMbmberRole;
	}
	/**
	 * @return the participatedProgram
	 */
	public LearningProgram getParticipatedProgram() {
		return participatedProgram;
	}
	/**
	 * @param participatedProgram the participatedProgram to set
	 */
	public void setParticipatedProgram(LearningProgram participatedProgram) {
		this.participatedProgram = participatedProgram;
	}
 

}
