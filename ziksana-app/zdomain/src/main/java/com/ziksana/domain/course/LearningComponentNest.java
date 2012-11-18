package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;

public class LearningComponentNest extends AuditHistory{
	
	public LearningComponentNest(LearningComponent learningComponentParent,
			LearningComponent learningComponentNest) {
		this.learningComponentParent = learningComponentParent;
		this.nestLearningComponent = learningComponentNest;
	}

	private Integer		 		componentNestId;
	private Date 				creationDate 			= null;
	private Integer 			nestLevel 				= null;
	private LearningComponent 	learningComponentParent	= null;
	private LearningComponent 	nestLearningComponent 	= null;

	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LearningComponentNest [nestLevel=" + nestLevel
				+ ", learningComponentParent=" + learningComponentParent+ "]";
	}

	/**
	 * @return the nestLearningComponent
	 */
	public LearningComponent getNestLearningComponent() {
		return nestLearningComponent;
	}

	/**
	 * @param nestLearningComponent the nestLearningComponent to set
	 */
	public void setNestLearningComponent(LearningComponent nestLearningComponent) {
		this.nestLearningComponent = nestLearningComponent;
	}

	/**
	 * @return the componentNestId
	 */
	public Integer getComponentNestId() {
		return componentNestId;
	}

	/**
	 * @param componentNestId the componentNestId to set
	 */
	public void setComponentNestId(Integer componentNestId) {
		this.componentNestId = componentNestId;
	}

}