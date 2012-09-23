package com.ziksana.domain.course;

import java.util.Date;

public class LearningContentParts {
	/**
	 * This field corresponds to the property contentPartsId
	 */
	private Integer contentPartsId;

	/**
	 * This field corresponds to the property CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the property PartPath<br>
	 * Maximum Length:45
	 */
	private String partPath;

	/**
	 * This field corresponds to the property partSequence
	 * Sequence of the LearningContent part
	 */
	private Integer partSequence;

	/**
	 * This field corresponds to the property learningContentId
	 */
	private Integer learningContentId;

	/**
	 * This field corresponds to the property createdBy { User who creates }
	 */
	private String createdBy;

	/**
	 * This field corresponds to the property createdOn { Creation Date)
	 */
	private Date createdOn;

	/**
	 * This field corresponds to the property createdBy {User who modified }
	 */
	private String modifiedBy;

	/**
	 * This field corresponds to the property createdBy { modified date}
	 */
	private Date modifiedOn;

	/**
	 * This method returns the value of the property contentPartsId
	 * 
	 * @return the value of property contentPartsId
	 */
	public Integer getContentPartsId() {
		return contentPartsId;
	}

	/**
	 * This method sets the value of the property contentPartsId
	 * 
	 * @param contentPartsId
	 *            the value for property contentPartsId
	 */
	public void setContentPartsId(Integer contentPartsId) {
		this.contentPartsId = contentPartsId;
	}

	/**
	 * This method returns the value of the property CreationDate
	 * 
	 * @return the value of property CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the property CreationDate
	 * 
	 * @param creationDate
	 *            the value for property CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the property PartPath
	 * 
	 * @return the value of property PartPath
	 */
	public String getPartPath() {
		return partPath;
	}

	/**
	 * This method sets the value of the property PartPath
	 * 
	 * @param partPath
	 *            the value for property PartPath
	 */
	public void setPartPath(String partPath) {
		this.partPath = partPath == null ? null : partPath.trim();
	}

	/**
	 * @return the LearningContentId
	 */
	public Integer getLearningContentId() {
		return learningContentId;
	}

	/**
	 * @param LearningContentId
	 *            the LearningContentId to set
	 */
	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = learningContentId;
	}

	/**
	 * @return the partSequence
	 */
	public Integer getPartSequence() {
		return partSequence;
	}

	/**
	 * @param partSequence
	 *            the partSequence to set
	 */
	public void setPartSequence(Integer partSequence) {
		this.partSequence = partSequence;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
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
	 * @param createdOn
	 *            the createdOn to set
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
	 * @param modifiedBy
	 *            the modifiedBy to set
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
	 * @param modifiedOn
	 *            the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}