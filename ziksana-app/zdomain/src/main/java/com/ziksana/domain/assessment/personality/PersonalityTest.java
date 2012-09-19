package com.ziksana.domain.assessment.personality;

public class PersonalityTest {

	/**
	 * This field corresponds to the database column psttest.TestId
	 */
	private Integer testId;
	/**
	 * This field corresponds to the database column psttest.Name
	 */
	private String name;
	/**
	 * This field corresponds to the database column psttest.Description
	 */
	private String description;
	/**
	 * This field corresponds to the database column psttest.Geography
	 */
	private Integer geography;
	/**
	 * This field corresponds to the database column psttest.Version
	 */
	private String version;
	/**
	 * This field corresponds to the database column psttest.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column psttest.ModelId
	 */
	private Integer modelId;

	/**
	 * This method returns the value of the database column psttest.TestId
	 * 
	 * @return the value of psttest.TestId
	 */
	public Integer getTestId() {
		return testId;
	}

	/**
	 * This method sets the value of the database column psttest.TestId
	 * 
	 * @param testId
	 *            the value for psttest.TestId
	 */
	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	/**
	 * This method returns the value of the database column psttest.Name
	 * 
	 * @return the value of psttest.Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the value of the database column psttest.Name
	 * 
	 * @param name
	 *            the value for psttest.Name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method returns the value of the database column psttest.Description
	 * 
	 * @return the value of psttest.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column psttest.Description
	 * 
	 * @param description
	 *            the value for psttest.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the database column psttest.Geography
	 * 
	 * @return the value of psttest.Geography
	 */
	public Integer getGeography() {
		return geography;
	}

	/**
	 * This method sets the value of the database column psttest.Geography
	 * 
	 * @param geography
	 *            the value for psttest.Geography
	 */
	public void setGeography(Integer geography) {
		this.geography = geography;
	}

	/**
	 * This method returns the value of the database column psttest.Version
	 * 
	 * @return the value of psttest.Version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the database column psttest.Version
	 * 
	 * @param version
	 *            the value for psttest.Version
	 */
	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	/**
	 * This method returns the value of the database column psttest.Active
	 * 
	 * @return the value of psttest.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column psttest.Active
	 * 
	 * @param active
	 *            the value for psttest.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column psttest.ModelId
	 * 
	 * @return the value of psttest.ModelId
	 */
	public Integer getModelId() {
		return modelId;
	}

	/**
	 * This method sets the value of the database column psttest.ModelId
	 * 
	 * @param modelId
	 *            the value for psttest.ModelId
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
}