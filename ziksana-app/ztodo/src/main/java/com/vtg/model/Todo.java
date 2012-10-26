/**
 * 
 */
package com.vtg.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * 
 */
public class Todo implements Serializable {

	private static final long serialVersionUID = -6468608803858408602L;

	private String id;

	private String category;

	private String description;

	private boolean complete;

	private int memberRoleId;

	private Date creationDate;

	/**
	 * 
	 */
	public Todo() {
		super();
	}

	/**
	 * @param id
	 * @param category
	 * @param description
	 * @param complete
	 * @param memberRoleId
	 * @param creationDate
	 */
	public Todo(String id, String category, String description,
			boolean complete, int memberRoleId, Date creationDate) {
		super();
		this.id = id;
		this.category = category;
		this.description = description;
		this.complete = complete;
		this.memberRoleId = memberRoleId;
		this.creationDate = creationDate;
	}

	public Todo(String id) {
		super();
		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public int getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(int memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id = ").append(id).append(" - ");
		sb.append("creationDate = ").append(creationDate).append(" - ");

		return sb.toString();
	}

	public boolean equals(Object obj) {
		Todo todo = (Todo) obj;
		if (this.id != todo.getId()) {
			return false;
		}
		if (this.description != todo.getDescription()) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;

	}
}
