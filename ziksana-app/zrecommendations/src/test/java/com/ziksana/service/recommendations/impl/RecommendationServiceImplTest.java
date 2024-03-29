package com.ziksana.service.recommendations.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.service.recommendations.RecommendationsService;

/**
 * Test Case
 * 
 * @author
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RecommendationServiceImplTest {

	private static final Logger logger = LoggerFactory
			.getLogger(RecommendationServiceImplTest.class);
	@Autowired
	RecommendationsService recommendationService;

	@BeforeClass
	public static void runBeforeClass() {

	}

	@AfterClass
	public static void runAfterClass() {

	}

	// check insert the Recommendations

	@Ignore
	public void createRecommendations() {

		Recommendation recomend = new Recommendation();
		recomend.setID(112);
		recomend.setCategory(1);
		recomend.setCurrentState("zik");
		recomend.setTargetState("ZIKSANAOLD");
		recomend.setDurationtoBump(1);
		recomend.setActive(3);
		recomend.setCreationDate(new Date());
		recomend.setMemberRoleId(100);
		recomend.setTitle("2. Productivity");
		recomend.setDescription("As your evaluation of descriptive..,");

		assertNotNull(recomend);

		recommendationService.addToCalendar(recomend);
		logger.info("Recommendations insert SUCCESSFUL");
	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#selectAll()}.
	 */
	@Ignore
	public void testSelectAll() {
		List<Recommendation> recommendationList = new ArrayList<Recommendation>();

		recommendationList = recommendationService.getRecommendations(1);
		//assertEquals(recommendationList.size(), 2);
		logger.info("Select All recommendation By Category");
		for (Recommendation recomend : recommendationList) {

			logger.info("recommendation Title  :" + recomend.getTitle()
					+ "Description :" + recomend.getDescription());

		}

	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#selectAll()}.
	 */
	@Ignore
	public void testgetAllRecommendationsList() {
		List<Recommendation> recommendationList = new ArrayList<Recommendation>();

		recommendationList = recommendationService.getAllRecommendationsList();
		assertEquals(recommendationList.size(), 4);
		logger.info("Select All recommendation By Category");
		for (Recommendation recomend : recommendationList) {
			logger.info("recommendation Title  :" + recomend.getTitle()
					+ "Description :" + recomend.getDescription());

		}

	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#selectAll()}.
	 */
	@Ignore
	public void testgetRecommendationsByCurrentState() {
		List<Recommendation> recommendationList = new ArrayList<Recommendation>();

		String currentStatus="NEW";
		//String currentStatus="NEW";
		//String currentStatus="NEW";
		recommendationList = recommendationService.getRecommendationsByCurrentState(currentStatus);
		//assertEquals(recommendationList.size(), 1);
		logger.info("Select All recommendation By Category");
		for (Recommendation recomend : recommendationList) {
			logger.info("recommendation Title  :" + recomend.getTitle()
					+ "Description :" + recomend.getDescription());

		}

	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#selectById(int)}
	 * .
	 * */

	@Ignore
	public void testSelectById() {
		List<Recommendation> actual = recommendationService
				.getRecommendations(1);

		List<Recommendation> expected = recommendationService
				.getRecommendations(1);

		/*
		 * assertNotNull(expected); assertEquals(actual, expected);
		 * assertNotSame(actual, expected);
		 */
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
		recommendationService.updateRecommendationsCategoryById(1, 1000,1);
		
	}

	/**
	 * Test method for
	 * {@link com.ziksana.dao.recommendations.RecommendationsDao#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void testDelete() throws Exception {

		// recommendationService.delete(1);

		// Recommendation expected =
		// recommendationService.getRecommendations(1);

		// assertNull(expected);
	}

}
