package com.ziksana.domain.assessment.personality;

public class PersonalitySuitability {
	/**
	 * This field corresponds to the database column
	 * pstsuitability.SuitabilityId
	 */
	private Integer suitabilityId;
	/**
	 * This field corresponds to the database column
	 * pstsuitability.SuitabilityType
	 */
	private Integer suitabilityType;
	/**
	 * This field corresponds to the database column pstsuitability.Name
	 */
	private Integer name;
	/**
	 * This field corresponds to the database column pstsuitability.Value
	 */
	private String value;
	/**
	 * This field corresponds to the database column pstsuitability.Description
	 */
	private String description;
	/**
	 * This field corresponds to the database column pstsuitability.Version
	 */
	private Integer version;
	/**
	 * This field corresponds to the database column pstsuitability.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * pstsuitability.CharacteristicId
	 */
	private Integer characteristicId;
	/**
	 * This field corresponds to the database column pstsuitability.CategoryId
	 */
	private Integer categoryId;

	/**
	 * This method returns the value of the database column
	 * pstsuitability.SuitabilityId
	 * 
	 * @return the value of pstsuitability.SuitabilityId
	 */
	public Integer getSuitabilityId() {
		return suitabilityId;
	}

	/**
	 * This method sets the value of the database column
	 * pstsuitability.SuitabilityId
	 * 
	 * @param suitabilityId
	 *            the value for pstsuitability.SuitabilityId
	 */
	public void setSuitabilityId(Integer suitabilityId) {
		this.suitabilityId = suitabilityId;
	}

	/**
	 * This method returns the value of the database column
	 * pstsuitability.SuitabilityType
	 * 
	 * @return the value of pstsuitability.SuitabilityType
	 */
	public Integer getSuitabilityType() {
		return suitabilityType;
	}

	/**
	 * This method sets the value of the database column
	 * pstsuitability.SuitabilityType
	 * 
	 * @param suitabilityType
	 *            the value for pstsuitability.SuitabilityType
	 */
	public void setSuitabilityType(Integer suitabilityType) {
		this.suitabilityType = suitabilityType;
	}

	/**
	 * This method returns the value of the database column pstsuitability.Name
	 * 
	 * @return the value of pstsuitability.Name
	 */
	public Integer getName() {
		return name;
	}

	/**
	 * This method sets the value of the database column pstsuitability.Name
	 * 
	 * @param name
	 *            the value for pstsuitability.Name
	 */
	public void setName(Integer name) {
		this.name = name;
	}

	/**
	 * This method returns the value of the database column pstsuitability.Value
	 * 
	 * @return the value of pstsuitability.Value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * This method sets the value of the database column pstsuitability.Value
	 * 
	 * @param value
	 *            the value for pstsuitability.Value
	 */
	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	/**
	 * This method returns the value of the database column
	 * pstsuitability.Description
	 * 
	 * @return the value of pstsuitability.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column
	 * pstsuitability.Description
	 * 
	 * @param description
	 *            the value for pstsuitability.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the database column
	 * pstsuitability.Version
	 * 
	 * @return the value of pstsuitability.Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the database column pstsuitability.Version
	 * 
	 * @param version
	 *            the value for pstsuitability.Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * This method returns the value of the database column
	 * pstsuitability.Active
	 * 
	 * @return the value of pstsuitability.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column pstsuitability.Active
	 * 
	 * @param active
	 *            the value for pstsuitability.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * pstsuitability.CharacteristicId
	 * 
	 * @return the value of pstsuitability.CharacteristicId
	 */
	public Integer getCharacteristicId() {
		return characteristicId;
	}

	/**
	 * This method sets the value of the database column
	 * pstsuitability.CharacteristicId
	 * 
	 * @param characteristicId
	 *            the value for pstsuitability.CharacteristicId
	 */
	public void setCharacteristicId(Integer characteristicId) {
		this.characteristicId = characteristicId;
	}

	/**
	 * This method returns the value of the database column
	 * pstsuitability.CategoryId
	 * 
	 * @return the value of pstsuitability.CategoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * This method sets the value of the database column
	 * pstsuitability.CategoryId
	 * 
	 * @param categoryId
	 *            the value for pstsuitability.CategoryId
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}