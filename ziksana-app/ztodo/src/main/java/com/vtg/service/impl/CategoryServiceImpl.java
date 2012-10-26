/**
 * 
 */
package com.vtg.service.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtg.dao.impl.CategoryDaoImpl;
import com.vtg.model.Category;
import com.vtg.service.CategoryService;

/**
 * @author
 * 
 */
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDaoImpl categoryDaoImpl;

	private static final Logger LOGGER = Logger
			.getLogger(CategoryServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#selectAll()
	 */
	public Collection<Category> selectAll() {
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");
		LOGGER.info("Class :" + getClass()
				+ " : Method :selectAll() :categoryDaoImpl.selectAll():"
				+ categoryDaoImpl.selectAll().isEmpty());

		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return categoryDaoImpl.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#selectById(int)
	 */
	public Category selectById(final int categoryId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int categoryId)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :selectById(int categoryId) :categoryDaoImpl.selectById(categoryId):"
				+ categoryDaoImpl.selectById(categoryId).getCategoryId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int categoryId)");
		return categoryDaoImpl.selectById(categoryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#update(com.vtg.model.Category)
	 */
	public void update(final Category category) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :update(Category category) ");
		try {
			categoryDaoImpl.update(category);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(Category category) :categoryDaoImpl.update(category):");
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(Category category) :categoryDaoImpl.update(category): Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :update(Category category) ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#delete(int)
	 */
	public void delete(final int categoryId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int categoryId)");
		try {
			categoryDaoImpl.delete(categoryId);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :delete(int categoryId) :categoryDaoImpl.delete(categoryId):"
					+ categoryId);
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :delete(int categoryId) :categoryDaoImpl.delete(categoryId):"
					+ categoryId + " Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :delete(int categoryId)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#insert(com.vtg.model.Category)
	 */
	public void insert(final Category category) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :insert(Category category)");
		try {
			categoryDaoImpl.insert(category);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(Category category) :categoryDaoImpl.insert(category);:"
					+ category.getCategoryId());
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(Category category) :categoryDaoImpl.insert(category);"
					+ category.getCategoryId() + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :insert(Category category)");
	}
}
