package com.ziksana.domain.assessment.personality;

public class PersonalityCategory {

	/**
	 * This field corresponds to the database column pstcategory.CategoryId
	 */
	private Integer categoryId;
	/**
	 * This field corresponds to the database column pstcategory.Name
	 */
	private String name;
	/**
	 * This field corresponds to the database column pstcategory.Version
	 */
	private Integer version;
	/**
	 * This field corresponds to the database column pstcategory.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column pstcategory.Description
	 */
	private String description;

	/**
	 * This method returns the value of the database column
	 * pstcategory.CategoryId
	 * 
	 * @return the value of pstcategory.CategoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * This method sets the value of the database column pstcategory.CategoryId
	 * 
	 * @param categoryId
	 *            the value for pstcategory.CategoryId
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * This method returns the value of the database column pstcategory.Name
	 * 
	 * @return the value of pstcategory.Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the value of the database column pstcategory.Name
	 * 
	 * @param name
	 *            the value for pstcategory.Name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method returns the value of the database column pstcategory.Version
	 * 
	 * @return the value of pstcategory.Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the database column pstcategory.Version
	 * 
	 * @param version
	 *            the value for pstcategory.Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * This method returns the value of the database column pstcategory.Active
	 * 
	 * @return the value of pstcategory.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column pstcategory.Active
	 * 
	 * @param active
	 *            the value for pstcategory.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * pstcategory.Description
	 * 
	 * @return the value of pstcategory.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column pstcategory.Description
	 * 
	 * @param description
	 *            the value for pstcategory.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}