package com.ziksana.domain.course;

import java.util.Date;

public class CourseLearningStrategyElement {
	/**
	 * This field corresponds to the database column
	 * corcourselearningstrategyelement.strategyElementId
	 * 
	 */
	private Integer strategyElementId;

	/**
	 * This field corresponds to the database column
	 * corcourselearningstrategyelement.CreationDate
	 * 
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corcourselearningstrategyelement.Active
	 * 
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corcourselearningstrategyelement.ElementName
	 * 
	 */
	private String elementName;

	/**
	 * This field corresponds to the database column
	 * corcourselearningstrategyelement.ElementValue
	 * 
	 */
	private String elementValue;

	/**
	 * This field corresponds to the database column
	 * corcourselearningstrategyelement.Description
	 * 
	 */
	private String description;

	/**
	 * This field corresponds to the database column
	 * corcourselearningstrategyelement.CourseLearningStrategyId
	 * 
	 */
	private Integer strategyId;

	/**
	 * This method returns the value of the database column
	 * corcourselearningstrategyelement.strategyElementId
	 * 
	 * @return the value of corcourselearningstrategyelement.strategyElementId
	 * 
	 */
	public Integer getStrategyElementId() {
		return strategyElementId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningstrategyelement.strategyElementId
	 * 
	 * @param strategyElementId
	 *            the value for corcourselearningstrategyelement.strategyElementId
	 * 
	 */
	public void setStrategyElementId(Integer strategyElementId) {
		this.strategyElementId = strategyElementId;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningstrategyelement.CreationDate
	 * 
	 * @return the value of corcourselearningstrategyelement.CreationDate
	 * 
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningstrategyelement.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corcourselearningstrategyelement.CreationDate
	 * 
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningstrategyelement.Active
	 * 
	 * @return the value of corcourselearningstrategyelement.Active
	 * 
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningstrategyelement.Active
	 * 
	 * @param active
	 *            the value for corcourselearningstrategyelement.Active
	 * 
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningstrategyelement.ElementName
	 * 
	 * @return the value of corcourselearningstrategyelement.ElementName
	 * 
	 */
	public String getElementName() {
		return elementName;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningstrategyelement.ElementName
	 * 
	 * @param elementName
	 *            the value for corcourselearningstrategyelement.ElementName
	 * 
	 */
	public void setElementName(String elementName) {
		this.elementName = elementName == null ? null : elementName.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningstrategyelement.ElementValue
	 * 
	 * @return the value of corcourselearningstrategyelement.ElementValue
	 * 
	 */
	public String getElementValue() {
		return elementValue;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningstrategyelement.ElementValue
	 * 
	 * @param elementValue
	 *            the value for corcourselearningstrategyelement.ElementValue
	 * 
	 */
	public void setElementValue(String elementValue) {
		this.elementValue = elementValue == null ? null : elementValue.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningstrategyelement.Description
	 * 
	 * @return the value of corcourselearningstrategyelement.Description
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningstrategyelement.Description
	 * 
	 * @param description
	 *            the value for corcourselearningstrategyelement.Description
	 * 
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcourselearningstrategyelement.CourseLearningStrategyId
	 * 
	 * @return the value of
	 *         corcourselearningstrategyelement.CourseLearningStrategyId
	 * 
	 */
	public Integer getStrategyId() {
		return strategyId;
	}

	/**
	 * This method sets the value of the database column
	 * corcourselearningstrategyelement.CourseLearningStrategyId
	 * 
	 * @param strategyId
	 *            the value for
	 *            corcourselearningstrategyelement.CourseLearningStrategyId
	 * 
	 */
	public void setStrategyId(Integer strategyId) {
		this.strategyId = strategyId;
	}
}