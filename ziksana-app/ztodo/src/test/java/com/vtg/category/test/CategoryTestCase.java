package com.vtg.category.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtg.dao.CategoryDao;
import com.vtg.dao.impl.CategoryDaoImpl;
import com.vtg.model.Category;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryTestCase {

	private static CategoryDao categoryDAO;

	@BeforeClass
	public static void runBeforeClass() {
		categoryDAO = new CategoryDaoImpl();
	}

	@AfterClass
	public static void runAfterClass() {
		categoryDAO = null;
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryDao#insert(com.vtg.model.Category)}.
	 */
	@Test
	public void testInsert() {

		Category actual = new Category(1, "category name");
		categoryDAO.insert(actual);

		assertEquals(1, actual.getCategoryId());
		Category expected = categoryDAO.selectById(actual.getCategoryId());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		Collection<Category> list = categoryDAO.selectAll();
		assertNotNull(list);
		assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		Category actual = new Category();
		Category expected = categoryDAO.selectById(actual.getCategoryId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryDao#update(com.vtg.model.Category)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		Category actual = new Category();

		Category expected = categoryDAO.selectById(actual.getCategoryId());
		expected.setCategoryName("Category description");
		categoryDAO.update(expected);
		expected = categoryDAO.selectById(actual.getCategoryId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		categoryDAO.delete(1);
		Category expected = categoryDAO.selectById(1);
		assertNull(expected);
	}

}
