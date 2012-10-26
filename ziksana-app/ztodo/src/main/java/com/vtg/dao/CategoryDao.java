/**
 * 
 */
package com.vtg.dao;

import java.util.Collection;

import com.vtg.model.Category;

/**
 * @author
 * 
 */
public interface CategoryDao {

	public Collection<Category> selectAll();

	public Category selectById(int id);

	public void update(Category Category) throws Exception;

	public void delete(int categoryId) throws Exception;

	public void insert(Category category);

}
