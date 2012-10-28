package com.vtg.category.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.todos.Category;
import com.ziksana.service.todo.CategoryService;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryTestCase {


	@Autowired
	CategoryService categoryService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryMapper#insert(com.vtg.model.CategoryMapper)}.
	 */
	@Test
	public void testInsert() {

		Category actual = new Category(2, "category name");
		categoryService.createCategory(actual);

		assertEquals(1, actual.getCategoryId());
		Category expected = categoryService.getCategory(actual.getCategoryId());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryMapper#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		// Collection<Category> list = categoryMapper.getCategory(1);
		// assertNotNull(list);
		// assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryMapper#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		Category actual = new Category(1, "category name");
		Category expected = categoryService.getCategory(actual.getCategoryId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryMapper#update(com.vtg.model.CategoryMapper)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		Category actual = new Category(1, "category name");

		Category expected = categoryService.getCategory(actual.getCategoryId());
		expected.setCategoryName("Category description");
		categoryService.updateCategory(expected);
		expected = categoryService.getCategory(actual.getCategoryId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryMapper#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		categoryService.deleteCategory(2);
		Category expected = categoryService.getCategory(2);
		assertNull(expected);
	}

}
