package com.ziksana.domain.assessment.personality;

public class PersonalityCharacteristic {

	/**
	 * This field corresponds to the database column
	 * pstcharacteristic.CharacteristicId
	 */
	private Integer characteristicId;
	/**
	 * This field corresponds to the database column pstcharacteristic.Type
	 */
	private Integer type;
	/**
	 * This field corresponds to the database column pstcharacteristic.Name
	 */
	private Integer name;
	/**
	 * This field corresponds to the database column pstcharacteristic.Value
	 */
	private String value;
	/**
	 * This field corresponds to the database column
	 * pstcharacteristic.Description
	 */
	private String description;
	/**
	 * This field corresponds to the database column pstcharacteristic.Version
	 */
	private Integer version;
	/**
	 * This field corresponds to the database column pstcharacteristic.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * pstcharacteristic.CategoryId
	 */
	private Integer categoryId;

	/**
	 * This method returns the value of the database column
	 * pstcharacteristic.CharacteristicId
	 * 
	 * @return the value of pstcharacteristic.CharacteristicId
	 */
	public Integer getCharacteristicId() {
		return characteristicId;
	}

	/**
	 * This method sets the value of the database column
	 * pstcharacteristic.CharacteristicId
	 * 
	 * @param characteristicId
	 *            the value for pstcharacteristic.CharacteristicId
	 */
	public void setCharacteristicId(Integer characteristicId) {
		this.characteristicId = characteristicId;
	}

	/**
	 * This method returns the value of the database column
	 * pstcharacteristic.Type
	 * 
	 * @return the value of pstcharacteristic.Type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method sets the value of the database column pstcharacteristic.Type
	 * 
	 * @param type
	 *            the value for pstcharacteristic.Type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method returns the value of the database column
	 * pstcharacteristic.Name
	 * 
	 * @return the value of pstcharacteristic.Name
	 */
	public Integer getName() {
		return name;
	}

	/**
	 * This method sets the value of the database column pstcharacteristic.Name
	 * 
	 * @param name
	 *            the value for pstcharacteristic.Name
	 */
	public void setName(Integer name) {
		this.name = name;
	}

	/**
	 * This method returns the value of the database column
	 * pstcharacteristic.Value
	 * 
	 * @return the value of pstcharacteristic.Value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * This method sets the value of the database column pstcharacteristic.Value
	 * 
	 * @param value
	 *            the value for pstcharacteristic.Value
	 */
	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	/**
	 * This method returns the value of the database column
	 * pstcharacteristic.Description
	 * 
	 * @return the value of pstcharacteristic.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column
	 * pstcharacteristic.Description
	 * 
	 * @param description
	 *            the value for pstcharacteristic.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the database column
	 * pstcharacteristic.Version
	 * 
	 * @return the value of pstcharacteristic.Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the database column
	 * pstcharacteristic.Version
	 * 
	 * @param version
	 *            the value for pstcharacteristic.Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * This method returns the value of the database column
	 * pstcharacteristic.Active
	 * 
	 * @return the value of pstcharacteristic.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * pstcharacteristic.Active
	 * 
	 * @param active
	 *            the value for pstcharacteristic.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * pstcharacteristic.CategoryId
	 * 
	 * @return the value of pstcharacteristic.CategoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * This method sets the value of the database column
	 * pstcharacteristic.CategoryId
	 * 
	 * @param categoryId
	 *            the value for pstcharacteristic.CategoryId
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}