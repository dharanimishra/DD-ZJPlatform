package com.ziksana.domain.assessment;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class RubricLevel extends AuditHistory {
	

	public RubricLevel(String level, String description, Boolean active) {
		super();
		this.level = level;
		this.description = description;
		this.active = active;
	}
	
	private ZID rubricLevelId;
	private String 	level 			= null;
	private String 	description 	= null;
	private Boolean active 			= null;


	/**
	 * @return the rubricLevelId
	 */
	public ZID getRubricLevelId() {
		return rubricLevelId;
	}
	/**
	 * @param rubricLevelId the rubricLevelId to set
	 */
	public void setRubricLevelId(ZID rubricLevelId) {
		this.rubricLevelId = rubricLevelId;
	}
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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
		return "RubricLevel [level=" + level + ", description=" + description
				+ ", active=" + active + "]";
	}


}
