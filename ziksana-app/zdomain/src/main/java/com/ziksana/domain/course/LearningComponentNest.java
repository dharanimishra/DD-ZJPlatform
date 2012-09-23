package com.ziksana.domain.course;

import java.util.Date;

public class LearningComponentNest {
	/**
	 * This field corresponds property componentNestId
	 */
	private Integer componentNestId;

	/**
	 * This field corresponds property CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds property NestLevel
	 */
	private Integer nestLevel;

	/**
	 * This field corresponds property learningComponentParentId
	 */
	private Integer learningComponentParentId;

	/**
	 * This field corresponds property learningComponentNestId
	 */
	private Integer learningComponentNestId;
	
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
	 * This method returns the value of property componentNestId
	 * 
	 * @return the value of property componentNestId
	 */
	public Integer getComponentNestId() {
		return componentNestId;
	}

	/**
	 * This method sets the value of property componentNestId
	 * 
	 * @param componentNestId
	 *            the value for property componentNestId
	 */
	public void setComponentNestId(Integer componentNestId) {
		this.componentNestId = componentNestId;
	}

	/**
	 * This method returns the value of property CreationDate
	 * 
	 * @return the value of property CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of property CreationDate
	 * 
	 * @param creationDate
	 *            the value for property CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of property NestLevel
	 * 
	 * @return the value of property NestLevel
	 */
	public Integer getNestLevel() {
		return nestLevel;
	}

	/**
	 * This method sets the value of property NestLevel
	 * 
	 * @param nestLevel
	 *            the value for property NestLevel
	 */
	public void setNestLevel(Integer nestLevel) {
		this.nestLevel = nestLevel;
	}

	/**
	 * This method returns the value of property ParentLearningComponentId
	 * 
	 * @return the value of property ParentLearningComponentId
	 */
	public Integer getLearningComponentParentId() {
		return learningComponentParentId;
	}

	/**
	 * This method sets the value of property ParentLearningComponentId
	 * 
	 * @param parentLearningComponentId
	 *            the value for property ParentLearningComponentId
	 */
	public void setLearningComponentParentId(Integer learningComponentParentId) {
		this.learningComponentParentId = learningComponentParentId;
	}

	/**
	 * This method returns the value of property NestLearningComponentId
	 * 
	 * @return the value of property NestLearningComponentId
	 */
	public Integer getLearningComponentNestId() {
		return learningComponentNestId;
	}

	/**
	 * This method sets the value of property NestLearningComponentId
	 * 
	 * @param nestLearningComponentId
	 *            the value for property NestLearningComponentId
	 */
	public void setLearningComponentNestId(Integer learningComponentNestId) {
		this.learningComponentNestId = learningComponentNestId;
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