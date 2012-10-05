package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class LearningContentParts extends AuditHistory{

	private Integer 	contentPartsId;
	private Date 		creationDate 	= null;
	/**
	 * Maximum Length:45
	 */
	private String 			partPath 		= null;
	private Integer 		partSequence 	= null;
	private LearningContent learningContent = null;

	/**
	 * @return the value of property contentPartsId
	 */
	public Integer getContentPartsId() {
		return contentPartsId;
	}

	/**
	 * @param contentPartsId
	 *            the value for property contentPartsId
	 */
	public void setContentPartsId(Integer contentPartsId) {
		this.contentPartsId = contentPartsId;
	}

	/**
	 * @return the value of property CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the value for property CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the value of property PartPath
	 */
	public String getPartPath() {
		return partPath;
	}

	/**
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