package com.ziksana.domain.todos;

import java.io.Serializable;
import java.util.Date;

public class MemberRole implements Serializable {

	private static final long serialVersionUID = 6328214692876418878L;

	private int id;

	private int roleType;

	private Date roleStartDate;

	private Date roleEndDate;

	private int active;

	private int doNotMarketIndicator;

	private String thumbnailPicturePath;

	/**
	 * 
	 */
	public MemberRole() {
		super();
	}

	/**
	 * @param id
	 * @param roleType
	 * @param roleStartDate
	 * @param roleEndDate
	 * @param active
	 * @param thumbnailPicturePath
	 */
	public MemberRole(int id, int roleType, Date roleStartDate,
			Date roleEndDate, int active, int doNotMarketIndicator,
			String thumbnailPicturePath) {
		super();
		this.id = id;
		this.roleType = roleType;
		this.roleStartDate = roleStartDate;
		this.roleEndDate = roleEndDate;
		this.active = active;
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public Date getRoleStartDate() {
		return roleStartDate;
	}

	public void setRoleStartDate(Date roleStartDate) {
		this.roleStartDate = roleStartDate;
	}

	public Date getRoleEndDate() {
		return roleEndDate;
	}

	public void setRoleEndDate(Date roleEndDate) {
		this.roleEndDate = roleEndDate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getDoNotMarketIndicator() {
		return doNotMarketIndicator;
	}

	public void setDoNotMarketIndicator(int doNotMarketIndicator) {
		this.doNotMarketIndicator = doNotMarketIndicator;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Id = ").append(id).append(" - ");
		sb.append("roleType = ").append(roleType).append(" - ");
		sb.append("roleStartDate = ").append(roleStartDate).append(" - ");
		sb.append("roleEndDate = ").append(roleEndDate).append(" - ");
		sb.append("active = ").append(active).append(" - ");
		sb.append("doNotMarketIndicator = ").append(doNotMarketIndicator)
				.append(" - ");
		sb.append("thumbnailPicturePath = ").append(thumbnailPicturePath)
				.append(" - ");
		return sb.toString();
	}

	public boolean equals(Object obj) {
		final MemberRole memberrole = (MemberRole) obj;
		if (this.id != memberrole.getId()) {
			return false;
		}
		if (this.roleType != memberrole.getRoleType()) {
			return false;
		}
		if (this.active != memberrole.getActive()) {
			return false;
		}
		if (!this.thumbnailPicturePath.equals(memberrole
				.getThumbnailPicturePath())) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int prime = 31;

		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (roleType ^ (roleType >>> 32));
		return result;
	}

}
