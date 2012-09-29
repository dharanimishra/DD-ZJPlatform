package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class LearningContentParts extends AuditHistory{
	/**
	 * This field corresponds to the property contentPartsId
	 */
	private Integer contentPartsId;

	/**
	 * This field corresponds to the property CreationDate
	 */
	private Date creationDate = null;

	/**
	 * This field corresponds to the property PartPath<br>
	 * Maximum Length:45
	 */
	private String partPath = null;

	/**
	 * This field corresponds to the property partSequence Sequence of the
	 * LearningContent part
	 */
	private Integer partSequence = null;

	/**
	 * This field corresponds to the property learningContentId
	 */
	private LearningContent learningContent = null;

	/**
	 * This method returns the value of the property contentPartsId
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
	 * @return the learningContent
	 */
	public LearningContent getLearningContent() {
		return learningContent;
	}

	/**
	 * @param learningContent the learningContent to set
	 */
	public void setLearningContent(LearningContent learningContent) {
		this.learningContent = learningContent;
	}

	@Override
	public String toString() {
		return "LearningContentParts [partPath=" + partPath + ", partSequence="
				+ partSequence + ", learningContent=" + learningContent
				+ "]";
	}

}