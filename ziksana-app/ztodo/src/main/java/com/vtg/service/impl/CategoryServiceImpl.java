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

	private static final Logger logger = Logger
			.getLogger(CategoryServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#selectAll()
	 */
	public Collection<Category> selectAll() {
		logger.info("Class :" + getClass() + " : Entering Method :selectAll()");
		logger.info("Class :" + getClass()
				+ " : Method :selectAll() :categoryDaoImpl.selectAll():"
				+ categoryDaoImpl.selectAll().isEmpty());

		logger.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return categoryDaoImpl.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#selectById(int)
	 */
	public Category selectById(int categoryId) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :selectById(int categoryId)");
		logger.debug("Class :"
				+ getClass()
				+ " : Method :selectById(int categoryId) :categoryDaoImpl.selectById(categoryId):"
				+ categoryDaoImpl.selectById(categoryId).getCategoryId());
		logger.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int categoryId)");
		return categoryDaoImpl.selectById(categoryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#update(com.vtg.model.Category)
	 */
	public void update(Category category) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :update(Category category) ");
		try {
			categoryDaoImpl.update(category);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :update(Category category) :categoryDaoImpl.update(category):");
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :update(Category category) :categoryDaoImpl.update(category): Exception :"
					+ e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :update(Category category) ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#delete(int)
	 */
	public void delete(int categoryId) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :delete(int categoryId)");
		try {
			categoryDaoImpl.delete(categoryId);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :delete(int categoryId) :categoryDaoImpl.delete(categoryId):"
					+ categoryId);
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :delete(int categoryId) :categoryDaoImpl.delete(categoryId):"
					+ categoryId + " Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :delete(int categoryId)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.CategoryService#insert(com.vtg.model.Category)
	 */
	public void insert(Category category) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :insert(Category category)");
		try {
			categoryDaoImpl.insert(category);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :insert(Category category) :categoryDaoImpl.insert(category);:"
					+ category.getCategoryId());
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :insert(Category category) :categoryDaoImpl.insert(category);"
					+ category.getCategoryId() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :insert(Category category)");
	}
}
