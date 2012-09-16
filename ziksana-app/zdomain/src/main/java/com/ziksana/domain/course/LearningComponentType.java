package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class LearningComponentType implements Serializable{
	/**
	 * srial versionid
	 */
	private static final long serialVersionUID = -2524025288224485326L;

	/**
	 * This field corresponds to the database column corlearningcomponenttype.ID
	 */
	private Integer ID;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttype.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttype.ComponentTypeName
	 */
	private String componentTypeName;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttype.ComponentTypeDescription
	 */
	private String componentTypeDescription;

	/**
	 * This field corresponds to the database column
	 * corlearningcomponenttype.Active
	 */
	private Boolean active;

	private Integer memberRoleId;

	/**
	 * . This method returns the value of the database column
	 * corlearningcomponenttype.ID
	 * 
	 * @return the value of corlearningcomponenttype.ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * . This method sets the value of the database column
	 * corlearningcomponenttype.ID
	 * 
	 * @param ID
	 *            the value for corlearningcomponenttype.ID
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}

	/**
	 * . This method returns the value of the database column
	 * corlearningcomponenttype.CreationDate
	 * 
	 * @return the value of corlearningcomponenttype.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * . This method sets the value of the database column
	 * corlearningcomponenttype.CreationDate
	 * 
	 * @param creationDate
	 *            the value for corlearningcomponenttype.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * . This method returns the value of the database column
	 * corlearningcomponenttype.ComponentTypeName
	 * 
	 * @return the value of corlearningcomponenttype.ComponentTypeName
	 */
	public String getComponentTypeName() {
		return componentTypeName;
	}

	/**
	 * . This method sets the value of the database column
	 * corlearningcomponenttype.ComponentTypeName
	 * 
	 * @param componentTypeName
	 *            the value for corlearningcomponenttype.ComponentTypeName
	 */
	public void setComponentTypeName(String componentTypeName) {
		this.componentTypeName = componentTypeName == null ? null
				: componentTypeName.trim();
	}

	/**
	 * . This method returns the value of the database column
	 * corlearningcomponenttype.ComponentTypeDescription
	 * 
	 * @return the value of corlearningcomponenttype.ComponentTypeDescription
	 */
	public String getComponentTypeDescription() {
		return componentTypeDescription;
	}

	/**
	 * . This method sets the value of the database column
	 * corlearningcomponenttype.ComponentTypeDescription
	 * 
	 * @param componentTypeDescription
	 *            the value for
	 *            corlearningcomponenttype.ComponentTypeDescription
	 */
	public void setComponentTypeDescription(String componentTypeDescription) {
		this.componentTypeDescription = componentTypeDescription == null ? null
				: componentTypeDescription.trim();
	}

	/**
	 * . This method returns the value of the database column
	 * corlearningcomponenttype.Active
	 * 
	 * @return the value of corlearningcomponenttype.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * . This method sets the value of the database column
	 * corlearningcomponenttype.Active
	 * 
	 * @param active
	 *            the value for corlearningcomponenttype.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the memberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * @param memberRoleId
	 *            the memberRoleId to set
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}