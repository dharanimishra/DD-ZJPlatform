/**
 * 
 */
package com.ziksana.domain.todo;

import com.ziksana.domain.member.MemberPersona;

/**
 * @author prabu
 *
 */
public class Todo {
	
	 private Integer ID;
	 private String todoText;
	 private Category category;
	 private MemberPersona creatorMember;
	 private boolean isThisCompleted;
	
	 
	 /**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	/**
	 * @return the todoText
	 */
	public String getTodoText() {
		return todoText;
	}
	/**
	 * @param todoText the todoText to set
	 */
	public void setTodoText(String todoText) {
		this.todoText = todoText;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the creatorMember
	 */
	public MemberPersona getCreatorMember() {
		return creatorMember;
	}
	/**
	 * @param creatorMember the creatorMember to set
	 */
	public void setCreatorMember(MemberPersona creatorMember) {
		this.creatorMember = creatorMember;
	}
	/**
	 * @return the isThisCompleted
	 */
	public boolean isThisCompleted() {
		return isThisCompleted;
	}
	/**
	 * @param isThisCompleted the isThisCompleted to set
	 */
	public void setThisCompleted(boolean isThisCompleted) {
		this.isThisCompleted = isThisCompleted;
	}
	 
	 
	/**
	 * 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Todo item is %s and the category is %s", todoText, category);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + (isThisCompleted ? 1231 : 1237);
		result = prime * result
				+ ((todoText == null) ? 0 : todoText.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (isThisCompleted != other.isThisCompleted)
			return false;
		if (todoText == null) {
			if (other.todoText != null)
				return false;
		} else if (!todoText.equals(other.todoText))
			return false;
		return true;
	}
	
	
	
	 
     	 
	 


}
