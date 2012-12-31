/**
 * 
 */
package com.ziksana.persistence.recommendations;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.domain.todo.Todo;

/**
 * @author
 * 
 */
public interface RecommendationMapper {

	public List<Recommendation> getRecommendations(Integer category);
	
	
	public List<Recommendation> getMapperRecommendation(RowBounds rowBounds);
	
	public List<Recommendation> getAllRecommendations();
	
	public List<Recommendation> getRecommendationsByCurrentState(String currentState);
	
	public List<Recommendation> getAllRecommendationsList();

	public void addToCalendar(Recommendation recommendation);

	public void addToTodo(Recommendation recommendation);

	public void addToIgnore(Recommendation recommendation);
	
	public void updateRecommendationsCategoryById(@Param("recommendationId")Integer recommendationId , @Param("category")Integer category);
	


}
