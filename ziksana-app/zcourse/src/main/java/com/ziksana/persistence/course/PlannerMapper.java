/**
 * 
 */
package com.ziksana.persistence.course;

import java.util.List;

import com.ziksana.domain.course.Planner;

/**
 * @author vtg-p13
 *
 */
public interface PlannerMapper {

	public void savePlanner(Planner planner);

	public List<Planner> getPlannerByCourseId(Integer courseId);

	public int updatePlanner(Planner planner);
}
