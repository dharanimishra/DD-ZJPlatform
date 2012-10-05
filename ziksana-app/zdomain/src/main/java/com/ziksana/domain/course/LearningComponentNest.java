package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class LearningComponentNest extends AuditHistory{
	
	public LearningComponentNest(LearningComponent learningComponentParent,
			LearningComponent learningComponentNest) {
		this.learningComponentParent = learningComponentParent;
		this.learningComponentNest = learningComponentNest;
	}

	private Integer 			componentNestId;
	private Date 				creationDate 			= null;
	private Integer 			nestLevel 				= null;
	private LearningComponent 	learningComponentParent	= null;
	private LearningComponent 	learningComponentNest 	= null;

	/**
	 * @return the value of property componentNestId
	 */
	public Integer getComponentNestId() {
		return componentNestId;
	}

	/**
	 * @param componentNestId
	 *            the value for property componentNestId
	 */
	public void setComponentNestId(Integer componentNestId) {
		this.componentNestId = componentNestId;
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
	 * @return the value of property NestLevel
	 */
	public Integer getNestLevel() {
		return nestLevel;
	}

	/**
	 * @param nestLevel
	 *            the value for property NestLevel
	 */
	public void setNestLevel(Integer nestLevel) {
		this.nestLevel = nestLevel;
	}

	/**
	 * @return the learningComponentParent
	 */
	public LearningComponent getLearningComponentParent() {
		return learningComponentParent;
	}

	/**
	 * @param learningComponentParent the learningComponentParent to set
	 */
	public void setLearningComponentParent(LearningComponent learningComponentParent) {
		this.learningComponentParent = learningComponentParent;
	}

	/**
	 * @return the learningComponentNest
	 */
	public LearningComponent getLearningComponentNest() {
		return learningComponentNest;
	}

	/**
	 * @param learningComponentNest the learningComponentNest to set
	 */
	public void setLearningComponentNest(LearningComponent learningComponentNest) {
		this.learningComponentNest = learningComponentNest;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LearningComponentNest [nestLevel=" + nestLevel
				+ ", learningComponentParent=" + learningComponentParent
				+ ", learningComponentNest=" + learningComponentNest + "]";
	}

}