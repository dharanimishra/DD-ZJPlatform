package com.ziksana.domain.institution;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.contacts.RelationshipType;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class InstitutionStructure extends AuditHistory {

	public InstitutionStructure(RelationshipType relationshipType,
			String realtionshipDescription, Date startDate, Date endDate) {
		this.relationshipType = relationshipType;
		this.realtionshipDescription = realtionshipDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	private ZID 				structureId;
	private RelationshipType 	relationshipType 		= null;
	private String 				realtionshipDescription = null;
	private Date 				startDate 				= null;
	private Date 				endDate 				= null;
	
	/**
	 * @return the structureId
	 */
	public ZID getStructureId() {
		return structureId;
	}
	/**
	 * @param structureId the structureId to set
	 */
	public void setStructureId(Integer structureId) {
		this.structureId = new IntegerZID(structureId);
	}
	/**
	 * @return the relationshipType
	 */
	public RelationshipType getRelationshipType() {
		return relationshipType;
	}
	/**
	 * @param relationshipType the relationshipType to set
	 */
	public void setRelationshipType(RelationshipType relationshipType) {
		this.relationshipType = relationshipType;
	}
	/**
	 * @return the realtionshipDescription
	 */
	public String getRealtionshipDescription() {
		return realtionshipDescription;
	}
	/**
	 * @param realtionshipDescription the realtionshipDescription to set
	 */
	public void setRealtionshipDescription(String realtionshipDescription) {
		this.realtionshipDescription = realtionshipDescription;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "InstitutionStructure [relationshipType=" + relationshipType
				+ ", realtionshipDescription=" + realtionshipDescription
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
