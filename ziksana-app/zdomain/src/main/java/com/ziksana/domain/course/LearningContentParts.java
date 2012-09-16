package com.ziksana.domain.course;

import java.util.Date;

public class LearningContentParts {
	/**
	 * This field corresponds to the database column corlearningcontentparts.contentPartsId
	 */
	private Integer contentPartsId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentparts.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentparts.PartPath
	 */
	private String partPath;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentparts.partSequence
	 */
	private Integer partSequence;

	/**
	 * This field corresponds to the database column
	 * corlearningcontentparts.learningContentId
	 */
	private Integer learningContentId;

	/**
	 * This method returns the value of the database column
	 * corlearningcontentparts.contentPartsId
	 * 
	 * @return the value of corlearningcontentparts.contentPartsId
	 */
	public Integer getContentPartsId() {
		return contentPartsId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentparts.contentPartsId
	 * 
	 * @param contentPartsId
	 *            the value for corlearningcontentparts.contentPartsId
	 */
	public void setContentPartsId(Integer contentPartsId) {
		this.contentPartsId = contentPartsId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentparts.CreationDate
	 * 
	 * @return the value of corlearningcontentparts.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentparts.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corlearningcontentparts.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontentparts.PartPath
	 * 
	 * @return the value of corlearningcontentparts.PartPath
	 */
	public String getPartPath() {
		return partPath;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontentparts.PartPath
	 * 
	 * @param partPath
	 *            the value for corlearningcontentparts.PartPath
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
}