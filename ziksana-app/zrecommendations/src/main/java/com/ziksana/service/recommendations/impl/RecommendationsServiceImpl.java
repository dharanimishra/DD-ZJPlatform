package com.ziksana.service.recommendations.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.persistence.recommendations.RecommendationMapper;
import com.ziksana.service.recommendations.RecommendationsService;

/**
 * @author
 * 
 */
@Service
public class RecommendationsServiceImpl implements RecommendationsService {

	private static final Logger LOGGER = Logger
			.getLogger(RecommendationsServiceImpl.class);

	@Autowired
	private RecommendationMapper recommendationMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.recommendations.RecommendationsService#getRecommendations
	 * (java.lang.Integer)
	 */
	public List<Recommendation> getRecommendations(Integer category) {
		
		List<Recommendation> recomendationList = new ArrayList<Recommendation>();
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");
		
		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		recomendationList = recommendationMapper.getRecommendations(category);
		LOGGER.info("Recommendation Size"+recomendationList.size());
		return  recomendationList;
		
		
	}

	/*
	 * 
	 * @see
	 * com.ziksana.service.recommendations.RecommendationsService#addToCalendar
	 * (com.ziksana.domain.recommendations.Recommendation)
	 */
	public void addToCalendar(Recommendation recommendation) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :addToCalendar(Recommendation recommendation)");
		try {
			recommendationMapper.addToCalendar(recommendation);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :addToCalendar(Recommendation recommendation) :recommendationsDaoImpl.addToCalendar(recommendation):");
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :addToCalendar(Recommendation recommendation) :recommendationsDaoImpl.addToCalendar(recommendation): Exception :"
					+ e);
		}
		LOGGER.info("Class :"
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
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :addToTodo(Recommendation recommendation) ");
		try {
			recommendationMapper.addToTodo(recommendation);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :addToTodo(Recommendation recommendation) :recommendationsDaoImpl.addToTodo(recommendation):");
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :addToTodo(Recommendation recommendation) :recommendationsDaoImpl.addToTodo(recommendation): Exception :"
					+ e);
		}
		LOGGER.info("Class :"
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
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :addToIgnore(Recommendation recommendation) ");
		try {
			recommendationMapper.addToIgnore(recommendation);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :addToIgnore(Recommendation recommendation) :recommendationsDaoImpl.addToIgnore(recommendation):");
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :addToIgnore(Recommendation recommendation) :recommendationsDaoImpl.addToIgnore(recommendation): Exception :"
					+ e);
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method :addToIgnore(Recommendation recommendation) ");
	}
}
