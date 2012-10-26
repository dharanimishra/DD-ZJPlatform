package com.ziksana.dao.recommendations.impl;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.dao.recommendations.RecommendationsDao;
import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.mapper.RecommendationMapper;

/**
 * @author
 * 
 */
public class RecommendationsDaoImpl implements RecommendationsDao {

	private static final Logger logger = Logger
			.getLogger(RecommendationsDaoImpl.class);

	@Autowired
	private RecommendationMapper recommendationMapper;

	public void setRecommendationMapper(
			RecommendationMapper recommendationMapper) {
		this.recommendationMapper = recommendationMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.dao.recommendations.RecommendationsDao#selectAll()
	 */
	public Collection<Recommendation> selectAll() {
		logger.info("Class :" + getClass() + " : Entering Method :selectAll()");
		List<Recommendation> list = recommendationMapper.selectAll();
		logger.info("Class :" + getClass()
				+ " : Method :selectAll(): List Size :" + list);
		logger.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.dao.recommendations.RecommendationsDao#getRecommendations
	 * (java.lang.Integer)
	 */
	public List<Recommendation> getRecommendations(Integer category) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :getRecommendations(Integer category)");
		List<Recommendation> list = recommendationMapper.selectAll();
		logger.info("Class :" + getClass()
				+ " : Method :selectAll(): List Size :" + list);
		logger.info("Class :" + getClass()
				+ " : Leaving Method :getRecommendations(Integer category)");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.dao.recommendations.RecommendationsDao#selectById(int)
	 */
	public Recommendation selectById(int id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		Recommendation list = recommendationMapper.selectById(id);
		logger.info("Class :" + getClass()
				+ " : Method :selectById(int id): List Size :" + list);
		logger.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.dao.recommendations.RecommendationsDao#addToCalendar(com.
	 * ziksana.domain.recommendations.Recommendation)
	 */
	public void addToCalendar(Recommendation recommendation) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method : addToCalendar(Recommendation recommendation)");
		try {
			recommendationMapper.insert(recommendation);
			logger.info("Class :"
					+ getClass()
					+ ":RecommendationsDaoImpl : Method :addToCalendar(Recommendation recommendation): Recommendation :"
					+ recommendation.getID());
		} catch (Exception e) {
			logger.info("Class :"
					+ getClass()
					+ ":RecommendationsDaoImpl : Method :addToCalendar(Recommendation recommendation): Recommendation :"
					+ recommendation.getID() + "Exception :" + e);
		}
		logger.info("Class :"
				+ getClass()
				+ " : Leaving Method :addToCalendar(Recommendation recommendation)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.dao.recommendations.RecommendationsDao#addToTodo(com.ziksana
	 * .domain.recommendations.Recommendation)
	 */
	public void addToTodo(Recommendation recommendation) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method : addToTodo(Recommendation recommendation)");
		try {
			recommendationMapper.insert(recommendation);
			logger.info("Class :"
					+ getClass()
					+ ":RecommendationsDaoImpl : Method :addToTodo(Recommendation recommendation): Recommendation :"
					+ recommendation.getID());
		} catch (Exception e) {
			logger.info("Class :"
					+ getClass()
					+ ":RecommendationsDaoImpl : Method :addToTodo(Recommendation recommendation): Recommendation :"
					+ recommendation.getID() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :addToTodo(Recommendation recommendation)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.dao.recommendations.RecommendationsDao#addToIgnore(com.ziksana
	 * .domain.recommendations.Recommendation)
	 */
	public void addToIgnore(Recommendation recommendation) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method :addToIgnore(Recommendation recommendation)");
		try {
			recommendationMapper.insert(recommendation);
			logger.info("Class :"
					+ getClass()
					+ ":RecommendationsDaoImpl : Method :addToIgnore(Recommendation recommendation): Recommendation :"
					+ recommendation.getID());
		} catch (Exception e) {
			logger.info("Class :"
					+ getClass()
					+ ":RecommendationsDaoImpl : Method :addToIgnore(Recommendation recommendation): Recommendation :"
					+ recommendation.getID() + "Exception :" + e);
		}
		logger.info("Class :"
				+ getClass()
				+ " : Leaving Method :addToIgnore(Recommendation recommendation)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.dao.recommendations.RecommendationsDao#insert(com.ziksana
	 * .domain.recommendations.Recommendation)
	 */
	public void insert(Recommendation recommendation) {
		logger.info("Class :" + getClass()
				+ " : Entering Method : insert(Recommendation recommendation)");
		try {
			recommendationMapper.insert(recommendation);
			logger.info("Class :"
					+ getClass()
					+ ":RecommendationsDaoImpl : Method :insert(Recommendation recommendation): Recommendation :"
					+ recommendation.getID());
		} catch (Exception e) {
			logger.info("Class :"
					+ getClass()
					+ ":RecommendationsDaoImpl : Method :insert(Recommendation recommendation): Recommendation :"
					+ recommendation.getID() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :insert(Recommendation recommendation)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.dao.recommendations.RecommendationsDao#delete(int)
	 */
	public void delete(int id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :delete(int id)");
		try {
			recommendationMapper.delete(id);
			logger.debug("Class :" + getClass()
					+ " : Method :delete(int ID) : ID :" + id);
		} catch (Exception e) {
			logger.debug("Class :" + getClass()
					+ " : Method :delete(int ID) : ID :" + id + " Exception :"
					+ e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :delete(int id)");

	}

}
