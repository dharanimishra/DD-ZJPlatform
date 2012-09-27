package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class LearningComponentNest extends AuditHistory{
	
	public LearningComponentNest(LearningComponent learningComponentParent,
			LearningComponent learningComponentNest) {
		super();
		this.learningComponentParent = learningComponentParent;
		this.learningComponentNest = learningComponentNest;
	}

	/**
	 * This field corresponds property componentNestId
	 */
	private Integer componentNestId;

	/**
	 * This field corresponds property CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds property NestLevel
	 */
	private Integer nestLevel;

	/**
	 * This field corresponds property learningComponentParentId
	 */
	private LearningComponent learningComponentParent;

	/**
	 * This field corresponds property learningComponentNestId
	 */
	private LearningComponent learningComponentNest;

	/**
	 * This method returns the value of property componentNestId
	 * @return the value of property componentNestId
	 */
	public Integer getComponentNestId() {
		return componentNestId;
	}

	/**
	 * This method sets the value of property componentNestId
	 * @param componentNestId
	 *            the value for property componentNestId
	 */
	public void setComponentNestId(Integer componentNestId) {
		this.componentNestId = componentNestId;
	}

	/**
	 * This method returns the value of property CreationDate
	 * @return the value of property CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of property CreationDate
	 * @param creationDate
	 *            the value for property CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of property NestLevel
	 * @return the value of property NestLevel
	 */
	public Integer getNestLevel() {
		return nestLevel;
	}

	/**
	 * This method sets the value of property NestLevel
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