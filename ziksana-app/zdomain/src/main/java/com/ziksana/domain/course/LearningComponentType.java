package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.member.MemberPersona;

public class LearningComponentType {

	public LearningComponentType(ComponentType componentType){
		this.componentType = componentType;
		
	}
	/**
	 * This field corresponds to the property learningCompTypeId
	 */
	private Integer learningCompTypeId;

	/**
	 * This field corresponds to the property CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the property ComponentTypeName
	 */
	private ComponentType componentType;

	/**
	 * This field corresponds to the property Active
	 */
	private Boolean active;

	private MemberPersona creatingMember;

	/**
	 * . This method returns the value of the property CreationDate
	 * 
	 * @return the value of property CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 *This method sets the value of the property CreationDate
	 * @param creationDate
	 *            the value for property CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	/**
	 *This method returns the value of the property Active
	 * @return the value of property Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 *This method sets the value of the property Active
	 * @param active
	 *            the value for property Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the learningCompTypeId
	 */
	public Integer getLearningCompTypeId() {
		return learningCompTypeId;
	}

	/**
	 * @param learningCompTypeId
	 *            the learningCompTypeId to set
	 */
	public void setLearningCompTypeId(Integer learningCompTypeId) {
		this.learningCompTypeId = learningCompTypeId;
	}

	/**
	 * @return the componentTypeName
	 */
	public ComponentType getComponentType() {
		return componentType;
	}

	/**
	 * @param componentTypeName the componentTypeName to set
	 */
	public void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}

	/**
	 * @return the creatingMember
	 */
	public MemberPersona getCreatingMember() {
		return creatingMember;
	}

	/**
	 * @param creatingMember the creatingMember to set
	 */
	public void setCreatingMember(MemberPersona creatingMember) {
		this.creatingMember = creatingMember;
	}


}