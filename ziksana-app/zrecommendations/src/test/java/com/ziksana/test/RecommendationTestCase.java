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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.dao.recommendations.RecommendationsDao;
import com.ziksana.dao.recommendations.impl.RecommendationsDaoImpl;
import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.service.recommendations.RecommendationsService;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RecommendationTestCase {

	@Autowired
	RecommendationsService recommendationService;

	@BeforeClass
	public static void runBeforeClass() {

	}

	@AfterClass
	public static void runAfterClass() {

	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#insert(com.vtg.model.Recommendation)}
	 * .
	 */
	@Test
	public void testInsert() {

		Recommendation actual = new Recommendation(1, "Title", "Description",
				1, "currentState", "currentState", new Date(), 1, 1, 1);
		recommendationService.addToCalendar(actual);

		// assertEquals(2, 2);
		Recommendation expected = recommendationService.getRecommendations(1);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		Recommendation list = recommendationService.getRecommendations(1);
		assertNotNull(list);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#selectById(int)}
	 * .
	 */
	@Test
	public void testSelectById() {
		Recommendation actual = recommendationService.getRecommendations(1);

		Recommendation expected = recommendationService.getRecommendations(1);

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#update(com.vtg.model.Category)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		Recommendation actual = new Recommendation(2, "Title", "Description",
				1, "currentState", "currentState", new Date(), 1, 1, 1);
		Recommendation expected = recommendationService.getRecommendations(1);
		expected.setCreationDate(new Date());
		recommendationService.addToTodo(expected);
		expected = recommendationService.getRecommendations(1);

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		// recommendationService.delete(1);

		Recommendation expected = recommendationService.getRecommendations(1);

		assertNull(expected);
	}

}
