package com.ziksana.service.recommendations;

import java.util.List;

import com.ziksana.domain.recommendations.Recommendation;

public interface RecommendationsService {

	public List<Recommendation> getRecommendations(Integer category);

	public List<Recommendation> getMapperRecommendation();

	public Recommendation getRecommendationByRecommendationId(
			Integer recommendationId);

	public Integer updateRecommendationsCategoryById(Integer recommendationId,
			Integer category, Integer ignoreCount);

	public List<Recommendation> getAllRecommendations();

	public List<Recommendation> getRecommendationsByCurrentState(
			String currentState);

	public List<Recommendation> getAllRecommendationsList();

	public void addToCalendar(Recommendation recommendation);

	public void addToTodo(Recommendation recommendation);

	public void addToIgnore(Recommendation recommendation);

}
