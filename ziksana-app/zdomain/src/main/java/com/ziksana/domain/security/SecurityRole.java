package com.ziksana.domain.security;

import java.util.Date;

public class SecurityRole {

	/**
	 * This field corresponds to the database column secrole.ID
	 */
	private Integer roleId;
	/**
	 * This field corresponds to the database column secrole.CreationDate
	 * 
	 */
	private Date creationDate;
	/**
	 * This field corresponds to the database column secrole.Active
	 * 
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column secrole.RoleName
	 * 
	 */
	private String roleName;
	/**
	 * This field corresponds to the database column secrole.RoleDescription
	 * 
	 */
	private String roleDescription;

	/**
	 * This field corresponds to the database column secrole.institutionId
	 */
	private Integer institutionId;
	
	//private List<MemberRolePrivilege> memRolePrivilegeList;
	//private List<RoleACL> roleACLList;

	/**
	 * This method returns the value of the database column secrole.ID
	 * @return  the value of secrole.ID
	 * 
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method sets the value of the database column secrole.ID
	 * @param ID  the value for secrole.ID
	 * 
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method returns the value of the database column secrole.CreationDate
	 * @return  the value of secrole.CreationDate
	 * 
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column secrole.CreationDate
	 * @param creationDate  the value for secrole.CreationDate
	 * 
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column secrole.Active
	 * @return  the value of secrole.Active
	 * 
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column secrole.Active
	 * @param active  the value for secrole.Active
	 * 
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column secrole.RoleName
	 * @return  the value of secrole.RoleName
	 * 
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * This method sets the value of the database column secrole.RoleName
	 * @param roleName  the value for secrole.RoleName
	 * 
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * This method returns the value of the database column secrole.RoleDescription
	 * @return  the value of secrole.RoleDescription
	 * 
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * This method sets the value of the database column secrole.RoleDescription
	 * @param roleDescription  the value for secrole.RoleDescription
	 * 
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription == null ? null : roleDescription
				.trim();
	}

	/**
	 * @return the institutionId
	 */
	public Integer getInstitutionId() {
		return institutionId;
	}

	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}
}