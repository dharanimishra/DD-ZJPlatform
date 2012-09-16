package com.ziksana.domain.course;

import java.util.Date;

public class LearningComponentContentHotspot {
	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.componentContentTagHotspotId
	 */
	private Integer componentContentTagHotspotId;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.Coordinates
	 */
	private String coordinates;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.HotspotName
	 */
	private String hotspotName;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.HotspotDescription
	 */
	private String hotspotDescription;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.LearningComponentContentId
	 */
	private Integer learningComponentContentId;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentcontenthotspot.CurriculumCourseId
	 */
	private Integer curriculumCourseId;

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.componentContentTagHotspotId
	 * 
	 * @return the value of corlearningcomponentcontenthotspot.componentContentTagHotspotId
	 */
	public Integer getComponentContentTagHotspotId() {
		return componentContentTagHotspotId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.componentContentTagHotspotId
	 * 
	 * @param componentContentTagHotspotId
	 *            the value for corlearningcomponentcontenthotspot.componentContentTagHotspotId
	 */
	public void setComponentContentTagHotspotId(Integer componentContentTagHotspotId) {
		this.componentContentTagHotspotId = componentContentTagHotspotId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.CreationDate
	 * 
	 * @return the value of corlearningcomponentcontenthotspot.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corlearningcomponentcontenthotspot.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.Coordinates
	 * 
	 * @return the value of corlearningcomponentcontenthotspot.Coordinates
	 */
	public String getCoordinates() {
		return coordinates;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.Coordinates
	 * 
	 * @param coordinates
	 *            the value for corlearningcomponentcontenthotspot.Coordinates
	 */
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates == null ? null : coordinates.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.HotspotName
	 * 
	 * @return the value of corlearningcomponentcontenthotspot.HotspotName
	 */
	public String getHotspotName() {
		return hotspotName;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.HotspotName
	 * 
	 * @param hotspotName
	 *            the value for corlearningcomponentcontenthotspot.HotspotName
	 */
	public void setHotspotName(String hotspotName) {
		this.hotspotName = hotspotName == null ? null : hotspotName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.HotspotDescription
	 * 
	 * @return the value of
	 *         corlearningcomponentcontenthotspot.HotspotDescription
	 */
	public String getHotspotDescription() {
		return hotspotDescription;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.HotspotDescription
	 * 
	 * @param hotspotDescription
	 *            the value for
	 *            corlearningcomponentcontenthotspot.HotspotDescription
	 */
	public void setHotspotDescription(String hotspotDescription) {
		this.hotspotDescription = hotspotDescription == null ? null
				: hotspotDescription.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.Active
	 * 
	 * @return the value of corlearningcomponentcontenthotspot.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.Active
	 * 
	 * @param active
	 *            the value for corlearningcomponentcontenthotspot.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.LearningComponentContentId
	 * 
	 * @return the value of
	 *         corlearningcomponentcontenthotspot.LearningComponentContentId
	 */
	public Integer getLearningComponentContentId() {
		return learningComponentContentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.LearningComponentContentId
	 * 
	 * @param learningComponentContentId
	 *            the value for corlearningcomponentcontenthotspot.
	 *            LearningComponentContentId
	 */
	public void setLearningComponentContentId(Integer learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.MemberRoleId
	 * 
	 * @return the value of corlearningcomponentcontenthotspot.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corlearningcomponentcontenthotspot.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentcontenthotspot.CurriculumCourseId
	 * 
	 * @return the value of
	 *         corlearningcomponentcontenthotspot.CurriculumCourseId
	 */
	public Integer getCurriculumCourseId() {
		return curriculumCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentcontenthotspot.CurriculumCourseId
	 * 
	 * @param curriculumCourseId
	 *            the value for
	 *            corlearningcomponentcontenthotspot.CurriculumCourseId
	 */
	public void setCurriculumCourseId(Integer curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}
}