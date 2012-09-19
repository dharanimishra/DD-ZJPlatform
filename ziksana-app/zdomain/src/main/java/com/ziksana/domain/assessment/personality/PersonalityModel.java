package com.ziksana.domain.assessment.personality;

import java.math.BigDecimal;

public class PersonalityModel {

	/**
	 * This field corresponds to the database column pstmodel.ModelId
	 */
	private Integer modelId;
	/**
	 * This field corresponds to the database column pstmodel.Name
	 */
	private String name;
	/**
	 * This field corresponds to the database column pstmodel.Description
	 */
	private String description;
	/**
	 * This field corresponds to the database column pstmodel.Author
	 */
	private String author;
	/**
	 * This field corresponds to the database column pstmodel.Version
	 */
	private String version;
	/**
	 * This field corresponds to the database column pstmodel.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column pstmodel.CostPerUnit
	 */
	private BigDecimal costPerUnit;
	/**
	 * This field corresponds to the database column pstmodel.Source
	 */
	private Integer source;
	/**
	 * This field corresponds to the database column pstmodel.Currency
	 */
	private Integer currency;

	/**
	 * This method returns the value of the database column pstmodel.ModelId
	 * 
	 * @return the value of pstmodel.ModelId
	 */
	public Integer getModelId() {
		return modelId;
	}

	/**
	 * This method sets the value of the database column pstmodel.ModelId
	 * 
	 * @param modelId
	 *            the value for pstmodel.ModelId
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	/**
	 * This method returns the value of the database column pstmodel.Name
	 * 
	 * @return the value of pstmodel.Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the value of the database column pstmodel.Name
	 * 
	 * @param name
	 *            the value for pstmodel.Name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method returns the value of the database column pstmodel.Description
	 * 
	 * @return the value of pstmodel.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column pstmodel.Description
	 * 
	 * @param description
	 *            the value for pstmodel.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the database column pstmodel.Author
	 * 
	 * @return the value of pstmodel.Author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * This method sets the value of the database column pstmodel.Author
	 * 
	 * @param author
	 *            the value for pstmodel.Author
	 */
	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	/**
	 * This method returns the value of the database column pstmodel.Version
	 * 
	 * @return the value of pstmodel.Version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the database column pstmodel.Version
	 * 
	 * @param version
	 *            the value for pstmodel.Version
	 */
	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	/**
	 * This method returns the value of the database column pstmodel.Active
	 * 
	 * @return the value of pstmodel.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column pstmodel.Active
	 * 
	 * @param active
	 *            the value for pstmodel.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column pstmodel.CostPerUnit
	 * 
	 * @return the value of pstmodel.CostPerUnit
	 */
	public BigDecimal getCostPerUnit() {
		return costPerUnit;
	}

	/**
	 * This method sets the value of the database column pstmodel.CostPerUnit
	 * 
	 * @param costPerUnit
	 *            the value for pstmodel.CostPerUnit
	 */
	public void setCostPerUnit(BigDecimal costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	/**
	 * This method returns the value of the database column pstmodel.Source
	 * 
	 * @return the value of pstmodel.Source
	 */
	public Integer getSource() {
		return source;
	}

	/**
	 * This method sets the value of the database column pstmodel.Source
	 * 
	 * @param source
	 *            the value for pstmodel.Source
	 */
	public void setSource(Integer source) {
		this.source = source;
	}

	/**
	 * This method returns the value of the database column pstmodel.Currency
	 * 
	 * @return the value of pstmodel.Currency
	 */
	public Integer getCurrency() {
		return currency;
	}

	/**
	 * This method sets the value of the database column pstmodel.Currency
	 * 
	 * @param currency
	 *            the value for pstmodel.Currency
	 */
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
}