package com.ziksana.domain.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Legacy History details
 * 
 * @author bhashasp
 */
public class AuditHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This field corresponds to the property createdBy { User who creates }
	 */
	private String createdBy;

	/**
	 * This field corresponds to the property createdOn { Creation Date)
	 */
	private Date createdOn;

	/**
	 * This field corresponds to the property createdBy {User who modified }
	 */
	private String modifiedBy;

	/**
	 * This field corresponds to the property createdBy { modified date}
	 */
	private Date modifiedOn;

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


}
