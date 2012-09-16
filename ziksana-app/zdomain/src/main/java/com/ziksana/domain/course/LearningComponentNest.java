package com.ziksana.domain.course;

import java.util.Date;

public class LearningComponentNest {
	/**
	 * This field corresponds to the database column corlearningcomponentnest.componentNestId
	 */
	private Integer componentNestId;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentnest.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentnest.NestLevel
	 */
	private Integer nestLevel;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentnest.ParentLearningComponentId
	 */
	private Integer parentLearningComponentId;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponentnest.NestLearningComponentId
	 */
	private Integer nestLearningComponentId;

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentnest.componentNestId
	 * 
	 * @return the value of corlearningcomponentnest.componentNestId
	 */
	public Integer getComponentNestId() {
		return componentNestId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentnest.componentNestId
	 * 
	 * @param componentNestId
	 *            the value for corlearningcomponentnest.componentNestId
	 */
	public void setComponentNestId(Integer componentNestId) {
		this.componentNestId = componentNestId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentnest.CreationDate
	 * 
	 * @return the value of corlearningcomponentnest.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentnest.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corlearningcomponentnest.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentnest.NestLevel
	 * 
	 * @return the value of corlearningcomponentnest.NestLevel
	 */
	public Integer getNestLevel() {
		return nestLevel;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentnest.NestLevel
	 * 
	 * @param nestLevel
	 *            the value for corlearningcomponentnest.NestLevel
	 */
	public void setNestLevel(Integer nestLevel) {
		this.nestLevel = nestLevel;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentnest.ParentLearningComponentId
	 * 
	 * @return the value of corlearningcomponentnest.ParentLearningComponentId
	 */
	public Integer getParentLearningComponentId() {
		return parentLearningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentnest.ParentLearningComponentId
	 * 
	 * @param parentLearningComponentId
	 *            the value for
	 *            corlearningcomponentnest.ParentLearningComponentId
	 */
	public void setParentLearningComponentId(Integer parentLearningComponentId) {
		this.parentLearningComponentId = parentLearningComponentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcomponentnest.NestLearningComponentId
	 * 
	 * @return the value of corlearningcomponentnest.NestLearningComponentId
	 */
	public Integer getNestLearningComponentId() {
		return nestLearningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcomponentnest.NestLearningComponentId
	 * 
	 * @param nestLearningComponentId
	 *            the value for corlearningcomponentnest.NestLearningComponentId
	 */
	public void setNestLearningComponentId(Integer nestLearningComponentId) {
		this.nestLearningComponentId = nestLearningComponentId;
	}
}