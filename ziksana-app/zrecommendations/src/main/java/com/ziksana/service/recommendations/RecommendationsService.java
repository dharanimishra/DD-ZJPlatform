package com.ziksana.service.recommendations;

import java.util.List;

import com.ziksana.domain.recommendations.Recommendation;

public interface RecommendationsService {

	public List<Recommendation> getRecommendations(Integer category);

	public void addToCalendar(Recommendation recommendation);

	public void addToTodo(Recommendation recommendation);

	public void addToIgnore(Recommendation recommendation);

}
