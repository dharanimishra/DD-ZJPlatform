package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.id.ZID;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;

/**
 * @author bhashasp
 */
public class LearningComponentType extends AuditHistory{

	
	public LearningComponentType(){
		
	}
	
	public LearningComponentType(String compTypeName,
			String compTypeDescription, Boolean isDefineQualifier,
			Boolean active) {
		this.compTypeName = compTypeName;
		this.compTypeDescription = compTypeDescription;
		this.isDefineQualifier = isDefineQualifier;
		this.active = active;
	}

	private ZID		 		learningCompTypeId;
	private Date 			creationDate 		= null;
	
	@Deprecated
	private ComponentType 	componentType 		= null;
	
	private String 			compTypeName		= null;
	private String 			compTypeDescription = null;
	private Boolean 		isDefineQualifier	= null;
	private Boolean 		active		 		= null;
	private MemberPersona 	creatorMemberPersona= null;
	private String			definedBy			= null;

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
	 * @return the compTypeName
	 */
	public String getCompTypeName() {
		return compTypeName;
	}

	/**
	 * @param compTypeName the compTypeName to set
	 */
	public void setCompTypeName(String compTypeName) {
		this.compTypeName = compTypeName;
	}

	/**
	 * @return the compTypeDescription
	 */
	public String getCompTypeDescription() {
		return compTypeDescription;
	}

	/**
	 * @param compTypeDescription the compTypeDescription to set
	 */
	public void setCompTypeDescription(String compTypeDescription) {
		this.compTypeDescription = compTypeDescription;
	}

	/**
	 * @return the creatorMemberPersona
	 */
	public MemberPersona getCreatorMemberPersona() {
		return creatorMemberPersona;
	}

	/**
	 * @param creatorMemberPersona the creatorMemberPersona to set
	 */
	public void setCreatorMemberPersona(MemberPersona creatorMemberPersona) {
		this.creatorMemberPersona = creatorMemberPersona;
	}

	/**
	 * @return the qualifierIndicator
	 */
	public Boolean getQualifierIndicator() {
		return isDefineQualifier;
	}

	/**
	 * @param qualifierIndicator the qualifierIndicator to set
	 */
	public void setQualifierIndicator(Boolean qualifierIndicator) {
		this.isDefineQualifier = qualifierIndicator;
	}

	/**
	 * @return the definedBy
	 */
	public String getDefinedBy() {
		return definedBy;
	}

	/**
	 * @param definedBy the definedBy to set
	 */
	public void setDefinedBy(String definedBy) {
		this.definedBy = definedBy;
	}

	@Override
	public String toString() {
		return "LearningComponentType [compTypeName=" + compTypeName
				+ ", compTypeDescription=" + compTypeDescription
				+ ", qualifierIndicator=" + isDefineQualifier + ", active="
				+ active + "]";
	}



}