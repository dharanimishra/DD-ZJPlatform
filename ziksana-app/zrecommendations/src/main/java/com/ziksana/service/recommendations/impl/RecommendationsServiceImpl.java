package com.ziksana.service.recommendations.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.persistence.recommendations.RecommendationMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.recommendations.RecommendationsService;

/**
 * 
 * 
 */
@Service
public class RecommendationsServiceImpl implements RecommendationsService {

	private static final Logger LOGGER = LoggerFactory
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
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		recomendationList = recommendationMapper.getRecommendations(category,
				memberRoleId);
		LOGGER.info("Recommendation Size" + recomendationList.size());
		return recomendationList;

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
		recommendationMapper.addToCalendar(recommendation);
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
		recommendationMapper.addToTodo(recommendation);
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
		recommendationMapper.addToIgnore(recommendation);
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method :addToIgnore(Recommendation recommendation) ");
	}
	public List<Recommendation> getRecommendationsByCurrentState(
			String currentState) {
		List<Recommendation> recomendationList = new ArrayList<Recommendation>();
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :getRecommendationsByCurrentState(String currentState)");

		recomendationList = recommendationMapper
				.getRecommendationsByCurrentState(currentState);
		LOGGER.info("Recommendation Size" + recomendationList.size());

		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method :getRecommendationsByCurrentState(String currentState)");
		return recomendationList;
	}


	public List<Recommendation> getAllRecommendationsList() {
		List<Recommendation> recomendationList = new ArrayList<Recommendation>();
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :getAllRecommendationsList()");
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		recomendationList = recommendationMapper
				.getAllRecommendationsList(memberRoleId);
		LOGGER.info("Recommendation Size" + recomendationList.size());

		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :getAllRecommendationsList()");
		return recomendationList;
	}


	public List<Recommendation> getAllRecommendations() {
		List<Recommendation> recomendationList = new ArrayList<Recommendation>();
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");

		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		recomendationList = recommendationMapper
				.getAllRecommendations(memberRoleId);
		LOGGER.info("Recommendation Size" + recomendationList.size());
		return recomendationList;
	}


	public Integer updateRecommendationsCategoryById(Integer recommendationId,
			Integer category, Integer ignoreCount) {
		return recommendationMapper.updateRecommendationsCategoryById(
				recommendationId, category, ignoreCount);

	}


	public List<Recommendation> getMapperRecommendation() {
		int offset = 0;
		int limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		return recommendationMapper.getMapperRecommendation(memberRoleId,
				rowBounds);
	}


	public Recommendation getRecommendationByRecommendationId(
			Integer recommendationId) {
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		return recommendationMapper.getRecommendationByRecommendationId(
				recommendationId, memberRoleId);
	}
}
