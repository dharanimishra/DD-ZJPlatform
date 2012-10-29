/**
 * 
 */
package com.ziksana.domain.todo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * 
 */
public class TodoList implements Serializable {

	private static final long serialVersionUID = -3852524251743822969L;

	private String id;

	private String name;

	private Date lastUpdate;

	/**
	 * 
	 */
	public TodoList() {
		super();
	}

	/*
	 * @param id
	 * 
	 * @param name
	 * 
	 * @param lastUpdate
	 */
	public TodoList(String id, String name, Date lastUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("id = ").append(id).append(" - ");
		sb.append("name = ").append(name).append(" - ");
		sb.append("lastUpdate = ").append(lastUpdate).append(" - ");
		return sb.toString();
	}

	public boolean equals(Object obj) {
		final TodoList todolist = (TodoList) obj;
		if (this.id != todolist.getId()) {
			return false;
		}
		if (!this.name.equals(todolist.getName())) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + +((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;

	}
}
