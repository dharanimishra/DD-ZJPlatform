package com.ziksana.service.recommendations.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.dao.recommendations.impl.RecommendationsDaoImpl;
import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.service.recommendations.RecommendationsService;

/**
 * @author
 * 
 */
public class RecommendationsServiceImpl implements RecommendationsService {

	private static final Logger logger = Logger
			.getLogger(RecommendationsDaoImpl.class);

	@Autowired
	private RecommendationsDaoImpl recommendationsDaoImpl;

	public void setRecommendationsDaoImpl(
			RecommendationsDaoImpl recommendationsDaoImpl) {
		this.recommendationsDaoImpl = recommendationsDaoImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.recommendations.RecommendationsService#getRecommendations
	 * (java.lang.Integer)
	 */
	public List<Recommendation> getRecommendations(Integer category) {
		logger.info("Class :" + getClass() + " : Entering Method :selectAll()");
		logger.info("Class :" + getClass()
				+ " : Method :selectAll() :announcementDaoImpl.selectAll():"
				+ recommendationsDaoImpl.selectAll().isEmpty());

		logger.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return recommendationsDaoImpl.getRecommendations(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.recommendations.RecommendationsService#addToCalendar
	 * (com.ziksana.domain.recommendations.Recommendation)
	 */
	public void addToCalendar(Recommendation recommendation) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method :addToCalendar(Recommendation recommendation)");
		try {
			recommendationsDaoImpl.addToCalendar(recommendation);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :addToCalendar(Recommendation recommendation) :recommendationsDaoImpl.addToCalendar(recommendation):");
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :addToCalendar(Recommendation recommendation) :recommendationsDaoImpl.addToCalendar(recommendation): Exception :"
					+ e);
		}
		logger.info("Class :"
				+ getClass()
				+ " : Leaving Method : addToCalendar(Recommendation recommendation) ");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.recommendations.RecommendationsService#addToTodo(
	 * com.ziksana.domain.recommendations.Recommendation)
	 */
	public void addToTodo(Recommendation recommendation) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method :addToTodo(Recommendation recommendation) ");
		try {
			recommendationsDaoImpl.addToTodo(recommendation);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :addToTodo(Recommendation recommendation) :recommendationsDaoImpl.addToTodo(recommendation):");
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :addToTodo(Recommendation recommendation) :recommendationsDaoImpl.addToTodo(recommendation): Exception :"
					+ e);
		}
		logger.info("Class :"
				+ getClass()
				+ " : Leaving Method :addToTodo(Recommendation recommendation) ");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.recommendations.RecommendationsService#addToIgnore
	 * (com.ziksana.domain.recommendations.Recommendation)
	 */
	public void addToIgnore(Recommendation recommendation) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method :addToIgnore(Recommendation recommendation) ");
		try {
			recommendationsDaoImpl.addToIgnore(recommendation);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :addToIgnore(Recommendation recommendation) :recommendationsDaoImpl.addToIgnore(recommendation):");
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :addToIgnore(Recommendation recommendation) :recommendationsDaoImpl.addToIgnore(recommendation): Exception :"
					+ e);
		}
		logger.info("Class :"
				+ getClass()
				+ " : Leaving Method :addToIgnore(Recommendation recommendation) ");
	}
}
