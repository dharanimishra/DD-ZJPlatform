package com.ziksana.domain.course;

import java.util.Date;

public class InstitutionUnit {
	/**
	 * This field corresponds to the database column
	 * corinstitutionunit.institutionUnitId
	 */
	private Integer institutionUnitId;

	/**
	 * This field corresponds to the database column corinstitutionunit.UnitType
	 */
	private Integer unitType;

	/**
	 * This field corresponds to the database column
	 * corinstitutionunit.StartDate
	 */
	private Date startDate;

	/**
	 * This field corresponds to the database column corinstitutionunit.EndDate
	 */
	private Date endDate;

	/**
	 * This field corresponds to the database column
	 * corinstitutionunit.UnitDescription
	 */
	private String unitDescription;

	/**
	 * This field corresponds to the database column
	 * corinstitutionunit.ThumbnailPicturePath
	 */
	private String thumbnailPicturePath;

	/**
	 * This field corresponds to the database column
	 * corinstitutionunit.ParentInstitutionId
	 */
	private Integer parentInstitutionId;

	/**
	 * This field corresponds to the database column
	 * corinstitutionunit.InstutitionId
	 */
	private Integer instutitionId;

	/**
	 * This method returns the value of the database column
	 * corinstitutionunit.institutionUnitId
	 * 
	 * @return the value of corinstitutionunit.institutionUnitId
	 */
	public Integer getInstitutionUnitId() {
		return institutionUnitId;
	}

	/**
	 * This method sets the value of the database column
	 * corinstitutionunit.institutionUnitId
	 * 
	 * @param institutionUnitId
	 *            the value for corinstitutionunit.institutionUnitId
	 */
	public void setInstitutionUnitId(Integer institutionUnitId) {
		this.institutionUnitId = institutionUnitId;
	}

	/**
	 * This method returns the value of the database column
	 * corinstitutionunit.UnitType
	 * 
	 * @return the value of corinstitutionunit.UnitType
	 */
	public Integer getUnitType() {
		return unitType;
	}

	/**
	 * This method sets the value of the database column
	 * corinstitutionunit.UnitType
	 * 
	 * @param unitType
	 *            the value for corinstitutionunit.UnitType
	 */
	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}

	/**
	 * This method returns the value of the database column
	 * corinstitutionunit.StartDate
	 * 
	 * @return the value of corinstitutionunit.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method sets the value of the database column
	 * corinstitutionunit.StartDate
	 * 
	 * @param startDate
	 *            the value for corinstitutionunit.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method returns the value of the database column
	 * corinstitutionunit.EndDate
	 * 
	 * @return the value of corinstitutionunit.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method sets the value of the database column
	 * corinstitutionunit.EndDate
	 * 
	 * @param endDate
	 *            the value for corinstitutionunit.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method returns the value of the database column
	 * corinstitutionunit.UnitDescription
	 * 
	 * @return the value of corinstitutionunit.UnitDescription
	 */
	public String getUnitDescription() {
		return unitDescription;
	}

	/**
	 * This method sets the value of the database column
	 * corinstitutionunit.UnitDescription
	 * 
	 * @param unitDescription
	 *            the value for corinstitutionunit.UnitDescription
	 */
	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription == null ? null : unitDescription
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corinstitutionunit.ThumbnailPicturePath
	 * 
	 * @return the value of corinstitutionunit.ThumbnailPicturePath
	 */
	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	/**
	 * This method sets the value of the database column
	 * corinstitutionunit.ThumbnailPicturePath
	 * 
	 * @param thumbnailPicturePath
	 *            the value for corinstitutionunit.ThumbnailPicturePath
	 */
	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath == null ? null
				: thumbnailPicturePath.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corinstitutionunit.ParentInstitutionId
	 * 
	 * @return the value of corinstitutionunit.ParentInstitutionId
	 */
	public Integer getParentInstitutionId() {
		return parentInstitutionId;
	}

	/**
	 * This method sets the value of the database column
	 * corinstitutionunit.ParentInstitutionId
	 * 
	 * @param parentInstitutionId
	 *            the value for corinstitutionunit.ParentInstitutionId
	 */
	public void setParentInstitutionId(Integer parentInstitutionId) {
		this.parentInstitutionId = parentInstitutionId;
	}

	/**
	 * This method returns the value of the database column
	 * corinstitutionunit.InstutitionId
	 * 
	 * @return the value of corinstitutionunit.InstutitionId
	 */
	public Integer getInstutitionId() {
		return instutitionId;
	}

	/**
	 * This method sets the value of the database column
	 * corinstitutionunit.InstutitionId
	 * 
	 * @param instutitionId
	 *            the value for corinstitutionunit.InstutitionId
	 */
	public void setInstutitionId(Integer instutitionId) {
		this.instutitionId = instutitionId;
	}
}