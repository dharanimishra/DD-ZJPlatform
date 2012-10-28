/**
 * 
 */
package com.ziksana.persistence.todos;

import com.ziksana.domain.todos.Category;

/**
 * @author
 * 
 */
public interface CategoryMapper {

	public Category getCategory(int id);

	public void updateCategory(Category Category) throws Exception;

	public void deleteCategory(int categoryId) throws Exception;

	public void createCategory(Category category);

}
