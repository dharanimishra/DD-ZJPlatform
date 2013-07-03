/**
 * 
 */
package com.ziksana.domain.todo;

import com.ziksana.domain.member.MemberPersona;

/**
 * @author prabu
 *
 */
public class Category {
	
	   private Integer   categoryId;
	   private String    name;
	   private MemberPersona    creatorMember;
	
	   
	   
   /**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	   
	   
	   
	   
	   

}
