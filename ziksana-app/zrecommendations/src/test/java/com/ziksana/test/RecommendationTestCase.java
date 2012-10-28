package com.ziksana.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.dao.recommendations.RecommendationsDao;
import com.ziksana.dao.recommendations.impl.RecommendationsDaoImpl;
import com.ziksana.domain.recommendations.Recommendation;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RecommendationTestCase {

	private static RecommendationsDao recommendationsDAO;

	@BeforeClass
	public static void runBeforeClass() {
		recommendationsDAO = new RecommendationsDaoImpl();
	}

	@AfterClass
	public static void runAfterClass() {
		recommendationsDAO = null;
	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#insert(com.vtg.model.Recommendation)}.
	 */
	@Test
	public void testInsert() {

		Recommendation actual = new Recommendation(1, "Title", "Description",
				1, "currentState", "currentState", new Date(), 1, 1, 1);
		recommendationsDAO.insert(actual);

		//assertEquals(2, 2);
		Recommendation expected = recommendationsDAO.selectById(actual.getID());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.ziksana.dao.recommendations.RecommendationsDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		Collection<Recommendation> list = recommendationsDAO.selectAll();
		assertNotNull(list);
		assertEquals(1, list.size());
	}

	/**
	 * Test method for {@link com.ziksana.dao.recommendations.RecommendationsDao#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		Recommendation actual = new Recommendation(1, "Title", "Description",
				1, "currentState", "currentState", new Date(), 1, 1, 1);
		Recommendation expected = recommendationsDAO.selectById(1);

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#update(com.vtg.model.Category)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		Recommendation actual = new Recommendation();
		Recommendation expected = recommendationsDAO.selectById(1);
		expected.setCreationDate(new Date());
		recommendationsDAO.addToTodo(expected);
		expected = recommendationsDAO.selectById(1);

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.ziksana.dao.recommendations.RecommendationsDao#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		recommendationsDAO.delete(1);

		Recommendation expected = recommendationsDAO.selectById(1);

		assertNull(expected);
	}

}
