/**
 * 
 */
package com.ziksana.persistence.recommendations;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.ziksana.domain.recommendations.Recommendation;

/**
 * @author
 * 
 */
public interface RecommendationMapper {

	public List<Recommendation> getRecommendations(
			@Param("category") Integer category,
			@Param("memberRoleId") Integer memberRoleId);

	public Recommendation getRecommendationByRecommendationId(
			@Param("recommendationId") Integer recommendationId,
			@Param("memberRoleId") Integer memberRoleId);

	public List<Recommendation> getMapperRecommendation(Integer memberRoleId,
			RowBounds rowBounds);

	public List<Recommendation> getAllRecommendations(Integer memberRoleId);

	public List<Recommendation> getRecommendationsByCurrentState(
			String currentState);

	public List<Recommendation> getAllRecommendationsList(Integer memberRoleId);

	public void addToCalendar(Recommendation recommendation);

	public void addToTodo(Recommendation recommendation);

	public void addToIgnore(Recommendation recommendation);

	public int updateRecommendationsCategoryById(
			@Param("recommendationId") Integer recommendationId,
			@Param("category") Integer category,
			@Param("ignoreCount") Integer ignoreCount);

}
