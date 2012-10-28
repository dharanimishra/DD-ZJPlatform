/**
 * 
 */
package com.ziksana.service.todo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.todos.Category;
import com.ziksana.service.todo.CategoryService;
import com.ziksana.persistence.todos.CategoryMapper;

/**
 * @author
 * 
 */
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	private static final Logger LOGGER = Logger
			.getLogger(CategoryServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#selectById(int)
	 */
	public Category getCategory(final int categoryId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :getCategory(int categoryId)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :getCategory(int categoryId) :categoryMapper.getCategory(categoryId):"
				+ categoryMapper.getCategory(categoryId).getCategoryId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :getCategory(int categoryId)");
		return categoryMapper.getCategory(categoryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#update(com.vtg.model.Category)
	 */
	public void updateCategory(final Category category) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :updateCategory(Category category) ");
		try {
			categoryMapper.updateCategory(category);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :updateCategory(Category category) :categoryMapper.updateCategory(category):");
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :updateCategory(Category category) :categoryMapper.updateCategory(category): Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :updateCategory(Category category) ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#delete(int)
	 */
	public void deleteCategory(final int categoryId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :deleteCategory(int categoryId)");
		try {
			categoryMapper.deleteCategory(categoryId);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :deleteCategory(int categoryId) :categoryMapper.deleteCategory(categoryId):"
					+ categoryId);
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :deleteCategory(int categoryId) :categoryMapper.deleteCategory(categoryId):"
					+ categoryId + " Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :deleteCategory(int categoryId)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#insert(com.vtg.model.Category)
	 */
	public void createCategory(final Category category) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :createCategory(Category category)");
		try {
			categoryMapper.createCategory(category);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :createCategory(Category category) :categoryMapper.createCategory(category):"
					+ category.getCategoryId());
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :createCategory(Category category) :categoryMapper.createCategory(category): "
					+ category.getCategoryId() + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :createCategory(Category category)");
	}

}
