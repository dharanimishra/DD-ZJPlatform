package com.ziksana.service.recommendations;

import java.util.List;

import com.ziksana.domain.recommendations.Recommendation;

public interface RecommendationsService {

	public List<Recommendation> getRecommendations(Integer category);
	
	public List<Recommendation> getMapperRecommendation();
	
	public void updateRecommendationsCategoryById(Integer recommendationId, Integer category);
	
	public List<Recommendation> getAllRecommendations();

	public List<Recommendation> getRecommendationsByCurrentState(
			String currentState);

	public List<Recommendation> getAllRecommendationsList();

	public void addToCalendar(Recommendation recommendation);

	public void addToTodo(Recommendation recommendation);

	public void addToIgnore(Recommendation recommendation);

}
