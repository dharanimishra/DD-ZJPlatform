package com.vtg.model;

import java.io.Serializable;

/**
 * Category POJO
 * 
 * @author
 */
public class Category implements Serializable {

	private static final long serialVersionUID = -5437165889448504534L;

	private int categoryId;
	private String categoryName;

	public Category() {
	}

	public Category(int categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;

	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("categoryId = ").append(categoryId).append(" - ");
		sb.append("categoryName = ").append(categoryName).append(" - ");
		return sb.toString();
	}

	public boolean equals(Object obj) {
		Category category = (Category) obj;
		if (this.categoryId != category.categoryId) {
			return false;
		}
		if (!this.categoryName.equals(category.getCategoryName())) {
			return false;
		}
		return true;
	}

	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (categoryId ^ (categoryId >>> 32));
		result = prime * result
				+ ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;

	}
}
