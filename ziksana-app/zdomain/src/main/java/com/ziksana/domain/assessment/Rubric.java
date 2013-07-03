package com.ziksana.domain.assessment;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class Rubric extends AuditHistory {
	

	public Rubric(String name, String description, MemberPersona createdMember) {
		this.name = name;
		this.description = description;
		this.createdMember = createdMember;
	}

	
	private ZID rubricId;
	private String name = null; 
	private String description = null;
	
	private MemberPersona createdMember = null;

	/**
	 * @return the rubricId
	 */
	public ZID getRubricId() {
		return rubricId;
	}

	/**
	 * @param rubricId the rubricId to set
	 */
	public void setRubricId(Integer rubricId) {
		this.rubricId = new IntegerZID(rubricId);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createdMember
	 */
	public MemberPersona getCreatedMember() {
		return createdMember;
	}

	/**
	 * @param createdMember the createdMember to set
	 */
	public void setCreatedMember(MemberPersona createdMember) {
		this.createdMember = createdMember;
	}

	@Override
	public String toString() {
		return "Rubric [name=" + name + ", description=" + description + "]";
	}


}
