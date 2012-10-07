package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.common.id.ZID;
import com.ziksana.domain.member.MemberPersona;

public class LearningComponentType {

	public LearningComponentType(ComponentType componentType){
		this.componentType = componentType;
	}
	
	private ZID		 		learningCompTypeId;
	private Date 			creationDate 		= null;
	private ComponentType 	componentType 		= null;
	private Boolean 		active		 		= null;
	private MemberPersona 	creatingMember 		= null;

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
	 * @return the value of property Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the value for property Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the learningCompTypeId
	 */
	public ZID getLearningCompTypeId() {
		return learningCompTypeId;
	}

	/**
	 * @param learningCompTypeId
	 *            the learningCompTypeId to set
	 */
	public void setLearningCompTypeId(ZID learningCompTypeId) {
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