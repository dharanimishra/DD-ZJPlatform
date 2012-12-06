/**
 * 
 */
package com.ziksana.persistence.recommendations;

import java.util.List;

import com.ziksana.domain.recommendations.Recommendation;

/**
 * @author
 * 
 */
public interface RecommendationMapper {

	public List<Recommendation> getRecommendations(Integer category);

	public void addToCalendar(Recommendation recommendation);

	public void addToTodo(Recommendation recommendation);

	public void addToIgnore(Recommendation recommendation);

}
