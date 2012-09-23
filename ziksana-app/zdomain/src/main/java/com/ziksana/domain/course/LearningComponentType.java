package com.ziksana.domain.course;

import java.util.Date;

public class LearningComponentType {

	/**
	 * This field corresponds to the property learningCompTypeId
	 */
	private Integer learningCompTypeId;

	/**
	 * This field corresponds to the property CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the property ComponentTypeName
	 */
	private String componentTypeName;

	/**
	 * This field corresponds to the property ComponentTypeDescription<br>
	 * Maximum Length:120
	 */
	private String componentTypeDescription;

	/**
	 * This field corresponds to the property Active
	 */
	private Boolean active;

	private Integer creatingMemberPersonaId;
	
	/**This field corresponds to the property createdBy { User who creates }
	 */
	private String createdBy;
	
	/**This field corresponds to the property createdOn { Creation Date)
	 */
	private Date createdOn;
	
	/**This field corresponds to the property createdBy {User who modified  }
	 */
	private String modifiedBy;
	
	/**This field corresponds to the property createdBy { modified date}
	 */
	private Date modifiedOn;

	/**
	 * . This method returns the value of the property CreationDate
	 * 
	 * @return the value of property CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * . This method sets the value of the property CreationDate
	 * 
	 * @param creationDate
	 *            the value for property CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * . This method returns the value of the property ComponentTypeName
	 * 
	 * @return the value of property ComponentTypeName
	 */
	public String getComponentTypeName() {
		return componentTypeName;
	}

	/**
	 * . This method sets the value of the property ComponentTypeName
	 * 
	 * @param componentTypeName
	 *            the value for property ComponentTypeName
	 */
	public void setComponentTypeName(String componentTypeName) {
		this.componentTypeName = componentTypeName == null ? null
				: componentTypeName.trim();
	}

	/**
	 * . This method returns the value of the property ComponentTypeDescription
	 * 
	 * @return the value of property ComponentTypeDescription
	 */
	public String getComponentTypeDescription() {
		return componentTypeDescription;
	}

	/**
	 * . This method sets the value of the property ComponentTypeDescription
	 * 
	 * @param componentTypeDescription
	 *            the value for property ComponentTypeDescription
	 */
	public void setComponentTypeDescription(String componentTypeDescription) {
		this.componentTypeDescription = componentTypeDescription == null ? null
				: componentTypeDescription.trim();
	}

	/**
	 * . This method returns the value of the property Active
	 * 
	 * @return the value of property Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * . This method sets the value of the property Active
	 * 
	 * @param active
	 *            the value for property Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the learningCompTypeId
	 */
	public Integer getLearningCompTypeId() {
		return learningCompTypeId;
	}

	/**
	 * @param learningCompTypeId
	 *            the learningCompTypeId to set
	 */
	public void setLearningCompTypeId(Integer learningCompTypeId) {
		this.learningCompTypeId = learningCompTypeId;
	}

	/**
	 * @return the creatingMemberPersonaId
	 */
	public Integer getCreatingMemberPersona() {
		return creatingMemberPersonaId;
	}

	/**
	 * @param creatingMemberRoleId the creatingMemberPersonaId to set
	 */
	public void setCreatingMemberPersona(Integer creatingMemberPersonaId) {
		this.creatingMemberPersonaId = creatingMemberPersonaId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}