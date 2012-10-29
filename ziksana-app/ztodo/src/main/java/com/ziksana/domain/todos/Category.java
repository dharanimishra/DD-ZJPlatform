package com.ziksana.domain.todos;

import java.io.Serializable;

/**
 * Category POJO
 * 
 * @author
 */
public class Category implements Serializable {

	private static final long serialVersionUID = -5437165889448504534L;

	private Integer categoryId;
	private String categoryName;

	public Category() {
	}

	public Category(final Integer categoryId, final String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;

	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(final Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(final String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Todo item is %s and the category is %s",
				categoryId, categoryName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result
				+ ((categoryName == null) ? 0 : categoryName.hashCode());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;

		return true;
	}

}
