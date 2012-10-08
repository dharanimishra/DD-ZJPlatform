package com.ziksana.domain.assessment;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

public class RubricCategory extends AuditHistory {
	
	public RubricCategory(String name, String description, Boolean active) {
		super();
		this.name = name;
		this.description = description;
		this.active = active;
	}

	private ZID 	rubricCategoryId;
	private String 	name 			= null;
	private String 	description 	= null;
	private Boolean active 			= null;
	
	/**
	 * @return the rubricCategoryId
	 */
	public ZID getRubricCategoryId() {
		return rubricCategoryId;
	}
	/**
	 * @param rubricCategoryId the rubricCategoryId to set
	 */
	public void setRubricCategoryId(ZID rubricCategoryId) {
		this.rubricCategoryId = rubricCategoryId;
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
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "RubricCategory [name=" + name + ", description=" + description
				+ ", active=" + active + "]";
	}

}
