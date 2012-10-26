/**
 * 
 */
package com.vtg.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vtg.dao.CategoryDao;
import com.vtg.mapper.CategoryMapper;
import com.vtg.model.Category;

/**
 * @author
 * 
 */
@Component
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private CategoryMapper categoryMapper;

	private static final Logger LOGGER = Logger
			.getLogger(CategoryDaoImpl.class);

	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.CategoryDao#selectAll()
	 */
	public Collection<Category> selectAll() {
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");
		final List<Category> list = categoryMapper.selectAll();
		LOGGER.info("Class :" + getClass()
				+ " : Method :selectAll(): List Size :" + list);
		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.CategoryDao#selectById(int)
	 */
	public Category selectById(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		final Category list = categoryMapper.selectById(id);
		LOGGER.info("Class :" + getClass()
				+ " : Method :selectById(int id): List Size :" + list);
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.CategoryDao#update(com.vtg.model.Category)
	 */
	public void update(final Category category) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :update(Category category)");
		try {
			categoryMapper.update(category);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(Category category): categoryMapper.update(category);"
					+ category.getCategoryId());
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(Category category): categoryMapper.update(category);"
					+ category.getCategoryId() + " Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :update(Category category)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.CategoryDao#delete(int)
	 */
	public void delete(final int categoryId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int categoryId)");
		try {
			categoryMapper.delete(categoryId);
			LOGGER.debug("Class :" + getClass()
					+ " : Method :delete(int categoryId) : categoryId :"
					+ categoryId);
		} catch (Exception e) {
			LOGGER.debug("Class :" + getClass()
					+ " : Method :delete(int categoryId) : categoryId :"
					+ categoryId + " Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :delete(int categoryId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.CategoryDao#insert(com.vtg.model.Category)
	 */
	public void insert(final Category category) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :insert(Category category)");
		try {
			categoryMapper.insert(category);
			LOGGER.debug("Class :" + getClass()
					+ " : Method :insert(Category category) : category :"
					+ category);
		} catch (Exception e) {
			LOGGER.debug("Class :" + getClass()
					+ " : Method :insert(Category category) : category :"
					+ category + " Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :insert(Category category)");
	}

}
