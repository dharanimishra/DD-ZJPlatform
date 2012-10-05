package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;

public class LearningComponentContentHotspot extends AuditHistory{

	public LearningComponentContentHotspot(String hotspotName,
			String hotspotDescription, MemberPersona memberPersona) {
		this.hotspotName = hotspotName;
		this.hotspotDescription = hotspotDescription;
		this.memberPersona = memberPersona;
	}
	private Integer 					componentContentTagHotspotId;
	private Date 						creationDate 				= null;
	private String 						coordinates 				= null;
	private String 						hotspotName 				= null;
	private String 						hotspotDescription 			= null;
	private Boolean 					active 						= null;
	private LearningComponentContent 	learningComponentContent 	= null;
	private MemberPersona 				memberPersona 				= null;
	//private CurriculumCourse 			curriculumCourse 			= null;
	/**
	 * @return the componentContentTagHotspotId
	 */
	public Integer getComponentContentTagHotspotId() {
		return componentContentTagHotspotId;
	}
	/**
	 * @param componentContentTagHotspotId the componentContentTagHotspotId to set
	 */
	public void setComponentContentTagHotspotId(Integer componentContentTagHotspotId) {
		this.componentContentTagHotspotId = componentContentTagHotspotId;
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
	 * @return the coordinates
	 */
	public String getCoordinates() {
		return coordinates;
	}
	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	/**
	 * @return the hotspotName
	 */
	public String getHotspotName() {
		return hotspotName;
	}
	/**
	 * @param hotspotName the hotspotName to set
	 */
	public void setHotspotName(String hotspotName) {
		this.hotspotName = hotspotName;
	}
	/**
	 * @return the hotspotDescription
	 */
	public String getHotspotDescription() {
		return hotspotDescription;
	}
	/**
	 * @param hotspotDescription the hotspotDescription to set
	 */
	public void setHotspotDescription(String hotspotDescription) {
		this.hotspotDescription = hotspotDescription;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the learningComponentContent
	 */
	public LearningComponentContent getLearningComponentContent() {
		return learningComponentContent;
	}
	/**
	 * @param learningComponentContent the learningComponentContent to set
	 */
	public void setLearningComponentContent(
			LearningComponentContent learningComponentContent) {
		this.learningComponentContent = learningComponentContent;
	}
	/**
	 * @return the memberPersona
	 */
	public MemberPersona getMemberPersona() {
		return memberPersona;
	}
	/**
	 * @param memberPersona the memberPersona to set
	 */
	public void setMemberPersona(MemberPersona memberPersona) {
		this.memberPersona = memberPersona;
	}
/*	*//**
	 * @return the curriculumCourse
	 *//*
	public CurriculumCourse getCurriculumCourse() {
		return curriculumCourse;
	}
	*//**
	 * @param curriculumCourse the curriculumCourse to set
	 *//*
	public void setCurriculumCourse(CurriculumCourse curriculumCourse) {
		this.curriculumCourse = curriculumCourse;
	}
*/

}