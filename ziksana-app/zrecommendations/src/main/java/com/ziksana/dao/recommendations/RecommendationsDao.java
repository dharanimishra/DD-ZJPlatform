package com.ziksana.dao.recommendations;

import java.util.Collection;
import java.util.List;

import com.ziksana.domain.recommendations.Recommendation;

/**
 * @author
 * 
 */
public interface RecommendationsDao {

	public Collection<Recommendation> selectAll();

	public List<Recommendation> getRecommendations(Integer category);

	public Recommendation selectById(int id);

	public void addToCalendar(Recommendation recommendation);

	public void addToTodo(Recommendation recommendation);

	public void addToIgnore(Recommendation recommendation);

	public void insert(Recommendation recommendation);

	public void delete(int ID);

}
