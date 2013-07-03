package com.ziksana.domain.member;

import java.util.Date;

public class MemberRolePrivilege {
	/**
	 * This field corresponds to the database column
	 * secmemberroleprivilege.memRolePrivilegeId
	 */
	private Integer memRolePrivilegeId;

	/**
	 * This field corresponds to the database column
	 * secmemberroleprivilege.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * secmemberroleprivilege.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * secmemberroleprivilege.RoleId
	 */
	private Integer roleId;

	/**
	 * This field corresponds to the database column
	 * secmemberroleprivilege.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * secmemberroleprivilege.memRolePrivilegeId
	 * 
	 * @return the value of secmemberroleprivilege.memRolePrivilegeId
	 */
	public Integer getMemRolePrivilegeId() {
		return memRolePrivilegeId;
	}

	/**
	 * This method sets the value of the database column
	 * secmemberroleprivilege.memRolePrivilegeId
	 * 
	 * @param memRolePrivilegeId
	 *            the value for secmemberroleprivilege.memRolePrivilegeId
	 */
	public void setMemRolePrivilegeId(Integer memRolePrivilegeId) {
		this.memRolePrivilegeId = memRolePrivilegeId;
	}

	/**
	 * This method returns the value of the database column
	 * secmemberroleprivilege.CreationDate
	 * 
	 * @return the value of secmemberroleprivilege.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * secmemberroleprivilege.CreationDate
	 * 
	 * @param creationDate
	 *            the value for secmemberroleprivilege.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * secmemberroleprivilege.Active
	 * 
	 * @return the value of secmemberroleprivilege.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * secmemberroleprivilege.Active
	 * 
	 * @param active
	 *            the value for secmemberroleprivilege.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * secmemberroleprivilege.RoleId
	 * 
	 * @return the value of secmemberroleprivilege.RoleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method sets the value of the database column
	 * secmemberroleprivilege.RoleId
	 * 
	 * @param roleId
	 *            the value for secmemberroleprivilege.RoleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method returns the value of the database column
	 * secmemberroleprivilege.MemberRoleId
	 * 
	 * @return the value of secmemberroleprivilege.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * secmemberroleprivilege.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for secmemberroleprivilege.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}